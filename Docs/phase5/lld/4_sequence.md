## sequence diagram spasification

Sequence: Customer Places Order
SEQUENCE PLACE_ORDER_SEQUENCE
PARTICIPANTS: Customer, MobileApp, OrderService, RestaurantService, PaymentService, NotificationService

    Customer -> MobileApp: Select items & place order
    MobileApp -> OrderService: POST /api/orders {items, address, payment}

    OrderService -> OrderService: Validate order
    OrderService -> RestaurantService: Check restaurant availability
    RestaurantService -> OrderService: Availability status

    OrderService -> OrderService: Calculate total
    OrderService -> PaymentService: Process payment
    PaymentService -> OrderService: Payment confirmation

    OrderService -> Database: Save order
    OrderService -> RestaurantService: Notify new order
    OrderService -> NotificationService: Send order confirmation

    NotificationService -> Customer: Push notification
    NotificationService -> Restaurant: SMS/email notification

    OrderService -> MobileApp: Return order details
    MobileApp -> Customer: Display order confirmation

END SEQUENCE

// Sequence: Restaurant Prepares Order
SEQUENCE PREPARE_ORDER_SEQUENCE
PARTICIPANTS: RestaurantStaff, RestaurantPortal, OrderService, KitchenDisplay, NotificationService

    RestaurantStaff -> RestaurantPortal: View new orders
    RestaurantPortal -> OrderService: GET /api/restaurants/{id}/orders

    RestaurantStaff -> RestaurantPortal: Accept order
    RestaurantPortal -> OrderService: PUT /api/orders/{id}/status "PREPARING"

    OrderService -> KitchenDisplay: Update order status
    OrderService -> NotificationService: Send status update

    RestaurantStaff -> RestaurantPortal: Mark order as ready
    RestaurantPortal -> OrderService: PUT /api/orders/{id}/status "READY"

    OrderService -> DeliveryService: Trigger rider assignment
    OrderService -> NotificationService: Notify customer

END SEQUENCE
