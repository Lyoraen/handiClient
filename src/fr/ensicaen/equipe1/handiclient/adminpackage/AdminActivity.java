package fr.ensicaen.equipe1.handiclient.adminpackage;

import java.util.Locale;

import fr.ensicaen.equipe1.handiclient.R;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;

public class AdminActivity extends Activity {

	private String _stringToTag=null;
	private NfcAdapter mAdapter;
	private EditText _pinField;
	private EditText _nameField;
	private EditText _soldeField;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);

		mAdapter = NfcAdapter.getDefaultAdapter(getApplicationContext());
		if (mAdapter == null || !mAdapter.isEnabled()) {
			finish();
			return;
		}
		
		_nameField = (EditText) findViewById(R.id.nomfield);
		_pinField = (EditText) findViewById(R.id.pinField);
		_soldeField = (EditText) findViewById(R.id.soldefield);
		
	}

	@Override
	public void onResume(){
		super.onResume();
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, new Intent(this,this.getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
		mAdapter.enableForegroundDispatch(this, pendingIntent, null, null);
	}

	@Override
	public void onNewIntent(Intent intent) {
		setIntent(intent);
		if(!_nameField.getText().equals("") && !_soldeField.getText().equals("") && !_pinField.getText().equals("")) {
			_stringToTag = _pinField.getText() + "*MULTITOUCH_MODE*AUDIO_MODE";
			//_stringToTag = "1234*MULTITOUCH_MODE*AUDIO_MODE";
			NdefMessage msg = creerMessage(_stringToTag, true);
			writeMessage(intent, msg);
		}
	}

	private void writeMessage(Intent intent, NdefMessage msg) {
		Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
		Ndef ndef = Ndef.get(tag);
		try {
			ndef.connect();
			ndef.writeNdefMessage(msg);
			//ndef.makeReadOnly();
			ndef.close();
		} catch (Exception e) {
		}
	}

	private NdefMessage creerMessage(String text, boolean encodeInUtf8) {
		NdefRecord[] records = new NdefRecord[1];
		records[0] = TextRecord.createTextRecord(text, Locale.ENGLISH, encodeInUtf8);
		return new NdefMessage(records);
	}

}