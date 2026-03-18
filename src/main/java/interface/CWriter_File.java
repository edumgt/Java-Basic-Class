package Example.Example_04;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * 파일 출력자
 */
public class CWriter_File implements IReleasable, IWriter {
	/*
	 * BufferedWriter 클래스란?
	 * - 데이터를 스트림에 출력하는 역할을 수행하는 클래스를 의미한다. (+ 즉, BufferedWriter 클래스를 활용하면
	 * 데이터를 파일 등에 기록하는 것이 가능하다.)
	 */
	private BufferedWriter m_oWriter = null;
	
	/** 생성자 */
	public CWriter_File(String a_oPath_File) {
		try {
			/*
			 * File 클래스란?
			 * - 파일을 제어하기 위한 다양한 기능을 제공하는 클래스를 의미한다. (+ 즉, File 클래스를 활용하면
			 * 특정 파일의 존재 여부를 검사하는 등의 명령문을 작성하는 것이 가능하다.)
			 *
			 * FileWriter 클래스란?
			 * - 파일에 데이터를 기록하기 위한 다양한 기능을 제공하는 클래스를 의미한다. (+ 즉, FileWriter 클래스를
			 * 활용하면 데이터를 파일에 반영구적으로 저장하는 것이 가능하다.)
			 */
			File oFile = new File(a_oPath_File);
			FileWriter oWriter_File = new FileWriter(oFile);
			
			m_oWriter = new BufferedWriter(oWriter_File);
		} catch(Exception a_oException) {
			a_oException.printStackTrace();
		}
	}
	
	/** 제거 한다 */
	@Override
	public void release() {
		try {
			/*
			 * close 메서드는 스트림을 제거하는 역할을 수행한다. (+ 즉, close 메서드를 호출하고 나면 더이상 스트림에
			 * 데이터를 출력하거나 읽어들이는 것이 불가능하다.)
			 */
			m_oWriter.close();
		} catch(Exception oException) {
			oException.printStackTrace();
		}
	}
	
	/** 문자열을 출력한다 */
	@Override
	public void writeStr(String a_oStr) {
		try {
			/*
			 * write 메서드는 스트림에 데이터를 출력하는 역할을 수행한다. (+ 즉, write 메서드를 활용하면 파일 등에
			 * 데이터를 기록하는 것이 가능하다.)
			 */
			m_oWriter.write(a_oStr);
			m_oWriter.newLine();
			
			/*
			 * flush 메서드란?
			 * - 입/출력 버퍼를 비우는 역할을 수행한다. (+ 즉, flush 메서드를 활용하면 입/출력 버퍼에 존재하는
			 * 데이터를 즉시 목적지로 이동 시키는 것이 가능하다.)
			 */
			m_oWriter.flush();
		} catch(Exception a_oException) {
			a_oException.printStackTrace();
		}
	}
}
