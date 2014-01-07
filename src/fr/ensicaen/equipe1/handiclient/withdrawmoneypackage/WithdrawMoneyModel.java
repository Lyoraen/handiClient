package fr.ensicaen.equipe1.handiclient.withdrawmoneypackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.IModel;

public class WithdrawMoneyModel implements IModel {
	
	private WithdrawMoneyActivity _withdrawMoneyActivity;

	public WithdrawMoneyModel(WithdrawMoneyActivity withdrawMoneyActivity) {
		_withdrawMoneyActivity = withdrawMoneyActivity;
	}
}
