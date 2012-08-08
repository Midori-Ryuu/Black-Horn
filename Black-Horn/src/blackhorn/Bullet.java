package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Bullet extends MovableEntity {

	private Entity firingPlayer;

	Bullet(float x, float y, Entity firingPlayer) {
		super(x, y, Math.signum(firingPlayer.getRotation()) * CConstants.BULLET_SPEED, firingPlayer.getRotation(),0,0);
		this.firingPlayer = firingPlayer;
	}

	public void init(GameContainer container) throws SlickException {
		super.init(container);
		this.setTexture(new Image("/data/bullet.png"));
	}

	public void update(GameContainer container, int delta) throws SlickException {
		super.update(container, delta);
		moveForward(delta, firingPlayer);	
	}

	public void render(GameContainer container, Graphics g) throws SlickException {
		super.render(container, g);
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
}
