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
						   new Enemy("Skeleton", 80, 10), 
						   new Enemy("Spider", 60, 40),
						   new Enemy("Barbarian", 100, 20)};
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
		System.out.println("What will you do?");
		System.out.println("1. Continue and fight; 2. Check inventory; 3. Back out; 4. Use a health potion");
		while (running) {
			String choice = IN.next();
			if (choice.equals("1")) {
				System.out.println((rand.nextInt(5)+1) + " " + enemies[player.getPosition()-1].getType() + "s have appeared.");
			}
			else if (choice.equals("2")) {
				player.checkInventory();
				running = false;
			}
			else if (choice.equals("3")) {
				player.setPosition(0);
				running = false;
			}
			else if (choice.equals("4")) {
				player.useHealthPotion();
				running = false;
			}
			else {
				System.out.println("Invalid Command, try again:");
			}
			
		}
		
	}
}