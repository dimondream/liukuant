package garden;

/**
 * Bee Class.  Bee consumes pollen
 */
public class Bee implements Runnable {
    private Garden garden;
    private int health;

    /**
     * Bee constructor
     * @param garden
     */
    public Bee(Garden garden) {
        this.garden = garden;
        this.health = 200;
    }

    /*
     * The run method for a Bee.
     * This method should:
     * 1. Check to see if the Bee's health has hit 0 or the bee has consumed <= 200 pollen grains.
     * 2. If yes, terminate the thread!
     * 3. If no, and if the Garden has pollen to give, the Bee should consume Pollen from the Garden.
     * 4. If no, and if the Garden has no pollen to give, decrement the Bee's health by 1 unit.
     * 5. After each iteration of this thread, put it to sleep for 10 milliseconds!  You can do this using the command:
     *    Thread.sleep(10);
     */
    @Override
    public void run() {
        try {
            int total=0;
            while(health > 0 && total <200) {
                if (!garden.empty()) {
                    total += garden.lastElement().number;
                    garden.pull();
                } else {
                    health -= 1;
                }
                //Thread.sleep(10);
            }

            Thread.currentThread().interrupt();
            Thread.sleep(10);
        }catch(InterruptedException e){
            System.out.println(e);
        }
    }

    /**
     * Getter for health
     * @return health
     */
    public int getHealth () {
        return this.health;
    }
}