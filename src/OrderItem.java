

/**
 * @author SEID
 * @version 1.0
 * @created 17-Dec-2025 4:54:03 PM
 */
public class OrderItem {

	private String customizations;
	private int id;
	private String itemName;
	public Order m_Order;
	public Payment m_Payment;
	private int menuItemId;
	private int orderId;
	private int quantity;
	private double totalPrice;
	private double unitPrice;

	public OrderItem(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public double calculateItemTotal(){
		return 0;
	}

	/**
	 * 
	 * @param newQuantity    newQuantity
	 */
	public void updateQuantity(int newQuantity){

	}

}