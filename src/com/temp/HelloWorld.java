package com.temp;

public class HelloWorld {
	
	static DoublyLinkedList firstNode = new DoublyLinkedList(0);
	static DoublyLinkedList  tail = firstNode;

	public static void main(String[] agrs){	
		print();
		System.out.println("Deleting the first node when it is the only node in the doubly linked list.");
		delete(firstNode);
		print();
		
		firstNode = new DoublyLinkedList(0);
		tail = firstNode;
		for (int i = 1 ; i < 5 ; i++){			
			tail = createNode(i,tail );
		}	
		print();
		
		System.out.println("Deleting the first node in the doubly linked list.");
		delete(firstNode);
		print();
		
		System.out.println("Deleting the last node in the doubly linked list.");
		delete(tail);
		print();
		
		DoublyLinkedList temp = firstNode;
		for (int i = 0 ; i < 1 ; i++){			
			temp = temp.next;
		}
		
		System.out.println("Deleting the 2nd node in the doubly linked list.");
		delete(temp);
		print();
	}
	
	public static DoublyLinkedList createNode(int val,DoublyLinkedList tail){
		
		DoublyLinkedList temp = new DoublyLinkedList(val);
		
		tail.next = temp;
		temp.prev = tail;
		
		return temp;
	}
	
	public static void delete(DoublyLinkedList toBeDeleted){
		
		// Check if its firstNode or toBeDeleted is null
		if(firstNode == null || toBeDeleted == null)
			return;
		
		// Check if its the only node in the Doubly Linked List
		if(toBeDeleted.prev == null && toBeDeleted.next == null){
			
			firstNode = firstNode.next;
			return;
		}
		
		// Check if its the first node of Doubly Linked List
        if(toBeDeleted == firstNode){
			
			firstNode = firstNode.next;
			firstNode.prev = null;
			return;
		}		
		
        // Check if its the last node of Doubly Linked List
		 if(toBeDeleted.next == null){
			toBeDeleted.prev.next = null;
			return;
		}
		
		// Delete the node from anywhere in the Doubly Linked List
		toBeDeleted.prev.next = toBeDeleted.next;
		toBeDeleted.next.prev = toBeDeleted.prev;		
	}
	
	public static void print(){
		DoublyLinkedList temp = firstNode;
		System.out.println("The current list:");
		while (temp != null){
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void printReverse(){
		DoublyLinkedList temp = tail;
		System.out.println("The current list (reverse):");
		while (temp != null){
			System.out.print("TAIL"+temp.value);
			temp = temp.prev;
		}
		System.out.println();
	}
}
