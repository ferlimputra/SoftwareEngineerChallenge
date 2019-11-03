package com.paypay.assignment;

public final class ImmutableStack<T> implements Stack<T> {

  @SuppressWarnings("rawtypes")
  private static final Stack EMPTY_STACK = new EmptyStack<>();

  private final T head;
  private final Stack<T> tail;
  private final int size;

  private ImmutableStack(T head, Stack<T> tail) {
    this.head = head;
    this.tail = tail;
    this.size = tail.size() + 1;
  }

  @SuppressWarnings("unchecked")
  public static <T> Stack<T> empty() {
    return (Stack<T>) EMPTY_STACK;
  }

  @Override
  public final int size() {
    return size;
  }

  @Override
  public final boolean isEmpty() {
    return size <= 0;
  }

  @Override
  public final Stack<T> push(T element) {
    return new ImmutableStack<>(element, this);
  }

  @Override
  public final T peek() {
    return head;
  }

  @Override
  public final Stack<T> pop() {
    return tail;
  }

  @Override
  public final Stack<T> reverse() {
    Stack<T> reversedStack = empty();
    Stack<T> stack = this;

    while (!stack.isEmpty()) {
      reversedStack = reversedStack.push(stack.peek());
      stack = stack.pop();
    }
    return reversedStack;
  }

  /**
   * Class to safely represent an empty stack.
   * 
   * @param <T>
   */
  private static final class EmptyStack<E> implements Stack<E> {

    @Override
    public int size() {
      return 0;
    }

    @Override
    public Stack<E> push(E element) {
      return new ImmutableStack<E>(element, this);
    }

    @Override
    public E peek() {
      throw new UnsupportedOperationException("Stack is empty");
    }

    @Override
    public Stack<E> pop() {
      throw new UnsupportedOperationException("Stack is empty");
    }

    @Override
    public Stack<E> reverse() {
      throw new UnsupportedOperationException("Stack is empty");
    }

    @Override
    public boolean isEmpty() {
      return true;
    }

  }
}
