package structures;

public class BasicLinkedList<X> {

    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList() {

        first = null;
        last = null;
        nodeCount = 0;
    }

    public int size() {
        return nodeCount;
    }

    public void add(X item) {

        if(first == null) {
            first = new Node(item);
            last = first;
        } else {
            Node newLast = new Node(item);
            this.last.setNextNode(newLast);
            this.last = newLast;
        }

        nodeCount++;
    }

    public void insert(X item, int position) {

        if(position > size()) {
            throw new IllegalStateException("position greater than the size of the linkedList");
        }

        int index = 1;
        Node currentNode = first;
        boolean inserted = false;

        while (!inserted) {

            currentNode = currentNode.getNextNode();

            if (index == position && currentNode != null) {
                Node nodeToInsert = new Node(currentNode.getNextNode(), item);
                currentNode.setNextNode(nodeToInsert);
                inserted = true;
            }
            index++;
        }
        nodeCount++;
    }

    public X removeAt(int position) throws IllegalStateException{
        Node nodeToRemove = null;

        if(first == null) {
            throw new IllegalStateException("linkedList is empty!");
        }

        if(size() < position) {
            throw new IllegalStateException("position greater than the size of the linkedList");
        }

        Node currentNode = first;
        Node prevNode = first;

        for(int i=1; i < position && currentNode !=null; i++) {
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();

        }

        prevNode.setNextNode(currentNode.getNextNode());
        nodeCount--;

        return currentNode.getNodeItem();
    }

    public X get(int position) {

        if(first == null) {
            throw new IllegalStateException("linkedList is empty!");
        }

        if(size() < position) {
            throw new IllegalStateException("position greater than the size of the linkedList");
        }
        Node currentNode = first;

        for(int i=1; i < position && currentNode !=null; i++) {

            currentNode = currentNode.getNextNode();

        }

        return currentNode.getNodeItem();

    }

    public int find(X item) {
        if(first == null) {
            throw new IllegalStateException("linkedList is empty!");
        }

        Node currentNode = first;
        int index = -1;
        for(int i=1; i<size(); i++) {

            if(currentNode.getNodeItem().equals(item)) {
                index = i;
            }
            currentNode = currentNode.getNextNode();

        }

        return index;
    }

    public X remove() throws IllegalStateException {

        X currentFirst = null;

        if(first == null) {
            throw new IllegalStateException("Empty list!");
        } else {
            currentFirst = first.getNodeItem();
            first = first.getNextNode();
            nodeCount--;
        }

        return currentFirst;
    }

    public String toString() {
        StringBuffer contents = new StringBuffer();
        Node curNode = first;

        while(curNode != null) {
            contents.append(curNode.nodeItem);
            curNode = curNode.getNextNode();

            if(curNode != null) {
                contents.append(", ");
            }
        }

        return contents.toString();
    }

    private class Node {
        private Node nextNode;
        private X nodeItem;

        public Node(Node nextNode, X nodeItem) {
            this.nextNode = nextNode;
            this.nodeItem = nodeItem;
        }

        public Node(X nodeItem) {
            this.nextNode = null;
            this.nodeItem = nodeItem;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public X getNodeItem() {
            return nodeItem;
        }
    }

}
