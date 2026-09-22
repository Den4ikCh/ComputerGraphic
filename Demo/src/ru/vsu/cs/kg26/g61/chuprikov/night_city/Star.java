package ru.vsu.cs.kg26.g61.chuprikov.night_city;

import java.awt.*;

public class Star {
    private int x, y;
    private int size;
    private double brightness;
    private double blinkSpeed;

    public Star(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size = size;
        brightness = Math.random();
        blinkSpeed = Math.random();
    }

    public void update() {
        brightness += blinkSpeed;
        if (brightness > 1 || brightness < 0) {
            blinkSpeed *= -1;
            brightness = Math.max(0, Math.min(1, brightness));
        }
    }

    public void draw(Graphics2D g) {
        int a = (int) (brightness * 255);
        g.setColor(new Color(255, 255, 255, a));
        g.fillOval(x, y, size, size);
    }
}
