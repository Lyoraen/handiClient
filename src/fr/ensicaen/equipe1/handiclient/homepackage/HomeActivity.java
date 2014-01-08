package fr.ensicaen.equipe1.handiclient.homepackage;

import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.R.layout;
import fr.ensicaen.equipe1.handiclient.R.menu;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;

@TargetApi(Build.VERSION_CODES.GINGERBREAD_MR1)
public class HomeActivity extends Activity {

	private NfcAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	public void onResume() {
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this, this.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
		mAdapter.enableForegroundDispatch(this, pendingIntent, null, null);
	}

	public void onNewIntent(Intent intent) {
		resoudreIntent(intent);
	}

	public void resoudreIntent(Intent intent) {
		String action = intent.getAction();
		byte[] id = null;
		if (NfcAdapter.ACTION_TAG_DISCOVERED.equals(action)){
			Parcelable[] rawMsgs = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
			NdefMessage[] messages;
			if (rawMsgs != null) {
				messages = new NdefMessage[rawMsgs.length];
				for (int i = 0; i < rawMsgs.length; i++) {
					messages[i] = (NdefMessage) rawMsgs[i];
					id = messages[i].getRecords()[i].getId();
				}
			}
		}
		System.out.println(id);
	}
}