package sample;

import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.Random;


import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * Created by Brik25 on 16.04.2017.
 */
public class SpeedQuickSort {


    int[] A = new int[10];


    //Пьяный соня
    private void pause(int dSec) {
        try {
            Thread.sleep(dSec * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //Рандомизация
    public SpeedQuickSort(int length) {
        Random rand = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = rand.nextInt(100);
        }

    }

    //Заполняем первую колнку случайными числами в потоке
    public void OneDisp(Rectangle[] rect, Text[] text) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < A.length; i++) {
                    rect[i].setFill(Color.RED);
                    text[i].setText(String.valueOf(A[i]));
                    rect[i].setFill(Color.GREEN);
                }
                pause(5);
                for (int i = 0; i < A.length; i++) {
                    rect[i].setFill(Color.YELLOW);
                    text[i].setText(String.valueOf(A[i]));

                }
            }
        }).start();
    }



    void nextOne(int low, int high, Rectangle[] rect, Text[] text, Rectangle[] rect_2, Text[] text_2) {

        int i = low;
        int j = high;
        int indexOP = low + (high - low) / 2;
        int x = A[indexOP];
        //выделение опорного элемента
        rect_2[indexOP].setVisible(true);
        rect_2[indexOP].setFill(Color.ROSYBROWN);
        text_2[indexOP].setVisible(true);
        text_2[indexOP].setText(String.valueOf(A[indexOP]));
        pause(10);

        do {
            while (A[i] < x) i++;
            while (A[j] > x) j--;
            if (i <= j) {
                //выделение элементов для перестановки
                rect_2[i].setVisible(true);
                rect_2[i].setFill(Color.RED);
                text_2[i].setVisible(true);
                text_2[i].setText(String.valueOf(A[i]));

                rect_2[j].setVisible(true);
                rect_2[j].setFill(Color.RED);
                text_2[j].setVisible(true);
                text_2[j].setText(String.valueOf(A[j]));
                pause(10);

                //перестановка эл.
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;

                //показывается как переставлены эл.
                rect_2[i].setFill(Color.GREEN);
                text_2[i].setText(String.valueOf(A[i]));

                rect_2[j].setFill(Color.GREEN);
                text_2[j].setText(String.valueOf(A[j]));
                pause(10);

                //смещение значений в основной массив
                text[i].setText(String.valueOf(A[i]));
                rect[i].setFill(Color.GREEN);
                rect_2[i].setVisible(false);
                text_2[i].setVisible(false);
                text[j].setText(String.valueOf(A[j]));
                rect[j].setFill(Color.GREEN);
                rect_2[j].setVisible(false);
                text_2[j].setVisible(false);
                pause(10);

                rect[i].setFill(Color.GRAY);
                rect[j].setFill(Color.GRAY);
                pause(10);


                i++;
                j--;
            }
        } while (i <= j);

        if (low < j) nextOne(low, j, rect, text, rect_2, text_2);
        if (i < high) nextOne(i, high, rect, text, rect_2, text_2);

    }

    public void TwoDisp(Rectangle[] rect, Text[] text, Rectangle[] rect_2, Text[] text_2) {

        Thread aSortdisplayo = new Thread(new Runnable() {
            @Override
            public void run() {
                nextOne(0, A.length - 1, rect, text, rect_2, text_2);
            }
        });

        aSortdisplayo.start();

        for (int k = 0; k < A.length; k++) {
            rect_2[k].setVisible(false);
            text_2[k].setVisible(false);
        }
    }
    void nextTwo(int low, int high, Rectangle[] rect, Text[] text, Rectangle[] rect_2, Text[] text_2) {

        int i = low;
        int j = high;
        int indexOP = low + (high - low) / 2;
        int x = A[indexOP];
        //выделение опорного элемента
        rect_2[indexOP].setVisible(true);
        rect_2[indexOP].setFill(Color.ROSYBROWN);
        text_2[indexOP].setVisible(true);
        text_2[indexOP].setText(String.valueOf(A[indexOP]));
        pause(10);

        do {
            while (A[i] > x) i++;
            while (A[j] < x) j--;
            if (i <= j) {
                //выделение элементов для перестановки
                rect_2[i].setVisible(true);
                rect_2[i].setFill(Color.RED);
                text_2[i].setVisible(true);
                text_2[i].setText(String.valueOf(A[i]));

                rect_2[j].setVisible(true);
                rect_2[j].setFill(Color.RED);
                text_2[j].setVisible(true);
                text_2[j].setText(String.valueOf(A[j]));
                pause(10);

                //перестановка эл.
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;

                //показывается как переставлены эл.
                rect_2[i].setFill(Color.GREEN);
                text_2[i].setText(String.valueOf(A[i]));

                rect_2[j].setFill(Color.GREEN);
                text_2[j].setText(String.valueOf(A[j]));
                pause(10);

                //смещение значений в основной массив
                text[i].setText(String.valueOf(A[i]));
                rect[i].setFill(Color.GREEN);
                rect_2[i].setVisible(false);
                text_2[i].setVisible(false);
                text[j].setText(String.valueOf(A[j]));
                rect[j].setFill(Color.GREEN);
                rect_2[j].setVisible(false);
                text_2[j].setVisible(false);
                pause(10);

                rect[i].setFill(Color.GRAY);
                rect[j].setFill(Color.GRAY);
                pause(10);

                i++;
                j--;
            }
        } while (i <= j);

        if (low < j) nextTwo(low, j, rect, text, rect_2, text_2);
        if (i < high) nextTwo(i, high, rect, text, rect_2, text_2);

    }


    public void threeDisp(Rectangle[] rect, Text[] text, Rectangle[] rect_2, Text[] text_2) {

        Thread aSortdisplayt = new Thread(new Runnable() {
            @Override
            public void run() {
                nextTwo( 0, A.length-1,rect, text, rect_2, text_2);
            }
        });

        aSortdisplayt.start();

        for (int k = 0; k < A.length; k++) {
            rect_2[k].setVisible(false);
            text_2[k].setVisible(false);
        }
    }

    @FXML
    public void Open(Rectangle[] rect, Text[] text) {



        }
    }

