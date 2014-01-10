package fr.ensicaen.equipe1.handiclient.goodbyepackage;

import android.widget.Button;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.goodbyepackage.GoodByeActivity;
import fr.ensicaen.equipe1.handiclient.viewpackage.AudioView;
import fr.ensicaen.equipe1.handiclient.viewpackage.IView;

public class GoodByeView implements IView{
	private GoodByeActivity _goodByeActivity;
	private IView _view;

	public GoodByeView(GoodByeActivity goodByeActivity, String viewType) {
		_goodByeActivity = goodByeActivity;
		if(viewType.equals("AUDIO_MODE")) {
			_view = new AudioView(_goodByeActivity,R.id.layoutGoodbye);
		}
		/*
		else {
			break;
		}
		*/
	}

	@Override
	public void describe() {
		_view.describe();
		
	}

	@Override
	public void describe(String speech) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactOnNumberButtons(Button button) {
		// TODO Auto-generated method stub
		
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
	public void destroyTTS() {
		// TODO Auto-generated method stub
		
	}

	public void describeActivity() {
		_view.describe(_goodByeActivity.getModel().getActivityDescription());
		
	}

	@Override
	public void reactOnSecretNumberButtons(Button button) {
		// TODO Auto-generated method stub
		
	}

}
