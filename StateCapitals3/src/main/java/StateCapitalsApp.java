/*
    This program will read data regarding a state(capital, population, area)
    then a hashmap containing the name of the sate and a Capital object will be created. 
    every line of the text file contains state::capital::population::area. the '::'
    is what seperates each field of the record. The Capital.java class will take care
    of storing information regarding the capital of the specified state. 

*/
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Juan B
 */
public class StateCapitalsApp {

    public static void main(String[] args) {

        File usa = new File("MoreStateCapitals.txt");
        Scanner in = null;

        try {

            // the scanner that allows us to interate through the file
            in = new Scanner(usa);

            // the data structure to hold our states and capitals
            Map<String, Capital> theUSA = new HashMap<>();

            // how many records were read in
            int records = 0;

            //read through the file populating the hashmap
            while (in.hasNextLine()) {

                String record = in.nextLine();
                String[] stateCapital = record.split("::");

                // create the datafields required for making a Capital object.(unmarshalling)
                String name = stateCapital[1];
                int population = Integer.parseInt(stateCapital[2]);
                double area = Double.parseDouble(stateCapital[3]);
                
                theUSA.put(stateCapital[0], new Capital(name, population, area));
                records++;
            }

            //report on the data read
            System.out.println("A total of " + records + " Capital/State pairs were read");

            //sort the states alphabetically
            TreeSet<String> states = new TreeSet<>(theUSA.keySet());

            System.out.println("==================================================================");

            //print the states read in
            for (String state : states) {

                System.out.println(state + " --- " + theUSA.get(state));
            }

            System.out.println("===================================================================\n");

            System.out.print("Enter the minimum population: ");

            // repurpose the scanner 
            in = new Scanner(System.in);

            // gather the min are to be printted
            int minPop = in.nextInt();
            System.out.println("Printing capitals with a population greater than " + minPop + ".......");
            for (String state : states) {

                if (theUSA.get(state).getPopulation() > minPop) {
                    System.out.println(state + " --- " + theUSA.get(state));
                }

            }

            System.out.println("===================================================================\n");

            //getting the max are fromt he user and printing the states/capitals that 
            //have an are less than the max.
            System.out.print("Enter the max area for the capitals to be printed: ");

            double maxArea = in.nextDouble();
            System.out.println("Printing capitals with an area less than " + maxArea + ".......");
            for (String state : states) {

                if (theUSA.get(state).getArea() < maxArea) {
                    System.out.println(state + " --- " + theUSA.get(state));
                }

            }
            
            System.out.println("===================================================================\n");

            //file not found exception in case the file specified is not in the correct directoy.
        } catch (FileNotFoundException fnf) {

            System.out.println("File was not found");

            //catching all other exceptions.
        } catch (Exception e) {

            System.out.println("Something went wrong!");
        }
        
        finally{
            
            if(in != null )in.close();
        }

    }

}
