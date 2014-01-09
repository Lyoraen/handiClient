package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.goodbyepackage.GoodByeActivity;
import fr.ensicaen.equipe1.handiclient.homepackage.HomeActivity;
import fr.ensicaen.equipe1.handiclient.homepackage.HomeControl;
import fr.ensicaen.equipe1.handiclient.homepackage.HomeModel;
import fr.ensicaen.equipe1.handiclient.homepackage.HomeView;
import fr.ensicaen.equipe1.handiclient.menupackage.MenuActivity;

public class AuthenticationActivity extends Activity {
	private AuthenticationControl _authenticationControl;
	private AuthenticationModel _authenticationModel;
	private AuthenticationView _authenticationView;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        
        _authenticationModel = new AuthenticationModel(this);
        _authenticationControl = new AuthenticationControl(this, _authenticationModel.getControlType());
        _authenticationView = new AuthenticationView(this, _authenticationModel.getViewType());
    }
    
    protected void onResume() {
		super.onResume();
		_authenticationView.describeActivity();
		//_authenticationView.reactOnAction(button);
	}
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	_authenticationControl.reactDependingOnUserActions(event);
		return true;
    }

	public AuthenticationControl getControl() {
		return _authenticationControl;
	}

	public AuthenticationModel getModel() {
		return _authenticationModel;
	}

	public AuthenticationView getView() {
		return _authenticationView;
	}

	public void intentToGoodByeActivity() {
		Intent goodByeIntent = new Intent(getApplicationContext(), GoodByeActivity.class);
		this.startActivity(goodByeIntent);
		finish();
	}
	
	public void intentToMenuActivity() {
		Intent menuIntent = new Intent(getApplicationContext(), MenuActivity.class);
		this.startActivity(menuIntent);
		finish();
	}
}
