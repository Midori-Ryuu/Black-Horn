package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy extends Character {

	public Enemy(float x, float y, float weight) {
		super(x, y,1,1,1,1,1,CConstants.ROTATION_LEFT,CConstants.PLAYER_JUMP_SPEED, weight);
	}

	public void init(GameContainer container) throws SlickException {
		super.init(container);
		this.setTexture(new Image("/data/alpha.png"));
	}

	public void update(GameContainer container, int delta) throws SlickException {
		super.update(container, delta);
	}
}
