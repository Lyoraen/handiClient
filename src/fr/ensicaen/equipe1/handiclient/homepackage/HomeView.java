package fr.ensicaen.equipe1.handiclient.homepackage;

import fr.ensicaen.equipe1.handiclient.viewpackage.IView;

public class HomeView implements IView {
	
	private HomeActivity _homeActivity; 

	public HomeView(HomeActivity homeActivity) {
		_homeActivity = homeActivity;
	}
}
