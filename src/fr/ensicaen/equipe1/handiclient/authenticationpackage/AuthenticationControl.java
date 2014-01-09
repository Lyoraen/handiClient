package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import android.view.MotionEvent;
import fr.ensicaen.equipe1.handiclient.controlpackage.IControl;
import fr.ensicaen.equipe1.handiclient.controlpackage.MultiTouchControl;

public class AuthenticationControl implements IControl {

	private AuthenticationActivity _authenticationActivity;
	private IControl _control;

	public AuthenticationControl(AuthenticationActivity authenticationActivity,String controlType) {
		_authenticationActivity = authenticationActivity;

		if(controlType.equals("MULTITOUCH_MODE")) {
			_control = new MultiTouchControl(this);
		}
	}
	
	@Override
	public void useButton(int i) {
		_authenticationActivity.getModel().addNumberToPin(i);
	}

	@Override
	public void useButtonCancel() {
		boolean cancelled = _authenticationActivity.getModel().cancelEntry();
		//TODO if (cancelled == true) _activity.intentToGoodByeActivity();
	}

	@Override
	public void useButtonValidate() {
		_authenticationActivity.getModel().verifyPIN();
	}
	
	@Override
	public void reactDependingOnUserActions(MotionEvent motionEvent) {
		_control.reactDependingOnUserActions(motionEvent);
	}
}
