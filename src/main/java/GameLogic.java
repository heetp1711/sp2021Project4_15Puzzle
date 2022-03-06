import java.util.Collections;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.text.*; 
import javafx.scene.paint.Color;
import javafx.scene.layout.*;
import java.util.ArrayList;

public class GameLogic {
    int[] puzzle = new int[16];
    int x, y;
    int curr;

    ArrayList<ArrayList<Integer>> dict;

    public GameLogic() {
        dict = new ArrayList<>();

        int[] arr = new int[]{1,2,3,7,4,5,6,0,8,9,10,11,12,13,14,15};

        //0 14 13 12 15 9 5 8 11 7 4 1 3 10 6 2

        int[] arr1 = new int[]{0,14,13,12,15,9,5,8,11,7,4,1,3,10,6,2};
        int[] arr2 = new int[]{9,12,7,4,10,6,0,11,5,13,1,15,3,2,8,14};
        int[] arr3 = new int[]{6,7,15,1,9,10,2,12,5,11,4,14,3,8,0,13};
        int[] arr4 = new int[]{11,1,15,12,10,5,0,6,8,2,9,7,3,4,13,14};
        int[] arr5 = new int[]{11,14,0,4,2,9,1,15,6,10,12,7,8,5,3,13};
        int[] arr6 = new int[]{14,4,11,15,2,9,0,10,12,5,13,1,6,3,8,7};
        int[] arr7 = new int[]{12,4,15,10,9,8,6,11,3,14,2,1,5,0,7,13};
        int[] arr8 = new int[]{14,4,15,10,9,1,3,8,6,0,11,13,12,7,5,2};
        int[] arr9 = new int[]{6,14,11,15,5,1,3,10,9,4,7,8,12,0,13,2};
        int[] arr10 = new int[]{11,9,1,7,4,6,3,15,8,12,2,0,14,5,13,10};
        int[] arr11 = new int[]{3,9,1,7,11,4,12,15,8,13,14,10,0,6,2,5};

        addToDict(arr);

        addToDict(arr1);
        addToDict(arr2);
        addToDict(arr3);
        addToDict(arr4);
        addToDict(arr5);
        addToDict(arr6);
        addToDict(arr7);
        addToDict(arr8);
        addToDict(arr9);
        addToDict(arr10);
        addToDict(arr11);

        curr = 0;

        generate();
    }

    void addToDict(int[] arr) {
        ArrayList<Integer> temp = new ArrayList<>();

        for (int e: arr) {
            temp.add(e);
        }

        dict.add(temp);
    }

    public void generate() {
        ArrayList<Integer> temp = dict.get(curr);

        for (int i = 0; i < 16; i++) {
            puzzle[i] = temp.get(i);
            if (puzzle[i] == 0) {
                x = i/4;
                y = i%4;
            }
        }

        for(int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                System.out.print(puzzle[4*a + b] + " ");
            }
            System.out.println();
        }
        System.out.println();

        curr = ++curr%11;
    }

    public int at(int i, int j) {
        if (i >= 4 && j >= 4) return -1;

        return puzzle[i*4 + j];
    }

    public int at(int i) {
        if (i >= 16) return -1;

        return puzzle[i];
    }

    public boolean checkWin() {
        for (int  i = 0; i < 16; i++) {
            if (puzzle[i] != i) return false;
        }
        return true;
    }

    public int[] getPuzzle() {
        return puzzle;
    }

    public void swap(int i, int j) {
        int temp = puzzle[4*i + j];
        puzzle[4*i + j] = puzzle[4*x + y];
        puzzle[4*x + y] = temp;
        x = i;
        y = j;

        for(int a = 0; a < 4; a++) {
            for (int b = 0; b < 4; b++) {
                System.out.print(puzzle[4*a + b] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }
}