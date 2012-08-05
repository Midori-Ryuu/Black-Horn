package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Player extends Character {

	public Player(float x, float y) {
		super(x, y, 1, 1, 1, 1, 0, CConstants.ROTATION_RIGHT);

	}
	
	public void init(GameContainer container) throws SlickException {
		super.init(container);
		this.setTexture(new Image("/data/valyrie.png"));
		this.getTexture().setRotation(this.getRotation());

	}

	public void update(GameContainer container, int delta) throws SlickException {
		super.update(container, delta);
		
	}

	public void fireWeapon(GameContainer gc) {

		Bullet bullet = new Bullet(this.getRectangle().getCenterX(), this.getRectangle().getCenterY(), this); // spawn a bullet in front of player
		try {
			bullet.init(gc);
		} catch (SlickException e) {
			e.printStackTrace();
		} // give bullet texture
		MainGameState.objectList.add(bullet); // add bullet to player spawned object list for update and rendering
	}

	public float getAttackSpeed() {
		return getAttackspeed();
	}

	public void setAttackSpeed(int attackspeed) {
		this.setAttackspeed(attackspeed);
	}

}
