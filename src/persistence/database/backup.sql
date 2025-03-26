-- Tạo database 
-- create database quanlytourdulich;

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


-- Thêm dữ liệu vào bảng
INSERT INTO customer (id, username, password, role, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address, registrationDate, identityNumber, customerType)
VALUES
('C001', 'john_doe', 'password123', 'User', 'John', 'Doe', '1990-05-15', 'Male', '0123456789', 'john.doe@example.com', '123 Main St, New York', '2023-01-10', '123456789', 'Regular'),
('C002', 'jane_smith', 'securePass', 'Admin', 'Jane', 'Smith', '1988-11-22', 'Female', '0987654321', 'jane.smith@example.com', '456 Elm St, Los Angeles', '2023-02-05', '987654321', 'VIP'),
('C003', 'mike_jones', 'mikePass99', 'User', 'Mike', 'Jones', '1995-07-19', 'Male', '0934567890', 'mike.jones@example.com', '789 Oak St, Chicago', '2023-03-15', '456789123', 'Regular'),
('C004', 'susan_lee', 'susanLeePwd', 'User', 'Susan', 'Lee', '1992-03-30', 'Female', '0945678901', 'susan.lee@example.com', '159 Pine St, Houston', '2023-04-20', '789123456', 'Regular'),
('C005', 'tom_walker', 'walkerTom45', 'User', 'Tom', 'Walker', '1987-09-10', 'Male', '0956789012', 'tom.walker@example.com', '753 Birch St, Phoenix', '2023-05-10', '654321789', 'VIP'),
('C006', 'emma_harris', 'emmaH123', 'User', 'Emma', 'Harris', '1993-06-25', 'Female', '0967890123', 'emma.harris@example.com', '321 Cedar St, Philadelphia', '2023-06-12', '123789456', 'Regular'),
('C007', 'robert_brown', 'robertBrown789', 'User', 'Robert', 'Brown', '1990-12-05', 'Male', '0978901234', 'robert.brown@example.com', '654 Maple St, San Antonio', '2023-07-08', '987123654', 'Regular'),
('C008', 'linda_clark', 'lindaC999', 'User', 'Linda', 'Clark', '1997-02-14', 'Female', '0989012345', 'linda.clark@example.com', '951 Willow St, San Diego', '2023-08-21', '321654987', 'VIP'),
('C009', 'kevin_martin', 'kevinPass88', 'User', 'Kevin', 'Martin', '1985-08-30', 'Male', '0990123456', 'kevin.martin@example.com', '852 Redwood St, Dallas', '2023-09-18', '852369741', 'Regular'),
('C010', 'sarah_wilson', 'sarahW2023', 'User', 'Sarah', 'Wilson', '1994-10-01', 'Female', '0911234567', 'sarah.wilson@example.com', '357 Aspen St, San Jose', '2023-10-05', '951753468', 'Regular'),
('C011', 'peter_parker', 'spidey123', 'User', 'Peter', 'Parker', '1996-11-15', 'Male', '0922345678', 'peter.parker@example.com', '555 Hero St, New York', '2023-11-11', '456852123', 'VIP'),
('C012', 'natalie_cooper', 'natalieC777', 'User', 'Natalie', 'Cooper', '1991-04-20', 'Female', '0933456789', 'natalie.cooper@example.com', '777 Blossom St, Austin', '2023-12-09', '123654789', 'Regular'),
('C013', 'jackson_miller', 'jacksonM555', 'User', 'Jackson', 'Miller', '1989-07-07', 'Male', '0944567890', 'jackson.miller@example.com', '333 Forest St, Boston', '2024-01-15', '369852147', 'Regular'),
('C014', 'amanda_johnson', 'amandaJ333', 'User', 'Amanda', 'Johnson', '1992-09-25', 'Female', '0955678901', 'amanda.johnson@example.com', '444 Ocean St, Seattle', '2024-02-20', '147258369', 'VIP'),
('C015', 'ryan_adams', 'ryanA666', 'User', 'Ryan', 'Adams', '1990-06-10', 'Male', '0966789012', 'ryan.adams@example.com', '222 Park St, Miami', '2024-03-17', '789654321', 'Regular'),
('C016', 'michelle_wright', 'michelleW2024', 'User', 'Michelle', 'Wright', '1995-12-31', 'Female', '0977890123', 'michelle.wright@example.com', '666 River St, Denver', '2024-04-25', '321987654', 'Regular'),
('C017', 'chris_evans', 'captainA777', 'User', 'Chris', 'Evans', '1986-05-20', 'Male', '0988901234', 'chris.evans@example.com', '999 Shield St, Washington', '2024-05-12', '258369147', 'VIP'),
('C018', 'olivia_moore', 'oliviaM999', 'User', 'Olivia', 'Moore', '1993-08-14', 'Female', '0999012345', 'olivia.moore@example.com', '888 Sunset St, Portland', '2024-06-05', '753951852', 'Regular'),
('C019', 'daniel_roberts', 'danielR123', 'User', 'Daniel', 'Roberts', '1988-03-03', 'Male', '0910123456', 'daniel.roberts@example.com', '123 King St, Nashville', '2024-07-08', '852147963', 'Regular'),
('C020', 'emily_thomas', 'emilyT2024', 'User', 'Emily', 'Thomas', '1997-11-22', 'Female', '0921234567', 'emily.thomas@example.com', '321 Queen St, Las Vegas', '2024-08-30', '456321789', 'VIP');
