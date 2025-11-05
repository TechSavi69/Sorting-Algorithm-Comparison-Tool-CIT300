public class BubbleSort {
    private long stepCount;
    
    public BubbleSort() {
        this.stepCount = 0;
    }
    
    public int[] sort(int[] array) {
        stepCount = 0;
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                stepCount++; // Comparison step
                if (array[j] > array[j + 1]) {
                    // Swap elements
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    stepCount++; // Swap step
                }
            }
        }
        return array;
    }
    
    public long getStepCount() {
        return stepCount;
    }
    
    public void resetStepCount() {
        stepCount = 0;
    }
}