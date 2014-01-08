package fr.ensicaen.equipe1.handiclient.homepackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class HomeModel {

	private HomeActivity _homeActivity; 
	private MainModel _mainModel = MainModel.getInstance();

	public HomeModel(HomeActivity homeActivity) {
		_homeActivity = homeActivity;
	}
}
