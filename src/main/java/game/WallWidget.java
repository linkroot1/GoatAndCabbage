package game;

import game.enums.Orientation;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WallWidget extends BlockWidget {

    public WallWidget(Orientation orientation) {
        super(orientation);
    }

    @Override
    protected BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getImageFileByOrientation());
            Dimension dimension = getDimensionByOrientation();
            image = ImageUtils.resizeImage(image, dimension.width, dimension.height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void drawWall(Graphics g, Point lefTop, Direction direct, int CELL_SIZE) {
        g.setColor(Color.RED);

        if (direct.equals(Direction.west()) || direct.equals(Direction.east())) {
            g.drawLine(lefTop.x, lefTop.y, lefTop.x, lefTop.y + CELL_SIZE);
        } else {
            g.drawLine(lefTop.x, lefTop.y, lefTop.x + CELL_SIZE, lefTop.y);
        }

        g.setColor(Color.BLACK);   // восстанавливаем цвет пера
    }


    private File getImageFileByOrientation() {
        return (orientation == Orientation.VERTICAL) ? new File("WV.png") : new File("WH.png");
    }
}
