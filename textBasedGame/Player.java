package textBasedGame;

public class Player {
	private String name;
	private int health;
	private int healthPotions;
	private int coins;
	private Weapon weapon;
	private Armor armor;
	private int position;
	
	public Player(String name) {
		this.health = 100;
		this.name = name;
		this.coins = 0;
		this.healthPotions = 3;
		this.weapon = new Weapon(1, "Wooden Sword", 10);
		this.armor = new Armor(1, "Leather Tunic", 5);
		this.position = 0;
	}
	
	public void checkInventory() {
		System.out.println("Your Health is: " + this.health);
		System.out.println("You have " + this.coins +  " coins.");
		System.out.println("You have " + this.healthPotions + " health potions.");
		System.out.println("You have a level " + this.weapon.getLevel() + " " + this.weapon.getName() + " that does " + this.weapon.getAttackDamage() + " damage.");
		System.out.println("You have a level " + this.armor.getLevel() + " " + this.armor.getName() + " that has " + this.armor.getDefense() + " defense.");
	}

	public void useHealthPotion() {
		if (this.healthPotions > 0) {
			int originalHealth = this.health;
			this.health = this.health + 30;
			if (this.health > 100) {
				this.health = 100;
			}
			System.out.println("You healed yourself for "+ (100 - originalHealth) + " health.");
			this.healthPotions--;
			System.out.println("You have " + this.healthPotions + " health potions left.");
		}
		else {
			System.out.println("You have no health potions left.");
		}
		
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getHealthPotions() {
		return healthPotions;
	}

	public void setHealthPotions(int healthPotions) {
		this.healthPotions = healthPotions;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
	
	
	
	
	
	
	
}
