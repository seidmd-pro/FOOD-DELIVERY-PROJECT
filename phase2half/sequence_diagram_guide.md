# Sequence Diagrams Guide for KochaEats Food Delivery System

## Overview

Sequence diagrams show object interactions arranged in time sequence. For KochaEats, we need 3-4 sequence diagrams showing the message flow between objects for key operations.

---

## Diagram 1: Place Order Sequence

### **Diagram Title:** "sequence-diagram-place-order"

fig 2.1 ![you can get in phase5 folder diagram folder](../phase5/diagram/sequence-diagram-place-order.png)

### **Objects/Actors:**

- Customer (User)
- MobileApp (Frontend)
- OrderController (Backend)
- RestaurantService
- PaymentService
- NotificationService
- Database

### **Sequence Flow:**

┌──────────┐ ┌─────────────┐ ┌──────────────┐ ┌────────────────┐ ┌──────────────┐ ┌──────────────────┐ ┌──────────┐
│ Customer │ │ MobileApp │ │OrderController│ │RestaurantService│ │PaymentService│ │NotificationService│ │ Database │
└─────┬────┘ └──────┬──────┘ └──────┬───────┘ └────────┬───────┘ └──────┬───────┘ └─────────┬─────────┘ └────┬─────┘
│ │ │ │ │ │ │
│ 1: Select Items │ │ │ │ │ │
│───────────────> │ │ │ │ │ │
│ │ │ │ │ │ │
│ 2: Place Order │ │ │ │ │ │
│───────────────> │ │ │ │ │ │
│ │ 3: POST /api/orders│ │ │ │ │
│ │──────────────────>│ │ │ │ │
│ │ │ │ │ │ │
│ │ │ 4: Validate Order │ │ │ │
│ │ │────────────────────>│ │ │ │
│ │ │ │ │ │ │
│ │ │ 5: Check Restaurant │ │ │ │
│ │ │────────────────────>│ │ │ │
│ │ │ │ │ │ │
│ │ │ │ 6: isAvailable() │ │ │
│ │ │ │<───────────────────│ │ │
│ │ │ │ │ │ │
│ │ │ 7: Calculate Total │ │ │ │
│ │ │────────────────────>│ │ │ │
│ │ │ │ │ │ │
│ │ │ 8: Process Payment │ │ │ │
│ │ │─────────────────────────────────────────>│ │ │
│ │ │ │ │ │ │
│ │ │ │ │ 9: charge() │ │
│ │ │ │ │<────────────────────│ │
│ │ │ │ │ │ │
│ │ │ │ │10: Payment Result │ │
│ │ │ │ │────────────────────>│ │
│ │ │ │ │ │ │
│ │ │11: Save Order │ │ │ │
│ │ │───────────────────────────────────────────────────────────────────────────────────>│
│ │ │ │ │ │ │
│ │ │12: Order Saved │ │ │ │
│ │ │<───────────────────────────────────────────────────────────────────────────────────│
│ │ │ │ │ │ │
│ │ │13: Notify Restaurant│ │ │ │
│ │ │───────────────────────────────────────────────┐ │ │
│ │ │ │ │ │ │
│ │ │ │ │ 14: sendSMS() │ │
│ │ │ │ │<────────────────│ │
│ │ │ │ │ │ │
│ │ │15: Notify Customer │ │ │ │
│ │ │─────────────────────────────────────────────────────────────────────────────────────>│
│ │ │ │ │ │ │
│ │ │ │ │ 16: sendPush() │ │
│ │ │ │ │<───────────────────────────────────────│
│ │ │ │ │ │ │
│ │ │17: Order Confirmation│ │ │ │
│ │<───────────────────│ │ │ │ │
│ │ │ │ │ │ │
│18: Display Confirmation│ │ │ │ │ │
│<─────────────────│ │ │ │ │ │
│ │ │ │ │ │ │
│ │ │ │ │ │ │

text

### **Key Messages:**

1. `POST /api/orders` - HTTP request to create order
2. `isAvailable()` - Check restaurant availability
3. `charge()` - Process payment
4. `saveOrder()` - Persist order to database
5. `sendSMS()`, `sendPush()` - Notification methods

---

## Diagram 2: Assign Rider to Order

