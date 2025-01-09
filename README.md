# Game-Library-Management-System
_Game Library Management System_ is an Object Oriented Programming (OOP) project developed in Java, designed to provide the management of digital game library through a user-friendly command line interface. This system allows users to effectively manage their game collections. The user can play games and keep track of their play time and achievements or can wish-list games available in the library.
The whole system is built using eight classes: Main, Game, Library, User, Review, Achievement, Vault and AdminUser. With each providing different functionality and is interconnected with each other via composition.
# Structuring

The files used in the project are divided into two packages: User and Game. The User package contains User, AdminUser and Vault while the Game package contains Game, Library, Achievement and Review. The following shows a textual representation of a tree map for this project.

Tree Map of Project Structure

```
Game Library Management System
│
├── Main
│
├── User
│   ├── User
│   ├── AdminUser
│   └── Vault
│
└── Game
    ├── Game
    ├── Library
    ├── Achievement
    └── Review
```
