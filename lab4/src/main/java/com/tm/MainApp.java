package com.tm;

import java.io.IOException;

/**
 * Created by tudor.maier on 28/11/2017.
 */
public class MainApp {

    private static String fileName = "/tmp/input4.txt";
    private static String outputFile = "/tmp/lab4Output_001.txt";

    public static void main (String[] args) throws InterruptedException {
        final ProducerConsumer producerConsumer = new ProducerConsumer(fileName, outputFile);

        Thread producerThread = new Thread(() -> {
            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        });

        Thread consumerThread = new Thread(() -> {
            try {
                producerConsumer.consume();
            } catch (InterruptedException | IOException e) {
                System.out.println(e.getMessage());
            }
        });

        // Start both threads
        producerThread.start();
        consumerThread.start();

        // t1 finishes before t2
        producerThread.join();
        consumerThread.join();
    }
}
