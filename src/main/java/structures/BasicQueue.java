package structures;

import interfaces.Queue;

public class BasicQueue<X> implements Queue<X> {
    private X[] data;

    private int front;

    private int end;

    public BasicQueue() {
        this(1000);
    }
    public BasicQueue(int size) {
        data = (X[]) new Object[size];
        front = -1;
        end = -1;
    }

    public int size () {
        if (front == -1 && end == -1) {
            return 0;
        } else {
            return end - front + 1;
        }
    }

    public void enQueue(X item) {


        if( (end + 1) % data.length == front) {
            throw new IllegalStateException("Queue full!");
        } else if (size() == 0){
            front++;
            end++;
            data[end] = item;
        } else {
            end++;
            data[end] = item;
        }
    }

    public X deQueue() {
        X item;
        if(size() == 0) {
            throw new IllegalStateException("Queue is empty!");
        } else if (end == front) {
            item = data[front];
            data[front] = null;
            end = -1;
            front = -1;
        } else {
            item = data[front];
            data[front] = null;
            front++;
        }

        return item;

    }

    public boolean contains(X item) {
        boolean found = false;
        if(size()==0){
            throw new IllegalStateException("Queues is empty!");
        } else {
            for (int i = front; i < end; i++) {
                if (data[i].equals(item)) {
                    found = true;
                    break;
                }
            }
        }

        return found;
    }

    public X access(int position) {

        if(size() == 0 || position > size()) {
            throw new IllegalArgumentException("Illegal position");
        } else {
            int trueIndex = 0;
            for (int i = front; i < end; i++) {
                if(trueIndex == position) {
                    return data[trueIndex];
                }
                trueIndex++ ;
            }
        }

        throw new IllegalArgumentException("could note get position in queue: " + position);

    }
}
