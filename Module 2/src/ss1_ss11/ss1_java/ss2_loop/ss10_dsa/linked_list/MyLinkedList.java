package ss1_ss11.ss1_java.ss2_loop.ss10_dsa.linked_list;

public class MyLinkedList<E> {
    class Node<E> {
        E data;
        Node<E> next;

        public Node(E data) {
            this.data = data;
        }
    }
    private Node<E> head;
    private int numNodes = 0;

    public MyLinkedList(E data) {
        head = new Node<>(data);
        numNodes++;
    }

    public void add(E data) {
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node<>(data);
        numNodes++;
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(E data) {
        add(data);
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }

        Node<E> temp = head;
        if (index == 0) {
            head = head.next;
        } else {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node<E> nodeToRemove = temp.next;
            temp.next = nodeToRemove.next;
            numNodes--;
            return nodeToRemove.data;
        }
        numNodes--;
        return temp.data;
    }

    public boolean remove(Object o) {
        if (head == null) return false;
        if (head.data.equals(o)) {
            head = head.next;
            numNodes--;
            return true;
        }
        Node<E> temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(o)) {
                temp.next = temp.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index out of range.");
        }
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int size() {
        return numNodes;
    }

    public void printList() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public MyLinkedList<E> clone() {
        MyLinkedList<E> cloneList = new MyLinkedList<>(head.data);
        Node<E> temp = head.next;
        while (temp != null) {
            cloneList.add(temp.data);
            temp = temp.next;
        }
        return cloneList;
    }

    public boolean contains(E o) {
        Node<E> temp = head;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E o) {
        Node<E> temp = head;
        int index = 0;
        while (temp != null) {
            if (temp.data.equals(o)) {
                return index;
            }
            temp = temp.next;
            index++;
        }
        return -1;
    }
}
