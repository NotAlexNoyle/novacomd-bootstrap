package bootstrap;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Declare main class.
public class Main {

	// Declare main window frame.
	public static JFrame mainFrame = new JFrame("novacomd-bootstrap");

	// init main.
	public static void main(String[] args) {

		// Create and set up the window.
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Store operating system in string for reference.
		String os = System.getProperty("os.name");

		// Detect if OS is Windows.
		if(os.contains("Windows")) {

			// Inform the user that the bootstrap is only intended for UNIX-like systems.
			JOptionPane.showMessageDialog(null, "novacomd-bootstrap is only designed to support UNIX-like systems.", "Error", JOptionPane.ERROR_MESSAGE);

			// Abort the bootstrap and kill the program.
			System.exit(0);

		}

		// Declare panel to hold content on frame.
		JPanel mainPanel = new JPanel();

		// Define install button.
		JButton installNovacomdButton = new JButton("Run Bootstrap");

		// Make install button perform an action.
		installNovacomdButton.addActionListener(new ActionListener() {

			// Every time the button is pressed, this action event will be executed.
			public void actionPerformed(ActionEvent evt) {

				// Run the function to install novacomd.
				installNovacomdButtonActionPerformed(evt);

			}

		});

		// Declare about label.
		JLabel aboutLabel = new JLabel("A modern novacomd installer for all UNIX-like systems.");
		// Make about label italic.
		aboutLabel.setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 12));

		// Declare copyright label.
		JLabel copyrightLabel = new JLabel("novacomd license");
		// Make copyright label look and act like a URL.
		urlLabelTransform(copyrightLabel);

		// Make copyright label perform an action.
		copyrightLabel.addMouseListener(new MouseAdapter() {

			// Every time the label is pressed, this mouse event will be executed.
			public void mouseClicked(MouseEvent event) {

				// Open the novacomd license in the system's web browser.
				urlOpen("https://www.apache.org/licenses/LICENSE-2.0.txt");

			}

		});

		// Declare developer label.
		JLabel devLabel = new JLabel("Source Code");
		// Make developer label look and act like a URL.
		urlLabelTransform(devLabel);

		// Make developer label perform an action.
		devLabel.addMouseListener(new MouseAdapter() {

			// Every time the label is pressed, this mouse event will be executed.
			public void mouseClicked(MouseEvent event) {

				// Open the source code in the system's web browser.
				urlOpen("https://github.com/NotAlexNoyle/novacomd-bootstrap");

			}

		});

		// Set BoxLayout for window frame.
		mainFrame.getContentPane().setLayout(new BoxLayout(mainFrame.getContentPane(), BoxLayout.Y_AXIS));
		// Set BoxLayout for panel on frame.
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		// Declare spacers.
		JComponent topSpacer = new Box.Filler(new Dimension(100, 30), new Dimension(100, 30), new Dimension(100, 30));
		JComponent aboutSpacer = new Box.Filler(new Dimension(100, 20), new Dimension(100, 20), new Dimension(100, 20));
		JComponent devSpacer = new Box.Filler(new Dimension(100, 20), new Dimension(100, 20), new Dimension(100, 20));

		// Center-align components on panel.
		installNovacomdButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		aboutLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		devLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		copyrightLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		copyrightLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// Prevent button from getting an outline on it after being clicked.
		installNovacomdButton.setFocusPainted(false);

		// Add components to panel.
		mainFrame.add(topSpacer);
		mainFrame.add(installNovacomdButton);
		mainFrame.add(aboutSpacer);
		mainFrame.add(aboutLabel);
		mainFrame.add(aboutLabel);
		mainFrame.add(devSpacer);
		mainFrame.add(devLabel);
		mainFrame.add(copyrightLabel);

		// Set window frame properties and display the panel on it.
		mainFrame.getContentPane().add(mainPanel);
		mainFrame.setResizable(false);
		mainFrame.setBounds(150, 150, 350, 200);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);

	}

	// Action to be performed when the install button is pressed.
	private static void installNovacomdButtonActionPerformed(java.awt.event.ActionEvent evt) {

		// TODO: Install novacomd
		JOptionPane.showMessageDialog(null, "The back-end to this program is incomplete. Novacomd will not be installable until it is.", "Error", JOptionPane.ERROR_MESSAGE);

	}

	// Displays an error if a link is not found.
	private static void urlOpen(String url) {

		// Safely open URL.
		try {

			// Open URL using desktop's default URL handler (usually a web browser).
			Desktop.getDesktop().browse(new URI(url));

		}
		// Check for errors while opening URL.
		catch (IOException | URISyntaxException error) {

			// Display error to user if URL opening encountered errors.
			JOptionPane.showMessageDialog(null, "Failed to open URL: " + url, "Error", JOptionPane.ERROR_MESSAGE);
			// Display a more detailed error in the console for bug reporting.
			System.out.println(error.getMessage());

		}

	}

	// Applies URL-like style to labels.
	private static void urlLabelTransform(JLabel label) {

		// Set the color of the label to the standard URL color.
		label.setForeground(Color.BLUE.darker());
		// Make hovering over the label display a hand cursor.
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	}

}