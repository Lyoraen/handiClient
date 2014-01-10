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
		boolean added = _authenticationActivity.getModel().addNumberToPin(i);
		_authenticationActivity.getView().reactOnSecretNumberButtons((Button) _authenticationActivity.findViewById(_authenticationActivity.getResources().getIdentifier("authenticationbutton"+i, "id", _authenticationActivity.getPackageName())));
		if(added == false)
			_authenticationActivity.getView().tooMuchEntries();
	}

	@Override
	public void useButtonCancel() {
		boolean cancelled = _authenticationActivity.getModel().cancelEntry();
		_authenticationActivity.getView().reactOnCancelButton((Button) _authenticationActivity.findViewById(_authenticationActivity.getResources().getIdentifier("authenticationbuttoncancel", "id", _authenticationActivity.getPackageName())));
		if (cancelled == false) {
			_authenticationActivity.intentToGoodByeActivity();
		}
	}

	@Override
	public void useButtonValidate() {
		_authenticationActivity.getView().reactOnValidateButton((Button) _authenticationActivity.findViewById(_authenticationActivity.getResources().getIdentifier("authenticationbuttonvalidate", "id", _authenticationActivity.getPackageName())));
		if(_authenticationActivity.getModel().verifyPIN()) {
			_authenticationActivity.intentToMenuActivity();
		}
	}
	
	@Override
	public void reactDependingOnUserActions(MotionEvent motionEvent) {
		_control.reactDependingOnUserActions(motionEvent);
	}
}
