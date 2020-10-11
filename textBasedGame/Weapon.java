package textBasedGame;

public class Weapon {
	private int level;
	private String name;
	private int attackDamage;
	
	public Weapon(int level, String name, int attackDamage) {
		this.level = level;
		this.name = name;
		this.attackDamage = attackDamage;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(int attackDamage) {
		this.attackDamage = attackDamage;
	}
	
	
	
	
	
	
}
