package game;

import game.moveObjects.Goat;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GoatWidget extends JPanel {

    private final Goat goat;
    private Direction direction;


    public GoatWidget(Goat goat) {
        super();
        this.goat = goat;
        direction = goat.get_direction();
        setFocusable(true);
        addKeyListener(new KeyController());
    }

    public void drawGoat(Graphics g, Goat _goat, Point point, int CELL_SIZE ){
        g.setColor(Color.RED);

        String str = "";
        g.drawImage(this.getImage(), point.x, point.y, null );


        g.setColor(Color.BLACK);   // восстанавливаем цвет пера
    }


    protected BufferedImage getImage() {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getGoatFileByDirection(goat.get_direction()));
            image = ImageUtils.resizeImage(image, 30, 30);
            //image = goatImageWithChargeText(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }



    public void setActive(boolean state) {
        setFocusable(state);
        requestFocus();
        repaint();
    }


    protected Dimension getDimension() {
        return new Dimension(60, 120);
    }



    private BufferedImage goatImageWithChargeText(BufferedImage goatImage) {
        BufferedImage img = new BufferedImage(goatImage.getWidth(), 30, BufferedImage.TYPE_INT_ARGB);
        Graphics g = img.getGraphics();
        g.drawImage(goatImage, 0, 0, null);


            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.setColor(goatChargeTextColor());
            g.drawString(goatChargeText(), 5, 5);


        return img;
    }

    private String goatChargeText() {
        return goat.getEnergy() + "" + "";
    }

    private Color goatChargeTextColor() {
        return GameWidgetsUtils.chargeTextColor(goat.getEnergy(), 100);
    }

    private static File getGoatFileByDirection(Direction direction) {
        File file = null;
        if (direction.equals(Direction.east()))  {
            file = new File("resources/" +"goat_east.jpg");
        }
        else if (direction.equals(Direction.west()))  {
            file = new File("resources/" +"goat_west.png");
        }
        else if (direction.equals(Direction.south()))  {
            file = new File("resources/" +"goat_south.jpg");
        }
        else if (direction.equals(Direction.north()))  {
            file = new File("resources/" +"goat_north.jpg");
        }

        return file;
    }

    // Внутренний класс-обработчик событий. Придает специфицеское поведение виджету
    private class KeyController implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent ke) {
            if (ke.isControlDown()) {
                if (ke.getKeyCode() == KeyEvent.VK_UP) {
                    goat.moveBoxYourself(Direction.north());
                } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    goat.moveBoxYourself(Direction.south());
                } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    goat.moveBoxYourself(Direction.west());
                } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    goat.moveBoxYourself(Direction.east());
                }

            } else if (ke.isAltDown()) {
                if (ke.getKeyCode() == KeyEvent.VK_UP) {
                    goat.moveBoxAwayFromYou(Direction.north());
                } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    goat.moveBoxAwayFromYou(Direction.south());
                } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    goat.moveBoxAwayFromYou(Direction.west());
                } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    goat.moveBoxAwayFromYou(Direction.east());
                }
            } else {
                if (ke.getKeyCode() == KeyEvent.VK_UP) {
                    goat.move(Direction.north());
                } else if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
                    goat.move(Direction.south());
                } else if (ke.getKeyCode() == KeyEvent.VK_LEFT) {
                    goat.move(Direction.west());
                } else if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                    goat.move(Direction.east());
                }
                else if(ke.getKeyCode() == KeyEvent.VK_SPACE) { // используем ключ
                    goat.useKey();
                }

            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

}
