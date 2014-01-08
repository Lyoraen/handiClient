package fr.ensicaen.equipe1.handiclient.modelpackage;

import fr.ensicaen.equipe1.handiclient.networkpackage.NetworkHandler;

public final class MainModel {
	public static enum controlModes {
		DEFAULT_MODE, MULTITOUCH_MODE
	};

	public static enum viewModes {
		DEFAULT_MODE, AUDIO_MODE
	};
	
	private static volatile MainModel _instance = null;

	private String _id;
	private String _pin;
	private int _controlType;
	private int _viewType;
	private String _name;
	private int _balance;
	private NetworkHandler _networkHandler = NetworkHandler.getInstance();

	private MainModel(String id,String pin) {
		_id = id;
		_pin = pin;
	}
	
	public static MainModel createInstance(String id, String pin) {
		if (_instance == null) {
			synchronized (MainModel.class) {
				if (_instance == null) {
					_instance = new MainModel(id,pin);
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
	
	public int getControlType() {
		return _controlType;
	}
	
	public int getViewType() {
		return _viewType;
	}
	
	public boolean verifyPIN(String pin){
		if(pin.equals(_pin))
		{		
			_name = _networkHandler.getName();
			_balance = _networkHandler.getBalance();
			return true;
		}
		else
		{
			return false;
		}
	}
	
}
