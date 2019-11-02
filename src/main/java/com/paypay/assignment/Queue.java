package com.paypay.assignment;

public interface Queue<T> {

  public Queue<T> enQueue(T t);

  /**
   * Removes the element at the beginning of the immutable queue, and returns the new queue.
   * 
   * @return
   */
  public Queue<T> deQueue();

  public T head();

  public boolean isEmpty();
}
