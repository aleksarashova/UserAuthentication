import java.util.Random;
public class Game {

    private final static int EQUAL_SIZE = 3;
    private FigureType[][] board = new FigureType[6][6];
    private Random random = new Random();

    private boolean validateBoardCoord(int x, int y){
        return y>=0 && y<board.length && x>=0 && x<=board[0].length;
    }
    public void swapFigures(int x1, int y1, int x2, int y2){
        if (!validateBoardCoord(x1,y1) || !validateBoardCoord(x2,y2))
            throw  new IllegalArgumentException("Error: Invalid board coordinates.");
        FigureType figureType = board[y1][x1];
        board[y1][x1] = board[y2][x2];
        board[y2][x2]= figureType;
    }

    private boolean hasEqualFigureTypesHorizontal(int x, int y){
        if (!validateBoardCoord(x,y) || !validateBoardCoord(x+EQUAL_SIZE-1,y))
            throw  new IllegalArgumentException("Error: Invalid board coordinates.");
        boolean hasEqual = true;
        FigureType figureType = null;
        for(int i = x; i<x+EQUAL_SIZE; i++){
            FigureType currFigureType = board[y][i];
            if (figureType==null) {
                figureType = currFigureType;
            }
            else if (currFigureType!=figureType) {
                hasEqual = false;
                break;
            }
        }
        return hasEqual;
    }

    private boolean hasEqualFigureTypesVertical(int x, int y){
        if (!validateBoardCoord(x,y) || !validateBoardCoord(x,y+EQUAL_SIZE-1))
            throw  new IllegalArgumentException("Error: Invalid board coordinates.");
        boolean hasEqual = true;
        FigureType figureType = null;
        for(int i = y; i<y+EQUAL_SIZE; i++){
            FigureType currFigureType = board[i][x];
            if (figureType==null) {
                figureType = currFigureType;
            }
            else if (currFigureType!=figureType) {
                hasEqual = false;
                break;
            }
        }
        return hasEqual;
    }

    private void clearBomb(int x, int y){
        int fromX = Math.max(x-1,0);
        int fromY = Math.max(y-1,0);
        int toX = Math.min(x+1,board[y].length-1);
        int toY = Math.min(y+1,board.length-1);
        for(int r = fromY; r<=toY; r++) {
            for (int c = fromX; c <= toX; c++) {
                board[r][c] = null;
            }
        }
    }

    private void clearHorizontal(int x, int y){
        for(int i = x; i<x+EQUAL_SIZE;i++){
            if (board[y][i]==FigureType.BOMB) clearBomb(i,y);
            else board[y][i]=null;
        }
    }

    private void clearVertical(int x, int y){
        for(int i = y; i<y+EQUAL_SIZE;i++){
            if (board[i][x]==FigureType.BOMB) clearBomb(x,i);
            else board[i][x]=null;
        }
    }

    private FigureType randomFigureType() {
        FigureType[] figureTypes = FigureType.values();
        int randomIndex = random.nextInt(figureTypes.length);
        return figureTypes[randomIndex];
    }

    private FigureType getFillBoardFigureType(int x, int y){
        for(int r = y; r>=0; r--) {
            if (board[r][x]!=null){
                FigureType tmp = board[r][x];
                board[r][x] = null;
                return tmp;
            }
        }
        return randomFigureType();
    }

    private void fillBoardColumn(int x){
        for(int r = board.length-1; r>=0; r--) {
            if (board[r][x]==null){
                board[r][x] = getFillBoardFigureType(x,r);
            }
        }
    }

    private void fillEmptyBoardPlaces() {
        for (int c = 0; c <= board[0].length; c++) {
            fillBoardColumn(c);
        }
    }

    public void checkEquals(){
        for(int y = 0; y<board.length-EQUAL_SIZE; y++){
            for(int x = 0; x<board[y].length-EQUAL_SIZE; x++){
                if (hasEqualFigureTypesHorizontal(x,y)){
                    clearHorizontal(x,y);
                } else if (hasEqualFigureTypesVertical(x, y)) {
                    clearVertical(x,y);
                }
            }
        }
        fillEmptyBoardPlaces();
    }
}
