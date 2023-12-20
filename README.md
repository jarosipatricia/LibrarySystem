## Intro
Please note that this doc is only used to provide general guide to the project, the comments in the code than can help to understand how the actual program works.
This project contains 3 subprojects each representing a different subtaskt of an assignment:
- Using singleton - represents a project where BookLibrary is created with singletion design pattern
- Using builder - represents a project where builder pattern is used for creating book instances
- Using abstract classes and interfaces - represents a project where an interface and an abstract class is used when working with books


## Book
Class for book that holds information about the book ( for example name, value, author, yearPublished,..). These information are having read-only access, plus they can't be modified, once instance is created.
Use of inheritance on the book class can be seen on the 2 subclasses - AudioBook (book with 2 more properties - duration and reader) and SignedBook (book signed by author that has double value).

## BookLibrary

This class serves as a library for storing collection books. It supports the following functionality:
- contains a collection of books and their quantity (the same book can be registered multiple times)
- registering a new book
- retrieving a book from library
- returning a book to library
As there is only one library, Singletion design pattern is used for implementation.

## Librarian

Represents a virtual assistant for working with the library. It supports communication with the user through the
console, more specifically the user can ask it to:
- list the books present in the library (and their quantities)
- get a specific book from the library user want to borrow
- put a book that the user returning back to the library

## Main
This class includes the main method that contains the main code of the program. Here we create Book instances, then fill the library with them.
