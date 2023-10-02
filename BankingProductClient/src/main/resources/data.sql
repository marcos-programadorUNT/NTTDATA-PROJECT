INSERT INTO banks(business_name, direction, status)
VALUES ('BCP','Calle Las Magnolias 1', 'ACTIVE'),
       ('Banco de la Nación','Calle Emperatriz 2', 'ACTIVE');


INSERT INTO customers (email, address, phone_number, status, customer_type, first_name, last_name, document_number, date_of_birth)
VALUES ('test@email.com', 'Test Address', '123456789', 'ACTIVE', 'personal', 'John', 'Doe', '12345678', '1990-01-01');

INSERT INTO customers (email, address, phone_number, status, customer_type, first_name, last_name, document_number, date_of_birth)
VALUES ('test2@email.com', 'Test Address', '123213213', 'ACTIVE', 'personal', 'Anthony', 'Kiedis', '12312312', '2001-01-01');

INSERT INTO customers (email, address, phone_number, status, customer_type, first_name, last_name, document_number, date_of_birth)
VALUES ('test3@email.com', 'Test Address', '185693145', 'ACTIVE', 'personal', 'Marcos', 'Hernandez', '71238896', '2000-07-02');

INSERT INTO customers (email, address, phone_number, status, customer_type, first_name, last_name, document_number, date_of_birth)
VALUES ('test4@email.com', 'Test Address', '185645645', 'ACTIVE', 'personal', 'Estefania', 'Vargas', '14567863', '2000-06-09');

INSERT INTO customers (email, address, phone_number, status, customer_type, business_name, ruc, foundation_date)
VALUES ('test5@email.com', 'Test Address', '987654321', 'ACTIVE', 'business', 'Interbank', '12345678911', '1990-01-01');

INSERT INTO customers (email, address, phone_number, status, customer_type, business_name, ruc, foundation_date)
VALUES ('test6@email.com', 'Test Address', '977654321', 'ACTIVE', 'business', 'BanBif', '12312312311', '2010-01-01');


INSERT INTO banking_products(main_banking_product_type, banking_product_type,status,balance,registration_date,bank_id,customer_id, monthly_movement_limit,maintenance_commission_amount, specific_day_movement)
VALUES ('passive_banking_product','current_account','ACTIVE',1520,'2023-07-24',1,6,0,500,0),
       ('passive_banking_product','current_account','ACTIVE',162065.65,'2023-08-15',1,6,0,200,0);

INSERT INTO banking_products(main_banking_product_type,banking_product_type,status,balance,registration_date,bank_id,customer_id, monthly_movement_limit,maintenance_commission_amount, specific_day_movement)
VALUES ('passive_banking_product','savings_account','ACTIVE',1789.56,'2023-12-04',1,1,4,0,0),
       ('passive_banking_product','savings_account','ACTIVE',1236.47,'2023-05-12',1,2,5,0,0);

INSERT INTO banking_products(main_banking_product_type,banking_product_type,status,balance,registration_date,bank_id,customer_id, monthly_movement_limit,maintenance_commission_amount, specific_day_movement)
VALUES ('passive_banking_product','fixed_term_account','ACTIVE',14569.25,'2023-09-29',1,3,0,0,2);

INSERT INTO banking_products(main_banking_product_type,banking_product_type,status,balance,registration_date,bank_id,customer_id, monthly_movement_limit,maintenance_commission_amount, specific_day_movement)
VALUES ('active_banking_product','active_banking_product','ACTIVE',17896.47,'2023-07-31',1,4,0,0,0);

INSERT INTO movements(movement_type, status, money_required, registration_date, banking_product_id)
VALUES ('D','ACTIVE','500','2023-10-01',3),
       ('R','ACTIVE','650','2023-09-28',3),
       ('D','ACTIVE','100','2023-09-29',5),
       ('R','ACTIVE','140','2023-09-29',5),
       ('D','ACTIVE','200','2023-09-29',5)
