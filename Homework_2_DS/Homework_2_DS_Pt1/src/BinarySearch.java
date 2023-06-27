public class BinarySearch {
    public static int numSteps;

    public static int search(Student[] students, int key) {
        numSteps = 0; // Initialize the number of steps

        return binarySearch(students, key, 0, students.length - 1);
    }

    private static int binarySearch(Student[] students, int key, int left, int right) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (students[mid].getGlobalId() == key) {
                return mid; // Found the key at the current index
            }
            if (students[mid].getGlobalId() < key) {
                numSteps++;
                return binarySearch(students, key, mid + 1, right); // Search the right half
            }
            numSteps++;
            return binarySearch(students, key, left, mid - 1); // Search the left half
        }
        return -1; // Key not found
    }
}
