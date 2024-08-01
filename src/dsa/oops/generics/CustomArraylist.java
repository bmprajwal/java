package dsa.oops.generics;

import java.util.ArrayList;
import java.util.Arrays;

public class CustomArraylist<T> {
    private Object[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArraylist() {
        this.data = new Object[DEFAULT_SIZE];
    }
    public CustomArraylist(int size) {
        this.data = new Object[size];
    }

    void add(T num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    private void resize() {
        Object[] temp = new Object[2 * size];
        for (int i = 0; i < data.length; i++) {
            temp[i] = (T) data[i];
        }
        data = temp;
    }

    private boolean isFull() {
        return data.length == size;
    }

    T remove(){
        return (T) data[--size];
    }

    int size(){
        return size;
    }

    T get(int index){
        if(index < size){
            return (T)  data[index];
        }
        return null;
    }

    @Override
    public String toString() {
        return "CustomArraylist{" +
                "data=" + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        CustomArraylist<String> list = new CustomArraylist<>(5);
        list.add("kdjf");
        list.add("dkf");
        String removed = list.remove();
        System.out.println(removed);
        System.out.println(list);
    }
}
