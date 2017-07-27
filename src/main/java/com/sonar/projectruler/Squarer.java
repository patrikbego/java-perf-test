package com.sonar.projectruler;

/**
 * Created by begop on 04/07/2017.
 */
public class Squarer {


    public static void main(String[] args) {

        //top, right, bottom, left
        // top = m[0][0]
        //right= m[0][1]
        //bottom=m[0][2]
        //left=[0][3]

        int sizey = 3;
        int sizex = 3;

        int m[][] = {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 1}
        };

        int posibilities = 0;

//        recursiveCall(sizey, sizex, m);

        for (int i=0; i<256; i++) {
            System.out.println(Integer.toBinaryString(i));
        }

    }

    static void recursiveCall(int m[][]) {

        double booleanValue = Math.random();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
//                if (m[i][j] == 1 && m[0][0] != 1 && m[sizey - 1][sizex -1] != 1)
//                    m[i][j] = 0;
//                else
//                    m[i][j] = 1;

//                if(m[i - 1][j] == 1 )

                if (i < 3 && j < 3 && (m[i + 1][j] == 0 || m[i][j + 1] == 0))
                    m[i][j] = 1;
                else
                    m[i][j] = 0;

                //m[0][0] = 1

                //m[i][j] = 1

                //i > 0 && j > 0 && m[i][j] == 1


                System.out.print(m[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        if (m[0][0] == 0 && m[3 - 1][3 -1] == 0)
            recursiveCall(m);
    }
}
