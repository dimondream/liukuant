package garden;

/**
 * Flower Class.  Flower produces pollen
 */
public class Flower implements Runnable {
    private Garden garden;
    private int pollenCount;

    /**
     * Flower constructor
     * @param garden
     */
    public Flower(Garden garden) {
        this.garden = garden;
        this.pollenCount = 0;
    }

    /*
     * The run method for a Flower.
     * This method should:
     * 1. Check to see if <= 200 pollen grains have been generated.
     * 2. If no, push a new Pollen grain into the Garden!
     * 3. If yes, terminate the Thread
     * 4. After each iteration of the thread, put it to sleep for 10 milliseconds!  You can do this using the command:
     *    Thread.sleep(10);
     */
    @Override
    public void run() {
        try {
            while(pollenCount<200) {
                garden.push(new Pollen(1));
                pollenCount+=1;
                //Thread.sleep(10);
            }
            Thread.currentThread().interrupt();
            Thread.sleep(10);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * Getter for pollen count
     * @return pollen count
     */
    public int getPollenCount() {
        return this.pollenCount;
    }
}