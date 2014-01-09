package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import android.view.MotionEvent;
import android.widget.Button;
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
		_authenticationActivity.getView().reactOnNumberButtons((Button) _authenticationActivity.findViewById(_authenticationActivity.getResources().getIdentifier("authenticationbutton"+i, "id", _authenticationActivity.getPackageName())));
	}

	@Override
	public void useButtonCancel() {
		boolean cancelled = _authenticationActivity.getModel().cancelEntry();
		_authenticationActivity.getView().reactOnCancelButton((Button) _authenticationActivity.findViewById(_authenticationActivity.getResources().getIdentifier("authenticationbuttoncancel", "id", _authenticationActivity.getPackageName())));
		//TODO if (cancelled == true) _activity.intentToGoodByeActivity();
		if (cancelled == false) {
			_authenticationActivity.intentToGoodByeActivity();
		}
	}

	@Override
	public void useButtonValidate() {
		_authenticationActivity.getModel().verifyPIN();
		_authenticationActivity.getView().reactOnValidateButton((Button) _authenticationActivity.findViewById(_authenticationActivity.getResources().getIdentifier("authenticationbuttonvalidate", "id", _authenticationActivity.getPackageName())));

	}
	
	@Override
	public void reactDependingOnUserActions(MotionEvent motionEvent) {
		_control.reactDependingOnUserActions(motionEvent);
	}
}
