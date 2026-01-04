

/**
 * @author SEID
 * @version 1.0
 * @created 01-Jan-2026 12:12:39 AM
 */
public class User {

	private LocalDateTime createdAt;
	private String email;
	private String firstName;
	private Integer id;
	private String lastName;
	public Order m_Order;
	private String password;
	private Integer phoneNumber;
	private String role;
	private String status;
	private LocalDateTime updatedAt;

	/**
	 * 1️⃣ No-argument constructor
	 */
	public User(){

	}

	/**
	 * 2️⃣ Parameterized constructor
	 * 
	 * @param id
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password    password
	 */
	public User(Integer id, String firstName, String lastName, String email, String password){

	}

	/**
	 * 
	 * @exception Throwable
	 */
	public void finalize()
	  throws Throwable{

	}

	/**
	 * 3️⃣ Activate user
	 */
	public void activate(){

	}

	/**
	 * 4️⃣ Deactivate user
	 */
	public void deactivate(){

	}

	/**
	 * 5️⃣ Encrypt password (simple example)
	 * 
	 * @param password    password
	 */
	public String encryptPassword(String password){
		return "";
	}

	public String getEmail(){
		return "";
	}

	public String getFirstName(){
		return "";
	}

	/**
	 * 9️⃣ Get full name
	 */
	public String getFullName(){
		return "";
	}

	/**
	 * 🔟 Getters and Setters
	 */
	public Integer getId(){
		return 0;
	}

	public String getLastName(){
		return "";
	}

	public Integer getPhoneNumber(){
		return 0;
	}

	public String getRole(){
		return "";
	}

	public String getStatus(){
		return "";
	}

	/**
	 * 
	 * @param email    email
	 */
	public void setEmail(String email){

	}

	/**
	 * 
	 * @param firstName    firstName
	 */
	public void setFirstName(String firstName){

	}

	/**
	 * 
	 * @param id    id
	 */
	public void setId(Integer id){

	}

	/**
	 * 
	 * @param lastName    lastName
	 */
	public void setLastName(String lastName){

	}

	/**
	 * 
	 * @param phoneNumber    phoneNumber
	 */
	public void setPhoneNumber(Integer phoneNumber){

	}

	/**
	 * 
	 * @param role    role
	 */
	public void setRole(String role){

	}

	/**
	 * 8️⃣ Update profile
	 * 
	 * @param update    update
	 */
	public void updateProfile(String update){

	}

	/**
	 * 7️⃣ Validate password
	 * 
	 * @param password    password
	 */
	public void validatePassword(String password){

	}

	/**
	 * 6️⃣ Verify password
	 * 
	 * @param plain
	 * @param hash    hash
	 */
	public Boolean verifyPassword(String plain, String hash){
		return false;
	}

}