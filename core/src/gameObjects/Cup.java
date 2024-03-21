package gameObjects;

public class Cup extends GameObject {
    public boolean poisoned;
    public Cup(float _x, float _y, float _width, float _height, String _name) {
        super(_x, _y, _width, _height, _name);
        this.poisoned = false;
    }
}
