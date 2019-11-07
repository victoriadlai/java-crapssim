//Victoria Lai 49451704
//Michael Monh 66687082


package lab2;

import java.util.Random;

public class CrapsGame {
	
	//Default attributes for CrapsGame
	
	private int numRolls;
	private CrapsMetricsMonitor crapsMetricsMonitor;
	int pointNumber;
	
	
	
	//Constructor for CrapsGame -- initializes class fields 
	public CrapsGame(CrapsMetricsMonitor monitor) {
		this.numRolls = 0;
		this.crapsMetricsMonitor = monitor;
	}
	
	
	
	//Method that runs the algorithm for the game
	public boolean playGame() {
		Random r = new Random();
		this.numRolls = 0;
		
			//For each game; while loop for each game played
			while(true) {
				
				//rolls 2 dies
				int diceRoll1 = r.nextInt(6) + 1;
				int diceRoll2 = r.nextInt(6) + 1;
				int diceRollTotal = diceRoll1 + diceRoll2;
				this.numRolls++;
				
				//update number of max rolls in statistics
				if (crapsMetricsMonitor.getMaxRolls() < numRolls) {
					crapsMetricsMonitor.setMaxRolls(numRolls);
				}
				
				System.out.println("Rolled a " + diceRollTotal);
				
				//checks first roll of a game
				if (this.numRolls == 1) {
					if (diceRollTotal == 7 || diceRollTotal == 11) {
						System.out.println("*****Natural! You win!*****");
						
						//update number of naturals in statistics
						crapsMetricsMonitor.setNaturalRolls(crapsMetricsMonitor.getNaturalRolls() + 1);
						
						return true;
					}
					 	
					else if (diceRollTotal == 2 || diceRollTotal == 3 || diceRollTotal == 12) {
						System.out.println("*****Craps! You lose.*****");
						
						//update number of craps in statistics
						crapsMetricsMonitor.setCrapsRolls(crapsMetricsMonitor.getCrapsRolls() + 1);
						
						return false;
					}
					
					else {
						pointNumber = diceRollTotal;
					}
				}
				
				//checks 2nd roll and on of a game
				else if (this.numRolls > 1) {
					if (diceRollTotal == pointNumber) {		
						System.out.println("*****Rolled the point! You win!*****");
						
						return true;
					}
					
					else if (diceRollTotal == 7) {
						System.out.println("*****Crap out! You lose.*****");
						
						//update number of craps in statistics
						crapsMetricsMonitor.setCrapsRolls(crapsMetricsMonitor.getCrapsRolls() + 1);
						
						return false;
					}
				} 
			} //end of while loop
	} //end of method
} // end of class
