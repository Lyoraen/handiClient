package fr.ensicaen.equipe1.handiclient.withdrawmoneypackage;

import fr.ensicaen.equipe1.handiclient.controlpackage.IControl;
import fr.ensicaen.equipe1.handiclient.menupackage.MenuActivity;

public class WithdrawMoneyControl implements IControl {
	
	private WithdrawMoneyActivity _withdrawMoneyActivity;

	public WithdrawMoneyControl(WithdrawMoneyActivity withdrawMoneyActivity) {
		_withdrawMoneyActivity = withdrawMoneyActivity;
	}

}
