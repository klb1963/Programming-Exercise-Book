package classwork_27.json_wrapper.wrapper_no_generics;

    // имя: Леонид, возраст: 59 - это данные в одной программе
    // {name: Leonid, age: 59} - это Json, который передают другой программе и она его может "прочитать" (parsing)


public class JsonWrapper {

    // поле класса
    private Object value;

    // конструктор
    public JsonWrapper(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{value: " + value + "}";
    }
}
