# Library Management System

Concepts and Principles
Object-Oriented Programming (OOP)

OOP is a programming paradigm based on the concept of "objects" which can contain data and methods. The four main principles of OOP are:

    Encapsulation: Bundling the data (attributes) and methods (functions) that operate on the data into a single unit or class. It restricts direct access to some of the object's components.
    Inheritance: Mechanism where a new class is derived from an existing class. The new class (subclass) inherits attributes and methods from the existing class (superclass).
    Polymorphism: Ability of different classes to be treated as instances of the same class through a common interface. It allows methods to do different things based on the object it is acting upon.
    Abstraction: Process of hiding the complex implementation details and showing only the necessary features of the object.

**Data Structures**

    Lists: Used to store collections of books, members, and transactions. Java's ArrayList is used for dynamic arrays that can grow as needed.
    Maps: Can be used for fast lookups of books and members by their IDs.

**Exception Handling**

Proper error handling is crucial for building robust applications. This project demonstrates:

    Try-catch blocks: To handle potential runtime errors gracefully without crashing the program.
    Custom exceptions: To provide more meaningful error messages and handle specific error scenarios.

**File Handling**

To persist data between program runs, file handling mechanisms can be added. This project can be extended to:

    Read from files: Load initial data for books, members, and transactions.
    Write to files: Save current state when the application exits.

**Class Structure**

The project consists of the following main classes:

    Book: Represents a book in the library.
    Member: Represents a member of the library.
    Transaction: Represents a transaction (issue or return) involving a book and a member.
    Library: Manages the collection of books, members, and transactions.

**Class Diagram**

Library
  - List<Book> books
  - List<Member> members
  - List<Transaction> transactions
  + addBook(Book book)
  + removeBook(String bookId)
  + searchBook(String title)
  + registerMember(Member member)
  + issueBook(String bookId, String memberId)
  + returnBook(String bookId, String memberId)

Book
  - String id
  - String title
  - String author
  - boolean isIssued
  + getters and setters

Member
  - String id
  - String name
  - List<Book> borrowedBooks
  + getters and setters

Transaction
  - String transactionId
  - Book book
  - Member member
  - Date issueDate
  - Date returnDate
  + getters and setters

