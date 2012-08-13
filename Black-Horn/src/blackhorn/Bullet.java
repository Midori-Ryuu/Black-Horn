package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet extends MovableEntity {

	private Entity firingPlayer;

	Bullet(float x, float y, Entity firingPlayer) {
		super(x, y, Math.signum(firingPlayer.getRotation()) * CConstants.BULLET_SPEED, firingPlayer.getRotation(), 0, 0);
		this.setFiringPlayer(firingPlayer);
	}

	public void init(GameContainer container) throws SlickException {
		//this.setTexture(new Image("/data/bullet.png"));
		MainGameState.animationList.getCurrentAnimation(this);
		super.init(container);
	}

	public void update(GameContainer container, int delta) throws SlickException {
		super.update(container, delta);

	}

	public void render(GameContainer container, Graphics g) throws SlickException {
		super.render(container, g);
	}

	@Override
	public void groundCollision(Ground ground) {
		// TODO Auto-generated method stub
		MainGameState.objectListRemove.add(this);

	}

	@Override
	public void playerCollision(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void enemyCollision(Enemy enemy) {
		enemy.bulletCollision(this);
		MainGameState.objectListRemove.add(this);

	}

	@Override
	public void doCollision(MovableEntity movableEntity) {
		MainGameState.objectListRemove.add(this);
		movableEntity.bulletCollision(this);

	}

	@Override
	public void bulletCollision(Bullet bullet) {

		MainGameState.objectListRemove.add(this);

	}

	public Entity getFiringPlayer() {
		return firingPlayer;
	}

	public void setFiringPlayer(Entity firingPlayer) {
		this.firingPlayer = firingPlayer;
	}
}
