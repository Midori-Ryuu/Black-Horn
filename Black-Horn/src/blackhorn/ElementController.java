package blackhorn;

import java.util.Properties;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.controls.Controller;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.input.NiftyInputEvent;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.xml.xpp3.Attributes;

public class ElementController implements Controller {

	private Element element;

	@Override
	public void bind(Nifty nifty, Screen screen, Element element, Properties parameter, Attributes controlDefinitionAttributes) {
		this.element = element;
		System.out.println("bind() called for element: " + element);

	}

	@Override
	public void init(Properties parameter, Attributes controlDefinitionAttributes) {
		System.out.println("init()  called for element: " + element);

	}

	@Override
	public void onStartScreen() {
		System.out.println("onStartScreen()  alled for element: " + element);
	}

	@Override
	public void onFocus(boolean getFocus) {
		System.out.println("onFocus()  called for element: " + element + ", with: " + getFocus);
	}

	@Override
	public boolean inputEvent(NiftyInputEvent inputEvent) {

		return false;
	}

	public void next() {
		System.out.println("next() clicked for element: " + element);
		// MainGame.container.getInput().clearControlPressedRecord();
		MainGame.game.enterState(0);

	}
}