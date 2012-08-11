package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public abstract class Entity {

	private Image texture;
	private float x, y;
	private float rotation;
	Rectangle rectangle;

	Entity(float x, float y, float rotation) {
		this.x = x;
		this.y = y;
		this.rotation = rotation;
		rectangle = new Rectangle(x, y, 100, 100);

	}

	public void init(GameContainer gc) throws SlickException {
	}

	public void update(GameContainer gc, int delta) throws SlickException {
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		texture.draw(x, y);
	}

	public abstract void doCollision(MovableEntity movableEntity);

	public Rectangle getRectangle() {
		//return new Rectangle(this.x, this.y, this.texture.getWidth(), this.texture.getHeight());
		//if (texture != null)
			
			//rectangle.setBounds(x, y, this.texture.getWidth(), this.texture.getHeight());
		rectangle.setX(x);
		rectangle.setY(y);
		return rectangle;
	}

	public Rectangle getRectangle(float tmpx, float tmpy) {
		//return new Rectangle(tmpx, tmpy, this.texture.getWidth(), this.texture.getHeight());
		//if (texture != null)
			//rectangle.setBounds(tmpx, tmpy, this.texture.getWidth(), this.texture.getHeight());
		
		rectangle.setX(tmpx);
		rectangle.setY(tmpy);
			
		return rectangle;
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
