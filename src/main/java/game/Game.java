package game;

import game.events.GoatActionEvent;
import game.events.GoatActionListener;

public class Game {


    //----------------------------------------Свойства класса----------------------------------------

    private Labyrinth _labyrinth;
    private Yard _yard;
    private boolean stopGame = true;

    GoatObserver o = new GoatObserver();

    //------------------------------------------Методы класса-----------------------------------------

    public Yard get_yard() {
        return _yard;
    }

    //Инициализировать начало игры
    public void initGame() {

        //Начало игры
        stopGame = false;

        //Создание загона
        _yard = new Yard(10, 10, this);

        //Создание лабиринта
        _labyrinth = new Labyrinth(_yard);

        //создаем коробки
        _labyrinth.createBox(3, 1);
        _labyrinth.createBox(2, 4);

        //создаем капусту
        _labyrinth.createCabbage(5, 5);

        //создаем козу
        _labyrinth.createGoat(1, 1, 30);

        //создаем ключ
        _labyrinth.createKey(4, 4);

        //создаем телепорт
        _labyrinth.createTeleport(3, 3);

        //создаем монетки
        _labyrinth.createCoin(2, 5);
        _labyrinth.createCoin(2, 6);

        //создаем стены
        _labyrinth.createWall(1, 1, Direction.south());

        _labyrinth.createWall(2, 2, Direction.west());

        _labyrinth.createWall(2, 4, Direction.west());

        _labyrinth.createWall(3, 1, Direction.south());

        _labyrinth.createWall(4, 1, Direction.east());

        _labyrinth.createWall(2, 2, Direction.east());

        _yard.getGoat().addGoatActionListener(o);
    }

    //Проверить закончилась ли игра
    public boolean checkGameEnding() {
        return stopGame;
    }

    //Определить выиграна ли игра
    public boolean determinateWin() {

        if (!checkGameEnding() && findGoatAndCabbageInYard()) {
            if (_yard.getGoat().position() == _yard.getCabbage().position()) {
                Win();
                return true;
            }
        }

        if (_yard.getGoat().getEnergy() < 1) {

            System.out.println("You goat energy is null!!!!!!");
            this.stopGame();
        }
        return false;

    }

    //Определить есть ли в загоне коза и капуста
    public boolean findGoatAndCabbageInYard() {

        if (_yard == null) return false;
        return _yard.getCabbage() != null && _yard.getGoat() != null;
    }

    //Закончить игру
    public void stopGame() {
        stopGame = true;
    }

    //Выиграть игру
    public void Win() {
        System.out.println("You win !!!");
    }

    private class GoatObserver implements GoatActionListener {
        @Override
        public void goatMakedMove(GoatActionEvent e) {
            determinateWin();
        }
    }
}
