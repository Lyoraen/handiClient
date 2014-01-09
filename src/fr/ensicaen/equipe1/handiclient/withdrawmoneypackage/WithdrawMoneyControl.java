package fr.ensicaen.equipe1.handiclient.withdrawmoneypackage;

import android.view.MotionEvent;
import android.widget.Button;
import fr.ensicaen.equipe1.handiclient.controlpackage.IControl;
import fr.ensicaen.equipe1.handiclient.controlpackage.MultiTouchControl;
import fr.ensicaen.equipe1.handiclient.menupackage.MenuActivity;

public class WithdrawMoneyControl implements IControl{
	
	private WithdrawMoneyActivity _withdrawMoneyActivity;
	private IControl _control;

	public WithdrawMoneyControl(WithdrawMoneyActivity withdrawMoneyActivity, String controlType) {
		_withdrawMoneyActivity = withdrawMoneyActivity;
		
		if(controlType.equals("MULTITOUCH_MODE")) {
			_control = new MultiTouchControl(this);
		}
	}

	@Override
	public void useButton(int i) {
		_withdrawMoneyActivity.getModel().addNumberToAmount(i);
		_withdrawMoneyActivity.getView().reactOnAction((Button) _withdrawMoneyActivity.findViewById(_withdrawMoneyActivity.getResources().getIdentifier("withdrawmoneybutton"+i, "id", _withdrawMoneyActivity.getPackageName())));
	}

	@Override
	public void useButtonCancel() {
		boolean cancelled = _withdrawMoneyActivity.getModel().cancelEntry();
		//TODO
		//if (cancelled == true) _withdrawMoneyActivity.intentToGoodByeActivity();
		_withdrawMoneyActivity.getView().reactOnAction((Button) _withdrawMoneyActivity.findViewById(_withdrawMoneyActivity.getResources().getIdentifier("withdrawmoneybuttoncancel", "id", _withdrawMoneyActivity.getPackageName())));
	}

	@Override
	public void useButtonValidate() {
		_withdrawMoneyActivity.getModel().verifyBalance();
		_withdrawMoneyActivity.getView().reactOnAction((Button) _withdrawMoneyActivity.findViewById(_withdrawMoneyActivity.getResources().getIdentifier("withdrawmoneyvalidate", "id", _withdrawMoneyActivity.getPackageName())));
		
		
	}

	@Override
	public void reactDependingOnUserActions(MotionEvent motionEvent) {
		_control.reactDependingOnUserActions(motionEvent);
		
	}

}
