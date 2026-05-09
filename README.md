# SwiftShip - Courier Management System (Java OOP Project)

## 📌 Overview
SwiftShip is a Java-based Courier Management System developed using Object-Oriented Programming principles. It simulates a real-world delivery workflow where customers can request parcels, admins approve and assign delivery agents, and agents update delivery status in real time.

The system includes a Java Swing GUI and file handling for persistent data storage.

---

## 🚀 Features

### 👤 User Roles
- Customer
- Admin
- Delivery Agent

### 📦 Parcel Workflow
- Customer requests a parcel
- Admin approves parcel requests
- System generates tracking ID
- Admin assigns delivery agent
- Delivery agent updates parcel status
- Customer tracks parcel using tracking ID

---

## 🛠️ System Features
- Role-based access control
- Parcel cost calculation based on weight
- Tracking history updates
- File-based data persistence
- Java Swing GUI for interaction
- Service-layer architecture

---

## 🧠 OOP Concepts Used
- Encapsulation
- Inheritance
- Polymorphism
- Abstraction
- Interfaces (basic usage)

---

## 📁 Project Structure
├── models/
│ ├── User.java
│ ├── Customer.java
│ ├── Admin.java
│ ├── DeliveryAgent.java
│ ├── Parcel.java
│ ├── Address.java
│ ├── ParcelStatus.java
│ ├── Role.java
│
├── services/
│ ├── UserService.java
│ ├── ParcelService.java
│ ├── FileService.java
│ ├── AppContext.java
│
├── gui/
│ ├── LoginFrame.java
│ ├── AdminPanel.java
│ ├── CustomerPanel.java
│ ├── AgentPanel.java
│ ├── MainDashboard.java
│
├── main/
│ ├── Main.java
│
└── Parcels.txt (generated file for storage)

---

## ⚙️ How to Run
1. Open project in NetBeans / IntelliJ IDEA / Eclipse  
2. Ensure JDK 8 or higher is installed  
3. Run `Main.java`  
4. Login as:
   - Customer
   - Admin
   - Delivery Agent  

---

## 📂 Important Note (File Path)
This project uses file handling for storing parcel data.