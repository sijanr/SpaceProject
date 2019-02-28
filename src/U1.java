public class U1 extends Rocket {

    private int chanceExplode;
    private int chanceCrash;

    public U1(){
        super(18, 10, 100_000_000 * 10);
        this.chanceCrash = (int) (0.01*(super.getAddedWeight()/super.getMaxWeight()));
        this.chanceExplode =  (int) (0.05*(getAddedWeight()/getMaxWeight()));
    }


//  checks whether the rocket will land successfully or not
    @Override
    public boolean land(){
        if(super.randomNumberGenerate()>(chanceCrash*10+0.4)){
            return false;
        }
        return true;
    }


//  checks of the launch of the rocket was successful
    @Override
    public boolean launch(){
        if(super.randomNumberGenerate()>(chanceExplode*10+0.2)){
            return false;
        }
        return true;
    }


}
