package detail.test;

import detail.dao.Stock;
import detail.dao.StockImpl;
import detail.model.Detail;
import detail.model.Gear;
import detail.model.Lever;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

class StockImplTest {

    Stock stock;
    Detail[] details;

    @BeforeEach
    void setUp() {

        stock = new StockImpl(5);
        details = new Detail[5];
        details[0] = new Gear(1L, 10, "steal", "Bosh", 2.0, 12, 6);
        details[1] = new Gear(2L, 10, "steal", "Bosh", 2.0, 24, 12);
        details[2] = new Lever(3L, 100, "steal", "Bosh", 3.0, 12);
        details[3] = new Lever(4L, 100, "steal", "Bosh", 3.0, 12);

        for (int i = 0; i < details.length; i++) {
            stock.addDetail(details[i]);
        }
    }

    @Test
    void addDetail() {
        assertFalse(stock.addDetail(details[3]));
        assertFalse(stock.addDetail(null));
        Detail oneMoredetail = new Gear(5L, 10, "steal", "Bosh", 2.0, 24, 12);
        assertTrue(stock.addDetail(oneMoredetail));
        assertEquals(5, stock.quantity());
        oneMoredetail = new Gear(6L, 10, "steal", "Bosh", 2.0, 24, 12);
        assertFalse(stock.addDetail(oneMoredetail));
    }

    @Test
    void findByBarCode() {
        assertEquals(details[0], stock.findByBarCode(1L));
        assertNull(stock.findByBarCode(7L));
    }

    @Test
    void updateDetail() {
    }

    @Test
    void deleteDetail() {
    }

    @Test
    void printStock() {
        stock.printStock();
    }
}