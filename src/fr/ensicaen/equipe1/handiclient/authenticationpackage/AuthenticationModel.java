package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class AuthenticationModel {

	private AuthenticationActivity _authenticationActivity;
	private MainModel _mainModel;
	private String _activityDescription = "Entrez votre code. Posez sur l'écran le nombre de doigts correspondant au chiffre souhaité. Zéro correspondant à dix doigts. Glisser votre doigt verre la gauche pour corriger et verre la droite pour valider";
	private String _pinCodeEnteredByUser = "";

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

	public boolean addNumberToPin(int i) {
		if(_pinCodeEnteredByUser.length() < 4) {
			_pinCodeEnteredByUser += "" + i;
			
			// Notify View
			_authenticationActivity.getView().addStarToPinField();
			
			return true;
		}
		return false;
	}

	public boolean cancelEntry() {
		int length = _pinCodeEnteredByUser.length();
		if (length == 0)
			return false;
		_pinCodeEnteredByUser = _pinCodeEnteredByUser.substring(0, length - 1);
		
		// Notify View
		_authenticationActivity.getView().removeStarFromPinField();
		
		return true;
	}

	public boolean verifyPIN() {
		if (_mainModel.verifyPin(_pinCodeEnteredByUser))
			return true;
		
		// Notify View
		//TODO Message de code erroné
		
		return false;
	}

	public String getActivityDescription() {
		return _activityDescription;
	}

}
