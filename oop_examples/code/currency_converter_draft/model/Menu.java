package currency_converter_draft.model;

public enum Menu {
    LOADING_FILE(1,"Loading File"),
    ASK_CLIENT(2,"Ask client"),
    REPORT_AMOUNT(3,"Report amount"),
    END_TRANSACTION(4,"End transaction");

    private final int item;
    private final String action;

    Menu(int item, String action) {
        this.item = item;
        this.action = action;
    }

    public int getItem() {
        return item;
    }

    public String getAction() {
        return action;
    }

    public static void printMenu(){

    }
}
