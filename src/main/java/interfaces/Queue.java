package interfaces;

public interface Queue<X> {

    void enQueue(X newItem);
    X deQueue();
    boolean contains(X item);
    X access(int positions);
    int size();
}
