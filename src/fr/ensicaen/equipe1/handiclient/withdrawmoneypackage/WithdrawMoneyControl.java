package fr.ensicaen.equipe1.handiclient.withdrawmoneypackage;

import android.view.MotionEvent;
import android.widget.Button;
import fr.ensicaen.equipe1.handiclient.controlpackage.IControl;
import fr.ensicaen.equipe1.handiclient.controlpackage.MultiTouchControl;
import fr.ensicaen.equipe1.handiclient.menupackage.MenuActivity;
import fr.ensicaen.equipe1.handiclient.networkpackage.NetworkHandler;

public class WithdrawMoneyControl implements IControl {

	private WithdrawMoneyActivity _withdrawMoneyActivity;
	private IControl _control;
	private NetworkHandler _networkHandler;

	public WithdrawMoneyControl(WithdrawMoneyActivity withdrawMoneyActivity,
			String controlType) {
		_withdrawMoneyActivity = withdrawMoneyActivity;

		if (controlType.equals("MULTITOUCH_MODE")) {
			_control = new MultiTouchControl(this);
		}
	}

	@Override
	public void useButton(int i) {
		boolean added = _withdrawMoneyActivity.getModel().addNumberToAmount(i);
		if (added == true)
			_withdrawMoneyActivity.getView().reactOnNumberButtons( (Button) _withdrawMoneyActivity .findViewById(_withdrawMoneyActivity.getResources() .getIdentifier(
											"withdrawmoneybutton" + i, "id", _withdrawMoneyActivity.getPackageName())));
		else
			_withdrawMoneyActivity.getView().tooMuchEntries();
	}

	@Override
	public void useButtonCancel() {
		boolean cancelled = _withdrawMoneyActivity.getModel().cancelEntry();
		_withdrawMoneyActivity.getView()
				.reactOnCancelButton(
						(Button) _withdrawMoneyActivity
								.findViewById(_withdrawMoneyActivity
										.getResources().getIdentifier(
												"withdrawmoneybuttoncancel",
												"id",
												_withdrawMoneyActivity
														.getPackageName())));
		if (cancelled == false) {
			_withdrawMoneyActivity.intentToMenuActivity();
		}
	}

	@Override
	public void useButtonValidate() {
		_withdrawMoneyActivity.getView()
				.reactOnValidateButton(
						(Button) _withdrawMoneyActivity
								.findViewById(_withdrawMoneyActivity
										.getResources().getIdentifier(
												"withdrawmoneybuttonvalidate",
												"id",
												_withdrawMoneyActivity
														.getPackageName())));
		int money = Integer.parseInt(_withdrawMoneyActivity.getModel()
				.getAmountEnteredByUser());
		_networkHandler = NetworkHandler.getInstance();
		_networkHandler.setMoney(money);
		_networkHandler.getWithdrawFunction().execute();
		/*
		 * Boolean test = _networkHandler.getValidation();
		 * if(test.booleanValue()==true){ //Argent retiré }else{ //Argent pas
		 * retiré }
		 */
		_withdrawMoneyActivity.intentToGoodByeActivity();
	}

	@Override
	public void reactDependingOnUserActions(MotionEvent motionEvent) {
		_control.reactDependingOnUserActions(motionEvent);

	}

}
