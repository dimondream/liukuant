package lab03;

import java.util.Objects;

/**
 * A  White Ash is a tree that stores carbon.
 *  - A WhiteAsh has a diameter
 *  - A WhiteAsh may be alive or dead
 *  - A WhiteAsh has a default growth rate of 0.3 cm in diameter a year
 */
public class WhiteAsh implements Comparable<WhiteAsh>{

	private final double DEFAULT_RATE = 0.3;
	private double diameter;
	private boolean alive;

	/**
	 * Create an Ash with the given diameter. This new tree is, by default, alive.
	 *
	 * @param diameter	The diameter of this tree
	 */
	public WhiteAsh(double diameter) {
		this.diameter = diameter;
		this.alive = true;
	}

	/**
	 * Get the diameter of this tree
	 *
	 * @return	The diameter of this tree
	 */
	public double getDiameter() {
		return this.diameter;
	}

	/**
	 * Set the diameter of this tree
	 */
	private void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	/**
	 * Return True if this tree is alive and false otherwise.
	 *
	 * @return	Whether or not this tree is alive
	 */
	public boolean getLiving() {
		return this.alive;
	}

	/**
	 * Set the tree to be alive or dead
	 */
	private void setLiving(boolean b) { this.alive = b; }

	/**
	 * Return string representation of this tree
	 *
	 * @return String	The string representation of this tree
	 */
	@Override
	public String toString() {
		String s = "Diameter: " + this.diameter +
				", Carbon content: " + this.carbonContent() + " kg";
		return s;
	}

	/**
	 * Increment the diameter of this tree based on the time (in years) that has elapsed
	 *  - If the tree is dead, do nothing
	 *  - If the time elapsed is less than 0, do nothing
	 *
	 * @param years  The number of years that have elapsed
	 */
	public void grow(double years) {
		if(getLiving() && years > 0){
			 setDiameter(getDiameter() + (DEFAULT_RATE * years));
		}
	}

	/**
	 * Calculate the carbon content of this tree in kg, based on biomass
	 * Carbon content of a White Ash can be calculated using this formula:
	 * Carbon = a*B, where B is the tree's Biomass and a = 0.521
	 * The tree's Biomass can be calculated using this formula:
	 * B = p*diameter^q, where diameter is the tree diameter, p = 0.16 and = 2.35
	 * Coefficients from:
	 * https://d32ogoqmya1dw8.cloudfront.net/files/eslabs/carbon/allometric_coefficients_common.v3.pdf
	 *
	 * @return double  The kg of carbon sequestered in the wood of the tree
	 */
	public double carbonContent() {
		return 	0.521 * 0.16 * Math.pow(getDiameter(), 2.35); //replace this line!!
	}

	/**
	 * Fell the tree. To fell (or chop down) the tree:
	 * - Sets the diameter to zero
	 * - Set the living status to 'false'.
	 */
	public void fellTree() {
		setDiameter(0);
		setLiving(false);//replace this line!!
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WhiteAsh whiteAsh = (WhiteAsh) o;
		return Double.compare(whiteAsh.diameter, diameter) == 0 && alive == whiteAsh.alive;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DEFAULT_RATE, diameter, alive);
	}

	/**
	 * Compare this tree to another.
	 * - If one tree is alive and the other dead, the living tree is "greater" than the dead one
	 * - If both are alive or dead, the one with the larger diameter is "greater"
	 * - If the trees are equal, return 0.
	 *
	 * @return int	0,1 or -1 (meaning same, greater than or less than, respectively)
	 */
	@Override
	public int compareTo(WhiteAsh other) {
		if(this.equals(other)){
			return 0;
		}else if(alive == other.alive){
			if(diameter > other.diameter){
				return 1;
			}
		}else if(alive){
			return 1;
		}
		return -1;
	}

}
