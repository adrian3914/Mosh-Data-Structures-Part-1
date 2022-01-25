package ca.adrian.arrays;

public class ArrayAdrian {
    private int[] array;
    private int count;

    public ArrayAdrian(int length) {
        this.array = new int[length];
        this. count = 0;
    }

    // add
    public void insert(int element){

        if (count == array.length){
            // create new array with bigger
            int[] newArray = new int[(array.length + 1)];

           for (int i = 0; i < array.length; i++){
               newArray[i] = array[i];
           }
           array = newArray;
           array[count++] = element;

        }else {
            array[count++] = element;
        }
    }

    // Remove
    public void removeAt(int index){
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();

        int[] newArray = new int[count -1];

        for (int i = 0; i < count; i++) {

            if (i == index){

                for (int j = index; j < array.length; j++) {
                    if (j != array.length -1)
                    array[j] = array[j + 1];
                }

                array[array.length - 1] = 0;
                count--;
            }
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    public int length(){
        return array.length;
    }

    // index of
    public int indexOf(int item){

        for (int i = 0; i < array.length; i++){
            if (array[i] == item)
                return i;
        }

        return -1;
    }

    public void printArray(){

        System.out.print("[");
        for (int i = 0; i < count; i++){

            if (i+1 == count)
                System.out.print(array[i] + "]");
            else
                System.out.print(array[i] + ", ");
        }

    }
}
