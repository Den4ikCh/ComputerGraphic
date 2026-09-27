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
            g.setColor(new Color(switchedOnColor.getRed(), switchedOnColor.getGreen(), switchedOnColor.getBlue(), 80));
            g.fillRect(x - 3, y - 3, width + 6, height + 6);
            g.setColor(switchedOnColor);
        } else {
            g.setColor(switchedOffColor);
        }
        g.fillRect(x, y, width, height);
    }
}
