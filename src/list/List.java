package list;

public interface List<E> { // extends Iterable<E> {  // Iterable<E>은 lang 패키지에 있음으로 import하지 않아도 가능하다. 
	void add( E element );
	void add( int index, E element );
	E get( int index );
	E remove( int index );
	void removeAll();
	int size();
	Object[] toArray();
	Iterator<E> iterator();
}
