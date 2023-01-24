package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BreakGoatGame extends JFrame {

    private Game _game;

    private GamePanel _gamePanel;

    //===================================================================== main
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BreakGoatGame();
            }
        });
    }

    //============================================================== constructor
    public BreakGoatGame() {

        this.setTitle("Коза и капуста");

        _game = new Game();
        _game.initGame();
        _gamePanel = new GamePanel(_game);

//        //... Create button and check box.
//        JButton newGameBtn = new JButton("Новая игра");
//        newGameBtn.addActionListener(new ActionNewGame());

        //... Do layout
        JPanel controlPanel = new JPanel(new FlowLayout());
//        controlPanel.add(newGameBtn);

        //... Create content pane with graphics area in center (so it expands)
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(controlPanel, BorderLayout.NORTH);
        content.add(_gamePanel, BorderLayout.CENTER);

        //... Set this window's characteristics.
        setContentPane(content);
        setTitle("Коза и капуста");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        _gamePanel.setFocusable(true);
        _gamePanel.setVisible(true);
    }

    ////////////////////////////////////////////////////////////// ActionNewGame
    class ActionNewGame implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            _game.initGame();
        }
    }
}

