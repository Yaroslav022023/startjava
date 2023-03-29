package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ArrayTheme {
    public static void main(String[] args) {
        System.out.println("1.Реверс значений массива:");

        int[] intArr = {4, 1, 5, 3, 7, 6, 2};
        int length = intArr.length;
        int reverseIndex = length - 1;

        System.out.println(Arrays.toString(intArr));

        for (int i = 0; i < length - 1; i++) {
            if (i == reverseIndex) {
                break;
            }
            int tmp;
            tmp = intArr[i];
            intArr[i] = intArr[reverseIndex];
            intArr[reverseIndex] = tmp;
            reverseIndex--;
        }
        System.out.println(Arrays.toString(intArr));

        System.out.println("\n2.Вывод произведения элементов массива:");

        intArr = new int[10];
        length = intArr.length;

        for (int i = 0; i < length; i++) {
            intArr[i] = i;
        }

        int result = 1;
        for (int i = 1; i < length - 1; i++) {
            result *= intArr[i];
            System.out.print(intArr[i] + (i < length - 2 ? " * " : " = " + result));
        }

        System.out.println("\nЧисло 0 имеет индекс " + intArr[0] +
                "\nЧисло 9 имеет индекс " + intArr[length - 1]);

        System.out.println("\n3.Удаление элементов массива:");

        float[] floatArr = new float[15];
        length = floatArr.length;

        for (int i = 0; i < length; i++) {
            floatArr[i] = (float) Math.random();
            System.out.printf(floatArr[i] != 0.0f ? "%.3f %s" : "%5.3f %s", floatArr[i], " ");
            System.out.print(i != length / 2 ? "" : "\n");
        }

        System.out.println("\n");
        float middleCellNum = floatArr[length / 2];

        for (int i = 0; i < length; i++) {
            if (middleCellNum < floatArr[i]) {
                floatArr[i] = 0.0f;
            }
            System.out.printf(floatArr[i] != 0.0f ? "%.3f %s" : "%5.3f %s", floatArr[i], " ");
            System.out.print(i != length / 2 ? "" : "\n");
        }

        int amount0 = 0;
        for (float check0 : floatArr) {
            if (check0 == 0.0f) {
                amount0++;
            }
        }
        System.out.println("\nКоличество обнуленных ячеек: " + amount0);

        System.out.println("\n4.Вывод элементов массива лесенкой в обратном порядке:");

        char[] letters = new char[26];
        length = letters.length;

        for (int i = 0; i < length; i++) {
            letters[i] = (char) ('A' + i);
        }

        int amountLettersInLine = length - 2;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j > amountLettersInLine; j--) {
                System.out.print(letters[j]);
            }
            System.out.println();
            amountLettersInLine--;
        }

        System.out.println("\n5.Генерация уникальных чисел:");

        int[] uniqueNums = new int[30];
        length = uniqueNums.length;

        for (int i = 0; i < length; i++) {
            boolean unique = false;
            int randomNum = 0;
            while (!unique) {
                randomNum = (int) (60 + Math.random() * 40);
                for (int checkUnique : uniqueNums) {
                    if (randomNum != checkUnique) {
                        unique = true;
                    } else {
                        unique = false;
                        break;
                    }
                }
            }
            uniqueNums[i] = randomNum;
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1; j++) {
                if (uniqueNums[j] > uniqueNums[j + 1]) {
                    int temp;
                    temp = uniqueNums[j + 1];
                    uniqueNums[j + 1] = uniqueNums[j];
                    uniqueNums[j] = temp;
                }
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.print(i % 10 == 0 ? "\n" + uniqueNums[i] + " " : uniqueNums[i] + " ");
        }

        System.out.println("\n\n6.Копирование не пустых строк:");

        String[] srcStrings = {"    ", "AA", "", "BBB", "CC", "D", "    ", "E", "FF", "G", ""};
        int countNonBlankStrings = 0;

        for (String isEmpty : srcStrings) {
            if (!isEmpty.isBlank()) {
                countNonBlankStrings++;
            }
        }
        System.out.println(Arrays.toString(srcStrings));

        String[] destStrings = new String[countNonBlankStrings];
        int indexStringArr = 0;
        int indexCopyStringArr = 0;

        for (int i = 0; i < destStrings.length; i++) {
            int lenghtInsert = 0;
            boolean insertionAllow = false;
            for (int j = indexStringArr; j < srcStrings.length; j++) {
                if (!srcStrings[j].isBlank()) {
                    lenghtInsert++;
                    insertionAllow = true;
                } else {
                    break;
                }
            }
            if (insertionAllow) {
                System.arraycopy(srcStrings, indexStringArr, destStrings, indexCopyStringArr, lenghtInsert);
                indexCopyStringArr += lenghtInsert;
                indexStringArr += lenghtInsert;
            } else {
                indexStringArr++;
            }
        }
        System.out.println(Arrays.toString(destStrings));
    }
}