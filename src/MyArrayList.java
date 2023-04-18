public class MyArrayList<T> implements MyList{
    private Object[] arr;
    private int size;
    public MyArrayList() {
        this.arr = new Object[10];
        this.size = 0;
    }
    public void add(Object item, int index) {
        if (index < 0 || index > arr.length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        if (arr.length + 1 > arr.length) {
            T[] newArr = (T[]) arr[arr.length*2];
            arr = newArr;
        }
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = item;
    }
    public boolean remove(Object item) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].equals(item)) {
                for (int j = i; j < arr.length - 1; j++) {
                    arr[j] = arr[j + 1];
                }
                arr[arr.length - 1] = null;
                return true;
            }
        }
        return false;
    }
    public void add(Object element) {
        if (size == arr.length) {
            arr = new Object[arr.length*2];
        }
        arr[size++] = element;
    }
    public Object get(int index){
        return arr[index];
    }
    public Object[] remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = (T) arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[--size] = null;
        return (Object[]) arr[size];
    }
    public int size(){
        return size;
    }
    public void clear(){
        arr = new Object[arr.length];
        for(int i = 0; i<arr.length; i++){
            arr[i]=null;
        }
    }
    public boolean contains(Object o){
        for(int i = 0; i< arr.length; i++){
            if(o==arr[i]){
                return true;
            }
        }
        return false;
    }
    public void sort(){
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((Integer) arr[i] >(Integer) arr[j]) {
                    temp = (int) arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public int indexOf(Object o) {
        for(int i = 0; i< arr.length; i++){
            if(o == arr[i]){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(Object o){
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == o) {
                return i;
            }
        }
        return -1;
    }
}
