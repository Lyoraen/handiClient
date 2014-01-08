package fr.ensicaen.equipe1.handiclient.controlpackage;

import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;

public class MultiTouchControl implements IControl {
	
	private float _previousX;
	private float _previousY;
	private int pointCnt = 0;

	TextView textView;  //textView = (TextView) findViewById(R.id.text);

	@Override
	public void useButton(int i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useButtonCancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void useButtonValidate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reactDependingOnUserActions(MotionEvent motionEvent) {
		int action = (motionEvent.getAction() & MotionEvent.ACTION_MASK);

		try {
		
			switch (action) {
			case MotionEvent.ACTION_DOWN:
				pointCnt = 1;
				textView.setText("DOWN : " + String.valueOf(pointCnt));
				_previousX = motionEvent.getX();
				_previousY = motionEvent.getY();
				break;

			case MotionEvent.ACTION_UP:
				
				if(getDistance(_previousX, _previousY, motionEvent) > 300){
					textView.setText("valide");
					useButtonValidate();
					pointCnt = 0;
				}
				else if (getDistance(_previousX, _previousY, motionEvent) < -300 ) {
					textView.setText("annule");
					useButtonCancel();
					pointCnt = 0;
				}
			
				if (pointCnt>0){
					for(int i=1; i<10; i++){
						if(pointCnt == i){
							useButton(i);
							break;
						}
					}
					textView.setText(String.valueOf(pointCnt));
				}
				break;


			case MotionEvent.ACTION_POINTER_DOWN:

				int currentPointerCnt = motionEvent.getPointerCount();
				if (currentPointerCnt > pointCnt) {
					pointCnt = currentPointerCnt;
				}

				textView.setText("POINTER_DOWN : " + String.valueOf(pointCnt));
				break;

			default:
				break;
			}
		} catch (Exception e) {
			Log.e("error", e.getMessage());
		}	
	}
	
	
	/**
	 * @brief getDistance
	 */
	float getDistance(float startX, float startY, MotionEvent ev) {
		float distanceSum = 0;
		final int historySize = ev.getHistorySize();
		for (int h = 0; h < historySize; h++) {
			// historical point
			float hx = ev.getHistoricalX(0, h);
			float hy = ev.getHistoricalY(0, h);
			// distance between startX,startY and historical point
			float dx = (hx - startX);
			float dy = (hy - startY);
			distanceSum += Math.sqrt(dx * dx + dy * dy);
			// make historical point the start point for next loop iteration
			startX = hx;
			startY = hy;
		}
		// add distance from last historical point to event's point
		float dx = (ev.getX(0) - startX);
		//Log.i("dx   ", String.valueOf(dx));
		float dy = (ev.getY(0) - startY);
		//Log.i("dy   ", String.valueOf(dy));
		distanceSum += Math.sqrt(dx * dx + dy * dy);
		if (dx < 0){// a gauche
			return -distanceSum;
		}
		else // a droite
			return distanceSum;
	}
}
