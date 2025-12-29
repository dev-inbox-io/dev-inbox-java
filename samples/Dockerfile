# Multi-stage build for DevInbox Java Sample
# Build context should be the 'java' directory (parent of samples)
FROM maven:3.9-eclipse-temurin-11 AS builder

# Set working directory
WORKDIR /app

# Copy parent project files (context is 'java' directory)
COPY pom.xml pom.xml
COPY src src

# Build and install the parent client library to local Maven repo
RUN mvn clean install -DskipTests

# Copy sample project files
COPY samples/pom.xml samples/pom.xml
COPY samples/src samples/src

# Build the sample project and copy dependencies
WORKDIR /app/samples
RUN mvn clean package dependency:copy-dependencies -DskipTests

# Runtime stage
FROM eclipse-temurin:11-jre

WORKDIR /app

# Copy dependencies from builder
COPY --from=builder /app/samples/target/dependency/*.jar /app/lib/

# Copy compiled classes
COPY --from=builder /app/samples/target/classes /app/classes

# Run the sample with proper classpath
ENTRYPOINT ["java", "-cp", "/app/classes:/app/lib/*", "io.devinbox.sample.ExampleUsage"]