### **Diagram Title:** "Rider Assignment Sequence"

### **Objects/Actors:**

- RestaurantSystem
- OrderService
- RiderService
- LocationService
- NotificationService
- Rider (User)
- Database

### **Sequence Flow:**

┌────────────────┐┌──────────────┐┌──────────────┐┌────────────────┐┌──────────────────┐┌──────────┐┌──────────┐
│RestaurantSystem││ OrderService ││ RiderService ││LocationService││NotificationService││ Rider ││ Database │
└────────┬───────┘└──────┬───────┘└──────┬───────┘└───────┬───────┘└─────────┬────────┘└─────┬─────┘└────┬─────┘
│ │ │ │ │ │ │
│1: Order Ready │ │ │ │ │ │
│───────────────>│ │ │ │ │ │
│ │ │ │ │ │ │
│ │2: findAvailableRiders()│ │ │ │ │
│ │────────────────────────>│ │ │ │ │
│ │ │ │ │ │ │
│ │ │3: getNearbyRiders() │ │ │ │
│ │ │───────────────────────────>│ │ │ │
│ │ │ │ │ │ │
│ │ │ │4: Query DB │ │ │ │
│ │ │ │──────────────────────────────────────────────────────>│
│ │ │ │ │ │ │
│ │ │ │5: Riders List │ │ │ │
│ │ │ │<───────────────────────────────────────────────────────│
│ │ │ │ │ │ │
│ │ │6: Calculate Distances │ │ │ │
│ │ │───────────────────────────>│ │ │ │
│ │ │ │ │ │ │
│ │ │ │7: Distance Matrix │ │ │ │
│ │ │ │<───────────────────│ │ │ │
│ │ │ │ │ │ │
│ │ │8: Select Optimal Rider │ │ │ │
│ │ │───────────────────────────>│ │ │ │
│ │ │ │ │ │ │
│ │ │9: Assign Rider to Order │ │ │ │
│ │ │────────────────────────────────────────────────────────────────────────────>│
│ │ │ │ │ │ │
│ │ │10: Update Order Status │ │ │ │
│ │ │────────────────────────────────────────────────────────────────────────────>│
│ │ │ │ │ │ │
│ │ │11: Notify Rider │ │ │ │
│ │ │──────────────────────────────────────────────┐ │ │
│ │ │ │ │ │ │ │
│ │ │ │ │12: createNotification()│ │ │
│ │ │ │ │<─────────────────│ │ │
│ │ │ │ │ │ │ │
│ │ │ │ │13: Send Push │ │ │
│ │ │ │ │─────────────────────────────────────>│ │
│ │ │ │ │ │ │ │
│ │ │ │ │ │14: Display │ │
│ │ │ │ │ │──────────────>│ │
│ │ │ │ │ │ │ │
│ │ │15: Rider Accepts │ │ │ │
│ │ │<─────────────────────────────────────────────────────────────────────────────│
│ │ │ │ │ │ │ │
│ │16: Confirm Assignment│ │ │ │ │ │
│ │<───────────────────────│ │ │ │ │ │
│ │ │ │ │ │ │ │
│17: Update Dashboard│ │ │ │ │ │ │
│<─────────────────│ │ │ │ │ │ │
│ │ │ │ │ │ │ │

text

### **Key Messages:**

1. `findAvailableRiders()` - Find riders marked as available
2. `getNearbyRiders()` - Filter by proximity to restaurant
3. `calculateDistances()` - Compute travel distances
4. `createNotification()` - Generate rider notification
5. `sendPush()` - Send push notification to rider app

---

## Diagram 3: Track Order Status

### **Diagram Title:** "sequence-diagram-track-order"

![track order image](../phase5/diagram/sequence-diagram-track-order.png)

fig 2.3

### **Objects/Actors:**

- Customer (User)
- MobileApp (Frontend)
- OrderService (Backend)
- RestaurantService
- DeliveryService
- WebSocketService
- Database

### **Sequence Flow:**

