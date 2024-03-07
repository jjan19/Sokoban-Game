//NAME: Janny Ly
//DATE STARTED: May 19, 2023
//DATE FINISHED: June 1, 2023
//PURPOSE: SOKOBAN

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.Applet;
import java.net.*;
import java.applet.*;
import java.io.*;

public class Sokoban_Adaptation extends Applet implements ActionListener
{
    Panel p_card;
    Panel card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12, card13, card14, card15, card16;
    CardLayout cdLayout = new CardLayout ();
    AudioClip soundFile;
    JLabel score, score2, score3, score4, score5;
    private Image backgroundImage;
    int level = 1;
    char newlevel = 'n';
    String member = "";
    String saved = "";


    JLabel a[] = new JLabel [7 * 7];
    JLabel a2[] = new JLabel [7 * 7];
    JLabel a3[] = new JLabel [7 * 7];
    JLabel a4[] = new JLabel [7 * 7];
    JLabel a5[] = new JLabel [7 * 7];

    int x = 4;
    int y = 2;
    int x1 = 4;
    int y1 = 2;
    int x2 = 3;
    int y2 = 1;
    int x3 = 5;
    int y3 = 4;
    int x4 = 2;
    int y4 = 1;
    char groundB[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'f', 'f', 'c', 'w', 'w'},
	    {'w', 'c', 'f', 'f', 'f', 'f', 'w'},
	    {'w', 'f', 'f', 'p', 'p', 'f', 'w'},
	    {'w', 'f', 'f', 'f', 'p', 'f', 'w'},
	    {'w', 'f', 'c', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topB[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'f', 'f', 'c', 'w', 'w'},
	    {'w', 'c', 'f', 'f', 'f', 'f', 'w'},
	    {'w', 'f', 'f', 'h', 'h', 'f', 'w'},
	    {'w', 'f', 'f', 'f', 'h', 'f', 'w'},
	    {'w', 'f', 'c', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};


    char groundB1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'f', 'f', 'c', 'w', 'w'},
	    {'w', 'c', 'f', 'f', 'f', 'f', 'w'},
	    {'w', 'f', 'f', 'p', 'p', 'f', 'w'},
	    {'w', 'f', 'f', 'f', 'p', 'f', 'w'},
	    {'w', 'f', 'c', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topB1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'f', 'f', 'c', 'w', 'w'},
	    {'w', 'c', 'f', 'f', 'f', 'f', 'w'},
	    {'w', 'f', 'f', 'h', 'h', 'f', 'w'},
	    {'w', 'f', 'f', 'f', 'h', 'f', 'w'},
	    {'w', 'f', 'c', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};



