// Introduced in Chapter 14
/**
 * A nearly-perfect tree where nodes are <= their children.
 * Can be used as a priority queue or for heapsort.
 */
import java.util.*;
import java.util.ArrayList;

public class Heap<E extends Comparable<E>> {

  /** Contiguous representation of the tree. */
   ArrayList<E> data;

  /** The tree is initially empty. */
  public Heap() {
    data = new ArrayList<E>();
  }

  /**
   * Copy the elements of unsortedData into the tree, then
   * rearrange them to make it a heap.
   */
  protected Heap<E>  buildHeap() {
    
    for (int i = (data.size() / 2) - 1; i >= 0; i--) {
      filterDown(i);
    }
    return this;
  }

  /** Add a new element, maintaining the heap properties. */
  public void add(E target) {
    data.add(target);
    filterUp(data.size() - 1);
  }

  /** Move the element at index down to restore the heap properties. */
  protected void filterDown(int index) {
    while (index < data.size()) {
      int left = leftChildIndex(index);
      int right = rightChildIndex(index);
      int smallest = index;
      if ((left < data.size())
          && (data.get(left).compareTo(data.get(smallest)) < 0)) {
        smallest = left;
      }
      if ((right < data.size())
          && (data.get(right).compareTo(data.get(smallest)) < 0)) {
        smallest = right;
      }
      if (index == smallest) {
        return;
      }
      swap(index, smallest);
      index = smallest;
    }
  }

  /** Move the element at index up to restore the heap properties. */
  protected void filterUp(int index) {
    int parent = parentIndex(index);
    while (parent >= 0) {
      if (data.get(index).compareTo(data.get(parent)) < 0) {
        swap(index, parent);
        index = parent;
        parent = parentIndex(index);
      } else {
        return;
      }
    }
  }

  /** Sort data. */
  

  /** Return true if this Heap is empty. */
  public boolean isEmpty() {
    return data.isEmpty();
  }

  /** Return the index of the left child of the node at index. */
  protected static int leftChildIndex(int index) {
    return (2 * index) + 1;
  }
  
  /** Return the index of the parent of the node at index. */
  protected static int parentIndex(int index) {
    return (index - 1) / 2;
  }

  /** Remove and return the smallest element in the Heap. */
  public E remove() {
    E result = data.get(0);
    E lastElement = data.remove(data.size() - 1);
    if (data.size() > 0) {
      data.set(0, lastElement);
    }
    filterDown(0);
    return result;
  }

  /** Return the index of the right child of the node at index. */
  protected static int rightChildIndex(int index) {
    return (2 * index) + 2;
  }

  /** Swap the elements at indices i and j. */
  protected void swap(int i, int j) {
    E temp = data.get(i);
    data.set(i, data.get(j));
    data.set(j, temp);
  }

}