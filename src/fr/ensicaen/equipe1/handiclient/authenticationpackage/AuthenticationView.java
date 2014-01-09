package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import android.widget.Button;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.viewpackage.AudioView;
import fr.ensicaen.equipe1.handiclient.viewpackage.IView;

public class AuthenticationView {

	private AuthenticationActivity _authenticationActivity;
	private IView _view;

	public AuthenticationView(AuthenticationActivity authenticationActivity,String viewType) {
		_authenticationActivity = authenticationActivity;
		if(viewType.equals("AUDIO_MODE")) {
			_view = new AudioView(_authenticationActivity,R.id.layoutAuthentication);
		}
		/*
		else {
			break;
		}
		*/
	}

	public void describe() {
		_view.describe();
	}

	public void reactOnAction(Button button) {
		_view.reactOnAction(button);
	}

}
