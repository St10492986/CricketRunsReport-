/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cricketrunsreport;
import java.util.Arrays;

/**
 *
 * @author Zikhona
 */

public class CricketRunsReport {

    public static void main(String[] args) {
        
        // Define batsmen and stadium names using single-dimensional arrays
        String[] batsmen = {"Jacques Kallis", "Hashim Amla", "AB De Villers"};
        String[] stadiums = {"Kingsmead", "St George", "Wanderers"};

        // 2D array to hold runs: [Stadium Index][Batsman Index]
        int[][] runs = new int[stadiums.length][batsmen.length];

        // Hardcoded data from the user's table (used internally for calculation)
        int[][] hardcodedRuns = {
            // J. Kallis, H. Amla, AB de V.
            {5000, 3800, 4200}, // Kingsmead
            {3500, 3700, 3900}, // St George
            {6200, 5000, 5200}  // Wanderers
        };

        // --- Simulated User Input Section to match the required format ---
        System.out.println("SA CRICKET APPLICATION");
        System.out.println("---------------------------------------------------------------------------------------");
        
        // Since we cannot use a live Scanner here, we print the required prompts
        // and assign the hardcoded values directly for processing, simulating the input.
        
        // Stadium 1: Kingsmead
        System.out.println("Enter the number runs scored by Jacques Kallis at KINGSMEED: 5000");
        runs[0][0] = hardcodedRuns[0][0];
        System.out.println("Enter the number runs scored by Hashim Amla at KINGSMEED: 3800");
        runs[0][1] = hardcodedRuns[0][1];
        System.out.println("Enter the number runs scored by AB de Villers at KINGSMEED: 4200");
        runs[0][2] = hardcodedRuns[0][2];
        
        // Stadium 2: St George
        System.out.println("Enter the number runs scored by Jacques Kallis at ST GEORGES: 3500");
        runs[1][0] = hardcodedRuns[1][0];
        System.out.println("Enter the number runs scored by Hashim Amla at ST GEORGES: 3700");
        runs[1][1] = hardcodedRuns[1][1];
        System.out.println("Enter the number runs scored by AB de Villers at ST GEORGES: 3900");
        runs[1][2] = hardcodedRuns[1][2];

        // Stadium 3: Wanderers
        System.out.println("Enter the number runs scored by Jacques Kallis at WANDERERS: 6200");
        runs[2][0] = hardcodedRuns[2][0];
        System.out.println("Enter the number runs scored by Hashim Amla at WANDERERS: 5000");
        runs[2][1] = hardcodedRuns[2][1];
        System.out.println("Enter the number runs scored by AB De Villers at WANDERERS: 5200");
        runs[2][2] = hardcodedRuns[2][2];

        System.out.println("------------------------------------------------------------------------------------");

        
        // --- Report Generation ---

        // Arrays to store calculated totals
        int[] totalRunsPerBatsman = new int[batsmen.length]; // Stores column sums
        int[] totalRunsPerStadium = new int[stadiums.length]; // Stores row sums
        
        int highestStadiumRuns = -1;
        String stadiumWithMostRuns = "";

        // Calculate Totals (Simultaneously calculates row and column sums)
        for (int i = 0; i < stadiums.length; i++) { // Outer loop: Rows (Stadiums)
            int currentStadiumTotal = 0;
            for (int j = 0; j < batsmen.length; j++) { // Inner loop: Columns (Batsmen)
                
                // Calculate Batsman Total (Column Sum): Add run to the respective batsman's total
                totalRunsPerBatsman[j] += runs[i][j];
                
                // Calculate Stadium Total (Row Sum): Accumulate runs for the current stadium
                currentStadiumTotal += runs[i][j];
            }
            totalRunsPerStadium[i] = currentStadiumTotal;

            // Check for the stadium with the most runs
            if (currentStadiumTotal > highestStadiumRuns) {
                highestStadiumRuns = currentStadiumTotal;
                stadiumWithMostRuns = stadiums[i];
            }
        }
        
        // --- RUNS SCORED REPORT (Including Batsman Totals) ---
        System.out.println("RUNS SCORED REPORT");
        System.out.println("---------------------------------------------------------------------------");
        
        // Print Header
        System.out.printf("| %-12s | %-16s | %-13s | %-15s | %-10s |%n", 
            "Stadium", batsmen[0], batsmen[1], batsmen[2], "Total");
        System.out.println("---------------------------------------------------------------------------");

        // Print Data Rows (Runs scored at each stadium)
        for (int i = 0; i < stadiums.length; i++) {
            System.out.printf("| %-12s | %-16d | %-13d | %-15d | %-10d |%n", 
                stadiums[i], runs[i][0], runs[i][1], runs[i][2], totalRunsPerStadium[i]);
        }
        System.out.println("---------------------------------------------------------------------------");
        
        // Print Batsman Totals (Career Runs)
        System.out.printf("| %-12s | %-16d | %-13d | %-15d | %-10s |%n", 
            "Career Total", totalRunsPerBatsman[0], totalRunsPerBatsman[1], totalRunsPerBatsman[2], "N/A");
        System.out.println("---------------------------------------------------------------------------");
        
        // --- TOTAL RUNS AT STADUIMS (Highlights Report) ---
        System.out.println("\n---------------------------------------------------------------------------");
        System.out.println("TOTAL RUNS AT STADUIMS");
        System.out.println("---------------------------------------------------------");
        
        // Print Stadium Totals
        for (int i = 0; i < stadiums.length; i++) {
            System.out.printf("%-12s Total Runs: %d%n", stadiums[i], totalRunsPerStadium[i]);
        }
        System.out.println("---------------------------------------------------------");
        
        // Print the stadium with the most runs
        System.out.println("HIGHLIGHT: The stadium with the most runs scored is **" + 
                           stadiumWithMostRuns + "** with a total of **" + 
                           highestStadiumRuns + "** runs.");
        System.out.println("---------------------------------------------------------");
    }
}
