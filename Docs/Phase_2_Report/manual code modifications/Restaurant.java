

/**
 * @author SEID
 * @version 1.0
 * @created 01-Jan-2026 12:12:39 AM
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

	/**
	 * 1️⃣ No-argument constructor
	 */
	public Restaurant(){

	}

	/**
	 * 2️⃣ Parameterized constructor
	 * 
	 * @param id
	 * @param name
	 * @param address
	 * @param cuisineType    cuisineType
	 */
	public Restaurant(int id, String name, String address, String cuisineType){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	/**
	 * 3️⃣ Check if restaurant accepts orders
	 */
	public boolean acceptsOrders(){
		return false;
	}

	/**
	 * 4️⃣ Calculate delivery fee
	 * 
	 * @param distance
	 * @param amount    amount
	 */
	public double calculateDeliveryFee(double distance, double amount){
		return 0;
	}

	/**
	 * 5️⃣ Check availability
	 */
	public boolean checkAvailability(){
		return false;
	}

	public String getCuisineType(){
		return "";
	}

	/**
	 * 6️⃣ Display restaurant name
	 */
	public String getDisplayName(){
		return "";
	}

	/**
	 * 9️⃣ Getters and Setters
	 */
	public int getId(){
		return 0;
	}

	public String getName(){
		return "";
	}

	public double getRating(){
		return 0;
	}

	public String getStatus(){
		return "";
	}

	/**
	 * 7️⃣ Available for orders
	 */
	public boolean isAvailableForOrders(){
		return false;
	}

	/**
	 * 
	 * @param cuisineType    cuisineType
	 */
	public void setCuisineType(String cuisineType){

	}

	/**
	 * 
	 * @param id    id
	 */
	public void setId(int id){

	}

	/**
	 * 
	 * @param name    name
	 */
	public void setName(String name){

	}

	/**
	 * 
	 * @param status    status
	 */
	public void setStatus(String status){

	}

	/**
	 * 8️⃣ Update rating
	 * 
	 * @param newRating    newRating
	 */
	public void updateRating(int newRating){

	}

}