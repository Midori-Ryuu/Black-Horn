package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class MovableEntity extends Entity {

	private float sideSpeed;
	private float jumpSpeed;
	private boolean isJumping;

	public MovableEntity(float x, float y, float sideSpeed, float rotation) {

		super(x, y, rotation);
		this.sideSpeed = sideSpeed;
		this.jumpSpeed = CConstants.PLAYER_JUMP_SPEED;
		setJumping(false);
	}

	public void init(GameContainer gc) throws SlickException {
		super.init(gc);

	}

	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
		if (sideSpeed != 0f)
			moveForward(delta, null);
		if (isJumping) {
			Entity tmpe = jumpUp(delta);

			if (tmpe == null) //Didn't collide with anything
				jumpSpeed += CConstants.GRAVITY;
			//else if (tmpe instanceof Ground) //Collided with ceiling or object -- will be implemented
			else if(tmpe.equals(MainGameState.fakeentity)) {
				if (jumpSpeed > 0) {
					isJumping = false;
					jumpSpeed = CConstants.PLAYER_JUMP_SPEED;
				} else
					jumpSpeed = Math.abs(jumpSpeed);
			}

		}
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
	}

	public void setSideSpeed(float sideSpeed) {
		this.sideSpeed = sideSpeed;
	}

	public float getSideSpeed() {
		return sideSpeed;
	}

	public Entity moveForward(int delta, Entity ignored) { //ignored is used by projectiles to ignore the firing source 

		this.setRotation(Math.abs(this.getRotation()) * Math.signum(sideSpeed));
		this.getTexture().setRotation(this.getRotation());
		float speed = sideSpeed * (float) delta;
		float tmpx = this.getX() + speed;
		return detectCollision(tmpx, this.getY(), ignored);
	}

	public Entity jumpUp(int delta) {

		float speed = jumpSpeed * (float) delta;
		float tmpy = this.getY() + speed;
		return detectCollision(this.getX(), tmpy, null);
	}

	public float getJumpSpeed() {
		return jumpSpeed;
	}

	public void setJumpSpeed(float jumpSpeed) {
		this.jumpSpeed = jumpSpeed;
	}

	public boolean isJumping() {
		return isJumping;
	}

	public void setJumping(boolean isJumping) {
		this.isJumping = isJumping;
	}

}
