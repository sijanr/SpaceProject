public interface ISpaceShip {

    /*@description This is the method to test if the launch was successful
    * @param None
    * @return True if the launch was successful and false if not*/
    boolean launch();


    /*@description This method tests if the landing was successful
    * @param None
    * @return Tru if the land was successful and false if not */
    boolean land();


    /*@description This method tests if the given item can be taken into the spaceship
    * @param item The item to be taken into the spaceship
    * @return True if the item can be taken into the spaceship and false if not*/
    boolean canCarry(Item item);


    /*@description This method adds the item to the spaceship
    * @param item The item to be added to the collectibles that are to be taken into the spaceship
    * @return None*/
    void carryItem(Item item);
}
