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
		Entity tmpe = this.moveForward(delta, firingPlayer);
		
		if (tmpe == null) // bullet didn't collide with anything
			return;

		if (tmpe.equals(MainGameState.fakeentity)) { // bullet reached end of map add in to remove list
			MainGameState.objectListRemove.add(this);
			return;
		}
		
		if (tmpe instanceof Ground)
			MainGameState.objectListRemove.add(this);
		
		if(tmpe instanceof Character)
		{
			((Character) tmpe).takeDamage(5); // bullet collided with a character
			MainGameState.objectListRemove.add(this); // add in to remove list
		}
		
	}

	public void render(GameContainer container, Graphics g) throws SlickException {
		super.render(container, g);
	}
}
