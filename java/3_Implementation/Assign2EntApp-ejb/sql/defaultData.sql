INSERT INTO BookingType VALUES (1, 'Transfer');
INSERT INTO BookingType VALUES (2, 'Hourly');

--Delete all old Data
DELETE FROM VEHICLETYPE;
DELETE FROM VEHICLELICENSE;

--Insert values into VehicleTypes
INSERT INTO VEHICLETYPE VALUES('SEDAN','A standard luxury sedan',4);
INSERT INTO VEHICLETYPE VALUES('LIMO6','A six seater limo',6);
INSERT INTO VEHICLETYPE VALUES('LIMO8','A eight seater limo',8);

--Insert values for License
INSERT INTO VEHICLELICENSE VALUES(1,'HV Licence');
INSERT INTO VEHICLELICENSE VALUES(2,'Taxi Licence');