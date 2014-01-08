package fr.ensicaen.equipe1.handiclient.homepackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class HomeModel {

	private HomeActivity _homeActivity; 

	public HomeModel(HomeActivity homeActivity) {
		_homeActivity = homeActivity;
	}
	
	public void setCardData(String id,String pin) {
		MainModel.createInstance(id,pin);
	}
}