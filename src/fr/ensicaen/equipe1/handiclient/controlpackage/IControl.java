package fr.ensicaen.equipe1.handiclient.controlpackage;

import android.view.MotionEvent;

public interface IControl {
	public void useButton1();

	public void useButton2();

	public void useButton3();

	public void useButton4();

	public void useButton5();

	public void useButton6();

	public void useButton7();

	public void useButton8();

	public void useButton9();
	
	public void useButtonCancel();
	
	public void useButtonValidate();
	
	public void reactDependingOnUserActions(MotionEvent e);
}
