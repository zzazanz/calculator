import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator");
        JPanel panel = new JPanel();
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton zero = new JButton("0");
        JButton plus = new JButton("+");
        JButton minus = new JButton("-");
        JButton multiply = new JButton("*");
        JButton divide = new JButton("/");
        JButton equal = new JButton("=");
        JButton clear = new JButton("AC");
        JLabel currentFormula = new JLabel("");
        AtomicReference<String> previousNum = new AtomicReference<>("");
        AtomicReference<String> nextNum = new AtomicReference<>("");
        AtomicReference<String> calcu = new AtomicReference<>("");
        AtomicBoolean isPreviousComplete = new AtomicBoolean(false);
        ArrayList<JButton> numList = new ArrayList<>(Arrays.asList(one, two, three, four, five, six, seven, eight, nine, zero));
        ArrayList<JButton> calcuList = new ArrayList<>(Arrays.asList(plus, minus, multiply, divide));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300, 400));

        for (JButton btn : numList) {
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 25));
            btn.setPreferredSize(new Dimension(75, 35));

            btn.addActionListener(e -> {
                if (!isPreviousComplete.get()) {
                    previousNum.set(previousNum.get() + btn.getText());
                    currentFormula.setText(previousNum.get());
                } else {
                    nextNum.set(nextNum.get() + btn.getText());
                    currentFormula.setText(nextNum.get());
                }
            });

            panel.add(btn);
        }

        for (JButton calcuBtn : calcuList) {
            calcuBtn.setFont(new Font("Segoe UI", Font.PLAIN, 25));
            calcuBtn.setPreferredSize(new Dimension(75, 35));

            calcuBtn.addActionListener(e -> {
                calcu.set(calcuBtn.getText());
                isPreviousComplete.set(true);
                currentFormula.setText(calcu.get());
            });

            panel.add(calcuBtn);
        }

        equal.addActionListener(e -> currentFormula.setText(String.valueOf(Calculate.calculate(previousNum.get(), previousNum.get(), calcu.get()))));
        equal.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        equal.setPreferredSize(new Dimension(75, 35));

        clear.addActionListener(e -> {
            previousNum.set("");
            nextNum.set("");
            calcu.set("");
            isPreviousComplete.set(false);
            currentFormula.setText("");
        });
        clear.setFont(new Font("Segoe UI", Font.PLAIN, 25));
        clear.setPreferredSize(new Dimension(75, 35));

        currentFormula.setFont(new Font("Segoe UI", Font.BOLD, 25));

        panel.add(equal);
        panel.add(clear);
        panel.add(currentFormula);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
}
