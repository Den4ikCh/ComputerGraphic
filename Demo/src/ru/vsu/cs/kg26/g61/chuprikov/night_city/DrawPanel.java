package ru.vsu.cs.kg26.g61.chuprikov.night_city;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {
    @Override
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth() - 1, getHeight() - 1);
//        Star star = new Star(300, 400, 10);
//        star.draw(g);
//        Moon moon = new Moon(200, 200, 70, 200);
//        moon.draw(g);
//        Cloud cloud = new Cloud(300, 300, 50, 20, 2, new Color(255, 255, 255, 200));
//        cloud.draw(g);
        Building building = new Building(40, 40, 500, 200, new Color(10, 10, 10));
        building.draw(g);
    }
}
