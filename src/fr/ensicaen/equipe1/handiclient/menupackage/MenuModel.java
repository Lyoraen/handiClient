package fr.ensicaen.equipe1.handiclient.menupackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class MenuModel {
	
	private MenuActivity _menuActivity;
	private MainModel _mainModel;

	public MenuModel(MenuActivity menuActivity) {
		_menuActivity = menuActivity;
		_mainModel = MainModel.getInstance();
	}

}
