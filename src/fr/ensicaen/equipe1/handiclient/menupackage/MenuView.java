package fr.ensicaen.equipe1.handiclient.menupackage;

import android.widget.Button;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.menupackage.MenuActivity;
import fr.ensicaen.equipe1.handiclient.viewpackage.AudioView;
import fr.ensicaen.equipe1.handiclient.viewpackage.IView;

public class MenuView implements IView {

	private MenuActivity _menuActivity;
	private IView _view;

	public MenuView(MenuActivity menuActivity,String viewType) {
		_menuActivity = menuActivity;
		if(viewType.equals("AUDIO_MODE")) {
			_view = new AudioView(_menuActivity,R.id.layoutMenu);
		}
		/*
		else {
			break;
		}
		 */
	}

	public void describe() {
		_view.describe();
	}

	@Override
	public void reactOnNumberButtons(Button button) {
		_view.reactOnNumberButtons(button);
	}

	@Override
	public void reactOnCancelButton(Button button) {
		_view.reactOnCancelButton(button);
	}

	@Override
	public void reactOnValidateButton(Button button) {
		_view.reactOnValidateButton(button);
	}

	@Override
	public void describe(String speech) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroyTTS() {
		_view.destroyTTS();
		
	}
}
