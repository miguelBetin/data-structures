package structures;

import interfaces.Stack;

public class BasicStack<X> implements Stack<X> {
    private X[] data;
    private int stackPointer;

    public BasicStack() {
        data = (X[])new Object[1000];
        stackPointer = 0;
    }
    @Override
    public void push(X newItem) {
        data[stackPointer++] = newItem;

    }

    public X pop() throws IllegalArgumentException {

        if(stackPointer == 0) {
            throw new IllegalArgumentException("No items left");
        }

        return data[--stackPointer];
    }

    public boolean contains(X item) {

        for(int i=0; i<stackPointer; i++){
            if(data[i].equals(item)) return true;
        }

        return false;
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
