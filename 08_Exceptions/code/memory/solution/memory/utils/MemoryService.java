package memory.solution.memory.utils;

public class MemoryService {
    public static int getMaxAvailableMemory() {
        // TODO Homework
        int size = 0;
        int min = 0;
        int max = Integer.MAX_VALUE;
        while (min <= max) {
            int mid = min + (max - min) / 2;//(min + max)/2
            try {
                int[] arr = new int[mid];
                size = mid;
                min = mid + 1;
            } catch (OutOfMemoryError e) {
                max = mid - 1;
            }
        }
        return size;
    }
}
