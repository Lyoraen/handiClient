package fr.ensicaen.equipe1.handiclient.withdrawmoneypackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.goodbyepackage.GoodByeActivity;

public class WithdrawMoneyActivity extends Activity {
	private WithdrawMoneyControl _withdrawMoneyControl;
	private WithdrawMoneyModel _withdrawMoneyModel;
	private WithdrawMoneyView _withdrawMoneyView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_withdrawmoney);
		
		_withdrawMoneyModel = new WithdrawMoneyModel(this);
		_withdrawMoneyControl = new WithdrawMoneyControl(this, _withdrawMoneyModel.getControlType());
		_withdrawMoneyView = new WithdrawMoneyView(this, _withdrawMoneyModel.getViewType());
	}
	
	protected void onResume() {
		super.onResume();
		_withdrawMoneyView.describe(_withdrawMoneyModel.getActivityDescription());

		//_authenticationView.reactOnAction(button);
	}
	
	@Override
    public boolean onTouchEvent(MotionEvent event) {
    	_withdrawMoneyControl.reactDependingOnUserActions(event);
		return true;
    }

	public WithdrawMoneyControl getControl() {
		return _withdrawMoneyControl;
	}

	public WithdrawMoneyModel getModel() {
		return _withdrawMoneyModel;
	}

	public WithdrawMoneyView getView() {
		return _withdrawMoneyView;
	}

	public void intentToGoodByeActivity() {
		Intent goodByeIntent = new Intent(getApplicationContext(), GoodByeActivity.class);
		this.startActivity(goodByeIntent);
		finish();
		
	}
}
