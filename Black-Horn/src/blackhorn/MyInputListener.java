package blackhorn;

import org.newdawn.slick.Input;
import org.newdawn.slick.InputListener;

public class MyInputListener implements InputListener {

	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
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

		switch (key) {
		case Input.KEY_RIGHT:
			MainGame.player.setSideSpeed(CConstants.PLAYER_SPEED);
			MainGameState.animationList.getCurrentAnimation(MainGame.player);
			break;

		case Input.KEY_LEFT:
			MainGame.player.setSideSpeed(-CConstants.PLAYER_SPEED);
			MainGameState.animationList.getCurrentAnimation(MainGame.player);
			break;

		case Input.KEY_UP:
			if (!MainGame.player.isJumping()) {
				MainGame.player.setJumpSpeed(-CConstants.PLAYER_JUMP_SPEED);
				MainGame.player.setJumping(true);
			}
			break;

		case Input.KEY_SPACE:
			//	if (!MainGame.player.isJumping())
			if (!MainGame.player.hasFired())
				MainGame.player.fireWeapon(MainGame.container);
			MainGame.player.setHasFired(true);
			break;

		case Input.KEY_ESCAPE:
			MainGame.game.enterState(Math.abs(1 - MainGame.game.getCurrentStateID()));
			break;

		default:
			break;

		}

	}

	@Override
	public void keyReleased(int key, char c) {

		if (key == Input.KEY_RIGHT)
		{
			MainGame.player.setSideSpeed(0f);
			MainGameState.animationList.getCurrentAnimation(MainGame.player);
		}
		else if (key == Input.KEY_LEFT)
		{
			MainGame.player.setSideSpeed(0f);
			MainGameState.animationList.getCurrentAnimation(MainGame.player);
		}
		else if (key == Input.KEY_SPACE)
			MainGame.player.setHasFired(false);
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
