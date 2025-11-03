package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TeleportWidget extends JPanel {
    private Teleport _teleport;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            BufferedImage image = ImageIO.read(new File("resources/" + "portal.png"));
            image = ImageUtils.resizeImage(image, 120, 120);
            g.drawImage(image, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawTeleport(Graphics g, Point point) {
        g.setColor(Color.RED);
        g.drawImage(this.getImage(), point.x, point.y, null);
        g.setColor(Color.BLACK);   // восстанавливаем цвет пера
    }

    protected BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getTeleportFile());
            image = ImageUtils.resizeImage(image, 30, 30);
            image = teleportImageWithChargeText(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private static File getTeleportFile() {
        return new File("resources/" + "portal.png");
    }

    private BufferedImage teleportImageWithChargeText(BufferedImage teleportImage) {
        BufferedImage img = new BufferedImage(teleportImage.getWidth(), 30, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.drawImage(teleportImage, 1, 1, null);

        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.setColor(teleportChargeTextColor());
        g.drawString(teleportChargeText(), 5, 5);

        return img;
    }

    private String teleportChargeText() {
        return "";
    }

    private Color teleportChargeTextColor() {
        return GameWidgetsUtils.chargeTextColor(0, 100);
    }
}
