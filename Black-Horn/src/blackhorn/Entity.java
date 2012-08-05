package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Entity {

	private Image texture;
	private float x, y;
	private float rotation;

	Entity(float x, float y,float rotation) {
		this.x = x;
		this.y = y;
		this.rotation = rotation;
	}

	public void init(GameContainer gc) throws SlickException {
	}

	public void update(GameContainer gc, int delta) throws SlickException {
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		texture.draw(x, y);
	}

	public Entity detectCollision(float tmpx, float tmpy, Entity ignored) {

		for (int i = 0; i < MainGameState.objectList.size(); i++) {
			if ((!this.equals(MainGameState.objectList.get(i))) && (!MainGameState.objectList.get(i).equals(ignored)))
				if (this.getRectangle(tmpx, tmpy).intersects(MainGameState.objectList.get(i).getRectangle()))
					return MainGameState.objectList.get(i);
		}

		if ((tmpx > 0 && tmpx < 4600) && (tmpy > 0 && tmpy < 3000)) { //Within map bounds
			this.setX(tmpx);
			this.setY(tmpy);
			return null;
		}

		return MainGameState.fakeentity;
	}

	public Rectangle getRectangle() {
		return new Rectangle(this.x, this.y, this.texture.getWidth(), this.texture.getHeight());
	}

	public Rectangle getRectangle(float tmpx, float tmpy) {
		return new Rectangle(tmpx, tmpy, this.texture.getWidth(), this.texture.getHeight());
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Image getTexture() {
		return texture;
	}

	public void setTexture(Image texture) {
		this.texture = texture;
	}

	public float getRotation() {
		return rotation;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

}
