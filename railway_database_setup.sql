-- Railway MySQL Database Setup for Forest Management System
-- Run this script in Railway MySQL Query tab

-- Drop existing tables if they exist (to avoid errors)
DROP TABLE IF EXISTS Resources;
DROP TABLE IF EXISTS Visitors;
DROP TABLE IF EXISTS ForestOfficers;
DROP TABLE IF EXISTS Plants;
DROP TABLE IF EXISTS Trees;
DROP TABLE IF EXISTS Animals;
DROP TABLE IF EXISTS users;

-- 1. Users Table (for authentication)
CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(20) NOT NULL DEFAULT 'USER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    is_active BOOLEAN DEFAULT TRUE
);

-- 2. Animals Table
CREATE TABLE Animals (
    animal_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    scientific_name VARCHAR(150) NOT NULL,
    location VARCHAR(200),
    zone VARCHAR(50),
    count INT DEFAULT 0,
    species_type VARCHAR(50),
    conservation_status VARCHAR(50),
    last_sighting_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 3. Trees Table
CREATE TABLE Trees (
    tree_id INT PRIMARY KEY AUTO_INCREMENT,
    common_name VARCHAR(100) NOT NULL,
    scientific_name VARCHAR(150) NOT NULL,
    location VARCHAR(200),
    zone VARCHAR(50),
    height_meters DECIMAL(5,2),
    age_years INT,
    diameter_cm DECIMAL(6,2),
    health_status VARCHAR(50),
    plantation_date DATE,
    tree_type VARCHAR(50),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 4. Plants Table
CREATE TABLE Plants (
    plant_id INT PRIMARY KEY AUTO_INCREMENT,
    common_name VARCHAR(100) NOT NULL,
    scientific_name VARCHAR(150) NOT NULL,
    location VARCHAR(200),
    zone VARCHAR(50),
    plant_type VARCHAR(50),
    coverage_area_sqm DECIMAL(8,2),
    flowering_season VARCHAR(50),
    medicinal_use BOOLEAN DEFAULT FALSE,
    count INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 5. Forest Officers Table
CREATE TABLE ForestOfficers (
    officer_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    employee_id VARCHAR(20) UNIQUE NOT NULL,
    designation VARCHAR(100),
    department VARCHAR(100),
    assigned_zone VARCHAR(50),
    contact_number VARCHAR(15),
    email VARCHAR(100),
    joining_date DATE,
    status VARCHAR(20) DEFAULT 'Active',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- 6. Visitors Table
CREATE TABLE Visitors (
    visitor_id INT PRIMARY KEY AUTO_INCREMENT,
    full_name VARCHAR(100) NOT NULL,
    contact_number VARCHAR(15),
    email VARCHAR(100),
    visit_date DATE NOT NULL,
    entry_time TIME,
    exit_time TIME,
    visitor_type VARCHAR(50),
    group_size INT DEFAULT 1,
    permit_number VARCHAR(50),
    zone_visited VARCHAR(50),
    purpose VARCHAR(200),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 7. Resources Table
CREATE TABLE Resources (
    resource_id INT PRIMARY KEY AUTO_INCREMENT,
    resource_name VARCHAR(100) NOT NULL,
    resource_type VARCHAR(50),
    quantity INT DEFAULT 0,
    unit VARCHAR(20),
    location VARCHAR(200),
    assigned_zone VARCHAR(50),
    assigned_officer_id INT,
    condition_status VARCHAR(50),
    purchase_date DATE,
    last_maintenance_date DATE,
    next_maintenance_date DATE,
    cost DECIMAL(10,2),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (assigned_officer_id) REFERENCES ForestOfficers(officer_id)
);

-- Create Indexes for Better Performance
CREATE INDEX idx_animals_zone ON Animals(zone);
CREATE INDEX idx_animals_conservation ON Animals(conservation_status);
CREATE INDEX idx_trees_zone ON Trees(zone);
CREATE INDEX idx_trees_health ON Trees(health_status);
CREATE INDEX idx_plants_zone ON Plants(zone);
CREATE INDEX idx_officers_zone ON ForestOfficers(assigned_zone);
CREATE INDEX idx_officers_status ON ForestOfficers(status);
CREATE INDEX idx_visitors_date ON Visitors(visit_date);
CREATE INDEX idx_visitors_zone ON Visitors(zone_visited);
CREATE INDEX idx_resources_zone ON Resources(assigned_zone);
CREATE INDEX idx_resources_type ON Resources(resource_type);

-- Insert sample data for testing
INSERT INTO users (username, email, password, role) VALUES 
('admin', 'admin@forest.com', '$2a$10$xJ3h5KwUMqLl5QZvZQGz0.FGGKvz5q5vq5vq5vq5vq5vq5vq5vq5vq', 'ADMIN');

INSERT INTO Animals (name, scientific_name, location, zone, count, species_type, conservation_status, last_sighting_date) VALUES
('Bengal Tiger', 'Panthera tigris tigris', 'Zone A Forest', 'Zone A', 12, 'Mammal', 'Endangered', '2025-12-01'),
('Asian Elephant', 'Elephas maximus', 'Zone B Forest', 'Zone B', 8, 'Mammal', 'Endangered', '2025-11-28');

INSERT INTO Trees (common_name, scientific_name, location, zone, height_meters, age_years, diameter_cm, health_status, tree_type) VALUES
('Teak Tree', 'Tectona grandis', 'Zone A', 'Zone A', 25.5, 50, 80.0, 'Healthy', 'Deciduous'),
('Banyan Tree', 'Ficus benghalensis', 'Zone B', 'Zone B', 30.0, 100, 120.5, 'Healthy', 'Evergreen');

-- Display success message
SELECT 'All tables created successfully! You can now test the API.' AS Status;
