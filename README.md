# 🏥 MediCore – Healthcare Management System

**MediCore** is a backend healthcare management system built using **Spring Boot**, **Spring Data JPA**, **MySQL**, and **RESTful APIs**.  
It automates essential hospital workflows such as doctor management, patient records, appointments, prescriptions, and payments, while following a clean and scalable layered architecture.

---

## 🛠 Tech Stack

- **Language:** Java 21  
- **Framework:** Spring Boot 3  
- **ORM:** Spring Data JPA (Hibernate)  
- **Database:** MySQL  
- **Build Tool:** Maven  
- **API Style:** RESTful APIs  
- **Testing Tools:** Postman, cURL  
- **IDE:** Eclipse

---

## 🚀 Features

### 👨‍⚕️ Doctor Management
- Add, edit, delete, and view doctor profiles.  
- Store specialization, phone, and email.  
- Ensures structured and validated data.

### 👤 Patient Management
- Register new patients.
- Update age, gender, and contact details.
- Maintain long-term patient records.

### 📅 Appointment Management
- Schedule appointments between doctor and patient.
- Prevent double-booking using business logic and constraints.
- Fetch appointments by doctor or by patient.  
- Update appointment status.

### 💊 Prescription Management
- Create prescriptions linked to specific appointments.  
- Store medicines, dosage, and clinical notes.  
- One-to-one mapping ensures accurate medical documentation.

### 💳 Payment Management
- Record payments for completed appointments.  
- Track amount, method, and payment status.  
- Ensures exactly one payment per appointment.

---

# 🏗️ System Architecture

MediCore follows the **Spring Boot Layered MVC Architecture**, also known as the **N-Tier Architecture**.  
This ensures clear separation of concerns, scalability, and easier maintenance.

### 🔄 High-Level Flow

```plaintext
Client (Postman / Frontend)
            |
            v
  Controller Layer
      (Handles HTTP requests)
            |
            v
     Service Layer
 (Business logic & validation)
            |
            v
   Repository Layer
   (JPA database access)
            |
            v
     MySQL Database
     (Persistent storage)
```

---

## 🧱 Architecture Layers

### 1. Controller Layer (Presentation Layer)
- Handles incoming HTTP requests and outgoing responses.  
- Exposes RESTful API endpoints.  
- Uses annotations such as `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`, `@PutMapping`.

### 2. Service Layer (Business Logic Layer)
- Contains core business rules and validation logic.  
- Coordinates workflows like appointment booking and linking prescriptions/payments.  
- Annotated with `@Service`.

### 3. Repository Layer (Data Access Layer)
- Interacts with MySQL using Spring Data JPA.  
- Provides CRUD operations without manual SQL.  
- Annotated with `@Repository`.

### 4. Entity Layer (Persistence Layer)
- Defines JPA entities mapped to database tables.  
- Manages relationships such as:
  - `@OneToMany` (Doctor → Appointments)  
  - `@ManyToOne` (Appointment → Doctor/Patient)  
  - `@OneToOne` (Appointment → Prescription/Payment)

---

## 🚀 Future Enhancements

- **Frontend Integration** using React or Angular for a complete user interface.  
- **Deployment** using Docker / AWS / Render for backend hosting.  
- **JWT Authentication** for secure, role-based access (Admin, Doctor, Patient).

---

## ⭐ Contributing

Contributions are welcome! If you have suggestions or improvements, feel free to create a pull request.

