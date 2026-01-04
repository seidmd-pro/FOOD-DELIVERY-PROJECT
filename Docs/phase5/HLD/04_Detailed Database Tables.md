# Detailed Database Tables

## User Table
| Field    | Type     |
|---------|----------|
| user_id | VARCHAR  |
| name    | VARCHAR  |
| email   | VARCHAR  |
| phone   | VARCHAR  |
| role    | VARCHAR  |

## Order Table
| Field     | Type     |
|----------|----------|
| order_id | VARCHAR  |
| user_id  | VARCHAR  |
| status   | VARCHAR  |
| total    | DOUBLE   |

## Restaurant Table
| Field         | Type     |
|--------------|----------|
| restaurant_id| VARCHAR  |
| name         | VARCHAR  |
| location     | VARCHAR  |
