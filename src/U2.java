public class U2 extends Rocket {
    private int chanceExplode;
    private int chanceCrash;

    public U2(){
        super(29, 18, 120_000_000);
        this.chanceCrash = (int) (0.08*(getAddedWeight()/getMaxWeight()));
        this.chanceExplode = (int) (0.04*(getAddedWeight()/getMaxWeight()));
    }


//  checks if there was any problem with the launch of the rocket
    @Override
    public boolean launch(){
        if(super.randomNumberGenerate()>(chanceExplode*10)+0.2){
            return false;
        }
        return true;
    }


//  checks if the land of the rocket was successful
    @Override
    public boolean land(){
        if(super.randomNumberGenerate()>(chanceCrash*10)+0.2){
            return false;
        }
        return true;
    }


}
