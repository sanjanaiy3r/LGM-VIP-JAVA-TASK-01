
import java.awt.*;
import javax.swing.*;

public class CurrencyConverter {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Currency Converter");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        frame.getContentPane().setBackground(Color.WHITE);

        JLabel titleLabel = new JLabel("Currency Converter");
        titleLabel.setBounds(120, 20, 200, 30);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        frame.add(titleLabel);

        JLabel inputLabel = new JLabel("Amount in USD:");
        inputLabel.setBounds(50, 70, 100, 25);
        inputLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        frame.add(inputLabel);

        JTextField inputField = new JTextField();
        inputField.setBounds(160, 70, 150, 25);
        frame.add(inputField);

        JLabel outputLabel = new JLabel("Convert to:");
        outputLabel.setBounds(50, 110, 100, 25);
        outputLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        frame.add(outputLabel);

        String[] currencies = {"INR", "AED", "EUR", "GBP", "USD"};
        JComboBox<String> currencyBox = new JComboBox<>(currencies);
        currencyBox.setBounds(160, 110, 150, 25);
        frame.add(currencyBox);

        JButton convertButton = new JButton("Convert");
        convertButton.setBounds(140, 160, 100, 30);
        convertButton.setBackground(Color.GRAY);
        convertButton.setForeground(Color.WHITE);
        convertButton.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        frame.add(convertButton);

        JLabel resultLabel = new JLabel("Converted Amount: ");
        resultLabel.setBounds(50, 210, 300, 25);
        resultLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        frame.add(resultLabel);

        convertButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(inputField.getText());
                String currency = (String) currencyBox.getSelectedItem();
                double convertedAmount = switch (currency) {
                    case "INR" ->
                        amount * 83.95; // INR conversion rate
                    case "AED" ->
                        amount * 3.67;  // AED conversion rate
                    case "EUR" ->
                        amount * 0.85;  // EUR conversion rate
                    case "GBP" ->
                        amount * 0.75;  // GBP conversion rate
                    case "USD" ->
                        amount;         // USD to USD conversion rate
                    default ->
                        throw new IllegalStateException("Unexpected value: " + currency);
                };

                resultLabel.setText("Converted Amount: " + String.format("%.2f", convertedAmount) + " " + currency);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid amount.");
            }
        });

        frame.setVisible(true);
    }
}
