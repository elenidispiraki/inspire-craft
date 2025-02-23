# inspire-craft - Build & Deploy Guide

## Description
InspireCraft is a full-stack web application that allows creators to showcase their DIY products while visitors can add them to their favorites.

---

## Technologies Used
- **Backend:** Java Spring Boot (RESTful API)
- **Frontend:** Angular 18
- **Database:** MySQL
- **Authentication:** JWT
- **Dependency Management:** Gradle

### Prerequisites

- Java 17+ (για το Spring Boot)
- MySQL
- Node.js (για το Angular)
- Gradle

### Backend Build and Deploy

1. Clone repository:

    ```bash
     git clone https://github.com/username/InspireCraftApp.git
     cd InspireCraftApp

2. Set up the MySQL database with the appropriate configuration (e.g., create the database and users).

3. Build the backend:
    ```bash
    ./gradlew build

4. Run the Spring Boot application:
   ```bash
   ./gradlew bootRun
The backend will be available at http://localhost:8080.


### Frontend Build and Deploy

1. Navigate to the frontend folder:
    ```bash
    cd frontend

2. Install the Angular dependencies:
     ```bash
     npm install

3. Build the Angular frontend:
    ```bash
    ng build --prod

4. Run the Angular application:
    ```bash
    ng serve
The frontend will be available at http://localhost:4200.


Deployment
To deploy the application to a production environment, follow these steps:
1. Set up the production environment (e.g., create databases and configure servers).
   Use tools like Docker or a cloud service (e.g., AWS, Heroku) for deployment.


License
This project is licensed under the MIT License.
  ```pgsql
This README provides instructions on how to build and deploy the application both locally and in a production environment, with the appropriate technologies and steps for your project.