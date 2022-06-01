package com.company;

import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Quiz implements ActionListener {

    String[] questions=  {
                            "'Long vehicle' means a vehicle whose length exceeds?",
                            "Traffic participants are required to comply with:",
                            "How should the hemostatic tourniquet be applied?",
                            "In which cases is the operation of vehicles prohibited?"

    };
    String[] [] options=    {
            {"12m", "10m", "14", "20m"},
            {"Traffic rules", "All requirements listed", "Driving agent's instructions", "The significance of traffic lights"},
            {"10-15cm below the wound", "Directly on the wound", "Above the wound by 10-15cm", "2-5cm below the wound"},
            {"It has a different engine model", "It's equipped with studded tires", "The speedometer not work", "In any of this case"},

    };

    char[] answers= {
            'A',
            'B',
            'C',
            'D'
    };

    char guess;
    char answer;
    char index;
    int correct_quesses=0;
    int total_questions= questions.length;
    int result;
    int seconds=10;

    JFrame frame= new JFrame();
    JTextField textField= new JTextField();
    JTextArea textArea = new JTextArea();
    JButton buttonA= new JButton();
    JButton buttonB= new JButton();
    JButton buttonC= new JButton();
    JButton buttonD= new JButton();
    JLabel answer_labelA= new JLabel();
    JLabel answer_labelB= new JLabel();
    JLabel answer_labelC= new JLabel();
    JLabel answer_labelD= new JLabel();
    JLabel time_label = new JLabel();
    JLabel second_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JFormattedTextField();

    Timer timer= new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            second_left.setText(String.valueOf(seconds));
            if(seconds<=0){
                displayAnswer();
            }
        }
    });

    public  Quiz(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650,650);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(null);
        frame.setResizable(false);


        textField.setBounds(0,0,650,50);
        textField.setBackground(new Color(25,25,25));
        textField.setForeground(new Color(25,255,0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 30));
        textField.setBorder(BorderFactory.createBevelBorder(1));
        textField.setHorizontalAlignment(JTextField.CENTER);
        textField.setEditable(false);

        textArea.setBounds(0,50,650,100);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(25,25,25));
        textArea.setForeground(new Color(25,255,0));
        textArea.setFont(new Font("Ink Free", Font.BOLD, 30));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);


        buttonA.setBounds(0,150,100,100);
        buttonA.setFont(new Font("MV Boli", Font.BOLD, 20));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,250,100,100);
        buttonB.setFont(new Font("MV Boli", Font.BOLD, 20));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,350,100,100);
        buttonC.setFont(new Font("MV Boli", Font.BOLD, 20));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,450,100,100);
        buttonD.setFont(new Font("MV Boli", Font.BOLD, 20));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        answer_labelA.setBounds(125,150,500,100);
        answer_labelA.setBackground(new Color(20,50,50));
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("MV Boli", Font.BOLD, 25));
        answer_labelA.setText("Testing label A");

        answer_labelB.setBounds(125,250,500,100);
        answer_labelB.setBackground(new Color(20,50,50));
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("MV Boli", Font.BOLD, 25));
        answer_labelB.setText("Testing label B");

        answer_labelC.setBounds(125,350,500,100);
        answer_labelC.setBackground(new Color(20,50,50));
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("MV Boli", Font.BOLD, 25));
        answer_labelC.setText("Testing label C");


        answer_labelD.setBounds(125,450,500,100);
        answer_labelD.setBackground(new Color(20,50,50));
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("MV Boli", Font.BOLD, 25));
        answer_labelD.setText("Testing label D");

        second_left.setBounds(535,510,100,100);
        second_left.setBackground(new Color(25,25,25));
        second_left.setForeground(new Color(255,0,0));
        second_left.setFont(new Font("Ink Free", Font.ITALIC, 50));
        second_left.setBorder(BorderFactory.createBevelBorder(1));
        second_left.setOpaque(true);
        second_left.setHorizontalAlignment(JTextField.CENTER);
        second_left.setText(String.valueOf(seconds));

        time_label.setBounds(535,475,100,25);
        time_label.setBackground(new Color(50,50,50));
        time_label.setForeground(new Color(255,0,0));
        time_label.setFont(new Font("MV Boli", Font.PLAIN, 20));
        time_label.setHorizontalAlignment(JTextField.CENTER);
        time_label.setText("Hurry up!");

        number_right.setBounds(225,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("Ink Free", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(255,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font ("Ink Free", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);


        frame.add(time_label);
        frame.add(second_left);
        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textArea);
        frame.add(textField);
        frame.setVisible(true);

        nextQuestion();


    }

    public void nextQuestion(){
        if(index>= total_questions){
            results();
        }
        else{
            textField.setText("Question"+(index+1));
            textArea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
            timer.start();
        }

    }
    @Override
    public void actionPerformed(ActionEvent e){

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA){
            answer ='A';
            if(answer == answers[index]){
                correct_quesses++;
            }
        }
        if(e.getSource()==buttonB){
            answer ='B';
            if(answer == answers[index]){
                correct_quesses++;
            }
        }
        if(e.getSource()==buttonC){
            answer ='C';
            if(answer == answers[index]){
                correct_quesses++;
            }
        }
        if(e.getSource()==buttonD){
            answer ='D';
            if(answer == answers[index]){
                correct_quesses++;
            }
        }
        displayAnswer();

    }
    public void displayAnswer(){
        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index]!='A'){
            answer_labelA.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='B'){
            answer_labelB.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='C'){
            answer_labelC.setForeground(new Color(255,0,0));
        }
        if(answers[index]!='D'){
            answer_labelD.setForeground(new Color(255,0,0));
        }
        Timer pause= new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(25,255,0));
                answer_labelB.setForeground(new Color(25,255,0));
                answer_labelC.setForeground(new Color(25,255,0));
                answer_labelD.setForeground(new Color(25,255,0));

                answer =' ';
                seconds=10;
                second_left.setText(String.valueOf(seconds));
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();


            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results(){
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        result = (int)((correct_quesses/(double)total_questions)*100);
        textField.setText("Results!");
        textArea.setText(" ");
        answer_labelA.setText(" ");
        answer_labelB.setText(" ");
        answer_labelC.setText(" ");
        answer_labelD.setText(" ");


        number_right.setText("("+correct_quesses+"/"+total_questions+")");
        percentage.setText(result+"%");

        frame.add(percentage);
        frame.add(number_right);

    }

}