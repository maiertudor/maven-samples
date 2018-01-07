package com.tm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by tudor.maier on 28/11/2017.
 */
public class ProducerConsumer {

    private LinkedList<Person> personList;
    private String fileName;
    private int capacity = 5;
    private String outputFile;

    public ProducerConsumer(String fileName, String outputFile) {
        this.fileName = fileName;
        personList = new LinkedList<>();
        this.outputFile = outputFile;
    }

    public void produce() throws InterruptedException {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
            String readObject;
            while((readObject = readFile(scanner)) != null) {
                synchronized (this) {

                    while(personList.size() > capacity){
                        wait();
                    }

                    Person person = PersonValidator.convertPersonFromRaw(readObject);
//                    System.out.println("Raw person: " + person.toString());
                    if(PersonValidator.isPersonValid(person)){
                        personList.add(person);
//                        System.out.println("Valid person: " + person.toString());
                    }

                    notify();

                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private String readFile(Scanner scan) {
        scan.useDelimiter(Pattern.compile("%"));
        if (scan.hasNext()) {
            return scan.next();
        }
        return null;
    }

    public void consume() throws InterruptedException, IOException {

        FileWriter fileWriter = null;
        while(true) {
            synchronized (this) {

                while(personList.size() == 0) {
                    wait();
                }

                Person person = personList.removeFirst();
//                Files.write(Paths.get("/tmp/lab4Output.txt"), person.toString().getBytes(), StandardOpenOption.APPEND);
                try {
                    fileWriter = new FileWriter(outputFile, true);
                    fileWriter.write(person.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    fileWriter.close();
                }
//                System.out.println("Removed person: " + person.toString());
                notify();

            }
        }

    }
}
