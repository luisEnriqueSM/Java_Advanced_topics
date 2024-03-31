package org.training.collections;

import java.util.Objects;

public class Product implements Comparable<Product>{

    private Integer id;

    public Product(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Product product) { // specifies "natural ordering" for product
        // delegate to Integer which implements Comparable<Integer>
        return id.compareTo(product.id);
        // return Integer.compare(id, product.id); // another option
        // return id-product.id // sorts ascending by id
    }
}
