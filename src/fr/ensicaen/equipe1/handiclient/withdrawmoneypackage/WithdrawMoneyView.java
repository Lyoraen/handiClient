package fr.ensicaen.equipe1.handiclient.withdrawmoneypackage;

import android.widget.Button;
import android.widget.TextView;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.viewpackage.AudioView;
import fr.ensicaen.equipe1.handiclient.viewpackage.IView;

public class WithdrawMoneyView implements IView{
	
	private WithdrawMoneyActivity _withdrawMoneyActivity;
	private IView _view;
	
	private String _amountDisplayed = "";

	public WithdrawMoneyView(WithdrawMoneyActivity withdrawMoneyActivity, String viewType) {
		_withdrawMoneyActivity = withdrawMoneyActivity;
		if(viewType.equals("AUDIO_MODE")) {
			_view = new AudioView(_withdrawMoneyActivity,R.id.layoutWithdrawmoney);
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


	public void addNumberToAmountField(int i) {
		_amountDisplayed += i;
		updateAmountField();
		
	}


	public void removeNumberFromAmountField() {
		int length = _amountDisplayed.length();
		_amountDisplayed = _amountDisplayed.substring(0, length - 1);
		updateAmountField();
		
	}
	

	private void updateAmountField() {
		TextView amountField = (TextView) _withdrawMoneyActivity.findViewById(R.id.amountField);
		amountField.setText(_amountDisplayed);	
	}

	@Override
	public void describe(String speech) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactOnNumberButtons(Button button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactOnCancelButton(Button button) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactOnValidateButton(Button button) {
		// TODO Auto-generated method stub
		
	}

	public void tooMuchEntries() {
		// TODO Auto-generated method stub
		
	}
}
