import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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


        /* Обработчик закрытия формы */
        Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String value = textField1.getText();
                if (checkKeys(textField1.getText()) && checkKeys(TextField2.getText())) {
                    int result = minus(Integer.parseInt(textField1.getText()), Integer.parseInt(TextField2.getText()));
                    textArea1.setText("" + result);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect input data!");
                    textField1.setText(null);
                    textArea1.setText("Error");
                }
            }
        });

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

    public static int minus(int arg1, int arg2){
        int res = arg1 - arg2;
        return res;
    }
}
