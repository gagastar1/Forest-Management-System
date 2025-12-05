# Railway Database Connection Setup

## Your Railway MySQL Database Details

**Connection URL:**
```
mysql://root:hFLmjcGhRpKrElXiwBNAJLINcSfrfzqu@caboose.proxy.rlwy.net:36723/railway
```

## Railway Environment Variables (Auto-Set)

Railway automatically sets these variables when you add MySQL:

- `MYSQL_URL` = `jdbc:mysql://caboose.proxy.rlwy.net:36723/railway`
- `MYSQLUSER` = `root`
- `MYSQLPASSWORD` = `hFLmjcGhRpKrElXiwBNAJLINcSfrfzqu`
- `MYSQLHOST` = `caboose.proxy.rlwy.net`
- `MYSQLPORT` = `36723`
- `MYSQLDATABASE` = `railway`

## What I've Updated

✅ Updated `application.properties` to use Railway's environment variable names:
- `MYSQL_URL` instead of `DATABASE_URL`
- `MYSQLUSER` instead of `DATABASE_USERNAME`
- `MYSQLPASSWORD` instead of `DATABASE_PASSWORD`

## Railway Will Now Use These Settings

When deployed on Railway:
- Spring Boot reads `MYSQL_URL`, `MYSQLUSER`, `MYSQLPASSWORD` from Railway environment
- Tables will be auto-created in Railway's MySQL database

When running locally:
- Falls back to `localhost:3306/forest_management_system`
- Uses your local credentials (root/Giri@#2004)

## Verify Settings in Railway Dashboard

1. Go to your Railway project
2. Click on your Spring Boot service
3. Go to **"Variables"** tab
4. You should see these automatically set by Railway:
   ```
   MYSQL_URL
   MYSQLUSER
   MYSQLPASSWORD
   MYSQLHOST
   MYSQLPORT
   MYSQLDATABASE
   ```

## Next Steps

### 1. Commit and Push Changes
```bash
cd "C:\Users\girio\Desktop\projects\Forest Management System"
git add .
git commit -m "Configure Railway MySQL connection"
git push origin master
```

### 2. Railway Will Auto-Deploy
- Railway detects the push
- Rebuilds your app
- Connects to MySQL automatically
- Creates all tables on first run

### 3. Test Your Deployed API
Once deployed, test it:
```bash
# Replace with your actual Railway app URL
curl https://your-app.up.railway.app/api/animals
```

## Database Schema Migration

Your tables will be created automatically because of:
```properties
spring.jpa.hibernate.ddl-auto=update
```

This means:
- First deployment: Creates all tables (Animals, Trees, Plants, etc.)
- Subsequent deployments: Only updates schema if entities change
- Data is preserved between deployments

## Connect to Railway MySQL (Optional)

If you want to check the database directly:

### Using MySQL CLI:
```bash
mysql -h caboose.proxy.rlwy.net -u root -phFLmjcGhRpKrElXiwBNAJLINcSfrfzqu --port 36723 --protocol=TCP railway
```

### Using Railway CLI:
```bash
railway connect MySQL
```

### Using MySQL Workbench / DBeaver:
- Host: `caboose.proxy.rlwy.net`
- Port: `36723`
- Username: `root`
- Password: `hFLmjcGhRpKrElXiwBNAJLINcSfrfzqu`
- Database: `railway`

## Your Final Deployment Checklist

- [x] MySQL database created on Railway
- [x] Environment variables configured (auto by Railway)
- [x] application.properties updated to use Railway env vars
- [ ] Commit changes to GitHub
- [ ] Push to trigger Railway deployment
- [ ] Verify API is accessible
- [ ] Update frontend with production API URL

## Production API URL

After Railway deploys, you'll get a URL like:
```
https://forest-management-production-XXXX.up.railway.app
```

Update your frontend:
```typescript
// frontend/lib/api.ts
const API_BASE_URL = 'https://forest-management-production-XXXX.up.railway.app/api';
```

Or create `frontend/.env.local`:
```env
NEXT_PUBLIC_API_URL=https://forest-management-production-XXXX.up.railway.app/api
```

---

🎉 Your backend is ready to deploy with Railway MySQL!
