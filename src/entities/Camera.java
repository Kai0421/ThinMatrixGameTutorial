package entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector3f;

import java.security.Key;

public class Camera {

    private Vector3f position = new Vector3f(0, 0, 0);
    private float pitch; // (high or low)
    private float yaw; // how left or right
    private float roll; // 180 degree wud be upside down

    public Camera() {

    }

    public void move(){
        if (Keyboard.isKeyDown(Keyboard.KEY_W))
            position.z -= 0.02f;

        if (Keyboard.isKeyDown(Keyboard.KEY_D))
            position.x += 0.02f;

        if (Keyboard.isKeyDown(Keyboard.KEY_A))
            position.x -= 0.02f;
    }

    public Vector3f getPosition() {
        return position;
    }

    public float getPitch() {
        return pitch;
    }

    public float getYaw() {
        return yaw;
    }

    public float getRoll() {
        return roll;
    }
}
