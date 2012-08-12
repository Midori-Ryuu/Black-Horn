package blackhorn;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public final class CAnimations {

	public Animation playerWalkingLeft;

	public Animation playerWalkingRight;
	public Animation playerStanding;
	public Animation groundStatic;

	public Animation enemyWalkingLeft;
	public Animation enemyWalkingRight;
	public Animation enemyStanding;
	
	public Animation bulletStatic;

	public void init() throws SlickException{

		playerWalkingLeft = new Animation();
		enemyStanding = new Animation();
		groundStatic = new Animation();
		bulletStatic = new Animation();
		playerStanding = new Animation();
		playerWalkingRight = new Animation();
		playerStanding.addFrame(new Image("data/playerS1.png"), 500);
		playerWalkingLeft.addFrame(new Image("data/playerL2.png"), 500);
		playerWalkingLeft.addFrame(new Image("data/playerL1.png"), 500);
		playerWalkingLeft.addFrame(new Image("data/playerL3.png"), 500);
		playerWalkingLeft.addFrame(new Image("data/playerL1.png"), 500);
		playerWalkingLeft.setLooping(true);
		playerWalkingRight.addFrame(new Image("data/playerR2.png"), 500);
		playerWalkingRight.addFrame(new Image("data/playerR1.png"), 500);
		playerWalkingRight.addFrame(new Image("data/playerR3.png"), 500);
		playerWalkingRight.addFrame(new Image("data/playerR1.png"), 500);
		playerWalkingRight.setLooping(true);
		
		enemyStanding.addFrame(new Image("data/GrueBloodyGrin.png"), 1000);

		groundStatic.addFrame(new Image("data/rocks2.png"), 1000);
		
		bulletStatic.addFrame(new Image("data/bullet.png"),1000);

	}

	//	public static Animation getCurrentAnimation(Player player) {
	//		return playerStanding;
	//	}
	//
	//	public static Animation getCurrentAnimation(Enemy enemy) {
	//		return enemyStanding;
	//	}
	//
	//	public static Animation getCurrentAnimation(Ground ground) {
	//		return groundStatic;
	//	}

	public Animation getCurrentAnimation(Entity entity) {
		if (entity instanceof Enemy)
			return enemyStanding;
		if (entity instanceof Ground)
			return groundStatic;
		if (entity instanceof Player)
			return playerStanding;
		if (entity instanceof Bullet)
			return bulletStatic;
		else
			return null;

	}
}
