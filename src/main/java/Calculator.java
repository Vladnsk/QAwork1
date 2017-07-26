import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Arc2D;

/**
 * Created by Владислав on 25.07.2017.
 */
public class Calculator {
    private JPanel panel1;
    private JTextField textField1;
    private JTextField TextField2;
    private JTextArea textArea1;
    private JButton Button;
    

    public Calculator() {
        JFrame mainWindow = new JFrame("Test app");
        mainWindow.setVisible(true);                //установка видимости формы
        mainWindow.setFocusable(true);              //установка фокуса формы
        mainWindow.setSize(600, 600); //задаем размер формы
        mainWindow.setResizable(false);             //запрет изменения размера в процессе работы

        mainWindow.setContentPane(panel1);
        mainWindow.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //задаем действие по-умолчанию при попытке заккрытия формы


         /* Обработчик клика по кнопке */
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String text1 = textField1.getText();
                String text2 = TextField2.getText();

                textArea1.setText(devS(text1, text2));

            }
        });

        /* Обработчик закрытия формы */

        mainWindow.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int reply = JOptionPane.showConfirmDialog(null, "Do you want exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }


    /* Проверка на возможность деления */
    public static Boolean checkDev(String str1, String str2){
        if (str1.matches("\\-?\\d+(\\.\\d{0,})?") == true && str2.matches("\\-?\\d+(\\.\\d{0,})?") == true) {
            double number2 = Double.parseDouble(str2);
            if (number2 == 0)
                return false;
            else
                return true;
        }
        else
            return false;
    }
    /* Деление */
    public static String devS(String firstStr, String secondStr) {
        double res = 0;
        String result;

        if(checkDev(firstStr,secondStr) == true) {
            double number1 = Double.parseDouble(firstStr);
            double number2 = Double.parseDouble(secondStr);
            res = number1 / number2;
            result = "" + res;
        }
        else{
            result = "Incorrect input";
        }
        return result;
    }
}
