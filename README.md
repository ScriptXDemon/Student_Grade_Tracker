Student Grade Tracker GUI
A simple Java Swing application for tracking student grades, calculating the average, highest, and lowest grades among a set number of students.

Features
Input Student Count: Enter the number of students whose grades will be tracked.
Add Grades: Enter grades (0-100) for each student. Input validation ensures grades are within this range.
Calculate Statistics: After entering all grades, calculate the average, highest, and lowest grades with one click.
Getting Started
Prerequisites
Java Development Kit (JDK) 8 or above.
A Java IDE (like Eclipse, IntelliJ IDEA) or command line for running Java programs.
Installation
Clone this repository:
bash
Copy code
git clone https://github.com/ScriptXDemon/StudentGradeTrackerGUI.git
Open the project in your preferred IDE or navigate to the project directory in your terminal.
Usage
Run the StudentGradeTrackerGUI class.
bash
Copy code
javac StudentGradeTrackerGUI.java
java StudentGradeTrackerGUI
Enter the number of students in the field provided.
Add grades one at a time using the "Add Grade" button.
Once all grades are entered, click "Calculate Statistics" to view the average, highest, and lowest grades.
Code Structure
StudentGradeTrackerGUI class:
Fields: Contains fields for user input, buttons for actions, a result label, and an ArrayList to store grades.
Methods:
addGrade(): Validates and adds grades to the list.
calculateStatistics(): Calculates and displays the average, highest, and lowest grades.
Main Method: Initializes the GUI and makes it visible.
Screenshot

Contributing
Fork the repository.
Create a new branch (git checkout -b feature-branch).
Make your changes.
Commit your changes (git commit -m 'Add new feature').
Push to the branch (git push origin feature-branch).
Open a Pull Request.
