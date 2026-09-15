package ru.vsu.cs.kg26.g61.chuprikov.demo1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DrawPanel extends JPanel {

    double r = 10;
    {
        new Timer(100, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r++;
                repaint();
            }
        });
    }

    @Override
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        super.paint(g);

        drawSun(g, getWidth() / 2, getHeight() / 2, 70 + 40 * Math.sin(r * 0.1), 100, 30, Color.ORANGE);
    }

    public static void drawSun(Graphics2D g, int x, int y, int r, int l, int n, Color c) {
        g.setColor(c);
        g.fillOval(x - r, y - r, r * 2, r * 2);

        double da = Math.PI * 2 / n;
        for (int i = 0; i < n; i++) {
            double a = da * i;
            double x1 = r * Math.cos(a) + x;
            double y1 = r * Math.sin(a) + y;
            double x2 = (r + l) * Math.cos(a) + x;
            double y2 = (r + l) * Math.sin(a) + y;
            g.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        }
    }
}
