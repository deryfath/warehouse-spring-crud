
CREATE DATABASE IF NOT EXISTS warehouse_db;
USE warehouse_db;

CREATE TABLE items (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE variants (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    color VARCHAR(100),
    size VARCHAR(50),
    price DECIMAL(12,2) NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    item_id BIGINT,
    CONSTRAINT fk_variant_item FOREIGN KEY (item_id) REFERENCES items(id) ON DELETE CASCADE
);

INSERT INTO items (name) VALUES
('T-Shirt'),
('Sneakers'),
('Backpack');


INSERT INTO variants (color, size, price, stock, item_id) VALUES
('Red', 'M', 150000, 10, 1),
('Blue', 'L', 150000, 5, 1),
('White', '42', 550000, 8, 2),
('Black', '43', 550000, 2, 2),
('Green', 'Medium', 350000, 7, 3);
