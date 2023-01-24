package game;

import game.enums.Orientation;
import game.events.GoatActionEvent;
import game.events.GoatActionListener;
import game.moveObjects.Box;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {

    private Game _game;


    private static final int CELL_SIZE = 30;
    private static final int GAP = 2;
    private static final int FONT_HEIGHT = 15;


    private static final Color BACKGROUND_COLOR = new Color(175, 255, 175);
    private static final Color GRID_COLOR = Color.GREEN;


    public GamePanel(Game game){
        _game = game;


        int width = 2*GAP + CELL_SIZE * _game.get_yard().width();
        int height = 2*GAP + CELL_SIZE * _game.get_yard().height();
        setPreferredSize(new Dimension(width, height));
        setBackground(Color.RED);

        _game.get_yard().getGoat().addGoatActionListener(new RepaintByAction());
        addKeyListener(this);

    }


    /** Рисуем поле */
    @Override
    public void paintComponent(Graphics g) {

        // Отрисовка фона
        int width  = getWidth();
        int height = getHeight();
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);   // восстнанваливаем цвет пера



        // Отрисовка сетки
        darwGrid(g);

        // Отрисовка ключа
        if(_game.get_yard().get_key().position() != null) {
            Point lefTop3 = leftTopCell(_game.get_yard().get_key().position());
            KeyWidget keyWidget = new KeyWidget();

            keyWidget.drawKey(g, _game.get_yard().get_key(), lefTop3, CELL_SIZE);
        }

        //Отрисовка телепорта
        Point leftTop4 = leftTopCell(_game.get_yard().get_teleport().position());
        TeleportWidget teleportWidget = new TeleportWidget();
        teleportWidget.drawTeleport(g, _game.get_yard().get_teleport(), leftTop4, CELL_SIZE);


        // Отрисовка козы
        Point lefTop = leftTopCell(_game.get_yard().getGoat().position());
        GoatWidget goatWidget = new GoatWidget(_game.get_yard().getGoat());

        goatWidget.drawGoat(g, _game.get_yard().getGoat(), lefTop, CELL_SIZE);


        //Отрисовка верхней строки
        String lable = "Goat energy is: ";
        lable = lable + _game.get_yard().getGoat().getEnergy();
        g.drawString(lable, 20, 300);

        // Отрисовка капусты
        if(!(_game.get_yard().getGoat().position().equals(_game.get_yard().getCabbage().position()))) {
            Point lefTop2 = leftTopCell(_game.get_yard().getCabbage().position());
            CabbageWidget cabbageWidget = new CabbageWidget(_game.get_yard().getCabbage());

            cabbageWidget.drawCabbage(g, _game.get_yard().getCabbage(), lefTop2, CELL_SIZE);
        }

        // Отрисовка остальных юнитов, стен и коробок
        CellPosition pos = new CellPosition(1,1);
        Direction direct = Direction.east();
        boolean isPostLastColumn;
        do
        {
            boolean isPostLastRow;
            do
            {
                // Отрисовка коробки
                Box box = _game.get_yard().box(pos);
                if(box != null)
                {
                    lefTop = leftTopCell(pos);
                    BoxWidget boxWidget = new BoxWidget();
                    boxWidget.drawBox(g, box, lefTop, CELL_SIZE);
                }

                // Отрисовка монеток
                Coin coin = _game.get_yard().coin(pos);
                if(coin != null)
                {
                    lefTop = leftTopCell(pos);
                    CoinWidget coinWidget = new CoinWidget();
                    coinWidget.drawCoin(g, coin, lefTop, CELL_SIZE);
                }

                // Отрисовка стен
                Direction d = Direction.north();
                for(int n = 1; n<=4; n++)
                {
                    d = d.clockwise();
                    MiddlePosition mpos = new MiddlePosition(pos, d);

                    if(_game.get_yard().isWall(mpos))      // Отрисовка стены
                    {
                        lefTop = leftTopCell(mpos);
                        Orientation orientation = Orientation.HORIZONTAL;
                        if(d == Direction.east() || d == Direction.west()) orientation = Orientation.VERTICAL;
                        WallWidget wallWidget = new WallWidget(orientation);
                        wallWidget.drawWall(g, lefTop, mpos.direction(), CELL_SIZE);
                    }

                }

                isPostLastRow = !pos.hasNext(direct);
                if(!isPostLastRow)    { pos = pos.next(direct); }
            }
            while(!isPostLastRow);

            direct = direct.opposite();

            isPostLastColumn = !pos.hasNext(Direction.south());
            if(!isPostLastColumn)    { pos = pos.next(Direction.south()); }
        }



        while( !isPostLastColumn );


    }

    private Point leftTopCell(CellPosition pos) {

        int left = GAP + CELL_SIZE * (pos.column()-1);
        int top = GAP + CELL_SIZE * (pos.row()-1);

        return new Point(left, top);
    }

    private Point leftTopCell(MiddlePosition mpos) {

        Point p = leftTopCell(mpos.cellPosition());

        if(mpos.direction().equals(Direction.south()))
        {
            p.y += CELL_SIZE;
            //p.x += CELL_SIZE;
        }
        else if(mpos.direction().equals(Direction.east()))
        {
            p.x += CELL_SIZE;
        }

        return p;
    }

    private void darwGrid(Graphics g) {
        int width  = getWidth();
        int height = getHeight();

        g.setColor(GRID_COLOR);

        for(int i = 1; i <= _game.get_yard().width()+1; i++)
        {
            int x = GAP + CELL_SIZE*(i-1);
            g.drawLine(x, 0, x, height);
        }

        for(int i = 1; i <= _game.get_yard().width()+1; i++)
        {
            int y = GAP + CELL_SIZE*(i-1);
            g.drawLine(0, y, width, y);
        }

    }







    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.isControlDown())
        {
            if(ke.getKeyCode() == KeyEvent.VK_UP) {
                _game.get_yard().getGoat().moveBoxYourself(Direction.north());
            }
            else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
                _game.get_yard().getGoat().moveBoxYourself(Direction.south());
            }
            else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
                _game.get_yard().getGoat().moveBoxYourself(Direction.west());
            }
            else if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                _game.get_yard().getGoat().moveBoxYourself(Direction.east());
            }

        }
        else  if(ke.isAltDown())
        {
            if(ke.getKeyCode() == KeyEvent.VK_UP) {
                _game.get_yard().getGoat().moveBoxAwayFromYou(Direction.north());
            }
            else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
                _game.get_yard().getGoat().moveBoxAwayFromYou(Direction.south());
            }
            else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
                _game.get_yard().getGoat().moveBoxAwayFromYou(Direction.west());
            }
            else if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                _game.get_yard().getGoat().moveBoxAwayFromYou(Direction.east());
            }
        }

        else
        {
            if(ke.getKeyCode() == KeyEvent.VK_UP) {
                _game.get_yard().getGoat().move(Direction.north());
            }
            else if(ke.getKeyCode() == KeyEvent.VK_DOWN) {
                _game.get_yard().getGoat().move(Direction.south());
            }
            else if(ke.getKeyCode() == KeyEvent.VK_LEFT) {
                _game.get_yard().getGoat().move(Direction.west());
            }
            else if(ke.getKeyCode() == KeyEvent.VK_RIGHT) {
                _game.get_yard().getGoat().move(Direction.east());
            }
            else if(ke.getKeyCode() == KeyEvent.VK_SPACE) { // используем ключ
                _game.get_yard().getGoat().useKey();
            }

        }
    }








    private class RepaintByAction implements GoatActionListener {

        @Override
        public void goatMakedMove(GoatActionEvent e) {
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
