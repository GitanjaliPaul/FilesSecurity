package com.security.utils;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


public  class FileReadWrite {

	public static void main(String[] args) {
    
		try {
			File myobj = new File("C:\\Users\\Dell\\filef2.txt");
			if (myobj.createNewFile()) {
				System.out.println("file created" + myobj.getName());
			} else {
				System.out.println("file already exists");
				if (myobj.exists()) {
					System.out.println("File name is" + " " + myobj.getName());
					System.out.println("Absolute path" + " " + myobj.getAbsolutePath());
					System.out.println("Writeable" + " " + myobj.canWrite());
					System.out.println("Readable" + " " + myobj.canRead());
					System.out.println("File size in bytes is" + " " + myobj.length());
                                                                   
                                  
				} else {
					System.out.println("File doesnot exist!!!");
				}

			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
