cd eureka/
mvn clean package
java -jar target/eureka-0.0.1-SNAPSHOT.jar &
cd ../auth/
mvn clean package
java -jar target/auth-0.0.1-SNAPSHOT.jar &
cd ..