# 3. Detailed Database Tables (LLD)

## User Table
| Field | Type |
|-----|------|
| user_id | VARCHAR |
| name | VARCHAR |
| email | VARCHAR |
| phone | VARCHAR |
| role | VARCHAR |

## Order Table
| Field | Type |
|------|------|
| order_id | VARCHAR |
| user_id | VARCHAR |
| total | DECIMAL |
| status | VARCHAR |

## MenuItem Table
| Field | Type |
|------|------|
| item_id | INT |
| name | VARCHAR |
| price | DECIMAL |
| restaurant_id | INT |
