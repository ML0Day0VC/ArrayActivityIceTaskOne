import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Max Day
 * Created At: 2023/08/15
 */

public class arrayAppForm {
    private JButton addToArrayButton;
    private JTextField numField;
    private JTextArea outputArea;
    private JPanel mainPanel;
    private JButton displayHorizontal;
    private JButton displayVertical;
    private JButton minMax;
    private ArrayList<Integer> intArr = new ArrayList<>(); //unknown size of array, so we use dynamic array list instead


    public arrayAppForm() {
        addToArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add integer
                String input = numField.getText();
                if (input.matches("[0-9]+")) { // checks if numbers are integers but more specifically makes sure numbers include only 0 1 2 3 4 5 6 7 8 9
                    intArr.add(Integer.parseInt(input));
                } else
                    JOptionPane.showMessageDialog(null, "Please enter valid integer numbers.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                numField.setText("");
            }
        });
        displayHorizontal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //display horizontal
                StringBuilder s = new StringBuilder();
                for (int element : intArr)
                    s.append(element).append(", ");
                outputArea.setText("Array Elements: [ " + s.substring(0, s.length() - 2) + "]"); // just to remove the extra spacing and commas
            }
        });
        displayVertical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //display vertical
                StringBuilder s = new StringBuilder();
                for (int element : intArr)
                    s.append(element).append(",\n");
                outputArea.setText("Array Elements: [\n" + s.substring(0, s.length() - 2) + "\n]"); // just to remove the extra spacing and commas
            }
        });
        minMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Min Max
                int min = intArr.stream().mapToInt(Integer::intValue).min().orElse(0); // another godly use for arraylists
                int max = intArr.stream().mapToInt(Integer::intValue).max().orElse(0);
                outputArea.setText("The min value is: %d\nThe max value is: %d".formatted(min, max)); //string formating
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ArrayApp");
        frame.setContentPane(new arrayAppForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(400, 200); // seting the window to a fixed size prevents alot of bad java gui issues
        frame.setResizable(false);
        frame.setVisible(true);
    }

}
