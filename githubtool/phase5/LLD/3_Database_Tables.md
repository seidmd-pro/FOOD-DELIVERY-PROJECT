# Data Flow Diagram Specification - Food Delivery System

## Overview

The Data Flow Diagram (DFD) shows how data moves through the Food Delivery System, illustrating the flow of information between processes, data stores, and external entities. This specification defines the data flows at different levels of abstraction.

## Context Diagram (Level 0)

### External Entities

- **Customer** - Places orders, makes payments, tracks deliveries
- **Restaurant Manager** - Manages restaurant profile and menu
- **Delivery Driver** - Updates delivery status and location
- **System Administrator** - Manages system configuration
- **telebirr Payment Gateway** - Processes payments
- **Google Maps API** - Provides location and routing services
- **Uber Eats API** - Alternative delivery service integration
- **Email Service Provider** - Sends email notifications

### Main Process

**Process 0: Food Delivery System**

- Manages all food ordering and delivery operations
- Processes user registrations and authentication
- Handles restaurant and menu management
- Coordinates order processing and payment
- Manages delivery tracking and notifications

### Data Flows (Level 0)

```
Customer ──[Order Request]──> Food Delivery System
Customer <──[Order Confirmation]── Food Delivery System
Customer ──[Payment Info]──> Food Delivery System
Customer <──[Order Status]── Food Delivery System

Restaurant Manager ──[Menu Updates]──> Food Delivery System
Restaurant Manager <──[Order Notifications]── Food Delivery System

Delivery Driver ──[Status Updates]──> Food Delivery System
Delivery Driver <──[Delivery Assignments]── Food Delivery System

System Administrator ──[System Config]──> Food Delivery System
System Administrator <──[System Reports]── Food Delivery System

Food Delivery System ──[Payment Request]──> telebirr Gateway
Food Delivery System <──[Payment Response]── telebirr Gateway

Food Delivery System ──[Location Query]──> Google Maps API
Food Delivery System <──[Route Data]── Google Maps API

Food Delivery System ──[Delivery Request]──> Uber Eats API
Food Delivery System <──[Delivery Status]── Uber Eats API

Food Delivery System ──[Email Request]──> Email Service
Food Delivery System <──[Delivery Status]── Email Service
```

## Level 1 Data Flow Diagram

### Major Processes

1. **User Management Process** - Handle user registration, authentication, and profiles
2. **Restaurant Management Process** - Manage restaurant profiles and menus
3. **Order Processing Process** - Handle order placement and validation
4. **Payment Processing Process** - Process payments and transactions
5. **Delivery Management Process** - Coordinate deliveries and tracking
6. **Notification Process** - Send notifications and communications
7. **Reporting Process** - Generate reports and analytics

### Data Stores

- **D1: Users** - User account information and profiles
- **D2: Restaurants** - Restaurant profiles and operational data
- **D3: Menus** - Menu items, prices, and availability
- **D4: Orders** - Order details and status information
- **D5: Payments** - Payment transactions and history
- **D6: Deliveries** - Delivery assignments and tracking data
- **D7: Notifications** - Notification logs and templates
- **D8: Reports** - Generated reports and analytics data

### Level 1 Data Flows

#### User Management Process (1.0)

```
Customer ──[Registration Data]──> 1.0 User Management
Customer <──[Account Confirmation]── 1.0 User Management
Customer ──[Login Credentials]──> 1.0 User Management
Customer <──[Authentication Token]── 1.0 User Management

1.0 User Management ──[User Data]──> D1: Users
1.0 User Management <──[User Info]── D1: Users
1.0 User Management ──[Email Request]──> 6.0 Notification
```

#### Restaurant Management Process (2.0)

```
Restaurant Manager ──[Restaurant Data]──> 2.0 Restaurant Management
Restaurant Manager ──[Menu Data]──> 2.0 Restaurant Management
Restaurant Manager <──[Profile Status]── 2.0 Restaurant Management

2.0 Restaurant Management ──[Restaurant Info]──> D2: Restaurants
2.0 Restaurant Management <──[Restaurant Data]── D2: Restaurants
2.0 Restaurant Management ──[Menu Items]──> D3: Menus
2.0 Restaurant Management <──[Menu Data]── D3: Menus
2.0 Restaurant Management ──[Update Notification]──> 6.0 Notification
```

