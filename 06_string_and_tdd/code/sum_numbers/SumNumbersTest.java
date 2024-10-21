package sum_numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SumNumbersTest {

    SumNumbers sumNumbers;
    String str = "1 23 456";
    String[] numbers = str.split(" ");

    @BeforeEach
    void setUp() {

        sumNumbers = new SumNumbers(str);

    }

    @Test
    void test(){
        int expected = 480;
        int actual = SumNumbers.getSumOfNumbers(numbers);
        assertEquals(expected, actual);
    }

}