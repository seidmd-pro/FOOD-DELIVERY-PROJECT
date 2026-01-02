## detailed database schema with constraints

// Database Table Definitions
TABLE Users
user_id INT PRIMARY KEY AUTO_INCREMENT,
email VARCHAR(255) UNIQUE NOT NULL,
password_hash VARCHAR(255) NOT NULL,
full_name VARCHAR(100) NOT NULL,
phone VARCHAR(20),
address TEXT,
user_type ENUM('CUSTOMER', 'RESTAURANT', 'RIDER', 'ADMIN') NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
INDEX idx_email (email),
INDEX idx_user_type (user_type)
END TABLE

TABLE Restaurants
restaurant_id INT PRIMARY KEY AUTO_INCREMENT,
owner_id INT NOT NULL,
name VARCHAR(255) NOT NULL,
description TEXT,
cuisine_type VARCHAR(100),
address TEXT NOT NULL,
latitude DECIMAL(10, 8),
longitude DECIMAL(11, 8),
phone VARCHAR(20),
email VARCHAR(255),
opening_time TIME,
closing_time TIME,
is_active BOOLEAN DEFAULT true,
rating DECIMAL(3, 2) DEFAULT 0.00,
FOREIGN KEY (owner_id) REFERENCES Users(user_id) ON DELETE CASCADE,
INDEX idx_location (latitude, longitude),
INDEX idx_cuisine (cuisine_type)
END TABLE

TABLE Menu_Items
item_id INT PRIMARY KEY AUTO_INCREMENT,
restaurant_id INT NOT NULL,
name VARCHAR(255) NOT NULL,
description TEXT,
price DECIMAL(10, 2) NOT NULL,
category VARCHAR(100),
is_available BOOLEAN DEFAULT true,
preparation_time INT, // in minutes
image_url VARCHAR(500),
FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id) ON DELETE CASCADE,
INDEX idx_restaurant (restaurant_id),
INDEX idx_category (category),
CHECK (price > 0)
END TABLE

TABLE Orders
order_id INT PRIMARY KEY AUTO_INCREMENT,
user_id INT NOT NULL,
restaurant_id INT NOT NULL,
total_amount DECIMAL(10, 2) NOT NULL,
delivery_address TEXT NOT NULL,
delivery_instructions TEXT,
status ENUM('PENDING', 'CONFIRMED', 'PREPARING', 'READY', 'ON_THE_WAY', 'DELIVERED', 'CANCELLED') DEFAULT 'PENDING',
rider_id INT,
estimated_delivery_time TIMESTAMP,
actual_delivery_time TIMESTAMP,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
FOREIGN KEY (user_id) REFERENCES Users(user_id),
FOREIGN KEY (restaurant_id) REFERENCES Restaurants(restaurant_id),
FOREIGN KEY (rider_id) REFERENCES Users(user_id),
INDEX idx_status (status),
INDEX idx_user (user_id),
INDEX idx_restaurant (restaurant_id),
INDEX idx_created (created_at),
CHECK (total_amount >= 0)
END TABLE

TABLE Order_Items
order_item_id INT PRIMARY KEY AUTO_INCREMENT,
order_id INT NOT NULL,
item_id INT NOT NULL,
quantity INT NOT NULL,
unit_price DECIMAL(10, 2) NOT NULL,
subtotal DECIMAL(10, 2) NOT NULL,
special_instructions TEXT,
FOREIGN KEY (order_id) REFERENCES Orders(order_id) ON DELETE CASCADE,
FOREIGN KEY (item_id) REFERENCES Menu_Items(item_id),
INDEX idx_order (order_id),
CHECK (quantity > 0),
CHECK (unit_price >= 0),
CHECK (subtotal = quantity \* unit_price)
END TABLE


