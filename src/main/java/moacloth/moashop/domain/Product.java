package moacloth.moashop.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.sql.Blob;

// n:1 (다대일에서 이놈이 다 n이다.)
@Entity
@Getter
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int num;

    @ManyToOne
    @JoinColumn(name="admin_id", columnDefinition = "VARCHAR(500)", nullable = false)
    private Admin admin_id;

    @Column(name="product_img", length=500, nullable = false)
    private Blob product_img;

    @Column(name="product_name", length=500, nullable = false)
    private String product_name;

    @Column(name="product_price", length=500, nullable = false)
    private int product_price;

    @Column(name="product_ex", length=500, nullable = false)
    private String product_ex;
}
