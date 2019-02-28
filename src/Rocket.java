import java.util.ArrayList;

public class Rocket implements ISpaceShip {

    private ArrayList<Item> item = new ArrayList<>();
    private int maxWeight;
    private int addedWeight;
    private int mRocketCost;


//    initialise the data fields with the constructor
    public Rocket(int maxWeight, int rocketWeight, int rocketCost){
        this.maxWeight = maxWeight;
        this.addedWeight = rocketWeight;
        this.mRocketCost = rocketCost;
    }


    @Override
    public boolean launch(){
        return true;
    }


    @Override
    public boolean land(){
        return true;
    }


//  method to check if a rocket can carry an item
    @Override
    public boolean canCarry(Item item){
        if(this.addedWeight+item.getWeight()<=this.maxWeight){
            return true;
        }
        return false;
    }


//  carry an item to the rocket
    @Override
    public void carryItem(Item item){
        if(canCarry(item)){
            this.addedWeight += item.getWeight();
            this.item.add(item);
        }
    }

    public int getAddedWeight(){
        return this.addedWeight;
    }

    public int getMaxWeight(){
        return this.maxWeight;
    }

    public double randomNumberGenerate(){
        return  (Math.random());
    }

    public int getRocketCost(){
        return this.mRocketCost;
    }


}
