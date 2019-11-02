package com.paypay.assignment;

/**
 * Assignment
 */
public class Assignment {

  public static void main(String[] args) {
    System.out.println("Start");
    Stack<String> test = ImmutableStack.emptyStack();
    test = test.push("1");
    test = test.push("2");
    test = test.push("3");
    test = test.push("4");
    test = test.reverse();

    while (!test.isEmpty()) {
      System.out.println(test.peek());
      test = test.pop();
    }
  }
}
