import java.io.*;

/**
 * File: Lab11Prob01.java
 * Class: CSCI 1302
 * Author: Brian Abbott
 * Created on: 4/24/26
 * Last modified: 4/24/26
 * Description: Reads binary data from people.dat, displays contents
 *              to the console, and writes an exact copy to people-copy.dat.
 */

public class Lab11Prob01 {

    public static void main(String[] args) {
        // Create File objects for input and output
        File inputFile = new File("src/people.dat");
        File outputFile = new File("src/people-copy.dat");

        // try with resources - open both input and output streams
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(inputFile));
             DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(outputFile))) {

            // loop until EOFException
            while (true) {
                // Read each field in the correct order
                int age = inputStream.readInt();
                String name = inputStream.readUTF();
                String address = inputStream.readUTF();
                int zip = inputStream.readInt();
                double salary = inputStream.readDouble();

                // print the record to the console with salary formatted to 2 decimal places
                System.out.printf("%d %s %s %d %.2f%n", age, name, address, zip, salary);

                // write the record to the copy file in binary format
                outputStream.writeInt(age);
                outputStream.writeUTF(name);
                outputStream.writeUTF(address);
                outputStream.writeInt(zip);
                outputStream.writeDouble(salary);
            }
        } catch (EOFException e) {
            // End of file reached, processing finished
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
