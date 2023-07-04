package Java.Day2.FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;

public class FileIO {
  

  public static void main(String[] args) {
    
    // relative path is fine are within the same project - otherwise use full path
    String inputFile = "C:\\SkillStorm Training\\Java\\Day2\\FileIO\\fileInput.txt";    // make sure to escape backslashes on Windows
    String outFile = "Java\\Day2\\FileIO\\fileOutput.txt";


    /*
     * TRY-CATCH
     *    put some "risky" code in the try block
     *    handle those errors in the catch block
     *      can only catch one at a time, but you can do multiple catch blocks 
     * 
     * 
     */

    try {

      /*
       * FILE INPUT AND OUT STREAMS
       *    have to work with streams to have your data flow between files
       * 
       */

      InputStream inputStream = new FileInputStream(inputFile);    // creates a new input stream that can read from inputFile
      OutputStream outputStream = new FileOutputStream(outFile);   // creates a new output stream that can write to outFile
    

      // reading in data from a file
      int byteData;   // data is read in bytes
      
      // loops until end of file
      while ((byteData = inputStream.read()) != -1) {
        System.out.println(byteData);
        outputStream.write(byteData);   // write to output, will overwrite file
      }

      inputStream.close();
      outputStream.close();


    } catch (IOException ioException) {
        System.out.println("Error with opening or closing files");
        ioException.printStackTrace();
    } catch (Exception e) {
        System.out.println("Something else went wrong!");
        e.printStackTrace();
      
    }
    
    /*
     * CLASS LOADER and RESOURCE STREAM
     *    works similarly to FileInputStream
     *    the difference:
     *      getResourceAsStream() grabs a static resource from your classpath - ie. within your project
     * 
     * 
     *    
     *    very useful for apps not running on local machine 
     * 
     */

    String resourcePath = "Java\\Day2\\FileIO\\fileInput.txt";    // needs to be relative path for getResourceAsStream()
    
    try {

      // grabs a static resource from our project and converts it into a stream
      InputStream inputStream = FileIO.class.getClassLoader().getResourceAsStream(resourcePath);

      // checking if we found the file
      if(inputStream != null) {

        int byteData;
        
        // loops until end of file
      while ((byteData = inputStream.read()) != -1) {       

        // converting each int into character        
        System.out.println((char) byteData);        
      }


      } else {
        System.out.println("Resource was not found!");
      }

      inputStream.close();

    } catch (Exception e) {
      e.printStackTrace();
    }


    /*
     * TRY WITH RESOURCES
     *    still a try-catch block
     * 
     *    we pass in something that needs to be opened (eg a file stream)
     *    and it will auto close it for us
     *    
     *        must implement the AutoCloseable interface 
     */

     try (FileInputStream fileInput = new FileInputStream(inputFile)) {

      int byteData;

      while ((byteData = fileInput.read()) != -1) {       

        // converting each int into character        
        System.out.println((char) byteData);

        
      }

      // no longer any need to close the input stream

     } catch (Exception e) {
      e.printStackTrace();
    }
    

  }

}
