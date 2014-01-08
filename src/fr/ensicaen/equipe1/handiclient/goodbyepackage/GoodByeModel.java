package fr.ensicaen.equipe1.handiclient.goodbyepackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class GoodByeModel {
	
	private GoodByeActivity _goodByeActivity;

	public GoodByeModel(GoodByeActivity goodByeActivity) {
		_goodByeActivity = goodByeActivity;
		
		MainModel.deleteInstance();
	}

}
