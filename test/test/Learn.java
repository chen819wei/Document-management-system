package test;

import org.junit.jupiter.api.Test;

public class Learn {
    @Test
    public void forLearn() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i);
                if (i * j >= 10) {
                    System.out.print(" ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
