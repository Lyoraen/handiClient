package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import fr.ensicaen.equipe1.handiclient.controlpackage.IControl;

public class AuthenticationControl implements IControl {

	private AuthenticationActivity _authenticationActivity;

	public AuthenticationControl(AuthenticationActivity authenticationActivity) {
		_authenticationActivity = authenticationActivity;
	}
}
