package sample.web.ui.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Observable;
import java.util.Observer;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends Observable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private int price;

    private BigDecimal bidAmount;

    private Observer observer;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Product(Product p) {
        this.name = p.name;
        this.price = p.price;
    }

    public Product(String productName, BigDecimal bidAmount) {
        this.name = productName;
        this.bidAmount = bidAmount;
    }

    public void setBidAmount(Observer observer, BigDecimal newBidAmount) {
        System.out.println("-----------------New bid placed----------------");
        int res = bidAmount.compareTo(newBidAmount);
        if (res < 0) {
            this.observer = observer;
            this.bidAmount = newBidAmount;
            setChanged();
            notifyObservers();
        } else {
            System.out.println("New bid amount cannot be less or equal to current bid amount: " + this.bidAmount);
        }
    }

    public Observer getObserver() {
        return observer;
    }

    public BigDecimal getBidAmount() {
        return bidAmount;
    }

    public String getProductName() {
        return name;
    }
}