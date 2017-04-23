
package sample;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.math.BigDecimal;

public class Controller {
    SpeedQuickSort cat;

    //объявляем наши колоник

    @FXML
    private Rectangle rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10,
            rect11, rect12, rect13, rect14, rect15, rect16, rect17, rect18, rect19, rect20;

    @FXML
    private Text text1, text2, text3, text4, text5, text6, text7, text8, text9, text10,
            text11, text12, text13, text14, text15, text16, text17, text18, text19, text20;

    /////////////
    //On Action//
    /////////////

    //Заполнение первой колонки,для будуюшей сортировки
    public void Random() {
        Rectangle[] rect = {rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10};
        Text[] text = {text1, text2, text3, text4, text5, text6, text7, text8, text9, text10};
        cat = new SpeedQuickSort(10);
        cat.OneDisp(rect,text);
    }

    //Сортировка
    public void SortingQuick() {

        Rectangle[] rect = {rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10};
        Rectangle[] rect_2 = {rect11, rect12, rect13, rect14, rect15, rect16, rect17, rect18, rect19, rect20};
        Text[] text = {text1, text2, text3, text4, text5, text6, text7, text8, text9, text10};
        Text[] text_2 = {text11, text12, text13, text14, text15, text16, text17, text18, text19, text20};
        cat.TwoDisp( rect, text, rect_2, text_2);
    }

    public void qSort() {

        Rectangle[] rect = {rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10};
        Rectangle[] rect_2 = {rect11, rect12, rect13, rect14, rect15, rect16, rect17, rect18, rect19, rect20};
        Text[] text = {text1, text2, text3, text4, text5, text6, text7, text8, text9, text10};
        Text[] text_2 = {text11, text12, text13, text14, text15, text16, text17, text18, text19, text20};
        cat.threeDisp( rect, text, rect_2, text_2);
    }



    //открываем файл
    public void OpenFile() {
        Rectangle[] rect = {rect1, rect2, rect3, rect4, rect5, rect6, rect7, rect8, rect9, rect10};
        Text[] text = {text1, text2, text3, text4, text5, text6, text7, text8, text9, text10};
        cat.Open(rect,text);
    }
}