package classwork_27.json_wrapper.wrapper_with_generics;

public class JsonWrapperAppl {
    public static void main(String[] args) {
        JsonWrapper<String> wrapper = new JsonWrapper<>("10");
        System.out.println(wrapper.toString());
        System.out.println(wrapper.getValue());

        JsonWrapper<Integer> numWrapper = new JsonWrapper<>(10);
        System.out.println(numWrapper.toString());
        System.out.println(numWrapper.getValue());
        System.out.println(numWrapper.getValue() * 50);
    }
}
