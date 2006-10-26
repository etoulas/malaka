-- drop tables from sample db
--DROP TABLE Purchase_Order
--DROP TABLE Micro_Market;
--DROP TABLE Orders;
--DROP TABLE Product;
--DROP TABLE Product_Code;
--DROP TABLE Customer;
--DROP TABLE Discount_Code;
--DROP TABLE Manufacture;

-- delete all old Data
DELETE FROM BookingType;
DELETE FROM EventType;
DELETE FROM VehicleType;
DELETE FROM VehicleLicense;
DELETE FROM DriversLicense;

-- insert booking types
INSERT INTO BookingType VALUES (1, 'Hourly');
INSERT INTO BookingType VALUES (2, 'Transfer');

-- insert event types
INSERT INTO EventType VALUES (1, 'Wedding',1);
INSERT INTO EventType VALUES (2, 'Party',1);
INSERT INTO EventType VALUES (3, 'Special event',1);
INSERT INTO EventType VALUES (4, 'Drop off/pick up)',2);

-- insert vehicle types
INSERT INTO VehicleType VALUES ('SEDAN', 'A standard luxury sedan', 4);
INSERT INTO VehicleType VALUES ('LIMO6', 'A six seater limo, fully a/c', 6);
INSERT INTO VehicleType VALUES ('LIMO8', 'A eight seater limo, fully a/c, bar and fridge', 8);

-- insert vehicle licenses
INSERT INTO VehicleLicense VALUES (1, 'SV License');
INSERT INTO VehicleLicense VALUES (2, 'VH License');

-- insert drivers licenses
INSERT INTO DriversLicense VALUES (1, 'HV License', '');
INSERT INTO DriversLicense VALUES (2, 'Taxi License', '');

INSERT INTO Address VALUES (1, 'Melbourne', 'Australia', 3122, '3', 'Park St', 'VIC', 'Hawthorn'); 
INSERT INTO Address VALUES (2, 'Melbourne', 'Australia', 3122, '3', 'Park St', 'VIC', 'Hawthorn');
INSERT INTO Address VALUES (3, 'Melbourne', 'Australia', 3122, '3', 'Park St', 'VIC', 'Hawthorn');
INSERT INTO Address VALUES (4, 'Melbourne', 'Australia', 3122, '3', 'Park St', 'VIC', 'Hawthorn');
INSERT INTO Address VALUES (5, 'Melbourne', 'Australia', 3122, '3', 'Park St', 'VIC', 'Hawthorn');

INSERT INTO Users VALUES ('Peter', 'Driver', 'Peter', 'Parker', 'Peter', '123', 1, 1, null);
INSERT INTO Users VALUES ('Bruce', 'Driver', 'Bruce', 'Wayne', 'Bruce', '123', 2, 2, null);
INSERT INTO Users VALUES ('Clark', 'Driver', 'Clark', 'Kent', 'Clark', '123', 3, 1, null);

INSERT INTO Booking VALUES (1, null, TIMESTAMP('20061101140000'), 0, TIMESTAMP('20061101120000'), null, 'Tim','Tim', 'Peter', null, 1, null, 4, 'SEDAN', 5);


