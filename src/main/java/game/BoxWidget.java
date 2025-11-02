package game;

import game.moveObjects.Box;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class BoxWidget extends JPanel {

    private Box _box;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            BufferedImage image = ImageIO.read(new File("resources/" + "box.png"));
            image = ImageUtils.resizeImage(image, 120, 120);
            g.drawImage(image, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawBox(Graphics g, Box box, Point point, int CELL_SIZE ){
        g.setColor(Color.RED);

        String str = "";
        g.drawImage(this.getImage(), point.x, point.y, null );

        //g.drawImage(this.getImage(), point.x+CELL_SIZE/8, point.y+CELL_SIZE/4+15, null );
        g.setColor(Color.BLACK);   // восстанавливаем цвет пера
    }

    protected BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getBoxFile());
            image = ImageUtils.resizeImage(image, 30, 30);
            image = boxImageWithChargeText(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private static File getBoxFile() {
        File file = null;
        file = new File("resources/" +"box.jpg");
        return file;
    }

    private BufferedImage boxImageWithChargeText(BufferedImage boxImage) {
        BufferedImage img = new BufferedImage(boxImage.getWidth(), 30, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.drawImage(boxImage, 0, 0, null);


        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.setColor(boxChargeTextColor());
        g.drawString(boxChargeText(), 5, 5);


        return img;
    }

    private String boxChargeText() {
        return "" + "" + "";
    }

    private Color boxChargeTextColor() {
        return GameWidgetsUtils.chargeTextColor(0, 100);
    }

}