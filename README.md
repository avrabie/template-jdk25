# Spring Boot Reactive Template with OAuth2
# Demo25 Application

## Setup

### Configuration

This project uses external configuration for sensitive values like OAuth secrets and database credentials.

1. Copy `gradle.properties.template` to `gradle.properties`:
   ```bash
   cp gradle.properties.template gradle.properties
   ```
and make the necessary changes, based on your subscriptions/credentials. (google client id and secret)

2. Edit `gradle.properties` and fill in your actual values:
   - `GOOGLE_CLIENT_ID`: Your Google OAuth client ID
   - `GOOGLE_CLIENT_SECRET`: Your Google OAuth client secret
   - `DB_USERNAME`: Database username
   - `DB_PASSWORD`: Database password

**Note:** The `gradle.properties` file is gitignored and will not be committed to the repository.

### Running the Application

The application will automatically pick up the properties from `gradle.properties` as environment variables.
A modern Spring Boot template project demonstrating reactive programming with R2DBC, database migrations with Liquibase, and OAuth2 authentication with Google.

## 🚀 Technology Stack

- **Java 25** - Latest Java SDK
- **Spring Boot** - Application framework
- **Spring WebFlux** - Reactive web framework
- **Spring Security OAuth2 Client** - OAuth2 authentication
- **R2DBC** - Reactive database connectivity
- **PostgreSQL** - Database
- **Liquibase** - Database migration management
- **Lombok** - Boilerplate code reduction
- **Gradle** - Build automation tool

## ✨ Features

- ⚡ **Fully Reactive** - Non-blocking, event-driven architecture using Spring WebFlux
- 🔐 **OAuth2 Authentication** - Integrated Google OAuth2 login
- 🗄️ **R2DBC PostgreSQL** - Reactive database access with PostgreSQL
- 📝 **Liquibase Migrations** - Version-controlled database schema management
- 🏗️ **Clean Architecture** - Well-structured, maintainable codebase
- 🔧 **Ready to Use** - Pre-configured template for quick project startup

## 📋 Prerequisites

- Java 25 or higher
- PostgreSQL database (or docker)
- Google OAuth2 credentials (Client ID and Secret)
- Gradle 9.x or higher

## 🛠️ Setup Instructions

```bash
./gradlew clean build
./gradlew bootRun`
