class MyLinkedList {
    private int size;
    private class Node {
        int val; // value
        Node next; // Node next
        Node(int val) {
            this.val = val;
            this.next = null;
        } // constructor of Node
    }
    private Node head; // single linkedlist only needs head

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;
        this.head = new Node(0);
    } //constructor of MyLinkedList

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if ((index < 0) || (index >= this.size)) {
            return -1;
        } //index is invalid
        else {
            Node current = this.head.next;
            //head是一个虚拟节点，所以真正的current得往后挪一个
            for (int i = 0; i < index; i++)
            {
                current = current.next;
            }
            return current.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        this.addAtIndex(0, val);
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        this.addAtIndex(size, val);
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > this.size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        Node NewNode = new Node(val); // 当前要插入的node
        Node prev = this.head; //把node前一个节点存储下来
        Node current = this.head.next; //把node后一个节点存储下来
        for (int i = 0; i < index; i++){
            prev = current;
            current = current.next;
        }
        prev.next = NewNode;
        NewNode.next = current;
        System.out.println(head.val);
        this.size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if ((index < 0) || (index >= this.size)){
            return;
        }
        else{
            Node prev = this.head;
            Node current = this.head.next;
            for(int i = 0; i < index; i++){
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
            this.size--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
