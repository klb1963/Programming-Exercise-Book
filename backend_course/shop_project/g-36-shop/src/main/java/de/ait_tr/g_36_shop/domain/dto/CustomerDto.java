package de.ait_tr.g_36_shop.domain.dto;

import de.ait_tr.g_36_shop.domain.entity.Cart;
import jakarta.persistence.*;

import java.util.Objects;

public class CustomerDto {

    private Long id;

    private String name;

    private CartDto cart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CartDto getCart() {
        return cart;
    }

    public void setCart(CartDto cart) {
        this.cart = cart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerDto that)) return false;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cart);
    }

    @Override
    public String toString() {
        return String.format("Customer: id - %d, name - %s, active - %s, cart - %s",
                id, name, cart == null ? "null" : cart);
    }
}