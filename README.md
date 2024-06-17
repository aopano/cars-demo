# Building and Running Local Machine

1. Install JDK 22 on the local machine if not yet installed
2. Install PostgreSQL on the local machine if not yet installed
3. Refer to "application.properties" for the DB Configuration
4. On the project directory run ``mvnw spring-boot:run``

# Building and Running Docker

1. Install JDK 22 on the local machine if not yet installed
2. Install Docker on the local machine if not yet installed
3. On the project directory run ``mvnw clean package`` then run ``docker-compose up``

# Testing the APIs Maven

1. On the project directory run ``mvnw test``

# Testing the APIs PostMan

1. Load the included ``Cars Demo.postman_collection.json`` in PostMan for sample tests
