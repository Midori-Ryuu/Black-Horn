package blackhorn;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.slick2d.NiftyOverlayBasicGameState;

public class MainMenuState extends NiftyOverlayBasicGameState {

	int stateID;

	public MainMenuState(int stateID) {

		super();
		this.stateID = stateID;

	}

	@Override
	public int getID() {
		return stateID;

	}

	@Override
	protected void enterState(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub
	}

	@Override
	protected void initGameAndGUI(GameContainer container, StateBasedGame game) throws SlickException {

		initNifty(container, game, MainGame.myInputSystem);
		// MainGame.game=game;
	}

	@Override
	protected void leaveState(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		MainGame.enteringFromMenu = true;
		// TODO Auto-generated method stub

	}

	@Override
	protected void prepareNifty(Nifty nifty, StateBasedGame arg1) {

		nifty.addXml("/xml/MainMenu.xml");
		nifty.gotoScreen("start");

	}

	@Override
	protected void renderGame(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException {
	}

	@Override
	protected void updateGame(GameContainer container, StateBasedGame game, int delta) throws SlickException {
	}
}
