import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI extends JFrame implements ActionListener {
    private JTextField display;
    private JPanel panel;
    private double num1, num2;
    private char operator;

    public CalculatorGUI() {
        setTitle("Калькулятор");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);

        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 10, 10));
        add(panel, BorderLayout.CENTER);

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sqrt", "^", "sin", "cos", "tan", "C"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(this);
            panel.add(button);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        try {
            if (command.charAt(0) == 'C') {
                display.setText("");
            } else if (command.charAt(0) == '=') {
                num2 = Double.parseDouble(display.getText());
                switch (operator) {
                    case '+':
                        display.setText(String.valueOf(num1 + num2));
                        break;
                    case '-':
                        display.setText(String.valueOf(num1 - num2));
                        break;
                    case '*':
                        display.setText(String.valueOf(num1 * num2));
                        break;
                    case '/':
                        display.setText(num2 != 0 ? String.valueOf(num1 / num2) : "Ошибка");
                        break;
                    case '^':
                        display.setText(String.valueOf(Math.pow(num1, num2)));
                        break;
                }
            } else if (command.equals("sqrt")) {
                num1 = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.sqrt(num1)));
            } else if (command.equals("sin")) {
                num1 = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.sin(Math.toRadians(num1))));
            } else if (command.equals("cos")) {
                num1 = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.cos(Math.toRadians(num1))));
            } else if (command.equals("tan")) {
                num1 = Double.parseDouble(display.getText());
                display.setText(String.valueOf(Math.tan(Math.toRadians(num1))));
            } else {
                if (command.charAt(0) == '+' || command.charAt(0) == '-' || command.charAt(0) == '*' || command.charAt(0) == '/' || command.charAt(0) == '^') {
                    num1 = Double.parseDouble(display.getText());
                    operator = command.charAt(0);
                    display.setText("");
                } else {
                    display.setText(display.getText() + command);
                }
            }
        } catch (Exception ex) {
            display.setText("Ошибка");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorGUI calculator = new CalculatorGUI();
            calculator.setVisible(true);
        });
    }
}