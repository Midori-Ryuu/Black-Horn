package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Enemy extends Character {

	public Enemy(float x, float y, float weight) {
		super(x, y, 1, 1, 1, 1, 0.00001f, 0, 0, 0.1f);
	}

	public void init(GameContainer container) throws SlickException {

		this.setTexture(new Image("/data/GrueBloodyGrin.png"));
		super.init(container);
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
		movableEntity.enemyCollision(this);
		// TODO Auto-generated method stub

	}

}
