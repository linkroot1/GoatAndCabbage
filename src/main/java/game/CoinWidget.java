package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class CoinWidget extends JPanel {

    private Coin _coin;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            BufferedImage image = ImageIO.read(new File("resources/" + "coin.jpeg"));
            image = ImageUtils.resizeImage(image, 120, 120);
            g.drawImage(image, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawCoin(Graphics g, Point point) {
        g.setColor(Color.RED);
        g.drawImage(this.getImage(), point.x, point.y, null);
        g.setColor(Color.BLACK);   // восстанавливаем цвет пера
    }

    protected BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getCoinFile());
            image = ImageUtils.resizeImage(image, 30, 30);
            image = coinImageWithChargeText(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private static File getCoinFile() {
        return new File("resources/" + "coin.jpeg");
    }

    private BufferedImage coinImageWithChargeText(BufferedImage coinImage) {
        BufferedImage img = new BufferedImage(coinImage.getWidth(), 30, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.drawImage(coinImage, 0, 0, null);

        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.setColor(coinChargeTextColor());
        g.drawString(coinChargeText(), 5, 5);

        return img;
    }

    private String coinChargeText() {
        return "";
    }

    private Color coinChargeTextColor() {
        return GameWidgetsUtils.chargeTextColor(0, 100);
    }
}
