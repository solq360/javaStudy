package org.solq.lesson13.demo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Console {

	public static void main(String[] args) {
		
		try(BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(System.in, "utf-8"));){
			
			String command = null;
			String retExec = null;
			while( (command = bufferedReader.readLine()) !=null){
				
				
				if("exit".equals( command)){
					System.out.println("ÍË³ö³ÌÐò");
					break;
				} 
				 Process  process=	Runtime.getRuntime().exec(command);
				 InputStream errorIs =  process.getErrorStream();
				System.out.println("exec code : "+ process.waitFor());
				 if(errorIs!=null){
					 System.out.println("error ");
				 }
				try (BufferedReader runtimeReader  = new BufferedReader(new InputStreamReader(process.getInputStream()));){
					while( (retExec = runtimeReader.readLine()) !=null){
						System.out.println(retExec);
					}
				}catch (Exception e) {
					e.printStackTrace();
		 		}
  			}
		} catch (Exception e) {
			e.printStackTrace();
 		}
	}
}
