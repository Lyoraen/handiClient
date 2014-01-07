package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.IModel;

public class AuthenticationModel implements IModel {

	private AuthenticationActivity _authenticationActivity;

	public AuthenticationModel(AuthenticationActivity authenticationActivity) {
		_authenticationActivity = authenticationActivity;
	}

}
