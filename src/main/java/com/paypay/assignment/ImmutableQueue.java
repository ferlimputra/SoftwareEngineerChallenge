package com.paypay.assignment;

/**
 * QueueImpl
 */
public final class ImmutableQueue<T> implements Queue<T> {

  @SuppressWarnings("rawtypes")
  private static final Queue EMPTY_QUEUE = new EmptyQueue<>();

  private final Stack<T> front;
  private final Stack<T> rear;

  private ImmutableQueue(Stack<T> front, Stack<T> rear) {
    boolean isFrontEmpty = front.isEmpty();
    boolean isRearEmpty = rear.isEmpty();

    // Reverse rear and assign to front if the rear is not empty
    if (isFrontEmpty && !isRearEmpty) {
      this.front = rear.reverse();
    } else {
      this.front = front;
    }
    this.rear = isFrontEmpty ? front : rear;
  }

  @Override
  public Queue<T> enQueue(T element) {
    return new ImmutableQueue<>(front, rear.push(element));
  }

  @Override
  public Queue<T> deQueue() {
    if (front.isEmpty()) {
      throw new UnsupportedOperationException("Queue is empty");
    }
    return new ImmutableQueue<>(front.pop(), rear.isEmpty() ? rear : rear.pop());
  }

  @Override
  public T head() {
    return front.peek();
  }

  @Override
  public boolean isEmpty() {
    return front.isEmpty();
  }

  @Override
  public int size() {
    return front.size() + rear.size();
  }

  @SuppressWarnings("unchecked")
  public static final <T> Queue<T> empty() {
    return (Queue<T>) EMPTY_QUEUE;
  }

  /**
   * Class to safely represent an empty queue.
   * 
   * @param <T>
   */
  private static final class EmptyQueue<T> implements Queue<T> {

    @Override
    @SuppressWarnings("unchecked")
    public final Queue<T> enQueue(T element) {
      return new ImmutableQueue<T>((Stack<T>) ImmutableStack.empty().push(element),
          ImmutableStack.empty());
    }

    @Override
    public Queue<T> deQueue() {
      throw new UnsupportedOperationException("Queue is empty");
    }

    @Override
    public T head() {
      throw new UnsupportedOperationException("Queue is empty");
    }

    @Override
    public boolean isEmpty() {
      return true;
    }

    @Override
    public int size() {
      return 0;
    }

  }

}
