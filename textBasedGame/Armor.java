package textBasedGame;

public class Armor {
	private int level;
	private String name;
	private int defense;
	
	public Armor(int level, String name, int defense) {
		this.level = level;
		this.name = name;
		this.defense = defense;
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

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	
	
}
