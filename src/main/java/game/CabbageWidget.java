package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CabbageWidget extends JPanel {

    private Cabbage _cabbage;


    public CabbageWidget(Cabbage cabbage) {
        super();
        this._cabbage = cabbage;

    }

    public void drawCabbage(Graphics g, Cabbage cabbage, Point point, int CELL_SIZE ){
        g.setColor(Color.RED);

        String str = "";
        g.drawImage(this.getImage(), point.x, point.y, null );

        //g.drawImage(this.getImage(), point.x+CELL_SIZE/8, point.y+CELL_SIZE/4+15, null );
        g.setColor(Color.BLACK);   // восстанавливаем цвет пера
    }

    protected BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getCabbageFile());
            image = ImageUtils.resizeImage(image, 30, 30);
            image = cabbageImageWithChargeText(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private static File getCabbageFile() {
        File file = null;
        file = new File("resources/" +"cabbage.png");
        return file;
    }

    private BufferedImage cabbageImageWithChargeText(BufferedImage cabbageImage) {
        BufferedImage img = new BufferedImage(cabbageImage.getWidth(), 30, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.drawImage(cabbageImage, 0, 0, null);


        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.setColor(cabbageChargeTextColor());
        g.drawString(cabbageChargeText(), 5, 5);


        return img;
    }

    private String cabbageChargeText() {
        return "" + "" + "";
    }

    private Color cabbageChargeTextColor() {
        return GameWidgetsUtils.chargeTextColor(0, 100);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        try {
            BufferedImage image = ImageIO.read(new File("resources/" +"cabbage.png"));
            image = ImageUtils.resizeImage(image, 30, 30);
            g.drawImage(image, 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
