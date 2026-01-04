

/**
 * @author SEID
 * @version 1.0
 * @created 01-Jan-2026 12:12:39 AM
 */
public class Order {

	private LocalDateTime createdAt;
	private int customerId;
	private String deliveryAddress;
	private double deliveryFee;
	private double discountAmount;
	private LocalDateTime estimatedDeliveryTime;
	private int id;
	public Restaurant m_Restaurant;
	private int orderNumber;
	private int restaurantId;
	private double serviceFee;
	private String specialInstructions;
	private String status;
	private double subtotal;
	private double taxAmount;
	private double totalAmount;

	/**
	 * 1️⃣ No-argument constructor
	 */
	public Order(){

	}

	/**
	 * 2️⃣ Parameterized constructor
	 * 
	 * @param orderNumber
	 * @param customerId
	 * @param restaurantId
	 * @param subtotal    subtotal
	 */
	public Order(int orderNumber, int customerId, int restaurantId, double subtotal){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	/**
	 * 3️⃣ Calculate total amount
	 */
	public void calculateTotal(){

	}

	/**
	 * 4️⃣ Check if order can be cancelled
	 */
	public boolean canBeCancelled(){
		return false;
	}

	/**
	 * 7️⃣ Getters and Setters
	 */
	public int getId(){
		return 0;
	}

	public int getOrderNumber(){
		return 0;
	}

	public String getStatus(){
		return "";
	}

	public double getTotalAmount(){
		return 0;
	}

	/**
	 * 
	 * @param deliveryFee    deliveryFee
	 */
	public void setDeliveryFee(double deliveryFee){

	}

	/**
	 * 
	 * @param discountAmount    discountAmount
	 */
	public void setDiscountAmount(double discountAmount){

	}

	/**
	 * 
	 * @param serviceFee    serviceFee
	 */
	public void setServiceFee(double serviceFee){

	}

	/**
	 * 5️⃣ Update order status
	 * 
	 * @param status
	 * @param updatedBy    updatedBy
	 */
	public void updateStatus(String status, String updatedBy){

	}

	/**
	 * 6️⃣ Validate order
	 */
	public float validateOrder(){
		return null;
	}

}