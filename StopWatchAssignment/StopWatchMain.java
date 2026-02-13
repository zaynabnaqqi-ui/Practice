import java.awt.*;
import javax.swing.*;

public class StopWatchMain {
    static class Stopwatch {
        private int cs = 0;     // centiseconds
        private int sec = 0;
        private int min = 0;
        private boolean running = false;

        void tick() {
            cs++;
            if (cs == 100) {
                cs = 0;
                sec++;
                if (sec == 60) {
                    sec = 0;
                    min++;
                }
            }
        }

        void start()    { running = true; }
        void stop(){ running = false; }   // pause
        void reset(){ cs = sec = min = 0; running = false; }
        boolean isRunning() { return running; }

        String getTime() {
            return String.format("%02d:%02d:%02d", min, sec, cs);
        }
    }
    private final Stopwatch watch = new Stopwatch();

    private JFrame frame;
    private JLabel display;
    private JButton btnStart;
    private JButton btnReset;
    private Timer timer;

    public StopWatchMain() {
        createWindow();
    }

    private void createWindow() {
        frame = new JFrame("Stopwatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);

        JPanel main = new JPanel(new BorderLayout(0, 30));
        main.setBackground(new Color(41, 77, 82));
       
        // Time display
        display = new JLabel("00:00:00", SwingConstants.CENTER);
        display.setFont(new Font("Britannic Bold", Font.BOLD, 100));
        display.setForeground(Color.WHITE);
        main.add(display, BorderLayout.CENTER);

        // Buttons
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 30));
        buttons.setBackground(new Color(41, 77, 82));

        btnStart = new JButton("START");
        btnReset = new JButton("RESET");
        JButton btnExit = new JButton("EXIT");
        btnStart.setBackground(new Color(200, 100, 0));
        btnStart.setForeground(Color.WHITE);
        btnReset.setBackground(new Color(200, 100, 0));
        btnReset.setForeground(Color.WHITE);
        btnExit.setBackground(new Color(200, 100, 0));
        btnExit.setForeground(Color.WHITE);
        for (JButton b : new JButton[]{btnStart, btnReset, btnExit}) {
            b.setPreferredSize(new Dimension(140, 60));
            b.setFont(new Font("Britannic Bold", Font.BOLD, 20));
            buttons.add(b);
        }
        btnStart.setBackground( new Color(200, 100, 0));
        btnReset.setBackground(new Color(200, 100, 0));
        btnExit.setBackground(new Color(200, 100, 0));


        main.add(buttons, BorderLayout.SOUTH);
        frame.add(main);

        // Timer – 10 ms = 1/100 s
        timer = new Timer(10, e -> {
            if (watch.isRunning()) {
                watch.tick();
                display.setText(watch.getTime());
            }
        });

        // Button actions: e is event object give info about event
        // A special object that waits for an action (like a button click) and runs code when it happens.
        btnStart.addActionListener(e -> {
            if (watch.isRunning()) {
                watch.stop();
                timer.stop();
                btnStart.setText("START");
                btnStart.setBackground(new Color(200, 100, 0));
                main.setBackground(new Color(59, 41, 82));
                buttons.setBackground(new Color(59, 41, 82));
            } else {
                watch.start();
                timer.start();
                btnStart.setText("PAUSE");
                btnStart.setBackground(new Color(200, 100, 0));
                main.setBackground(new Color(82, 41, 73));
                buttons.setBackground(new Color(82, 41, 73));
            }
        });

        btnReset.addActionListener(e -> {
            timer.stop();
            watch.reset();
            display.setText("00:00:00");
            btnStart.setText("START");
            btnStart.setBackground(new Color(200, 100, 0));
            main.setBackground(new Color(41, 77, 82));
            buttons.setBackground(new Color(41, 77, 82));
        });

        btnExit.addActionListener(e -> frame.dispose());

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StopWatchMain::new);
    }
}
