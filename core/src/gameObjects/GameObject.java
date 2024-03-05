package gameObjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class GameObject extends Actor {
    private Texture tex;
    // TODO check if animations really needed
    // private Animation animation;

    public GameObject(float _x, float _y, float _width, float _height, String _name) {
        this.setX(_x);
        this.setY(_y);
        this.setWidth(_width);
        this.setHeight(_height);
        this.setName(_name);
        this.tex = new Texture(
                Gdx.files.internal(
                        String.format("%s.png", this.getName().toLowerCase())
                )
        );
    }
}
