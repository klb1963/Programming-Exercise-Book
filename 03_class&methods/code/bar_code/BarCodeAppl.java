package bar_code;

public class BarCodeAppl {
    public static void main(String[] args) {

        long bc = 1_234_567_890_123l;

        BarCode barCode = new BarCode(bc);

        System.out.println(barCode);

        // print
        int l = barCode.lengthCode();
        System.out.println(barCode.lengthCode());
        System.out.println("BarCode length = " + l);

        int controlSum = barCode.controlSum();
        System.out.println("Control sum: " + controlSum);

        boolean checkBarCode = barCode.isValid();
        System.out.println("Bar code is valid: " + checkBarCode);

        System.out.println("=========== methods with parameter ==============");

        l = barCode.lengthCode(bc);
        System.out.println("BarCode length = " + l);

        controlSum = barCode.controlSum(bc);
        System.out.println("Control sum: " + controlSum);

        checkBarCode = barCode.isValid(bc);
        System.out.println("Bar code is valid: " + checkBarCode);

    }
}
