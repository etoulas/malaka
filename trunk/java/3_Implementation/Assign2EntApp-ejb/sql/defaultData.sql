-- drop tables from sample db
DROP TABLE Micro_Markets;
DROP TABLE Orders;
DROP TABLE Product;
DROP TABLE Product_Code;
DROP TABLE Customer;
DROP TABLE Discount_Code;
DROP TABLE Manufacture;

-- delete all old Data
DELETE FROM BookingType;
DELETE FROM EventType;
DELETE FROM VehicleType;
DELETE FROM VehicleLicense;
DELETE FROM DriversLicense;

-- insert booking types
INSERT INTO BookingType VALUES (1, 'Transfer');
INSERT INTO BookingType VALUES (2, 'Hourly');

-- insert event types
INSERT INTO EventType VALUES (1, 'Wedding/Party/Special event');
INSERT INTO EventType VALUES (2, 'Other (drop off/pick up)');

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
