import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
import java.util.ArrayList;


public class main {
	
	public static void OceanMap(char[][] a) {
		System.out.print("   ");
		for (int i = 0; i< a[1].length; i++) {
			System.out.print(i);
		}
		
		for (int i = 0; i < a.length; i++) {
			System.out.print("\n" + i + " |");
			for (int j = 0; j < a[i].length; j++) {
				if (a[i][j] == 0)
					System.out.print(" ");
				else
					System.out.print(a[i][j]);
			}
			System.out.print("| " + i);
		}
		
		System.out.print("\n   ");
		for (int i = 0; i< a[1].length; i++) {
			System.out.print(i);
		}
	}
	
	public static void deployPlayer(char[][] a, int numberOfDeployment) {
		Scanner s = new Scanner(System.in);
		int[] ar = new int[2];
		System.out.println("\n\nDeploy your ships");
		for (int i = 1; i<= numberOfDeployment; i++) {
			ar = enterCoordinates(i);
			while (ar[0]>=a.length || ar[1]>=a[i].length || a[ar[0]][ar[1]]!='\u0000') {
				System.out.println("Invalid Coordinate....Please try again");
				ar = enterCoordinates(i);
			}
				a[ar[0]][ar[1]] = '@';
		}
	}
	
	public static void deployComputer(char[][] a, int numberOfDeployment) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int n;
		int m;
		System.out.println("\n\nComputer is deploying ships");
		for (int i = 1; i<= numberOfDeployment; i++) {
			n = r.nextInt(a.length);
			try{
				  Thread.sleep(1000);
				}
			catch(InterruptedException ex){
				}
			m = r.nextInt(a[i].length);
			while (n>=a.length || m>=a[i].length || a[n][m]!='\u0000') {
				n = r.nextInt(a.length);
				try{
					  Thread.sleep(1000);
					}
				catch(InterruptedException ex){
					}
				m = r.nextInt(a[i].length);
			}
			System.out.println(i + ". ship DEPLOYED");
			a[n][m] = ' ';
		}
		System.out.println("++++++++++++++++++++++++");
	}
	
	public static int[] enterCoordinates(int deployNumber) {
		Scanner s = new Scanner(System.in);
		int[] ar = new int[2];
		System.out.print("Enter X coordinate for your " + deployNumber + ". ship: ");
		ar[0] = s.nextInt();
		System.out.print("Enter Y coordinate for your " + deployNumber + ". ship: ");
		ar[1] = s.nextInt();
		return ar;
	}
		
	public static void Battle(char[][] a, int numberOfDeployment ) {
		Scanner s = new Scanner(System.in);
		int turn; // 0: for player, 1 for computer
		int x;
		int y;
		int playerShips = numberOfDeployment;
		int computerShips = numberOfDeployment;
		int[] f = new int[2];
		ArrayList<Integer> computerMissed = new ArrayList<Integer>();
		Random r = new Random();
		while(!gameOver(playerShips,computerShips)) {
			x = a.length;
			y = a[0].length;
			turn = 0;
			System.out.println("YOUR TURN");	
			while (x>=a.length || y>=a[0].length) {
				System.out.print("Enter X coordinate: ");
				x = s.nextInt();
				System.out.print("Enter Y coordinate: ");
				y = s.nextInt();
			}
			f = checkHit(a,x,y, playerShips,computerShips ,turn,computerMissed);
			playerShips-= f[0];
			computerShips -= f[1];
			turn = 1;
			System.out.println("COMPUTER'S TURN");
			x = a.length;
			y = a[0].length;
			while (x>=a.length || y>=a[0].length) {
				x = r.nextInt(a.length);
				try{
					  Thread.sleep(100);
					}
				catch(InterruptedException ex){
					}
				y = r.nextInt(a[0].length);
				for (int i = 0 ; i<computerMissed.size();i++)
					if (x*a.length+y == computerMissed.get(i)) {
						x = a.length;
						y = a[0].length;
					}
			}
			f = checkHit(a,x,y,playerShips,computerShips ,turn, computerMissed);
			playerShips-= f[0];
			computerShips -= f[1];
			OceanMap(a);
			System.out.println("\n\nYour Ships: " + playerShips + " | Computer Ships: " + computerShips + "\n++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		}
		if (playerShips>computerShips) 
			System.out.println("Hooray! you win the battle :)");
		else
			System.out.println("Sorry! you lost :(");
	}
	
	public static int[] checkHit(char[][]a,int x, int y, int playerShips, int computerShips, int turn, ArrayList<Integer> computerMissed) {
		int[] aa = new int[2];
		if (turn == 0) {
			switch (a[x][y]) {	
			case '@':
				System.out.println("Oh no, you sunk your own ship :(");
				a[x][y] = 'x';
				aa[0] = 1;
				break;
			case ' ':
				System.out.println("Boom! You sunk the ship!");
				a[x][y] = '!';
				aa[1] = 1;
				break;
			case '\u0000':
				System.out.println("Sorry, you missed");
				a[x][y] = '-';
				break;
			}
		} else {
			int f = x*a.length + y;
			switch (a[x][y]) {	
			case '@':
				System.out.println("The Computer sunk one of your ships!");
				a[x][y] = 'x';
				aa[0] = 1;
				break;
			case ' ':
				System.out.println("The Computer sunk one of its own ships");
				a[x][y] = '!';
				aa[1] = 1;
				break;
			default:
				System.out.println("Computer missed");
				computerMissed.add(f);
				break;
			}
		}
		return aa;
	}
	
	
	public static boolean gameOver(int playerShips, int computerShips) {
		if (playerShips == 0 || computerShips == 0)
			return true;
		else 
			return false;
	}
	
	public static void main(String args[]) {
		int[] array = new int[10];
		array[10] = 5;
		
		System.out.println("Please enter the dimension of the map that you want");
		System.out.print("x dimension: ");
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		System.out.print("y dimension: ");
		int y =  sc.nextInt();
		char[][] dim = new char[x][y];
		System.out.println("\n\n\n**** Welcome to Battle Ships game ****\n");
		System.out.print("Right now, the sea is empty\n");
		OceanMap(dim);
		System.out.print("\n\n++++++++++++++++++++++\n How many times number of deployment should be: ");
		int z = sc.nextInt();	
		deployPlayer(dim, z);
		System.out.println("\n");
		OceanMap(dim);
		deployComputer(dim, z);
		OceanMap(dim);
		Battle(dim, z);
	}

}