    char groundB2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'f', 'w', 'f', 'f', 'f', 'w'},
	    {'w', 'f', 'c', 'f', 'p', 'f', 'w'},
	    {'w', 'f', 'p', 'f', 'w', 'c', 'w'},
	    {'w', 'f', 'f', 'f', 'p', 'c', 'w'},
	    {'w', 'c', 'f', 'p', 'f', 'f', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topB2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'f', 'w', 'f', 'f', 'f', 'w'},
	    {'w', 'f', 'c', 'f', 'h', 'f', 'w'},
	    {'w', 'f', 'h', 'f', 'w', 'c', 'w'},
	    {'w', 'f', 'f', 'f', 'h', 'c', 'w'},
	    {'w', 'c', 'f', 'h', 'f', 'f', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};



    char groundB3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'c', 'p', 'f', 'f', 'f', 'w'},
	    {'w', 'f', 'f', 'p', 'f', 'c', 'w'},
	    {'w', 'f', 'c', 'f', 'f', 'w', 'w'},
	    {'w', 'p', 'p', 'f', 'p', 'f', 'w'},
	    {'w', 'c', 'w', 'f', 'f', 'c', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topB3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'c', 'h', 'f', 'f', 'f', 'w'},
	    {'w', 'f', 'f', 'h', 'f', 'c', 'w'},
	    {'w', 'f', 'c', 'f', 'f', 'w', 'w'},
	    {'w', 'h', 'h', 'f', 'h', 'f', 'w'},
	    {'w', 'c', 'w', 'f', 'f', 'c', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};



    char groundB4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'c', 'p', 'f', 'p', 'c', 'w'},
	    {'w', 'f', 'p', 'f', 'c', 'f', 'w'},
	    {'w', 'f', 'c', 'f', 'p', 'c', 'w'},
	    {'w', 'p', 'p', 'f', 'f', 'p', 'w'},
	    {'w', 'c', 'w', 'f', 'f', 'c', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topB4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'c', 'h', 'f', 'h', 'c', 'w'},
	    {'w', 'f', 'h', 'f', 'c', 'f', 'w'},
	    {'w', 'f', 'c', 'f', 'h', 'c', 'w'},
	    {'w', 'h', 'h', 'f', 'f', 'h', 'w'},
	    {'w', 'c', 'w', 'f', 'f', 'c', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};


    char groundH[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'g', 'g', 't', 'w', 'w'},
	    {'w', 't', 'g', 'g', 'g', 'g', 'w'},
	    {'w', 'g', 'g', 'b', 'b', 'g', 'w'},
	    {'w', 'g', 'g', 'g', 'b', 'g', 'w'},
	    {'w', 'g', 't', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topH[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'g', 'g', 't', 'w', 'w'},
	    {'w', 't', 'g', 'g', 'g', 'g', 'w'},
	    {'w', 'g', 'g', 'h', 'h', 'g', 'w'},
	    {'w', 'g', 'g', 'g', 'h', 'g', 'w'},
	    {'w', 'g', 't', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundH1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'g', 'g', 't', 'w', 'w'},
	    {'w', 't', 'g', 'g', 'g', 'g', 'w'},
	    {'w', 'g', 'g', 'b', 'b', 'g', 'w'},
	    {'w', 'g', 'g', 'g', 'b', 'g', 'w'},
	    {'w', 'g', 't', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topH1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'g', 'g', 't', 'w', 'w'},
	    {'w', 't', 'g', 'g', 'g', 'g', 'w'},
	    {'w', 'g', 'g', 'h', 'h', 'g', 'w'},
	    {'w', 'g', 'g', 'g', 'h', 'g', 'w'},
	    {'w', 'g', 't', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundH2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'g', 'w', 'g', 'g', 'g', 'w'},
	    {'w', 'g', 't', 'g', 'b', 'g', 'w'},
	    {'w', 'g', 'b', 'g', 'w', 't', 'w'},
	    {'w', 'g', 'g', 'g', 'b', 't', 'w'},
	    {'w', 't', 'g', 'b', 'g', 'g', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topH2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'g', 'w', 'g', 'g', 'g', 'w'},
	    {'w', 'g', 't', 'g', 'h', 'g', 'w'},
	    {'w', 'g', 'h', 'g', 'w', 't', 'w'},
	    {'w', 'g', 'g', 'g', 'h', 't', 'w'},
	    {'w', 't', 'g', 'h', 'g', 'g', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};


    char groundH3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 't', 'b', 'g', 'g', 'g', 'w'},
	    {'w', 'g', 'g', 'b', 'g', 't', 'w'},
	    {'w', 'g', 't', 'g', 'g', 'w', 'w'},
	    {'w', 'b', 'b', 'g', 'b', 'g', 'w'},
	    {'w', 't', 'w', 'g', 'g', 't', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topH3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 't', 'h', 'g', 'g', 'g', 'w'},
	    {'w', 'g', 'g', 'h', 'g', 't', 'w'},
	    {'w', 'g', 't', 'g', 'g', 'w', 'w'},
	    {'w', 'h', 'h', 'g', 'h', 'g', 'w'},
	    {'w', 't', 'w', 'g', 'g', 't', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundH4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 't', 'b', 'g', 'b', 't', 'w'},
	    {'w', 'g', 'b', 'g', 't', 'g', 'w'},
	    {'w', 'g', 't', 'g', 'b', 't', 'w'},
	    {'w', 'b', 'b', 'g', 'g', 'b', 'w'},
	    {'w', 't', 'w', 'g', 'g', 't', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topH4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 't', 'h', 'g', 'h', 't', 'w'},
	    {'w', 'g', 'h', 'g', 't', 'g', 'w'},
	    {'w', 'g', 't', 'g', 'h', 't', 'w'},
	    {'w', 'h', 'h', 'g', 'g', 'h', 'w'},
	    {'w', 't', 'w', 'g', 'g', 't', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundN[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'i', 'i', 'u', 'w', 'w'},
	    {'w', 'u', 'i', 'i', 'i', 'i', 'w'},
	    {'w', 'i', 'i', 'y', 'y', 'i', 'w'},
	    {'w', 'i', 'i', 'i', 'y', 'i', 'w'},
	    {'w', 'i', 'u', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topN[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'i', 'i', 'u', 'w', 'w'},
	    {'w', 'u', 'i', 'i', 'i', 'i', 'w'},
	    {'w', 'i', 'i', 'h', 'h', 'i', 'w'},
	    {'w', 'i', 'i', 'i', 'h', 'i', 'w'},
	    {'w', 'i', 'u', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundN1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'i', 'i', 'u', 'w', 'w'},
	    {'w', 'u', 'i', 'i', 'i', 'i', 'w'},
	    {'w', 'i', 'i', 'y', 'y', 'i', 'w'},
	    {'w', 'i', 'i', 'i', 'y', 'i', 'w'},
	    {'w', 'i', 'u', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topN1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'i', 'i', 'u', 'w', 'w'},
	    {'w', 'u', 'i', 'i', 'i', 'i', 'w'},
	    {'w', 'i', 'i', 'h', 'h', 'i', 'w'},
	    {'w', 'i', 'i', 'i', 'h', 'i', 'w'},
	    {'w', 'i', 'u', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundN2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'i', 'w', 'i', 'i', 'i', 'w'},
	    {'w', 'i', 'u', 'i', 'y', 'i', 'w'},
	    {'w', 'i', 'y', 'i', 'w', 'u', 'w'},
	    {'w', 'i', 'i', 'i', 'y', 'u', 'w'},
	    {'w', 'u', 'i', 'y', 'i', 'i', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topN2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'i', 'w', 'i', 'i', 'i', 'w'},
	    {'w', 'i', 'u', 'i', 'h', 'i', 'w'},
	    {'w', 'i', 'h', 'i', 'w', 'u', 'w'},
	    {'w', 'i', 'i', 'i', 'h', 'u', 'w'},
	    {'w', 'u', 'i', 'h', 'i', 'i', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};


    char groundN3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'u', 'y', 'i', 'i', 'i', 'w'},
	    {'w', 'i', 'i', 'y', 'i', 'u', 'w'},
	    {'w', 'i', 'u', 'i', 'i', 'w', 'w'},
	    {'w', 'y', 'y', 'i', 'y', 'i', 'w'},
	    {'w', 'u', 'w', 'i', 'i', 'u', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topN3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'u', 'h', 'i', 'i', 'i', 'w'},
	    {'w', 'i', 'i', 'h', 'i', 'u', 'w'},
	    {'w', 'i', 'u', 'i', 'i', 'w', 'w'},
	    {'w', 'h', 'h', 'i', 'h', 'i', 'w'},
	    {'w', 'u', 'w', 'i', 'i', 'u', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundN4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'u', 'y', 'i', 'y', 'u', 'w'},
	    {'w', 'i', 'y', 'i', 'u', 'i', 'w'},
	    {'w', 'i', 'u', 'i', 'y', 'u', 'w'},
	    {'w', 'y', 'y', 'i', 'i', 'y', 'w'},
	    {'w', 'u', 'w', 'i', 'i', 'u', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topN4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'u', 'h', 'i', 'h', 'u', 'w'},
	    {'w', 'i', 'h', 'i', 'u', 'i', 'w'},
	    {'w', 'i', 'u', 'i', 'h', 'u', 'w'},
	    {'w', 'h', 'h', 'i', 'i', 'h', 'w'},
	    {'w', 'u', 'w', 'i', 'i', 'u', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};


    char groundY[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'r', 'r', 'e', 'w', 'w'},
	    {'w', 'e', 'r', 'r', 'r', 'r', 'w'},
	    {'w', 'r', 'r', 'l', 'l', 'r', 'w'},
	    {'w', 'r', 'r', 'r', 'l', 'r', 'w'},
	    {'w', 'r', 'e', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topY[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'r', 'r', 'e', 'w', 'w'},
	    {'w', 'e', 'r', 'r', 'r', 'r', 'w'},
	    {'w', 'r', 'r', 'h', 'h', 'r', 'w'},
	    {'w', 'r', 'r', 'r', 'h', 'r', 'w'},
	    {'w', 'r', 'e', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundY1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'r', 'r', 'e', 'w', 'w'},
	    {'w', 'e', 'r', 'r', 'r', 'r', 'w'},
	    {'w', 'r', 'r', 'l', 'l', 'r', 'w'},
	    {'w', 'r', 'r', 'r', 'l', 'r', 'w'},
	    {'w', 'r', 'e', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topY1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'r', 'r', 'e', 'w', 'w'},
	    {'w', 'e', 'r', 'r', 'r', 'r', 'w'},
	    {'w', 'r', 'r', 'h', 'h', 'r', 'w'},
	    {'w', 'r', 'r', 'r', 'h', 'r', 'w'},
	    {'w', 'r', 'e', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundY2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'r', 'w', 'r', 'r', 'r', 'w'},
	    {'w', 'r', 'e', 'r', 'l', 'r', 'w'},
	    {'w', 'r', 'l', 'r', 'w', 'e', 'w'},
	    {'w', 'r', 'r', 'r', 'l', 'e', 'w'},
	    {'w', 'e', 'r', 'l', 'r', 'i', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topY2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'r', 'w', 'r', 'r', 'r', 'w'},
	    {'w', 'r', 'e', 'r', 'h', 'r', 'w'},
	    {'w', 'r', 'h', 'r', 'w', 'e', 'w'},
	    {'w', 'r', 'r', 'r', 'h', 'e', 'w'},
	    {'w', 'e', 'r', 'h', 'r', 'i', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};


    char groundY3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'e', 'l', 'r', 'r', 'r', 'w'},
	    {'w', 'r', 'r', 'l', 'r', 'e', 'w'},
	    {'w', 'r', 'e', 'r', 'r', 'w', 'w'},
	    {'w', 'l', 'l', 'r', 'l', 'r', 'w'},
	    {'w', 'e', 'w', 'r', 'r', 'e', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topY3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'e', 'h', 'r', 'r', 'r', 'w'},
	    {'w', 'r', 'r', 'h', 'r', 'e', 'w'},
	    {'w', 'r', 'e', 'r', 'r', 'w', 'w'},
	    {'w', 'h', 'h', 'r', 'h', 'r', 'w'},
	    {'w', 'e', 'w', 'r', 'r', 'e', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundY4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'e', 'l', 'r', 'l', 'e', 'w'},
	    {'w', 'r', 'l', 'r', 'e', 'r', 'w'},
	    {'w', 'r', 'e', 'r', 'l', 'e', 'w'},
	    {'w', 'l', 'l', 'r', 'r', 'l', 'w'},
	    {'w', 'e', 'w', 'r', 'r', 'e', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topY4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'e', 'h', 'r', 'h', 'e', 'w'},
	    {'w', 'r', 'h', 'r', 'e', 'r', 'w'},
	    {'w', 'r', 'e', 'r', 'h', 'e', 'w'},
	    {'w', 'h', 'h', 'r', 'r', 'h', 'w'},
	    {'w', 'e', 'w', 'r', 'r', 'e', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundE[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'j', 'j', 'k', 'w', 'w'},
	    {'w', 'k', 'j', 'j', 'j', 'j', 'w'},
	    {'w', 'j', 'j', 'd', 'd', 'j', 'w'},
	    {'w', 'j', 'j', 'j', 'd', 'j', 'w'},
	    {'w', 'j', 'k', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topE[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'j', 'j', 'k', 'w', 'w'},
	    {'w', 'k', 'j', 'j', 'j', 'j', 'w'},
	    {'w', 'j', 'j', 'h', 'h', 'j', 'w'},
	    {'w', 'j', 'j', 'j', 'h', 'j', 'w'},
	    {'w', 'j', 'k', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundE1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'j', 'j', 'k', 'w', 'w'},
	    {'w', 'k', 'j', 'j', 'j', 'j', 'w'},
	    {'w', 'j', 'j', 'd', 'd', 'j', 'w'},
	    {'w', 'j', 'j', 'j', 'd', 'j', 'w'},
	    {'w', 'j', 'k', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topE1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'j', 'j', 'k', 'w', 'w'},
	    {'w', 'k', 'j', 'j', 'j', 'j', 'w'},
	    {'w', 'j', 'j', 'h', 'h', 'j', 'w'},
	    {'w', 'j', 'j', 'j', 'h', 'j', 'w'},
	    {'w', 'j', 'k', 'w', 'w', 'w', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundE2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'j', 'w', 'j', 'j', 'j', 'w'},
	    {'w', 'j', 'k', 'j', 'd', 'j', 'w'},
	    {'w', 'j', 'd', 'j', 'w', 'k', 'w'},
	    {'w', 'j', 'j', 'j', 'd', 'k', 'w'},
	    {'w', 'k', 'j', 'd', 'j', 'j', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topE2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'j', 'w', 'j', 'j', 'j', 'w'},
	    {'w', 'j', 'k', 'j', 'h', 'j', 'w'},
	    {'w', 'j', 'h', 'j', 'w', 'k', 'w'},
	    {'w', 'j', 'j', 'j', 'h', 'k', 'w'},
	    {'w', 'k', 'j', 'h', 'j', 'j', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};


    char groundE3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'k', 'd', 'j', 'j', 'j', 'w'},
	    {'w', 'j', 'j', 'd', 'j', 'k', 'w'},
	    {'w', 'j', 'k', 'j', 'j', 'w', 'w'},
	    {'w', 'd', 'd', 'j', 'd', 'j', 'w'},
	    {'w', 'k', 'w', 'j', 'j', 'k', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topE3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'k', 'h', 'j', 'j', 'j', 'w'},
	    {'w', 'j', 'j', 'h', 'j', 'k', 'w'},
	    {'w', 'j', 'k', 'j', 'j', 'w', 'w'},
	    {'w', 'h', 'h', 'j', 'h', 'j', 'w'},
	    {'w', 'k', 'w', 'j', 'j', 'k', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char groundE4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'k', 'd', 'j', 'd', 'k', 'w'},
	    {'w', 'j', 'd', 'j', 'k', 'j', 'w'},
	    {'w', 'j', 'k', 'j', 'd', 'k', 'w'},
	    {'w', 'd', 'd', 'j', 'j', 'd', 'w'},
	    {'w', 'k', 'w', 'j', 'j', 'k', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    char topE4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w'},
	    {'w', 'k', 'h', 'j', 'h', 'k', 'w'},
	    {'w', 'j', 'h', 'j', 'k', 'j', 'w'},
	    {'w', 'j', 'k', 'j', 'h', 'k', 'w'},
	    {'w', 'h', 'h', 'j', 'j', 'h', 'w'},
	    {'w', 'k', 'w', 'j', 'j', 'k', 'w'},
	    {'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

    public void init ()
    {
	JOptionPane.showMessageDialog (null, "Creator: Janny Ly 2023 \n" + "Graphics by: Janny Ly 2023", "Credits", JOptionPane.PLAIN_MESSAGE);
	p_card = new Panel ();
	p_card.setLayout (cdLayout);
	opening ();
	characters ();
	bamby ();
	hamin ();
	noah ();
	yejun ();
	eunho ();
	game1 (level);
	game2 (level);
	game3 (level);
	game4 (level);
	game5 (level);
	
	resize (500, 680);
	setBackground (new Color (81, 26, 119));
	setLayout (new BorderLayout ());
	add ("Center", p_card);
    }

    class BackGroundPanel extends Panel
    {
	Image backGround;

	BackGroundPanel ()
	{
	    super ();
	}

	public void paint (Graphics g)
	{
	    g.drawImage (getBackGroundImage (), 0, 0,
		    (int) getBounds ().getWidth (), (int) getBounds ().getHeight (), this);
	}

	public void setBackGroundImage (Image backGround)
	{
	    this.backGround = backGround;
	}

	private Image getBackGroundImage ()
	{
	    return backGround;
	}
    }


    public void opening ()
    {
	card1 = new Panel ();
	card1.setBackground (new Color (81, 26, 119));
	Image backGround = getImage (getCodeBase (), "SOKOBAN.png");
	BackGroundPanel card1 = new BackGroundPanel ();
	card1.setBackGroundImage (backGround);
	card1.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton blank = new JButton (createImageIcon ("SOKOBAN2.png"));
	blank.setPreferredSize (new Dimension (502, 535));
	blank.setBorder (null);
	p.add (blank);


	Panel p2 = new Panel ();
	JButton lore = new JButton (createImageIcon ("LORE.png"));
	lore.setPreferredSize (new Dimension (50, 50));
	lore.setBorder (null);
	lore.addActionListener (this);
	lore.setActionCommand ("objective");
	p2.add (lore);

	JButton start = new JButton (createImageIcon ("START.png"));
	start.setPreferredSize (new Dimension (200, 50));
	start.setBorder (null);
	start.addActionListener (this);
	start.setActionCommand ("start");
	p2.add (start);

	JButton ins = new JButton (createImageIcon ("INSTRUCTION2.png"));
	ins.setPreferredSize (new Dimension (50, 50));
	ins.setBorder (null);
	ins.addActionListener (this);
	ins.setActionCommand ("instruction");
	p2.add (ins);

	card1.add (p);
	card1.add (p2);

	p_card.add ("1", card1);
    }


    public void instruction ()
    {
	String[] options = new String[]
	{
	    "EXIT", "NEXT"
	}
	;

	int option = JOptionPane.showOptionDialog (null, createImageIcon ("INSTRUCTION_SCREEN1.png"), "INSTRUCTIONS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options [0]);

	if (option == 0)
	{

	}
	else
	{
	    instruction2 ();
	}

    }


    public void instruction2 ()
    {
	String[] options = new String[]
	{
	    "BACK", "NEXT"
	}
	;

	//AN OPTIONPANE THAT HAS CUSTOM BUTTONS AND A PICTURE WHICH USE THE OPTIONS ARRAY AS THE BUTTONS
	int option = JOptionPane.showOptionDialog (null, createImageIcon ("INSTRUCTION_SCREEN2.png"), "INSTRUCTIONS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options [0]);

	//WILL LOOP THE SONG
	if (option == 0)
	{
	    instruction ();
	}
	else
	{
	    instruction3 ();
	}

    }


    public void instruction3 ()
    {
	String[] options = new String[]
	{
	    "BACK", "EXIT"
	}
	;

	//AN OPTIONPANE THAT HAS CUSTOM BUTTONS AND A PICTURE WHICH USE THE OPTIONS ARRAY AS THE BUTTONS
	int option = JOptionPane.showOptionDialog (null, createImageIcon ("INSTRUCTION_SCREEN3.png"), "INSTRUCTIONS", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options [0]);

	//WILL LOOP THE SONG
	if (option == 0)
	{
	    instruction2 ();
	}
	else
	{

	}

    }


    public void characters ()
    {
	card5 = new Panel ();
	card5.setBackground (new Color (81, 26, 119));
	Image backGround = getImage (getCodeBase (), "CHARACTER_SCREEN.png");
	BackGroundPanel card5 = new BackGroundPanel ();
	card5.setBackGroundImage (backGround);
	card5.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton blank = new JButton (createImageIcon ("BLANK4.png"));
	blank.setPreferredSize (new Dimension (501, 109));
	blank.setBorder (null);
	p.add (blank);

	Panel p2 = new Panel ();
	JButton bamby = new JButton (createImageIcon ("BAMBY.png"));
	bamby.setPreferredSize (new Dimension (240, 170));
	bamby.addActionListener (this);
	bamby.setActionCommand ("");
	bamby.addActionListener (this);
	bamby.setActionCommand ("bamby");
	p2.add (bamby);

	JButton hamin = new JButton (createImageIcon ("HAMIN.png"));
	hamin.setPreferredSize (new Dimension (240, 170));
	hamin.addActionListener (this);
	hamin.setActionCommand ("");
	hamin.addActionListener (this);
	hamin.setActionCommand ("hamin");
	p2.add (hamin);

	Panel p3 = new Panel ();
	JButton noah = new JButton (createImageIcon ("NOAH.png"));
	noah.setPreferredSize (new Dimension (240, 170));
	noah.addActionListener (this);
	noah.setActionCommand ("");
	noah.addActionListener (this);
	noah.setActionCommand ("noah");
	p3.add (noah);

	JButton yejun = new JButton (createImageIcon ("YEJUN.png"));
	yejun.setPreferredSize (new Dimension (240, 170));
	yejun.addActionListener (this);
	yejun.setActionCommand ("");
	yejun.addActionListener (this);
	yejun.setActionCommand ("yejun");
	p3.add (yejun);

	Panel p4 = new Panel ();
	JButton back = new JButton (createImageIcon ("BACK.png"));
	back.setPreferredSize (new Dimension (100, 50));
	back.setBorder (null);
	back.addActionListener (this);
	back.setActionCommand ("back1");
	p4.add (back);

	Panel p5 = new Panel ();
	JButton eunho = new JButton (createImageIcon ("EUNHO.png"));
	eunho.setPreferredSize (new Dimension (150, 170));
	eunho.addActionListener (this);
	eunho.setActionCommand ("");
	eunho.addActionListener (this);
	eunho.setActionCommand ("eunho");
	p5.add (eunho);

	Panel p6 = new Panel ();
	JButton blank2 = new JButton (createImageIcon ("BLANK10.png"));
	blank2.setPreferredSize (new Dimension (100, 173));
	blank2.setBorder (null);
	p6.add (blank2);

	card5.add (p);
	card5.add (p2);
	card5.add (p3);
	card5.add (p4);
	card5.add (p5);
	card5.add (p6);
	p_card.add ("5", card5);
    }


    public void bamby ()
    {
	card6 = new Panel ();
	card6.setBackground (new Color (81, 26, 119));
	Image backGround = getImage (getCodeBase (), "BAMBY_SCREEN.png");
	BackGroundPanel card6 = new BackGroundPanel ();
	card6.setBackGroundImage (backGround);
	card6.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton blank = new JButton (createImageIcon ("BLANK5.png"));
	blank.setPreferredSize (new Dimension (499, 516));
	blank.setBorder (null);
	p.add (blank);

	Panel p2 = new Panel ();
	JButton back = new JButton (createImageIcon ("BACK.png"));
	back.setPreferredSize (new Dimension (100, 50));
	back.setBorder (null);
	back.addActionListener (this);
	back.setActionCommand ("back4");
	p2.add (back);

	JButton next = new JButton (createImageIcon ("NEXT.png"));
	next.setPreferredSize (new Dimension (100, 50));
	next.setBorder (null);
	next.addActionListener (this);
	next.setActionCommand ("bgame");
	p2.add (next);

	card6.add (p);
	card6.add (p2);
	p_card.add ("6", card6);
    }


    public void hamin ()
    {
	card7 = new Panel ();
	card7.setBackground (new Color (81, 26, 119));
	Image backGround = getImage (getCodeBase (), "HAMIN_SCREEN.png");
	BackGroundPanel card7 = new BackGroundPanel ();
	card7.setBackGroundImage (backGround);
	card7.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton blank = new JButton (createImageIcon ("BLANK6.png"));
	blank.setPreferredSize (new Dimension (501, 516));
	blank.setBorder (null);
	p.add (blank);

	Panel p2 = new Panel ();
	JButton back = new JButton (createImageIcon ("BACK.png"));
	back.setPreferredSize (new Dimension (100, 50));
	back.setBorder (null);
	back.addActionListener (this);
	back.setActionCommand ("back4");
	p2.add (back);

	JButton next = new JButton (createImageIcon ("NEXT.png"));
	next.setPreferredSize (new Dimension (100, 50));
	next.setBorder (null);
	next.addActionListener (this);
	next.setActionCommand ("hgame");
	p2.add (next);

	card7.add (p);
	card7.add (p2);
	p_card.add ("7", card7);
    }


    public void noah ()
    {
	card8 = new Panel ();
	card8.setBackground (new Color (81, 26, 119));
	Image backGround = getImage (getCodeBase (), "NOAH_SCREEN.png");
	BackGroundPanel card8 = new BackGroundPanel ();
	card8.setBackGroundImage (backGround);
	card8.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton blank = new JButton (createImageIcon ("BLANK7.png"));
	blank.setPreferredSize (new Dimension (501, 516));
	blank.setBorder (null);
	p.add (blank);

	Panel p2 = new Panel ();
	JButton back = new JButton (createImageIcon ("BACK.png"));
	back.setPreferredSize (new Dimension (100, 50));
	back.setBorder (null);
	back.addActionListener (this);
	back.setActionCommand ("back4");
	p2.add (back);

	JButton next = new JButton (createImageIcon ("NEXT.png"));
	next.setPreferredSize (new Dimension (100, 50));
	next.setBorder (null);
	next.addActionListener (this);
	next.setActionCommand ("ngame");
	p2.add (next);

	card8.add (p);
	card8.add (p2);
	p_card.add ("8", card8);
    }


    public void yejun ()
    {
	card9 = new Panel ();
	card9.setBackground (new Color (81, 26, 119));
	Image backGround = getImage (getCodeBase (), "YEJUN_SCREEN.png");
	BackGroundPanel card9 = new BackGroundPanel ();
	card9.setBackGroundImage (backGround);
	card9.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton blank = new JButton (createImageIcon ("BLANK8.png"));
	blank.setPreferredSize (new Dimension (501, 516));
	blank.setBorder (null);
	p.add (blank);

	Panel p2 = new Panel ();
	JButton back = new JButton (createImageIcon ("BACK.png"));
	back.setPreferredSize (new Dimension (100, 50));
	back.setBorder (null);
	back.addActionListener (this);
	back.setActionCommand ("back4");
	p2.add (back);

	JButton next = new JButton (createImageIcon ("NEXT.png"));
	next.setPreferredSize (new Dimension (100, 50));
	next.setBorder (null);
	next.addActionListener (this);
	next.setActionCommand ("ygame");
	p2.add (next);

	card9.add (p);
	card9.add (p2);
	p_card.add ("9", card9);
    }


    public void eunho ()
    {
	card10 = new Panel ();
	card10.setBackground (new Color (81, 26, 119));
	Image backGround = getImage (getCodeBase (), "EUNHO_SCREEN.png");
	BackGroundPanel card10 = new BackGroundPanel ();
	card10.setBackGroundImage (backGround);
	card10.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton blank = new JButton (createImageIcon ("BLANK9.png"));
	blank.setPreferredSize (new Dimension (501, 517));
	blank.setBorder (null);
	p.add (blank);

	Panel p2 = new Panel ();
	JButton back = new JButton (createImageIcon ("BACK.png"));
	back.setPreferredSize (new Dimension (100, 50));
	back.setBorder (null);
	back.addActionListener (this);
	back.setActionCommand ("back4");
	p2.add (back);

	JButton next = new JButton (createImageIcon ("NEXT.png"));
	next.setPreferredSize (new Dimension (100, 50));
	next.setBorder (null);
	next.addActionListener (this);
	next.setActionCommand ("egame");
	p2.add (next);

	card10.add (p);
	card10.add (p2);
	p_card.add ("10", card10);
    }


    public void game1 (int level)
    {
	card11 = new Panel ();
	card11.setBackground (new Color (11, 44, 69));
	Image backGround = getImage (getCodeBase (), "BACKGROUND1.png");
	BackGroundPanel card11 = new BackGroundPanel ();
	card11.setBackGroundImage (backGround);
	card11.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton reset = new JButton (createImageIcon ("RESET.png"));
	reset.setPreferredSize (new Dimension (75, 75));
	reset.setBorder (null);
	reset.addActionListener (this);
	reset.setActionCommand ("resetbamby");
	p.add (reset);

	JButton title = new JButton (createImageIcon ("PIXEL WORLD.png"));
	title.setPreferredSize (new Dimension (300, 75));
	title.setBorder (null);
	p.add (title);

	JButton next = new JButton (createImageIcon ("NEXTLEVEL.png"));
	next.setPreferredSize (new Dimension (75, 75));
	next.setBorder (null);
	next.addActionListener (this);
	next.setActionCommand ("nextbamby");
	p.add (next);

	Panel p2 = new Panel ();
	score = new JLabel ("Level: " + level);
	score.setFont (new Font ("Arial", Font.BOLD, 20));
	score.setForeground (Color.WHITE);
	p2.add (score);

	Panel p3 = new Panel (new GridLayout (7, 7));
	int move = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		a [move] = new JLabel (createImageIcon (groundB [i] [j] + "" + topB [i] [j] + ".png"));
		a [move].setPreferredSize (new Dimension (60, 60));
		p3.add (a [move]);
		move++;
	    }
	}

	a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "downbamby.png"));

	Panel p4 = new Panel ();
	JButton lore = new JButton (createImageIcon ("LORE.png"));
	lore.setPreferredSize (new Dimension (50, 50));
	lore.setBorder (null);
	lore.addActionListener (this);
	lore.setActionCommand ("objective");
	p4.add (lore);

	JButton blank1 = new JButton (createImageIcon ("BLANK11.png"));
	blank1.setPreferredSize (new Dimension (131, 50));
	blank1.setBorder (null);
	p4.add (blank1);

	JButton up = new JButton (createImageIcon ("UP.png"));
	up.setPreferredSize (new Dimension (50, 50));
	up.setBorder (null);
	up.addActionListener (this);
	up.setActionCommand ("up");
	p4.add (up);

	JButton blank2 = new JButton (createImageIcon ("BLANK12.png"));
	blank2.setPreferredSize (new Dimension (131, 50));
	blank2.setBorder (null);
	p4.add (blank2);

	JButton ins = new JButton (createImageIcon ("GAMEINSTRUCTION.png"));
	ins.setPreferredSize (new Dimension (50, 50));
	ins.setBorder (null);
	ins.addActionListener (this);
	ins.setActionCommand ("instruction");
	p4.add (ins);

	Panel p5 = new Panel ();
	JButton left = new JButton (createImageIcon ("LEFT.png"));
	left.setPreferredSize (new Dimension (50, 50));
	left.setBorder (null);
	left.addActionListener (this);
	left.setActionCommand ("left");
	p5.add (left);

	JButton down = new JButton (createImageIcon ("DOWN.png"));
	down.setPreferredSize (new Dimension (50, 50));
	down.setBorder (null);
	down.addActionListener (this);
	down.setActionCommand ("down");
	p5.add (down);

	JButton right = new JButton (createImageIcon ("RIGHT.png"));
	right.setPreferredSize (new Dimension (50, 50));
	right.setBorder (null);
	right.addActionListener (this);
	right.setActionCommand ("right");
	p5.add (right);

	card11.add (p);
	card11.add (p2);
	card11.add (p3);
	card11.add (p4);
	card11.add (p5);
	p_card.add ("11", card11);
    }


    public void game2 (int level)
    {
	card12 = new Panel ();
	card12.setBackground (new Color (11, 44, 69));
	Image backGround = getImage (getCodeBase (), "BACKGROUND1.png");
	BackGroundPanel card12 = new BackGroundPanel ();
	card12.setBackGroundImage (backGround);
	card12.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton reset = new JButton (createImageIcon ("RESET.png"));
	reset.setPreferredSize (new Dimension (75, 75));
	reset.setBorder (null);
	reset.addActionListener (this);
	reset.setActionCommand ("resethamin");
	p.add (reset);

	JButton title = new JButton (createImageIcon ("PIXEL WORLD.png"));
	title.setPreferredSize (new Dimension (300, 75));
	title.setBorder (null);
	p.add (title);

	JButton next = new JButton (createImageIcon ("NEXTLEVEL.png"));
	next.setPreferredSize (new Dimension (75, 75));
	next.setBorder (null);
	next.addActionListener (this);
	next.setActionCommand ("nexthamin");
	p.add (next);

	Panel p2 = new Panel ();
	score2 = new JLabel ("Level: " + level);
	score2.setFont (new Font ("Arial", Font.BOLD, 20));
	score2.setForeground (Color.WHITE);
	p2.add (score2);

	Panel p3 = new Panel (new GridLayout (7, 7));
	int move = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		a2 [move] = new JLabel (createImageIcon (groundH [i] [j] + "" + topH [i] [j] + ".png"));
		a2 [move].setPreferredSize (new Dimension (60, 60));
		p3.add (a2 [move]);
		move++;
	    }
	}

	a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "downhamin.png"));

	Panel p4 = new Panel ();
	JButton lore = new JButton (createImageIcon ("LORE.png"));
	lore.setPreferredSize (new Dimension (50, 50));
	lore.setBorder (null);
	lore.addActionListener (this);
	lore.setActionCommand ("objective");
	p4.add (lore);

	JButton blank1 = new JButton (createImageIcon ("BLANK11.png"));
	blank1.setPreferredSize (new Dimension (131, 50));
	blank1.setBorder (null);
	p4.add (blank1);

	JButton up = new JButton (createImageIcon ("UP.png"));
	up.setPreferredSize (new Dimension (50, 50));
	up.setBorder (null);
	up.addActionListener (this);
	up.setActionCommand ("up2");
	p4.add (up);

	JButton blank2 = new JButton (createImageIcon ("BLANK12.png"));
	blank2.setPreferredSize (new Dimension (131, 50));
	blank2.setBorder (null);
	p4.add (blank2);

	JButton ins = new JButton (createImageIcon ("GAMEINSTRUCTION.png"));
	ins.setPreferredSize (new Dimension (50, 50));
	ins.setBorder (null);
	ins.addActionListener (this);
	ins.setActionCommand ("instruction");
	p4.add (ins);

	Panel p5 = new Panel ();
	JButton left = new JButton (createImageIcon ("LEFT.png"));
	left.setPreferredSize (new Dimension (50, 50));
	left.setBorder (null);
	left.addActionListener (this);
	left.setActionCommand ("left2");
	p5.add (left);

	JButton down = new JButton (createImageIcon ("DOWN.png"));
	down.setPreferredSize (new Dimension (50, 50));
	down.setBorder (null);
	down.addActionListener (this);
	down.setActionCommand ("down2");
	p5.add (down);

	JButton right = new JButton (createImageIcon ("RIGHT.png"));
	right.setPreferredSize (new Dimension (50, 50));
	right.setBorder (null);
	right.addActionListener (this);
	right.setActionCommand ("right2");
	p5.add (right);

	card12.add (p);
	card12.add (p2);
	card12.add (p3);
	card12.add (p4);
	card12.add (p5);
	p_card.add ("12", card12);
    }


    public void game3 (int level)
    {
	card13 = new Panel ();
	card13.setBackground (new Color (11, 44, 69));
	Image backGround = getImage (getCodeBase (), "BACKGROUND1.png");
	BackGroundPanel card13 = new BackGroundPanel ();
	card13.setBackGroundImage (backGround);
	card13.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton reset = new JButton (createImageIcon ("RESET.png"));
	reset.setPreferredSize (new Dimension (75, 75));
	reset.setBorder (null);
	reset.addActionListener (this);
	reset.setActionCommand ("resetnoah");
	p.add (reset);

	JButton title = new JButton (createImageIcon ("PIXEL WORLD.png"));
	title.setPreferredSize (new Dimension (300, 75));
	title.setBorder (null);
	p.add (title);

	JButton next = new JButton (createImageIcon ("NEXTLEVEL.png"));
	next.setPreferredSize (new Dimension (75, 75));
	next.setBorder (null);
	next.addActionListener (this);
	next.setActionCommand ("nextnoah");
	p.add (next);

	Panel p2 = new Panel ();
	score3 = new JLabel ("Level: " + level);
	score3.setFont (new Font ("Arial", Font.BOLD, 20));
	score3.setForeground (Color.WHITE);
	p2.add (score3);

	Panel p3 = new Panel (new GridLayout (7, 7));
	int move = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		a3 [move] = new JLabel (createImageIcon (groundN [i] [j] + "" + topN [i] [j] + ".png"));
		a3 [move].setPreferredSize (new Dimension (60, 60));
		p3.add (a3 [move]);
		move++;
	    }
	}

	a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "downnoah.png"));

	Panel p4 = new Panel ();
	JButton lore = new JButton (createImageIcon ("LORE.png"));
	lore.setPreferredSize (new Dimension (50, 50));
	lore.setBorder (null);
	lore.addActionListener (this);
	lore.setActionCommand ("objective");
	p4.add (lore);

	JButton blank1 = new JButton (createImageIcon ("BLANK11.png"));
	blank1.setPreferredSize (new Dimension (131, 50));
	blank1.setBorder (null);
	p4.add (blank1);

	JButton up = new JButton (createImageIcon ("UP.png"));
	up.setPreferredSize (new Dimension (50, 50));
	up.setBorder (null);
	up.addActionListener (this);
	up.setActionCommand ("up3");
	p4.add (up);

	JButton blank2 = new JButton (createImageIcon ("BLANK12.png"));
	blank2.setPreferredSize (new Dimension (131, 50));
	blank2.setBorder (null);
	p4.add (blank2);

	JButton ins = new JButton (createImageIcon ("GAMEINSTRUCTION.png"));
	ins.setPreferredSize (new Dimension (50, 50));
	ins.setBorder (null);
	ins.addActionListener (this);
	ins.setActionCommand ("instruction");
	p4.add (ins);

	Panel p5 = new Panel ();
	JButton left = new JButton (createImageIcon ("LEFT.png"));
	left.setPreferredSize (new Dimension (50, 50));
	left.setBorder (null);
	left.addActionListener (this);
	left.setActionCommand ("left3");
	p5.add (left);

	JButton down = new JButton (createImageIcon ("DOWN.png"));
	down.setPreferredSize (new Dimension (50, 50));
	down.setBorder (null);
	down.addActionListener (this);
	down.setActionCommand ("down3");
	p5.add (down);

	JButton right = new JButton (createImageIcon ("RIGHT.png"));
	right.setPreferredSize (new Dimension (50, 50));
	right.setBorder (null);
	right.addActionListener (this);
	right.setActionCommand ("right3");
	p5.add (right);

	card13.add (p);
	card13.add (p2);
	card13.add (p3);
	card13.add (p4);
	card13.add (p5);
	p_card.add ("13", card13);
    }


    public void game4 (int level)
    {
	card14 = new Panel ();
	card14.setBackground (new Color (11, 44, 69));
	Image backGround = getImage (getCodeBase (), "BACKGROUND1.png");
	BackGroundPanel card14 = new BackGroundPanel ();
	card14.setBackGroundImage (backGround);
	card14.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton reset = new JButton (createImageIcon ("RESET.png"));
	reset.setPreferredSize (new Dimension (75, 75));
	reset.setBorder (null);
	reset.addActionListener (this);
	reset.setActionCommand ("resetyejun");
	p.add (reset);

	JButton title = new JButton (createImageIcon ("PIXEL WORLD.png"));
	title.setPreferredSize (new Dimension (300, 75));
	title.setBorder (null);
	p.add (title);

	JButton next = new JButton (createImageIcon ("NEXTLEVEL.png"));
	next.setPreferredSize (new Dimension (75, 75));
	next.setBorder (null);
	next.addActionListener (this);
	next.setActionCommand ("nextyejun");
	p.add (next);

	Panel p2 = new Panel ();
	score4 = new JLabel ("Level: " + level);
	score4.setFont (new Font ("Arial", Font.BOLD, 20));
	score4.setForeground (Color.WHITE);
	p2.add (score4);

	Panel p3 = new Panel (new GridLayout (7, 7));
	int move = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		a4 [move] = new JLabel (createImageIcon (groundY [i] [j] + "" + topY [i] [j] + ".png"));
		a4 [move].setPreferredSize (new Dimension (60, 60));
		p3.add (a4 [move]);
		move++;
	    }
	}

	a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "downyejun.png"));

	Panel p4 = new Panel ();
	JButton lore = new JButton (createImageIcon ("LORE.png"));
	lore.setPreferredSize (new Dimension (50, 50));
	lore.setBorder (null);
	lore.addActionListener (this);
	lore.setActionCommand ("objective");
	p4.add (lore);;

	JButton blank1 = new JButton (createImageIcon ("BLANK11.png"));
	blank1.setPreferredSize (new Dimension (131, 50));
	blank1.setBorder (null);
	p4.add (blank1);

	JButton up = new JButton (createImageIcon ("UP.png"));
	up.setPreferredSize (new Dimension (50, 50));
	up.setBorder (null);
	up.addActionListener (this);
	up.setActionCommand ("up4");
	p4.add (up);

	JButton blank2 = new JButton (createImageIcon ("BLANK12.png"));
	blank2.setPreferredSize (new Dimension (131, 50));
	blank2.setBorder (null);
	p4.add (blank2);

	JButton ins = new JButton (createImageIcon ("GAMEINSTRUCTION.png"));
	ins.setPreferredSize (new Dimension (50, 50));
	ins.setBorder (null);
	ins.addActionListener (this);
	ins.setActionCommand ("instruction");
	p4.add (ins);

	Panel p5 = new Panel ();
	JButton left = new JButton (createImageIcon ("LEFT.png"));
	left.setPreferredSize (new Dimension (50, 50));
	left.setBorder (null);
	left.addActionListener (this);
	left.setActionCommand ("left4");
	p5.add (left);

	JButton down = new JButton (createImageIcon ("DOWN.png"));
	down.setPreferredSize (new Dimension (50, 50));
	down.setBorder (null);
	down.addActionListener (this);
	down.setActionCommand ("down4");
	p5.add (down);

	JButton right = new JButton (createImageIcon ("RIGHT.png"));
	right.setPreferredSize (new Dimension (50, 50));
	right.setBorder (null);
	right.addActionListener (this);
	right.setActionCommand ("right4");
	p5.add (right);

	card14.add (p);
	card14.add (p2);
	card14.add (p3);
	card14.add (p4);
	card14.add (p5);
	p_card.add ("14", card14);
    }


    public void game5 (int level)
    {
	card15 = new Panel ();
	card15.setBackground (new Color (11, 44, 69));
	Image backGround = getImage (getCodeBase (), "BACKGROUND1.png");
	BackGroundPanel card15 = new BackGroundPanel ();
	card15.setBackGroundImage (backGround);
	card15.setLayout (new FlowLayout ());
	setLayout (new BorderLayout ());

	Panel p = new Panel ();
	JButton reset = new JButton (createImageIcon ("RESET.png"));
	reset.setPreferredSize (new Dimension (75, 75));
	reset.setBorder (null);
	reset.addActionListener (this);
	reset.setActionCommand ("reseteunho");
	p.add (reset);

	JButton title = new JButton (createImageIcon ("PIXEL WORLD.png"));
	title.setPreferredSize (new Dimension (300, 75));
	title.setBorder (null);
	p.add (title);

	JButton next = new JButton (createImageIcon ("NEXTLEVEL.png"));
	next.setPreferredSize (new Dimension (75, 75));
	next.setBorder (null);
	next.addActionListener (this);
	next.setActionCommand ("nexteunho");
	p.add (next);

	Panel p2 = new Panel ();
	score5 = new JLabel ("Level: " + level);
	score5.setFont (new Font ("Arial", Font.BOLD, 20));
	score5.setForeground (Color.WHITE);
	p2.add (score5);

	Panel p3 = new Panel (new GridLayout (7, 7));
	int move = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		a5 [move] = new JLabel (createImageIcon (groundE [i] [j] + "" + topE [i] [j] + ".png"));
		a5 [move].setPreferredSize (new Dimension (60, 60));
		p3.add (a5 [move]);
		move++;
	    }
	}

	a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "downeunho.png"));

	Panel p4 = new Panel ();
	JButton lore = new JButton (createImageIcon ("LORE.png"));
	lore.setPreferredSize (new Dimension (50, 50));
	lore.setBorder (null);
	lore.addActionListener (this);
	lore.setActionCommand ("objective");
	p4.add (lore);

	JButton blank1 = new JButton (createImageIcon ("BLANK11.png"));
	blank1.setPreferredSize (new Dimension (131, 50));
	blank1.setBorder (null);
	p4.add (blank1);

	JButton up = new JButton (createImageIcon ("UP.png"));
	up.setPreferredSize (new Dimension (50, 50));
	up.setBorder (null);
	up.addActionListener (this);
	up.setActionCommand ("up5");
	p4.add (up);

	JButton blank2 = new JButton (createImageIcon ("BLANK12.png"));
	blank2.setPreferredSize (new Dimension (131, 50));
	blank2.setBorder (null);
	p4.add (blank2);

	JButton ins = new JButton (createImageIcon ("GAMEINSTRUCTION.png"));
	ins.setPreferredSize (new Dimension (50, 50));
	ins.setBorder (null);
	ins.addActionListener (this);
	ins.setActionCommand ("instruction");
	p4.add (ins);

	Panel p5 = new Panel ();
	JButton left = new JButton (createImageIcon ("LEFT.png"));
	left.setPreferredSize (new Dimension (50, 50));
	left.setBorder (null);
	left.addActionListener (this);
	left.setActionCommand ("left5");
	p5.add (left);

	JButton down = new JButton (createImageIcon ("DOWN.png"));
	down.setPreferredSize (new Dimension (50, 50));
	down.setBorder (null);
	down.addActionListener (this);
	down.setActionCommand ("down5");
	p5.add (down);

	JButton right = new JButton (createImageIcon ("RIGHT.png"));
	right.setPreferredSize (new Dimension (50, 50));
	right.setBorder (null);
	right.addActionListener (this);
	right.setActionCommand ("right5");
	p5.add (right);

	card15.add (p);
	card15.add (p2);
	card15.add (p3);
	card15.add (p4);
	card15.add (p5);
	p_card.add ("15", card15);
    }

    public boolean winBamby ()
    {
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		if (groundB [i] [j] == 'c' && topB [i] [j] == 'c')
		    return false;
	    }
	}
	return true;
    }


    public boolean winHamin ()
    {
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		if (groundH [i] [j] == 't' && topH [i] [j] == 't')
		    return false;
	    }
	}
	return true;
    }


    public boolean winNoah ()
    {
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		if (groundN [i] [j] == 'u' && topN [i] [j] == 'u')
		    return false;
	    }
	}
	return true;
    }


    public boolean winYejun ()
    {
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		if (groundY [i] [j] == 'e' && topY [i] [j] == 'e')
		    return false;
	    }
	}
	return true;
    }


    public boolean winEunho ()
    {
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		if (groundE [i] [j] == 'k' && topE [i] [j] == 'k')
		    return false;
	    }
	}
	return true;
    }


    public void redrawBamby ()
    {
	int move = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		a [move].setIcon (createImageIcon (groundB [i] [j] + "" + topB [i] [j] + ".png"));
		move++;
	    }
	}
    }


    public void redrawHamin ()
    {
	int move = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		a2 [move].setIcon (createImageIcon (groundH [i] [j] + "" + topH [i] [j] + ".png"));
		move++;
	    }
	}
    }


    public void redrawNoah ()
    {
	int move = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		a3 [move].setIcon (createImageIcon (groundN [i] [j] + "" + topN [i] [j] + ".png"));
		move++;
	    }
	}
    }


    public void redrawYejun ()
    {
	int move = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		a4 [move].setIcon (createImageIcon (groundY [i] [j] + "" + topY [i] [j] + ".png"));
		move++;
	    }
	}
    }


    public void redrawEunho ()
    {
	int move = 0;
	for (int i = 0 ; i < 7 ; i++)
	{
	    for (int j = 0 ; j < 7 ; j++)
	    {
		a5 [move].setIcon (createImageIcon (groundE [i] [j] + "" + topE [i] [j] + ".png"));
		move++;
	    }
	}
    }


    public void copyOverBamby (char a[] [], char b[] [])
    {
	if (member == "bamby")
	{
	    for (int i = 0 ; i < 7 ; i++)
	    {
		for (int j = 0 ; j < 7 ; j++)
		{
		    a [i] [j] = b [i] [j];
		}
	    }
	}
    }


    public void copyOverHamin (char a[] [], char b[] [])
    {
	if (member == "hamin")
	{
	    for (int i = 0 ; i < 7 ; i++)
	    {
		for (int j = 0 ; j < 7 ; j++)
		{
		    a [i] [j] = b [i] [j];
		}
	    }
	}
    }


    public void copyOverNoah (char a[] [], char b[] [])
    {
	if (member == "noah")
	{
	    for (int i = 0 ; i < 7 ; i++)
	    {
		for (int j = 0 ; j < 7 ; j++)
		{
		    a [i] [j] = b [i] [j];
		}
	    }
	}
    }


    public void copyOverYejun (char a[] [], char b[] [])
    {
	if (member == "yejun")
	{
	    for (int i = 0 ; i < 7 ; i++)
	    {
		for (int j = 0 ; j < 7 ; j++)
		{
		    a [i] [j] = b [i] [j];
		}
	    }
	}
    }


    public void copyOverEunho (char a[] [], char b[] [])
    {
	if (member == "eunho")
	{
	    for (int i = 0 ; i < 7 ; i++)
	    {
		for (int j = 0 ; j < 7 ; j++)
		{
		    a [i] [j] = b [i] [j];
		}
	    }
	}
    }


    public void nextlevelBamby ()
    {
	if (member == "bamby")
	{
	    while (newlevel == 'y')
	    {
		level++;
		if (level == 1)
		{
		    copyOverBamby (groundB, groundB1);
		    copyOverBamby (topB, topB1);
		    x = x1;
		    y = y1;
		    level = 1;
		    newlevel = 'n';
		}
		else if (level == 2)
		{
		    copyOverBamby (groundB, groundB2);
		    copyOverBamby (topB, topB2);
		    x = x2;
		    y = y2;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVENOAH.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		else if (level == 3)
		{
		    copyOverBamby (groundB, groundB3);
		    copyOverBamby (topB, topB3);
		    x = x3;
		    y = y3;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEYEJUN.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		else if (level == 4)
		{
		    copyOverBamby (groundB, groundB4);
		    copyOverBamby (topB, topB4);
		    x = x4;
		    y = y4;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEEUNHO.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		redrawBamby ();
		a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "downbamby.png"));
	    }
	    showStatus ("To go to the next level, you must complete level " + level);
	}
    }


    public void nextlevelHamin ()
    {
	if (member == "hamin")
	{
	    while (newlevel == 'y')
	    {
		level++;
		if (level == 1)
		{
		    copyOverHamin (groundH, groundH1);
		    copyOverHamin (topH, topH1);
		    x = x1;
		    y = y1;
		    level = 1;
		    newlevel = 'n';
		}
		else if (level == 2)
		{
		    copyOverHamin (groundH, groundH2);
		    copyOverHamin (topH, topH2);
		    x = x2;
		    y = y2;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVENOAH.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		else if (level == 3)
		{
		    copyOverHamin (groundH, groundH3);
		    copyOverHamin (topH, topH3);
		    x = x3;
		    y = y3;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEYEJUN.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		else if (level == 4)
		{
		    copyOverHamin (groundH, groundH4);
		    copyOverHamin (topH, topH4);
		    x = x4;
		    y = y4;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEEUNHO.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		redrawHamin ();
		a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "downhamin.png"));
	    }
	    showStatus ("To go to the next level, you must complete level " + level);
	}
    }


    public void nextlevelNoah ()
    {
	if (member == "noah")
	{
	    while (newlevel == 'y')
	    {
		level++;
		if (level == 1)
		{
		    copyOverNoah (groundN, groundN1);
		    copyOverNoah (topN, topN1);
		    x = x1;
		    y = y1;
		    level = 1;
		    newlevel = 'n';
		}
		else if (level == 2)
		{
		    copyOverNoah (groundN, groundN2);
		    copyOverNoah (topN, topN2);
		    x = x2;
		    y = y2;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEHAMIN.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		else if (level == 3)
		{
		    copyOverNoah (groundN, groundN3);
		    copyOverNoah (topN, topN3);
		    x = x3;
		    y = y3;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEYEJUN.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		else if (level == 4)
		{
		    copyOverNoah (groundN, groundN4);
		    copyOverNoah (topN, topN4);
		    x = x4;
		    y = y4;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEEUNHO.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		redrawNoah ();
		a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "downnoah.png"));
	    }
	    showStatus ("To go to the next level, you must complete level " + level);
	}
    }


    public void nextlevelYejun ()
    {
	if (member == "yejun")
	{
	    while (newlevel == 'y')
	    {
		level++;
		if (level == 1)
		{
		    copyOverYejun (groundY, groundY1);
		    copyOverYejun (topY, topY1);
		    x = x1;
		    y = y1;
		    level = 1;
		    newlevel = 'n';
		}
		else if (level == 2)
		{
		    copyOverYejun (groundY, groundY2);
		    copyOverYejun (topY, topY2);
		    x = x2;
		    y = y2;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEHAMIN.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		else if (level == 3)
		{
		    copyOverYejun (groundY, groundY3);
		    copyOverYejun (topY, topY3);
		    x = x3;
		    y = y3;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVENOAH.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		else if (level == 4)
		{
		    copyOverYejun (groundY, groundY4);
		    copyOverYejun (topY, topY4);
		    x = x4;
		    y = y4;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEEUNHO.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		redrawYejun ();
		a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "downyejun.png"));
	    }
	    showStatus ("To go to the next level, you must complete level " + level);
	}
    }


    public void nextlevelEunho ()
    {
	if (member == "eunho")
	{
	    while (newlevel == 'y')
	    {
		level++;
		if (level == 1)
		{
		    copyOverEunho (groundE, groundE1);
		    copyOverEunho (topE, topE1);
		    x = x1;
		    y = y1;
		    level = 1;
		    newlevel = 'n';
		}
		else if (level == 2)
		{
		    copyOverEunho (groundE, groundE2);
		    copyOverEunho (topE, topE2);
		    x = x2;
		    y = y2;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEHAMIN.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		else if (level == 3)
		{
		    copyOverEunho (groundE, groundE3);
		    copyOverEunho (topE, topE3);
		    x = x3;
		    y = y3;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVENOAH.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		else if (level == 4)
		{
		    copyOverEunho (groundE, groundE4);
		    copyOverEunho (topE, topY4);
		    x = x4;
		    y = y4;
		    newlevel = 'n';
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEYEJUN.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
		}
		redrawEunho ();
		a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "downeunho.png"));
	    }
	    showStatus ("To go to the next level, you must complete level " + level);
	}
    }


    public void resetBamby ()
    {
	if (member == "bamby")
	{
	    if (level == 1)
	    {
		copyOverBamby (groundB, groundB1);
		copyOverBamby (topB, topB1);
		x = x1;
		y = y1;
	    }
	    else if (level == 2)
	    {
		copyOverBamby (groundB, groundB2);
		copyOverBamby (topB, topB2);
		x = x2;
		y = y2;
	    }
	    else if (level == 3)
	    {
		copyOverBamby (groundB, groundB3);
		copyOverBamby (topB, topB3);
		x = x3;
		y = y3;
	    }
	    else if (level == 4)
	    {
		copyOverBamby (groundB, groundB4);
		copyOverBamby (topB, topB4);
		x = x4;
		y = y4;
	    }
	    redrawBamby ();
	    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "downbamby.png"));
	}
    }


    public void resetHamin ()
    {
	if (member == "hamin")
	{
	    if (level == 1)
	    {
		copyOverHamin (groundH, groundH1);
		copyOverHamin (topH, topH1);
		x = x1;
		y = y1;
	    }
	    else if (level == 2)
	    {
		copyOverHamin (groundH, groundH2);
		copyOverHamin (topH, topH2);
		x = x2;
		y = y2;
	    }
	    else if (level == 3)
	    {
		copyOverHamin (groundH, groundH3);
		copyOverHamin (topH, topH3);
		x = x3;
		y = y3;
	    }
	    else if (level == 4)
	    {
		copyOverHamin (groundH, groundH4);
		copyOverHamin (topH, topH4);
		x = x4;
		y = y4;
	    }
	    redrawHamin ();
	    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "downhamin.png"));
	}
    }


    public void resetNoah ()
    {
	if (member == "noah")
	{
	    if (level == 1)
	    {
		copyOverNoah (groundN, groundN1);
		copyOverNoah (topN, topN1);
		x = x1;
		y = y1;
	    }
	    else if (level == 2)
	    {
		copyOverNoah (groundN, groundN2);
		copyOverNoah (topN, topN2);
		x = x2;
		y = y2;
	    }
	    else if (level == 3)
	    {
		copyOverNoah (groundN, groundN3);
		copyOverNoah (topN, topN3);
		x = x3;
		y = y3;
	    }
	    else if (level == 4)
	    {
		copyOverNoah (groundN, groundN4);
		copyOverNoah (topN, topN4);
		x = x4;
		y = y4;
	    }
	    redrawNoah ();
	    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "downnoah.png"));
	}
    }


    public void resetYejun ()
    {
	if (member == "yejun")
	{
	    if (level == 1)
	    {
		copyOverYejun (groundY, groundY1);
		copyOverYejun (topY, topY1);
		x = x1;
		y = y1;
	    }
	    else if (level == 2)
	    {
		copyOverYejun (groundY, groundY2);
		copyOverYejun (topY, topY2);
		x = x2;
		y = y2;
	    }
	    else if (level == 3)
	    {
		copyOverYejun (groundY, groundY3);
		copyOverYejun (topY, topY3);
		x = x3;
		y = y3;
	    }
	    else if (level == 4)
	    {
		copyOverYejun (groundY, groundY4);
		copyOverYejun (topY, topY4);
		x = x4;
		y = y4;

	    }
	    redrawYejun ();
	    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "downyejun.png"));
	}
    }


    public void resetEunho ()
    {
	if (member == "eunho")
	{
	    if (level == 1)
	    {
		copyOverEunho (groundE, groundE1);
		copyOverEunho (topE, topE1);
		x = x1;
		y = y1;
	    }
	    else if (level == 2)
	    {
		copyOverEunho (groundE, groundE2);
		copyOverEunho (topE, topE2);
		x = x2;
		y = y2;
	    }
	    else if (level == 3)
	    {
		copyOverEunho (groundE, groundE3);
		copyOverEunho (topE, topE3);
		x = x3;
		y = y3;
	    }
	    else if (level == 4)
	    {
		copyOverEunho (groundE, groundE4);
		copyOverEunho (topE, topY4);
		x = x4;
		y = y4;
	    }
	    redrawEunho ();
	    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "downeunho.png"));
	}
    }



    public void moveUpBamby ()
    {
	if (member == "bamby")
	{
	    if (topB [x - 1] [y] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topB [x - 1] [y] == 'f')
	    {
		x--;
		showStatus ("Moving up");
		redrawBamby ();
		a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "frontbamby.png"));
	    }
	    else if (topB [x - 1] [y] == 'c')
	    {
		x--;
		showStatus ("Moving up");
		redrawBamby ();
		a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "frontbamby.png"));
	    }
	    else if (topB [x - 1] [y] == 'h')
	    {
		if (x - 2 >= 0 && topB [x - 2] [y] == 'f')
		{
		    topB [x - 2] [y] = 'h';
		    topB [x - 1] [y] = 'f';
		    x--;
		    showStatus ("Pushing heart up");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "frontbamby.png"));
		}
		else if (x - 2 >= 0 && topB [x - 2] [y] == 'c')
		{
		    topB [x - 2] [y] = 'h';
		    topB [x - 1] [y] = 'f';
		    x--;
		    showStatus ("Heart secured");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "frontbamby.png"));
		}
		else
		{
		    showStatus ("Can't move heart up");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "frontbamby.png"));
		}
	    }
	    if (winBamby ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDNOAH.png"), "NOAH SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}

    }


    public void moveLeftBamby ()
    {
	if (member == "bamby")
	{
	    if (topB [x] [y - 1] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topB [x] [y - 1] == 'f')
	    {
		y--;
		showStatus ("Moving left");
		redrawBamby ();
		a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "leftbamby.png"));
	    }
	    else if (topB [x] [y - 1] == 'c')
	    {
		y--;
		showStatus ("Moving left");
		redrawBamby ();
		a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "leftbamby.png"));
	    }
	    else if (topB [x] [y - 1] == 'h')
	    {
		if (y - 2 >= 0 && topB [x] [y - 2] == 'f')
		{
		    topB [x] [y - 2] = 'h';
		    topB [x] [y - 1] = 'f';
		    y--;
		    showStatus ("Pushing heart left");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "leftbamby.png"));
		}
		else if (y - 2 >= 0 && topB [x] [y - 2] == 'c')
		{
		    topB [x] [y - 2] = 'h';
		    topB [x] [y - 1] = 'f';
		    y--;
		    showStatus ("Heart secured");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "leftbamby.png"));
		}
		else
		{
		    showStatus ("Can't move heart left");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "leftbamby.png"));
		}
	    }
	    if (winBamby ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDNOAH.png"), "NOAH SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}
    }


    public void moveDownBamby ()
    {
	if (member == "bamby")
	{
	    if (topB [x + 1] [y] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topB [x + 1] [y] == 'f')
	    {
		x++;
		showStatus ("Moving down");
		redrawBamby ();
		a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "downbamby.png"));
	    }
	    else if (topB [x + 1] [y] == 'c')
	    {
		x++;
		showStatus ("Moving down");
		redrawBamby ();
		a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "downbamby.png"));
	    }
	    else if (topB [x + 1] [y] == 'h')
	    {
		if (x + 2 <= 7 && topB [x + 2] [y] == 'f')
		{
		    topB [x + 2] [y] = 'h';
		    topB [x + 1] [y] = 'f';
		    x++;
		    showStatus ("Pushing heart down");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "downbamby.png"));
		}
		else if (x + 2 <= 7 && topB [x + 2] [y] == 'c')
		{
		    topB [x + 2] [y] = 'h';
		    topB [x + 1] [y] = 'f';
		    x++;
		    showStatus ("Heart secured");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "downbamby.png"));
		}
		else
		{
		    showStatus ("Can't move heart down");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "downbamby.png"));
		}
	    }
	    if (winBamby ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDNOAH.png"), "NOAH SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}
    }


    public void moveRightBamby ()
    {
	if (member == "bamby")
	{
	    if (topB [x] [y + 1] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topB [x] [y + 1] == 'f')
	    {
		y++;
		showStatus ("Moving right");
		redrawBamby ();
		a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "rightbamby.png"));
	    }
	    else if (topB [x] [y + 1] == 'c')
	    {
		y++;
		showStatus ("Moving right");
		redrawBamby ();
		a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "rightbamby.png"));
	    }
	    else if (topB [x] [y + 1] == 'h')
	    {
		if (y + 2 <= 7 && topB [x] [y + 2] == 'f')
		{
		    topB [x] [y + 2] = 'h';
		    topB [x] [y + 1] = 'f';
		    y++;
		    showStatus ("Pushing heart right");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "rightbamby.png"));
		}
		else if (y + 2 <= 7 && topB [x] [y + 2] == 'c')
		{
		    topB [x] [y + 2] = 'h';
		    topB [x] [y + 1] = 'f';
		    y++;
		    showStatus ("Heart secured");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "rightbamby.png"));
		}
		else
		{
		    showStatus ("Can't move heart right");
		    redrawBamby ();
		    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "rightbamby.png"));
		}
		if (winBamby ())
		{
		    if (level == 1)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
			newlevel = 'y';
		    }
		    if (level == 2)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDNOAH.png"), "NOAH SECURED", JOptionPane.PLAIN_MESSAGE);
			newlevel = 'y';
		    }
		    if (level == 3)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
			newlevel = 'y';
		    }
		    if (level == 4)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
			win();
		    }
		}
	    }
	}
    }


    public void moveUpHamin ()
    {
	if (member == "hamin")
	{
	    if (topH [x - 1] [y] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topH [x - 1] [y] == 'g')
	    {
		x--;
		showStatus ("Moving up");
		redrawHamin ();
		a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "fronthamin.png"));
	    }
	    else if (topH [x - 1] [y] == 't')
	    {
		x--;
		showStatus ("Moving up");
		redrawHamin ();
		a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "fronthamin.png"));
	    }
	    else if (topH [x - 1] [y] == 'h')
	    {
		if (x - 2 >= 0 && topH [x - 2] [y] == 'g')
		{
		    topH [x - 2] [y] = 'h';
		    topH [x - 1] [y] = 'g';
		    x--;
		    showStatus ("Pushing heart up");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "fronthamin.png"));
		}
		else if (x - 2 >= 0 && topH [x - 2] [y] == 't')
		{
		    topH [x - 2] [y] = 'h';
		    topH [x - 1] [y] = 'g';
		    x--;
		    showStatus ("Heart secured");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "fronthamin.png"));
		}
		else
		{
		    showStatus ("Can't move heart up");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "fronthamin.png"));
		}
	    }
	    if (winHamin ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDNOAH.png"), "NOAH SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}

    }


    public void moveLeftHamin ()
    {
	if (member == "hamin")
	{
	    if (topH [x] [y - 1] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topH [x] [y - 1] == 'g')
	    {
		y--;
		showStatus ("Moving left");
		redrawHamin ();
		a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "lefthamin.png"));
	    }
	    else if (topH [x] [y - 1] == 't')
	    {
		y--;
		showStatus ("Moving left");
		redrawHamin ();
		a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "lefthamin.png"));
	    }
	    else if (topH [x] [y - 1] == 'h')
	    {
		if (y - 2 >= 0 && topH [x] [y - 2] == 'g')
		{
		    topH [x] [y - 2] = 'h';
		    topH [x] [y - 1] = 'g';
		    y--;
		    showStatus ("Pushing heart left");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "lefthamin.png"));
		}
		else if (y - 2 >= 0 && topH [x] [y - 2] == 't')
		{
		    topH [x] [y - 2] = 'h';
		    topH [x] [y - 1] = 'g';
		    y--;
		    showStatus ("Heart secured");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "lefthamin.png"));
		}
		else
		{
		    showStatus ("Can't move heart left");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "lefthamin.png"));
		}
	    }
	    if (winHamin ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDNOAH.png"), "NOAH SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}
    }


    public void moveDownHamin ()
    {
	if (member == "hamin")
	{
	    if (topH [x + 1] [y] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topH [x + 1] [y] == 'g')
	    {
		x++;
		showStatus ("Moving down");
		redrawHamin ();
		a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "downhamin.png"));
	    }
	    else if (topH [x + 1] [y] == 't')
	    {
		x++;
		showStatus ("Moving down");
		redrawHamin ();
		a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "downhamin.png"));
	    }
	    else if (topH [x + 1] [y] == 'h')
	    {
		if (x + 2 <= 7 && topH [x + 2] [y] == 'g')
		{
		    topH [x + 2] [y] = 'h';
		    topH [x + 1] [y] = 'g';
		    x++;
		    showStatus ("Pushing heart down");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "downhamin.png"));
		}
		else if (x + 2 <= 7 && topH [x + 2] [y] == 't')
		{
		    topH [x + 2] [y] = 'h';
		    topH [x + 1] [y] = 'g';
		    x++;
		    showStatus ("Heart secured");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "downhamin.png"));
		}
		else
		{
		    showStatus ("Can't move heart down");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "downhamin.png"));
		}
	    }
	    if (winHamin ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDNOAH.png"), "NOAH SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}
    }


    public void moveRightHamin ()
    {
	if (member == "hamin")
	{
	    if (topH [x] [y + 1] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topH [x] [y + 1] == 'g')
	    {
		y++;
		showStatus ("Moving right");
		redrawHamin ();
		a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "righthamin.png"));
	    }
	    else if (topH [x] [y + 1] == 't')
	    {
		y++;
		showStatus ("Moving right");
		redrawHamin ();
		a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "righthamin.png"));
	    }
	    else if (topH [x] [y + 1] == 'h')
	    {
		if (y + 2 <= 7 && topH [x] [y + 2] == 'g')
		{
		    topH [x] [y + 2] = 'h';
		    topH [x] [y + 1] = 'g';
		    y++;
		    showStatus ("Pushing heart right");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "righthamin.png"));
		}
		else if (y + 2 <= 7 && topH [x] [y + 2] == 't')
		{
		    topH [x] [y + 2] = 'h';
		    topH [x] [y + 1] = 'g';
		    y++;
		    showStatus ("Heart secured");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "righthamin.png"));
		}
		else
		{
		    showStatus ("Can't move heart right");
		    redrawHamin ();
		    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "righthamin.png"));
		}
		if (winHamin ())
		{
		    if (level == 1)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
			newlevel = 'y';
		    }
		    if (level == 2)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDNOAH.png"), "NOAH SECURED", JOptionPane.PLAIN_MESSAGE);
			newlevel = 'y';
		    }
		    if (level == 3)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
			newlevel = 'y';
		    }
		    if (level == 4)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
			win();
		    }
		}
	    }
	}
    }


    public void moveUpNoah ()
    {
	if (member == "noah")
	{
	    if (topN [x - 1] [y] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topN [x - 1] [y] == 'i')
	    {
		x--;
		showStatus ("Moving up");
		redrawNoah ();
		a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "frontnoah.png"));
	    }
	    else if (topN [x - 1] [y] == 'u')
	    {
		x--;
		showStatus ("Moving up");
		redrawNoah ();
		a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "frontnoah.png"));
	    }
	    else if (topN [x - 1] [y] == 'h')
	    {
		if (x - 2 >= 0 && topN [x - 2] [y] == 'i')
		{
		    topN [x - 2] [y] = 'h';
		    topN [x - 1] [y] = 'i';
		    x--;
		    showStatus ("Pushing heart up");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "frontnoah.png"));
		}
		else if (x - 2 >= 0 && topN [x - 2] [y] == 'u')
		{
		    topN [x - 2] [y] = 'h';
		    topN [x - 1] [y] = 'i';
		    x--;
		    showStatus ("Heart secured");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "frontnoah.png"));
		}
		else
		{
		    showStatus ("Can't move heart up");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "frontnoah.png"));
		}
	    }
	    if (winNoah ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}

    }


    public void moveLeftNoah ()
    {
	if (member == "noah")
	{
	    if (topN [x] [y - 1] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topN [x] [y - 1] == 'i')
	    {
		y--;
		showStatus ("Moving left");
		redrawNoah ();
		a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "leftnoah.png"));
	    }
	    else if (topN [x] [y - 1] == 'u')
	    {
		y--;
		showStatus ("Moving left");
		redrawNoah ();
		a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "leftnoah.png"));
	    }
	    else if (topN [x] [y - 1] == 'h')
	    {
		if (y - 2 >= 0 && topN [x] [y - 2] == 'i')
		{
		    topN [x] [y - 2] = 'h';
		    topN [x] [y - 1] = 'i';
		    y--;
		    showStatus ("Pushing heart left");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "leftnoah.png"));
		}
		else if (y - 2 >= 0 && topN [x] [y - 2] == 'u')
		{
		    topN [x] [y - 2] = 'h';
		    topN [x] [y - 1] = 'i';
		    y--;
		    showStatus ("Heart secured");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "leftnoah.png"));
		}
		else
		{
		    showStatus ("Can't move heart left");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "leftnoah.png"));
		}
	    }
	    if (winNoah ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}
    }


    public void moveDownNoah ()
    {
	if (member == "noah")
	{
	    if (topN [x + 1] [y] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topN [x + 1] [y] == 'i')
	    {
		x++;
		showStatus ("Moving down");
		redrawNoah ();
		a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "downnoah.png"));
	    }
	    else if (topN [x + 1] [y] == 'u')
	    {
		x++;
		showStatus ("Moving down");
		redrawNoah ();
		a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "downnoah.png"));
	    }
	    else if (topN [x + 1] [y] == 'h')
	    {
		if (x + 2 <= 7 && topN [x + 2] [y] == 'i')
		{
		    topN [x + 2] [y] = 'h';
		    topN [x + 1] [y] = 'i';
		    x++;
		    showStatus ("Pushing heart down");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "downnoah.png"));
		}
		else if (x + 2 <= 7 && topN [x + 2] [y] == 'u')
		{
		    topN [x + 2] [y] = 'h';
		    topN [x + 1] [y] = 'i';
		    x++;
		    showStatus ("Heart secured");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "downnoah.png"));
		}
		else
		{
		    showStatus ("Can't move heart down");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "downnoah.png"));
		}
	    }
	    if (winNoah ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}
    }


    public void moveRightNoah ()
    {
	if (member == "noah")
	{
	    if (topN [x] [y + 1] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topN [x] [y + 1] == 'i')
	    {
		y++;
		showStatus ("Moving right");
		redrawNoah ();
		a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "rightnoah.png"));
	    }
	    else if (topN [x] [y + 1] == 'u')
	    {
		y++;
		showStatus ("Moving right");
		redrawNoah ();
		a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "rightnoah.png"));
	    }
	    else if (topN [x] [y + 1] == 'h')
	    {
		if (y + 2 <= 7 && topN [x] [y + 2] == 'i')
		{
		    topN [x] [y + 2] = 'h';
		    topN [x] [y + 1] = 'i';
		    y++;
		    showStatus ("Pushing heart right");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "rightnoah.png"));
		}
		else if (y + 2 <= 7 && topN [x] [y + 2] == 'u')
		{
		    topN [x] [y + 2] = 'h';
		    topN [x] [y + 1] = 'i';
		    y++;
		    showStatus ("Heart secured");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "rightnoah.png"));
		}
		else
		{
		    showStatus ("Can't move heart right");
		    redrawNoah ();
		    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "rightnoah.png"));
		}
		if (winNoah ())
		{
		    if (level == 1)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
			newlevel = 'y';
		    }
		    if (level == 2)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
			newlevel = 'y';
		    }
		    if (level == 3)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDYEJUN.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
			newlevel = 'y';
		    }
		    if (level == 4)
		    {
			JOptionPane.showMessageDialog (null, createImageIcon ("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
			win();
		    }
		}
	    }
	}
    }


    public void moveUpYejun ()
    {
	if (member == "yejun")
	{
	    if (topY [x - 1] [y] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topY [x - 1] [y] == 'r')
	    {
		x--;
		showStatus ("Moving up");
		redrawYejun ();
		a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "frontyejun.png"));
	    }
	    else if (topY [x - 1] [y] == 'e')
	    {
		x--;
		showStatus ("Moving up");
		redrawYejun ();
		a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "frontyejun.png"));
	    }
	    else if (topY [x - 1] [y] == 'h')
	    {
		if (x - 2 >= 0 && topY [x - 2] [y] == 'r')
		{
		    topY [x - 2] [y] = 'h';
		    topY [x - 1] [y] = 'r';
		    x--;
		    showStatus ("Pushing heart up");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "frontyejun.png"));
		}
		else if (x - 2 >= 0 && topY [x - 2] [y] == 'e')
		{
		    topY [x - 2] [y] = 'h';
		    topY [x - 1] [y] = 'r';
		    x--;
		    showStatus ("Heart secured");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "frontyejun.png"));
		}
		else
		{
		    showStatus ("Can't move heart up");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "frontyejun.png"));
		}
	    }
	    if (winYejun ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDNOAH.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}

    }


    public void moveLeftYejun ()
    {
	if (member == "yejun")
	{
	    if (topY [x] [y - 1] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topY [x] [y - 1] == 'r')
	    {
		y--;
		showStatus ("Moving left");
		redrawYejun ();
		a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "leftyejun.png"));
	    }
	    else if (topY [x] [y - 1] == 'e')
	    {
		y--;
		showStatus ("Moving left");
		redrawYejun ();
		a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "leftyejun.png"));
	    }
	    else if (topY [x] [y - 1] == 'h')
	    {
		if (y - 2 >= 0 && topY [x] [y - 2] == 'r')
		{
		    topY [x] [y - 2] = 'h';
		    topY [x] [y - 1] = 'r';
		    y--;
		    showStatus ("Pushing heart left");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "leftyejun.png"));
		}
		else if (y - 2 >= 0 && topY [x] [y - 2] == 'e')
		{
		    topY [x] [y - 2] = 'h';
		    topY [x] [y - 1] = 'r';
		    y--;
		    showStatus ("Heart secured");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "leftyejun.png"));
		}
		else
		{
		    showStatus ("Can't move heart left");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "leftyejun.png"));
		}
	    }
	    if (winYejun ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDNOAH.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}
    }


    public void moveDownYejun ()
    {
	if (member == "yejun")
	{
	    if (topY [x + 1] [y] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topY [x + 1] [y] == 'r')
	    {
		x++;
		showStatus ("Moving down");
		redrawYejun ();
		a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "downyejun.png"));
	    }
	    else if (topY [x + 1] [y] == 'e')
	    {
		x++;
		showStatus ("Moving down");
		redrawYejun ();
		a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "downyejun.png"));
	    }
	    else if (topY [x + 1] [y] == 'h')
	    {
		if (x + 2 <= 7 && topY [x + 2] [y] == 'r')
		{
		    topY [x + 2] [y] = 'h';
		    topY [x + 1] [y] = 'r';
		    x++;
		    showStatus ("Pushing heart down");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "downyejun.png"));
		}
		else if (x + 2 <= 7 && topY [x + 2] [y] == 'e')
		{
		    topY [x + 2] [y] = 'h';
		    topY [x + 1] [y] = 'r';
		    x++;
		    showStatus ("Heart secured");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "downyejun.png"));
		}
		else
		{
		    showStatus ("Can't move heart down");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "downyejun.png"));
		}
	    }
	    if (winYejun ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDNOAH.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}
    }


    public void moveRightYejun ()
    {
	if (member == "yejun")
	{
	    if (topY [x] [y + 1] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topY [x] [y + 1] == 'r')
	    {
		y++;
		showStatus ("Moving right");
		redrawYejun ();
		a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "rightyejun.png"));
	    }
	    else if (topY [x] [y + 1] == 'e')
	    {
		y++;
		showStatus ("Moving right");
		redrawYejun ();
		a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "rightyejun.png"));
	    }
	    else if (topY [x] [y + 1] == 'h')
	    {
		if (y + 2 <= 7 && topY [x] [y + 2] == 'r')
		{
		    topY [x] [y + 2] = 'h';
		    topY [x] [y + 1] = 'r';
		    y++;
		    showStatus ("Pushing heart right");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "rightyejun.png"));
		}
		else if (y + 2 <= 7 && topY [x] [y + 2] == 'e')
		{
		    topY [x] [y + 2] = 'h';
		    topY [x] [y + 1] = 'r';
		    y++;
		    showStatus ("Heart secured");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "rightyejun.png"));
		}
		else
		{
		    showStatus ("Can't move heart right");
		    redrawYejun ();
		    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "rightyejun.png"));
		}
		if (winYejun ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDNOAH.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDEUNHO.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	    }
	}
    }


    public void moveUpEunho ()
    {
	if (member == "eunho")
	{
	    if (topE [x - 1] [y] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topE [x - 1] [y] == 'j')
	    {
		x--;
		showStatus ("Moving up");
		redrawEunho ();
		a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "fronteunho.png"));
	    }
	    else if (topE [x - 1] [y] == 'k')
	    {
		x--;
		showStatus ("Moving up");
		redrawEunho ();
		a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "fronteunho.png"));
	    }
	    else if (topE [x - 1] [y] == 'h')
	    {
		if (x - 2 >= 0 && topE [x - 2] [y] == 'j')
		{
		    topE [x - 2] [y] = 'h';
		    topE [x - 1] [y] = 'j';
		    x--;
		    showStatus ("Pushing heart up");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "fronteunho.png"));
		}
		else if (x - 2 >= 0 && topE [x - 2] [y] == 'k')
		{
		    topE [x - 2] [y] = 'h';
		    topE [x - 1] [y] = 'j';
		    x--;
		    showStatus ("Heart secured");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "fronteunho.png"));
		}
		else
		{
		    showStatus ("Can't move heart up");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "fronteunho.png"));
		}
	    }
	    if (winEunho ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDNOAH.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDYEJUN.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}

    }


    public void moveLeftEunho ()
    {
	if (member == "eunho")
	{
	    if (topE [x] [y - 1] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topE [x] [y - 1] == 'j')
	    {
		y--;
		showStatus ("Moving left");
		redrawEunho ();
		a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "lefteunho.png"));
	    }
	    else if (topE [x] [y - 1] == 'k')
	    {
		y--;
		showStatus ("Moving left");
		redrawEunho ();
		a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "lefteunho.png"));
	    }
	    else if (topE [x] [y - 1] == 'h')
	    {
		if (y - 2 >= 0 && topE [x] [y - 2] == 'j')
		{
		    topE [x] [y - 2] = 'h';
		    topE [x] [y - 1] = 'j';
		    y--;
		    showStatus ("Pushing heart left");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "lefteunho.png"));
		}
		else if (y - 2 >= 0 && topE [x] [y - 2] == 'k')
		{
		    topE [x] [y - 2] = 'h';
		    topE [x] [y - 1] = 'j';
		    y--;
		    showStatus ("Heart secured");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "lefteunho.png"));
		}
		else
		{
		    showStatus ("Can't move heart left");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "lefteunho.png"));
		}
	    }
	    if (winEunho ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDNOAH.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDYEJUN.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}
    }


    public void moveDownEunho ()
    {
	if (member == "eunho")
	{
	    if (topE [x + 1] [y] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topE [x + 1] [y] == 'j')
	    {
		x++;
		showStatus ("Moving down");
		redrawEunho ();
		a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "downeunho.png"));
	    }
	    else if (topE [x + 1] [y] == 'k')
	    {
		x++;
		showStatus ("Moving down");
		redrawEunho ();
		a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "downeunho.png"));
	    }
	    else if (topE [x + 1] [y] == 'h')
	    {
		if (x + 2 <= 7 && topE [x + 2] [y] == 'j')
		{
		    topE [x + 2] [y] = 'h';
		    topE [x + 1] [y] = 'j';
		    x++;
		    showStatus ("Pushing heart down");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "downeunho.png"));
		}
		else if (x + 2 <= 7 && topE [x + 2] [y] == 'k')
		{
		    topE [x + 2] [y] = 'h';
		    topE [x + 1] [y] = 'j';
		    x++;
		    showStatus ("Heart secured");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "downeunho.png"));
		}
		else
		{
		    showStatus ("Can't move heart down");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "downeunho.png"));
		}
	    }
	    if (winEunho ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDNOAH.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDYEJUN.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	}
    }


    public void moveRightEunho ()
    {
	if (member == "eunho")
	{
	    if (topE [x] [y + 1] == 'w')
	    {
		showStatus ("Wall. Can't go there");
	    }
	    else if (topE [x] [y + 1] == 'j')
	    {
		y++;
		showStatus ("Moving right");
		redrawEunho ();
		a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "righteunho.png"));
	    }
	    else if (topE [x] [y + 1] == 'k')
	    {
		y++;
		showStatus ("Moving right");
		redrawEunho ();
		a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "righteunho.png"));
	    }
	    else if (topE [x] [y + 1] == 'h')
	    {
		if (y + 2 <= 7 && topE [x] [y + 2] == 'j')
		{
		    topE [x] [y + 2] = 'h';
		    topE [x] [y + 1] = 'j';
		    y++;
		    showStatus ("Pushing heart right");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "righteunho.png"));
		}
		else if (y + 2 <= 7 && topE [x] [y + 2] == 'k')
		{
		    topE [x] [y + 2] = 'h';
		    topE [x] [y + 1] = 'j';
		    y++;
		    showStatus ("Heart secured");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "righteunho.png"));
		}
		else
		{
		    showStatus ("Can't move heart right");
		    redrawEunho ();
		    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "righteunho.png"));
		}
		if (winEunho ())
	    {
		if (level == 1)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDBAMBY.png"), "BAMBY SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 2)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDHAMIN.png"), "HAMIN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 3)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDNOAH.png"), "YEJUN SECURED", JOptionPane.PLAIN_MESSAGE);
		    newlevel = 'y';
		}
		if (level == 4)
		{
		    JOptionPane.showMessageDialog (null, createImageIcon("SAVEDYEJUN.png"), "EUNHO SECURED", JOptionPane.PLAIN_MESSAGE);
		    win();
		}
	    }
	    }
	}
    }
    
    public void win()
    {
	String[] options = new String[]
	{
	    "EXIT", "PLAY_AGAIN"
	}
	;

	int option = JOptionPane.showOptionDialog (null, createImageIcon ("ESCAPED.png"), "YOU WON!", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options [0]);

	if (option == 0)
	    System.exit (0);
	else if (option == 1)
	{
	    level = 1;
	    newlevel = 'n';
	    member = "";
	    saved = "";
	    score.setText ("Level: " + level);
	    cdLayout.show (p_card, "1");
	    restartBamby();
	    restartHamin();
	    restartNoah();
	    restartYejun();
	    restartEunho();
	    
	}
    }
    
    public void restartBamby ()
    {
	if (member == "bamby")
	{
	    score.setText ("Level: " + level);
	    x = x1;
	    y = y1;
	    copyOverBamby (groundB, groundB1);
	    copyOverBamby (topB, topB1);
	    redrawBamby();
	    a [x * 7 + y].setIcon (createImageIcon (groundB [x] [y] + "downbamby.png"));
	}
    }
    public void restartHamin ()
    {
	if (member == "hamin")
	{
	    score2.setText ("Level: " + level);
	    copyOverHamin (groundH, groundH1);
	    copyOverHamin (topH, topH1);
	    x = x1;
	    y = y1;
	    redrawHamin();
	    a2 [x * 7 + y].setIcon (createImageIcon (groundH [x] [y] + "downhamin.png"));
	}
    }
    public void restartNoah ()
    {
	if (member == "Noah")
	{
	    score3.setText ("Level: " + level);
	    copyOverNoah (groundN, groundN1);
	    copyOverNoah (topN, topN1);
	    x = x1;
	    y = y1;
	    redrawNoah();
	    a3 [x * 7 + y].setIcon (createImageIcon (groundN [x] [y] + "downnoah.png"));
	}
    }
    public void restartYejun ()
    {
	if (member == "yejun")
	{
	    score4.setText ("Level: " + level);
	    copyOverYejun (groundY, groundY1);
	    copyOverYejun (topY, topY1);
	    x = x1;
	    y = y1;
	    redrawYejun();
	    a4 [x * 7 + y].setIcon (createImageIcon (groundY [x] [y] + "downyejun.png"));
	}
    }
    public void restartEunho ()
    {
	if (member == "eunho")
	{
	    score5.setText ("Level: " + level);
	    copyOverEunho (groundE, groundE1);
	    copyOverEunho (topE, topE1);
	    x = x1;
	    y = y1;
	    redrawEunho();
	    a5 [x * 7 + y].setIcon (createImageIcon (groundE [x] [y] + "downeunho.png"));
	}
    }
    


    public void actionPerformed (ActionEvent e)
    {
	if (e.getActionCommand ().equals ("instruction"))
	{
	    instruction ();
	}
	else if (e.getActionCommand ().equals ("next1"))
	{
	    cdLayout.show (p_card, "3");
	}
	else if (e.getActionCommand ().equals ("back1"))
	{
	    cdLayout.show (p_card, "1");
	}
	else if (e.getActionCommand ().equals ("next2"))
	{
	    cdLayout.show (p_card, "4");
	}
	else if (e.getActionCommand ().equals ("back2"))
	{
	    cdLayout.show (p_card, "2");
	}
	else if (e.getActionCommand ().equals ("back3"))
	{
	    cdLayout.show (p_card, "3");
	}
	else if (e.getActionCommand ().equals ("back5"))
	{
	    cdLayout.show (p_card, "1");
	}
	else if (e.getActionCommand ().equals ("next5"))
	{
	    cdLayout.show (p_card, "5");
	}
	else if (e.getActionCommand ().equals ("back6"))
	{
	    cdLayout.show (p_card, "1");

	}
	else if (e.getActionCommand ().equals ("objective"))
	{
	    JOptionPane.showMessageDialog (null, createImageIcon ("OBJECTIVE.png"), "Lore", JOptionPane.PLAIN_MESSAGE);
	}
	else if (e.getActionCommand ().equals ("start"))
	{
	    cdLayout.show (p_card, "5");
	}
	else if (e.getActionCommand ().equals ("bamby"))
	{
	    cdLayout.show (p_card, "6");
	    member = "bamby";
	}
	else if (e.getActionCommand ().equals ("hamin"))
	{
	    cdLayout.show (p_card, "7");
	    member = "hamin";
	}
	else if (e.getActionCommand ().equals ("noah"))
	{
	    cdLayout.show (p_card, "8");
	    member = "noah";
	}
	else if (e.getActionCommand ().equals ("yejun"))
	{
	    cdLayout.show (p_card, "9");
	    member = "yejun";
	}
	else if (e.getActionCommand ().equals ("eunho"))
	{
	    cdLayout.show (p_card, "10");
	    member = "eunho";
	}
	else if (e.getActionCommand ().equals ("back4"))
	{
	    cdLayout.show (p_card, "5");
	}
	else if (e.getActionCommand ().equals ("bgame"))
	{
	    cdLayout.show (p_card, "11");
	    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEHAMIN.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
	}
	else if (e.getActionCommand ().equals ("hgame"))
	{
	    cdLayout.show (p_card, "12");
	    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEBAMBY.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
	}
	else if (e.getActionCommand ().equals ("ngame"))
	{
	    cdLayout.show (p_card, "13");
	    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEBAMBY.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
	}
	else if (e.getActionCommand ().equals ("ygame"))
	{
	    cdLayout.show (p_card, "14");
	    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEBAMBY.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
	}
	else if (e.getActionCommand ().equals ("egame"))
	{
	    cdLayout.show (p_card, "15");
	    JOptionPane.showMessageDialog (null, createImageIcon ("SAVEBAMBY.png"), "ALERT", JOptionPane.PLAIN_MESSAGE);
	}
	else if (e.getActionCommand ().equals ("game"))
	{
	    if (member == "bamby")
	    {
		cdLayout.show (p_card, "11");
	    }
	    else if (member == "hamin")
		cdLayout.show (p_card, "12");
	    else if (member == "noah")
		cdLayout.show (p_card, "13");
	    else if (member == "yejun")
		cdLayout.show (p_card, "14");
	    else if (member == "eunho")
		cdLayout.show (p_card, "15");

	}
	else if (e.getActionCommand ().equals ("resetbamby"))
	{
	    resetBamby ();
	}
	else if (e.getActionCommand ().equals ("nextbamby"))
	{
	    nextlevelBamby ();
	    score.setText ("Level: " + level);
	}
	else if (e.getActionCommand ().equals ("up"))
	{
	    moveUpBamby ();
	}
	else if (e.getActionCommand ().equals ("left"))
	{
	    moveLeftBamby ();
	}
	else if (e.getActionCommand ().equals ("down"))
	{
	    moveDownBamby ();
	}
	else if (e.getActionCommand ().equals ("right"))
	{
	    moveRightBamby ();
	}
	else if (e.getActionCommand ().equals ("up2"))
	{
	    moveUpHamin ();
	}
	else if (e.getActionCommand ().equals ("left2"))
	{
	    moveLeftHamin ();
	}
	else if (e.getActionCommand ().equals ("down2"))
	{
	    moveDownHamin ();
	}
	else if (e.getActionCommand ().equals ("right2"))
	{
	    moveRightHamin ();
	}
	else if (e.getActionCommand ().equals ("nexthamin"))
	{
	    nextlevelHamin ();
	    score2.setText ("Level: " + level);
	}
	else if (e.getActionCommand ().equals ("resethamin"))
	{
	    resetHamin ();
	}
	else if (e.getActionCommand ().equals ("up3"))
	{
	    moveUpNoah ();
	}
	else if (e.getActionCommand ().equals ("left3"))
	{
	    moveLeftNoah ();
	}
	else if (e.getActionCommand ().equals ("down3"))
	{
	    moveDownNoah ();
	}
	else if (e.getActionCommand ().equals ("right3"))
	{
	    moveRightNoah ();
	}
	else if (e.getActionCommand ().equals ("nextnoah"))
	{
	    nextlevelNoah ();
	    score3.setText ("Level: " + level);
	}
	else if (e.getActionCommand ().equals ("resetnoah"))
	{
	    resetNoah ();
	}
	else if (e.getActionCommand ().equals ("up4"))
	{
	    moveUpYejun ();
	}
	else if (e.getActionCommand ().equals ("left4"))
	{
	    moveLeftYejun ();
	}
	else if (e.getActionCommand ().equals ("down4"))
	{
	    moveDownYejun ();
	}
	else if (e.getActionCommand ().equals ("right4"))
	{
	    moveRightYejun ();
	}
	else if (e.getActionCommand ().equals ("nextyejun"))
	{
	    nextlevelYejun ();
	    score4.setText ("Level: " + level);
	}
	else if (e.getActionCommand ().equals ("resetYejun"))
	{
	    resetYejun ();
	}
	else if (e.getActionCommand ().equals ("up5"))
	{
	    moveUpEunho ();
	}
	else if (e.getActionCommand ().equals ("left5"))
	{
	    moveLeftEunho ();
	}
	else if (e.getActionCommand ().equals ("down5"))
	{
	    moveDownEunho ();
	}
	else if (e.getActionCommand ().equals ("right5"))
	{
	    moveRightEunho ();
	}
	else if (e.getActionCommand ().equals ("nexteunho"))
	{
	    nextlevelEunho ();
	    score5.setText ("Level: " + level);
	}
	else if (e.getActionCommand ().equals ("reseteunho"))
	{
	    resetEunho ();
	}

    }


    protected static ImageIcon createImageIcon (String path)
    {
	java.net.URL imgURL = Sokoban_Adaptation.class.getResource (path);
	if (imgURL != null)
	{
	    return new ImageIcon (imgURL);
	}


	else
	{
	    System.err.println ("Couldn't find file: " + path);
	    return null;
	}
    }
}
