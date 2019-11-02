package com.paypay.assignment;

/**
 * Stack
 */
public interface Stack<T> {

  public int size();

  public boolean isEmpty();

  public Stack<T> push(T element);

  public T peek();

  public Stack<T> pop();

  public Stack<T> reverse();

}
