package fr.ensicaen.equipe1.handiclient.menupackage;

import fr.ensicaen.equipe1.handiclient.controlpackage.IControl;
import fr.ensicaen.equipe1.handiclient.controlpackage.MultiTouchControl;
import fr.ensicaen.equipe1.handiclient.networkpackage.NetworkHandler;
import android.view.MotionEvent;
import android.widget.Button;

public class MenuControl implements IControl {

	private MenuActivity _menuActivity;
	private IControl _control;
	NetworkHandler _networkHandler;

	public MenuControl(MenuActivity menuActivity, String controlType) {
		_menuActivity = menuActivity;

		if (controlType.equals("MULTITOUCH_MODE")) {
			_control = new MultiTouchControl(this);
		}
	}

	@Override
	public void useButton(int i) {
		switch (i) {
		case 1:
			_networkHandler = NetworkHandler.getInstance();
			_networkHandler.setMoney(20);
			_networkHandler.getWithdrawFunction().execute();
			_menuActivity.intentToGoodByeActivity();
			break;
		case 2:
			_menuActivity.intentWithdrawMoneyActivity();
			break;
		case 3:
			_menuActivity.intentToGoodByeActivity();
			break;
		}
		_menuActivity.getView().reactOnSecretNumberButtons(
				(Button) _menuActivity.findViewById(_menuActivity
						.getResources().getIdentifier("menubutton" + i, "id",
								_menuActivity.getPackageName())));
	}

	@Override
	public void useButtonCancel() {
		_menuActivity.intentToGoodByeActivity();
	}

	@Override
	public void reactDependingOnUserActions(MotionEvent e) {
		_control.reactDependingOnUserActions(e);
	}

	@Override
	public void useButtonValidate() {
		// there is nothing in the fridge
	}

}
