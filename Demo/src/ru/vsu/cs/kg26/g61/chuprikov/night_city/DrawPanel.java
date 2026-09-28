package ru.vsu.cs.kg26.g61.chuprikov.night_city;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class DrawPanel extends JPanel {
    private Moon moon;
    private List<Star> stars;
    private List<Cloud> clouds;
    private List<Building> buildings;

    public DrawPanel() {
        setBackground(new Color(40, 20, 70));
        Random rnd = new Random();

        moon = new Moon(400, 180, 90, 200);

        stars = new ArrayList<>();
        for (int i = 0; i < 120; i++) {
            stars.add(new Star(rnd.nextInt(800), rnd.nextInt(350), 2 + rnd.nextInt(2)));
        }

        clouds = new ArrayList<>();
        clouds.add(new Cloud(80, 120, 120, 60, 1, new Color(120, 90, 160, 180)));
        clouds.add(new Cloud(560, 90, 140, 70, 1, new Color(120, 90, 160, 180)));
        clouds.add(new Cloud(300, 60, 100, 50, 2, new Color(140, 110, 180, 160)));

        buildings = new ArrayList<>();
        buildings.add(new Building(30, 400, 90, 250, new Color(35, 25, 60)));
        buildings.add(new Building(140, 320, 110, 330, new Color(25, 20, 50)));
        buildings.add(new Building(270, 280, 120, 370, new Color(20, 15, 45)));
        buildings.add(new Building(410, 360, 100, 290, new Color(30, 22, 55)));
        buildings.add(new Building(530, 340, 110, 310, new Color(25, 18, 50)));
        buildings.add(new Building(660, 420, 100, 230, new Color(35, 25, 60)));

        Timer timer = new Timer(30, e -> {
            for (Star s : stars) s.update();
            for (Cloud c : clouds) c.update(getWidth());
            for (Building b : buildings) b.update();
            repaint();
        });
        timer.start();
    }

    @Override
    public void paint(Graphics gr) {
        Graphics2D g = (Graphics2D) gr;
        super.paint(g);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();

        GradientPaint sky = new GradientPaint(0, 0, new Color(60, 20, 100),
                0, h, new Color(20, 10, 40));
        g.setPaint(sky);
        g.fillRect(0, 0, w, h);

        for (Star s : stars) s.draw(g);

        moon.draw(g);

        for (Cloud c : clouds) c.draw(g);

        for (Building b : buildings) b.draw(g);
    }
}
