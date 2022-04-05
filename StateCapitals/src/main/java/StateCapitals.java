/*
    This is the states capital game. A file called StateCapitals.txt 
    will be read in for a state capital pair and added to a hashmap.
    the state and capital will be seperated by '::'. After all 
    the records are read a trivia game will begin. 
*/

import java.io.*;
import java.util.*;
/**
 *
 * @author Juan B
 */
public class StateCapitals {
    
    public static void main(String[] args){
        
        // the file we read the states from 
        File usa = new File("src\\StateCapitals.txt");
         
        try{
            // the scanner that allows us to interate through the file
            Scanner in = new Scanner(usa);
            
            
            // the data structure to hold our states and capitals
            Map<String, String> theUSA = new HashMap<String,String>();
            
            // how many records were read in
            int records = 0;
            
            //read through the file populating the hashmap
            while(in.hasNextLine()){
                
                String record = in.nextLine();
                String[] stateCapital = record.split("::");
                
                theUSA.put(stateCapital[0], stateCapital[1]);
                records++;
            }
            
            //report the number of records
            System.out.println("A total of " + records + " State, Capital pairs were found.\n");
            System.out.println("The following states were found:");
            
            String[] states = new String[theUSA.size()];
            
            //print out the states found and put in an array
            int index = 0;
            for(String state: theUSA.keySet()){
                states[index] = state;
                System.out.print(state+ ((index == theUSA.size() - 1)? ".":", "));
                if(index % 11 == 0 && index > 0) System.out.println();
                index++;
            }
            
            System.out.println("\n\nWelcome to the states trivia game. A random state will show up,"
                    + " all you need to do is guess the correct capital of that state. ");
            System.out.println("Ready............ Go!");
            
            //keep track of the score and randomly play between 5 and 10 rounds
            int score = 0;
            int rounds =  5 + (int)(Math.random()* (10 - 5 + 1));
            
            // get input fromt eh console rather than the file
            in = new Scanner(System.in);
            
            for(int i = 0; i < rounds; i++){
                
                // select a random state from our set.
                int randState = (int)(Math.random()* states.length);
                
                // prompt 
                System.out.println("Round "+ (i +  1) + ": ");
                System.out.print("The state of " + states[randState] + " has a capital of: ");
                
                String guess = in.nextLine();
                
                // report on correct or incorrect answe. adjust score of correct.
                if(theUSA.get(states[randState]).equalsIgnoreCase(guess)){
                    System.out.println(guess + " is correct!");
                    score++;
                }
                else{
                    System.out.println(guess + " is not the capital of " + states[randState]);
                }
                
            }
            
            //report the player on how they did
            System.out.println("You scored " + score + " out of " + rounds);
            
        }
        
        catch(FileNotFoundException fnf){
            
            System.out.println("File was not found.");
        }
        
        catch(Exception e){
            
            System.out.println("Something went wrong!");
        }
        
        
        
    }
    
}
