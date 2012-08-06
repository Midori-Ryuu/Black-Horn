package blackhorn;

public final class CConstants {

	//Speed constants
	public static final float GLOBAL_SPEED_FACTOR = 1f;
	public static final float PLAYER_SPEED = CConstants.GLOBAL_SPEED_FACTOR * 0.2f;
	public static final float PLAYER_SPEED_STOPPING = CConstants.GLOBAL_SPEED_FACTOR * 0.002f;
	public static final float PLAYER_JUMP_SPEED = CConstants.GLOBAL_SPEED_FACTOR * 0.2f;
	public static final float BULLET_SPEED = GLOBAL_SPEED_FACTOR * 0.3f;
	
	//Distance constants
	public static final float GLOBAL_DISTANCE_FACTOR = 1f;
	public static final float NORMAL_DISTANCE = CConstants.GLOBAL_DISTANCE_FACTOR * 1f;
	public static final float CLOSE_DISTANCE = CConstants.GLOBAL_DISTANCE_FACTOR * 0.1f;
	

	//Gravity constants
	public static final float GRAVITY = 0.0003f;
	public static final float PLAYER_WEIGHT = 1f;

	//Rotation constants
	public static final float ROTATION_RIGHT = 90f;
	public static final float ROTATION_LEFT = 90f;
	public static final float ROTATION_UP = 0f;
	public static final float ROTATION_DOWN = 180f;

}
