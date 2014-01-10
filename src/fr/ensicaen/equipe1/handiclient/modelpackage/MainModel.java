package fr.ensicaen.equipe1.handiclient.modelpackage;

import fr.ensicaen.equipe1.handiclient.networkpackage.NetworkHandler;

public final class MainModel {
	public static enum controlModes {
		DEFAULT_MODE, MULTITOUCH_MODE
	};

	public static enum viewModes {
		DEFAULT_MODE, AUDIO_MODE
	};

	private volatile static MainModel _instance = null;

	private String _id;
	private String _pin;
	private String _controlType;
	private String _viewType;
	private static String _name;
	private static int _balance;
	private static NetworkHandler _networkHandler = NetworkHandler
			.getInstance();

	private MainModel(String id, String pin, String controlMode, String viewMode) {
		_id = id;
		_pin = pin;
		// perso carte
		_controlType = controlMode;
		_viewType = viewMode;
	}

	public static MainModel createInstance(String id, String pin,
			String controlMode, String viewMode) {
		_instance = new MainModel(id, pin, controlMode, viewMode);
		
		// connexion networkhandler
		NetworkHandler n = NetworkHandler.getInstance();
		n.setId(id);
		//_name = _networkHandler.getName(id);
		n.getGetNameFunction().execute();
		_name = n.getName();
		//_balance = _networkHandler.getBalance(id);
		n.getGetBalanceFunction().execute();
		_balance = n.getMoney();

		return _instance;
	}

	public static MainModel getInstance() {
		return _instance;
	}

	public static void deleteInstance() {
		_instance = null;
	}

	public boolean verifyPin(String enteredPin) {
		if (enteredPin.equals(_pin))
			return true;
		return false;
	}

	public String getControlType() {
		return _controlType;
	}

	public String getViewType() {
		return _viewType;
	}

	public static String getName() {
		return _name;
	}

	public static int getBalance() {
		return _balance;
	}

}
