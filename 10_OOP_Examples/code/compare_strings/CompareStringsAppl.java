package compare_strings;

public class CompareStringsAppl {
    public static void main(String[] args) {

//        int x = 5;
//        int y = 5;
//        boolean check = x==y;
//        System.out.println(check);

        String str1 = "Hello";
        String str2 = "Hello";

        boolean checker = (str1 == str2);
        System.out.println(checker);

        str1 = str1 + ", World!";

        System.out.println(str1);

        System.out.println("----------------------------");

        String str3 = new String("Hello");
        checker = str1 == str3;
        System.out.println(checker);
        System.out.println("----------------------------");
        System.out.println(str1.equals(str3));

    }
}
