package game.events;

import java.util.EventListener;

public interface GoatActionListener extends EventListener {
    void goatMakedMove(GoatActionEvent e);
}
