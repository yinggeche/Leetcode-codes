class MyLinkedList {
    private int size;
    private class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
            this.next = null;
        }
    }
    private Node head;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = new Node(0);
        this.size = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= this.size){
            return -1;
        }
        else{
            Node current = this.head.next;
            for (int i = 0; i < index; i++){
                current = current.next;
            }
            return current.val;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        if (this.size == 0){
            this.head.next = new Node(val);
        }
        else{
        Node prev = this.head;
        Node current = this.head.next;
        Node NewNode = new Node(val);
        prev.next = NewNode;
        NewNode.next = current;
        }
        this.size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (this.size == 0){
            this.head.next = new Node(val);
        }
        else{
            Node prev = this.head;
        Node current = this.head.next;
        Node NewNode = new Node(val);
        for (int i = 0; i < this.size; i++){
            prev = current;
            current = current.next;
        }
        prev.next = NewNode;
        }
        this.size++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > this.size){
            return;
        }
        else if (index <= 0){
            this.addAtHead(val);
        }
        else if (index == this.size){
            this.addAtTail(val);
        }
        else {
            Node NewNode = new Node(val);
            Node prev = this.head;
            Node current = this.head.next;
            for (int i = 0; i < index; i++){
                prev = current;
                current = current.next;
            }
            prev.next = NewNode;
            NewNode.next = current;
        }
        this.size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size){
            return;
        }
        else{
            Node prev = this.head;
            Node current = this.head.next;
            for (int i = 0; i < index; i++){
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
        }
        this.size--;
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
