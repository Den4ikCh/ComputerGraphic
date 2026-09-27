package ru.vsu.cs.kg26.g61.chuprikov.night_city;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Building {
    private int x, y;
    private int width, height;
    private Color color;
    private List<Window> windows;

    public Building(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        windows = new ArrayList<Window>();
        generateWindows();
    }

    private void generateWindows() {
        int winW = 14, winH = 18;
        int gapX = 10, gapY = 12;
        int startX = x + 12;
        int startY = y + 20;

        for (int row = 0; startY + row * (winH + gapY) + winH < y + height - 10; row++) {
            for (int col = 0; startX + col * (winW + gapX) + winW < x + width - 12; col++) {
                int wx = startX + col * (winW + gapX);
                int wy = startY + row * (winH + gapY);
                boolean switchedOn = Math.random() > 0.5;
                Color switchedOnColor = new Color(255, 220, 120);
                Color switchedOffColor = new Color(30, 30, 50);
                windows.add(new Window(wx, wy, winW, winH, switchedOnColor, switchedOffColor));
                if (switchedOn) {
                    windows.getLast().change();
                }
            }
        }
    }

    public void update() {
    }

    public void draw(Graphics2D g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);

        g.setColor(color.darker());
        g.fillRect(x - 5, y - 8, width + 10, 10);

        for (Window w : windows) w.draw(g);
    }
}
