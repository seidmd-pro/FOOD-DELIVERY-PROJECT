# Test-Driven Development (TDD)

## What is Test-Driven Development (TDD)?

 TDD = Write the Test BEFORE Writing the Code


## The TDD Steps: Red-Green-Refactor 

### The 3 Simple Steps

  RED = Write a test that fails (because code doesn't exist yet)
  GREEN = Write simple code to make the test pass
  REFACTOR = Make the code better (but keep the test passing)

### Real-Life Example: Making a Sandwich

  RED Step - Write the Test:
```

  GREEN Step - Make It Work
```

  REFACTOR Step - Make It Better:
```

## TDD Example: Creating a Calculator 

### Step 1: RED - Write Failing Test

```java
public class CalculatorTest {
    
    @Test
    public void testAddition() {
        // This test will fail because Calculator doesn't exist yet!
        Calculator calc = new Calculator(); //  This class doesn't exist
        
        int result = calc.add(2, 3); //  This method doesn't exist
        
        assertEquals(5, result); // We expect 2 + 3 = 5
    }
}
```


  Result:  FAIL - "Cannot find class Calculator"

### Step 2: GREEN - Make It Pass

Create the Calculator class
```java
public class Calculator {
    
    public int add(int a, int b) {
        return a + b; // Simple solution that works
    }
}
```


 Result: PASS - Test now works!

### Step 3:  REFACTOR - Make It Better

  The code is already simple and good, so no changes needed.

Run the test again to make sure:
```bash
mvn test
```

  Result: PASS - Still works!

## Complete TDD Example: User Login 

### Iteration 1: Basic Login

 RED - Write failing test:
```java
public class UserTest {
    
    @Test
    public void testUserCanLogin() {
        // This will fail - User class doesn't exist yet
        User user = new User("John", "password123");
        
        boolean success = user.login("password123");
        
        assertTrue(success);
    }
}
```

 GREEN - Make it pass:
```java
public class User {
    private String name;
    private String password;
    
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    
    public boolean login(String password) {
        return this.password.equals(password); // Simple check
    }
}
```

  REFACTOR - Make it better:
```java
// Code is simple and works, no refactoring needed yet
```

### Iteration 2: Handle Wrong Password

  RED - Write failing test:
```java
@Test
public void testUserCannotLoginWithWrongPassword() {
    User user = new User("John", "password123");
    
    boolean success = user.login("wrongpassword");
    
    assertFalse(success); // Should fail with wrong password
}
```

   GREEN - Make it pass:
```java
// Our existing code already handles this!
public boolean login(String password) {
    return this.password.equals(password); // Returns false for wrong password
}
```

  REFACTOR - Make it better:
```java
// Still simple and good
```

### Iteration 3: Handle Empty Password

  RED - Write failing test:
```java
@Test
public void testUserCannotLoginWithEmptyPassword() {
    User user = new User("John", "password123");
    
    boolean success = user.login("");
    
    assertFalse(success); // Should fail with empty password
}
```

  GREEN - Make it pass:
```java
public boolean login(String password) {
    if (password == null || password.isEmpty()) {
        return false; // Handle empty password
    }
    return this.password.equals(password);
}
```

   REFACTOR - Make it better:
```java
public boolean login(String password) {
    // More readable version
    if (password == null || password.trim().isEmpty()) {
        return false;
    }
    return this.password.equals(password);
}
```

## Why TDD is Awesome 

### Benefits for Beginners:

  Helps You Think
- Before TDD: "I'll write code and see what happens"
- With TDD: "What exactly should this code do?"

   Prevents Big Mistakes:
- **Before TDD:** Write 100 lines, find out it's all wrong
- **With TDD:** Write 5 lines, test immediately, fix quickly

Gives Confidence:
- TDD:"I hope this works" 
- With TDD: "I know this works" 

  Makes Better Code:
- Before TDD: Complex, hard-to-test code
- With TDD: Simple, easy-to-test code

### Real Benefits:

```java
// Without TDD - you might write this complex mess:
public class User {
    public boolean login(String password, boolean checkStrength, 
                        int maxAttempts, Date lastLogin, 
                        String securityQuestion, boolean isAdmin) {
        // 50 lines of confusing code
    }
}

// With TDD - you write simple, focused code:
public class User {
    public boolean login(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return this.password.equals(password);
    }
}
```

## TDD Best Practices for Beginners 📋

###  Good TDD Habits:

**1. Start with the simplest test:**
```java
//  Good - start simple
@Test
public void testUserExists() {
    User user = new User();
    assertNotNull(user);
}

//  Bad - too complex to start
@Test
public void testCompleteUserWorkflowWithDatabaseAndEmailAndSecurity() {
    // Testing 20 things at once
}
```

**2. Write the minimum code to pass:**
```java
//  Good - simple solution
public int add(int a, int b) {
    return a + b;
}

//  Bad - over-engineering
public int add(int a, int b) {
    // Complex validation, logging, caching, etc.
    // when simple addition is all that's needed
}
```

**3. Run tests frequently:**
```java
//  Good workflow:
// 1. Write 1 small test
// 2. Run test (should fail)
// 3. Write minimal code
// 4. Run test (should pass)
// 5. Repeat

//  Bad workflow:
// 1. Write 10 tests
// 2. Write lots of code
// 3. Run tests (many failures, hard to debug)
```

###  Simple TDD Rules:

1. RED:** Write a failing test
2. GREEN:** Write minimal code to pass
3. REFACTOR:** Improve code while keeping tests green
4. REPEAT:** Do it again for the next feature

## Common TDD Mistakes (and How to Avoid Them) 

### Mistake 1: Writing Too Much Code

```java
//  Bad - writing everything at once
@Test
public void testEverything() {
    // Test user creation, login, logout, profile update, 
    // password reset, email verification, etc.
}

//  Good - one thing at a time
@Test
public void testUserCreation() {
    User user = new User("John");
    assertEquals("John", user.getName());
}
```

### Mistake 2: Not Running Tests Often

```java
//  Bad - write lots of code without testing
public class User {
    // 100 lines of code written without running any tests
}

//  Good - test after every small change
public class User {
    private String name;
    
    public User(String name) {
        this.name = name; // Write this, then run test
    }
    
    public String getName() {
        return name; // Add this, then run test again
    }
}
```

## TDD Summary for Beginners 

**The TDD Process:**
1. RED = Write a test that fails
2.  GREEN = Write code to make it pass
3. REFACTOR = Make the code better
4. REPEAT = Do it again

 Key Benefits:
- Better thinking = Forces you to plan before coding
- Fewer bugs = Catch problems immediately
- Simpler code = TDD leads to cleaner solutions
- More confidence = You know your code works
