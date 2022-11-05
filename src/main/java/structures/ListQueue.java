package structures;

import interfaces.Queue;

import java.util.ArrayList;

public class ListQueue<X> implements Queue<X> {
    private ArrayList<X> data;
    public ListQueue() {
        data = new ArrayList<>();
    }

    public int size () {
        return data.size();
    }

    public void enQueue(X item) {

        data.add(item);
    }

    public X deQueue() {
        X item = null;
        if(size() == 0) {
            throw new IllegalStateException("Queue is empty!");
        } else {
            item = data.get(0);
            data.remove(0);
            return item;
        }

    }
    public boolean contains(X item) {
        return data.contains(item);
    }
    public X access(int position) {

        if(size() == 0 || position > size()) {
            throw new IllegalArgumentException("Illegal position");
        } else {
            return data.get(position);
        }
    }
}
