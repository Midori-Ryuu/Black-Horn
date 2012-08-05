package blackhorn;

public class Character extends MovableEntity {

	private float health;
	private float armor;
	private float damage;
	private float attackSpeed;

	public Character(float x, float y, float health, float armor, float damage, float attackSpeed, float sideSpeed, float rotation) {
		super(x, y, sideSpeed, rotation);

		this.health = health;
		this.armor=armor;
		this.damage=damage;
		this.attackSpeed=attackSpeed;
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
}
