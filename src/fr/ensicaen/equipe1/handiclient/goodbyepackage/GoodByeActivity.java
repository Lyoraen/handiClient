package fr.ensicaen.equipe1.handiclient.goodbyepackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.homepackage.HomeActivity;

public class GoodByeActivity extends Activity {
	private GoodByeControl _goodByeControl;
	private GoodByeModel _goodByeModel;
	private GoodByeView _goodByeView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goodbye);   
		_goodByeModel = new GoodByeModel(this);
		_goodByeControl = new GoodByeControl(this, _goodByeModel.getControlType());
		_goodByeView = new GoodByeView(this, _goodByeModel.getViewType());
		
		
		new CountDownTimer(5000, 1000) {

			@Override
			public void onFinish() {
				Intent beginningIntent = new Intent(getApplicationContext(), HomeActivity.class);
				GoodByeActivity.this.startActivity(beginningIntent);
				finish();
			}

			@Override
			public void onTick(long arg0) {
			}

		}.start();
	}
	
	protected void onResume() {
		super.onResume();
		_goodByeView.describeActivity();
		//_authenticationView.reactOnAction(button);
	}

	public GoodByeModel getModel() {
		return _goodByeModel;
	}
	
	public GoodByeView getView() {
		return _goodByeView;
	}
}
