public class MergeSort {
    public static void sort(Student[] students) {

        if (students == null || students.length <= 1) {
            return; // Base case: nothing to sort
        }
        mergeSort(students, 0, students.length - 1);
    }

    private static void mergeSort(Student[] students, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(students, left, mid); // Sort left half
            mergeSort(students, mid + 1, right); // Sort right half
            merge(students, left, mid, right); // Merge sorted halves
        }
    }

    private static void merge(Student[] students, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Student[] leftArray = new Student[n1];
        Student[] rightArray = new Student[n2];
        // Copy data to temporary arrays
        System.arraycopy(students, left, leftArray, 0, n1);
        System.arraycopy(students, mid + 1, rightArray, 0, n2);
        int i = 0, j = 0;
        int k = left; // Initial index of merged subarray
        // Merge the two arrays
        while (i < n1 && j < n2) {
            if (leftArray[i].getGlobalId() <= rightArray[j].getGlobalId()) {
                students[k] = leftArray[i];
                i++;
            } else {
                students[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements of leftArray, if any
        while (i < n1) {
            students[k] = leftArray[i];
            i++;
            k++;
        }
        // Copy remaining elements of rightArray, if any
        while (j < n2) {
            students[k] = rightArray[j];
            j++;
            k++;
        }
    }
}