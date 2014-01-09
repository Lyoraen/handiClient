package fr.ensicaen.equipe1.handiclient.adminpackage;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import android.annotation.TargetApi;
import android.nfc.NdefRecord;
import android.os.Build;
import android.util.Base64;
import android.util.Log;

public class TextRecord {

	private String _languageCode;
	private static String _text;
	private static String _secret = "nxpppppppppppppp"; // secret sur 16 octets

	public TextRecord() {
		_languageCode = "";
		_text = "";
	}

	public TextRecord(String languageCode, String text) {
		_languageCode = languageCode;
		_text = text;
	}
	
	public void setKey(String newKey) {
		_secret = newKey;
	}

	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public static TextRecord parse(NdefRecord record) {
		TextRecord txtRecord = null;
		try {
			// décodage d'un payload de type texte
			byte[] payload = record.getPayload();
			String textEncoding = ((payload[0] & 0200) == 0) ? "UTF-8" : "UTF-16";
			int languageCodeLength = payload[0] & 0077;
			String languageCode = new String(payload, 1, languageCodeLength, "US-ASCII");
			String text = new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
			
			//déchiffrement du texte chiffré sur le tag.
			txtRecord = new TextRecord(languageCode, decrypt(text));
		} catch (UnsupportedEncodingException e) {
			txtRecord = null;
		}
		return txtRecord;
	}

	public static byte[] concat(byte[] b1, byte[] b2) {
		byte[] data = new byte[b1.length + b2.length];
		int i = 0;
		for (byte b: b1) {
			data[i] = b;
			i++;
		}
		for (byte b: b2) {
			data[i] = b;
			i++;
		}
		return data;
	}

	public static byte[] concat(byte b1, byte[] b2) {
		byte[] data = new byte[b2.length + 1];
		int i = 1;
		data[0] = b1;
		for (byte b: b2) {
			data[i] = b;
			i++;
		}
		return data;
	}

	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	public static NdefRecord createTextRecord(String text, Locale locale, boolean encodeInUtf8) {
		byte[] langBytes = locale.getLanguage().getBytes(Charset.forName("US-ASCII"));
		int utfBit = encodeInUtf8 ? 0 : (1 << 7);
		char status = (char) (utfBit + langBytes.length);
		byte[] data = concat((byte)status, concat(langBytes, encrypt(text)));
		return new NdefRecord(NdefRecord.TNF_WELL_KNOWN, NdefRecord.RTD_TEXT, new byte[0], data);
	}

	public String getContent() {
		// TODO Auto-generated method stub
		return _text;
	}

	public static String decrypt(String textToDecrypt) {
		try {
			byte[] decodedValue = Base64.decode(textToDecrypt.getBytes(), 0);

			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ips = new IvParameterSpec(iv);

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

			// generated decryption key
			SecretKeySpec secretKey = new SecretKeySpec(_secret.getBytes("UTF-8"), "AES");
			
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ips);
			byte[] plainText = cipher.doFinal(decodedValue);
			return new String(plainText);
		} catch (Exception e) {
			e.printStackTrace();
			Log.e(_text, "Decipher error for " + textToDecrypt, e);
		}

		return "";
	}

	public static byte[] encrypt(String textToEncrypt) {
		try {
			byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
			IvParameterSpec ips = new IvParameterSpec(iv);

			// we generate an AES SecretKeySpec object which contains the secret key.
			SecretKeySpec secretKey = new SecretKeySpec(_secret.getBytes("UTF-8"), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ips);

			byte[] cipherText = cipher.doFinal(textToEncrypt.getBytes());
			byte[] base64encodedSecretData = Base64.encode(cipherText, 0);
			return base64encodedSecretData;
		} catch (Exception e) {
			e.printStackTrace();
			Log.e(_text, "Encryption error for " + textToEncrypt, e);
		}
		return "".getBytes();
	}
}