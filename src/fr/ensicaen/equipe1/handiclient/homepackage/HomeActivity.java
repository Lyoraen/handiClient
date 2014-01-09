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
import android.view.View;
import android.widget.Button;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.adminpackage.AdminActivity;
import fr.ensicaen.equipe1.handiclient.authenticationpackage.AuthenticationActivity;
import fr.ensicaen.equipe1.handiclient.withdrawmoneypackage.WithdrawMoneyActivity;

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
		
		final Button button = (Button) findViewById(R.id.adminButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent AdminIntent = new Intent(getApplicationContext(), AdminActivity.class);
        		startActivity(AdminIntent);
        		finish();
            }
        });
		
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
		finish();
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
					TextRecord textRecord = TextRecord.parse(record);
					String data = textRecord.getContent();
					//System.out.println(data);
	
					StringTokenizer st = new StringTokenizer(data,"*");

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
