public class Nqueen {
    public static void main(String[] args) {
        int n=4;

        char board[][]=new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j]='.';
            }
        }

        nQueen(board,0);

    }

    public  static void nQueen(char[][] board, int row) {

        if(row==board.length)
        {
            printboard(board);
            return;
        }
       
        for (int j = 0; j < board.length; j++) {

            if(isTrue(board,row,j))
            {
                board[row][j]='Q';
            nQueen(board, row+1);
            board[row][j]='.';
            }
        }
    }

    public static boolean isTrue(char[][] board, int row, int col) {

        //up side
        for (int i = row-1; i >=0; i--) {
            if(board[i][col]=='Q')
            {
                return false;
            }
        }

        //up left
        for(int i=row-1 , j=col-1 ; i>=0 &&  j>=0;i--,j--)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }

        } 
        for(int i=row-1 , j=col+1 ; i>=0 &&  j<board.length;i--,j++)
        {
            if(board[i][j]=='Q')
            {
                return false;
            }

        } 

        return true;

    }

    public static void printboard(char[][]board)
    {
        System.out.println("--------------");
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
}
