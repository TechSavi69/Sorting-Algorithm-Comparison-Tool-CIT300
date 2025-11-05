public class QuickSort {
    private long stepCount;
    
    public QuickSort() {
        this.stepCount = 0;
    }
    
    public int[] sort(int[] array) {
        stepCount = 0;
        return quickSort(array, 0, array.length - 1);
    }
    
    private int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
        return array;
    }
    
    private int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);
        
        for (int j = low; j < high; j++) {
            stepCount++; // Comparison step
            if (array[j] <= pivot) {
                i++;
                
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                stepCount++; // Swap step
            }
        }
        
        // Swap array[i+1] and array[high] (pivot)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        stepCount++; // Swap step
        
        return i + 1;
    }
    
    public long getStepCount() {
        return stepCount;
    }
}