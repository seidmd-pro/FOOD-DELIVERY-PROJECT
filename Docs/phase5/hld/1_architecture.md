### overview

KochaEats follows a Layered Microservices Architecture designed for scalability, reliability, and maintainability. The system is cloud-native, containerized, and built with modern DevOps practices to support high-volume food delivery operations in Ethiopian urban centers.

1. SYSTEM OVERVIEW

   - Brief description of KochaEats architecture
   - Architecture style choice (Microservices/Monolithic)

2. ARCHITECTURE DIAGRAM

   - Visual diagram created in Enterprise Architect
   - Shows all system components and connections

3. COMPONENT DESCRIPTIONS

   - Frontend: Mobile App, Web Portal, Admin Dashboard
   - Backend: API Gateway, Microservices
   - Database: PostgreSQL, Redis, MongoDB
   - External Services: Payment, SMS, Maps

4. DEPLOYMENT ARCHITECTURE

   - Cloud provider (AWS/Azure/Google Cloud)
   - Server setup, load balancing, scaling

5. TECHNOLOGY STACK

   - Programming languages, frameworks, tools

   # KochaEats System Architecture

## 1. Architecture Style

**Layered Microservices Architecture**

## 2. Key Components:

- **Frontend Layer**: React Native (Mobile), React.js (Web)
- **API Gateway**: Kong/Spring Cloud Gateway
- **Microservices**:
  - User Service (Authentication)
  - Order Service
  - Restaurant Service
  - Delivery Service
  - Payment Service
  - Notification Service
- **Database Layer**: PostgreSQL (primary), Redis (cache), MongoDB (analytics)
- **External Services**: Payment Gateways, SMS/Email, Maps API

## 3. Architecture Diagram:

fig 2.4 ![alt text](<../diagram/system architecture .png>)

## 4. Communication Patterns:

- REST APIs between services
- Message Queues for async notifications
- WebSockets for real-time tracking order
