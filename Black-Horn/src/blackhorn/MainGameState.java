package blackhorn;

import java.util.ArrayList;

import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;
import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.slick2d.NiftyOverlayBasicGameState;

public class MainGameState extends NiftyOverlayBasicGameState {

	int stateID;
	Nifty nifty;
	Image map = null;
	/*
	 * Enemy monster1 = null; Enemy monster2 = null; Enemy monster3 =
	 * null; Enemy monster4 = null; Debris debris1 = null; Debris debris2 =
	 * null; Debris debris3 = null; Debris debris4 = null; Debris debris5 =
	 * null; Debris debris6 = null;
	 */

	public static ArrayList<Entity> objectList;
	public static ArrayList<Entity> playerObjectList;
	public static ArrayList<Entity> objectListRemove;
	public static ArrayList<Entity> playerObjectListRemove;
	public static ArrayList<Entity> terrainObjectList;

	public static Entity fakeentity;

	public MainGameState(int stateID) {

		super();
		this.stateID = stateID;
		MainGame.player = new Player(1655, 1655);
		/*
		 * monster1 = new Enemy(1400, 1400); monster2 = new Enemy(1300,
		 * 1300); monster3 = new Enemy(1700, 1700); monster4 = new
		 * Enemy(2000, 2000);
		 * 
		 * debris1 = new Debris(1100, 1000); debris2 = new Debris(2200, 2200);
		 * debris3 = new Debris(1500, 1500); debris4 = new Debris(600, 600);
		 * debris5 = new Debris(3100, 1000); debris6 = new Debris(1700, 1200);
		 */

		fakeentity = new MovableEntity(0, 0, 0, 0);
		// list of players and non-player spawned objects
		objectList = new ArrayList<Entity>();

		// list of objects spawned by the player
		playerObjectList = new ArrayList<Entity>();

		// list of players and non-player spawned objects to be removed
		objectListRemove = new ArrayList<Entity>();

		// list of player spawned objects to be removed
		playerObjectListRemove = new ArrayList<Entity>();

		terrainObjectList = new ArrayList<Entity>();

		objectList.add(MainGame.player);
		/*
		 * objectList.add(monster1); objectList.add(monster2);
		 * objectList.add(monster3); objectList.add(monster4);
		 * terrainObjectList.add(debris1); terrainObjectList.add(debris2);
		 * terrainObjectList.add(debris3); terrainObjectList.add(debris4);
		 * terrainObjectList.add(debris5); terrainObjectList.add(debris6);
		 */

	}

	@Override
	public int getID() {
		return stateID;
	}

	@Override
	protected void enterState(GameContainer arg0, StateBasedGame arg1) throws SlickException {

	}

	@Override
	protected void initGameAndGUI(GameContainer container, StateBasedGame game) throws SlickException {

		map = new Image("/data/rocks.png");

		for (int i = 0; i < objectList.size(); i++)
			objectList.get(i).init(container);

		for (int i = 0; i < terrainObjectList.size(); i++)
			terrainObjectList.get(i).init(container);

		initNifty(container, game, MainGame.myInputSystem);
		// initNifty(container, game);
	}

	@Override
	protected void leaveState(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void prepareNifty(Nifty _nifty, StateBasedGame arg1) {
		nifty = _nifty;
		nifty.addXml("/xml/MainState.xml");
		nifty.gotoScreen("start");

	}

	@Override
	protected void renderGame(GameContainer container, StateBasedGame game, Graphics graphics) throws SlickException {

		graphics.scale((float) 1, (float) 1);
		graphics.translate(-MainGame.player.getX() - MainGame.player.getTexture().getHeight() / 2f + (float) container.getWidth() / 2f, -MainGame.player.getY()
				- MainGame.player.getTexture().getWidth() / 2f + (float) container.getHeight() / 2f);

		for (int i = 0; i < 36; i++)
			for (int j = 0; j < 24; j++)
				map.draw(i * 128, j * 128);

		for (int i = 0; i < objectList.size(); i++)
			// draw all characters
			objectList.get(i).render(container, graphics);

		for (int i = 0; i < playerObjectList.size(); i++)
			// draw bullets, etc...
			playerObjectList.get(i).render(container, graphics);

		for (int i = 0; i < terrainObjectList.size(); i++)
			terrainObjectList.get(i).render(container, graphics);

		graphics.translate(+MainGame.player.getX() + MainGame.player.getTexture().getHeight() / 2f - (float) container.getWidth() / 2f, +MainGame.player.getY()
				+ MainGame.player.getTexture().getWidth() / 2f - (float) container.getHeight() / 2f);

		graphics.scale((float) 1, (float) 1);
	}

	@Override
	protected void updateGame(GameContainer container, StateBasedGame game, int delta) throws SlickException {
		for (int i = 0; i < objectList.size(); i++)
			// update all objects
			objectList.get(i).update(container, delta);

		for (int i = 0; i < playerObjectList.size(); i++)
			// update bullets, etc...
			playerObjectList.get(i).update(container, delta);

		for (int i = 0; i < terrainObjectList.size(); i++)
			terrainObjectList.get(i).update(container, delta);

		objectList.removeAll(objectListRemove); // removes all dead;characters
		playerObjectList.removeAll(playerObjectListRemove); // removes all collided objects (bullets, grenades)

	}

}
