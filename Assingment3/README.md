# Game Club Console System (Project Iteration 2)

## Tech stack
- Java 17
- PostgreSQL
- JDBC

## Implemented requirements
- JOIN query: full gaming session description from `gaming_sessions`, `customers`, `stations`
- Design Pattern: Singleton (`ConnectionFactory`)
- Lambda expressions: Stream API usage in AnalyticsService
- SOLID: Repository layer for DB access, Service layer for business logic
- Role management: Role enum + access check (Security.require)
- Data validation: enums parsing and validation utilities
- Categories: MembershipType, StationStatus, SessionStatus

## How to run
1. Create PostgreSQL database and run SQL scripts from `Query.sql`
2. Update DB credentials in `DbConfig`
3. Run `Main`
