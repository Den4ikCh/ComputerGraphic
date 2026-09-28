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
        float[] dist = {0f, 0.5f, 1f};
        Color[] colors = {
                new Color(255, 255, 255, 120),
                new Color(255, 255, 255, 60),
                new Color(255, 255, 255, 0)
        };
        RadialGradientPaint glow = new RadialGradientPaint(
                new Point(x, y), haloRadius, dist, colors
        );
        g.setPaint(glow);
        g.fillOval(x - haloRadius, y - haloRadius, haloRadius * 2, haloRadius * 2);

        g.setColor(new Color(245, 245, 255));
        g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
    }
}
