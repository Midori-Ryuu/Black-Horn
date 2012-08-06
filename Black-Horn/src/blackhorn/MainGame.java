package blackhorn;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import de.lessvoid.nifty.slick2d.input.SlickSlickInputSystem;

public class MainGame extends StateBasedGame {

	public static boolean enteringFromMenu = false;
	public static final int MAINGAMESTATE = 0;
	public static final int MAINMENUSTATE = 1;
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
		//app.setMinimumLogicUpdateInterval(16);
		app.setMaximumLogicUpdateInterval(1);
		app.setAlwaysRender(true);
		app.setDisplayMode(800, 640, false); // window size
		app.start();
	}

	@Override
	public void initStatesList(GameContainer container) throws SlickException {
		MainGame.myInputListener = new MyInputListener();
		MainGame.myInputSystem = new SlickSlickInputSystem(myInputListener);
		MainGame.game = this;
		MainGame.container = container;
		this.addState(new MainGameState(MAINGAMESTATE));
		this.addState(new MainMenuState(MAINMENUSTATE));
		this.enterState(MAINMENUSTATE);
	}
}
