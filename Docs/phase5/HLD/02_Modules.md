# Module Diagram

## System Modules

### 1. User Management Module
- User registration
- Login and authentication
- Profile management
- Role management (Admin, Customer, Delivery Person)

### 2. Restaurant Module
- Add and manage restaurants
- Manage menus
- Update food availability

### 3. Order Management Module
- Place orders
- Update order status
- Cancel orders

### 4. Payment Module
- Process online payments
- Verify payment status

### 5. Delivery Module
- Assign delivery personnel
- Track order delivery

### 6. Notification Module
- Order confirmation alerts
- Delivery status updates

## Module Interaction
- User Module interacts with Order Module
- Order Module interacts with Payment and Delivery Modules
- Notification Module communicates with all other modules
