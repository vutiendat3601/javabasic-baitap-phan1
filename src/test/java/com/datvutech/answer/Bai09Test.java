package com.datvutech.answer;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class Bai09Test {
    private static FileWriter fWriter;

    @BeforeAll
    public static void setUp() throws IOException {
        fWriter = new FileWriter("o.txt");
    }

    @AfterAll
    public static void finish() throws IOException {
        fWriter.close();
    }

    @CsvFileSource(files = "src/test/resources/bai09.csv", numLinesToSkip = 1)
    @ParameterizedTest
    public void testCalElectricExpense(int oldIndex, int newIndex, double expected) {
        double actual = Bai09.calElectricExpense(oldIndex, newIndex);
        // try {
        //     fWriter.append(oldIndex + "," + newIndex + "," + actual+"\n");
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        Assertions.assertEquals(expected, actual);
    }

}
