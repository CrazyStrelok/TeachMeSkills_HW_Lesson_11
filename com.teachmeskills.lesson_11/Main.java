package com.teachmeskills.lesson_11;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите путь к файлу");
        String path = scanner.next();

        String data;
        String info;
        String pathOutValidFile = "outValid.txt";
        String pathOutNotValidFile = "outNotValid.txt";

        try (FileInputStream inFile = new FileInputStream(path);
             FileOutputStream outValidFile = new FileOutputStream(pathOutValidFile);
             FileOutputStream outNotValidFile = new FileOutputStream(pathOutNotValidFile);
             BufferedReader infileBuff = new BufferedReader(new InputStreamReader(inFile));
             BufferedWriter outFileBuff = new BufferedWriter(new OutputStreamWriter(outValidFile));
             BufferedWriter outFileBuff2 = new BufferedWriter(new OutputStreamWriter(outNotValidFile))) {

            while ((data = infileBuff.readLine()) != null) {
                info = NumDoc.checkNumDoc(data);
                if (info.isEmpty()) {
                    outFileBuff.write(data);
                    outFileBuff.newLine();
                    outFileBuff.flush();
                } else {
                    outFileBuff2.write(data + " - " + info);
                    outFileBuff2.newLine();
                    outFileBuff2.flush();
                }
                System.out.println(data);
            }

            System.out.println("Success");


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

}