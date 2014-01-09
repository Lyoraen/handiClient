package fr.ensicaen.equipe1.handiclient.goodbyepackage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import fr.ensicaen.equipe1.handiclient.R;
import fr.ensicaen.equipe1.handiclient.homepackage.HomeActivity;

public class GoodByeActivity extends Activity {
	
	GoodByeModel _goodByeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodbye);   
        _goodByeModel = new GoodByeModel(this);
    }
    
    protected void onResume() {
    	super.onResume();
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Intent beginningIntent = new Intent(getApplicationContext(), HomeActivity.class);
		this.startActivity(beginningIntent);
		finish();
    }
    
    
}
