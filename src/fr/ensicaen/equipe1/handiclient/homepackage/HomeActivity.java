package fr.ensicaen.equipe1.handiclient.homepackage;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.StringTokenizer;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.authenticationpackage.AuthenticationActivity;

@TargetApi(Build.VERSION_CODES.GINGERBREAD_MR1)
public class HomeActivity extends Activity {

	private NfcAdapter mAdapter;
	private HomeControl _homeControl;
	private HomeModel _homeModel;
	private HomeView _homeView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		_homeModel = new HomeModel(this);
		_homeControl = new HomeControl(this);
		_homeView = new HomeView(this);


		setContentView(R.layout.activity_home);
		mAdapter = NfcAdapter.getDefaultAdapter(getApplicationContext());
		if(mAdapter==null || !mAdapter.isEnabled()){
			finish();
			return;
		}
	}

	protected void onResume() {
		super.onResume();
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, this.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
		mAdapter.enableForegroundDispatch(this, pendingIntent, null, null);
	}

	public void onNewIntent(Intent intent) {
		setIntent(intent);
		resolveIntent(intent);
		Intent nextIntent = new Intent(getApplicationContext(), AuthenticationActivity.class);
		this.startActivity(nextIntent);
	}

	protected void onPause() {
		mAdapter.disableForegroundDispatch(this);
		super.onPause();
	}


	public void resolveIntent(Intent intent) {
		Tag tagFromIntent = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);

		// getting the tag id
		String uid = bin2hex(tagFromIntent.getId());

		String action = intent.getAction();
		if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)){
			Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
			NdefMessage[] messages;
			if (rawMsgs != null) {
				messages = new NdefMessage[rawMsgs.length];
				for (int i = 0; i < rawMsgs.length; i++) {
					messages[i] = (NdefMessage) rawMsgs[i];
				}
				NdefRecord record = messages[0].getRecords()[0];
				try {
					// decoding the payload
					byte[] payload = record.getPayload();
					String textEncoding = ((payload[0] & 0200) == 0) ? "UTF-8" : "UTF-16";
					int languageCodeLength = payload[0] & 0077;
					//String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");
					String data = new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
					StringTokenizer st = new StringTokenizer(data,"*");
					System.out.println(data);
					/*System.out.println(st.nextToken());
					System.out.println(st.nextToken());
					System.out.println(st.nextToken());*/
					_homeModel.setCardData(uid, st.nextToken(), st.nextToken(), st.nextToken());
				} catch (Exception e){
					e.printStackTrace();
				}
			}
		}
	}

	//To display the UID
	static String bin2hex(byte[] data) {
		return String.format("%0" + (data.length * 2) + "X", new BigInteger(1,data));
	}
}
