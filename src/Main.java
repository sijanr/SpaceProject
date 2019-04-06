import javax.swing.*;
import java.util.ArrayList;

public class Main {

    private static Simulation simulation = new Simulation();
    private static ArrayList<Item> items;

    public static void main(String[] args){


        //get the phase type and rocket type from user
        String phaseType = JOptionPane.showInputDialog(null,"'1' to load Phase-1 items \n'2' to load Phase-2 items", "Enter 1 or 2");
        String rocketType = JOptionPane.showInputDialog(null,"'U1' to load U1 rockets \n'U2' to load U2 rockets","Enter U1 or U2");


        //load the given phase items or exit if the user gave a wrong phase input value
        try{
            items = new ArrayList<>(loadItems(phaseType));
        } catch(NullPointerException e) {
            JOptionPane.showMessageDialog(null,"Wrong Phase value input", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

        ArrayList<Rocket> newRockets;

        //load the items in the given rocket type or exit if the user gave a wrong rocket input value
        if(rocketType.equals("U1")){
            newRockets = new ArrayList<>(simulation.loadU1(items));
        }

        else if(rocketType.equals("U2")){
            newRockets = new ArrayList<>(simulation.loadU2(items));
        }

        else{
            newRockets = null;
            JOptionPane.showMessageDialog(null,"Wrong Rocket type input", "ERROR", JOptionPane.ERROR_MESSAGE);
        }


        //display the budget information
        if(newRockets!=null) {
            long budget = simulation.runSimulation(newRockets);
            String budgetString = String.format("$%,d", budget);
            JOptionPane.showMessageDialog(null, "Rockets: " + rocketType + "\nNumber of rockets: " + newRockets.size() + "\nEstimated budget: " + budgetString);
        }



    }


    /**
     * Get the list of items from user's phase input value
     * @param itemType The phase type to be loaded into rockets
     * @return Array list of items if the user gave a valid input value else null
     */
    public static ArrayList<Item> loadItems(String itemType){
        if(itemType.equals("1")){
            return simulation.loadItemsPhase1();
        }
        else if(itemType.equals("2")){
            return simulation.loadItemsPhase2();
        }
        return null;
    }

}
