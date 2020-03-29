import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * A simple Swing dungeon game.
 *
 * @author Joseph Townshend
 * @version Mar 29, 2020
 *
 */

public class Game implements ActionListener{

  private int count = 1;
  private final JLabel label;
  private final JFrame frame;
  private final JButton upButton;
  private final JButton downButton;
  private final JPanel panel;

  public Game() {

    frame = new JFrame();

    upButton = new JButton("Up");
    upButton.addActionListener(this);

    downButton = new JButton("Down");
    downButton.addActionListener(this);

    label = new JLabel();
    label.setText("You find yourself in a long passage");

    panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30 , 10 , 30));
    panel.setLayout(new GridLayout(2, 1));

    panel.add(upButton);
    panel.add(downButton);
    panel.add(label);

    frame.add(panel, BorderLayout.CENTER); // add panel to frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // behaviour for closing frame
    frame.setTitle("Our GUI"); // set title of frame
    frame.pack(); // set frame to certain size
    frame.setVisible(true); // set window to be visible and in focus

  }


  public static void main(String[] args) {
    new Game();
  }


  /**
   * Increments the counter on each button click and displays
   * the current room in which the player occupies.
   * @param event information about the button click
   */
  @Override
  public void actionPerformed(ActionEvent event) {

    if (count == 1 && event.getSource() == upButton) {
      count++;
      label.setText("You walk into a dark cave");
    } else if (count == 1 && event.getSource() == downButton) {
      count--;
      label.setText("You walk out into sunlight");
    } else if (count == 2 && event.getSource() == upButton) {
      label.setText("You can go no further");
    } else if (count == 2 && event.getSource() == downButton) {
      count--;
      label.setText("You find yourself in a long passage");
    } else {
      return;
    }

  }
}

