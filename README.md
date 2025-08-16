# Airport Management API

A Spring Boot REST API created for the DevOps and SDAT final project, designed to handle airport-related data such as flights, arrivals, and departures. The service offers full CRUD functionality and is built with reliability and easy deployment in mind, making it suitable for integration into automated CI/CD workflows.

## Features

### Airports

- Add new airports with name, IATA code, city, and country.
- Retrieve all airports or search by ID.
- Update airport information securely.
- Delete airport records.
- Built-in exception handling for invalid or missing airport data.

### Cities

- Create new cities with name, state, and population.
- Fetch all city entries or find by ID.
- Update city details.
- Delete city records.

### Passengers

- Register passengers with first name, last name,and  phone number.
- List all passengers or find one by ID.
- Edit passenger details safely
- Remove passenger records.

### Aircraft

- Add aircraft using tail number, model, and capacity.
- Retrieve all aircraft or query by ID.
- Update aircraft specifications or status.
- Delete aircraft entries.

### Airlines

- Create airlines with name and unique code.
- Retrieve all airlines or filter by ID.
- Update airline information.
- Delete airline records.

### Gates

- Add new gates with number, airport, and type (arrival/departure).
- Fetch all gates or filter by airport and designation.
- Update gate information and aircraft assignments.
- Delete gate entries.
- Assign specific aircraft to gates for arrivals/departures.

### Flights 

- Add flights with airline, aircraft, airports, and schedule times.
- Retrieve all flights or filter by airport, airline, status, or ID.
- Update flight details and manage statuses.
- Delete flight entries.
- Track arrivals and departures by airport.
- Manage flight delays with clear status reasons.

## Technologies

- Java 17
- Spring Boot  
- Spring Data JPA  
- Maven  
- MySQL / H2 Database  
- JUnit 5

## Setup

1. Clone the repo:  
   ```bash
   git clone https://github.com/KhoaPham-2002/Airport-Server-API
   cd airport-api
    ```
2. **Enter the project directory**

   ```bash
   cd Airport-Server-API
   ```
3. **Build and run**

   ```bash
   mvn clean package
   mvn spring-boot:run
   ```

## Authors

- **Khoa Pham**
