package entity;

import jakarta.persistence.*;

@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "proName")
    private String proName;
    @Column(name = "proDesc")
    private String proDesc;
    @Column(name = "Price")
    private Double Price;

    public Product(String proName, String proDesc, Double price) {
        this.proName = proName;
        this.proDesc = proDesc;
        this.Price = price;
    }



    public Product(String proName) {
        this.proName = proName;
    }
    public Product(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDesc() {
        return proDesc;
    }

    public void setProDesc(String proDesc) {
        this.proDesc = proDesc;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    @Override
    public String toString() {
        return "{" +
                "\"id\":" + id +
                ", \"proName\":\"" + proName + '\"' +
                ", \"proDesc\":\"" + proDesc + '\"' +
                ", \"Price\":" + Price +
                "}";
    }
}
