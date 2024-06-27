import javax.swing.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PetSelector extends JFrame {
    private PetDrawingPanel drawingPanel;
    public PetSelector() {
        setTitle("pet selector");
        setSize(450, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        drawingPanel = new PetDrawingPanel();
        drawingPanel.setPreferredSize(new Dimension(400, 400));

        JRadioButton pigButton = new JRadioButton("Pig");
        JRadioButton dogButton = new JRadioButton("Dog");
        JRadioButton catButton = new JRadioButton("Cat");
        JRadioButton rabbitButton = new JRadioButton("Rabbit");
        JRadioButton goatButton = new JRadioButton("Goat");

        ButtonGroup group = new ButtonGroup();
        group.add(pigButton);
        group.add(dogButton);
        group.add(catButton);
        group.add(rabbitButton);
        group.add(goatButton);

        pigButton.addActionListener(new PetActionListener("Pig"));
        dogButton.addActionListener(new PetActionListener("Dog"));
        catButton.addActionListener(new PetActionListener("Cat"));
        rabbitButton.addActionListener(new PetActionListener("Rabbit"));
        goatButton.addActionListener(new PetActionListener("Goat"));

        JPanel radioPanel = new JPanel(new GridLayout(5, 1));
        radioPanel.add(pigButton);
        radioPanel.add(dogButton);
        radioPanel.add(catButton);
        radioPanel.add(rabbitButton);
        radioPanel.add(goatButton);

        add(drawingPanel, BorderLayout.CENTER);
        add(radioPanel, BorderLayout.WEST);
    }
    private class PetActionListener implements ActionListener {
        private String petType;

        public PetActionListener(String petType) {
            this.petType = petType;
        }
        public void actionPerformed(ActionEvent e) {
            drawingPanel.setPetType(petType);
            drawingPanel.repaint();
        }
    }
    private class PetDrawingPanel extends JPanel {
        private String petType;

        public void setPetType(String petType) {
            this.petType = petType;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (petType == null) {
                return;
            }
            switch (petType) {
                case "Pig":
                    drawPig(g);
                    break;
                case "Dog":
                    drawDog(g);
                    break;
                case "Cat":
                    drawCat(g);
                    break;
                case "Rabbit":
                    drawRabbit(g);
                    break;
                case "Goat":
                    drawGoat(g);
                    break;
            }
        }
        private void drawPig(Graphics g) {
            g.setColor(Color.PINK);
            g.fillOval(150, 150, 100, 100);
            g.fillOval(170, 130, 60, 60);
            g.setColor(Color.BLACK);
            g.drawOval(190, 170, 20, 20);
            g.drawOval(180, 160, 10, 10);
            g.drawOval(210, 160, 10, 10);
        }
        private void drawDog(Graphics g) {
            g.setColor(Color.YELLOW);
            g.fillRect(160, 200, 100, 50);
            g.fillRect(170, 150, 60, 60);
            g.setColor(Color.BLACK);
            g.drawRect(190, 170, 20, 20);
            g.drawRect(180, 160, 10, 10);
            g.drawRect(210, 160, 10, 10);
        }
        private void drawCat(Graphics g) {
            g.setColor(Color.GRAY);
            g.fillOval(150, 200, 100, 50);
            g.fillOval(170, 150, 60, 60);
            g.setColor(Color.BLACK);
            g.drawOval(190, 170, 20, 20);
            g.drawOval(180, 160, 10, 10);
            g.drawOval(210, 160, 10, 10);
            g.drawLine(180, 180, 160, 170);
            g.drawLine(220, 180, 240, 170);
        }
        private void drawRabbit(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillOval(150, 200, 100, 50);
            g.fillOval(170, 150, 60, 60);
            g.fillRect(190, 90, 10, 60);
            g.fillRect(210, 90, 10, 60);
            g.setColor(Color.BLACK);
            g.drawOval(190, 170, 20, 20);
            g.drawOval(180, 160, 10, 10);
            g.drawOval(210, 160, 10, 10);
        }

        private void drawGoat(Graphics g) {
            g.setColor(Color.ORANGE);
            g.fillRect(150, 200, 100, 50);
            g.fillRect(170, 150, 60, 60);
            g.setColor(Color.BLACK);
            g.drawRect(190, 170, 20, 20);
            g.drawRect(180, 160, 10, 10);
            g.drawRect(210, 160, 10, 10);
            g.drawLine(170, 190, 160, 210);
            g.drawLine(230, 190, 240, 210);
        }
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PetSelector().setVisible(true);
            }
        });
    }
}