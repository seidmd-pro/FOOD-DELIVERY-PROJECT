

/**
 * @author SEID
 * @version 1.0
 * @created 17-Dec-2025 4:54:32 PM
 */
public class User extends RestaurantManager Order DeliveryDriver {

	private LocalDateTime createAt;
	private String email;
	private String firstName;
	private Integer id;
	private String lastName;
	private String password;
	private Integer phoneNumber;
	private String role;
	private String status;
	private LocalDateTime updatedAt;

	public User(){

	}

	public void finalize() throws Throwable {
		super.finalize();
	}

	public void activate(){

	}

	public void deactivate(){

	}

	/**
	 * 
	 * @param password
	 */
	public String encryptPassword(String password){
		return "";
	}

	public String getFullName(){
		return "";
	}

	/**
	 * 
	 * @param update
	 */
	public void updateProfile(String update){

	}

	/**
	 * 
	 * @param password
	 */
	public void validatePassword(String password){

	}

	/**
	 * 
	 * @param plain
	 * @param hash
	 */
	public Boolean verifyPassword(String plain, String hash){
		return false;
	}

}