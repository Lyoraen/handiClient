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
	private static NetworkHandler _networkHandler = NetworkHandler.getInstance();

	private MainModel(String id,String pin, String controlMode, String viewMode) {
		_id = id;
		_pin = pin;
		// perso carte
		_controlType = controlMode;
		_viewType = viewMode;
	}
	
	public static MainModel createInstance(String id, String pin, String controlMode, String viewMode) {
		if (_instance == null) {
			synchronized (MainModel.class) {
				if (_instance == null) {
					_instance = new MainModel(id,pin, controlMode, viewMode);
					// connexion networkhandler
					_name = _networkHandler.getName(id);
					_balance = _networkHandler.getBalance(id);
				}
			}
		}
		return _instance;
	}

	public static MainModel getInstance() {
		return _instance;
	}

	public static void deleteInstance() {
		_instance = null;
	}
	
	public String getControlType() {
		return _controlType;
	}
	
	public String getViewType() {
		return _viewType;
	}
	
	public String getPin() {
		return _pin;
	}

	public static String getName() {
		return _name;
	}

	public static int getBalance() {
		return _balance;
	}
	
}
