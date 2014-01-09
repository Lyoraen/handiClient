package fr.ensicaen.equipe1.handiclient.viewpackage;

import android.widget.Button;

public interface IView {
	public void describe();
	public void reactOnNumberButtons(Button button);
	public void reactOnCancelButton(Button button);
	public void reactOnValidateButton(Button button);
	public void describeActivity(final String speech);

}
