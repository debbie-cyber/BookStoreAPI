Bookstore API
Welcome to the Bookstore API! This API allows you to perform CRUD operations for genres, authors, and books in a bookstore. It is built using Spring Boot and provides endpoints to create, read, update, and delete data.

Table of Contents
Requirements
Installation
Running the Application
API Endpoints
Create Operations
Read Operations
Update Operations
Delete Operations
Request and Response Formats
Error Handling
License
Requirements
Java 8 or higher
Maven
MySQL database
Installation
Clone the repository:
git clone https://github.com/yourusername/bookstore-api.git
Navigate to the project directory:
cd bookstore-api
Configure the MySQL database:
Create a database named bookstoredb and update the application.properties file with your database credentials.
spring.datasource.url=jdbc:mysql://localhost:3306/bookstoredb
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
Build the project:
mvn clean install
Running the Application
Run the Spring Boot application:
mvn spring-boot
Access the API:
The API will be available at http://localhost:8080/book-store/api.

API Endpoints
Create Operations
Create Genre
Endpoint: POST /book-store/api/genre/create
Request JSON:
{
"genreTitle": "Science Fiction"
}
Create Author
Endpoint: POST /book-store/api/author/create
Request JSON:
{
"firstName": "John",
"lastName": "Doe",
"email": "john.doe@example.com"
}
Create Book
Endpoint: POST /book-store/api/book/create
Request JSON:
{
"title": "The Great Adventure",
"genre": "Science Fiction",
"authorsEmail": ["john.doe@example.com"]
}
Read Operations
Get All Genres
Endpoint: GET /book-store/api/genre/all
Get All Authors
Endpoint: GET /book-store/api/author/all
Get All Books
Endpoint: GET /book-store/api/book/all
Get Genre by ID
Endpoint: GET /book-store/api/genre/{id}
Example Path: GET /book-store/api/genre/1
Get Author by ID
Endpoint: GET /book-store/api/author/{id}
Example Path: GET /book-store/api/author/1
Get Book by ID
Endpoint: GET /book-store/api/book/{id}
Example Path: GET /book-store/api/book/1
Update Operations
Update Genre
Endpoint: PUT /book-store/api/genre/update
Request JSON:
{
"id": 1,
"genreTitle": "Updated Science Fiction"
}
Update Author
Endpoint: PUT /book-store/api/author/update
Request JSON:
{
"id": 1,
"firstName": "John",
"lastName": "Doe",
"email": "updated.john.doe@example.com"
}
Update Book
Endpoint: PUT /book-store/api/book/update
Request JSON:
{
"id": 1,
"title": "Updated The Great Adventure",
"genre": "Updated Science Fiction",
"authorsEmail": ["updated.john.doe@example.com"]
}
Delete Operations
Delete Genre
Endpoint: DELETE /book-store/api/genre/delete/{id}
Example Path: DELETE /book-store/api/genre/delete/1
Delete Author
Endpoint: DELETE /book-store/api/author/delete/{id}
Example Path: DELETE /book-store/api/author/delete/1
Delete Book
Endpoint: DELETE /book-store/api/book/delete/{id}
Example Path: DELETE /book-store/api/book/delete/1
Request and Response Formats
GenreCreationRequest
{
"genreTitle": "Science Fiction"
}
AuthorCreationRequest
{
"firstName": "John",
"lastName": "Doe",
"email": "john.doe@example.com"
}
BookCreationRequest
{
"title": "The Great Adventure",
"genre": "Science Fiction",
"authorsEmail": ["john.doe@example.com"]
}
GenreResponse
{
"id": 1,
"genreTitle": "Science Fiction"
}
AuthorResponse
{
"id": 1,
"firstName": "John",
"lastName": "Doe",
"email": "john.doe@example.com"
}
BookResponse
{
"id": 1,
"title": "The Great Adventure",
"genre": {
"id": 1,
"genreTitle": "Science Fiction"
},
"authors": [
{
"id": 1,
"firstName": "John",
"lastName": "Doe",
"email": "john.doe@example.com"
}
]
}
Error Handling
The API uses custom exceptions to handle errors. The BookStoreException is thrown when there are issues with creating, updating, or deleting entities. The exception message will be returned as the response body with a 400 Bad Request status code.
Example Error Response
Status: 400 Bad Request
Response Body:
{
"message": "Genre Title is empty"
}
