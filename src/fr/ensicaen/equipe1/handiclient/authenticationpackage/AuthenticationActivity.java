package fr.ensicaen.equipe1.handiclient.authenticationpackage;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.homepackage.HomeControl;
import fr.ensicaen.equipe1.handiclient.homepackage.HomeModel;
import fr.ensicaen.equipe1.handiclient.homepackage.HomeView;

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
		_authenticationView.describe();
		_authenticationView.reactOnAction(button);
		_authenticationControl.reactDependingOnUserActions(motionEvent);
	}
}
