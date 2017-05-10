package list;

public class LinkedList<E> implements List<E> {
	
	private int size = 0;
	private Node<E> tail = null;
	private Node<E> head = null;
	
	@Override
	public void add(E element) {
		final Node<E> newNode = new Node<E>( element );
		
		if( head == null ) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}

		size++;
	}

	@Override
	public void add(int index, E element) {
		if( size < index || index < 0 ) {
			throw new IndexOutOfBoundsException( "Index:" + index + ", size:" + size );
		}
		
		if( index == 0 ) {   // head 삽입 
			
			final Node<E> newNode = new Node<E>( element, head );
			head = newNode;
			
		} else if( size == index ){  //  tail 삽입 
			
			add( element );
			
		} else {  // 중간 삽입
			
			Node<E> x = head;
			for( int i = 0; i < index - 1; i++ ) {
				x = x.next;
			}
		
			final Node<E> newNode = new Node<E>( element, x.next );
			x.next = newNode;
		}
		
		size++;
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

	@Override
	public String toString() {
		String s = "[";
		int index = 0;
		Node<E> x = head;
		
		while( x != null ) {
			if( index++ > 0 ) {
				s += ", ";
			}
			s += x.data;
			x = x.next;
		}
		s += "]";
		
		return s;
	}
	
	
}
