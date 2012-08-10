package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy extends Character {

	public Enemy(float x, float y, float weight) {
		super(x, y, 1, 1, 1, 1, 1, CConstants.ROTATION_LEFT, CConstants.PLAYER_JUMP_SPEED, weight);
	}

	public void init(GameContainer container) throws SlickException {
		super.init(container);
		this.setTexture(new Image("/data/alpha.png"));
	}

	public void update(GameContainer container, int delta) throws SlickException {
		super.update(container, delta);
	}

	@Override
	public void groundCollision(Ground ground) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playerCollision(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enemyCollision(Enemy enemy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doCollision(MovableEntity movableEntity) {
		// TODO Auto-generated method stub

	}

	public void bulletCollision(Bullet bullet) {
		MainGameState.objectListRemove.add(this);
		MainGameState.objectListRemove.add(bullet);

	}
}
