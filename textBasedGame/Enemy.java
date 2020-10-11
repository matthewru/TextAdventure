package textBasedGame;

public class Enemy {
	String type;
	int health;
	int damage;
	public Enemy(String type, int health, int damage) {
		this.type = type;
		this.health = health;
		this.damage = damage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	
	
	
	
	
}
