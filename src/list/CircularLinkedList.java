package list;


public class CircularLinkedList<E> implements List<E> {

	private int size = 0;
	private Node<E> tail = null;
	private Node<E> pos = null;


	@Override
	public void add(E element) {
		final Node<E> newNode = new  Node<E>(element);  //객체 참조를 고정시킨다.
		if(tail == null){
			tail = newNode.next = newNode; 
		}
		else{
			newNode.next = tail.next;  //의미적으로 head
			tail.next = newNode;
			tail = tail.next;
		}
		size++;
	}

	@Override
	public void add(int index, E element) {	
		if( size < index || index < 0 ) {
			throw new IndexOutOfBoundsException( "Index:" + index + ", size:" + size );
		}

		if(size == index)
		{
			add(element);
			return;
		}

		if(index == 0){
			final Node<E> newNode = new Node<E>(element,tail.next);
			tail.next = newNode;
		}

		else{
			Node<E> x = tail.next;
			for(int i =0; i < index-1; i++){
				x = x.next; 
			}
			final Node<E> newNode = new Node<E>(element,x.next);
			x.next = newNode;
		}

		size++;
	}

	@Override
	public E get(int index) {
		if( size <= index ) {
			throw new IndexOutOfBoundsException( "Index:" + index + ", size:" + size );
		}
		Node<E> x = tail.next;
		for(int i = 0; i < index; i++){
			x = x.next;
		}

		return x.data;
	}


	@Override
	public E remove(int index) {
		if( size <= index ) {
			throw new IndexOutOfBoundsException( "Index:" + index + ", size:" + size );
		}

		size--;

		if( 0 == index ) {  // head 삭제
			E data = tail.next.data;
			tail.next = tail.next.next;
			return data;
		} 

		Node<E> x = tail.next;

		for( int i = 0; i < index - 1; i++ ) {
			x = x.next;
		}

		E data = x.next.data;

		if( x.next == tail ) {  // tail 삭제
			x.next = tail.next;
			tail = x;
			return data;
		}

		// 중간 삭제
		x.next = x.next.next;
		return data;
	}

	//	@Override
	//	public E remove(int index) {
	//		if( size <= index ) {
	//			throw new IndexOutOfBoundsException( "Index:" + index + ", size:" + size );
	//		}
	//
	//		size--;
	//		//1. head 삭제
	//		if(index == 0){
	//			E data = tail.next.data;
	//			tail.next = tail.next.next;
	//			return data;
	//		}
	//
	//
	//
	//		//2. 중간 삭제
	//
	//		Node<E> x = tail.next;
	//		for(int i = 0; i < index-1; i++){
	//			x = x.next;
	//		}
	//		E data = x.next.data;
	//		x.next = x.next.next;
	//
	//		//3. tail 삭제
	//		if(x.next == tail){
	//			x.next = tail.next;
	//			tail = x;
	//			return data;
	//		}
	//
	//
	//
	//		return data;
	//	}

	@Override
	public void removeAll() {
		Node<E> x = tail.next; // 헤드로 이동
		while(x != tail){ //x는 tail까지 
			Node<E> next = x.next;

			x.next = null;
			x = next;
		}

		tail.next = null;
		tail = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[ size ];
		if( tail == null ) {
			return arr;
		}

		int index = 0;
		Node<E> x = tail.next;
		while( true ) {
			arr[ index++ ] = x.data;
			x = x.next;
			if( x == tail.next ) { // 다시 head로 이동됨
				break;
			}
		}

		return arr;
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
	public Iterator<E> iterator() {
		return new Iterator(){
			private int index = 0;
			private Node<E> x= tail.next;

			@Override
			public boolean hasNext() {
				return index < size;
			}

			@Override
			public Object next() {
				E data = x.data;
				x = x.next;
				index++;
				return data;
			}

		};
	}
}