#### Order Processing Process (3.0)

```
Customer ──[Order Request]──> 3.0 Order Processing
Customer <──[Order Confirmation]── 3.0 Order Processing

3.0 Order Processing <──[Restaurant Info]── D2: Restaurants
3.0 Order Processing <──[Menu Data]── D3: Menus
3.0 Order Processing <──[User Info]── D1: Users
3.0 Order Processing ──[Order Data]──> D4: Orders
3.0 Order Processing <──[Order Info]── D4: Orders
3.0 Order Processing ──[Payment Request]──> 4.0 Payment Processing
3.0 Order Processing <──[Payment Status]── 4.0 Payment Processing
3.0 Order Processing ──[Delivery Request]──> 5.0 Delivery Management
3.0 Order Processing ──[Order Notification]──> 6.0 Notification
```

#### Payment Processing Process (4.0)

```
3.0 Order Processing ──[Payment Request]──> 4.0 Payment Processing
4.0 Payment Processing ──[Payment Response]──> 3.0 Order Processing

4.0 Payment Processing ──[Payment Data]──> D5: Payments
4.0 Payment Processing <──[Payment History]── D5: Payments
4.0 Payment Processing ──[Payment Request]──> telebirr Gateway
4.0 Payment Processing <──[Payment Response]── telebirr Gateway
4.0 Payment Processing ──[Payment Notification]──> 6.0 Notification
```

#### Delivery Management Process (5.0)

```
3.0 Order Processing ──[Delivery Request]──> 5.0 Delivery Management
5.0 Delivery Management ──[Delivery Assignment]──> Delivery Driver
Delivery Driver ──[Status Update]──> 5.0 Delivery Management

5.0 Delivery Management ──[Delivery Data]──> D6: Deliveries
5.0 Delivery Management <──[Delivery Info]── D6: Deliveries
5.0 Delivery Management <──[Order Info]── D4: Orders
5.0 Delivery Management ──[Location Query]──> Google Maps API
5.0 Delivery Management <──[Route Data]── Google Maps API
5.0 Delivery Management ──[Delivery Request]──> Uber Eats API
5.0 Delivery Management <──[Delivery Status]── Uber Eats API
5.0 Delivery Management ──[Status Notification]──> 6.0 Notification
```

#### Notification Process (6.0)

```
1.0 User Management ──[Email Request]──> 6.0 Notification
2.0 Restaurant Management ──[Update Notification]──> 6.0 Notification
3.0 Order Processing ──[Order Notification]──> 6.0 Notification
4.0 Payment Processing ──[Payment Notification]──> 6.0 Notification
5.0 Delivery Management ──[Status Notification]──> 6.0 Notification

6.0 Notification ──[Notification Log]──> D7: Notifications
6.0 Notification <──[Template Data]── D7: Notifications
6.0 Notification ──[Email Request]──> Email Service Provider
6.0 Notification <──[Delivery Status]── Email Service Provider
6.0 Notification ──[SMS Request]──> SMS Gateway
6.0 Notification ──[Push Notification]──> Mobile Apps
```

#### Reporting Process (7.0)

```
System Administrator ──[Report Request]──> 7.0 Reporting
System Administrator <──[Generated Report]── 7.0 Reporting

7.0 Reporting <──[User Data]── D1: Users
7.0 Reporting <──[Restaurant Data]── D2: Restaurants
7.0 Reporting <──[Order Data]── D4: Orders
7.0 Reporting <──[Payment Data]── D5: Payments
7.0 Reporting <──[Delivery Data]── D6: Deliveries
7.0 Reporting ──[Report Data]──> D8: Reports
7.0 Reporting <──[Historical Data]── D8: Reports
```

## Level 2 Data Flow Diagrams

### Order Processing Process (3.0) - Detailed Breakdown

#### Sub-processes

- **3.1 Validate Order** - Check order validity and availability
- **3.2 Calculate Total** - Compute order total with taxes and fees
- **3.3 Create Order** - Generate order record and assign ID
- **3.4 Update Inventory** - Update menu item availability
- **3.5 Schedule Delivery** - Coordinate delivery timing

#### Detailed Data Flows

