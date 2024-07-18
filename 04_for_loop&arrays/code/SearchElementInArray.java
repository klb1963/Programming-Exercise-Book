public class SearchElementInArray {

    public static void main(String[] args) {

        int[] array = {23, 45, -76, 115, -34, 28};
        int element = 115;

        int result = searchInArray(array, element);
        System.out.println(result);

    }

    private static int searchInArray(int[] array, int element) {
        int elementIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] == element){
                elementIndex = i;
                return elementIndex;
            }
        }
        return -1;
    }
}
