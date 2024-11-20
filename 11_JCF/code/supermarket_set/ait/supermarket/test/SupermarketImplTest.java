package supermarket_set.ait.supermarket.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import supermarket_set.ait.supermarket.dao.Supermarket;
import supermarket_set.ait.supermarket.dao.SupermarketImpl;
import supermarket_set.ait.supermarket.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SupermarketImplTest {

    Supermarket supermarket;
    LocalDate now = LocalDate.now();

    Product[] products;

    @BeforeEach
    void setUp() {

        supermarket = new SupermarketImpl();
        products = new Product[5];
        products[0] = new Product(111111, "White Bread", "Bread", "Kolosok", 6.5, now.plusDays(5));
        products[1] = new Product(222222, "ChokoMilk", "Dairy", "MilkLand", 13, now.minusDays(3));
        products[2] = new Product(333333, "Cheese Gauda", "Dairy", "Farmer", 22.5, now.plusDays(50));
        products[3] = new Product(444444, "Cheese Chedder", "Dairy", "MilkLand", 30, now.plusDays(85));
        products[4] = new Product(555555, "Sweet Buns", "Bread", "Kolosok", 18.3, now.minusDays(25));

        for (Product p : products) {
            supermarket.addProduct(p);
        }
    }

    @Test
    void addProduct() {
        assertFalse(supermarket.addProduct(null));
        assertFalse(supermarket.addProduct(products[3]));
        Product product1 = new Product(666666, "Sweet Buns", "Bread", "Kolosok", 18.3, now.minusDays(25));
        assertTrue(supermarket.addProduct(product1));
        assertEquals(6, supermarket.skuQuantity());
        Product product2 = new Product(666666, "Sweet Buns", "Bread", "Kolosok", 18.3, now.minusDays(25));
        assertFalse(supermarket.addProduct(product2)); // с одинаковым баркодом
        Product product3 = new Product(777777, "Sweet Buns", "Bread", "Kolosok", 18.3, now.minusDays(25));
        assertTrue(supermarket.addProduct(product3));
    }

    @Test
    void removeProduct() {
        assertEquals(products[1], supermarket.removeProduct(222222));
        assertEquals(4, supermarket.skuQuantity());
        assertNull(supermarket.removeProduct(222222)); // дважды не можем удалить
        // assertNull(myMarket.removeProduct(222222));
    }

    @Test
    void findByBarCode() {
        assertEquals(products[1], supermarket.findByBarCode(222222));
        assertNull(supermarket.findByBarCode(888888));
    }

    @Test
    void findByCategory() {
        ArrayList<Product> actual = (ArrayList<Product>) supermarket.findByCategory("Bread");
        int l = actual.size();
        Product[] productsActual = new Product[l];
        // переносим все значения из листа в массив
        int i = 0;
        for (Product p : actual) {
            productsActual[i] = p;
            i++;
        }
        Product[] expected = {products[0], products[4]};
        assertArrayEquals(productsActual, expected);

    }

    @Test
    void findByBrand() {
        ArrayList<Product> actual = (ArrayList<Product>) supermarket.findByBrand("Kolosok");
        int l = actual.size();
        Product[] productsActual = new Product[l];
        // переносим все значения из листа в массив
        int i = 0;
        for (Product p : actual) {
            productsActual[i] = p;
            i++;
        }
        Product[] expected = {products[0], products[4]};
        assertArrayEquals(productsActual, expected);

    }

    @Test
    void findProductWithExpDate() {
        ArrayList<Product> actual = (ArrayList<Product>) supermarket.findProductWithExpDate();
        int l = actual.size();
        Product[] productsActual = new Product[l];
        // переносим все значения из листа в массив
        int i = 0;
        for (Product p : actual) {
            productsActual[i] = p;
            i++;
        }
        Product[] expected = {products[4], products[1]};
        assertArrayEquals(productsActual, expected);

    }

    @Test
    void skuQuantity() {
        assertEquals(5, supermarket.skuQuantity());
    }

}