```
Customer ──[Order Items]──> 3.1 Validate Order
3.1 Validate Order <──[Menu Data]── D3: Menus
3.1 Validate Order <──[Restaurant Status]── D2: Restaurants
3.1 Validate Order ──[Valid Order]──> 3.2 Calculate Total

3.2 Calculate Total <──[Pricing Data]── D3: Menus
3.2 Calculate Total ──[Order Total]──> 3.3 Create Order

3.3 Create Order ──[Order Record]──> D4: Orders
3.3 Create Order ──[Inventory Update]──> 3.4 Update Inventory
3.3 Create Order ──[Delivery Schedule]──> 3.5 Schedule Delivery

3.4 Update Inventory ──[Availability Update]──> D3: Menus
3.5 Schedule Delivery ──[Delivery Request]──> 5.0 Delivery Management
```

### Payment Processing Process (4.0) - Detailed Breakdown

#### Sub-processes

- **4.1 Validate Payment** - Verify payment information
- **4.2 Process Transaction** - Execute payment through gateway
- **4.3 Handle Response** - Process payment gateway response
- **4.4 Update Records** - Update payment and order records
- **4.5 Handle Failures** - Manage failed payment scenarios

#### Detailed Data Flows

```
3.0 Order Processing ──[Payment Info]──> 4.1 Validate Payment
4.1 Validate Payment ──[Valid Payment]──> 4.2 Process Transaction

4.2 Process Transaction ──[Payment Request]──> telebirr Gateway
telebirr Gateway ──[Payment Response]──> 4.3 Handle Response

4.3 Handle Response ──[Success Response]──> 4.4 Update Records
4.3 Handle Response ──[Failure Response]──> 4.5 Handle Failures

4.4 Update Records ──[Payment Data]──> D5: Payments
4.4 Update Records ──[Order Update]──> D4: Orders
4.4 Update Records ──[Success Status]──> 3.0 Order Processing

4.5 Handle Failures ──[Failure Log]──> D5: Payments
4.5 Handle Failures ──[Failure Status]──> 3.0 Order Processing
```

## Data Dictionary

### Data Elements

#### User Data

- **User ID** - Unique identifier (UUID)
- **First Name** - User's first name (String, 50 chars)
- **Last Name** - User's last name (String, 50 chars)
- **Email** - Email address (String, 100 chars, unique)
- **Password Hash** - Encrypted password (String, 255 chars)
- **Phone Number** - Contact number (String, 15 chars)
- **Address** - Delivery address (Complex object)
- **User Role** - CUSTOMER, RESTAURANT_MANAGER, DRIVER, ADMIN
- **User Status** - ACTIVE, INACTIVE, PENDING_CONFIRMATION

#### Restaurant Data

- **Restaurant ID** - Unique identifier (UUID)
- **Name** - Restaurant name (String, 100 chars)
- **Description** - Restaurant description (String, 500 chars)
- **Address** - Restaurant location (Complex object)
- **Phone Number** - Contact number (String, 15 chars)
- **Email** - Contact email (String, 100 chars)
- **Cuisine Type** - Type of cuisine (String, 50 chars)
- **Operating Hours** - Business hours (Complex object)
- **Rating** - Average rating (Decimal, 1-5 scale)
- **Status** - ACTIVE, INACTIVE, TEMPORARILY_CLOSED

#### Order Data

- **Order ID** - Unique identifier (UUID)
- **Customer ID** - Reference to customer (UUID)
- **Restaurant ID** - Reference to restaurant (UUID)
- **Order Items** - List of ordered items (Array)
- **Subtotal** - Order subtotal (Decimal, 2 decimal places)
- **Tax Amount** - Tax calculation (Decimal, 2 decimal places)
- **Delivery Fee** - Delivery charge (Decimal, 2 decimal places)
- **Total Amount** - Final total (Decimal, 2 decimal places)
- **Order Status** - PENDING, CONFIRMED, PREPARING, READY, DELIVERED, CANCELLED
- **Order Date** - Timestamp of order placement
- **Delivery Address** - Delivery location (Complex object)
- **Special Instructions** - Customer notes (String, 500 chars)

#### Payment Data

