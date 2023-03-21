package iterators;

import java.util.Iterator;
import nodes.DLLNode;

public class DLLIterator<E> implements Iterator<E> {
	
	
	DLLNode<E> currentNode;
	int iterationType;
	// reversed is used for when we are looping from beginning to end and then back.
	// Once it has looped from beginning to end, it will be set as true.
	boolean reversed = false;
	

	public DLLIterator(DLLNode<E> start, int iterType) {
		this.currentNode = start;
		this.iterationType = iterType;
	}
	
	public E next() {
		
		// Used for looping from beginning to end and then back.
		// Checks whether or not there exists a next node.
		// If we are only using beginning to end or end to beginning, it has no effect
		if (this.currentNode.getNext() == null) {
			this.reversed = true;
		}
		
		DLLNode<E> nextNode = null;
		// Checks for iteration type 1 or the beginning to end part of the full traversal.
		if (this.iterationType == 1 || !this.reversed) {
			nextNode = this.currentNode.getNext();
			
		// Checks for iteration type -1 or the end to beginning part of the full traversal.
		} else if (this.iterationType == -1 || this.reversed) {
			nextNode = this.currentNode.getPrev();
		}
		
		E temp = this.currentNode.getData();
		
		
		// If the next node is null, it sets the current node as null.
		// Simply checking if the next node exists in the hasNext method will exclude the final nodes.
		if (nextNode == null) {
			this.currentNode = null;
		} else {
			this.currentNode = nextNode;
		}
		return temp;
	}
	

	@Override
	public boolean hasNext() {
		return this.currentNode != null;
	}
}