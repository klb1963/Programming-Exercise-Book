package currency_converter_draft.model;

import java.util.Objects;

public class Currency {
    private String name;
    private String code;

    public Currency(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Currency currency)) return false;
        return Objects.equals(name, currency.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
