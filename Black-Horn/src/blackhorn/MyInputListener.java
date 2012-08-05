package blackhorn;

import org.newdawn.slick.Input;
import org.newdawn.slick.InputListener;

public class MyInputListener implements InputListener {

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {

		// if(clickCount==2)
		// {
		// game.enterState(Math.abs(1-game.getCurrentStateID()));
		// }

	}

	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
	}

	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {

	}

	@Override
	public void mousePressed(int button, int x, int y) {

	}

	@Override
	public void mouseReleased(int button, int x, int y) {
	}

	@Override
	public void mouseWheelMoved(int change) {

	}

	@Override
	public void inputEnded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputStarted() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAcceptingInput() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInput(Input input) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(int key, char c) {

		if (key == Input.KEY_RIGHT)
			MainGame.player.setMovementSpeed(CConstants.PLAYER_SPEED);
		else if (key == Input.KEY_LEFT)
			MainGame.player.setMovementSpeed(-CConstants.PLAYER_SPEED);
		else if(key== Input.KEY_SPACE)
			MainGame.player.fireWeapon(MainGame.container);
		else if (key == Input.KEY_ESCAPE)
			MainGame.game.enterState(Math.abs(1 - MainGame.game.getCurrentStateID()));
		
	
	}

	@Override
	public void keyReleased(int key, char c) {
		// TODO Auto-generated method stub
		if (key == Input.KEY_RIGHT)
			MainGame.player.setMovementSpeed(0f);
		else if (key == Input.KEY_LEFT)
			MainGame.player.setMovementSpeed(0f);
	}

	@Override
	public void controllerButtonPressed(int controller, int button) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerButtonReleased(int controller, int button) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerDownPressed(int controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerDownReleased(int controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerLeftPressed(int controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerLeftReleased(int controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerRightPressed(int controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerRightReleased(int controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerUpPressed(int controller) {
		// TODO Auto-generated method stub

	}

	@Override
	public void controllerUpReleased(int controller) {
		// TODO Auto-generated method stub

	}

}
