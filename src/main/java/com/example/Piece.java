package com.example;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

public class Piece {
    protected boolean color;
    private BufferedImage img;

    public Piece(boolean color, String img_file) {
        this.color = color;
        try {
            if (this.img == null) {
                this.img = ImageIO.read(getClass().getResource(img_file));
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    //precondition: color is not null
    //postcondition: returns white and black
    public boolean getColor() {
        return color;
    }
    //precondition: image is not null
    //postcondition: return image
    public Image getImage() {
        return img;
    }

    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        g.drawImage(this.img, x, y, null);
    }

    public boolean kingIsInCheck(boolean turns)
    {
        /*  1. Find all pieces of the other color - ArrayList <Piece> 
         2. Loop through all the possible attacks and moves
         keyword: instanceof - to find out if variable stores the target
         [variable] instanceof [class] 
        */
       // 1st step
        ArrayList <Square> opponentsLocations = new ArrayList<>();
        for (int i = 0; i < 8; i++)
        {
            Square colorSquares = b.getSquareArray()[start.getRow()][start.getCol()];
            for (int j = 0; j < 8; j++)
            {
                if (colorSquares.isOccupied())
                {
                    if (this.color != colorSquares.getOccupyingPiece().getColor())
                    {
                        opponentsLocations.add(colorSquares);
                    }
                }
            }
        }
        return true; 
        //2nd step
        if ()
    }

    // to be overriden in each subclass
    public ArrayList<Square> getLegalMoves(Board b, Square currentSquare) {
        return null;
    }

    // make sure to override this!
    @Override
    public String toString() {
        if (color)
            return "white";
        else
            return "black";
    }

    // to be implemented by each subclass
    public ArrayList<Square> getControlledSquares(Square[][] board, Square currentSquare) {
        return null;
    }
}


//create a 