import java.util.Arrays;

public class BinaryHeap {
    private int DefaultSize = 10;
    private int []array;
    private int itemCount;

    public BinaryHeap(){
        array = new int[DefaultSize];
        itemCount = 0;
    }

    /**
     *  Adds an item to the heap
     */
    public void add(int item){
        if (itemCount == array.length - 1)
            resizeArray();
        array[++itemCount] = item;
        climbUp(itemCount);
    }

    /**
     * Removes the smallest item in the heap
     */
    public int remove(){
        if(itemCount == 0) {
            System.out.println("No Items to Remove");
            return array[0];
        }

        int toRemove = array[1];
        array[1] = array[itemCount--];
        siftDown(1);
        return toRemove;
    }

    /**
     * Doubles the size of the inner array for this heap implementation
     */
    private void resizeArray(){
        array = Arrays.copyOf(array, array.length * 2);
    }

    /**
     *  Swaps the items at index1 and index1 of the inner array
     */
    private void swapArray(int index1, int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

    /**
     * Takes the item at index (index) in the array, and swaps it up to
     * the point at which it belongs in the min heap
     * (assuming it was placed at the bottom)
     */
    private void climbUp(int index){
        while(index > 1 && array[index] < array[index / 2]){
            swapArray(index, index / 2);
            index = index / 2;
        }
    }

    /**
     * Treats the index [index] as the root, and pushes the item at that
     * index in the heap down to the place that it truly belongs in the heap.
     */
    private void siftDown(int index){
        int parent = index;
        int child = 2 * parent;

        while(child <= itemCount){
            if (child <= itemCount - 1 && array[child] > array[child + 1])
                child++;
            if (array[parent] > array[child])
                swapArray(parent, child);
            parent = child;
            child = 2 * parent;
        }
    }


}
