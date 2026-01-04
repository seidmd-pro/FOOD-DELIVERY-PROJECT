## main class structure

/ Main System Classes
CLASS User
PRIVATE:
userId: Integer
name: String
email: String
phone: String
address: String
userType: Enum

    PUBLIC:
        METHOD register(name, email, password, userType): Boolean
            // Validate input
            IF email IS NOT valid OR password IS weak THEN
                RETURN false
            END IF

            // Check if user exists
            IF database.userExists(email) THEN
                RETURN false
            END IF

            // Create user record
            userRecord = {
                name: name,
                email: email,
                password: hash(password),
                userType: userType
            }

            database.insert("Users", userRecord)
            sendVerificationEmail(email)
            RETURN true
        END METHOD

        METHOD login(email, password): AuthenticationToken
            // Find user by email
            user = database.findUserByEmail(email)

            IF user IS NULL THEN
                THROW "User not found"
            END IF

            // Verify password
            IF NOT verifyPassword(password, user.passwordHash) THEN
                THROW "Invalid password"
            END IF

            // Generate authentication token
            token = generateJWT(user.userId, user.userType)
            updateLastLogin(user.userId)

            RETURN token
        END METHOD

        METHOD updateProfile(updates): Boolean
            // Validate updates
            FOR EACH field IN updates DO
                IF field NOT IN allowedFields THEN
                    THROW "Invalid field: " + field
                END IF
            END FOR

            // Update user record
            database.update("Users", userId, updates)
            RETURN true
        END METHOD

END CLASS

CLASS Order
PRIVATE:
orderId: Integer
userId: Integer
restaurantId: Integer
items: List<OrderItem>
totalAmount: Float
status: OrderStatus
deliveryAddress: String
createdAt: DateTime

    PUBLIC:
        METHOD placeOrder(userId, restaurantId, items, deliveryAddress): Order
            // Validate inputs
            IF items IS EMPTY THEN
                THROW "Order must contain at least one item"
            END IF

            // Check restaurant availability
            IF NOT restaurant.isOpen(restaurantId) THEN
                THROW "Restaurant is currently closed"
            END IF

            // Calculate total
            total = 0.0
            FOR EACH item IN items DO
                menuItem = restaurant.getMenuItem(item.itemId)
                IF menuItem IS NULL THEN
                    THROW "Invalid menu item: " + item.itemId
                END IF

                total = total + (menuItem.price * item.quantity)
            END FOR

            // Create order object
            newOrder = Order()
            newOrder.orderId = generateOrderId()
            newOrder.userId = userId
            newOrder.restaurantId = restaurantId
            newOrder.items = items
            newOrder.totalAmount = total
            newOrder.status = OrderStatus.PENDING
            newOrder.deliveryAddress = deliveryAddress
            newOrder.createdAt = currentDateTime()

            // Save to database
            database.insert("Orders", newOrder)

            // Trigger notifications
            notificationService.sendToRestaurant(restaurantId, "New order received")
            notificationService.sendToUser(userId, "Order placed successfully")

            RETURN newOrder
        END METHOD

        METHOD calculateTotal(): Float
            total = 0.0

            FOR EACH orderItem IN this.items DO
                menuItem = restaurant.getMenuItem(orderItem.itemId)
                total = total + (menuItem.price * orderItem.quantity)
            END FOR

            // Apply discounts if any
            discount = applyApplicableDiscounts(this.userId, total)
            total = total - discount

            this.totalAmount = total
            RETURN total
        END METHOD

        METHOD updateStatus(newStatus): Boolean
            // Validate status transition
            validTransitions = {
                OrderStatus.PENDING: [OrderStatus.CONFIRMED, OrderStatus.CANCELLED],
                OrderStatus.CONFIRMED: [OrderStatus.PREPARING, OrderStatus.CANCELLED],
                OrderStatus.PREPARING: [OrderStatus.READY, OrderStatus.CANCELLED],
                OrderStatus.READY: [OrderStatus.ON_THE_WAY],
                OrderStatus.ON_THE_WAY: [OrderStatus.DELIVERED]
            }

            IF newStatus NOT IN validTransitions[this.status] THEN
                THROW "Invalid status transition from " + this.status + " to " + newStatus
            END IF

            // Update status
            oldStatus = this.status
            this.status = newStatus
            database.update("Orders", this.orderId, {"status": newStatus})

            // Log status change
            logStatusChange(this.orderId, oldStatus, newStatus)

            // Send notifications based on status
            IF newStatus == OrderStatus.CONFIRMED THEN
                notificationService.sendToUser(this.userId, "Your order has been confirmed")
            ELSE IF newStatus == OrderStatus.ON_THE_WAY THEN
                notificationService.sendToUser(this.userId, "Your order is on the way")
            ELSE IF newStatus == OrderStatus.DELIVERED THEN
                notificationService.sendToUser(this.userId, "Your order has been delivered")
                requestPayment(this.orderId)
            END IF

            RETURN true
        END METHOD

        METHOD assignRider(riderId): Boolean
            // Check rider availability
            rider = riderService.getRider(riderId)
            IF rider.status != "AVAILABLE" THEN
                THROW "Rider is not available"
            END IF

            // Calculate distance between restaurant and delivery address
            restaurantLocation = restaurant.getLocation(this.restaurantId)
            deliveryLocation = geocode(this.deliveryAddress)
            distance = calculateDistance(restaurantLocation, deliveryLocation)

            // Update rider status and assign to order
            riderService.updateRiderStatus(riderId, "BUSY")
            database.insert("Deliveries", {
                "orderId": this.orderId,
                "riderId": riderId,
                "assignedAt": currentDateTime(),
                "estimatedDeliveryTime": calculateETA(distance)
            })

            this.status = OrderStatus.ON_THE_WAY

            // Notify rider and user
            notificationService.sendToRider(riderId, "New delivery assigned")
            notificationService.sendToUser(this.userId, "Rider assigned to your order")

            RETURN true
        END METHOD

END CLASS

CLASS Restaurant
PRIVATE:
restaurantId: Integer
name: String
location: GeoPoint
cuisineType: String
menu: List<MenuItem>
operatingHours: Schedule
status: String

    PUBLIC:
        METHOD addMenuItem(name, description, price, category): MenuItem
            // Validate input
            IF price <= 0 THEN
                THROW "Price must be positive"
            END IF

            // Create menu item
            newItem = MenuItem()
            newItem.itemId = generateItemId()
            newItem.name = name
            newItem.description = description
            newItem.price = price
            newItem.category = category
            newItem.restaurantId = this.restaurantId

            // Add to menu
            this.menu.append(newItem)
            database.insert("Menu_Items", newItem)

            RETURN newItem
        END METHOD

        METHOD updateOrderStatus(orderId, status): Boolean
            // Validate restaurant owns the order
            order = database.getOrder(orderId)
            IF order.restaurantId != this.restaurantId THEN
                THROW "Order does not belong to this restaurant"
            END IF

            // Update order status
            order.updateStatus(status)

            // If order is ready, notify delivery system
            IF status == "READY" THEN
                deliveryService.notifyOrderReady(orderId)
            END IF

            RETURN true
        END METHOD

END CLASS

### class diagram

fig 5.1 ![class diagram found in the in phas5  diagram folder](image.png)
