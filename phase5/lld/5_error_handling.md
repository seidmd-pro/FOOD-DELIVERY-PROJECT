## error handling

/ Centralized Error Handler
CLASS ErrorHandler
METHOD handleOrderError(errorType, context): ErrorResponse
errorMap = {
"INVALID_QUANTITY": {
code: 400,
message: "Item quantity must be greater than 0",
action: "Please update the quantity and try again"
},
"RESTAURANT_CLOSED": {
code: 403,
message: "The restaurant is currently closed",
action: "Please try again during operating hours"
},
"PAYMENT_FAILED": {
code: 402,
message: "Payment processing failed",
action: "Please check your payment method and try again"
},
"NO_RIDER_AVAILABLE": {
code: 503,
message: "No delivery riders available at the moment",
action: "Please try again in a few minutes"
},
"ORDER_CANCELLATION_EXPIRED": {
code: 400,
message: "Order can no longer be cancelled",
action: "Contact customer support for assistance"
}
}

        IF errorType IN errorMap THEN
            error = errorMap[errorType]
            logError(errorType, context)

            RETURN {
                success: false,
                error: {
                    code: error.code,
                    message: error.message,
                    action: error.action,
                    timestamp: currentTimestamp(),
                    referenceId: generateErrorId()
                }
            }
        ELSE
            RETURN genericError()
        END IF
    END METHOD

    METHOD validateOrderInput(orderData): ValidationResult
        errors = []

        // Validate items
        IF orderData.items IS EMPTY OR orderData.items IS NULL THEN
            errors.append("Order must contain at least one item")
        END IF

        FOR EACH item IN orderData.items DO
            IF item.quantity <= 0 THEN
                errors.append("Quantity for item '" + item.name + "' must be positive")
            END IF

            IF item.id IS NULL OR item.id <= 0 THEN
                errors.append("Invalid item ID")
            END IF
        END FOR

        // Validate delivery address
        IF orderData.deliveryAddress IS NULL OR orderData.deliveryAddress IS EMPTY THEN
            errors.append("Delivery address is required")
        END IF

        IF length(orderData.deliveryAddress) < 10 THEN
            errors.append("Delivery address is too short")
        END IF

        // Validate payment method
        validPaymentMethods = ["CREDIT_CARD", "DEBIT_CARD", "MOBILE_PAYMENT", "CASH_ON_DELIVERY"]
        IF orderData.paymentMethod NOT IN validPaymentMethods THEN
            errors.append("Invalid payment method")
        END IF

        IF errors IS EMPTY THEN
            RETURN {valid: true, errors: []}
        ELSE
            RETURN {valid: false, errors: errors}
        END IF
    END METHOD

END CLASS

// Input Validation Decorator Pattern
DECORATOR ValidatedOrderService EXTENDS OrderService
METHOD placeOrder(orderData): Order
// Validate before processing
validation = validator.validateOrderInput(orderData)
IF NOT validation.valid THEN
THROW ValidationException(validation.errors)
END IF

        // Proceed with original logic
        RETURN super.placeOrder(orderData)
    END METHOD

END DECORATOR
