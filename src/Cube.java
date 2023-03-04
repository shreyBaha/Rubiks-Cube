import java.awt.Color;
public class Cube {
    private Color[][][] cube = new Color[6][3][3]; //face 0 = f, face 1 = r, face 2 = b, face 3 = l, face 4 = u, face 5 = d
    
    public Cube(){
        this.fillCube();
    }

    public Color retColor(int f, int r, int c){
        return cube[f][r][c];
    }
    
    public void scramble(){
        for(int i = 0; i < 25; i++){
            int turn = (int)(Math.random()*6);
            int face = (int)(Math.random()*6);
            int col = (int)(Math.random()*3);
            int row = (int)(Math.random()*3);
            switch(turn){
                case 0:
                    turnRowLeft(row, face, false);
                    break;
                case 1:
                    turnRowRight(row, face, false);
                    break;
                case 2:
                    turnColBack(col, face, false);
                    break;
                case 3:
                    turnColFor(col, face, false);
                    break;
                case 4:
                    rotateFaceClock(face, false);
                    break;
                case 5:
                    rotateFaceCounterClock(face, false);
                    break;
            }
        }
    }

    public void fillCube(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                cube[0][i][j] = Color.GREEN;
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                cube[3][i][j] = Color.ORANGE;
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                cube[1][i][j] = Color.RED;
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                cube[2][i][j] = Color.YELLOW;
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                cube[4][i][j] = Color.WHITE;
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                cube[5][i][j] = Color.BLUE;
            }
        }
    }

    // public String printCube(){
    //     String ret = "Face\n\n";
    //     for(int i = 0; i < 3; i++){
    //         for(int j = 0; j < 3; j++){
    //             ret += cube[0][i][j];
    //         }
    //         ret += "\n";
    //     }
    //     ret += "\nLeft\n\n";
    //     for(int i = 0; i < 3; i++){
    //         for(int j = 0; j < 3; j++){
    //             ret += cube[3][i][j];
    //         }
    //         ret += "\n";
    //     }
    //     ret += "\nRight\n\n";
    //     for(int i = 0; i < 3; i++){
    //         for(int j = 0; j < 3; j++){
    //             ret += cube[1][i][j];
    //         }
    //         ret += "\n";
    //     }
    //     ret += "\nBack\n\n";
    //     for(int i = 0; i < 3; i++){
    //         for(int j = 0; j < 3; j++){
    //             ret += cube[2][i][j];
    //         }
    //         ret += "\n";
    //     }
    //     ret += "\nUp\n\n";
    //     for(int i = 0; i < 3; i++){
    //         for(int j = 0; j < 3; j++){
    //             ret += cube[4][i][j];
    //         }
    //         ret += "\n";
    //     }
    //     ret += "\nDown\n\n";
    //     for(int i = 0; i < 3; i++){
    //         for(int j = 0; j < 3; j++){
    //             ret += cube[5][i][j];
    //         }
    //         ret += "\n";
    //     }
    //     return ret;
    // }

    public void turnRowRight(int r, int f, boolean callFrom){
        if(f != 4 && f != 5){
            Color temp1 = cube[3][r][0];
            Color temp2 = cube[3][r][1];
            Color temp3 = cube[3][r][2];
            for(int i = 3; i > 0; i--){
                cube[i][r][0] = cube[i-1][r][0];
                cube[i][r][1] = cube[i-1][r][1];
                cube[i][r][2] = cube[i-1][r][2];
            }
            cube[0][r][0] = temp1;
            cube[0][r][1] = temp2;
            cube[0][r][2] = temp3;
            if(!callFrom){
                switch(r){
                    case 0: 
                        rotateFaceCounterClock(4, true);
                        break;
                    case 2:
                        rotateFaceClock(5, true);
                        break;
                }
            }
        }
        else{
            if(f == 4){
                switch(r){
                    case 2:
                        turnColFor(0, 1, false);
                        break;
                    case 1:
                        turnColFor(1, 1, false);
                        break;
                    case 0:
                        turnColFor(2, 1, false);
                        break;
                }
            }
            else if(f == 5){
                switch(r){
                    case 2:
                        turnColFor(2, 1, false);
                        break;
                    case 1:
                        turnColFor(1, 1, false);
                        break;
                    case 0:
                        turnColFor(0, 1, false);
                        break;
                }
            }
        }
        
    }

    public void turnRowLeft(int r, int f, boolean callFrom){
        if(f != 4 && f != 5){
            Color temp1 = cube[0][r][0];
            Color temp2 = cube[0][r][1];
            Color temp3 = cube[0][r][2];
            for(int i = 0; i < 3; i++){
                cube[i][r][0] = cube[i+1][r][0];
                cube[i][r][1] = cube[i+1][r][1];
                cube[i][r][2] = cube[i+1][r][2];
            }
            cube[3][r][0] = temp1;
            cube[3][r][1] = temp2;
            cube[3][r][2] = temp3;
            if(!callFrom){
                switch(r){
                    case 0: 
                        rotateFaceCounterClock(4, true);
                        break;
                    case 2:
                        rotateFaceClock(5, true);
                        break;
                }
            }
        }
        else{
            if(f == 4){
                switch(r){
                    case 2:
                        turnColBack(0, 1, false); 
                        break;
                    case 1:
                        turnColBack(1, 1, false);
                        break;
                    case 0:
                        turnColBack(2, 1, false);
                        break;
                }
            }
            else if(f == 5){
                switch(r){
                    case 2:
                        turnColBack(2, 1, false);
                        break;
                    case 1:
                        turnColBack(1, 1, false);
                        break;
                    case 0:
                        turnColBack(0, 1, false);
                        break;
                }
            }
        }
        
    }
