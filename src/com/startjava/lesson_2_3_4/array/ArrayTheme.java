package com.startjava.lesson_2_3_4.array;

import java.util.Arrays;

public class ArrayTheme {
    public static void main(String[] args) {
        System.out.println("1.Реверс значений массива:");

        int[] intArr = {4, 1, 5, 3, 7, 6, 2};
        int[] intArrReverse = new int[intArr.length];
        int indexIntArrReverse = 0;

        for (int i = intArr.length - 1; i >= 0; i--) {
            intArrReverse[indexIntArrReverse] = intArr[i];
            indexIntArrReverse++;
        }

        for (int intArrShow : intArr) {
            System.out.print(intArrShow + " ");
        }

        System.out.println();

        for (int intArrReverseShow : intArrReverse) {
            System.out.print(intArrReverseShow + " ");
        }

        System.out.println("\n\n2.Вывод произведения элементов массива:");

        int[] intArr2 = new int[10];
        int fillingIntArr2 = 0;

        for (int i = 0; i < intArr2.length; i++) {
            intArr2[i] = fillingIntArr2;
            fillingIntArr2++;
        }

        int calculateIntArr2 = 1;

        for (int i = 1; i < intArr2.length - 1; i++) {
            calculateIntArr2 *= intArr2[i];
            System.out.print(i < intArr2.length - 2 ? intArr2[i] + " * " : intArr2[i] + " = " + calculateIntArr2);
        }

        System.out.println("\nЧисло 0 имеет индекс " + intArr2[0] +
                "\nЧисло 9 имеет индекс " + intArr2[intArr2.length - 1]);

        System.out.println("\n3.Удаление элементов массива:");

        float[] floatArr = new float[15];
        ArrayTheme arrayTheme = new ArrayTheme();

        for (int i = 0; i < floatArr.length; i++) {
            floatArr[i] = (float) Math.random();
            arrayTheme.outputArray(floatArr, i);
        }

        System.out.println("\n");
        float middleNumFloatArr = floatArr[floatArr.length / 2];

        for (int i = 0; i < floatArr.length; i++) {
            if (middleNumFloatArr < floatArr[i]) {
                floatArr[i] = 0.0f;
            }
            arrayTheme.outputArray(floatArr, i);
        }
        int amount0 = 0;
        for (float check0 : floatArr) {
            if (check0 == 0.0f) {
                amount0++;
            }
        }
        System.out.println("\nКоличество обнуленных ячеек: " + amount0);

        System.out.println("\n4.Вывод элементов массива лесенкой в обратном порядке:");

        char[] charArr = new char[26];
        char letter = 65;

        for (int i = 0; i < charArr.length; i++) {
            charArr[i] = letter;
            letter++;
        }

        int amountLettersInLine = charArr.length - 2;
        for (int i = 0; i < charArr.length; i++) {
            for (int j = charArr.length - 1; j > amountLettersInLine; j--) {
                System.out.print(charArr[j]);
            }
            System.out.println();
            amountLettersInLine--;
        }

        System.out.println("\n5.Генерация уникальных чисел:");

        int[] intArr3 = new int[30];

        for (int i = 0; i < intArr3.length; i++) {
            boolean equalSameNum = false;
            int randomNum = 0;
            while (!equalSameNum) {
                randomNum = (int) (60 + Math.random() * 40);
                for (int equals : intArr3) {
                    if (randomNum != equals) {
                        equalSameNum = true;
                    } else {
                        equalSameNum = false;
                        break;
                    }
                }
            }
            intArr3[i] = randomNum;
        }

        for (int i = 0; i < intArr3.length; i++) {
            for (int j = 0; j < intArr3.length - 1; j++) {
                int temp;
                if (intArr3[j] > intArr3[j + 1]) {
                    temp = intArr3[j + 1];
                    intArr3[j + 1] = intArr3[j];
                    intArr3[j] = temp;
                }
            }
        }

        for (int i = 0; i < intArr3.length; i++) {
            System.out.print(i % 10 == 0 ? "\n" + intArr3[i] + " " : intArr3[i] + " ");
        }

        System.out.println("\n\n6.Копирование не пустых строк:");

        String[] stringArr = {"    ", "AA", "", "BBB", "CC", "D", "    ", "E", "FF", "G", ""};
        int lengthStringArr = 0;

        for (String isEmpty : stringArr) {
            if (!isEmpty.isBlank()) {
                lengthStringArr++;
            }
        }

        String[] copyStringArr = new String[lengthStringArr];
        int indexStringArr = 0;
        int indexCopyStringArr = 0;

        for (int i = 0; i < copyStringArr.length; i++) {
            int lenghtInsert = 0;
            boolean insertionAllow = false;
            for (int j = indexStringArr; j < stringArr.length; j++) {
                if (!stringArr[j].isBlank()) {
                    lenghtInsert++;
                    insertionAllow = true;
                } else {
                    break;
                }
            }
            if (insertionAllow) {
                System.arraycopy(stringArr, indexStringArr, copyStringArr, indexCopyStringArr, lenghtInsert);
                indexCopyStringArr += lenghtInsert;
                indexStringArr += lenghtInsert;
            } else {
                indexStringArr++;
            }
        }
        System.out.println(Arrays.toString(copyStringArr));
    }

    private void outputArray(float[] array, int i) {
        System.out.printf(array[i] != 0.0f ? "%.3f %s" : "%5.1f %s", array[i], " ");
        System.out.print(i != array.length / 2 ? "" : "\n");
    }
}