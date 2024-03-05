package gameObjects;

public class King extends GameObject {
    enum State {
        IDLE,
        ANGRY
    }

    int poisonedLvl;
    State state;

    public King(float _x, float _y, float _width, float _height, String _name) {
        super(_x, _y, _width, _height, _name);
    }
}
