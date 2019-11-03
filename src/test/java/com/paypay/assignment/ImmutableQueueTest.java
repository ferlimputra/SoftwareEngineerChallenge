package com.paypay.assignment;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * ImmutableQueueTest
 */
public class ImmutableQueueTest {

  @Test
  public void enqueue_queueShouldBeImmutable() {
    // Given
    Queue<String> queue = ImmutableQueue.empty();
    Queue<String> queue2;
    String first = "1";

    // When
    queue2 = queue.enQueue(first);

    // Then
    assertNotEquals(queue, queue2);
    assertTrue(queue.isEmpty());
    assertFalse(queue2.isEmpty());
  }

  @Test
  public void enqueue_singleElement_queueShouldNotBeEmpty() {
    // Given
    Queue<String> queue = ImmutableQueue.empty();
    String first = "1";

    // When
    queue = queue.enQueue(first);

    // Then
    assertFalse(queue.isEmpty());
    assertEquals("1", queue.head());
  }

  @Test
  public void enqueue_multipleElements_shouldAddedSuccessfully() {
    // Given
    Queue<String> queue = ImmutableQueue.empty();
    String[] arr = {"1", "2", "3"};

    // When
    for (String element : arr) {
      queue = queue.enQueue(element);
    }

    // Then
    assertFalse(queue.isEmpty());
    assertEquals(arr.length, queue.size());
  }

  @Test
  public void dequeue_singleElement_queueShouldBeEmpty() {
    // Given
    Queue<String> queue = ImmutableQueue.empty();
    String first = "1";

    // When
    queue = queue.enQueue(first);
    queue = queue.deQueue();

    // Then
    assertTrue(queue.isEmpty());
  }

  @Test
  public void dequeue_multipleElements_queueShouldBeEmpty() {
    // Given
    Queue<String> queue = ImmutableQueue.empty();
    String[] arr = {"1", "2", "3"};

    // When
    for (String element : arr) {
      queue = queue.enQueue(element);
      queue = queue.deQueue();
    }

    // Then
    assertTrue(queue.isEmpty());
  }

  @Test(expected = UnsupportedOperationException.class)
  public void dequeue_emptyQueue_shouldThrowException() {
    // Given
    Queue<String> queue = ImmutableQueue.empty();

    // When
    queue = queue.deQueue();
  }

}
