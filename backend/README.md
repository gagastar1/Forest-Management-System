# Forest Management System - Spring Boot Backend

A comprehensive REST API backend for managing forest resources, wildlife, personnel, and visitor tracking.

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

## Database Setup

1. Ensure MySQL is running
2. The database `forest_management_system` should already be created
3. Update `src/main/resources/application.properties` with your MySQL credentials:
   ```properties
   spring.datasource.username=root
   spring.datasource.password=your_password_here
   ```

## Building the Application

```bash
cd backend
mvn clean install
```

## Running the Application

```bash
mvn spring-boot:run
```

The API will start on `http://localhost:8080`

## API Endpoints

### Animals
- `GET /api/animals` - Get all animals
- `GET /api/animals/{id}` - Get animal by ID
- `POST /api/animals` - Create new animal
- `PUT /api/animals/{id}` - Update animal
- `DELETE /api/animals/{id}` - Delete animal
- `GET /api/animals/zone/{zone}` - Get animals by zone
- `GET /api/animals/conservation-status/{status}` - Get animals by conservation status

### Trees
- `GET /api/trees` - Get all trees
- `GET /api/trees/{id}` - Get tree by ID
- `POST /api/trees` - Create new tree
- `PUT /api/trees/{id}` - Update tree
- `DELETE /api/trees/{id}` - Delete tree
- `GET /api/trees/zone/{zone}` - Get trees by zone
- `GET /api/trees/health-status/{status}` - Get trees by health status

### Plants
- `GET /api/plants` - Get all plants
- `GET /api/plants/{id}` - Get plant by ID
- `POST /api/plants` - Create new plant
- `PUT /api/plants/{id}` - Update plant
- `DELETE /api/plants/{id}` - Delete plant
- `GET /api/plants/zone/{zone}` - Get plants by zone
- `GET /api/plants/medicinal` - Get medicinal plants

### Forest Officers
- `GET /api/officers` - Get all officers
- `GET /api/officers/{id}` - Get officer by ID
- `POST /api/officers` - Create new officer
- `PUT /api/officers/{id}` - Update officer
- `DELETE /api/officers/{id}` - Delete officer
- `GET /api/officers/zone/{zone}` - Get officers by zone
- `GET /api/officers/active` - Get active officers

### Visitors
- `GET /api/visitors` - Get all visitors
- `GET /api/visitors/{id}` - Get visitor by ID
- `POST /api/visitors` - Create new visitor
- `PUT /api/visitors/{id}` - Update visitor
- `DELETE /api/visitors/{id}` - Delete visitor
- `GET /api/visitors/date/{date}` - Get visitors by date (format: YYYY-MM-DD)
- `GET /api/visitors/zone/{zone}` - Get visitors by zone

### Resources
- `GET /api/resources` - Get all resources
- `GET /api/resources/{id}` - Get resource by ID
- `POST /api/resources` - Create new resource
- `PUT /api/resources/{id}` - Update resource
- `DELETE /api/resources/{id}` - Delete resource
- `GET /api/resources/zone/{zone}` - Get resources by zone
- `GET /api/resources/type/{type}` - Get resources by type

## Example API Calls

### Create a new animal
```bash
curl -X POST http://localhost:8080/api/animals \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Bengal Tiger",
    "scientificName": "Panthera tigris tigris",
    "location": "North Zone, Block A",
    "zone": "North",
    "count": 12,
    "speciesType": "Mammal",
    "conservationStatus": "Endangered",
    "lastSightingDate": "2025-12-01"
  }'
```

### Get all animals in a zone
```bash
curl http://localhost:8080/api/animals/zone/North
```

## Project Structure

```
backend/
├── src/
│   └── main/
│       ├── java/com/forest/management/
│       │   ├── ForestManagementApplication.java   # Main application
│       │   ├── entity/                            # JPA entities
│       │   │   ├── Animal.java
│       │   │   ├── Tree.java
│       │   │   ├── Plant.java
│       │   │   ├── ForestOfficer.java
│       │   │   ├── Visitor.java
│       │   │   └── Resource.java
│       │   ├── repository/                        # Data access layer
│       │   │   ├── AnimalRepository.java
│       │   │   ├── TreeRepository.java
│       │   │   ├── PlantRepository.java
│       │   │   ├── ForestOfficerRepository.java
│       │   │   ├── VisitorRepository.java
│       │   │   └── ResourceRepository.java
│       │   ├── service/                          # Business logic
│       │   │   ├── AnimalService.java
│       │   │   ├── TreeService.java
│       │   │   ├── PlantService.java
│       │   │   ├── ForestOfficerService.java
│       │   │   ├── VisitorService.java
│       │   │   └── ResourceService.java
│       │   └── controller/                       # REST controllers
│       │       ├── AnimalController.java
│       │       ├── TreeController.java
│       │       ├── PlantController.java
│       │       ├── ForestOfficerController.java
│       │       ├── VisitorController.java
│       │       └── ResourceController.java
│       └── resources/
│           └── application.properties            # Configuration
└── pom.xml                                       # Maven dependencies
```

## Technologies Used

- **Spring Boot 3.2.0** - Application framework
- **Spring Data JPA** - Data persistence
- **Hibernate** - ORM
- **MySQL** - Database
- **Lombok** - Reduce boilerplate code
- **Maven** - Dependency management

## Development

To package the application:
```bash
mvn package
```

To run tests:
```bash
mvn test
```

## Next Steps

1. **Test the API** - Use Postman or curl to test endpoints
2. **Add sample data** - Insert test data into the database
3. **Build a frontend** - Create a React/Angular/Vue.js frontend
4. **Add authentication** - Implement Spring Security
5. **Add validation** - Enhance data validation
6. **Add documentation** - Integrate Swagger/OpenAPI

## Troubleshooting

**Port already in use:**
Change the port in `application.properties`:
```properties
server.port=8081
```

**Database connection error:**
Verify MySQL is running and credentials are correct in `application.properties`

## License

This project is for educational purposes.
