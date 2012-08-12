package blackhorn;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public abstract class Character extends MovableEntity {

	private float health;
	private float armor;
	private float damage;
	private float attackSpeed;

	public Character(float x, float y, float health, float armor, float damage, float attackSpeed, float sideSpeed, float rotation, float jumpSpeed, float weight) {
		super(x, y, sideSpeed, rotation, jumpSpeed, weight);

		this.health = health;
		this.armor = armor;
		this.damage = damage;
		this.attackSpeed = attackSpeed;
	}

	public void init(GameContainer gc) throws SlickException {
		super.init(gc);
	}

	public void render(GameContainer gc, Graphics g) throws SlickException {
		super.render(gc, g);
	}

	public void takeDamage(int damage) {

		health -= damage;
		if (health <= 0) {
			MainGameState.objectListRemove.add(this); // if player is dead remove from list
		}
	}

	public float getDamage() {
		return damage;
	}

	public void setDamage(float damage) {
		this.damage = damage;
	}

	public float getArmor() {
		return armor;
	}

	public void setArmor(float armor) {
		this.armor = armor;
	}

	public float getAttackspeed() {
		return attackSpeed;
	}

	public void setAttackspeed(float attackspeed) {
		this.attackSpeed = attackspeed;
	}

	public void bulletCollision(Bullet bullet) {
		MainGameState.objectListRemove.add(this);
		MainGameState.objectListRemove.add(bullet);

	}
}
