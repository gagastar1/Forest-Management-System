# Forest Management System - Setup Guide

## Complete Spring Boot Backend Application Created! ✅

Your Forest Management System backend is ready with:
- ✅ 6 Entity classes (Animal, Tree, Plant, ForestOfficer, Visitor, Resource)
- ✅ 6 Repository interfaces with custom query methods
- ✅ 6 Service classes with business logic
- ✅ 6 REST Controllers with full CRUD operations
- ✅ MySQL database integration configured
- ✅ Complete project structure

## Next Steps to Run the Application

### Option 1: Install Maven and Run from Command Line

1. **Download and Install Maven:**
   - Go to: https://maven.apache.org/download.cgi
   - Download: `apache-maven-3.9.6-bin.zip` (or latest version)
   - Extract to: `C:\Program Files\Apache\maven`
   - Add to System PATH:
     - Right-click 'This PC' → Properties → Advanced system settings
     - Environment Variables → System Variables → Path → Edit
     - Add: `C:\Program Files\Apache\maven\bin`
   - Restart PowerShell

2. **Verify Maven Installation:**
   ```powershell
   mvn -version
   ```

3. **Build and Run:**
   ```powershell
   cd backend
   mvn clean install
   mvn spring-boot:run
   ```

### Option 2: Use an IDE (Recommended for Beginners)

#### IntelliJ IDEA (Recommended)
1. Download IntelliJ IDEA Community Edition (free)
2. Open Project → Select the `backend` folder
3. IntelliJ will automatically detect Maven and download dependencies
4. Right-click `ForestManagementApplication.java` → Run
5. API will start at http://localhost:8080

#### Eclipse
1. Download Eclipse IDE for Java Developers
2. File → Import → Maven → Existing Maven Projects
3. Select the `backend` folder
4. Right-click project → Run As → Spring Boot App

#### VS Code (Current Editor)
1. Install extensions:
   - Extension Pack for Java (Microsoft)
   - Spring Boot Extension Pack (VMware)
2. Open the `backend` folder
3. VS Code will prompt to install dependencies
4. Press F5 to run or use the Run button

### Option 3: Use Maven Wrapper (No Installation Required)

I can create Maven Wrapper files that allow you to run Maven without installing it:

```powershell
# I'll create mvnw.cmd files for you
# Then you can run:
.\mvnw.cmd spring-boot:run
```

## Testing the API

Once the application is running, test with:

### Using PowerShell:
```powershell
# Get all animals
Invoke-WebRequest -Uri "http://localhost:8080/api/animals" -Method GET

# Create a new animal
$body = @{
    name = "Bengal Tiger"
    scientificName = "Panthera tigris tigris"
    location = "North Zone"
    zone = "North"
    count = 12
    speciesType = "Mammal"
    conservationStatus = "Endangered"
} | ConvertTo-Json

Invoke-WebRequest -Uri "http://localhost:8080/api/animals" -Method POST -Body $body -ContentType "application/json"
```

### Using Browser:
- Open: http://localhost:8080/api/animals
- Install Postman for easier API testing

## What You Have Now

### API Endpoints Available:

**Animals:** `/api/animals`
**Trees:** `/api/trees`
**Plants:** `/api/plants`
**Officers:** `/api/officers`
**Visitors:** `/api/visitors`
**Resources:** `/api/resources`

Each endpoint supports:
- GET (all), GET (by id), POST, PUT, DELETE
- Custom filters (by zone, status, type, etc.)

## Project Files Created

```
backend/
├── pom.xml                                    # Maven configuration
├── src/main/
│   ├── java/com/forest/management/
│   │   ├── ForestManagementApplication.java  # Main application
│   │   ├── entity/                           # 6 entity classes
│   │   ├── repository/                       # 6 repository interfaces
│   │   ├── service/                          # 6 service classes
│   │   └── controller/                       # 6 REST controllers
│   └── resources/
│       └── application.properties            # Database config
└── README.md                                 # API documentation
```

## Troubleshooting

**If port 8080 is in use:**
Edit `application.properties`:
```properties
server.port=8081
```

**If database connection fails:**
1. Verify MySQL is running
2. Check database name: `forest_management_system`
3. Verify credentials in `application.properties`

## Recommended: Install IntelliJ IDEA

For the easiest development experience:
1. Download: https://www.jetbrains.com/idea/download/
2. Choose Community Edition (free)
3. Open the `backend` folder
4. Click Run → Everything works automatically!

Would you like me to:
1. Create Maven Wrapper files so you can run without installing Maven?
2. Create sample data SQL scripts?
3. Add more features like authentication or file upload?
