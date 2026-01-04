

/**
 * @author SEID
 * @version 1.0
 * @created 01-Jan-2026 12:07:34 AM
 */
public class Restaurant {

	private String address;
	private String cuisineType;
	private double deliveryFee;
	private double deliveryRadiusKm;
	private String description;
	private String email;
	private int id;
	public RestaurantManager m_RestaurantManager;
	private int managerId;
	private double minimumOrderAmount;
	private String name;
	private int phoneNumber;
	private double rating;
	private String status;
	private int totalReviews;

	public Restaurant(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public boolean acceptsOrders(){
		return false;
	}

	/**
	 * 
	 * @param distance
	 * @param amount    amount
	 */
	public double calculateDeliveryFee(double distance, double amount){
		return 0;
	}

	public boolean checkAvailability(){
		return false;
	}

	public String getDisplayName(){
		return "";
	}

	public boolean isAvailableForOrders(){
		return false;
	}

	/**
	 * 
	 * @param newRating    newRating
	 */
	public void updateRating(int newRating){

	}

}