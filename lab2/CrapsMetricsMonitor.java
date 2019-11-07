//Victoria Lai 49451704
//Michael Monh 66687082

package lab2;

public class CrapsMetricsMonitor {
	
	//Default Attributes of a CrapsMetricsMonitor
	private int gamesPlayed;
	private int gamesWon;
	private int gamesLost;
	private int maxRolls;
	private int naturalRolls;
	private int crapsRolls;
	private int maxWinStreak;
	private int maxLoseStreak;
	private int maxBalance;
	private int gameNumberOfMaxBalance;
	
	
	
	//Constructor for CrapsMetricsMonitor -- initializes fields
	// initialize fields to zero - use the reset method
	public CrapsMetricsMonitor() {
		this.reset();
	}
	
	
	
	//Getters for CrapsMetricsMonitor
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public int getGamesWon() {
		return gamesWon;
	}
	
	public int getGamesLost() {
		return gamesLost;
	}
	
	public int getMaxRolls() {
		return maxRolls;
	}
	
	public int getNaturalRolls() {
		return naturalRolls;
	}
	
	public int getCrapsRolls() {
		return crapsRolls;
	}
	
	public int getMaxWinStreak() {
		return maxWinStreak;
	}
	
	public int getMaxLoseStreak() {
		return maxLoseStreak;
	}
	
	public int getMaxBalance() {
		return maxBalance;
	}
	
	public int getGameNumberOfMaxBalance() {
		return gameNumberOfMaxBalance;
	}
	
	
	
	//Setters for Craps Metrics Monitor
	
	public void setGamesPlayed(int games) {
		gamesPlayed = games;
	}
	
	public void setGamesWon(int won) {
		gamesWon = won;
	}
	
	public void setGamesLost(int lost) {
		gamesLost = lost;
	}
	
	public void setMaxRolls(int roll) {
		maxRolls = roll;
	}
	
	public void setNaturalRolls(int natural) {
		naturalRolls = natural;
	}
	
	public void setCrapsRolls(int crap) {
		crapsRolls = crap;
	}
	
	public void setMaxWinStreak(int win) {
		maxWinStreak = win;
	}
	
	public void setMaxLoseStreak(int lose) {
		maxLoseStreak = lose;
	}
	
	public void setMaxBalance(int balance) {
		maxBalance = balance;
	}
	
	public void setGameNumberOfMaxBalance(int game) {
		gameNumberOfMaxBalance = game;
	}
	
	
	
	//Prints all statistics for the simulation
	public void printStatistics() {
		System.out.println();
		System.out.println("*****************************");
		System.out.println("*** SIMULATION STATISTICS ***");
		System.out.println("*****************************");
		System.out.println("Games played: " + getGamesPlayed());
		System.out.println("Games won: " + getGamesWon());
		System.out.println("Games lost: " + getGamesLost());
		System.out.println("Maximum Rolls in a single game: " + getMaxRolls());
		System.out.println("Natural Count: " + getNaturalRolls());
		System.out.println("Craps Count: " + getCrapsRolls());
		System.out.println("Maximum Winning Streak: " + getMaxWinStreak());
		System.out.println("Maximum Losing Streak: " + getMaxLoseStreak());
		System.out.println("Maximum balance: " + getMaxBalance() + " during game " + getGameNumberOfMaxBalance());
		System.out.println();
	}
	
	
	
	//Resets the state of the CrapsMetricsMonitor object -- all fields = 0
	public void reset() {
		setGamesPlayed(0);
		setGamesWon(0);
		setGamesLost(0);
		setMaxRolls(0);
		setNaturalRolls(0);
		setCrapsRolls(0);
		setMaxWinStreak(0);
		setMaxLoseStreak(0);
		setMaxBalance(0);
		setGameNumberOfMaxBalance(0);
	}
	
	
	
	
	
	
	
}
