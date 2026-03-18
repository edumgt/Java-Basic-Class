package Example.Example_08;

/*
 * 리플렉션 (Reflection) 이란?
 * - 클래스의 정보를 기반으로 대상을 제어 할 수 있는 기능을 의미한다. (+ 즉, 리플렉션을 활용하면
 * 특정 객체의 멤버 존재 여부를 검사하는 등의 명령문을 작성하는 것이 가능하다.)
 *
 * Java 의 모든 클래스는 리플렉션을 지원하며 해당 기능을 통해 객체를 동적으로 제어하는 것이 가능하다.
 *
 * Ex)
 * class CSomeClass {
 * 		private int m_nVal = 0;
 * }
 *
 * CSomeClass oSomeObj = new CSomeClass();
 * Class<CSomeClass> oCls_SomeClass = (Class<CSomeClass>)oSomeObj.getClass();
 *
 * Field oField = oCls_SomeClass.getDeclaredField("m_nVal");
 * oField.setAccessible(true);
 * oField.set(oSomeObj, 10);
 *
 * 위와 같이 Java 의 모든 클래스는 해당 클래스의 정보를 지니고 있는 Class 객체를 반환하기 위한 getClass 메서드를
 * 지원한다.
 *
 * 따라서 Class 객체를 통해 특정 클래스의 변수 or 메서드 등의 정보를 가져와서 해당 멤버를 제어하는 것이 가능하다.
 * (+ Ex. 메서드 호출 등등...)
 *
 * 단, 특정 데이터를 동적으로 제어하는 것은 해당 데이터를 직접 제어하는 것에 비해 성능이 저하 될 수 있으며
 * 이는 특정 데이터를 동적으로 제어함으로서 C# 컴파일러 최적화가 이루어지지 않기 때문이다. (+ 즉, 동적으로 특정 대상을
 * 제어하는 것은 런타임에 관련 명령문이 동작하기 때문에 최적화 된 명령문을 만들어내지 못한다는 것을 알 수 있다.)
 */

import Example.Example_06.CCharacter;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Example 8
 */
public class CE01Example_08 {
	/** 초기화 */
	public static void main(String[] args) {
		CCharacter oCharacter = new CCharacter(1, 5, 10);
		
		/*
		 * 아래와 같이 getClass 메서드를 활용하면 특정 클래스의 정보를 지니고 있는 Class 객체를 가져오는 것이
		 * 가능하다.
		 */
		Class<CCharacter> oCls = (Class<CCharacter>)oCharacter.getClass();
		
		try {
			/*
			 * Class 클래스에 존재하는 get 계열 메서드를 활용하면 변수 or 메서드 등의 정보를 가져오는 것이 가능하다.
			 */
			Field oField_Lv = oCls.getDeclaredField("m_nLv");
			
			/*
			 * Field 객체를 활용하면 특정 객체가 지니고 있는 멤버 변수의 데이터를 변경하거나 가져오는 것이 가능하다.
			 *
			 * 단, 리플렉션 객체를 통해 private 수준으로 보호 되고 있는 멤버를 제어하기 위해서는
			 * setAccessible 메서드를 활용해야한다. (+ 즉, setAccessible 메서드를 통해 private 멤버에 접근을
			 * 허용하는 것이 가능하다.)
			 */
			oField_Lv.setAccessible(true);
			
			oField_Lv.set(oCharacter, 10);
			Method oMethod_toString = oCls.getDeclaredMethod("toString");
			
			System.out.println("=====> 캐릭터 <=====");
			System.out.println(oMethod_toString.invoke(oCharacter));
			
			Field[] oFields = oCls.getDeclaredFields();
			Method[] oMethods = oCls.getDeclaredMethods();
			
			System.out.println("\n=====> 필드 정보 <=====");
			
			for(int i = 0; i < oFields.length; ++i) {
				System.out.println(oFields[i]);
			}
			
			System.out.println("\n=====> 메서드 정보 <=====");
			
			for(int i = 0; i < oMethods.length; ++i) {
				System.out.println(oMethods[i]);
			}
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
}
