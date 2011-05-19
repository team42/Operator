package applet.model;

/**
 * 
 * Taxi model used to store taxi information
 * 
 * @author Nicolai
 *
 */
public class Taxi {

	private String taxiID;
	private String taxiCoord;
	private String company;
	private int heuristic;
	
	public Taxi(String taxiID, String taxiCoord, String company) {
		this.taxiID = taxiID;
		this.taxiCoord = taxiCoord;
		this.company = company;
	}
	
	/**
	 * Constructor
	 * 
	 * Taxi ID and coordinate is required to make an object
	 * 
	 * @param taxiID
	 * @param taxiCoord
	 */
	public Taxi(String taxiID, String taxiCoord) {
		this.taxiID = taxiID;
		this.taxiCoord = taxiCoord;
	}
	
	/**
	 * Return the taxi ID
	 * 
	 * @return taxiID
	 */
	public String getTaxiID() {
		return taxiID;
	}
	
	/**
	 * Return the taxi coordinate
	 * 
	 * @return taxiCoord
	 */
	public String getTaxiCoord() {
		return taxiCoord;
	}
	
	/**
	 * Get the X coordinate of taxi.
	 * 
	 * @return X coordinate of taxi
	 */
	public int getXcoord() {
	   int xCoord = Integer.parseInt(taxiCoord.substring(0, 4));
	   return xCoord;
	}
	
	/**
	 * Get the Y coordinate of taxi.
	 * 
	 * @return Y coordinate of taxi
	 */
	public int getYcoord() {
      int yCoord = Integer.parseInt(taxiCoord.substring(5, 9));
      return yCoord;
   }
	
	public String getCompanyIP() {
		return company;
	}
	
	public void setHeuristic(int heuristic) {
		this.heuristic = heuristic;
	}
	
	public int getHeuristic() {
		return heuristic;
	}
	
}
