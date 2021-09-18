//////////////// FILE HEADER //////////////////////////
//
// Title: P10 Food Delivery
// Files: Delivery, Student, FoodRobot, DeliveryQueue, DeliveryQueueTester, DeliverySchedolingApp
// Course: CS300,Spring,2020
//
// Author: Meng Tian
// Email: mtian42@wisc.edu
// Lecturer's Name: Gary Dahl
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course
// staff must fully acknowledge and credit those sources here. If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons: NONE (identify each person and describe their help in detail)
// Online Sources: NONE (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////
import java.util.NoSuchElementException;

/**
 * the delivery queue class represents an array of delivery objects
 * 
 */
public class DeliveryQueue {
  private static final int INITIAL_CAPACITY = 20;// set the initial capacity of the queue is 20
  private Delivery[] heap;// the array of delivery object
  private int size;// the current number of delivery objects in the array

  /**
   * constructor of delivery queue object
   * 
   */
  public DeliveryQueue() {
    size = 0;// set the initial size of the array to zero
    heap = new Delivery[INITIAL_CAPACITY];// create a new array with capacity 20
  }

  /**
   * recursively propagates heap order violations up
   * 
   * @param index the starting position of the bubble up process
   */
  private void percolateUp(int index) {
    if (index > 0) {// check if it already reaches the peek of the array
      if (heap[index].compareTo(heap[(index - 1) / 2]) < 0) {// if not, compare the priority of it
                                                             // and its parent
        Delivery temp = heap[index];// if it has the prority, swap them
        heap[index] = heap[(index - 1) / 2];
        heap[(index - 1) / 2] = temp;
        if ((index - 1) / 2 > 0)// call this method again to compare it with the new parents
          percolateUp((index - 1) / 2);
      }
    }
  }

  /**
   * this method adds a new delivery to this priority queue. If the heap is already at capacity when
   * this method is called, it should first create a new larger capacity array (twice the previous
   * heap capacity), copy the old arrays contents into this larger array, and then use this array as
   * the heap going forward (until it is filled and replaced with an even larger one).
   * 
   * @param d the delivery object that need to be add to the queue
   */
  public void offerDelivery(Delivery d) {
    if (isEmpty() == true) {
      heap[0] = d;
      size++;
    } else {
      if (size >= heap.length) {// check if the array is full
        // if it is, make a new array and copy all existing elements
        Delivery[] newDelivery = new Delivery[2 * heap.length];
        for (int i = 0; i < heap.length; i++) {
          newDelivery[i] = heap[i];
        }
        newDelivery[heap.length] = d;// add the new object to the last
        heap = newDelivery;
        percolateUp(size);// check the priority of the array if it is in right order
        size++;// add one for the size
      } else {
        heap[size] = d;// add the new object to the last
        percolateUp(size);// check the priority of the array if it is in right order
        size++;// add one for the size
      }
    }
  }

  /**
   * recursively propagates heap order violations down
   * 
   * @param index the starting position of the bubble down process
   */
  private void percolateDown(int index) {
    // check whether the index is within the size of the heap
    if (2 * index + 1 < size) {
      Delivery rootValue = heap[index];
      int rootIndex = -1;
      // check whether the two children have higher priority than the index one
      for (int i = 0; i < 2 && i + 2 * index + 1 < this.size; i++) {
        if (heap[i + 2 * index + 1].compareTo(rootValue) < 0) {
          // if the child has higher priority
          rootValue = heap[i + 2 * index + 1];
          rootIndex = i + 2 * index + 1;
        }
      }
      // if the child does not have higher priority
      if (rootValue.compareTo(heap[index]) == 0) {
        // do nothing
      } else {
        // if child has higher priority, then swap the objects in the parent index and the its child
        // index
        Delivery child = heap[index];
        heap[index] = heap[rootIndex];
        heap[rootIndex] = child;
        percolateDown(rootIndex); // checks whether there is violations in the heap
      }
    }

  }

  /**
   * eliminates all heap order violations from the heap array
   * 
   * 
   */
  private void heapify() {

    for (int i = this.size / 2 - 1; i >= 0; i--) {// go over all objects in the array, and check its
                                                  // order
      percolateDown(i);
    }
    // use a for loop to remove the minimum value, stores that value at the end index and decrements
    // the end index, until the end index is 0
    for (int i = this.size - 1; i > 0; i--) {
      Delivery minHeap = heap[0];
      heap[0] = heap[i];
      heap[i] = minHeap;
      percolateDown(0);
    }
  }

  /**
   * removes and returns the highest priority delivery object from this priority queue, and also
   * removes all other delivery objects that “equals” (with matching studentIds or robotNames) that
   * highest priority one. After removing these deliveries, be sure to heapify your array to
   * maintain its heap structure.
   * 
   * @throws NoSuchElementException if the heap is empty
   * @return the delivery object that being removed
   * 
   */
  public Delivery pollBestDelivery() {
    if (isEmpty())// check if the array is empty
      throw new NoSuchElementException("Warning: Empty Heap!");
    Delivery returnDeli = heap[0];// get the removed object
    heap[0] = heap[size - 1];// move the last object to the first one
    heap[size - 1] = null;// set the last one to null
    size--;// size decreases one
    int m = 0;// count the number of equal objects
    for (int i = 0; i < size; i++) {
      if (returnDeli.equals(heap[i])) {// if it equals to the removed object
        heap[i] = null;// set it to null
        m++;
      }
    }
    for (int i = 0; i < size; i++) {
      if (heap[i] != null) {// if there is one position that has the object
        for (int j = 0; j < i; j++) {// check all positions before it
          if (heap[j] == null) {// if there is one is null
            heap[j] = heap[i];// move it to the front
            heap[i] = null;// set the current one to null
            break;
          }
        }
      }
    }
    size = size - m;// the size decreases as many equal objects
    heapify();// check the priority of the array if it is in right order
    return returnDeli;
  }

  /**
   * eliminates all heap order violations from the heap array
   * 
   * @throws NoSuchElementException if the heap is empty
   * @param index the starting position of the bubble down process
   */
  public Delivery peek() throws NoSuchElementException {
    if (isEmpty())
      throw new NoSuchElementException("Warning: Empty Heap!");
    return heap[0];
  }

  /**
   * return the size of the array
   * 
   * @return size the number of objects in the array
   */
  public int getSize() {
    return size;
  }

  /**
   * check if the array is empty
   * 
   * @return true if it is empty, false otherwise
   */
  public boolean isEmpty() {
    if (size == 0)
      return true;
    return false;
  }

  /**
   * Returns a String representation of a delivery queue
   * 
   * @implSpec Object class
   * @return a String representation of a delivery queue
   */
  @Override
  public String toString() {
    String string = "This DeliveryQueue contains " + size + " elements";
    if (size == 0) {
      return string;
    }
    string += ": [ ";
    for (int i = 0; i < size; i++)
      string += "\n" + heap[i].toString();
    string += " ]\n";
    return string;
  }

}
