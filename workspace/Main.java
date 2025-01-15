//Sophia Babayev
//1/14/2025
//Where the game is acually created with all the buttons doing different things with the Countrys class.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class Main 
{

  // array of 10 Country objects
  private Country[] countryArray = new Country[10];  
  // index of current shown country
  private int index = 0;
  private int rand;

  // GUI elements
  private JFrame jFrame = new JFrame("Countries");
  private ImageIcon img;
  private JLabel imageLabel;
  private JLabel outputLabel;
  private JTextField input;

  
  public static void main(String[] args) {
    // Create the GUI
    Main gui = new Main();
    gui.loadCountries();
    gui.showCountry();
  }

  
  //Postcondition: Reads in the data from the countries-data.csv file and fills in the countryArray with data.
  public void loadCountries() 
  {
    // Open the data file - do not change
    File file = new File("/workspaces/Countries/workspace/countries-data.csv");
    Scanner scan = null;
    try {
      scan = new Scanner(file);
    } catch(FileNotFoundException e) { 
        System.out.println("File not found");     
    }
     
    for(int i = 0; i < countryArray.length; i++){
      String input = scan.nextLine();
      String[] data = input.split(",");
      System.out.println("Read in " + data[0]);

      Country info = new Country(data[0], data[1], data[2], data[3]);
      countryArray[i] = info;
      System.out.println(countryArray[i].toString());

    }
     
    
  }

  
  //Postcondition: Will show the image associated with the current country in the GUI.
  public void showCountry() {
    // Get the country at index from countryArray
    // Get the country at variable index from the countryArray
    Country c = countryArray[index];
         
     
    // Use its get method to get the its image file name and save it into imagefile variable below instead of worldmap.jpg.
    String imagefile = "worldmap.jpg";
    imagefile = c.getImagefile();
    // Use the following code to create an new Image Icon and put it into the GUI
    img = new ImageIcon("/workspaces/Countries/workspace/" + imagefile);
    imageLabel.setIcon(img);
  }
  
  //Precondition: Next button muct be clicked.
  //Postcondition: If the index is greater than 9, set it back to 0. Clear the outputLabel to empty string using setText, and call showCountry(); method. It will also randomly print 1 of the 3 questions.
  public void nextButtonClick()
  {
    index++;
      if (index > 9){
        index = 0;
      }
      rand = (int)(Math.random()*3);
      if(rand == 0){
      outputLabel.setText("What country is this?");
      }
      else if( rand == 1){
        outputLabel.setText("Whats the capital?");
      }else{
      outputLabel.setText("What lanugage do they speak?");
      }
      showCountry();

  }
  
  //Precondition: Review button must be clicked
  //Postcondition: It shows the information about the current country to the user to review by calling the toStrng method.
  public void reviewButtonClick()
  {
    String review = countryArray[index].toString();
    System.out.println(review);
    outputLabel.setText(review);

  }

  //Precondition: Quiz button must be clicked.
  //Postcondition: pairs the correct answer type to the question being asked and cheaks to see if the user got it right.
  public void quizButtonClick()
  {
    
    if ( rand == 0 ){
      if (input.getText().contentEquals(countryArray[index].getName())) {
      outputLabel.setText("Correct!");
      }
      else {
      outputLabel.setText("NO!");
      }
    }
    if ( rand == 1 ){
      if (input.getText().contentEquals(countryArray[index].getCapital())) {
      outputLabel.setText("Correct!");
      }
      else {
      outputLabel.setText("NO!");
      }
    }
    if ( rand == 2 ){
      if (input.getText().contentEquals(countryArray[index].getlanguage())) {
      outputLabel.setText("Correct!");
      }
      else {
      outputLabel.setText("NO!");
      }
    }
    
  }




  /* Do NOT change anything below here */
  /* The Main() constructor is finished and will construct the GUI */
public Main() {
    jFrame.setLayout(new FlowLayout());
    jFrame.setSize(500, 360);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // buttons at the top
        JButton reviewButton = new JButton("Review");
        JButton quizButton = new JButton("Quiz");
        JButton newButton = new JButton("Next");
        jFrame.add(reviewButton);
        jFrame.add(quizButton);
        jFrame.add(newButton);
        
        // create a new image icon
        img = new ImageIcon("worldmap.jpg");
        // create a label to display image
        imageLabel = new JLabel(img);
        // and one for output
        outputLabel = new JLabel();
        jFrame.add(imageLabel);
        jFrame.add(outputLabel);

        input = new JTextField(20);
        jFrame.add(input);


        jFrame.setVisible(true);
        // add event listener for button click
        reviewButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      reviewButtonClick();
    }
        });
    quizButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) 
    {
      quizButtonClick();
    }
    });
   
   newButton.addActionListener(new ActionListener()  {
    public void actionPerformed(ActionEvent e) 
    {
      nextButtonClick();
    }
   });
}
  

}
