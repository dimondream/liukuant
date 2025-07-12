package cars;

/**
 * Car Factory class
 */
public class CarFactory {

    /**
     * Create a car
     * @param type type of car to create
     * @return car of specified type
     */
    public Car getCar(String type) {

        switch (type) {
            case "Corvette":
                return new Corvette();

            case "Ferrari":
                return new Ferrari();

            case "Rolls Royce":
                return new RollsRoyce();

            default: //doh!
                throw new RuntimeException("Wrong type");
        }
    }
}
