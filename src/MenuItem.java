

/**
 * @author SEID
 * @version 1.0
 * @created 17-Dec-2025 4:54:03 PM
 */
public class MenuItem {

	private int categoryId;
	private String description;
	private int id;
	private String imageUrl;
	private boolean isAvailable;
	private boolean isVegan;
	private boolean isVegetarian;
	public Restaurant m_Restaurant;
	private String name;
	private int preparationTime;
	private double price;
	private int restaurantId;

	public MenuItem(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public boolean isInStock(){
		return false;
	}

	/**
	 * 
	 * @param available    available
	 */
	public void updateAvailability(boolean available){

	}

	/**
	 * 
	 * @param newPrice    newPrice
	 */
	public void updatePrice(double newPrice){

	}

}