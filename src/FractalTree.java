import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class FractalTree extends JPanel {

    private static final int MAX_DEPTH = 10;
    private static final double INITIAL_ANGLE_CHANGE = Math.PI / 6; // 30 degrees
    private static final double INITIAL_LENGTH = 160;
    private static final double LENGTH_SCALE = 0.75;

    private double angleChange = INITIAL_ANGLE_CHANGE;
    private double thicknessFactor = 1.0;

    public FractalTree() {
        setBackground(Color.BLACK);
        setPreferredSize(new Dimension(800, 600));

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                int centerX = getWidth() / 2;
                double distance = Math.abs(e.getX() - centerX);
                double maxDistance = centerX;
                // Scale thickness based on distance from center (0.1 to 3.0)
                thicknessFactor = 0.1 + (distance / maxDistance) * 3.0;

                // Scale angle based on vertical position (0 to PI)
                // Map Y from 0 (top) to height (bottom) to angle 0 to PI
                angleChange = (double) e.getY() / getHeight() * Math.PI;

                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.WHITE);

        // Start drawing from the bottom center
        drawTree(g2d, getWidth() / 2, getHeight(), -Math.PI / 2, MAX_DEPTH, INITIAL_LENGTH);
    }

    private void drawTree(Graphics2D g, int x1, int y1, double angle, int depth, double length) {
        if (depth == 0) {
            return;
        }

        int x2 = x1 + (int) (Math.cos(angle) * length);
        int y2 = y1 + (int) (Math.sin(angle) * length);

        // Make branches thinner as they go up, scaled by thicknessFactor
        float width = (float) (depth * thicknessFactor);
        g.setStroke(new BasicStroke(width));
        g.drawLine(x1, y1, x2, y2);

        // Recursive calls
        // Recursive calls
        drawTree(g, x2, y2, angle - angleChange, depth - 1, length * LENGTH_SCALE);
        drawTree(g, x2, y2, angle + angleChange, depth - 1, length * LENGTH_SCALE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Fractal Tree");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new FractalTree());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
