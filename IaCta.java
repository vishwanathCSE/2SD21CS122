import java.awt.*;
import java.awt.event.*;        // imoprt packages,classes,methods
import javax.swing.*;

 class WrongMarks extends Exception {
  public WrongMarks(String e) {
    super(e);                          // creating an customized Exception 
   }
  public String toString(){
    return "Input Error";
   }
}

 class Marks extends JFrame implements ActionListener {
    JFrame f ;
    JButton b;
    Container contpane;
    JPanel p,p1,p2,p3,p4;                               // decleration of object variables
    JLabel l,ia1,ia2,ia3,cta,see,index,m,g;
    JTextField t1,t2,t3,t4,t5;
     Marks(String title) {
        super(title);

        b = new JButton("Compute");
        b.addActionListener(this);
        b.setBackground(Color.WHITE);
        ia1 = new JLabel("    Enter the IA 1 marks:" );    // IA 1 input
        t1 = new JTextField(5);

        ia2 = new JLabel("    Enter the IA 2 marks:");    // IA 2 input
        t2 = new JTextField(5);

        ia3 = new JLabel("    Enter the IA 3 marks:");    // IA 3 input
        t3 = new JTextField(5); 

        cta = new JLabel("    Enter the CTA marks:");     // CTA input
        t4 = new JTextField(5);

        see = new JLabel("    Enter the SEE marks:");     // SEE inpute 
        t5 = new JTextField(5);
        index = new JLabel("                                                      Grade calculator");    // main heading 
        m = new JLabel("  Total Marks:");    
        g = new JLabel("   Grade:");

        l = new JLabel();
        p = new JPanel();
        p1 = new JPanel();
        p3 = new JPanel();                 // invoking objects 
        p2 = new JPanel();
        p4 =new JPanel();
        p.add(ia1);
        p1.add(t1);
        p.add(ia2);
        p1.add(t2);
        p.add(ia3);               //
        p1.add(t3);               //
        p.add(cta);               // pushing up all the objects into the panel      
        p1.add(t4);               //
        p.add(see);               //
        p1.add(t5);
        p.add(m) ;
        p.add(l);
        p1.add(g);
        p4.add(b);
         p.setBackground(Color.GRAY);      //  setting 
         p1.setBackground(Color.GRAY);     //     colour 
         p3.setBackground(Color.GRAY);     //         to 
         p4.setBackground(Color.GRAY);     //           panel background 
         p.setLayout(new GridLayout(7, 2, 30 , 30));
         p1.setLayout(new GridLayout(7, 2, 30, 30));       // setting up grid
        contpane = this.getContentPane();
        contpane.add(p,BorderLayout.WEST);
        contpane.add(index,BorderLayout.NORTH);
        contpane.add(p1,BorderLayout.CENTER);      // alignment of panel into content pane 
        contpane.add(p3,BorderLayout.EAST);
        contpane.add(p4,BorderLayout.SOUTH);
        contpane.setBackground(Color.GRAY);
     }

     @Override
      public void actionPerformed(ActionEvent e) {
        double sum,cie;
        
        double ia1 = Double.parseDouble(t1.getText());     //  taking input
        double ia2 = Double.parseDouble(t2.getText());
        double ia3 = Double.parseDouble(t3.getText());
        double cta = Double.parseDouble(t4.getText());
        double see = Double.parseDouble(t5.getText());

       try {                                             // try catch methods START
          if ( ia1<0 || ia1>20)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "IA1 marks out of range", "Marks out of range", JOptionPane.ERROR_MESSAGE); 
          }
       try {
          if ( ia2<0 || ia2>20)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "IA2 marks out of range", "Marks out of range", JOptionPane.ERROR_MESSAGE); 
          }
       try {
          if ( ia3<0 || ia3>20)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "IA3 marks out of range", "Marks out of range", JOptionPane.ERROR_MESSAGE); 
          }
       try {
          if ( cta<0 || cta>10)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "CTA marks out of range", "Marks out of range", JOptionPane.ERROR_MESSAGE); 
          }
       try {
          if ( see<0 || see>100)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "SEE marks out of range", "Marks out of range", JOptionPane.ERROR_MESSAGE); 
          }
       try {
          if ( see<38)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "SEE exam failed", "Exam Failed", JOptionPane.ERROR_MESSAGE); 
          }                               // try catch END
         if(ia1>ia3 && ia2>ia3)
           cie = ia1 + ia2 + cta;
        else if(ia1>ia2 && ia3>ia2)          //computing
           cie = ia1 + ia3 + cta;
        else 
           cie = ia2 + ia3 + cta;
       try {                            // again try catch 
          if ( cie<20)
              throw new WrongMarks("wrong") ;
        }
          catch (WrongMarks wm){
            JOptionPane.showMessageDialog(null, "Student is detained from taking SEE ", "Detained", JOptionPane.ERROR_MESSAGE); 
          }
                               //END
             see = see/2;
          if (see%1==0.5){
              see=see+1;
             see = see-0.5;}
              sum = see + cie ;

          if (sum>100)    
            m.setText("  Total marks:");
          else
            m.setText("  Total marks:"+sum);  

        if(cie<20)
          g.setText("  The grade is : "); 
        else if(see<38 && sum<=40)
          g.setText("  The grade is : F");
        else if (sum>=90 && sum <=100)
          g.setText("  The grade is : S");
        else if(sum>=80 && sum <=89)
          g.setText("  The grade is : A");                     
        else if(sum>=70 && sum <=79)
          g.setText("  The grade is : B");                    // computing again
        else if(sum>=60 && sum <=69)
          g.setText("  The grade is : C");
        else if(sum>=50 && sum<= 59)
          g.setText("  The grade is : D");
        else if(sum>=40 && sum <=49)
          g.setText("  The grade is : E");
        else 
          System.out.println("");

        }
 }

 public class IaCta{
    public static void main(String[] args) {
     JFrame f = new Marks("Student Grading System");
      f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);     // main method
      f.setBounds(100, 100, 450, 450);
      f.setVisible(true);
   }
 }