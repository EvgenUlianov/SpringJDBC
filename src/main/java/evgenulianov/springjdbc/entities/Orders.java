package evgenulianov.springjdbc.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customers customer;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(nullable = false)
    private int amount;

    public Orders(){
        amount = 1;
    }
}