- **Payment ID** - Unique identifier (UUID)
- **Order ID** - Reference to order (UUID)
- **Amount** - Payment amount (Decimal, 2 decimal places)
- **Payment Method** - TELEBIRR, CREDIT_CARD, CASH
- **Transaction ID** - Gateway transaction ID (String, 100 chars)
- **Payment Status** - PENDING, COMPLETED, FAILED, REFUNDED
- **Payment Date** - Timestamp of payment
- **Gateway Response** - Payment gateway response (JSON)

#### Delivery Data

- **Delivery ID** - Unique identifier (UUID)
- **Order ID** - Reference to order (UUID)
- **Driver ID** - Reference to driver (UUID)
- **Pickup Address** - Restaurant location (Complex object)
- **Delivery Address** - Customer location (Complex object)
- **Estimated Time** - Delivery ETA (DateTime)
- **Actual Time** - Actual delivery time (DateTime)
- **Delivery Status** - ASSIGNED, PICKED_UP, IN_TRANSIT, DELIVERED
- **Driver Location** - Current GPS coordinates (Lat/Long)
- **Route Data** - Navigation route (JSON)

### Data Flows Description

#### High-Volume Data Flows

- **Order Requests** - Peak: 1000+ orders/hour during meal times
- **Location Updates** - Continuous GPS tracking from active drivers
- **Payment Transactions** - Real-time payment processing
- **Status Notifications** - Frequent status updates to customers

#### Critical Data Flows

- **Payment Information** - Encrypted and secure transmission
- **User Authentication** - Secure login and session management
- **Order Confirmations** - Reliable delivery to customers and restaurants
- **Delivery Assignments** - Time-sensitive driver notifications

#### Real-time Data Flows

- **Order Tracking** - Live status updates
- **Driver Location** - GPS coordinates every 30 seconds
- **Payment Status** - Immediate transaction results
- **Inventory Updates** - Real-time menu availability

## Data Storage Requirements

### Primary Data Stores

- **PostgreSQL Database** - Transactional data with ACID properties
- **Redis Cache** - Session data and frequently accessed information
- **File Storage (AWS S3)** - Images, documents, and static content
- **Message Queue (RabbitMQ)** - Asynchronous data processing

### Data Retention Policies

- **User Data** - Retained while account is active + 7 years after deletion
- **Order Data** - Retained for 7 years for business and tax purposes
- **Payment Data** - Retained for 10 years per financial regulations
- **Delivery Data** - Retained for 3 years for operational analysis
- **Log Data** - Retained for 1 year for debugging and audit

### Data Backup Strategy

- **Daily Backups** - Full database backup every 24 hours
- **Incremental Backups** - Transaction log backups every 15 minutes
- **Cross-Region Replication** - Real-time replication to secondary region
- **Point-in-Time Recovery** - Ability to restore to any point within 30 days

## Data Security and Privacy

### Data Classification

- **Public Data** - Restaurant menus, ratings, general information
- **Internal Data** - Order statistics, business analytics
- **Confidential Data** - User profiles, order history, payment methods
- **Restricted Data** - Payment details, authentication credentials

### Data Protection Measures

- **Encryption at Rest** - AES-256 encryption for stored data
- **Encryption in Transit** - TLS 1.3 for all data transmission
- **Data Masking** - PII masking in non-production environments
- **Access Controls** - Role-based access to sensitive data

### Privacy Compliance

- **GDPR Compliance** - Right to be forgotten, data portability
- **Data Minimization** - Collect only necessary data
- **Consent Management** - Explicit consent for data processing
- **Audit Trails** - Complete logging of data access and modifications

## Performance Considerations

### Data Flow Optimization

- **Caching Strategy** - Multi-level caching for frequently accessed data
- **Database Indexing** - Optimized indexes for common queries
- **Data Partitioning** - Horizontal partitioning for large tables
- **Connection Pooling** - Efficient database connection management

### Scalability Measures

- **Read Replicas** - Separate read and write operations
- **Data Sharding** - Distribute data across multiple databases
- **CDN Integration** - Content delivery network for static assets
- **Asynchronous Processing** - Non-blocking data processing where possible

### Monitoring and Alerting

- **Data Flow Monitoring** - Track data movement and processing times
- **Performance Metrics** - Database query performance and response times
- **Error Tracking** - Monitor and alert on data processing failures
- **Capacity Planning** - Proactive scaling based on data growth trends
