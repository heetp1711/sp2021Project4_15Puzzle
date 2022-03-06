import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.*; 
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import java.util.ArrayList;

public class GameButton extends Button {
    public int num;

    public GameButton(Background bg, Background bg2, int num) {
        this.setPrefSize(100,100);
        
        if (num == 0) {
            this.setBackground(bg2);
        } else {
            this.setBackground(bg);
            this.setText(String.valueOf(num));
        }

        this.num = num;
    }

    public void press(Background bg) {
        this.setBackground(bg);
        this.setDisable(true);
    }

    public boolean isZero() {
        return num == 0;
    }

    public void unpress(Background bg, int num) {
        this.setBackground(bg);
        
        if (num != 0) 
            this.setText(String.valueOf(num));
        else
            this.setText("");
        
        this.num = num;
        this.setDisable(false);
    }

    public void change(Background bt1, Background bt2, int num) {
        if (num == 0) {
            this.setBackground(bt2);
            this.setText("");
        } else {
            this.setBackground(bt1);
            this.setText(String.valueOf(num));
        }

        this.num = num;
    }
}