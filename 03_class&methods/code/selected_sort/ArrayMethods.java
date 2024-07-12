package selected_sort;

public class ArrayMethods {

    //сортировка массива методом selected sort от меньшего к большему
    public static int[] sortArrayAscending(int[] array){
        int min = array[0];
        int indexMin = 0;
        for (int i = 0; i < array.length; i++) {
            min = array[i];
            indexMin = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min){
                    min = array[j];
                    indexMin = j;
                }
            }
            // swap elements of array
            int tmp = array[i];
            array[i]= array[indexMin];
            array[indexMin]= tmp;
        }return array;



    }//сортировка массива методом selected search от большего к меньшему
    public static int[] sortArrayDescending(int[] array) {
        int max = array[0];
        int indexMax = 0;
        for (int i = 0; i < array.length; i++) {
            max = array[i];
            indexMax = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] > max) {
                    max = array[j];
                    indexMax = j;
                }
            }
            int tmp = array[i];
            array[i] = array[indexMax];
            array[indexMax] = tmp;
        }
        return array;
    }

    // print array
    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println();
        System.out.println("-------------------------------------");
    }

}
