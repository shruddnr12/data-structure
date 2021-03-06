package listtest;

import java.util.Arrays;

import list.ArrayList;
import list.Iterator;
import list.List;

public class ArrayListTest {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
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
		
		// get 연산 테스트  //for문 안에 get() 함수 또한 for문을 호출하므로 n제곱의 시간복잡도가 된다.
		for( int i= 0; i < count; i++ ) {
			System.out.println( i + "번째 항목: " + list.get( i ) );
		}
		
//		foreach문을 사용하기 위한 컬렉션 객체는 java.lang.iterable 인터페이스를 구현 해야 한다. 
//		for(Integer i : list){   //Iterable 인터페이스 상속하여 구현해야 가능.
//			System.out.println( i + "번째 항목: " + list.get( i ) );	
//		}

		// Iterator 반복자를 통한 list 순회 
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			int i = it.next();//auto boxing
			System.out.println(i);
		}
		
		
		// add(index, element) 테스트
		System.out.println( Arrays.toString(list.toArray()) );		
		list.add( 0, 1 );
		System.out.println( Arrays.toString(list.toArray()) );		
		list.add( 1, 2 );
		System.out.println( Arrays.toString(list.toArray()) );		
		list.add( 2, 3 );
		System.out.println( Arrays.toString(list.toArray()) );		
		list.add( 3, 4 );
		System.out.println( Arrays.toString(list.toArray()) );		
		list.add( 10, 55 );
		System.out.println( Arrays.toString(list.toArray()) );		
		list.add( 66 );
		System.out.println( Arrays.toString(list.toArray()) );
		
		// remove( index ) 테스트
		System.out.println( "삭제 항목: " + list.remove( 0 ) );
		System.out.println( "삭제 항목: " + list.remove( 1 ) );
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