package blackhorn;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.lessvoid.nifty.slick2d.input.SlickSlickInputSystem;

public class MainGame extends StateBasedGame {

	public static boolean enteringFromMenu = false;
	public static MyInputListener myInputListener;
	public static Player player;
	public static SlickSlickInputSystem myInputSystem;
	public static StateBasedGame game;
	public static GameContainer container;

	public MainGame() {
		super("Black Horn");
	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new MainGame());
		app.setMinimumLogicUpdateInterval(35);
		app.setMaximumLogicUpdateInterval(15);
		app.setAlwaysRender(true);
		app.setVSync(true);
		app.setDisplayMode(app.getScreenWidth(), app.getScreenHeight(), true); // window size
		//app.setMultiSample(16);
		app.setMouseGrabbed(true);
		app.start();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		MainGame.myInputListener = new MyInputListener();
		MainGame.myInputSystem = new SlickSlickInputSystem(myInputListener);
		MainGame.game = this;
		MainGame.container = container;
		
		
		this.addState(new MainGameState(CConstants.MAINGAMESTATE));
		this.addState(new MainMenuState(CConstants.MAINMENUSTATE));
		//this.enterState(MAINMENUSTATE);
		this.enterState(CConstants.MAINGAMESTATE);
	}
}
