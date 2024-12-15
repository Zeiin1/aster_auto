CREATE TABLE cars (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    make VARCHAR NOT NULL,
    model VARCHAR NOT NULL,
    year INT NOT NULL CHECK (year >= 1886 AND year <= extract(year from now())),
    price NUMERIC CHECK (price > 0),
    vin VARCHAR(17) UNIQUE NOT NULL
);

INSERT INTO cars (make, model, year, price, vin)
VALUES
    ('Toyota', 'Camry', 2020, 25000, '12345678901234567'),
    ('Tesla', 'Model S', 2021, 80000, '23456789012345678'),
    ('Ford', 'F-150', 2019, 30000, '34567890123456789'),
    ('Chevrolet', 'Impala', 2018, 20000, '45678901234567890'),
    ('Honda', 'Civic', 2022, 22000, '56789012345678901');
