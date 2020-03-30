import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * A simple Swing dungeon game.
 *
 * @author Joseph Townshend
 * @version Mar 29, 2020
 */

public class Game implements ActionListener {

  private int count = 1;

  private final JFrame frame;
  private final JPanel panel;

  private final JLabel message;
  private final JButton northButton;
  private final JButton southButton;
  private final JButton eastButton;
  private final JButton westButton;




  public Game() {

    frame = new JFrame();

    northButton = new JButton("North");
    northButton.addActionListener(this);

    southButton = new JButton("South");
    southButton.addActionListener(this);

    eastButton = new JButton("East");
    eastButton.addActionListener(this);

    westButton = new JButton("West");
    westButton.addActionListener(this);


    // In order to make the label centred swing constants must be set here.
    message = new JLabel("You find yourself in a long passage", SwingConstants.CENTER);

    panel = new JPanel();
    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    panel.setLayout(new BorderLayout(2, 1)); // this is what allows you to have N,S,E,W compass points.

    panel.add(message);
    panel.add(northButton, BorderLayout.NORTH);
    panel.add(southButton, BorderLayout.SOUTH);
    panel.add(eastButton, BorderLayout.EAST);
    panel.add(westButton, BorderLayout.WEST);



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
