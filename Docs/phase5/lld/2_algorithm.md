## algorithm and pesudocode

/ Algorithm 1: Place Order Flow
ALGORITHM PLACE_ORDER
INPUT: userId, restaurantId, items[], deliveryAddress, paymentMethod
OUTPUT: Order object or error

BEGIN
// Step 1: Validate inputs
IF items IS EMPTY THEN
RETURN ERROR "Order must contain items"
END IF

    // Step 2: Check user and restaurant
    user = getUser(userId)
    IF user IS NULL THEN
        RETURN ERROR "User not found"
    END IF

    restaurant = getRestaurant(restaurantId)
    IF restaurant IS NULL OR NOT restaurant.isOpen() THEN
        RETURN ERROR "Restaurant unavailable"
    END IF

    // Step 3: Validate and price items
    totalAmount = 0.0
    orderItems = []

    FOR EACH item IN items DO
        menuItem = restaurant.getMenuItem(item.id)
        IF menuItem IS NULL THEN
            RETURN ERROR "Invalid menu item: " + item.id
        END IF

        IF item.quantity <= 0 THEN
            RETURN ERROR "Invalid quantity for item: " + item.id
        END IF

        // Create order item
        orderItem = {
            itemId: item.id,
            name: menuItem.name,
            quantity: item.quantity,
            unitPrice: menuItem.price,
            subtotal: menuItem.price * item.quantity
        }

        orderItems.append(orderItem)
        totalAmount = totalAmount + orderItem.subtotal
    END FOR

    // Step 4: Apply discounts
    discount = calculateDiscount(userId, totalAmount)
    finalAmount = totalAmount - discount

    // Step 5: Create order
    order = Order()
    order.orderId = generateUniqueId()
    order.userId = userId
    order.restaurantId = restaurantId
    order.items = orderItems
    order.totalAmount = finalAmount
    order.status = "PENDING"
    order.deliveryAddress = deliveryAddress
    order.createdAt = currentTimestamp()

    // Step 6: Process payment
    paymentResult = processPayment(userId, finalAmount, paymentMethod)
    IF paymentResult.status != "SUCCESS" THEN
        order.status = "PAYMENT_FAILED"
        saveOrder(order)
        RETURN ERROR "Payment failed: " + paymentResult.message
    END IF

    // Step 7: Save order
    order.paymentId = paymentResult.transactionId
    order.status = "CONFIRMED"
    saveOrder(order)

    // Step 8: Trigger notifications
    sendNotification(userId, "ORDER_CONFIRMED", order)
    sendNotification(restaurantId, "NEW_ORDER", order)

    // Step 9: Return order details
    RETURN {
        success: true,
        orderId: order.orderId,
        estimatedDeliveryTime: calculateETA(restaurant.location, deliveryAddress),
        totalAmount: finalAmount
    }

END ALGORITHM

// Algorithm 2: Assign Rider to Order
ALGORITHM ASSIGN_RIDER
INPUT: orderId
OUTPUT: rider assignment result

BEGIN
// Step 1: Get order details
order = getOrder(orderId)
IF order IS NULL THEN
RETURN ERROR "Order not found"
END IF

    IF order.status != "READY" THEN
        RETURN ERROR "Order is not ready for delivery"
    END IF

    // Step 2: Get restaurant location
    restaurant = getRestaurant(order.restaurantId)
    restaurantLocation = restaurant.location

    // Step 3: Find available riders
    availableRiders = getAvailableRiders()

    // Step 4: Calculate distances and select rider
    selectedRider = NULL
    minDistance = INFINITY

    FOR EACH rider IN availableRiders DO
        distance = calculateDistance(rider.currentLocation, restaurantLocation)

        // Consider rider rating and proximity
        score = calculateRiderScore(rider, distance)

        IF score > bestScore THEN
            bestScore = score
            selectedRider = rider
        END IF
    END FOR

    IF selectedRider IS NULL THEN
        RETURN ERROR "No available riders found"
    END IF

    // Step 5: Assign rider to order
    assignment = {
        orderId: orderId,
        riderId: selectedRider.id,
        assignedAt: currentTimestamp(),
        estimatedPickupTime: calculatePickupTime(selectedRider.currentLocation, restaurantLocation)
    }

    saveDeliveryAssignment(assignment)

    // Step 6: Update statuses
    updateOrderStatus(orderId, "ASSIGNED")
    updateRiderStatus(selectedRider.id, "BUSY")

    // Step 7: Send notifications
    sendNotification(selectedRider.id, "NEW_DELIVERY", assignment)
    sendNotification(order.userId, "RIDER_ASSIGNED", {
        riderName: selectedRider.name,
        estimatedDeliveryTime: calculateDeliveryTime(assignment.estimatedPickupTime, order.deliveryAddress)
    })

    RETURN {
        success: true,
        riderId: selectedRider.id,
        riderName: selectedRider.name,
        estimatedDeliveryTime: assignment.estimatedDeliveryTime
    }

END ALGORITHM
