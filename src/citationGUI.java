/**
 * Autor : Sahil Agrawal
 * Description: Creates 2 different citations based on the users input
 * Version: 1.0
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class citationGUI extends JFrame {
    private Citation cite;
    JTextField firstName,lastName,answer;
    JRadioButton IEEE;
    JRadioButton ACM;

    /**
     * the function that creates the gui for the citation maker
     * @param cite
     */
    public citationGUI(Citation cite){
        super("Citation");
        this.cite = cite;
        JFrame frame = new JFrame("Citation");
        frame.setLayout(new GridLayout(4,2));

        frame.setSize(300,300);

        JLabel first = new JLabel("First Name:");
        JLabel last = new JLabel("Last Name:");

        firstName = new JTextField();
        lastName = new JTextField();
        answer = new JTextField();

        answer.setEditable(false);
        /**
         * An action event if you click enter on the text box it will format the text
         */

        Action actionFirst = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String format = firstName.getText();
                format = format.replaceAll("[0-9.]","");
                if(format == null || format.isEmpty()){
                    firstName.setText(format);
                }else{
                    firstName.setText(format.substring(0,1).toUpperCase()+format.substring(1).toLowerCase());
                }

            }
        };

        Action actionSecond = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String format = lastName.getText();
                format = format.replaceAll("[0-9.]","");
                if(format == null || format.isEmpty()){
                    lastName.setText(format);
                }else{
                    lastName.setText(format.substring(0,1).toUpperCase()+format.substring(1).toLowerCase());
                }
            }
        };

        IEEE = new JRadioButton("IEEE");
        ACM = new JRadioButton("ACM");
        /**
         * The action events for the buttons, if the text boxes are not filled it will ask the user to fill
         * in the boxes before giving an answer
         */
        ACM.addActionListener(new ActionListener() {
                                  @Override
                                  public void actionPerformed(ActionEvent e) {
                                      String f = firstName.getText();
                                      String l = lastName.getText();
                                      if(firstName.getText().isEmpty()||lastName.getText().isEmpty()){
                                          answer.setText("Please enter all values");
                                      }else {
                                          String formatLastName = lastName.getText();
                                          formatLastName = formatLastName.replaceAll("[0-9.]","");
                                          lastName.setText(formatLastName.substring(0,1).toUpperCase()+formatLastName.substring(1).toLowerCase());
                                          String formatFirstName = firstName.getText();
                                          formatFirstName = formatFirstName.replaceAll("[0-9.]","");
                                          firstName.setText(formatFirstName.substring(0,1).toUpperCase()+formatFirstName.substring(1).toLowerCase());
                                          answer.setText(cite.ACM(formatFirstName, formatLastName));
                                      }
                                  }
                              });


        IEEE.addActionListener(new ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent e) {

                                       String f = firstName.getText();
                                       String l = lastName.getText();

                                       if(firstName.getText().isEmpty()||lastName.getText().isEmpty()){
                                           answer.setText("Please enter all values");
                                       }else {
                                           String formatLastName = lastName.getText();
                                           formatLastName = formatLastName.replaceAll("[0-9.]","");
                                           lastName.setText(formatLastName.substring(0,1).toUpperCase()+formatLastName.substring(1).toLowerCase());
                                           String formatFirstName = firstName.getText();
                                           formatFirstName = formatFirstName.replaceAll("[0-9.]","");
                                           firstName.setText(formatFirstName.substring(0,1).toUpperCase()+formatFirstName.substring(1).toLowerCase());
                                           answer.setText(cite.IEEE(formatFirstName, formatLastName));
                                       }
                                   }
                               });
        firstName.addActionListener(actionFirst);
        lastName.addActionListener(actionSecond);
        frame.add(first);
        frame.add(firstName);
        frame.add(last);
        frame.add(lastName);
        ButtonGroup group = new ButtonGroup();
        group.add(IEEE);
        group.add(ACM);
        frame.add(IEEE);
        frame.add(ACM);
        frame.add(answer);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        Citation cite = new Citation();
        citationGUI mainFrame = new citationGUI(cite);
    }
}
