package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class AuthenticationModel {

	private AuthenticationActivity _authenticationActivity;
	private MainModel _mainModel = MainModel.getInstance();

	public AuthenticationModel(AuthenticationActivity authenticationActivity) {
		_authenticationActivity = authenticationActivity;
	}

	public int getControlType() {
		return _mainModel.getControlType();
	}
	
	public int getViewType() {
		return _mainModel.getViewType();
	}
	
}
