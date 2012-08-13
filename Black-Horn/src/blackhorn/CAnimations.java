package blackhorn;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public final class CAnimations {

	// Player walking left
	Image playerWL1;
	Image playerWL2;
	Image playerWL3;
	Image[] playerWL;

	// Player walking right
	;
	// Image("data/playerWL1.png"),new Image("data/playerWL1.png")};
	Image playerWR1;
	Image playerWR2;
	Image playerWR3;
	Image[] playerWR;

	// Player standing
	Image[] playerS;

	// Enemy standing
	Image[] enemyS;
	
	//Ground
	Image[] groundS;
	
	//Bullet
	Image[] bulletS;

	public void init() throws SlickException {

		playerWL1 = new Image("data/playerWL1.png");
		playerWL2 = new Image("data/playerWL2.png");
		playerWL3 = new Image("data/playerWL3.png");

		playerWR1 = new Image("data/playerWR1.png");
		playerWR2 = new Image("data/playerWR2.png");
		playerWR3 = new Image("data/playerWR3.png");

		playerS = new Image[] {new Image("data/playerS1.png")};
		enemyS = new Image[] {new Image("data/enemyS1.png")};
		groundS = new Image[] {new Image("data/groundS.png")};
		bulletS = new Image[] {new Image("data/bulletS.png")};

		playerWL = new Image[] { playerWL2, playerWL1, playerWL3, playerWL1 };
		playerWR = new Image[] { playerWR2, playerWR1, playerWR3, playerWR1 };
	}

	public void getCurrentAnimation(Player player) {
		if(player.getSideSpeed()<0)
			player.setCurrentAnimation(new Animation(playerWL, 500));
		else
			if(player.getSideSpeed()>0)
				player.setCurrentAnimation(new Animation(playerWR, 500));
			else if(player.getSideSpeed()==0)
				player.setCurrentAnimation(new Animation(playerS, 500));
	}

	public void getCurrentAnimation(Enemy enemy) {

		enemy.setCurrentAnimation(new Animation(enemyS, 500));
	}

	public void getCurrentAnimation(Ground ground) {

		ground.setCurrentAnimation(new Animation(groundS, 500));
	}

	public void getCurrentAnimation(Bullet bullet) {
		bullet.setCurrentAnimation(new Animation(bulletS, 500));
	}

}
