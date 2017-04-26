/**
 * Write a description of class MergeHeap here.
 *
 * Two heaps are generated and then a specified amount of elements are inserted into them.
 * MergeHeap1() checks for which heap is bigger/smaller and then a for loop iterates through
 * the smaller heap, adds each element (using the Heap add() function) of the smaller heap
 * into the bigger heap, and then removes said element with the remove() function. MergeHeap2()
 * checks for which heap is bigger/smaller and then a for loop iterates through the smaller heap,
 * adds each element (using the arraylist add() function) of the smaller heap into the bigger
 * heap, and then removes said element with the remove() function. The buildHeap() method then
 * sorts all of the elements in the heap.
 *
 * @Christopher (your name)
 * @10/7/2016 (a version number or a date)
 */

import java.util.*;

public class MergeHeap<E extends Comparable<E>>
{
        public static void main (String[] args) {
            MergeHeap mh = new MergeHeap();
            int size=40000000;
            Random r=new Random();
            Heap<Integer> he= new Heap<Integer>();
            he.data=new ArrayList<Integer>(size);
            Heap<Integer> he2= new Heap<Integer>();
            he2.data=new ArrayList<Integer>(size);


            for (int i = 0; i < size; i++) {
                he.data.add(r.nextInt(size));
                he2.data.add(r.nextInt(size));
            }

            /*long t1= System.currentTimeMillis();
            mh.mergeHeap1(he,he2);

            long t2= System.currentTimeMillis();
            System.out.println(t2-t1);*/

            long t3= System.currentTimeMillis();
            mh.mergeHeap2(he,he2);

            long t4= System.currentTimeMillis();
            System.out.println(t4-t3);


  }

    public  Heap<E> mergeHeap1(Heap h1, Heap h2) {
        Heap L;
        Heap S;

        if(h1.data.size() > h2.data.size()){
            L = h1;
            S = h2;
        }else if(h1.data.size() < h2.data.size()) {
            L = h2;
            S = h1;
        }else {
            L = h1;
            S = h2;
        }
        int sz = S.data.size();
        for(int i = 0; i < sz; i++){
            L.add(S.remove());
        }
    return L;
    }

    public  Heap<E> mergeHeap2(Heap h1, Heap h2) {
        Heap L;
        Heap S;

        if(h1.data.size() > h2.data.size()){
            L = h1;
            S = h2;
        }else if(h1.data.size() < h2.data.size()) {
            L = h2;
            S = h1;
        }else {
            L = h1;
            S = h2;
        }
        int sz = S.data.size();

        for(int i = 0; i < sz; i++){
            L.data.add(S.remove());
        }
        L.buildHeap();
    return L;
    }
}
