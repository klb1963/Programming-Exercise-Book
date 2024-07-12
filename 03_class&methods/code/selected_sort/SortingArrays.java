package selected_sort;

public class SortingArrays {
    public static void main(String[] args) {
        int[] array = {10, 30, -20, 50, -100};
        // print array
        ArrayMethods.printArray(array);
        // sort array in ascending (по возрастанию, от меньшего к большему)
        ArrayMethods.sortArrayAscending(array);
        // print array after sorting
        ArrayMethods.printArray(array);
        // sort array in descending (по убыванию, от большего к меньшему)
        ArrayMethods.sortArrayDescending(array);
        // print array after sorting
        ArrayMethods.printArray(array);
    }
}
