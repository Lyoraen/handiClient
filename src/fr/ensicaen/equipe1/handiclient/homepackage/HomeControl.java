package fr.ensicaen.equipe1.handiclient.homepackage;

import fr.ensicaen.equipe1.handiclient.controlpackage.IControl;
import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class HomeControl {
	
	private HomeActivity _homeActivity;
	private IControl _control;

	public HomeControl(HomeActivity homeActivity) {
		_homeActivity = homeActivity;
	}
}
