package fr.ensicaen.equipe1.handiclient.withdrawmoneypackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class WithdrawMoneyModel {
	
	private WithdrawMoneyActivity _withdrawMoneyActivity;
	private MainModel _mainModel;

	public WithdrawMoneyModel(WithdrawMoneyActivity withdrawMoneyActivity) {
		_withdrawMoneyActivity = withdrawMoneyActivity;
		_mainModel = MainModel.getInstance();
	}
}
