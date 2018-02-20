/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    // List is empty, no cycles
    if(head == null) return false;
    HashSet<Node> dataSet = new HashSet<>();
    
    Node current = head;
    while(current.next != null){
        if(dataSet.contains(current)){
            return true;
        }
        else{
            dataSet.add(current);
            current = current.next;
        }
    }
    return false;
}
