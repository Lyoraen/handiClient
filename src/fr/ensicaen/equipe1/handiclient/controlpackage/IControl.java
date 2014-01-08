package fr.ensicaen.equipe1.handiclient.controlpackage;

import android.view.MotionEvent;

public interface IControl {

	public void useButton(int i);
	
	public void useButtonCancel();
	
	public void useButtonValidate();
	
	public void reactDependingOnUserActions(MotionEvent e);
}
