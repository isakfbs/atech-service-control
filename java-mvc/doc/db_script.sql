CREATE TABLE CUSTOMERS (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(255)
);

CREATE TABLE ADDRESSES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fk_customer_id INT,
    street VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    postal_code VARCHAR(20),
    country VARCHAR(255),
    FOREIGN KEY (fk_customer_id) REFERENCES CUSTOMERS(id)
);

CREATE TABLE DEVICES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fk_customer_id INT,
    type VARCHAR(255),
    brand VARCHAR(255),
    model VARCHAR(255),
    serial_number VARCHAR(255),
    FOREIGN KEY (fk_customer_id) REFERENCES CUSTOMERS(id)
);

CREATE TABLE SERVICES (
    id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    device_id INT,
    description TEXT,
    status VARCHAR(50),
    start_date DATETIME,
    end_date DATETIME,
    cost DECIMAL(10, 2),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMERS(id),
    FOREIGN KEY (device_id) REFERENCES DEVICES(id)
);