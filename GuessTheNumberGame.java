import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GuessTheNumberGame extends JFrame implements ActionListener {

    private int randomNumber;
    private int attemptsLeft;
    private int score;
    private int round;

    private final int MAX_ATTEMPTS = 7;
    private final int MAX_NUMBER = 100;

    private JTextField guessField;
    private JLabel messageLabel;
    private JLabel attemptsLabel;
    private JLabel scoreLabel;
    private JLabel roundLabel;
    private JButton guessButton;
    private JButton newRoundButton;

    private Random random;

    public GuessTheNumberGame() {
        random = new Random();
        score = 0;
        round = 1;

        setTitle("🎮 Guess The Number Game");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
        startNewRound();

        setVisible(true);
    }

    private void initComponents() {

        // Main Panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(30, 144, 255)); // Dodger Blue
        add(panel);

        // Title Label
        JLabel titleLabel = new JLabel("Guess The Number (1 - 100)");
        titleLabel.setBounds(80, 20, 350, 40);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        titleLabel.setForeground(Color.WHITE);
        panel.add(titleLabel);

        // Round Label
        roundLabel = new JLabel();
        roundLabel.setBounds(30, 70, 200, 30);
        roundLabel.setFont(new Font("Arial", Font.BOLD, 14));
        roundLabel.setForeground(Color.WHITE);
        panel.add(roundLabel);

        // Score Label
        scoreLabel = new JLabel();
        scoreLabel.setBounds(300, 70, 200, 30);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 14));
        scoreLabel.setForeground(Color.WHITE);
        panel.add(scoreLabel);

        // Message Label
        messageLabel = new JLabel("Enter your guess below:");
        messageLabel.setBounds(110, 110, 300, 30);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        messageLabel.setForeground(Color.YELLOW);
        panel.add(messageLabel);

        // Guess Field
        guessField = new JTextField();
        guessField.setBounds(150, 150, 180, 35);
        guessField.setFont(new Font("Arial", Font.BOLD, 18));
        guessField.setHorizontalAlignment(JTextField.CENTER);
        panel.add(guessField);

        // Guess Button
        guessButton = new JButton("Submit Guess");
        guessButton.setBounds(160, 200, 160, 35);
        guessButton.setFont(new Font("Arial", Font.BOLD, 14));
        guessButton.setBackground(Color.WHITE);
        guessButton.setFocusPainted(false);
        guessButton.addActionListener(this);
        panel.add(guessButton);

        // Attempts Label
        attemptsLabel = new JLabel();
        attemptsLabel.setBounds(160, 250, 200, 30);
        attemptsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        attemptsLabel.setForeground(Color.WHITE);
        panel.add(attemptsLabel);

        // New Round Button
        newRoundButton = new JButton("Start New Round");
        newRoundButton.setBounds(150, 290, 180, 35);
        newRoundButton.setFont(new Font("Arial", Font.BOLD, 14));
        newRoundButton.setBackground(Color.GREEN);
        newRoundButton.setFocusPainted(false);
        newRoundButton.addActionListener(e -> startNewRound());
        panel.add(newRoundButton);
    }

    private void startNewRound() {
        randomNumber = random.nextInt(MAX_NUMBER) + 1;
        attemptsLeft = MAX_ATTEMPTS;
        guessField.setText("");
        guessButton.setEnabled(true);

        roundLabel.setText("Round: " + round);
        scoreLabel.setText("Score: " + score);
        attemptsLabel.setText("Attempts Left: " + attemptsLeft);
        messageLabel.setText("Enter your guess below:");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            int guess = Integer.parseInt(guessField.getText());

            if (guess < 1 || guess > MAX_NUMBER) {
                messageLabel.setText("⚠ Enter number between 1 and 100!");
                return;
            }

            attemptsLeft--;
            attemptsLabel.setText("Attempts Left: " + attemptsLeft);

            if (guess == randomNumber) {
                int points = attemptsLeft * 10;
                score += points;

                messageLabel.setText("🎉 Correct! You earned " + points + " points!");
                guessButton.setEnabled(false);
                round++;
            } else if (guess < randomNumber) {
                messageLabel.setText("📉 Too Low! Try Again.");
            } else {
                messageLabel.setText("📈 Too High! Try Again.");
            }

            if (attemptsLeft == 0 && guess != randomNumber) {
                messageLabel.setText("❌ Out of attempts! Number was " + randomNumber);
                guessButton.setEnabled(false);
                round++;
            }

            scoreLabel.setText("Score: " + score);

        } catch (NumberFormatException ex) {
            messageLabel.setText("⚠ Please enter a valid number!");
        }

        guessField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GuessTheNumberGame());
    }
}
