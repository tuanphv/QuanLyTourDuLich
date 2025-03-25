-- Tạo database 
create database quanlytourdulich;

-- Tạo các bảng
use quanlytourdulich;

-- Bảng khách hàng
CREATE TABLE customer (
    id VARCHAR(255) PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50),
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    dateOfBirth DATE,
    gender VARCHAR(10),
    phoneNumber VARCHAR(20),
    email VARCHAR(255),
    address TEXT,
    registrationDate DATE,
    identityNumber VARCHAR(50),
    customerType VARCHAR(50)
);

-- Bảng nhân viên
CREATE TABLE employee (
    id VARCHAR(255) PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50),
    firstName VARCHAR(255),
    lastName VARCHAR(255),
    dateOfBirth DATE,
    gender VARCHAR(10),
    phoneNumber VARCHAR(20),
    email VARCHAR(255),
    address TEXT,
    startDate DATE,
    position VARCHAR(255),
    status VARCHAR(50)
);

-- Các bảng dịch vụ (khách sạn, nhà hàng, phương tiện di chuyển)
CREATE TABLE hotel_service (
    serviceId VARCHAR(255) PRIMARY KEY,
    serviceName VARCHAR(255),
    description TEXT,
    price FLOAT,
    isAvailable BOOLEAN,
    hotelName VARCHAR(255),
    starRating INT,
    location VARCHAR(255),
    hasBreakfast BOOLEAN
);

CREATE TABLE restaurant_service (
    serviceId VARCHAR(255) PRIMARY KEY,
    serviceName VARCHAR(255),
    description TEXT,
    price FLOAT,
    isAvailable BOOLEAN,
    restaurantName VARCHAR(255),
    location VARCHAR(255),
    serviceType VARCHAR(255)
);

CREATE TABLE transportation_service (
    serviceId VARCHAR(255) PRIMARY KEY,
    serviceName VARCHAR(255),
    description TEXT,
    price FLOAT,
    isAvailable BOOLEAN,
    transportType VARCHAR(255),
    company VARCHAR(255),
    capacity INT
);

-- Các bảng tour
CREATE TABLE tour (
    tourId VARCHAR(255) PRIMARY KEY,
    tourName VARCHAR(255),
    price FLOAT,
    status VARCHAR(50),
    details TEXT,
    thumbnail TEXT,
    departurePoint VARCHAR(255),
    destination VARCHAR(255),
    tourType VARCHAR(255),
    numDay INT,
    numNight INT
);

CREATE TABLE tour_plan (
    tourPlanId VARCHAR(255) PRIMARY KEY,
    tourId VARCHAR(255),
    startDate DATE,
    endDate DATE,
    ticketLimit INT,
    ticketsBooked INT,
    status VARCHAR(50),
    totalCost FLOAT,
    totalRevenue FLOAT,
    FOREIGN KEY (tourId) REFERENCES tour(tourId)
);

-- Bảng hoá đơn
CREATE TABLE invoice (
    invoiceId VARCHAR(255) PRIMARY KEY,
    customerId VARCHAR(255),
    employeeId VARCHAR(255),
    tourPlanId VARCHAR(255),
    ticketCount INT,
    totalAmount FLOAT,
    notes TEXT,
    promoCode VARCHAR(50),
    invoiceDate DATE,
    status VARCHAR(50),
    FOREIGN KEY (customerId) REFERENCES customer(id),
    FOREIGN KEY (employeeId) REFERENCES employee(id),
    FOREIGN KEY (tourPlanId) REFERENCES tour_plan(tourPlanId)
);
CREATE TABLE invoice_details (
    invoiceId VARCHAR(255),
    ticketId VARCHAR(255),
    customerId VARCHAR(255),
    ticketPrice FLOAT,
    PRIMARY KEY (invoiceId, ticketId),
    FOREIGN KEY (invoiceId) REFERENCES invoice(invoiceId),
    FOREIGN KEY (customerId) REFERENCES customer(id)
);