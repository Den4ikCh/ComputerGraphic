package ru.vsu.cs.kg26.g61.chuprikov.night_city;

import java.awt.*;

public class Cloud {
    private int x, y;
    private int width, height;
    private int speed;
    private Color color;

    public Cloud(int x, int y, int width, int height, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = color;
    }

    public void update(int width) {
        x -= speed;
        if (x + width < 0) {
            x = width + this.width;
        }
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillOval(x, y + height / 3, width / 2, height / 2);
        g.fillOval(x + width / 4, y, width / 2, height);
        g.fillOval(x + width / 2, y + height / 4, width / 2, height / 2);
    }
}
