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
		super.init(container);
		this.setTexture(new Image("/data/selection tool.png"));
		this.getTexture().setRotation(this.getRotation());

	}

}
