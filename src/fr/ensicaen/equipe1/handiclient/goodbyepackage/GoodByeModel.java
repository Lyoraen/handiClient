package fr.ensicaen.equipe1.handiclient.goodbyepackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class GoodByeModel {
	private GoodByeActivity _goodByeActivity;
	private MainModel _mainModel;
	private String _activityDescription = "Opération terminée. Merci et à bientôt.";

	public GoodByeModel(GoodByeActivity goodByeActivity) {
		_goodByeActivity = goodByeActivity;
		_mainModel = MainModel.getInstance();
		
		MainModel.deleteInstance();
	}

	public String getViewType() {
		return _mainModel.getViewType();
	}

	public String getControlType() {
		return _mainModel.getControlType();
	}
	
	public String getActivityDescription(){
		return _activityDescription;
	}

}
