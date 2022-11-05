package structures;

import inter.Stack;

import java.util.ArrayList;

public class ListStack<X> implements Stack<X> {
    private ArrayList<X> data;
    private int stackPointer;

    public ListStack() {
        data = new ArrayList<X>();
        stackPointer = 0;
    }
    @Override
    public void push(X newItem) {
        data.add(newItem);
        stackPointer++;
    }

    public X pop() throws IllegalArgumentException {

        if(stackPointer == 0) {
            throw new IllegalArgumentException("No items left");
        }

        return data.get(--stackPointer);
    }

    public boolean contains(X item) {

        return data.contains(item);
    }

    public X access(X item) throws IllegalArgumentException {
      X response = null;

      while (stackPointer > 0) {
          response = pop();
          if (response.equals(item)) return response;
      }

      throw new IllegalArgumentException("Could not find element in stack." + item);
    }

    public int size() {
        return stackPointer;
    }
}
