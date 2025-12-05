# 🚀 Quick Start Guide

## ✅ System Status

### Backend Server
- **Status:** Running ✅
- **Port:** 8080
- **URL:** http://localhost:8080
- **API Base:** http://localhost:8080/api

### Frontend Server
- **Status:** Running ✅
- **Port:** 3000
- **URL:** http://localhost:3000

### Database
- **Type:** MySQL
- **Host:** localhost:3306
- **Database:** forest_management_system
- **User:** root
- **Password:** Giri@#2004

---

## 🎯 How to Use

### 1. First Time Access
1. Open browser: `http://localhost:3000`
2. You'll be redirected to the login/signup page
3. Click **"Sign Up"** to create your admin account
4. Fill in:
   - Username
   - Email
   - Password
   - Confirm Password
5. Click **"Sign Up"**

### 2. Login
1. Enter your username and password
2. Click **"Sign In"**
3. You'll be redirected to the dashboard

### 3. Access Modules
From the dashboard, click on any module card:
- 🦁 **Animals** - Wildlife management
- 🌳 **Trees** - Tree inventory
- 🌿 **Plants** - Plant catalog
- 👮 **Forest Officers** - Staff management
- 🎫 **Visitors** - Visitor tracking
- 🛠️ **Resources** - Resource allocation

### 4. Logout
Click the **"Logout"** button in the top-right corner of the dashboard

---

## 📍 Where Configurations Are Located

### Backend API Endpoints (Database Connection)
**File:** `backend/src/main/resources/application.properties`

Change database settings here:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/forest_management_system
spring.datasource.username=root
spring.datasource.password=Giri@#2004
```

### Frontend API Connection (Backend Connection)
**File:** `frontend/lib/api.ts`

Change backend URL here:
```typescript
const API_BASE_URL = 'http://localhost:8080/api';
```

Also in: `frontend/app/auth/page.tsx` (line ~37)
```typescript
const response = await fetch(`http://localhost:8080/api/auth/...`);
```

---

## 🔧 Starting/Stopping Servers

### Start Backend
```bash
cd backend
.\mvnw.cmd spring-boot:run
```

### Start Frontend
```bash
cd frontend
npm run dev
```

### Stop Servers
Press `Ctrl+C` in the respective terminal windows

---

## 🌐 Available API Endpoints

### Authentication
- `POST /api/auth/signup` - Register new user
- `POST /api/auth/login` - User login
- `GET /api/auth/users` - Get all users (admin)

### Animals
- `GET /api/animals` - Get all animals
- `POST /api/animals` - Create animal
- `PUT /api/animals/{id}` - Update animal
- `DELETE /api/animals/{id}` - Delete animal

### Trees
- `GET /api/trees` - Get all trees
- `POST /api/trees` - Create tree
- `PUT /api/trees/{id}` - Update tree
- `DELETE /api/trees/{id}` - Delete tree

### Plants
- `GET /api/plants` - Get all plants
- `POST /api/plants` - Create plant
- `PUT /api/plants/{id}` - Update plant
- `DELETE /api/plants/{id}` - Delete plant

### Officers
- `GET /api/officers` - Get all officers
- `POST /api/officers` - Create officer
- `PUT /api/officers/{id}` - Update officer
- `DELETE /api/officers/{id}` - Delete officer

### Visitors
- `GET /api/visitors` - Get all visitors
- `POST /api/visitors` - Create visitor
- `PUT /api/visitors/{id}` - Update visitor
- `DELETE /api/visitors/{id}` - Delete visitor

### Resources
- `GET /api/resources` - Get all resources
- `POST /api/resources` - Create resource
- `PUT /api/resources/{id}` - Update resource
- `DELETE /api/resources/{id}` - Delete resource

---

## 📚 Next Steps

1. **Create Your First User:** Sign up at http://localhost:3000
2. **Explore the Dashboard:** See all available modules
3. **Add Data:** Start adding animals, trees, plants, etc.
4. **Manage Staff:** Add forest officers and their assignments
5. **Track Visitors:** Record visitor entries and permits
6. **Monitor Resources:** Keep track of equipment and vehicles

---

## ⚠️ Troubleshooting

### "Connection error" on login
- Make sure backend is running on port 8080
- Check backend terminal for errors

### "API Error: 500"
- Check MySQL is running
- Verify database exists: `forest_management_system`
- Check backend logs for detailed error

### Page won't load
- Make sure frontend is running on port 3000
- Clear browser cache and refresh

---

**System is ready to use! Open http://localhost:3000 to get started! 🎉**
