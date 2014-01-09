package fr.ensicaen.equipe1.handiclient.withdrawmoneypackage;

import fr.ensicaen.equipe1.handiclient.modelpackage.MainModel;

public class WithdrawMoneyModel {
	
	private WithdrawMoneyActivity _withdrawMoneyActivity;
	private MainModel _mainModel;
	private String _activityDescription = "Veuillez entrer le montant que vous souhaitez.";
	private String _amountEnteredByUser = "";
	
	public WithdrawMoneyModel(WithdrawMoneyActivity withdrawMoneyActivity) {
		_withdrawMoneyActivity = withdrawMoneyActivity;
		_mainModel = MainModel.getInstance();
	}
	
	public String getControlType() {
		return _mainModel.getControlType();
	}

	public String getViewType() {
		return _mainModel.getViewType();
	}
	
	public void addNumberToAmount(int i) {
		_amountEnteredByUser += "" + i;
		
		// Notify View
		_withdrawMoneyActivity.getView().addNumberToAmountField(i);
	}
	
	
	public boolean cancelEntry() {
		int length = _amountEnteredByUser.length();
		if (length == 0)
			return false;
		_amountEnteredByUser = _amountEnteredByUser.substring(0, length - 1);
		// Notify View
		_withdrawMoneyActivity.getView().removeNumberFromAmountField();
		
		return true;
	}
	
	public String getActivityDescription() {
		return _activityDescription;
	}

	public boolean verifyBalance() {
		// TODO Auto-generated method stub
		return false;
		
	}

	
}
