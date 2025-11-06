public class MergeSort {
    private long stepCount;
    
    public MergeSort() {
        this.stepCount = 0;
    }
    
    public int[] sort(int[] array) {
        stepCount = 0;
        return mergeSort(array, 0, array.length - 1);
    }
    
    private int[] mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            
            merge(array, left, mid, right);
        }
        return array;
    }
    
    private void merge(int[] array, int left, int mid, int right) {
        // Create temporary arrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        
        // Copy data to temp arrays
        //
        for (int i = 0; i < n1; i++) {
            leftArray[i] = array[left + i];
            stepCount++;
        }
        for (int j = 0; j < n2; j++) {
            rightArray[j] = array[mid + 1 + j];
            stepCount++;
        }
        
        // Merge the temp arrays
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            stepCount++; // Comparison step
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
            stepCount++; // Assignment step
        }
        
        // Copy remaining elements
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
            stepCount++;
        }
        
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
            stepCount++;
        }
    }
    
    public long getStepCount() {
        return stepCount;
    }
}