package fr.ensicaen.equipe1.handiclient.menupackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import fr.ensicaen.equipe1.handiclient.R;

import fr.ensicaen.equipe1.handiclient.goodbyepackage.GoodByeActivity;
import fr.ensicaen.equipe1.handiclient.withdrawmoneypackage.WithdrawMoneyActivity;

public class MenuActivity extends Activity {

	private MenuControl _menuControl;
	private MenuModel _menuModel;
	private MenuView _menuView;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        
        _menuModel = new MenuModel(this);
        _menuControl = new MenuControl(this, _menuModel.getControlType());
        _menuView = new MenuView(this, _menuModel.getViewType());
    }
    
    protected void onResume() {
		super.onResume();
		_menuView.describe();
		//_menuView.reactOnAction(button);
	}
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	_menuControl.reactDependingOnUserActions(event);
		return true;
    }

	public MenuControl getControl() {
		return _menuControl;
	}

	public MenuModel getModel() {
		return _menuModel;
	}

	public MenuView getView() {
		return _menuView;
	}

	public void intentToGoodByeActivity() {
		Intent goodByeIntent = new Intent(getApplicationContext(), GoodByeActivity.class);
		this.startActivity(goodByeIntent);
		finish();
	}
	
	public void intentWithdrawMoneyActivity() {
		System.out.println("HAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		Intent withdrawMoneyIntent = new Intent(getApplicationContext(), WithdrawMoneyActivity.class);
		this.startActivity(withdrawMoneyIntent);
		finish();
	}
}
