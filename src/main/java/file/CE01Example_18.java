package Example.Example_18;

/*
 * 파일 시스템 (File System) 이란?
 * - 파일을 관리하고 제어 할 수 있는 기능을 의미한다. (+ 즉, 파일 시스템을 활용하면 반영구적으로 데이터를
 * 저장하는 것이 가능하다.)
 *
 * 프로그램은 주 기억 장치 (+ Ex. 메모리) 상에 위치하기 때문에 프로그램이 종료되고 나면
 * 프로그램이 사용하고 있던 데이터도 모두 사라지는 단점이 존재한다. (+ 즉, 변수는 주 기억 장치 상에 선언 된다는 것을
 * 알 수 있다.)
 *
 * 따라서 프로그램이 사용하고 있던 데이터를 반영구적으로 저장하기 위해서는 주 기억 장치가 아닌
 * 다른 기억 장치 (+ Ex. 보조 기억 장치) 에 저장 할 필요가 있으며 이때 파일을 활용하는 것이 가능하다. (+ 즉, 파일은
 * 보조 기억 장치 상에 생성 된다는 것을 알 수 있다.)
 *
 * 프로그램은 사용하고 있던 데이터를 파일에 저장하고 읽어들임으로서 데이터를 반영구적으로 유지하는 것이 가능하다.
 * (+ 즉, 프로그램이 실행 될 때 파일에 존재하는 데이터를 읽어들임으로서 이전에 실행 되었을 때 사용한 데이터를 계속
 * 유지한다는 것을 의미한다.)
 *
 * Java 파일 제어 방법
 * - Java 로 제작한 프로그램에서 파일에 데이터를 저장하거나 읽어들이기 위해서는 먼저 스트림 (Stream) 을
 * 생성 할 필요가 있다.
 *
 * 스트림 (Stream) 이란?
 * - 데이터를 이동 시킬 수 있는 통로를 의미하며 프로그램과 파일은 스트림을 통해 데이터를 저장하거나 읽어들이는 것이
 * 가능하다.
 *
 * 단, 스트림은 컴퓨터에서 공통적으로 사용 되는 자원이기 때문에 스트림을 사용했으면 반드시 스트림을
 * 컴퓨터에게 반환해줘야한다. (+ 즉, 스트림을 반환하지 않으면 불필요한 자원을 계속 유지하게 됨으로서
 * 필요 할 때 스트림을 생성하지 못하는 문제를 일으킨다는 것을 알 수 있다.)
 *
 * 스트림은 단방향이기 때문에 프로그램과 파일 간에 데이터를 서로 주고 받기 위해서는 2 개의 스트림이 필요하다 (+ 즉,
 * 프로그램에서 파일에 데이터를 내보내기 위한 스트림 1 개와 파일에서 프로그램으로 데이터를 읽어들이기 위한 스트림 1 개가
 * 필요하다는 것을 알 수 있다.)
 *
 * Java 파일 스트림 관련 클래스
 * - FileReader / FileWriter
 * - FileInputStream / FileOutputStream
 *
 * Reader / Writer 계열 vs Input / Output Stream 계열
 * - Reader / Writer 계열 클래스는 문자열 데이터를 대상으로 동작하는 클래스를 의미한다. (+ 즉, 텍스트 데이터를
 * 입/출력 하고 싶다면 Reader / Writer 계열 클래스를 활용하면 된다.)
 *
 * 반면, Input / Output Stream 계열 클래스는 이진 데이터를 대상을 동작하는 클래스를 의미한다. (+ 즉,
 * 정수와 같은 이진 데이터를 위주로 데이터 입/출력 을 하고 싶다면 Input / Output Stream 계열 클래스를
 * 활용하면 된다.)
 */

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.ByteBuffer;

/**
 * Example 18 (파일 시스템)
 */
public class CE01Example_18 {
	/** 초기화 */
	public static void main(String[] args) {
		File oFileA = new File("P_E01Example_18_01.txt");
		File oFileB = new File("P_E01Example_18_02.bin");
		
		try {
			/*
			 * Buffered 계열 클래스란?
			 * - 버퍼 기반 입/출력을 제어하는 클래스를 의미한다. (+ 즉, Buffered 계열 클래스는
			 * 데이터 입/출력 시 해당 데이터가 바로 목적지로 이동 하는 것이 아니라 내부적으로 존재하는
			 * 버퍼에 보관 된 후 일정 기준 이상으로 데이터가 누적 되면 이동 하는 특징이 존재한다.)
			 *
			 * 데이터 입/출력은 CPU 의 성능과는 큰 연관이 없기 때문에 가능하면 데이터 입/출력 빈도를
			 * 최소화 시키는 것이 좋다. (+ 즉, 데이터 입/출력 횟수가 빈번 할 경우
			 * 내부적으로 병목 현상이 발생 할 수 있다는 것을 의미한다.)
			 */
			BufferedWriter oWriterA = new BufferedWriter(new FileWriter(oFileA));
			BufferedOutputStream oWriterB = new BufferedOutputStream(new FileOutputStream(oFileB));
			
			for(int i = 0; i < 10; ++i) {
				/*
				 * ByteBuffer 클래스란?
				 * - 정수와 같은 이진 데이터와 바이트 배열 간에 변환을 제어하는 클래스를 의미한다. (+ 즉,
				 * ByteBuffer 클래스를 활용하면 정수를 간단하게 바이트 배열로 변환하는 것이 가능하다.)
				 */
				ByteBuffer oBuffer = ByteBuffer.allocate(Integer.BYTES);
				oBuffer.putInt(i + 1);
				
				oWriterA.write("Hello, World!\n");
				oWriterB.write(oBuffer.array(), 0, oBuffer.array().length);
			}
			
			oWriterA.close();
			oWriterB.close();
		} catch(Exception oException) {
			oException.printStackTrace();
		}
		
		/*
		 * try with resource 란?
		 * - 스트림과 같이 공유 자원을 안전하게 제거해주는 try 블럭을 의미한다. (+ 즉,
		 * try with resource 블럭에서 생성 한 자원은 해당 블럭이 종료되면 자동으로 제거 된다는 것을 알 수 있다.)
		 */
		try(BufferedReader oReader = new BufferedReader(new FileReader(oFileA))) {
			System.out.println("=====> 텍스트 <=====");
			
			while(oReader.ready()) {
				String oStr = oReader.readLine();
				System.out.println(oStr);
			}
		} catch(Exception oException) {
			oException.printStackTrace();
		}
		
		try(BufferedInputStream oReader = new BufferedInputStream(new FileInputStream(oFileB))) {
			System.out.println("\n=====> 바이너리 <=====");
			
			int nNumBytes = 0;
			byte[] oBytes = new byte[Integer.BYTES];
			
			/*
			 * read 메서드는 스트림으로부터 데이터를 읽어 들인 후 읽어 들인 데이터의 바이스 수를 반환하는 특징이
			 * 존재한다. (+ 즉, read 메서드의 반환 값이 0 이하라는 것은 더이상 읽어 들 일 데이터가 없다는 것을
			 * 의미한다.)
			 */
			while((nNumBytes = oReader.read(oBytes, 0, oBytes.length)) > 0) {
				ByteBuffer oBuffer = ByteBuffer.wrap(oBytes, 0, nNumBytes);
				System.out.printf("%d, ", oBuffer.getInt());
			}
			
			System.out.println();
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
}
