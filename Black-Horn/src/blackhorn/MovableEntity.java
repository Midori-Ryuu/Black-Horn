package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class MovableEntity extends Entity {

	private float movementSpeed;

	public MovableEntity(float x, float y, float movementSpeed, float rotation) {

		super(x, y, rotation);
		this.movementSpeed = movementSpeed;
	}

	public void init(GameContainer gc) throws SlickException {
		super.init(gc);

	}

	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);

	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
	}

	public void setMovementSpeed(float movementSpeed) {
		this.movementSpeed = movementSpeed;
	}

	public float getMovementSpeed() {
		return movementSpeed;
	}

	public Entity moveForward(int delta, Entity ignored) {
		if (movementSpeed != 0) {
			this.setRotation(Math.abs(this.getRotation()) * Math.signum(movementSpeed));
			this.getTexture().setRotation(this.getRotation());
			float speed = movementSpeed * (float) delta;
			float tmpx = this.getX() + speed;
			return detectCollision(tmpx, this.getY(), ignored);
		} else
			return null;
	}

}
