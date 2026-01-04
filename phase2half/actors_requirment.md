# Phase 2: Requirements Analysis for KochaEats Food Delivery System

## 1. Actors (System Users & External Entities)

### Primary Actors:

1. **Customer**

   - **Description:** End-user who orders food through the platform
   - **Role:** Browses restaurants, places orders, makes payments, tracks deliveries
   - **Interaction:** Uses mobile app or website to access services

2. **Restaurant Owner/Manager**

   - **Description:** Business partner who lists their restaurant on KochaEats
   - **Role:** Manages restaurant profile, updates menu, processes orders, handles restaurant operations
   - **Interaction:** Uses Restaurant Dashboard web portal

3. **Delivery Rider/Driver**

   - **Description:** Independent contractor who delivers food from restaurants to customers
   - **Role:** Accepts delivery requests, picks up orders, delivers to customers, updates delivery status
   - **Interaction:** Uses Rider Mobile App

4. **System Administrator**
   - **Description:** Internal staff managing the KochaEats platform
   - **Role:** Manages user accounts, monitors system performance, handles disputes, generates reports
   - **Interaction:** Uses Admin Web Dashboard

### Secondary/External Actors:

5. **Payment Gateway System**

   - **Description:** External financial service provider (e.g., Stripe, PayPal, local banks)
   - **Role:** Processes online payments securely, validates transactions, handles refunds
   - **Interaction:** API integration with KochaEats backend

6. **SMS/Email Notification Service**

   - **Description:** External communication service
   - **Role:** Sends OTPs, order confirmations, delivery updates, promotional messages
   - **Interaction:** API calls from KochaEats system

7. **Maps & Location Service**
   - **Description:** External mapping service (e.g., Google Maps, Mapbox)
   - **Role:** Provides geolocation, calculates distances, suggests optimal routes
   - **Interaction:** API integration for location-based services

---

## 2. Functional Requirements (User Stories & Use Cases)

### **A. Customer Requirements:**

#### Registration & Authentication:

- **US-C01:** As a new customer, I want to register using my email or phone number so I can create an account
- **US-C02:** As a customer, I want to login securely with email/phone and password so I can access my account
- **US-C03:** As a customer, I want to reset my password if I forget it so I can regain account access
- **US-C04:** As a customer, I want to update my profile information (name, address, phone) so my details are current

#### Restaurant Browsing & Selection:

- **US-C05:** As a customer, I want to browse restaurants by cuisine type (Ethiopian, Italian, Chinese, etc.) so I can find preferred food
- **US-C06:** As a customer, I want to search restaurants by name or dish so I can find specific items
- **US-C07:** As a customer, I want to filter restaurants by rating (4+ stars), delivery time, or price range so I can make better choices
- **US-C08:** As a customer, I want to view restaurant details (menu, ratings, delivery time, minimum order) so I can decide where to order from

#### Menu & Ordering:

- **US-C09:** As a customer, I want to view a restaurant's full menu with prices, descriptions, and images so I know what to order
- **US-C10:** As a customer, I want to add/remove items to/from my cart with specified quantities so I can prepare my order
- **US-C11:** As a customer, I want to apply promo codes or discounts to my cart so I can save money
- **US-C12:** As a customer, I want to specify delivery address and delivery instructions so my food arrives correctly
- **US-C13:** As a customer, I want to choose between delivery or pickup options based on my preference
- **US-C14:** As a customer, I want to place an order with selected payment method so I can complete my purchase

#### Payment Processing:

- **US-C15:** As a customer, I want to pay online using credit/debit card, mobile money, or digital wallet so my payment is secure
- **US-C16:** As a customer, I want the option for cash on delivery for orders under certain conditions
- **US-C17:** As a customer, I want to receive a digital receipt after payment so I have proof of transaction
- **US-C18:** As a customer, I want to save my payment methods securely for faster checkout next time

#### Order Tracking & Management:

- **US-C19:** As a customer, I want to track my order status in real-time (Confirmed → Preparing → On the way → Delivered) so I know when to expect my food
- **US-C20:** As a customer, I want to view my order history with details of past orders so I can reorder easily
- **US-C21:** As a customer, I want to cancel my order within a specific timeframe if I change my mind
- **US-C22:** As a customer, I want to contact the rider or restaurant directly through the app if there's an issue

#### Reviews & Ratings:

- **US-C23:** As a customer, I want to rate restaurants (1-5 stars) and write reviews after delivery so others can benefit
- **US-C24:** As a customer, I want to rate delivery riders based on service quality so performance can be monitored
- **US-C25:** As a customer, I want to view restaurant and rider ratings before ordering so I can choose quality service

### **B. Restaurant Requirements:**

#### Profile Management:

- **US-R01:** As a restaurant owner, I want to register my restaurant on KochaEats so I can reach more customers
- **US-R02:** As a restaurant, I want to update my restaurant profile (name, address, contact, description, images) so information is accurate
- **US-R03:** As a restaurant, I want to set my operating hours (open/close times, holidays) so customers know when I'm available
- **US-R04:** As a restaurant, I want to specify my delivery radius and minimum order amount so operations are feasible

#### Menu Management:

- **US-R05:** As a restaurant, I want to add/remove/update menu items with prices, descriptions, and images so my menu is current
- **US-R06:** As a restaurant, I want to categorize menu items (Appetizers, Main Course, Desserts, Drinks) so it's organized
- **US-R07:** As a restaurant, I want to mark items as "out of stock" temporarily so customers don't order unavailable items
- **US-R08:** As a restaurant, I want to create special offers or combo deals to attract more customers

