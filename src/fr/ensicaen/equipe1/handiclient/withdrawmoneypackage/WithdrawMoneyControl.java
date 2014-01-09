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
<<<<<<< HEAD
		_withdrawMoneyActivity.getModel().addNumberToAmount(i);
		//_withdrawMoneyActivity.getView().reactOnAction((Button) _withdrawMoneyActivity.findViewById(_withdrawMoneyActivity.getResources().getIdentifier("withdrawmoneybutton"+i, "id", _withdrawMoneyActivity.getPackageName())));
=======
		boolean added = _withdrawMoneyActivity.getModel().addNumberToAmount(i);
		_withdrawMoneyActivity.getView().reactOnNumberButtons((Button) _withdrawMoneyActivity.findViewById(_withdrawMoneyActivity.getResources().getIdentifier("withdrawmoneybutton"+i, "id", _withdrawMoneyActivity.getPackageName())));
		if(added == false)
			_withdrawMoneyActivity.getView().tooMuchEntries();
>>>>>>> 124fe25363e079e184d7d53cd8497315846e5bd7
	}

	@Override
	public void useButtonCancel() {
		boolean cancelled = _withdrawMoneyActivity.getModel().cancelEntry();
<<<<<<< HEAD
		//TODO
		//if (cancelled == true) _withdrawMoneyActivity.intentToGoodByeActivity();
		//_withdrawMoneyActivity.getView().reactOnAction((Button) _withdrawMoneyActivity.findViewById(_withdrawMoneyActivity.getResources().getIdentifier("withdrawmoneybuttoncancel", "id", _withdrawMoneyActivity.getPackageName())));
=======
		_withdrawMoneyActivity.getView().reactOnCancelButton((Button) _withdrawMoneyActivity.findViewById(_withdrawMoneyActivity.getResources().getIdentifier("withdrawmoneybuttoncancel", "id", _withdrawMoneyActivity.getPackageName())));
		if (cancelled == false) {
			_withdrawMoneyActivity.intentToGoodByeActivity();
		}
		
>>>>>>> 124fe25363e079e184d7d53cd8497315846e5bd7
	}

	@Override
	public void useButtonValidate() {
<<<<<<< HEAD
		_withdrawMoneyActivity.getModel().verifyBalance();
		//_withdrawMoneyActivity.getView().reactOnAction((Button) _withdrawMoneyActivity.findViewById(_withdrawMoneyActivity.getResources().getIdentifier("withdrawmoneyvalidate", "id", _withdrawMoneyActivity.getPackageName())));
		
		
=======
		_withdrawMoneyActivity.getView().reactOnValidateButton((Button) _withdrawMoneyActivity.findViewById(_withdrawMoneyActivity.getResources().getIdentifier("withdrawmoneybuttonvalidate", "id", _withdrawMoneyActivity.getPackageName())));
			_withdrawMoneyActivity.intentToGoodByeActivity();	
>>>>>>> 124fe25363e079e184d7d53cd8497315846e5bd7
	}

	@Override
	public void reactDependingOnUserActions(MotionEvent motionEvent) {
		_control.reactDependingOnUserActions(motionEvent);
		
	}

}
