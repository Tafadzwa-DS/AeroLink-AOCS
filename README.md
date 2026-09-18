# AeroLink AOCS

## Airline Operations Control System

AeroLink AOCS is a Java-based airline operations simulation system designed to demonstrate how an airline can manage aircraft, flights, passengers, bookings, and operational reports from one central application.

## Why I Built This

I built AeroLink AOCS to combine my interest in aviation with my studies in Information Technology. The project gives me an opportunity to explore how software can be used to simulate and manage real-world airline operations while strengthening my Java and Object-Oriented Programming skills.

## Features

- Aircraft management
- Flight management
- Passenger registration and login
- Flight searching
- Passenger flight booking
- Seat availability validation
- Booking cancellation
- Aircraft assignment to flights
- Flight status management
- Operational reports
- Revenue calculation
- Custom exception handling

## Technologies

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Exception Handling
- Git and GitHub
- Command-Line Interface (CLI)

## Project Structure

AeroLink AOCS
└── src
    └── aviation
        ├── app          - main application and menu system
        ├── exceptions   - custom exceptions for invalid operations
        ├── model        - core domain objects
        └── service      - application and business logic

## Packages

- model - Aircraft, Flight, Airport, Passenger, Pilot, Crew, MaintenanceRecord, and PassengerBooking classes
- service - application logic for managing aircraft, flights, passengers, bookings, and reports
- exceptions - custom exceptions used to handle invalid operations and errors
- app - the main application, menu system, and test classes

## How to Run

Make sure Java is installed and available from the command line.

Navigate to the src directory:

cd src

Compile the project:

javac aviation/model/*.java aviation/service/*.java aviation/exceptions/*.java aviation/app/*.java

Run the application:

java aviation.app.Main

## Sample Usage

AeroLink AOCS provides separate workflows for administrative and passenger operations.

Admin
 ├── Manage Aircraft
 ├── Manage Flights
 └── View Reports

Passenger
 ├── Register
 ├── Login
 ├── Search Flights
 ├── Book Flight
 ├── View Bookings
 └── Cancel Booking

The application also demonstrates exception handling when users provide invalid aircraft, flight, passenger, booking, or seat information.

## Version

V1 focuses on demonstrating core airline-operations functionality using in-memory data structures, primarily ArrayList.

Future versions may introduce:

- Improved validation
- More advanced booking and seat-management rules
- Crew management
- Maintenance scheduling
- Additional Java data structures and algorithms
- Persistent data storage
- Expanded application interfaces

## Author

Tafadzwa Magweregwede

BSc Information Technology
University of Botswana