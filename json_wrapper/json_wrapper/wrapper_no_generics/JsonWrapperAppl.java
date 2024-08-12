package classwork_27.json_wrapper.wrapper_no_generics;

public class JsonWrapperAppl {
    public static void main(String[] args) {

        JsonWrapper wrapper = new JsonWrapper("10");
        System.out.println(wrapper);
        System.out.println("---------------------");

        // int a = (int) wrapper.getValue();
        Integer aa = (int) wrapper.getValue();
        System.out.println(aa);

    }
}
