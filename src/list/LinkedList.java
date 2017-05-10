package list;

public class LinkedList<E> implements List<E> {
	
	private int size = 0;
	private Node<E> head = null;
	
	@Override
	public void add(E element) {
		Node<E> newNode = new Node<E>( element );
		
		if( head == null ) {
			head = newNode;
		} else {
			Node<E> x = head;
			while( x.next != null ) {
				x = x.next;
			}
			x.next = newNode;
		}
		
		size++;
	}

	@Override
	public void add(int index, E element) {
	}

	@Override
	public E get(int index) {
		if( size <= index ) {
			throw new IndexOutOfBoundsException( "Index:" + index + ", size:" + size );
		}
		
		Node<E> x = head;
		for( int i = 0; i < index; i++ ) {
			x = x.next;
		}
		
		return x.data;
	}

	@Override
	public E remove(int index) {
		return null;
	}

	@Override
	public void removeAll() {
		for( Node<E> x = head; x != null; ){
			Node<E> next = x.next;
			
			x.data = null;
			x.next = null;
			
			x = next;
		}
		
		head = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}
	
	private static class Node<E>{
		private Node<E> next;
		private E data;

		private Node( E element ) {
			this.data = element;
			this.next = null;
		}
		
		private Node( E element, Node<E> next ) {
			this.data = element;
			this.next = next;
		}
	}
}
