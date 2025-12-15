# 🌟 Enterprise Inventory Manager 🌟

## 📝 Description
Enterprise Inventory Manager is a full-stack application designed for efficient enterprise inventory management. This project combines a client developed in Angular and a backend server built with Spring Boot, providing a robust and scalable solution for inventory handling.

## ✨ Features
- 🔒 **User Management:** Secure login and authentication.
- 📦 **Inventory Management:** View, create, edit, and delete products.
- 🎨 **Modern Interface:** Responsive and user-friendly design.
- 🌐 **REST API:** Backend with well-defined endpoints for client interaction.
- 🔄 **CORS Configuration:** Support for cross-domain requests.

## 🛠️ Technologies Used
### 🌟 Frontend
- ⚡ Angular (v21.0.0)
- 🟦 TypeScript
- 🎨 SCSS

### 🌟 Backend
- ☕ Spring Boot (v3.5.8)
- 🖥️ Java
- 🛠️ Maven

### 🌟 Database
- 🗄️ (Specify the database used, e.g., MySQL, PostgreSQL, etc.)

## 🗂️ Project Structure
### 📂 Backend: `inventory-manager-api`
- **`src/main/java`**: Contains the backend source code.
  - **`config`**: CORS and other configurations.
  - **`InventoryManagerApiApplication.java`**: Main class to start the Spring Boot application.
- **`src/main/resources`**: Configuration files and static resources.
  - **`application.properties`**: Application configuration.

### 📂 Frontend: `inventory-manager-client`
- **`src/app`**: Contains the main Angular components.
  - **`auth/login`**: Authentication module.
  - **`inventory/inventory-list`**: Inventory management module.
  - **`components/navbar`**: Navigation bar.
- **`angular.json`**: Angular project configuration.

## 🚀 Installation and Setup
### ✅ Prerequisites
- 📦 Node.js and npm
- ☕ Java 17 or higher
- 🛠️ Maven
- 🗄️ (Specify the database and necessary tools)

### 🛠️ Steps to Run the Project
#### 🔙 Backend
1. Navigate to the `inventory-manager-api` directory.
2. Run the following command to compile and start the server:
   ```bash
   ./mvnw spring-boot:run
   ```
3. The server will be available at `http://localhost:8080`.

#### 🔝 Frontend
1. Navigate to the `inventory-manager-client` directory.
2. Install the dependencies by running:
   ```bash
   npm install
   ```
3. Start the development server:
   ```bash
   npm start
   ```
4. The application will be available at `http://localhost:4200`.

## 🤝 Contributions
Contributions are welcome! If you want to contribute, please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Make your changes and ensure the code is well-documented.
4. Submit a pull request.

## 📜 License
This project is licensed under the [MIT License](LICENSE).

## 📧 Contact
For questions or support, please contact:
- **👨‍💻 Developer**: Jose Antonio Moreno Marin
- **📩 Email**: jmormar00@gmail.com
- **LinkedIn**: www.linkedin.com/in/joseantonio-morenomarin 

---
Thank you for using Enterprise Inventory Manager! 🎉