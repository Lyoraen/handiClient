package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import fr.ensicaen.equipe1.handiclient.controlpackage.IControl;

public class AuthenticationControl {

	private AuthenticationActivity _authenticationActivity;
	private IControl _control;

	public AuthenticationControl(AuthenticationActivity authenticationActivity) {
		_authenticationActivity = authenticationActivity;
	}
}