// NEED SWITCHES FOR OTHER FACE CONDITIONS (f != 1 && f != 3)
    public void turnColBack(int c, int f, boolean callFrom){
        if(f != 1 && f != 3){ 
            int colf0 = 1;
            int colf5 = 1;
            int colf2 = 1;
            int colf4 = 1;
            if(f == 2){
                switch(c){
                    case 0:
                        colf0 = 2;
                        colf5 = 2;
                        colf4 = 2;
                        colf2 = 0;
                        break;
                    case 2:
                        colf0 = 0;
                        colf5 = 0;
                        colf4 = 0;
                        colf2 = 2;
                        break;
                }
            }
            else{
                switch(c){
                    case 0:
                        colf0 = 0;
                        colf5 = 0;
                        colf4 = 0;
                        colf2 = 2;
                        break;
                    case 2:
                        colf0 = 2;
                        colf5 = 2;
                        colf4 = 2;
                        colf2 = 0;
                        break;
                }
            }
            Color temp1 = cube[0][0][colf0];
            Color temp2 = cube[0][1][colf0];
            Color temp3 = cube[0][2][colf0];
            cube[0][0][colf0] = cube[5][0][colf5];
            cube[0][1][colf0] = cube[5][1][colf5];
            cube[0][2][colf0] = cube[5][2][colf5];
            cube[5][0][colf5] = cube[2][0][colf2];
            cube[5][1][colf5] = cube[2][1][colf2];
            cube[5][2][colf5] = cube[2][2][colf2];
            cube[2][0][colf2] = cube[4][0][colf4];
            cube[2][1][colf2] = cube[4][1][colf4];
            cube[2][2][colf2] = cube[4][2][colf4];
            cube[4][0][colf4] = temp1;
            cube[4][1][colf4] = temp2;
            cube[4][2][colf4] = temp3;
            if(!callFrom){
                switch(c){
                    case 0: 
                        rotateFaceCounterClock(3, true);
                        break;
                    case 2:
                        rotateFaceClock(1, true);
                        break;
                }
            }
        }
        else{
            int colf1 = -1;
            int colf3 = -1;
            int rowF5 = -1;
            int rowF4 = -1;
            if(f == 1){
                switch(c){
                    case 0:
                        rowF5 = 0;
                        rowF4 = 2;
                        colf1 = 0;
                        colf3 = 2;
                        if(!callFrom){
                            rotateFaceCounterClock(0, true);
                        }
                        break;
                    case 1:
                        rowF5 = 1;
                        rowF4 = 1;
                        colf1 = 1;
                        colf3 = 1;
                        break;
                    case 2:
                        rowF5 = 2;
                        rowF4 = 0;
                        colf1 = 2;
                        colf3 = 0;
                        if(!callFrom){
                            rotateFaceClock(2, true);
                        }
                        break;
                }
                Color temp1 = cube[1][0][colf1];
                Color temp2 = cube[1][1][colf1];
                Color temp3 = cube[1][2][colf1];
                cube[1][0][colf1] = cube[5][rowF5][2];
                cube[1][1][colf1] = cube[5][rowF5][1];
                cube[1][2][colf1] = cube[5][rowF5][0];
                cube[5][rowF5][0] = cube[3][0][colf3];
                cube[5][rowF5][1] = cube[3][1][colf3];
                cube[5][rowF5][2] = cube[3][2][colf3];
                cube[3][0][colf3] = cube[4][rowF4][2];
                cube[3][1][colf3] = cube[4][rowF4][1];
                cube[3][2][colf3] = cube[4][rowF4][0];
                cube[4][rowF4][0] = temp1;
                cube[4][rowF4][1] = temp2;
                cube[4][rowF4][2] = temp3;
            }
            else if(f == 3){
                switch(c){
                    case 0:
                        rowF5 = 2;
                        rowF4 = 0;
                        colf1 = 2;
                        colf3 = 0;
                        if(!callFrom){
                            rotateFaceCounterClock(2, true);
                        }
                        break;
                    case 1:
                        rowF5 = 1;
                        rowF4 = 1;
                        colf1 = 1;
                        colf3 = 1;
                        break;
                    case 2:
                        rowF5 = 0;
                        rowF4 = 2;
                        colf1 = 0;
                        colf3 = 2;
                        if(!callFrom){
                            rotateFaceClock(0, true);
                        }
                        break;
                }
                Color temp1 = cube[1][0][colf1];
                Color temp2 = cube[1][1][colf1];
                Color temp3 = cube[1][2][colf1];
                cube[1][0][colf1] = cube[4][rowF4][2];
                cube[1][1][colf1] = cube[4][rowF4][1];
                cube[1][2][colf1] = cube[4][rowF4][0];
                cube[4][rowF4][0] = cube[3][0][colf3];
                cube[4][rowF4][1] = cube[3][1][colf3];
                cube[4][rowF4][2] = cube[3][2][colf3];
                cube[3][0][colf3] = cube[5][rowF5][2];
                cube[3][1][colf3] = cube[5][rowF5][1];
                cube[3][2][colf3] = cube[5][rowF5][0];
                cube[5][rowF5][0] = temp1;
                cube[5][rowF5][1] = temp2;
                cube[5][rowF5][2] = temp3;
            }
            
            
            
        }
        
    }

    public void turnColFor(int c, int f, boolean callFrom){
        if(f != 1 && f != 3){
            int colf0 = 1;
            int colf5 = 1;
            int colf2 = 1;
            int colf4 = 1;
            if(f == 2){
                switch(c){
                    case 0:
                        colf0 = 2;
                        colf5 = 2;
                        colf4 = 2;
                        colf2 = 0;
                        break;
                    case 2:
                        colf0 = 0;
                        colf5 = 0;
                        colf4 = 0;
                        colf2 = 2;
                        break;
                }
            }
            else{
                switch(c){
                    case 0:
                        colf0 = 0;
                        colf5 = 0;
                        colf4 = 0;
                        colf2 = 2;
                        break;
                    case 2:
                        colf0 = 2;
                        colf5 = 2;
                        colf4 = 2;
                        colf2 = 0;
                        break;
                }
            }
            Color temp1 = cube[0][0][colf0];
            Color temp2 = cube[0][1][colf0];
            Color temp3 = cube[0][2][colf0];
            cube[0][0][colf0] = cube[4][0][colf4];
            cube[0][1][colf0] = cube[4][1][colf4];
            cube[0][2][colf0] = cube[4][2][colf4];
            cube[4][0][colf4] = cube[2][0][colf2];
            cube[4][1][colf4] = cube[2][1][colf2];
            cube[4][2][colf4] = cube[2][2][colf2];
            cube[2][0][colf2] = cube[5][0][colf5];
            cube[2][1][colf2] = cube[5][1][colf5];
            cube[2][2][colf2] = cube[5][2][colf5];
            cube[5][0][colf5] = temp1;
            cube[5][1][colf5] = temp2;
            cube[5][2][colf5] = temp3;
            if(!callFrom){
                switch(c){
                    case 0: 
                        rotateFaceClock(3, true);
                        break;
                    case 2:
                        rotateFaceCounterClock(1, true);
                        break;
                }
            }
        }
        else{
            int colf1 = -1;
            int colf3 = -1;
            int rowF5 = -1;
            int rowF4 = -1;
            if(f == 1){
                switch(c){
                    case 0:
                        rowF5 = 0;
                        rowF4 = 2;
                        colf1 = 0;
                        colf3 = 2;
                        if(!callFrom){
                            rotateFaceClock(0, true);
                        }
                        break;
                    case 1:
                        rowF5 = 1;
                        rowF4 = 1;
                        colf1 = 1;
                        colf3 = 1;
                        break;
                    case 2:
                        rowF5 = 2;
                        rowF4 = 0;
                        colf1 = 2;
                        colf3 = 0;
                        if(!callFrom){
                            rotateFaceCounterClock(2, true);
                        }
                        break;
                }
                Color temp1 = cube[1][0][colf1];
                Color temp2 = cube[1][1][colf1];
                Color temp3 = cube[1][2][colf1];
                cube[1][0][colf1] = cube[4][rowF4][0];
                cube[1][1][colf1] = cube[4][rowF4][1];
                cube[1][2][colf1] = cube[4][rowF4][2];
                cube[4][rowF4][0] = cube[3][2][colf3];
                cube[4][rowF4][1] = cube[3][1][colf3];
                cube[4][rowF4][2] = cube[3][0][colf3];
                cube[3][0][colf3] = cube[5][rowF5][0];
                cube[3][1][colf3] = cube[5][rowF5][1];
                cube[3][2][colf3] = cube[5][rowF5][2];
                cube[5][rowF5][2] = temp1;
                cube[5][rowF5][1] = temp2;
                cube[5][rowF5][0] = temp3;
            }
            else if(f == 3){
                switch(c){
                    case 0:
                        rowF5 = 2;
                        rowF4 = 0;
                        colf1 = 2;
                        colf3 = 0;
                        if(!callFrom){
                            rotateFaceClock(2, true);
                        }
                        break;
                    case 1:
                        rowF5 = 1;
                        rowF4 = 1;
                        colf1 = 1;
                        colf3 = 1;
                        break;
                    case 2:
                        rowF5 = 0;
                        rowF4 = 2;
                        colf1 = 0;
                        colf3 = 2;
                        if(!callFrom){
                            rotateFaceCounterClock(0, true);
                        }
                        break;
                }
                Color temp1 = cube[1][0][colf1];
                Color temp2 = cube[1][1][colf1];
                Color temp3 = cube[1][2][colf1];
                cube[1][0][colf1] = cube[5][rowF5][2];
                cube[1][1][colf1] = cube[5][rowF5][1];
                cube[1][2][colf1] = cube[5][rowF5][0];
                cube[5][rowF5][0] = cube[3][0][colf3];
                cube[5][rowF5][1] = cube[3][1][colf3];
                cube[5][rowF5][2] = cube[3][2][colf3];
                cube[3][0][colf3] = cube[4][rowF4][2];
                cube[3][1][colf3] = cube[4][rowF4][1];
                cube[3][2][colf3] = cube[4][rowF4][0];
                cube[4][rowF4][0] = temp1;
                cube[4][rowF4][1] = temp2;
                cube[4][rowF4][2] = temp3;
            }
            
        }
       
    }

    public void rotateFaceClock(int f, boolean callFrom){
        Color temp = cube[f][0][0];
        cube[f][0][0] = cube[f][2][0];
        cube[f][2][0] = cube[f][2][2];
        cube[f][2][2] = cube[f][0][2];
        cube[f][0][2] = temp;
        temp = cube[f][0][1];
        cube[f][0][1] = cube[f][1][0];
        cube[f][1][0] = cube[f][2][1];
        cube[f][2][1] = cube[f][1][2];
        cube[f][1][2] = temp;
        if(!callFrom){
            switch(f){
                case 0:
                turnColBack(2, 3, true);
                    break;
                case 1:
                turnColBack(2, 0, true);
                    break;
                case 2:
                turnColBack(2, 1, true);
                    break;
                case 3:
                turnColBack(2, 2, true); //ERROR
                    break;
                case 4:
                turnRowLeft(0, 0, true);
                    break;
                case 5:
                turnRowRight(2, 0, true);
                    break;
            }
        }
    }

    public void rotateFaceCounterClock(int f, boolean callFrom){
        Color temp = cube[f][0][0];
        cube[f][0][0] = cube[f][0][2];
        cube[f][0][2] = cube[f][2][2];
        cube[f][2][2] = cube[f][2][0];
        cube[f][2][0] = temp;
        temp = cube[f][0][1];
        cube[f][0][1] = cube[f][1][2];
        cube[f][1][2] = cube[f][2][1];
        cube[f][2][1] = cube[f][1][0];
        cube[f][1][0] = temp;
        if(!callFrom){
            switch(f){
                case 0:
                turnColFor(2, 3, true);
                    break;
                case 1:
                turnColFor(2, 0, true);
                    break;
                case 2:
                turnColFor(2, 1, true);
                    break;
                case 3:
                turnColFor(2, 2, true);
                    break;
                case 4:
                turnRowRight(0, 0, true);
                    break;
                case 5:
                turnRowLeft(2, 0, true);
                    break;
            }
        }
    }
}

