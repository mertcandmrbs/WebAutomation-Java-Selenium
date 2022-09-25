package testinium.network;

import java.lang.Thread;  
import java.io.*;

public class TestSleepMethod1 extends App {
	public void run(){    
		  for(int i=1;i<5;i++){   
		  // the thread will sleep for the 500 milli seconds   
		    try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}    
		    System.out.println(i);
		    }
		  }

	public static void main(String[] args) {
		TestSleepMethod1 t1=new TestSleepMethod1();
		

	}

}
