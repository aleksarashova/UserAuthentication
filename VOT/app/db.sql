CREATE TABLE orders (
        id SERIAL PRIMARY KEY,
        product VARCHAR(255),
        quantity INT,
        customer_id VARCHAR(255)
);
