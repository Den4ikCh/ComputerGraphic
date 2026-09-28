package ru.vsu.cs.kg26.g61.chuprikov.night_city;

import java.awt.*;

public class Window {
    private int x, y;
    private int width, height;
    private boolean switchedOn;
    private Color switchedOnColor;
    private Color switchedOffColor;

    public Window(int x, int y, int width, int height, Color switchedOnColor, Color switchedOffColor) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.switchedOnColor = switchedOnColor;
        this.switchedOffColor = switchedOffColor;
    }

    public void change() {
        switchedOn = !switchedOn;
    }

    public void draw(Graphics2D g) {
        if (switchedOn) {
            float[] dist = {0f, 1f};
            Color[] colors = {
                    new Color(switchedOnColor.getRed(), switchedOnColor.getGreen(), switchedOnColor.getBlue(), 120),
                    new Color(switchedOnColor.getRed(), switchedOnColor.getGreen(), switchedOnColor.getBlue(), 0)
            };
            RadialGradientPaint glow = new RadialGradientPaint(
                    new Point(x + width / 2, y + height / 2),
                    Math.max(width, height), dist, colors
            );
            g.setPaint(glow);
            g.fillOval(x - width / 2, y - height / 2, width * 2, height * 2);

            g.setColor(switchedOnColor);
        } else {
            g.setColor(switchedOffColor);
        }
        g.fillRect(x, y, width, height);
    }
}
