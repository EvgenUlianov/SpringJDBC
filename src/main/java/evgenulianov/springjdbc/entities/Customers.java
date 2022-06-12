package evgenulianov.springjdbc.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "customers")
public class Customers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private int age;

    @Column(nullable = true, name = "phone_number")
    private String phoneNumber;

    public Customers(){
        age = 0;
    }

}
