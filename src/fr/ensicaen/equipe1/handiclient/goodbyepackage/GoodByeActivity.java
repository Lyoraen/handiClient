package fr.ensicaen.equipe1.handiclient.goodbyepackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.homepackage.HomeActivity;

public class GoodByeActivity extends Activity {

	GoodByeModel _goodByeModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_goodbye);   
		_goodByeModel = new GoodByeModel(this);

		new CountDownTimer(2000, 1000) {

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
}
