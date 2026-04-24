import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * File: Lab11Prob02.java
 * Class: CSCI 1302
 * Author: Brian Abbott
 * Created on: 4/24/26
 * Last modified: 4/24/26
 * Description: Reads binary data from people.dat into Person objects,
 *              sorts by salary descending, and writes sorted data to
 *              people-salary-sorted.dat.
 */

public class Lab11Prob02 {

    public static void main(String[] args) {
        // Create File objects for input and output
        File inputFile = new File("src/people.dat");
        File outputFile = new File("src/people-salary-sorted.dat");

        // ArrayList to store Person objects
        ArrayList<Person> people = new ArrayList<>();

        // Read all records from the binary input file
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(inputFile))) {

            // loop until EOFException
            while (true) {
                // Read each field in the correct order
                int age = inputStream.readInt();
                String name = inputStream.readUTF();
                String address = inputStream.readUTF();
                int zip = inputStream.readInt();
                double salary = inputStream.readDouble();

                // Create a Person and add to the list
                Person person = new Person(age, name, address, zip, salary);
                people.add(person);
            }
        } catch (EOFException e) {
            // End of file reached, processing finished
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort the ArrayList by salary in descending order
        Collections.sort(people);

        // Write sorted Person data to output file using toString()
        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream(outputFile))) {
            for (Person person : people) {
                outputStream.writeUTF(person.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
