package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class DogSoundMatcher {
    private JFrame frame;
    private JLabel questionLabel;
    private JButton playSoundButton;
    private JPanel imagePanel;
    private Map<String, String> dogData; // Map of dog name to image path
    private String correctDog;

    public DogSoundMatcher() {
        // Initialize dog data
        dogData = new HashMap<>();
        dogData.put("Bulldog", "bulldog.jpg");
        dogData.put("Beagle", "beagle.jpg");
        dogData.put("Poodle", "poodle.jpg");

        // Randomly select the correct dog
        correctDog = dogData.keySet().toArray(new String[0])[(int) (Math.random() * dogData.size())];

        // Set up the GUI
        frame = new JFrame("Match Dog Sound to Picture");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        questionLabel = new JLabel("Which dog matches the sound?");
        questionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        playSoundButton = new JButton("Play Sound");
        playSoundButton.addActionListener(e -> playDogSound(correctDog));

        imagePanel = new JPanel();
        imagePanel.setLayout(new GridLayout(1, dogData.size()));

        for (String dog : dogData.keySet()) {
            JButton dogButton = new JButton(new ImageIcon(dogData.get(dog)));
            dogButton.addActionListener(new DogButtonListener(dog));
            imagePanel.add(dogButton);
        }

        frame.setLayout(new BorderLayout());
        frame.add(questionLabel, BorderLayout.NORTH);
        frame.add(playSoundButton, BorderLayout.CENTER);
        frame.add(imagePanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void playDogSound(String dog) {
        // Placeholder for playing sound logic
        System.out.println("Playing sound for: " + dog);
        // Use libraries like JavaFX MediaPlayer or external libraries for actual sound playback
    }

    private class DogButtonListener implements ActionListener {
        private String dog;

        public DogButtonListener(String dog) {
            this.dog = dog;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (dog.equals(correctDog)) {
                JOptionPane.showMessageDialog(frame, "Correct! It's a " + dog + "!");
            } else {
                JOptionPane.showMessageDialog(frame, "Wrong! Try again.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DogSoundMatcher::new);
    }
}
