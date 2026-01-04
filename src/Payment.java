

/**
 * @author SEID
 * @version 1.0
 * @created 17-Dec-2025 4:54:03 PM
 */
public class Payment {

	private float amount;
	private String gatewayResponse;
	private String gatewayTransactionId;
	private int id;
	public MenuItem m_MenuItem;
	private int orderId;
	private String paymentMethod;
	private LocalDateTime processedAt;
	private String status;

	public Payment(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	public boolean isSuccessful(){
		return false;
	}

	public double processPayment(){
		return 0;
	}

	/**
	 * 
	 * @param amount    amount
	 */
	public void refund(float amount){

	}

	public double validatePayment(){
		return 0;
	}

}