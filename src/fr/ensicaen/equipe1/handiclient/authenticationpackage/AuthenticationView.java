package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import fr.ensicaen.equipe1.handiclient.viewpackage.IView;

public class AuthenticationView {

	private AuthenticationActivity _authenticationActivity;
	private IView _view;

	public AuthenticationView(AuthenticationActivity authenticationActivity,
			int viewType) {
		_authenticationActivity = authenticationActivity;
		switch (viewType) {
		case 1:
			_view = new AudioView(_authenticationActivity, _authenticationActivity.findViewById(id));
			break;
		default:
			break;
		}
	}

}