┌──────────┐ ┌─────────────┐ ┌──────────────┐ ┌────────────────┐ ┌────────────────┐ ┌──────────────────┐ ┌──────────┐
│ Customer │ │ MobileApp │ │ OrderService │ │RestaurantService│ │DeliveryService│ │WebSocketService │ │ Database │
└─────┬────┘ └──────┬──────┘ └──────┬───────┘ └────────┬───────┘ └───────┬───────┘ └─────────┬────────┘ └────┬─────┘
│ │ │ │ │ │ │
│1: Open Tracking │ │ │ │ │ │
│───────────────> │ │ │ │ │ │
│ │ │ │ │ │ │
│ │2: GET /api/orders/{id}/track│ │ │ │ │
│ │──────────────────>│ │ │ │ │
│ │ │ │ │ │ │
│ │ │3: Get Order Details │ │ │ │
│ │ │────────────────────────────────────────────────────────────────────────────────────>│
│ │ │ │ │ │ │
│ │ │4: Order Data │ │ │ │
│ │ │<─────────────────────────────────────────────────────────────────────────────────────│
│ │ │ │ │ │ │
│ │ │5: Get Restaurant Status│ │ │ │ │
│ │ │────────────────────>│ │ │ │ │
│ │ │ │ │ │ │ │
│ │ │ │6: Current Status │ │ │ │
│ │ │ │<───────────────────│ │ │ │
│ │ │ │ │ │ │ │
│ │ │7: Get Delivery Status│ │ │ │ │
│ │ │─────────────────────────────────────────>│ │ │ │
│ │ │ │ │ │ │ │
│ │ │ │ │8: Rider Location │ │ │
│ │ │ │ │<───────────────────│ │ │
│ │ │ │ │ │ │ │
│ │ │9: Compile Tracking Info│ │ │ │ │
│ │ │<───────────────────────┐ │ │ │ │
│ │ │ │ │ │ │ │
│ │ │10: Initial Response │ │ │ │ │
│ │<───────────────────│ │ │ │ │ │
│ │ │ │ │ │ │ │
│ │11: Display Status │ │ │ │ │ │
│<─────────────────│ │ │ │ │ │ │
│ │ │ │ │ │ │ │
│ │ │12: Establish WebSocket │ │ │ │ │
│ │────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────>│
│ │ │ │ │ │ │ │
│ │ │ │ │ │13: Connection Open │ │
│ │ │ │ │ │<─────────────────────│ │
│ │ │ │ │ │ │ │
│ │ │ │ │14: Status Update │ │ │
│ │ │ │ │─────────────────────────────────────────────>│ │
│ │ │ │ │ │ │ │
│ │ │ │ │ │15: Push to Client │ │
│ │ │ │ │ │───────────────────────────────────────────────>│
│ │ │ │ │ │ │ │
│ │16: Real-time Update│ │ │ │ │ │
│<─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────│
│ │ │ │ │ │ │ │
│ │ │ │ │ │ │ │
│ │ │ │ │ │ │ │
│17: Order Delivered│ │ │ │ │ │ │
│ │ │ │ │ │ │ │
│ │18: Close Connection│ │ │ │ │ │
│ │───────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────────>│
│ │ │ │ │ │ │ │

### how can create a sequence diagram

Step 1: Create Sequence Diagram Package

1. In Project Browser, right-click "Phase2_UML_Diagrams"
2. Select "Add → Package"
3. Name: "SequenceDiagrams"
4. Click "OK"
   Step 2: Enable Sequence Diagram Toolbox

5. Press Ctrl+Shift+3 to open Toolbox
6. Click drop-down menu at top
7. Select "UML Behavioral"
8. Scroll down to "Sequence" section

## Add Lifelines (7 Required)

METHOD 1: Drag and Drop

1. From Toolbox → "Lifeline"
2. Click on diagram 7 times
3. Space evenly across top

METHOD 2: Quick Create

1. Select "Lifeline" tool
2. Hold Ctrl key
3. Click 7 times horizontally
4. Double-click each to rename:

LIFELINES TO CREATE (left to right):

1. :Customer (actor)
2. :MobileApp (boundary)
3. :OrderController (control)
4. :RestaurantService (control)
5. :PaymentService (control)
6. :NotificationService (control)
7. :Database (entity)

FORMAT LIFELINES:

1. Select all lifelines (Ctrl+A)
2. Right-click → Appearance
3. Set Fill Color: Light Blue
4. Line Width: 2px
