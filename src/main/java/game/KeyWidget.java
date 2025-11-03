package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class KeyWidget extends JPanel {
    private Key _key;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            BufferedImage image = ImageIO.read(new File("resources/" + "key.png"));
            image = ImageUtils.resizeImage(image, 120, 120);
            g.drawImage(image, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawKey(Graphics g, Point point) {
        g.setColor(Color.RED);
        g.drawImage(this.getImage(), point.x, point.y, null);
        g.setColor(Color.BLACK);   // восстанавливаем цвет пера
    }

    protected BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getKeyFile());
            image = ImageUtils.resizeImage(image, 30, 30);
            image = keyImageWithChargeText(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private static File getKeyFile() {
        return new File("resources/" + "key.png");
    }

    private BufferedImage keyImageWithChargeText(BufferedImage keyImage) {
        BufferedImage img = new BufferedImage(keyImage.getWidth(), 30, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.drawImage(keyImage, 0, 0, null);

        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.setColor(keyChargeTextColor());
        g.drawString(keyChargeText(), 5, 5);

        return img;
    }

    private String keyChargeText() {
        return "";
    }

    private Color keyChargeTextColor() {
        return GameWidgetsUtils.chargeTextColor(0, 100);
    }
}
