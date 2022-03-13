package evgenulianov.springjdbc;

import evgenulianov.springjdbc.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class SpringJdbcApplication { //implements CommandLineRunner

//    final private MyRepository repository;
//
//    public SpringJdbcApplication(MyRepository repository) {
//        this.repository = repository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringJdbcApplication.class, args);



    }

//    @Override
//    public void run(String... args) throws Exception {
//
////        System.out.println(repository.getQuerry());
////        repository.executeQuery();
//
////        String url = A
////
////        Connection connection = DriverManager.getConnection();
//
//    }
}
