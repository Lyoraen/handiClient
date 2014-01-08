package fr.ensicaen.equipe1.handiclient.viewpackage;

import java.util.Locale;

import android.R;
import android.app.Activity;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.Button;

public class AudioView implements IView, TextToSpeech.OnInitListener{
	private TextToSpeech _tts;
	private Activity _activity;
	
	public AudioView(Activity activity){
		_activity = activity;
		_tts = new TextToSpeech(_activity, this);
	}

	public void readActivityDescription(){
		
	}
	
	private void readButtonDescription(Button button){
	
		String text = button.getContentDescription().toString();
		_tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
	}
	
	public void blinkButton(Button button){
		
	}

	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			int result = _tts.setLanguage(Locale.FRENCH);
			if (result == TextToSpeech.LANG_MISSING_DATA
					|| result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "This Language is not supported");
//			} else {
//				bouton1.setEnabled(false);
//				bouton2.setEnabled(false);
//				bouton3.setEnabled(false);
				
//				 new Thread(new Runnable() {
//				        public void run() {
//				           speakOut(bouton1);
//				           try {
//							Thread.sleep(3000);
//							speakOut(bouton2);
//							
//							Thread.sleep(3000);
//							speakOut(bouton3);
//							
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//				        }
//				    }).start();
//			}

		} else {
			Log.e("TTS", "Initilization Failed!");
		}
		
	}
	
	
	}}
