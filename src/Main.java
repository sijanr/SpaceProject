import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        Simulation simulation = new Simulation();
        ArrayList<Item> items = new ArrayList<>(simulation.loadItemsPhase2());
        ArrayList<Rocket> newRockets = new ArrayList<>(simulation.loadU1(items));
        long budget = simulation.runSimulationU1(newRockets);
        System.out.println("Total budget estimated = " + budget);

    }
}
