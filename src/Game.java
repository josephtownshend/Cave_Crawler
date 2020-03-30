import java.awt.BorderLayout;
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
 */

public class Game implements ActionListener {

  private int count = 1;
  private final JLabel message;
  private final JFrame frame;
  private final JButton northButton;
  private final JButton southButton;
  private final JButton westButton;
  private final JButton eastButton;
  private final JPanel panel;


  public Game() {

    frame = new JFrame();

    northButton = new JButton("North");
    northButton.addActionListener(this);

    southButton = new JButton("South");
    southButton.addActionListener(this);

    westButton = new JButton("West");
    westButton.addActionListener(this);

    eastButton = new JButton("East");
    eastButton.addActionListener(this);

    message = new JLabel();
    message.setText("You find yourself in a long passage");

    panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panel.setLayout(new BorderLayout(2, 1)); // this is what allows you to have N,S,E,W compass points.

    panel.add(northButton, BorderLayout.NORTH);
    panel.add(southButton, BorderLayout.SOUTH);
    panel.add(westButton, BorderLayout.WEST);
    panel.add(eastButton, BorderLayout.EAST);
    panel.add(message);

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
   * Increments the counter on each button click and displays the current room in
   * which the player occupies.
   *
   * @param event information about the button click
   */
  @Override
  public void actionPerformed(ActionEvent event) {

    if (count == 1 && event.getSource() == northButton) {
      count++;
      message.setText("You walk into a dark cave");
    } else if (count == 1 && event.getSource() == southButton) {
      count--;
      message.setText("You walk into sunlight");
    } else if (count == 2 && event.getSource() == northButton) {
      message.setText("You can go no further...");
    } else if (count == 2 && event.getSource() == southButton) {
      count--;
      message.setText("You find yourself in a long passage");
    } else {
      return;
    }

  }
}
