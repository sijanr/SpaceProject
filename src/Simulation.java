import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Simulation {



    /**@description Loads the items and their respective weight from phase2 file
     * @return The array list of items loaded from the file or null, if the file was not found*/

    public ArrayList<Item> loadItemsPhase2(){
        ArrayList<Item> items = new ArrayList<>();
        File loadFile = new File("phase-2.txt");
        try{
            Scanner scanner = new Scanner(loadFile);
            String[] itemName;
            while(scanner.hasNextLine()){
                itemName = scanner.nextLine().split("=");
                items.add(new Item(itemName[0],Integer.parseInt(itemName[1])/1000));
            }
            return items;
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        return null;
    }


    /**@description Loads the items into the U1 rocket(s)
     * @param items Array list of items to be sent to the space
     * @return Array list of rockets required to fill in all the items or null if the item list is empty*/
    public ArrayList<U1> loadU1(ArrayList<Item> items){
        ArrayList<U1> mU1Rockets = new ArrayList<>();
        if(items!=null){
            U1 newRocket = new U1();
            for (int i =0; i<items.size(); i++){
                if(newRocket.canCarry(items.get(i))){
                    newRocket.carryItem(items.get(i));
                }
                else{
                    mU1Rockets.add(newRocket);
                    newRocket = new U1();
                    i--;
                }
            }
            return mU1Rockets;
        }
        return null;
    }



    /**@description Loads the items into the U2 rocket(s)
     * @param items Array list of items to be sent to the space
     * @return Array list of rockets required to fill in all the items or null if there aren't any items*/
    public ArrayList<U2> loadU2(ArrayList<Item> items){
        ArrayList<U2> mU2Rockets = new ArrayList<>();
        if(items!=null){
            U2 newRocket = new U2();
            for (int i=0; i<items.size(); i++){
                if(newRocket.canCarry(items.get(i))){
                    newRocket.carryItem(items.get(i));
                }
                else{
                    mU2Rockets.add(newRocket);
                    newRocket = new U2();
                }
            }
            return mU2Rockets;
        }
        return null;
    }



    /**@description Runs the simulation to get an estimate of the total cost to send the rockets
     * @param providedRockets Array list of rockets carrying the items to be sent to the space
     * @return The estimated budget to send all the rockets*/
    public long runSimulationU1(ArrayList<Rocket> providedRockets){

        long totalBudget = 0;

        for (int i=0; i<providedRockets.size(); i++){

//          add the rocket's cost to the budget
            totalBudget += providedRockets.get(i).getRocketCost();

//          check if the rocket had a successful launch and land
            if(!providedRockets.get(i).land() || !providedRockets.get(i).launch()){
                i--;
            }
        }

        return totalBudget;
    }
}
