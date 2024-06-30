package bar_code;

//**Задание 1.**
//Штрих-код имеет строго регламентированную длину, то есть количество цифр,
//которое в нем содержится (обычно это 8 или 13 цифр).
//Создать класс Code, в котором реализовать методы:
//- lengthCode(long code), который возвращает длину штрих-кода
//- controlSum(long code), который возвращает сумму всех цифр штрих кода
//- isValid(long code), который проверяет штрих-код на правильное количество цифр

public class BarCode {

    //field
    private long barCode;

    // constructor
    public BarCode(long barCode) {
        this.barCode = barCode;
    }

    //getter and setter
    public long getBarCode() {
        return barCode;
    }

    public void setBarCode(long barCode) {
        this.barCode = barCode;
    }

    @Override
    public String toString() {
        return "BarCode{" +
                "barCode=" + barCode +
                '}';
    }

    //lengthCode(long code)
    public int lengthCode(long code) {
        // calculate length
        int length = 0;
        while (code > 0) {
            code = code / 10; // целочисленное деление
            length++;
        }
        return length;
    }

    // controlSum(long code)
    public int controlSum(long code) {
        int digit = 0;
        // calculate sum of digits
        int sum = 0;
        while (code > 0) {
            digit = (int) (code % 10); // целочисленное деление с остатком
            code = code / 10; // целочисленное деление
            sum += digit;
        }
        return sum;
    }

    // isValid
    public boolean isValid(long code) {
        if (lengthCode(code) == 13) {
            return true;
        } else return false;
    }

    // methods - no argument
    //lengthCode()
    public int lengthCode() {
        long temp = barCode;
        // calculate length
        int length = 0;
        while (barCode > 0) {
            barCode = barCode / 10; // целочисленное деление
            length++;
        }
        barCode = temp;
        return length;
    }

    // controlSum()
    public int controlSum() {
        long temp = barCode;
        int digit = 0;
        // calculate sum
        int sum = 0;
        while (barCode > 0) {
            digit = (int) (barCode % 10); // целочисленное деление с остатком
            barCode = barCode / 10; // целочисленное деление
            sum += digit;
        }
        barCode = temp;
        return sum;
    }

    // isValid()
    public boolean isValid() {
        if (lengthCode() == 13) {
            return true;
        } else return false;
    }
}
