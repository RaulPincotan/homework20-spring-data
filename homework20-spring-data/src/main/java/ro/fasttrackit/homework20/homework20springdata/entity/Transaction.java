package ro.fasttrackit.homework20.homework20springdata.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private String product;
    @Enumerated(EnumType.ORDINAL)
    private Type type;
    private double amount;

    public Transaction() {
    }

    public Transaction(String product, Type type, double amount) {
        this.product = product;
        this.type = type;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return id == that.id &&
                Double.compare(that.amount, amount) == 0 &&
                Objects.equals(product, that.product) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, type, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", type=" + type +
                ", amount=" + amount +
                '}';
    }
}
