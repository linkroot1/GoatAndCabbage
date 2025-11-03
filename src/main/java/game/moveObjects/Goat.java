package game.moveObjects;

import game.*;
import game.events.GoatActionEvent;
import game.events.GoatActionListener;

import java.util.ArrayList;
import java.util.List;

public class Goat {


    //-----------------------------------Свойства класса--------------------------------------------

    private Yard _yard;
    private int goatEnergy;
    private CellPosition _position;
    private Direction _direction = Direction.east();
    private Box _box;
    private Key _key;
    private ArrayList<Coin> _coinPool = new ArrayList();

    private boolean destroy = false;
    private final List<GoatActionListener> _listeners = new ArrayList();

    //---------------------------------Конструктор класса-------------------------------------------

    public Goat(int goatEnergy) {
        this.goatEnergy = goatEnergy;
    }

    //------------------------------------Методы класса----------------------------------------------

    //Получить количество козьей энергии
    public int getEnergy() {
        return this.goatEnergy;
    }

    //Сделать ход
    public boolean move(Direction direction) {
        if (this.canMove(direction)) {
            this.setPosition(this.position().next(direction));
            this.expendEnergy();
            this.fireGoatAction();
            _direction = direction;
            eatCabbage();
            if (_key == null) takeKey();
            if (_coinPool.size() != _yard._coinPool.size()) takeCoin();
            return true;
        }
        return false;
    }

    //Проверить, можно ли сделать ход
    public boolean canMove(Direction direction) {
        //Проверяем есть ли энергия
        if (this.getEnergy() < 1) return false;

        //Проверяем есть ли следующая позиция
        if (!this.position().hasNext(direction)) return false;

        // Проверяем есть ли стена
        MiddlePosition nextMiddlePos = new MiddlePosition(this.position(), direction);
        CellPosition nextCellPos = this.position().next(direction);
        if (this._yard.isWall(nextMiddlePos)) return false;

            //Проверяем есть ли коробка
        else return !this._yard.isBox(nextCellPos);
    }

    //Потратить козью энергию
    public boolean expendEnergy() {
        if (goatEnergy > 0) {
            goatEnergy--;
            return true;
        } else if (goatEnergy < 0) {
            goatEnergy = 0;
        }
        return false;
    }

    //Съесть капусту
    public boolean eatCabbage() {
        //Если на текущей клетке есть капуста - съесть ее (выиграть игру)
        if (_position.equals(_yard.getCabbage().position()) && _coinPool.size() == _yard._coinPool.size()) {
            goatEnergy = 0;
            _yard.I_eat_cabbage();
            return true;
        }
        return false;
    }

    //Потянуть коробку на себя
    public boolean moveBoxYourself(Direction direction) {
        //Получить коробку
        Box box = new Box(null);
        if (_position.hasNext(direction.opposite()) && this._yard.isBox(_position.next(direction.opposite())))
            box = this._yard.box(_position.next(direction.opposite()));
        else return false;

        //Получить направление коробки
        int dir;
        if (this.position().hasNext(Direction.east()) && box.position().equals(this.position().next(Direction.west().opposite())))
            dir = 1;
        else if (this.position().hasNext(Direction.west()) && box.position().equals(this.position().next(Direction.east().opposite())))
            dir = 2;
        else if (this.position().hasNext(Direction.south()) && box.position().equals(this.position().next(Direction.north().opposite())))
            dir = 3;
        else if (this.position().hasNext(Direction.north()) && box.position().equals(this.position().next(Direction.south().opposite())))
            dir = 4;
        else return false;

        //Если можем двигать козу в полученном направлении - двигаем козу и коробку
        if (dir == 1) {
            if (this.canMove(Direction.west())) {
                this.move(Direction.west());
                box.move(Direction.west());
                this.fireGoatAction();
                return true;
            }
        } else if (dir == 2) {
            if (this.canMove(Direction.east())) {
                this.move(Direction.east());
                box.move(Direction.east());
                this.fireGoatAction();
                return true;
            }

        } else if (dir == 3) {
            if (this.canMove(Direction.north())) {
                this.move(Direction.north());
                box.move(Direction.north());
                this.fireGoatAction();
                return true;
            }

        } else {
            if (this.canMove(Direction.south())) {
                this.move(Direction.south());
                box.move(Direction.south());
                this.fireGoatAction();
                return true;
            }

        }
        return false;
    }

    //Потянуть коробку от себя
    public boolean moveBoxAwayFromYou(Direction direction) {
        //Получить коробку
        Box box = new Box(null);
        if (_position.hasNext(direction) && this._yard.isBox(_position.next(direction)))
            box = this._yard.box(_position.next(direction));
        else return false;

        //Получить направление коробки
        int dir;
        if (this.position().hasNext(Direction.west()) && box.position().equals(this.position().next(Direction.west())))
            dir = 1;
        else if (this.position().hasNext(Direction.east()) && box.position().equals(this.position().next(Direction.east())))
            dir = 2;
        else if (this.position().hasNext(Direction.north()) && box.position().equals(this.position().next(Direction.north())))
            dir = 3;
        else if (this.position().hasNext(Direction.south()) && box.position().equals(this.position().next(Direction.south())))
            dir = 4;
        else return false;

        //Если можем двигать козу в полученном направлении - двигаем козу и коробку
        if (dir == 1) {
            if (box.canMove(Direction.west())) {
                box.move(Direction.west());
                this.move(Direction.west());
                return true;
            }
        } else if (dir == 2) {
            if (box.canMove(Direction.east())) {
                box.move(Direction.east());
                this.move(Direction.east());
                return true;
            }

        } else if (dir == 3) {
            if (box.canMove(Direction.north())) {
                box.move(Direction.north());
                this.move(Direction.north());
                return true;
            }

        } else {
            if (box.canMove(Direction.south())) {
                box.move(Direction.south());
                this.move(Direction.south());
                return true;
            }

        }
        return false;
    }

    //Взять ключ
    public boolean takeKey() {
        if (_yard.get_key() != null && _yard.get_key().position().equals(_position)) {
            _key = _yard.get_key();
            _key.set_position(null);
            return true;
        }
        return false;
    }

    //Взять монетку
    public boolean takeCoin() {
        for (int i = 0; i < _yard._coinPool.size(); i++) {
            if (_yard.getCoin(i) != null && _yard.getCoin(i).position() != null && _yard.getCoin(i).position().equals(_position)) {
                _coinPool.add(_yard.getCoin(i));
                _yard._coinPool.get(i).set_position(null);
                return true;
            }
        }

        return false;
    }

    //Задать загон
    public void set_yard(Yard _yard) {
        this._yard = _yard;
    }

    public boolean setPosition(CellPosition pos) {
        _position = pos;
        return true;
    }

    public CellPosition position() {
        return _position;
    }

    //Получить направление
    public Direction get_direction() {
        return _direction;
    }

    //Уничтожить
    public void destroy() {
        destroy = true;
    }

    //Уничтожена ли коза?
    public boolean isDestroy() {
        return destroy;
    }

    //Создать событие
    public void fireGoatAction() {
        for (GoatActionListener l : this._listeners) {
            l.goatMakedMove(new GoatActionEvent(this));
        }
    }

    //Использовать ключ
    public boolean useKey() {
        if (_key != null && _position.equals(_yard.get_teleport().position())) {
            _yard.get_teleport().activate(this);
            return true;
        }
        return false;
    }

    public void addGoatActionListener(GoatActionListener l) {
        if (destroy) {
            throw new RuntimeException("Error: robot is fired");
        }
        _listeners.add(l);
    }

    public Key get_key() {
        return _key;
    }
}