#### Order Management:

- **US-R09:** As a restaurant, I want to receive instant notifications for new orders so I can start preparation immediately
- **US-R10:** As a restaurant, I want to view all active orders with details (items, special instructions) so I can prepare correctly
- **US-R11:** As a restaurant, I want to update order status (Accepted → Preparing → Ready for pickup) so customers can track
- **US-R12:** As a restaurant, I want to reject orders if I cannot fulfill them (due to capacity or ingredients)

#### Financial Management:

- **US-R13:** As a restaurant, I want to view my daily/weekly/monthly earnings report so I can track performance
- **US-R14:** As a restaurant, I want to see a breakdown of orders, commissions, and net earnings so I understand finances
- **US-R15:** As a restaurant, I want to set up my bank account for receiving payments from KochaEats so I get paid

### **C. Delivery Rider Requirements:**

#### Registration & Availability:

- **US-DR01:** As a delivery rider, I want to register on the platform with my details and documents so I can start working
- **US-DR02:** As a rider, I want to set my availability status (Online/Available, Busy, Offline) so I control when I work
- **US-DR03:** As a rider, I want to specify my preferred delivery zones so I work in familiar areas

#### Delivery Management:

- **US-DR04:** As a rider, I want to receive delivery requests with order details and locations so I can accept suitable deliveries
- **US-DR05:** As a rider, I want to accept or reject delivery requests based on my availability and location
- **US-DR06:** As a rider, I want to view optimal route from restaurant to customer location so I can deliver efficiently
- **US-DR07:** As a rider, I want to update delivery status (Going to restaurant → Picked up → On the way → Delivered) so all parties are informed
- **US-DR08:** As a rider, I want to contact customer through masked number if I need delivery instructions so privacy is maintained

#### Earnings & Performance:

- **US-DR09:** As a rider, I want to track my daily earnings and number of deliveries so I know my income
- **US-DR10:** As a rider, I want to view my performance metrics (average delivery time, customer ratings) so I can improve
- **US-DR11:** As a rider, I want to withdraw my earnings to my bank account or mobile money so I can access my money

### **D. Administrator Requirements:**

#### User Management:

- **US-A01:** As an admin, I want to view and manage all user accounts (customers, restaurants, riders) so I can maintain system integrity
- **US-A02:** As an admin, I want to approve or reject restaurant registration requests after verification so only legitimate businesses join
- **US-A03:** As an admin, I want to verify rider documents and approve/reject rider applications so only qualified riders deliver
- **US-A04:** As an admin, I want to suspend or ban users who violate terms of service so platform remains safe

#### Content & System Management:

- **US-A05:** As an admin, I want to manage featured restaurants and promotions on the homepage so I can highlight partners
- **US-A06:** As an admin, I want to view and moderate customer reviews/ratings so content is appropriate
- **US-A07:** As an admin, I want to update system-wide settings (commission rates, delivery fees, etc.) so business parameters are controlled

#### Reporting & Analytics:

- **US-A08:** As an admin, I want to generate reports on orders, revenue, and user activity so I can analyze business performance
- **US-A09:** As an admin, I want to view dashboard with key metrics (total orders, revenue, active users) at a glance
- **US-A10:** As an admin, I want to export data to Excel/PDF for further analysis so I can make data-driven decisions

#### Dispute Resolution:

- **US-A11:** As an admin, I want to receive and manage customer complaints or disputes so issues are resolved fairly
- **US-A12:** As an admin, I want to issue refunds or credits in case of service failures so customer satisfaction is maintained

---

## 3. Non-Functional Requirements

### Performance:

- The system should handle up to 1000 concurrent users during peak hours
- Order placement should complete within 3 seconds
- Real-time order tracking updates should reflect within 15 seconds

### Security:

- All passwords must be encrypted using bcrypt hashing
- Payment information must be PCI-DSS compliant
- Personal data must be protected according to data protection regulations

### Reliability:

- System uptime should be 99.5% or higher
- Order data should never be lost once confirmed
- Backup and recovery procedures should be in place

### Usability:

- Mobile app should be intuitive for users with basic smartphone knowledge
- Website should be responsive and work on all modern browsers
- Interface should be available in multiple languages (Amharic, English, etc.)

### Scalability:

- System architecture should support adding new restaurants and cities easily
- Database should handle growth to 100,000+ users
- Payment system should integrate with local Ethiopian payment methods

---

## 4. Assumptions & Constraints

### Assumptions:

1. Customers have smartphones with internet access
2. Restaurants have staff to manage online orders
3. Delivery riders have smartphones and reliable transportation
4. Payment gateway services are available and reliable
5. Users are primarily located in urban areas with good network coverage

### Constraints:

1. Must comply with Ethiopian business regulations
2. Must support local payment methods (telebirr, CBE Birr, etc.)
3. Must consider varying internet speeds across regions
4. Must accommodate different device capabilities
5. Budget constraints for development and maintenance

---

## 5. Priority Classification

### High Priority (Must Have):

- Customer registration and authentication
- Restaurant browsing and menu viewing
- Order placement and payment processing
- Basic order tracking
- Restaurant order management
- Rider delivery assignment

### Medium Priority (Should Have):

- Advanced search and filters
- Customer reviews and ratings
- Promo codes and discounts
- Multiple payment methods
- Detailed analytics and reporting

### Low Priority (Could Have):

- Loyalty programs
- Social media integration
- Advanced AI recommendations
- Multi-language support beyond English/Amharic
- Voice-based ordering

---
