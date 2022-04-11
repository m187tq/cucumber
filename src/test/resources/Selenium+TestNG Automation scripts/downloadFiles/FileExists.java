package downloadFiles;

import java.io.File;

public class FileExists {

	public static void main(String[] args) {
		
		String path=System.getProperty("user.dir")+"/test.pdf";   // File path stored in a varaible
		
		File f = new File(path);   // Create File object and pass file path as a parameter
		
		if(f.exists())  //checking file exists or not, if f.exists() returns true means file exists
		{ 
		    System.out.println("File location: " +path.toString());
		    System.out.println("File exists");
		 }
		else
		{
			System.out.println("File NOT exist"); // if not exists else block will execute
		}
	}
}
