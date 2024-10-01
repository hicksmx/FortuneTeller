import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private ArrayList<String> fortunes;
    private JTextArea fortuneDisplay;
    private int lastFortuneIndex;
    private Random random;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        initializeFortunes();
        createComponents();
        setFrameSize();
        random = new Random();
        lastFortuneIndex = -1;
    }

    private void initializeFortunes() {
        fortunes = new ArrayList<>();
        fortunes.add("You will find unexpected joy in the smallest of things.");
        fortunes.add("A pleasant surprise is waiting for you.");
        fortunes.add("Your creativity will lead you to success.");
        fortunes.add("Good fortune will be yours.");
        fortunes.add("A thrilling time is in your near future.");
        fortunes.add("Your hard work will pay off in the end.");
        fortunes.add("A dream you have will come true.");
        fortunes.add("You will receive good news from a distant friend.");
        fortunes.add("Your talents will be recognized and suitably rewarded.");
        fortunes.add("You will have a very comfortable old age.");
        fortunes.add("Your life will be happy and peaceful.");
        fortunes.add("A lifetime of happiness lies ahead of you.");
    }

    private void createComponents() {
        setLayout(new BorderLayout());

        // Top panel
        JPanel topPanel = new JPanel(new BorderLayout());
        ImageIcon icon = loadImageIcon("/fortune_teller.png");
        JLabel iconLabel = new JLabel(icon);
        iconLabel.setHorizontalAlignment(JLabel.CENTER);
        topPanel.add(iconLabel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Fortune Teller", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 48));
        topPanel.add(titleLabel, BorderLayout.SOUTH);

        add(topPanel, BorderLayout.NORTH);

        // Middle panel
        fortuneDisplay = new JTextArea(10, 30);
        fortuneDisplay.setFont(new Font("SansSerif", Font.PLAIN, 14));
        fortuneDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(fortuneDisplay);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom panel
        JPanel bottomPanel = new JPanel();
        JButton readFortuneButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");

        Font buttonFont = new Font("SansSerif", Font.BOLD, 14);
        readFortuneButton.setFont(buttonFont);
        quitButton.setFont(buttonFont);

        readFortuneButton.addActionListener(e -> readFortune());
        quitButton.addActionListener(e -> System.exit(0));

        bottomPanel.add(readFortuneButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }

    private ImageIcon loadImageIcon(String path) {
        java.net.URL imgURL = getClass().getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    private void setFrameSize() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int width = (int) (screenSize.width * 0.75);
        int height = (int) (screenSize.height * 0.75);
        setSize(width, height);
        setLocationRelativeTo(null);
    }

    private void readFortune() {
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastFortuneIndex);

        lastFortuneIndex = index;
        String fortune = fortunes.get(index);
        fortuneDisplay.append(fortune + "\n");
    }
}