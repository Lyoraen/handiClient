package fr.ensicaen.equipe1.handiclient.homepackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.IModel;

public class HomeModel implements IModel {

	private HomeActivity _homeActivity; 

	public HomeModel(HomeActivity homeActivity) {
		_homeActivity = homeActivity;
	}
}
