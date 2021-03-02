package com.company;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Animal> animalList = new ArrayList<>();

        String[] animalTypes = {
                "Dog",
                "Cat",
                "Donkey",
                "Parrot",
                "Horse",
                "Fox",
                "Lion",
                "Tiger",
                "Lizard",
                "Bear",
        };

        try {
            BufferedReader br = new BufferedReader(new FileReader("animals.csv"));

            String line = br.readLine();
            String[] splitLine;
            Animal animal = new Animal();
            
            while (line != null) {
                line = br.readLine();
                splitLine = line.split(";");
                animal.id = Integer.parseInt(splitLine[0]);
                animal.type = Integer.parseInt(splitLine[1]);
                animal.name = splitLine[2];
                animal.age = Integer.parseInt(splitLine[3]);
                animal.gender = splitLine[4];
                animal.aggressive = splitLine[5];
                animal.friendly = splitLine[6];

                animalList.add(animal);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("0");
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("ukol1.txt"));

            for (int i = 0; i < animalList.size(); i++) {
                if (animalList.get(i).aggressive.equals("Y")) {
                    bw.write(animalList.get(i).name);
                    bw.write(";");
                    bw.write(animalTypes[animalList.get(i).id]);
                    bw.write(";");
                    bw.write(animalList.get(i).gender);
                    bw.newLine();
                }
            }

            bw.close();
        } catch (Exception e) {
            System.out.println("1");
        }
    }
}