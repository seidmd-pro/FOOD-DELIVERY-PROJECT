## detaieled data flow diagram

1. DATA FLOW DIAGRAMS (DFD)

   - Level 0: Context Diagram
   - Level 1: Main Processes
   - Level 2: Detailed processes (if needed)

2. DATA FLOW DESCRIPTIONS

   - How data moves between components
   - Data transformation processes

3. DATA STORES

   - Where data is stored
   - Data retention policies

4. EXTERNAL ENTITIES

   - Users, restaurants, riders, external systems

   ## Required Content for Phase 2:

   # KochaEats Data Flow Design

## 1. DFD Level 0 (Context Diagram):

**External Entities**:

1. Customer
2. Restaurant
3. Delivery Rider
4. Administrator
5. Payment Gateway
6. SMS Service

**Data Flows**:

- Customer → System: Order Request, Payment Details
- System → Customer: Order Confirmation, Tracking Updates
- Restaurant → System: Menu Updates, Order Status
- System → Restaurant: New Orders, Payment Details
- Rider → System: Location Updates, Delivery Status
- System → Rider: Delivery Assignments, Route Information

## 2. DFD Level 1 (Major Processes):

**Process 1.0: Process Order**

- Input: Order details from customer
- Process: Validate, calculate total, create order
- Output: Order confirmation, payment request

**Process 2.0: Process Payment**

- Input: Payment method and details
- Process: Validate, process transaction
- Output: Payment confirmation, receipt

**Process 3.0: Manage Delivery**

- Input: Order details, location
- Process: Assign rider, track delivery
- Output: Delivery updates, completion

**Process 4.0: Handle Notifications**

- Input: Event data
- Process: Format and send notifications
- Output: Email/SMS/Push notifications

## 3. Data Stores:

- **User Database**: Customer, restaurant, rider profiles
- **Order Database**: Orders, cart items, order history
- **Menu Database**: Restaurant menus, prices, categories
- **Payment Database**: Transactions, refunds, receipts .
