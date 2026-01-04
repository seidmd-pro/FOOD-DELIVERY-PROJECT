# 1. Class Design (LLD)

## Main Classes

### AppState
Attributes:
- cart
- user
- orders
- coupon
- language

Methods:
- addToCart()
- removeFromCart()
- applyCoupon()
- getCartTotal()
- saveToStorage()

### User
Attributes:
- userId
- fullName
- email
- phone
- role

Methods:
- login()
- logout()
- register()

### Restaurant
Attributes:
- restaurantId
- name
- rating
- minOrder

Methods:
- getMenu()

### Order
Attributes:
- orderId
- items
- totalAmount
- status

Methods:
- placeOrder()
- cancelOrder()

**Figure 6:** Class Diagram  
_(Insert Class Diagram Image here)_
