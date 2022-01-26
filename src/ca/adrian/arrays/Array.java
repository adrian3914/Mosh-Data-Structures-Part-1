package ca.adrian.arrays;

public class Array {
    private int[] items;
    private int count;

    public Array(int length){
        this.items = new int[length];
    }

    // Insert
    public void insert(int item){
        if (items.length == count){
            int[] newItems = new int[count * 2];

            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }

            this.items = newItems;
        }

        items[count++] = item;
    }
    // Remove

    public void removeAt(int index){
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        for (int i = index; i < count ; i++) {
            items[i] = items[i +1];
        }

        count--;
    }
    // indexOf

    public int indexOf(int item){
        for (int i = 0; i < count; i++){
            if (items[i] == item)
            return i;
        }
        return -1;
    }
    // print
    public void print(){
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    // Max
    public int max(){
        int max = items[0];

        for (int i = 1; i < count; i++){
            if (items[i] > max){
                max = items[i];
            }
        }
        return max;
    }

    //reverse()
    public void reverse(){
        int[] reversedArray = new int[count];
        int j = 0;

        for (int i = (count - 1); i >= 0 ; i--) {
                reversedArray[j] = items[i];
                j++;
        }
        items = reversedArray;
    }

//    // intersect()
//    public int[] intersect(int[] other){
//        ArrayList<Integer> list = new ArrayList<>();
//        int count = 0;
//        int j = 0;
//
//        // 1 2 3
//        // 3 4 1 2 3
//
//        for (int i = 0; i < count; i++) {
//
//            while (j < other.length){
//                if (items[i] == other[j]){
//                    list.add(items[i]);
//                }
//                j++;
//            }
//        }
//
//    }
}
