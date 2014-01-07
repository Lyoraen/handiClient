package fr.ensicaen.equipe1.handiclient.menupackage;

import fr.ensicaen.equipe1.handiclient.controlpackage.IControl;

public class MenuControl implements IControl {
	
	private MenuActivity _menuActivity;

	public MenuControl(MenuActivity menuActivity) {
		_menuActivity = menuActivity;
	}

}
