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
                double number1 = Double.parseDouble(text1);
                double number2 = Double.parseDouble(text2);

                if (checkKeys(text1) && checkKeys(text2))
                    if (checkZero(number2))
				        textArea1.setText(""+dev(number1,number2));
                else {
                    JOptionPane.showMessageDialog(null, "Incorrect input data!");
                    textField1.setText(null);
                    TextField2.setText(null);
                    textArea1.setText(null);
                }
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

    /**
     * Проверка что введено именно число
     *
     * @param keys введеная в поле строка
     * @return результат проверки
     */
    public static Boolean checkKeys(String keys) {
        return keys.matches("([-+])?\\d*\\.?,?\\d+");
    }

    /* Проверка на деление на ноль */
    public static Boolean checkZero(double number){
        if(number == 0)
            return false;
        else
            return true;
    }
    /* Деление */
    public static double dev(double firstStr, double secondStr) {

        double result = firstStr/secondStr;
        return result;
    }
}
