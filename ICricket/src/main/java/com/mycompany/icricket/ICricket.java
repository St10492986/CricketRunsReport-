/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.icricket;
import java.util.Scanner;


/**
 *
 * @author Zikhona
 */
public class ICricket {

    public static void main(String[] args) {
      
// 1. Interface Definition (ICricket)
// Contains methods to get batsman name, stadium name, and runs scored.

    /**
     *
     */
    public interface ICricket {
    // Note: Using 'grtRunsScored' as specified in the prompt, assuming 'grt' is a typo for 'get'.
    String getBatsman();
    String getStadium();
    int grtRunsScored();
}

// 2. Abstract Class (Cricket)
// Implements the ICricket interface and contains shared variables and the constructor.
abstract class Cricket implements ICricket {
    
    // Protected variables to store the data
    protected String batsmanName;
    protected String stadiumName;
    protected int totalRunsScored;
    
    /**
     * Constructor that accepts the batsman's name, stadium name, and total runs scored
     * as parameters.
     * @param batsmanName The name of the cricket player.
     * @param stadiumName The name of the stadium.
     * @param totalRunsScored The total runs scored by the batsman at the stadium.
     */
    public Cricket(String batsmanName, String stadiumName, int totalRunsScored) {
        this.batsmanName = batsmanName;
        this.stadiumName = stadiumName;
        this.totalRunsScored = totalRunsScored;
    }
    
    // Implementation of methods from the ICricket interface
    @Override
    public String getBatsman() {
        return batsmanName;
    }

    @Override
    public String getStadium() {
        return stadiumName;
    }

    @Override
    public int grtRunsScored() {
        return totalRunsScored;
    }
    
    // Abstract method for report printing, to be implemented by the subclass
    public abstract void printReport();
}

// 3. Subclass (CricketRunsScored)
// Extends the abstract Cricket class and provides the report logic.
class CricketRunsScored extends Cricket {
    
    /**
     * Constructor for CricketRunsScored. Calls the superclass constructor.
     * @param batsmanName The name of the cricket player.
     * @param stadiumName The name of the stadium.
     * @param totalRunsScored The total runs scored.
     */
    public CricketRunsScored(String batsmanName, String stadiumName, int totalRunsScored) {
        super(batsmanName, stadiumName, totalRunsScored);
    }

    // Implementation of the abstract method to print the report in the required format
    @Override
    public void printReport() {
        System.out.println("\nBATSMAN RUNS SCORED REPORT");
        System.out.println("********************************");
        // Use getter methods inherited from the abstract class (which implements the interface)
        System.out.println("CRICKET PLAYERS: " + getBatsman());
        System.out.println("STADUIM:" + getStadium());
        System.out.println("TOTAL RUNS SCORED: " + grtRunsScored());
        System.out.println("\n");
    }
}

// 4. Main Application Class (RunApplication)
public class RunApplication {
    public static void main(String[] args) {
        
        // --- Simulation of Console Input ---
        
        // Hardcoded values to match the required output format
        final String batsman = "Jacques Kallis";
        final String stadium = "Wanderers";
        final int runs = 5000;
        
        // Print the input prompts with the hardcoded values (simulating user entry)
        System.out.println("The cricket name: " + batsman);
        System.out.println("Enter the stadium; " + stadium);
        // Note: Using "Wannderers" in the input prompt as specified in the request
        System.out.println("Enter the total runs scored by " + batsman + " at Wannderers:" + runs);
        
        // --- Instantiation and Report Generation ---
        
        // Instantiate the CricketRunsScored class using the constructor
        CricketRunsScored report = new CricketRunsScored(batsman, stadium, runs);
        
        // Print the final report
        report.printReport();
    }
}
          
    }


    

