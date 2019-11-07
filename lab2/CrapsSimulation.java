//Victoria Lai 49451704
//Michael Monh 66687082

package lab2;

import java.util.Scanner;

public class CrapsSimulation {
	
	//Default attributes of the CrapsSimulation
	private CrapsGame crapsGame;
	private CrapsMetricsMonitor crapsMetricsMonitor;
	private String name;
	private int balance;
	private int bet;
	private int currentWinStreak;
	private int currentLoseStreak;
	private Scanner s;
	
	
	
	//Constructor for CrapsSimulation -- initializes all fields and sets default values
	public CrapsSimulation() {
		this.crapsMetricsMonitor = new CrapsMetricsMonitor();
		this.crapsGame = new CrapsGame(this.crapsMetricsMonitor);
		this.name = " ";
		this.balance = 0;
		this.bet = 0;
		this.currentWinStreak = 0;
		this.currentLoseStreak = 0;
		this.s = new Scanner(System.in);
	}
	
	
	
	//Getters for CrapsSimulation -- gets values from private variables
	public CrapsGame getCrapsGame() {
		return crapsGame;
	}
	
	public CrapsMetricsMonitor getCrapsMetricsMonitor() {
		return crapsMetricsMonitor;
	}
	
	public String getName() {
		return name;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public int getBet() {
		return bet;
	}
	
	public int getCurrentWinStreak() {
		return currentWinStreak;
	}
	
	public int getCurrentLoseStreak() {
		return currentLoseStreak;
	}
	
	
	
	//Setters for CrapsSimulation -- sets new values for variables
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}
		
	public void setCurrentWinStreak(int streak) {
		currentWinStreak = streak;
	}
	
	public void setCurrentLoseStreak(int streak) {
		currentLoseStreak = streak;
	}
	
	
	
	//Main loop for single simulation run.
	//Start method for CrapsSimulation -- asks for user details, ensures user makes a valid bet, begins the game, 
	// asks if the user would like to play again, and resets the game statistics for a clean slate
	public void start() {
		while(true){
			
			System.out.print("Welcome to SimCraps! Enter your user name: ");
			this.setName(s.nextLine());
			
			System.out.println("Hello " + getName() + "!");
			
			System.out.print("Enter the amount of money you will bring to the table: ");
			setBalance(Integer.parseInt(s.nextLine()));
			
			System.out.print("Enter the bet amount between $1 and $" + getBalance() + ": ");
			
			// Check if user's bet input is valid
			while(true){
				
				try{
					setBet(Integer.parseInt(s.nextLine()));
					
					if(getBet() >= 1 && getBet() <= getBalance()){
						break;
					}
					else {
						System.out.print("Invalid bet! Please enter a bet between $1 and $" + getBalance() + ": ");
					}
				}
				
				catch (Exception e) {
					System.out.print("Invalid bet! Please enter a bet between $1 and $" + getBalance() + ": ");
				}
					
			}
			
			int originalBet = getBet();
			
			//Whole simulation; while loop for one simulation
			while (getBalance() != 0) {
				
				//updates number of games played in statistics
				crapsMetricsMonitor.setGamesPlayed(crapsMetricsMonitor.getGamesPlayed() + 1);
				
				//updates max balance and the game number when the max balance occurred
				if (getBalance() > crapsMetricsMonitor.getMaxBalance()) {
					crapsMetricsMonitor.setMaxBalance(getBalance());
					crapsMetricsMonitor.setGameNumberOfMaxBalance(crapsMetricsMonitor.getGamesPlayed());
				}
				
				if (getBet() > getBalance()) {
					setBet(getBalance());
				}
				
				System.out.println(getName() + " bets $" + getBet());
		
				//runs the games of the simulation
				if(this.crapsGame.playGame() == true) {
					setBalance(getBalance() + getBet());
					
					//update number of games won in statistics
					crapsMetricsMonitor.setGamesWon(crapsMetricsMonitor.getGamesWon() + 1);
					
					//update current win streak
					setCurrentWinStreak(getCurrentWinStreak() + 1);
					
					//update max win streak in statistics
					if (getCurrentWinStreak() > crapsMetricsMonitor.getMaxWinStreak()) {
						crapsMetricsMonitor.setMaxWinStreak(getCurrentWinStreak()); 
					}
					
					//cancel lose streak by resetting current lose streak to 0
					setCurrentLoseStreak(0);
					
				}
				else{
					setBalance(getBalance() - getBet());
					
					//update number of games lost in statistics
					crapsMetricsMonitor.setGamesLost(crapsMetricsMonitor.getGamesLost() + 1);
					
					//update current lose streak
					setCurrentLoseStreak(getCurrentLoseStreak() + 1);
					
					//update max lose streak in statistics
					if (getCurrentLoseStreak() > crapsMetricsMonitor.getMaxLoseStreak()) {
						crapsMetricsMonitor.setMaxLoseStreak(getCurrentLoseStreak()); 
					}
					
					//cancel win streak by resetting current win streak to 0
					setCurrentWinStreak(0);
				}
			
				//print out the balance after each game
				if (getBalance() != 0){
					System.out.println(getName() + "'s balance: " + getBalance() + ". Playing a new game...");
					
					if (getBet() > getBalance()) {
						setBet(getBalance());
					}
				}
			
				setBet(originalBet);
			}
	
			//print out balance at the very end
			System.out.println(getName() + "'s balance: " + getBalance() + ".");
			
			//prints statistics of the simulation
			this.crapsMetricsMonitor.printStatistics();
			
			//ask user if they would like to play another game
			System.out.print("Replay? Enter 'y' or 'n': ");

			if (s.nextLine().equals("n")) {
				break;
			}
			
			//reset statistics if user wishes to play again
			this.crapsMetricsMonitor.reset();
			System.out.println(); //add a new line for formatting purposes
		}
		
		//closes Scanner object
		s.close();
	}

}
