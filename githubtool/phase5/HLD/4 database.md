# 4. High-Level Database Design (HLD)

## Overview
The database is designed to support users, restaurants, menus, orders, payments, and delivery.

## High-Level Entities
- User
- Restaurant
- MenuItem
- Order
- OrderItem
- Coupon
- Payment
- Delivery

## Database Diagram
**Figure 5:** High-Level ER Diagram  
_(Insert ER Diagram Image here)_

## Key Relationships
- User places Order
- Restaurant provides MenuItem
- Order contains OrderItems
- Order uses Coupon
- Order has Payment and Delivery
