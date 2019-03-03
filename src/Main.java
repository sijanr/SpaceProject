import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        Simulation simulation = new Simulation();

        //load phase-1 items on U1 rocket and get the estimated budget
        ArrayList<Item> items = new ArrayList<>(simulation.loadItemsPhase1());
        ArrayList<Rocket> newRockets = new ArrayList<>(simulation.loadU1(items));
        long budget = simulation.runSimulation(newRockets);
        System.out.println("Total budget estimated for phase 1= " + budget);

        //load phase-2 items on U2 rockets and get the estimated budget
        items.clear();
        newRockets.clear();
        items = new ArrayList<>(simulation.loadItemsPhase2());
        newRockets = new ArrayList<>(simulation.loadU2(items));
        System.out.println("Rocket size = " + newRockets.size());
        budget = simulation.runSimulation(newRockets);
        System.out.println("Total budget estimated for phase 2 = " + budget);

    }
}
