# 1. System Architecture Design (HLD)

## Overview
The KochaEats Food Delivery System follows a **multi-tier web architecture** designed for scalability,
security, and maintainability.

## Architecture Type
- Client–Server Architecture
- Modular Monolithic (Frontend + Backend Logic + Data Layer)
- Service-oriented internal structure

## Components
1. Client Layer (Web Browser)
2. Application Layer
3. Data Layer
4. External Services

## Architecture Diagram
**Figure 1:** Overall System Architecture  
_(Insert Architecture Diagram Image here)_

## Component Description

### Client Layer
- Web browser (HTML, CSS, JavaScript)
- Handles UI, language switching, cart interaction

### Application Layer
- Business logic (cart, order, coupon, authentication)
- State management (AppState class)
- Validation & security helpers

### Data Layer
- Local Storage (users, cart, orders)
- Database (future backend support)

### External Services
- Google Maps (delivery location)
- Payment gateways (Telebirr, CBE, Amole)
- Notification system
![alt text](<Screenshot 2025-12-27 071043-2.png>)