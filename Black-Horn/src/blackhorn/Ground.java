package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Ground extends Entity {

	public Ground(float x, float y, float rotation) {
		super(x, y, rotation);
		// TODO Auto-generated constructor stub
	}

	public void init(GameContainer container) throws SlickException {

		//this.setTexture(new Image("/data/rocks2.png"));
		//this.getTexture().setRotation(this.getRotation());
		super.init(container);
	}

	@Override
	public void doCollision(MovableEntity entity) {
		entity.groundCollision(this);

	}

}
