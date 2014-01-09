package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class AuthenticationModel {

	private AuthenticationActivity _authenticationActivity;
	private MainModel _mainModel;
	private String _activityDescription = "Entrer votre code PIN. Poser le nombre de doigts correspondant au chiffre souhaité. Zéro correspond à dix doigts.";

	public AuthenticationModel(AuthenticationActivity authenticationActivity) {
		_authenticationActivity = authenticationActivity;
		_mainModel = MainModel.getInstance();
	}

	public String getControlType() {
		return _mainModel.getControlType();
	}

	public String getViewType() {
		return _mainModel.getViewType();
	}

	public boolean verifyPIN(String pin){
		if(pin.equals(_mainModel.getPin()))
		{		
			return true;
		}
		return false;
	}
	
	public String getActivityDescription() {
		return _activityDescription;
	}

}
