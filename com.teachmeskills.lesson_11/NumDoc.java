package com.teachmeskills.lesson_11;

public class NumDoc {
    static String checkNumDoc(String str) {

        String infoNumb = "";

        if (str.length() != 15) {
            infoNumb = "Длина номера документа должна быть 15 символов";
        } else if (!((str.contains("docnum")) || (str.contains("сontract")))) {
            infoNumb = "Номер документа не содержит docnum или сontract";
        } else {
            infoNumb = "";
        }

        return infoNumb;

    }
}

