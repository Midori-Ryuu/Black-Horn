package blackhorn;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.screen.Screen;
import de.lessvoid.nifty.screen.ScreenController;

class MyScreenController implements ScreenController {
	public void bind(Nifty nifty, Screen screen) {
	}

	public void onEndScreen() {
	}

	public void onStartScreen() {
	}

	public void next() {
		System.out.println("next() called from MyScreenController");
	}
}