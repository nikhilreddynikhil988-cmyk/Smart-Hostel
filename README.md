# Smart Hostel Management System

A full-stack application for managing hostel complaints and administration.

## Project Structure

- `smart-hostel-frontend/`: React frontend application
- `SmartHostel/`: Spring Boot backend API

## Prerequisites

- Node.js (for frontend)
- Java 17 (for backend)
- Maven (for backend)
- Docker (for containerization)
- Git

## Building the Application

### Frontend

```bash
cd smart-hostel-frontend
npm install
npm run build
```

### Backend

```bash
cd SmartHostel
mvn clean package
```

## Running Locally

### Frontend

```bash
cd smart-hostel-frontend
npm run dev
```

### Backend

```bash
cd SmartHostel
mvn spring-boot:run
```

## Containerization

Dockerfiles are provided for both services. To build images:

```bash
# Frontend
docker build -t smart-hostel-frontend ./smart-hostel-frontend

# Backend
docker build -t smart-hostel ./SmartHostel
```

## Deployment

This project is prepared for deployment to Azure using AZD. See `.azure/plan.copilotmd` for the deployment plan.

## Git Setup

To push to Git:

1. Initialize repository:
   ```bash
   git init
   ```

2. Add files:
   ```bash
   git add .
   ```

3. Commit:
   ```bash
   git commit -m "Initial commit"
   ```

4. Create a repository on GitHub and add remote:
   ```bash
   git remote add origin <your-repo-url>
   git push -u origin main
   ```