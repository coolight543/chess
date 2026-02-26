package com.example;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class Piece {
    private final boolean color;
    private BufferedImage img;
    private boolean isQueen = true;
    private int pieceTaken = 0;
    private boolean isBlocked = false; 
    
    public Piece(boolean isWhite, String img_file) {
        this.color = isWhite;
         
        try {
            if (this.img == null) {
                this.img = ImageIO.read(new File(System.getProperty("user.dir")+img_file));
            }
          } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
          }
    }
    
    

    
    public boolean getColor() {
        return color;
    }
    
    public Image getImage() {
        return img;
    }
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
     return null;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    public ArrayList<Square> getLegalMoves(Board b, Square start)
    {
        Square right = b.getSquareArray()[start.getRow()][start.getCol()];
        if (start.getCol() < 7)
        {
            right.getOccupyingPiece().getColor(); 
        }
        if (right.isOccupied() && right.getOccupyingPiece().getColor() != this.color) {
        
            // This is a legal move because it's occupied by an opponent's piece
            ArrayList<Square> legalMoves = new ArrayList<>();
            legalMoves.add(right);
            return legalMoves;
        }
        
        //Queen movements
        if (isQueen)
        {
            if (pieceTaken > 3)
            {
                isQueen = false; 
            }
            for (int i = start.getRow(); i < 8 && i >=0; i++)
            {
                for (int j = start.getCol(); j < 8 && j >=0; j++)
                {
                //if queen saw the same color, it can't move past its own piece
                if (this.color)
                {
                    break;
                }
                //if queen saw the opponent color, it can take the piece, but could not move pass
                if (!this.color && /*something.get != null */)
                {
                    pieceTaken++;
                    break;
                }
                //legalmoves.add(b.getSquareArray()[i][j])
                }
            
            }
        }
        //pawn movements
        else 
        {
            if (isBlocked)
            {
                break;
            }
            if (start.getRow() == 0)
            {
                isQueen = true; 
                pieceTaken = 0; 
            }

        }

       
    }
}
    
    
    
        
//--ddeadend
    // isQueen - is it still a queen
    // if isQueen - queen moves
    // if isNotQueen - pawn moves
    // eat - count++
    // move - pieceTaken 3 - check every time after move
    // 3- false
    // pawn to end - isQueen

/* 



        //track how many times the queen has taken a piece, and if it's taken 3 pieces, it can move like a pawn for the rest of the game.
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (queenHasTaken3Pieces) {
                    // Add knight moves to legalMoves
                    if (isLegalPawnMove(start, i, j)) {
                        legalMoves.add(b.getSquareArray()[i][j]);
                    }
                } else {
                    // Add regular queen moves to legalMoves
                    if (isLegalQueenMove(start, i, j)) {
                        legalMoves.add(b.getSquareArray()[i][j]);
                }   
            }
        }       
    	return null;
    }

public boolean queenHasTaken3Pieces() {
    // Implement logic to check if the queen has taken 3 pieces
    int piecesTakenCount = 0;
    for (Piece piece : piecesTaken) {
        if (piece.getColor() != this.color) {
            piecesTakenCount++;
            if (piecesTakenCount >= 3) {
                return true;
            }
        }
    }
    // This could involve tracking the number of pieces taken in a variable and returning true if it reaches 3
    return false; // Placeholder return value
} 
public boolean isLegalPawnMove(Square start, int row, int col) {
    // Implement logic to check if moving to (row, col) is a legal pawn move from the start square
    // This could involve checking if the move is one square forward (depending on the color of the piece) and if the target square is not occupied by a piece of the same color
    while(start.getRow() > 0) {
        if (this.color) { // If the piece is white
            if (row == start.getRow() - 1 && col == start.getCol() && !b.getSquareArray()[row][col].isOccupied()) {
                return true; // Legal move for white pawn
            }
        } else { // If the piece is black
            if (row == start.getRow() + 1 && col == start.getCol() && !b.getSquareArray()[row][col].isOccupied()) {
                return true; // Legal move for black pawn
            }
        }
    }
    return false; // Placeholder return value

    }  
}


 */
