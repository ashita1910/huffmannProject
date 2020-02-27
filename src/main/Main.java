package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        str = str.toLowerCase();
        ArrayList<String> list = new ArrayList<>(26);
        ArrayList<String> listFinal = new ArrayList<>(26);
        ArrayList<String> finalPrint = new ArrayList<>(26);
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);
            String binaryValue = Integer.toBinaryString(value);
            list.add(binaryValue);
        }
        for (int j = 0; j < list.size(); j++) {
            StringBuilder stringBuilder = new StringBuilder();
            int appendSize = 8 - list.get(j).length();
            for (int k = 0; k < appendSize; k++) {
                stringBuilder.append("0");
            }
            stringBuilder.append(list.get(j));
            listFinal.add(stringBuilder.toString());
        }
        System.out.println("Binary list:");
        System.out.println(listFinal);
        String[] array = {"1010", "100000", "00000", "10110", "010", "110011", "100010", "0001", "0110", "1100001011",
                "11000011", "10111", "110010", "0111", "1001", "100001", "1100000001", "0010", "0011", "1100", "00001",
                "1100000", "110001", "1100001000", "100011", "1100001010"};
        int huffmannLength = 0;
        for (int l = 0; l < str.length(); l++) {
            int ascii = str.charAt(l);
            int index = ascii - 97;
            huffmannLength = huffmannLength + array[index].length();
            finalPrint.add(array[index]);
        }
        System.out.println("Huffmann list:");
        System.out.println(finalPrint);
        System.out.println("Binary list length: ");
        float binaryListLength = listFinal.size() * 8;
        System.out.println((int) binaryListLength);
        System.out.println("Huffmann list length: ");
        System.out.println(huffmannLength);
        System.out.print("Compression Ratio: ");
        float compressionRatio = huffmannLength / binaryListLength;
        System.out.println(compressionRatio);
        scanner.close();
    }
}
