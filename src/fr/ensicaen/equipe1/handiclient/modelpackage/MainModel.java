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

	private int _id;
	private int _controlMode;
	private int _viewMode;
	private NetworkHandler _networkHandler = NetworkHandler.getInstance();

	private MainModel(int id, int controlMode, int viewMode) {
		_id = id;
		_controlMode = controlMode;
		_viewMode = viewMode;
	}

	public static MainModel createInstance(int id, int controlMode, int viewMode) {
		if (_instance == null) {
			synchronized (MainModel.class) {
				if (_instance == null) {
					_instance = new MainModel(id, controlMode, viewMode);
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
}
