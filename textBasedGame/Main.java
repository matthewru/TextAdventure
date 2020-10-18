package textBasedGame;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	//print maps
	public static void printMap(String[][] maps, int index) {
		for (int i = 0; i < maps[index].length; i++) {
			System.out.println(maps[index][i]);
		}
	}

	public static void main(String[] args) {
		
		//system objects
		Scanner IN = new Scanner(System.in);
		Random rand = new Random();
		
		//initial inputs
		System.out.println("Enter your player name: ");
		String playerName = IN.next();
		
		//dungeon variables
		String[][] maps = {{"     []      ", 
							"     ||      ",
							"[]===[x]===[]",
							"     ||      ",
							"     []      "},
						   {"     [x]      ", 
							"     ||      ",
							"[]===[]===[]",
							"     ||      ",
							"     []      "},
						   {"     []      ", 
							"     ||      ",
							"[]===[]===[x]",
							"     ||      ",
							"     []      "},
						   {"     []      ", 
							"     ||      ",
							"[]===[]===[]",
							"     ||      ",
							"     [x]      "},
						   {"     []      ", 
							"     ||      ",
							"[x]===[]===[]",
							"     ||      ",
							"     []      "}};
		Enemy[] enemies = {new Enemy("Zombie", 100, 7), 
						   new Enemy("Skeleton", 80, 4), 
						   new Enemy("Spider", 60, 7),
						   new Enemy("Barbarian", 100, 5)};
		boolean running = true;
				
		//game objects
		Player player = new Player(playerName);
		
		//game start
		System.out.println("###---Welcome to the Dungeon---###");
		System.out.println("----------------------------------");
		printMap(maps, 0);
		System.out.println("You fall into the dungeon at grab the Wooden Sword, Leather Tunic, and 3 Health Potions on the ground.");
		System.out.println("You notice you have the option of going forward, right, backward, or left, which way do you travel?");
		System.out.println("1. Forward; 2. Right; 3. Backward; 4. Left;");
		while (running) {
			String choice = IN.next();
			if (choice.equals("1")) {
				player.setPosition(1);
				printMap(maps, 1);
				System.out.println("You have entered the Zombie room.");
				running = false;
			}
			else if (choice.equals("2")) {
				player.setPosition(2);
				printMap(maps, 2);
				System.out.println("You have entered the Skeleton room.");
				running = false;
			}
			else if (choice.equals("3")) {
				player.setPosition(3);
				printMap(maps, 3);
				System.out.println("You have entered the Spider room.");
				running = false;
			}
			else if (choice.equals("4")) {
				player.setPosition(4);
				printMap(maps, 4);
				System.out.println("You have entered the Barbarian room.");
				running = false;
			}
			else {
				System.out.println("Invalid Command, try again:");
			}
		}
		running = true;
		boolean dead = false;
		while (running) {
			if (dead) {
				break;
			}
			System.out.println("What will you do?");
			System.out.println("1. Continue and fight; 2. Check inventory; 3. Back out; 4. Use a health potion");
			String choice = IN.next();
			if (choice.equals("1")) {
				int numEnemies = rand.nextInt(5)+1;
				Enemy enemy = enemies[player.getPosition()-1];
				int enemyOrigHealth = enemy.getHealth();
				boolean fight = true;
				System.out.println(numEnemies + " " + enemy.getType() + "s have appeared.");
				while (fight) {
					if (dead) {
						break;
					}
					System.out.println("1. Fight; 2. Check inventory; 3. Flee; 4. Use a health potion");
					String option = IN.next();
					if (option.equals("1")) {
						while (numEnemies > 0) {
							if (dead) {
								break;
							}
							while (enemy.getHealth() > 0) {
								int damageDone = player.getWeapon().getAttackDamage()+10;
								int receivingDamage = enemy.getDamage();
								enemy.setHealth(enemy.getHealth() - damageDone);
								System.out.println("You attack, dealing " + damageDone + " damage. The enemy has " + enemy.getHealth() + " health left.");
								player.setHealth(player.getHealth() - receivingDamage);
								System.out.println("You sustain " + receivingDamage + " damage from the enemy. You have " + player.getHealth() + " health left.");
								if (player.getHealth() <= 0) {
									System.out.println("Game Over, you died.");
									dead = true;
									break;
								}
								if (enemy.getHealth() <= 0) {
									System.out.println("You defeated and enemy");
									numEnemies -= 1;
								}
							}
							enemy.setHealth(enemyOrigHealth);
							if (numEnemies <= 0) {
								int coinsEarned = rand.nextInt(200);
								int healthPotionsEarned = rand.nextInt(5);
								System.out.println("You've beaten the dungeon!");
								System.out.println("From this room you have earned: ");
								System.out.println(coinsEarned + " coins.");
								System.out.println(healthPotionsEarned + " health potions.");
								System.out.println("You leave the dungeon with your riches.");
								fight = false;
								running = false;
							}
						}
					}
					else if (option.equals("2")) {
						player.checkInventory();
					}
					else if (option.equals("3")) {
						System.out.println("You leave the dungeon, the door closing behind you having you unable to return.");
						fight = false;
						running = false;
					}
					else if (option.equals("4")) {
						player.useHealthPotion();
					}
				}
			}
			else if (choice.equals("2")) {
				player.checkInventory();
			}
			else if (choice.equals("3")) {
				player.setPosition(0);
				System.out.println("You find yourself out of the dungeon, running away like a coward.");
				System.out.println("You escape while your inventory looks like this: ");
				player.checkInventory();
				running = false;
			}
			else if (choice.equals("4")) {
				player.useHealthPotion();
			}
			else {
				System.out.println("Invalid Command, try again:");
			}
			
		}
		
	}
}