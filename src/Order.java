

/**
 * @author SEID
 * @version 1.0
 * @created 17-Dec-2025 4:54:03 PM
 */
public class Order {

	private LocalDateTime createdAt;
	private int customerId;
	private address deliveryAddress;
	private float deliveryFee;
	private float discountAmount;
	private LocalDateTime estimatedDeliveryTime;
	private int id;
	private int orderNumber;
	private int restaurantId;
	private double serviceFee;
	private String specialInstructions;
	private staus status;
	private double subtotal;
	private double taxAmount;
	private double totalAmount;

	public Order(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public void calculateTotal(){

	}

	public boolean canBeCancelled(){
		return false;
	}

	/**
	 * 
	 * @param status
	 * @param updatedBy    updatedBy
	 */
	public void updateStatus(String status, String updatedBy){

	}

	public float validateOrder(){
		return null;
	}

}