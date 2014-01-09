package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import android.view.MotionEvent;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.controlpackage.IControl;
import fr.ensicaen.equipe1.handiclient.controlpackage.MultiTouchControl;
import fr.ensicaen.equipe1.handiclient.viewpackage.AudioView;

public class AuthenticationControl {

	private AuthenticationActivity _authenticationActivity;
	private IControl _control;

	public void AuthenticationControl(AuthenticationActivity authenticationActivity,String controlType) {
		_authenticationActivity = authenticationActivity;

		if(controlType.equals("MULTITOUCH_MODE")) {
			_control = new MultiTouchControl();
		}
	}
	
	public void reactDependingOnUserActions(MotionEvent motionEvent) {
		_control.reactDependingOnUserActions(motionEvent);
	}
}
