package supermarket.ait.supermarket.model;
import java.time.LocalDate;

public class Product {
	private long barCode;
	private String name;
	private String category;
	private String brand;
	private double price;
	private LocalDate expDate;
	
	public Product(long barCode, String name, String category, String brand, double price, LocalDate expDate) {
		this.barCode = barCode;
		this.name = name;
		this.category = category;
		this.brand = brand;
		this.price = price;
		this.expDate = expDate;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getBarCode() {
		return barCode;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public String getBrand() {
		return brand;
	}

	public double getPrice() {
		return price;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	@Override
	public String toString() {
		return "Product{" +
				"barCode=" + barCode +
				", name='" + name + '\'' +
				", category='" + category + '\'' +
				", brand='" + brand + '\'' +
				", price=" + price +
				", expDate=" + expDate +
				'}';
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;

		Product product = (Product) object;

        return barCode == product.barCode;
    }

	@Override
	public int hashCode() {
		return (int) (barCode ^ (barCode >>> 32));
	}

//	Оператор >>>: barCode >>> 32 выполняет беззнаковый сдвиг вправо на 32 бита для значения barCode. Это делит barCode на 2 в степени 32 и заполняет старшие биты нулями. Этот сдвиг делается, чтобы разбить значение на две 32-битные части.
//	Оператор XOR (^): barCode ^ (barCode >>> 32) применяет побитовую операцию XOR между исходным значением barCode и результатом сдвига. XOR используется здесь для того, чтобы "смешать" старшую и младшую половины числа barCode, обеспечивая более уникальное распределение хэш-кодов.
//  Приведение к (int): Результат выражения преобразуется в тип int, так как метод hashCode() возвращает именно int.
//	Зачем это нужно?
//	Этот метод обеспечивает хэш-код на основе поля barCode, который в свою очередь используется для сравнения объектов в хэш-таблицах.
}
