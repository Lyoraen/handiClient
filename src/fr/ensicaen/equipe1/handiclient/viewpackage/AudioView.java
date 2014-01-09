package fr.ensicaen.equipe1.handiclient.viewpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import fr.ensicaen.equipe1.handiclient.R;

import android.app.Activity;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.TextView;

public class AudioView implements IView, TextToSpeech.OnInitListener {
	private TextToSpeech _tts;
	private Activity _activity;
	private int _layoutID;
	private boolean hasInitializedTTS = false;
	private ArrayList<String> awaitingSpeeches = new ArrayList<String>();

	public AudioView(Activity activity, int layoutID) {
		_activity = activity;
		_layoutID = layoutID;
		_tts = new TextToSpeech(_activity, this);
	}

	@Override
	public void describe() {
		new Thread(new Runnable() {
			public void run() {
				ViewGroup layout = (ViewGroup) _activity
						.findViewById(_layoutID);
				for (int i = 0; i < layout.getChildCount(); i++) {
					View v = layout.getChildAt(i);
					if (v.getClass() == Button.class
							|| v.getClass() == TextView.class) {
						readDescription((TextView) v);
					}
				}
			}
		}).start();
	}

	private void readDescription(View v) {
		String text = v.getContentDescription().toString();
		if (hasInitializedTTS) {
			_tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
			try {
				Thread.sleep(2500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			awaitingSpeeches.add(text);
		}
	}

	@Override
	public void reactOnNumberButtons(Button button) {
		/* Animation */
		Animation animation = new ScaleAnimation(1, 0.8f, 1, 0.8f,
				Animation.RELATIVE_TO_SELF, 0.5f, 
				Animation.RELATIVE_TO_SELF, 0.5f);
		animation.setDuration(200);
		animation.setInterpolator(new AccelerateInterpolator());
		animation.setRepeatCount(1);
		animation.setRepeatMode(Animation.REVERSE);
		button.startAnimation(animation);
		
		/* Sound */
		ToneGenerator toneG = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
		toneG.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 200); 
	}
	
	@Override
	public void reactOnCancelButton(Button button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactOnValidateButton(Button button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			int resultLocalization = _tts.setLanguage(Locale.FRENCH);
			if (resultLocalization == TextToSpeech.LANG_MISSING_DATA
					|| resultLocalization == TextToSpeech.LANG_NOT_SUPPORTED) {
				Log.e("TTS", "This Language is not supported");
			} else {
				Log.e("TTS", "Initilization Failed!");
			}
		}
		hasInitializedTTS = true;
		if (!awaitingSpeeches.isEmpty()) {
			Iterator<String> it = awaitingSpeeches.iterator();
			while (it.hasNext()) {
				_tts.speak(it.next(), TextToSpeech.QUEUE_FLUSH, null);
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void describeActivity(final String speech) {
		new Thread(new Runnable() {
			public void run() {
				if (hasInitializedTTS) {
					_tts.speak(speech, TextToSpeech.QUEUE_FLUSH, null);
					try {
						Thread.sleep(2500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				} else {
					awaitingSpeeches.add(speech);
				}
			}
		}).start();
	}
}
