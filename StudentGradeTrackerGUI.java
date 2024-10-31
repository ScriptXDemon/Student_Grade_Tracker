import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StudentGradeTrackerGUI extends JFrame {
    private JTextField numStudentsField;
    private JTextField gradeField;
    private JButton addGradeButton;
    private JButton calculateButton;
    private JLabel resultLabel;
    private ArrayList<Integer> grades;
    private int numStudents;

    // Constructor to set up GUI components
    public StudentGradeTrackerGUI() {
        grades = new ArrayList<>();
        numStudents = 0;
        
        // Set up the JFrame
        setTitle("Student Grade Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create components
        numStudentsField = new JTextField(5);
        gradeField = new JTextField(5);
        addGradeButton = new JButton("Add Grade");
        calculateButton = new JButton("Calculate Statistics");
        resultLabel = new JLabel("<html>Enter the number of students and grades<br>Click 'Calculate Statistics' to view results.</html>");

        // Panel for entering number of students
        JPanel numStudentsPanel = new JPanel();
        numStudentsPanel.add(new JLabel("Number of students:"));
        numStudentsPanel.add(numStudentsField);

        // Panel for entering grades
        JPanel gradePanel = new JPanel();
        gradePanel.add(new JLabel("Enter grade (0-100):"));
        gradePanel.add(gradeField);
        gradePanel.add(addGradeButton);

        // Action for adding a grade
        addGradeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addGrade();
            }
        });

        // Action for calculating statistics
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateStatistics();
            }
        });

        // Layout setup
        setLayout(new GridLayout(5, 1, 10, 10));
        add(numStudentsPanel);
        add(gradePanel);
        add(calculateButton);
        add(resultLabel);
    }

    // Method to add a grade with validation
    private void addGrade() {
        if (numStudents == 0) {
            try {
                numStudents = Integer.parseInt(numStudentsField.getText());
                if (numStudents <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a positive number for the number of students.");
                numStudentsField.setText("");
                return;
            }
        }
        
        if (grades.size() >= numStudents) {
            JOptionPane.showMessageDialog(this, "All grades have been entered.");
            return;
        }

        try {
            int grade = Integer.parseInt(gradeField.getText());
            if (grade < 0 || grade > 100) {
                JOptionPane.showMessageDialog(this, "Please enter a valid grade between 0 and 100.");
            } else {
                grades.add(grade);
                gradeField.setText("");
                JOptionPane.showMessageDialog(this, "Grade added for student " + grades.size() + ".");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid number for the grade.");
        }
    }

    // Method to calculate and display statistics
    private void calculateStatistics() {
        if (grades.size() != numStudents) {
            JOptionPane.showMessageDialog(this, "Please enter grades for all students.");
            return;
        }

        int sum = 0, highest = grades.get(0), lowest = grades.get(0);
        for (int grade : grades) {
            sum += grade;
            if (grade > highest) highest = grade;
            if (grade < lowest) lowest = grade;
        }

        double average = sum / (double) numStudents;
        resultLabel.setText(String.format("<html>Average grade: %.2f<br>Highest grade: %d<br>Lowest grade: %d</html>", average, highest, lowest));
    }

    // Main method to launch the GUI application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentGradeTrackerGUI app = new StudentGradeTrackerGUI();
            app.setVisible(true);
        });
    }
}
