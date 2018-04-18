/**********************
 Hambartzum Gamburian
 PQ_Heap.java
 **********************/

import java.util.*;

public class PQ_Heap<T extends Comparable<T>> {

    //Using ArrayList instead of Array to implement heap
    private ArrayList<T> myList;
    private ArrayList<T> printList;

    //Creating the object
    public PQ_Heap() {
        myList = new ArrayList<T>();
    }

    public void add(T item) {
        myList.add(item);
        up(myList);
    }

    public T remove() throws NoSuchElementException {
        if (myList.size() == 0) {
            //If the ArrayList is empty, throw an exception at the user
            throw new NoSuchElementException();
        }
        if (myList.size() == 1) {
            return myList.remove(0);
        }
        T temp = myList.get(0);
        //Removes the last item in the ArrayList then sets it to the head of the ArrayList
        myList.set(0, myList.remove(myList.size()-1));
        down(myList);
        //Return generic object
        return temp;
    }

    public int size() {
        return myList.size();
    }

    public boolean isEmpty() {
        return myList.isEmpty();
    }

    public String toString() {
        return myList.toString();
    }

    public String viewValues() {
        //Creating a temp ArrayList with contents of current ArrayList
        //Then removing the contents of the temp ArrayList one by one to view values
        //In the correct priority assigned
        printList = new ArrayList<T>(myList);
        //Using a StringBuffer object to write all my text to this then returning
        //This as a String
        StringBuffer sb = new StringBuffer();
        while(printList.size() != 0) {
            sb.append(printRemove().toString() + "\n");
        }
        return sb.toString();
    }

    private T printRemove() throws NoSuchElementException {
        if (printList.size() == 0) {
            //If the ArrayList is empty, throw an exception at the user
            throw new NoSuchElementException();
        }
        if (printList.size() == 1) {
            return printList.remove(0);
        }
        T temp = printList.get(0);
        //Removes the last item in the ArrayList then sets it to the head of the ArrayList
        printList.set(0, printList.remove(printList.size()-1));
        down(printList);
        //Return generic object
        return temp;
    }

    private void up(ArrayList<T> list) {
        //Last element index
        int k = list.size() - 1;
        while (k > 0) {
            //Middle element index
            int p = (k-1)/2;
            //Getting the objects and storing them
            T item = list.get(k);
            T parent = list.get(p);

            //Comparing using the generic object compareTo() method (in this case PrintJob)
            if (item.compareTo(parent) > 0) {
                list.set(k, parent);
                list.set(p, item);
                k = p;
            }

            else {
                break;
            }
        }
    }

    private void down(ArrayList<T> list) {
        int k = 0;
        //L is a child in the heap
        int l = 2*k+1;
        while (l < list.size()) {
            int max=l, z=l+1;

            //Comparing using the generic object compareTo() method (in this case PrintJob)
            if (z < list.size()) {
                if (list.get(z).compareTo(list.get(l)) > 0) {
                    max++;
                }
            }

            //Comparing using the generic object compareTo() method (in this case PrintJob)
            if (list.get(k).compareTo(list.get(max)) < 0) {
                T temp = list.get(k);
                list.set(k, list.get(max));
                list.set(max, temp);
                k = max;
                l = 2*k+1;
            }

            else {
                break;
            }
        }
    }
}
