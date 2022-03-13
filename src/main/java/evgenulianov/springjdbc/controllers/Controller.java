package evgenulianov.springjdbc.controllers;

import evgenulianov.springjdbc.repository.MyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RequiredArgsConstructor
@RestController
@RequestMapping("products")
public class Controller {

    private final MyRepository repository;

    @GetMapping("/fetch-product")
    public Iterable<String> getProducts(@RequestParam(value = "name", required = true) String name) throws SQLException {
        return repository.getProducts(name);
    }

}
