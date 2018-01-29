public class Solution {

    public class Move {
        int i;
        int j;

        public Move(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    public class Cell {
        int row;
        int col;
        int dist;

        public Cell(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }

    public int knight(int A, int B, int C, int D, int E, int F) {

        boolean[][] board = new boolean[A][B];
        ArrayList<Move> moves = new ArrayList<Move>();
        moves.add(new Move(-1,-2));
        moves.add(new Move(-2,-1));
        moves.add(new Move(-2,1));
        moves.add(new Move(-1,2));
        moves.add(new Move(1,2));
        moves.add(new Move(2,1));
        moves.add(new Move(2,-1));
        moves.add(new Move(1,-2));

        int sx = C-1;
        int sy = D-1;

        int dx = E-1;
        int dy = F-1;

        Queue<Cell> q = new LinkedList<Cell>();
        q.add(new Cell(sx, sy, 0));
        board[sx][sy] = true;

        while (!q.isEmpty()) {
            Cell cell = q.remove();

            if (cell.row == dx && cell.col == dy) {
                return cell.dist;
            }

            for (Move m : moves) {
                if (0 <= cell.row + m.i && cell.row + m.i < A &&
                        0 <= cell.col + m.j && cell.col + m.j < B &&
                            !board[cell.row+m.i][cell.col+m.j]) {
                    q.add(new Cell(cell.row+m.i, cell.col+m.j, cell.dist+1));
                    board[cell.row+m.i][cell.col+m.j] = true;
                }
            }
        }

        return -1;
    }
}
