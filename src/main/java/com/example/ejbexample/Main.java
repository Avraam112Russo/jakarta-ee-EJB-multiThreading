package com.example.ejbexample;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.submit(() -> {
                URLConnection urlConnection;
                try {
                    urlConnection = new URL("http://localhost:8080/Ejb-example-1.0-SNAPSHOT/counter").openConnection();
                    Scanner scanner = new Scanner(urlConnection.getInputStream());
                    while (scanner.hasNext()){
                        System.out.println(scanner.next());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }finally {
                    executorService.shutdown();
                }
                });
        }

    }
}
