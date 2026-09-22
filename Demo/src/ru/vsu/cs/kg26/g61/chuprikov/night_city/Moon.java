package ru.vsu.cs.kg26.g61.chuprikov.night_city;

import java.awt.*;

public class Moon {
    private int x, y;
    private int radius;
    private int haloRadius;

    public Moon(int x, int y, int radius, int haloRadius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.haloRadius = haloRadius;
    }

    public void draw(Graphics2D g) {
        int steps = Math.max(1, (haloRadius - radius) / 5);
        for (int i = steps; i > 0; i--) {
            int r = radius + (haloRadius - radius) * i / steps;
            int alpha = (int) (40 * (1 - (float) i / steps));
            g.setColor(new Color(255, 255, 255, alpha));
            g.fillOval(x - r, y - r, r * 2, r * 2);
        }

        g.setColor(new Color(245, 245, 255));
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
