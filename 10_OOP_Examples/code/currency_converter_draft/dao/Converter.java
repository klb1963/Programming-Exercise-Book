package currency_converter_draft.dao;

import currency_converter_draft.model.Currency;

public interface Converter {
    boolean loadingCurrency(Currency currency);
    <Client> Currency askClient(Client client);
    Currency reportAmount(String name);
    boolean getEndTransaction(String name);

}
