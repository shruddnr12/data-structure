package listtest;

import list.Iterator;
import list.LinkedList;
import list.List;

public class LinkedListTest {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();

		// add 연산
		list.add( 11 );
		list.add( 22 );
		list.add( 22 );
		list.add( 33 );
		list.add( 44 );
		list.add( 44 );
		
		// size 연산
		int count = list.size();
		System.out.println( "리스트 크기:" + count );
		
		// get 연산 테스트
		for( int i= 0; i < count; i++ ) {
			System.out.println( i + "번째 항목: " + list.get( i ) );
		}
	
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			int i = it.next();
			System.out.println(i + "\t");
		}
		System.out.print("\n");
		
		// add(index, element) 테스트
		System.out.println( list );		
		list.add( 0, 1 );
		System.out.println( list );		
		list.add( 1, 2 );
		System.out.println( list );		
		list.add( 2, 3 );
		System.out.println( list );		
		list.add( 3, 4 );
		System.out.println( list );		
		list.add( 10, 55 );
		System.out.println( list );		
		list.add( 66 );
		System.out.println( list );
		
		// remove( index ) 테스트
		System.out.println( "삭제 항목: " + list.remove( 0 )  );
		System.out.println( list );
		System.out.println( "삭제 항목: " + list.remove( 1 )  );
		System.out.println( list );
		System.out.println( "삭제 항목: " + list.remove( list.size() - 1  ) );
		System.out.println( list );
		
		// removeAll 테스트
		list.removeAll();
		System.out.println( list );
		
		// 예외 테스트
		try {
			list.get( 0 );
		} catch( IndexOutOfBoundsException e ) {
			System.out.println( "예외발생:" + e );
		}
	}
}
