

/**
 * @author SEID
 * @version 1.0
 * @created 17-Dec-2025 4:54:04 PM
 */
public class Delivery {

	private LocalDateTime actualTime;
	private String deliveryLocation;
	private double distance;
	private int driverId;
	private LocalDateTime estimatedTime;
	private int id;
	public DeliveryDriver m_DeliveryDriver;
	private int orderId;
	private String status;

	public Delivery(){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	/**
	 * 
	 * @param driverId    driverId
	 */
	public void assignDriver(int driverId){

	}

	public String calculateETA(){
		return "";
	}

	/**
	 * 
	 * @param status    status
	 */
	public void updateStatus(String status){

	}

}