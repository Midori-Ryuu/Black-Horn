package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public abstract class MovableEntity extends Entity {

	private float sideSpeed;
	private float jumpSpeed;
	private float weight;
	private boolean isJumping;

	public MovableEntity(float x, float y, float sideSpeed, float rotation, float jumpSpeed, float weight) {

		super(x, y, rotation);
		this.sideSpeed = sideSpeed;
		this.jumpSpeed = jumpSpeed;
		this.isJumping = false;
		this.weight = weight;
	}

	public void init(GameContainer gc) throws SlickException {
		super.init(gc);

	}

	public void update(GameContainer gc, int delta) throws SlickException {
		super.update(gc, delta);
		if (sideSpeed != 0f)
			moveForward(delta, null);

		jumpUp(delta);

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

	public void moveForward(int delta, Entity ignored) { //ignored is used by projectiles to ignore the firing source 

		this.setRotation(Math.abs(this.getRotation()) * Math.signum(sideSpeed));
		this.getTexture().setRotation(this.getRotation());
		float speed = sideSpeed * (float) delta;
		float tmpx = this.getX() + speed;
		detectCollision(tmpx, this.getY(), ignored);
		//	return detectCollision(tmpx, this.getY(), ignored);
	}

	public void jumpUp(int delta) {

		float speed = jumpSpeed * (float) delta;
		float tmpy = this.getY() + speed;
		detectCollision(this.getX(), tmpy, null);
		//	return detectCollision(this.getX(), tmpy, null);
	}

	public int detectCollision(float tmpx, float tmpy, Entity ignored) {

		for (int i = 0; i < MainGameState.objectList.size(); i++) {
			if ((!this.equals(MainGameState.objectList.get(i))) && (!MainGameState.objectList.get(i).equals(ignored)))
				if (this.getRectangle(tmpx, tmpy).intersects(MainGameState.objectList.get(i).getRectangle())) {
					MainGameState.objectList.get(i).doCollision(this);
					return 0;
				}

		}

		if ((tmpx > 0 && tmpx < 4600) && (tmpy > 0 && tmpy < 3000)) { //Within map bounds
			this.setX(tmpx);
			this.setY(tmpy);
			jumpSpeed += CConstants.GRAVITY * weight;
			return 1;
		}

		MainGameState.objectListRemove.add(this);
		return 2;
	}

	public abstract void groundCollision(Ground ground);

	public abstract void playerCollision(Player player);

	public abstract void enemyCollision(Enemy enemy);

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
