package fr.ensicaen.equipe1.handiclient.adminpackage;

import java.math.BigInteger;
import java.util.Locale;

import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.homepackage.HomeActivity;
import fr.ensicaen.equipe1.handiclient.networkpackage.NetworkHandler;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.os.Bundle;
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
	private NetworkHandler _networkHandler;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin);

		mAdapter = NfcAdapter.getDefaultAdapter(getApplicationContext());
		if (mAdapter == null || !mAdapter.isEnabled()) {
			finish();
			return;
		}

		_nameField = (EditText) findViewById(R.id.nameField2);
		_pinField = (EditText) findViewById(R.id.pinField3);
		_soldeField = (EditText) findViewById(R.id.soldeField3);
		
		_networkHandler = new NetworkHandler();

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
		if(!_nameField.getText().toString().equals("") && !_soldeField.getText().toString().equals("") && !_pinField.getText().toString().equals("")) {
			// tag uid reading
			Tag tagFromIntent = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
			String uid = bin2hex(tagFromIntent.getId());

			// tag writting
			_stringToTag = _pinField.getText() + "*MULTITOUCH_MODE*AUDIO_MODE";
			NdefMessage msg = creerMessage(_stringToTag, true);
			writeMessage(intent, msg);
			
			// Datanase writting
			_networkHandler.addUser(uid, _nameField.getText().toString(),  Integer.parseInt(_soldeField.getText().toString()));

			//back to the home activity
			Intent homeIntent = new Intent(getApplicationContext(), HomeActivity.class);
			startActivity(homeIntent);
			finish();
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

	//To display the UID
	static String bin2hex(byte[] data) {
		return String.format("%0" + (data.length * 2) + "X", new BigInteger(1,data));
	}
}