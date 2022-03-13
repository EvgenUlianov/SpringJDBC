package evgenulianov.springjdbc.repository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Repository
public class MyRepository {


    private final JdbcTemplate jdbcTemplate;
   // private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//    private final String url;
//    private final String username;
//    private final String password;
    private String querry;

    public MyRepository(//@Value("${spring.datasource.url}") String url,
//                        @Value("${spring.datasource.username}") String username,
//                        @Value("${spring.datasource.password}") String password,
                        JdbcTemplate jdbcTemplate) {///,
                       // NamedParameterJdbcTemplate namedParameterJdbcTemplate
//        this.url = url;
//        this.username = username;
//        this.password = password;
        this.jdbcTemplate = jdbcTemplate;
        this.querry = read();
    }

    private String read() {
        try (InputStream is = this.getClass().getResourceAsStream("/templates/select.sql");
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<String> getProducts(String name) {
        List<String> result = new ArrayList<>();
        SqlRowSet resultSet = jdbcTemplate.queryForRowSet(querry, name);
        while (resultSet.next())
            result.add(resultSet.getString("product_name"));
//        try (Connection connection = DriverManager.getConnection(url, username, password);){
//
//        } catch (SQLException e){
//            System.out.println(e.getMessage());
//        }

        return result;
    }

}