package fr.ensicaen.equipe1.handiclient.homepackage;

import fr.ensicaen.equipe1.handiclient.controlpackage.IControl;

public class HomeControl implements IControl {
	
	private HomeActivity _homeActivity; 

	public HomeControl(HomeActivity homeActivity) {
		_homeActivity = homeActivity;
	}
}
