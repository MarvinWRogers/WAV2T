package org.RockPaperScissors;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;

public class Game extends JFrame {
    int opponentScore, drawScore, playerScore = 0;
    JTextArea getOpponentScoreKeeper = new JTextArea("" + opponentScore);
    JTextArea getPlayerScoreKeeper = new JTextArea("" + playerScore);
    JTextArea getDrawScoreKeeper = new JTextArea("" + drawScore);
    JPanel dialogPanel = new JPanel();
    JPanel scorePanel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JButton rock = new JButton(	"\u270A");
    JButton paper= new JButton("\u270B");
    JButton scissors= new JButton("\u2704");
    JButton resetButton= new JButton();
    JLabel displayGameStatus = new JLabel( "Select your choice!");
     String plyStr1 = " You won! ";
     String plyStr2 = " You lost! ";
     String drawCond = "-- Draw! --";

      public Game () {

          JFrame frame = new JFrame("Rock Paper Scissors ");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Terminates process when closed
          frame.setSize(400, 400); // generic size
          frame.setResizable(false); // user prevented from expanding window
          frame.getContentPane().setBackground(Color.blue); // sets JFrame color to Blue

          JLabel yourLabel = new JLabel("Player: ");
          JLabel drawLabel = new JLabel("Draw: ");
          JLabel opponentLabel = new JLabel("Computer: ");

          // ---------- score panel layout ----------
          scorePanel.setLayout(new FlowLayout());
          scorePanel.setBackground(Color.ORANGE);
          // opponent score
          scorePanel.add(opponentLabel);
          scorePanel.add(getOpponentScoreKeeper);
          // draw score
          scorePanel.add(drawLabel);
          scorePanel.add(getDrawScoreKeeper);
          // player score
          scorePanel.add(yourLabel);
          scorePanel.add(getPlayerScoreKeeper);

          // score cards cannot be manually typed in
          getOpponentScoreKeeper.setEditable(false);
          getDrawScoreKeeper.setEditable(false);
          getPlayerScoreKeeper.setEditable(false);

          // ---------- score panel layout end ----------

          // dialog panel
          dialogPanel.add(displayGameStatus);
          dialogPanel.setBorder(BorderFactory.createLineBorder(Color.black));
          dialogPanel.setBackground(Color.CYAN);
          buttonPanel.setLayout(new GridLayout(2,3));
          buttonPanel.setBackground(Color.black);

          rock.setBackground(Color.GRAY);
          rock.setOpaque(true);
          rock.setBorderPainted(false);
          buttonPanel.add(rock);

          paper.setBackground(Color.PINK);
          paper.setOpaque(true);
          paper.setBorderPainted(false);
          buttonPanel.add(paper);

          scissors.setBackground(Color.GREEN);
          scissors.setOpaque(true);
          scissors.setBorderPainted(false);
          buttonPanel.add(scissors);

          // reset button
          resetButton.setText("Reset");
          resetButton.setBackground(Color.RED);
          resetButton.setOpaque(true);
          resetButton.setBorderPainted(false); // for macOS users viewing the button
          buttonPanel.add(resetButton);

          // action listeners
          rock.addActionListener(e -> {generateComputerChoice(e);});
          paper.addActionListener(e -> {generateComputerChoice(e);});
          scissors.addActionListener(e -> {generateComputerChoice(e);});
          resetButton.addActionListener(e -> {resetGame(e); });

          // frame assignments -- not working with me 100% right now while manually creating the GUI
          frame.getContentPane().add(BorderLayout.PAGE_START, scorePanel);
          frame.getContentPane().add(BorderLayout.CENTER, buttonPanel);
          frame.getContentPane().add(BorderLayout.SOUTH, dialogPanel);
          frame.setVisible(true); // final sequence for JFrame to produce all panels and buttons

      }

    public void generateComputerChoice(ActionEvent e) {

        int[] selection = {0, 1, 2}; // rock paper scissors
        Random r = new Random();
        int OpponentPicks = r.nextInt(selection.length);


        if (OpponentPicks == 0 && e.getSource() == rock) {
            // draw for rock
            getDrawScoreKeeper.setText("" + drawScore++);
            displayGameStatus.setText(String.valueOf(drawCond));


        } else if (OpponentPicks == 1 && e.getSource() == rock) {
            // player loses rock
            getOpponentScoreKeeper.setText("" + opponentScore++);
            displayGameStatus.setText(String.valueOf(plyStr2));

        } else if (OpponentPicks == 2 && e.getSource() == rock) {
            // player wins rock
            getPlayerScoreKeeper.setText("" + playerScore++);
            displayGameStatus.setText(String.valueOf(plyStr1));

        } // end rock conditionals


        // conditionals for paper button pressed
        if (OpponentPicks == 0 && e.getSource() == paper) {
            // player wins paper
            getPlayerScoreKeeper.setText("" + playerScore++);
            displayGameStatus.setText(String.valueOf(plyStr1));

        } else if (OpponentPicks == 1 && e.getSource() == paper) {
            // paper draws
            getDrawScoreKeeper.setText("" + drawScore++);
            displayGameStatus.setText(String.valueOf(drawCond));
        } else if (OpponentPicks == 2 && e.getSource() == paper) {
            // player loses
            getOpponentScoreKeeper.setText("" + opponentScore++);
            displayGameStatus.setText(String.valueOf(plyStr2));
        } // end paper conditionals


        // conditionals for scissors button pressed
        if (OpponentPicks == 0 && e.getSource() == scissors) {
            // player loses
            getOpponentScoreKeeper.setText("" + opponentScore++);
            displayGameStatus.setText(String.valueOf(plyStr2));
            // scoreKeeperUser(OpponentPicks);
            // method to add count to ties
        } else if (OpponentPicks == 1 && e.getSource() == scissors) {
            // player wins
            getPlayerScoreKeeper.setText("" + playerScore++);
            displayGameStatus.setText(String.valueOf(plyStr1));
            // method to add count to losses
        } else if (OpponentPicks == 2 && e.getSource() == scissors) {
            // draw scissors
            getDrawScoreKeeper.setText("" + drawScore++);
            displayGameStatus.setText(String.valueOf(drawCond));
        } // end scissor conditionals
    } // end game check conditionals

// reset game
    public void resetGame(ActionEvent e) {
        playerScore = 0;
        opponentScore = 0;
        drawScore = 0;

        if (e.getSource() == resetButton) {
            getPlayerScoreKeeper.setText("" + playerScore);
            getOpponentScoreKeeper.setText("" + opponentScore);
            getDrawScoreKeeper.setText("" + drawScore);
            displayGameStatus.setText("Restart");
        }
    }

} // end Game class





