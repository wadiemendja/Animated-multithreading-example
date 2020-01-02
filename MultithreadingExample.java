import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MultithreadingExample {
    public static void main(String[] args) {
     JFrame window =new JFrame ("Processus");
     window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     window.setSize(500,500);
     window.setResizable(false);
     JPanel pan = new JPanel ();
     pan.setBackground(Color.yellow);
     pan.setLayout(null);
     pan.setBorder(BorderFactory.createLineBorder(Color.black));
     window.setContentPane(pan);
     JButton sqr1 = new JButton ();
     JButton sqr2 = new JButton ();
     JButton sqr3 = new JButton () ;
     JButton btn1 = new JButton ("Task 1") ;
     btn1.setBounds(30,400,100,50);
     pan.add(btn1);
     JButton btn2 = new JButton ("Task 2") ;
     btn2.setBounds(130,400,100,50);
     pan.add(btn2);
     JButton btn3 = new JButton ("Task 3") ;
     btn3.setBounds(230,400,100,50);
     pan.add(btn3);
     JButton btn4 = new JButton ("All Tasks") ;
     btn4.setBounds(330,400,150,50);
     pan.add(btn4);
     sqr1.setBounds(40,300,50,50);
     sqr1.setBackground(Color.black);
     sqr1.setEnabled(false);
     sqr2.setBounds(390,300,50,50);
     sqr2.setBackground(Color.black);
     sqr2.setEnabled(false);
     sqr3.setBounds(40,40,100,50);
     sqr3.setBackground(Color.black);
     sqr3.setEnabled(false);
     pan.add(sqr1);
     pan.add(sqr2);
     pan.add(sqr3);
     window.setVisible(true);
     btn1.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        btn1.setEnabled(false);

        Thread thread = new Thread() {
        @Override
        public void run() {
            Point point = sqr1.getLocation();
            Point point2 = sqr2.getLocation();
                while (point.x!=201) {
                    sqr1.setLocation(point.x,point.y);
                    point.x++ ;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {}
                }
                    while(sqr2.getLocation().x != 250){/* wait */}
                    point = sqr1.getLocation();
                    point2 = sqr2.getLocation();
                    while (point.y!=90) {
                        sqr2.setLocation(point2.x,point2.y);
                        sqr1.setLocation(point.x,point.y);
                        point.y-- ;
                        point2.y-- ;
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {}
                    }
              }
            };
            thread.start();
            }
        });
     btn2.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        btn2.setEnabled(false);
        Thread thread = new Thread() {
        Point point = sqr2.getLocation();
        Point point1 = sqr1.getLocation();
        @Override
        public void run() {
                while (point.x!=249) {
                    sqr2.setLocation(point.x,point.y);
                    point.x-- ;
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {}
                }
                    while(sqr1.getLocation().x != sqr2.getLocation().x -50){/* wait */}
                    
                     point = sqr2.getLocation();
                     point1 = sqr1.getLocation();
                     
                    while (point.y!=90) {
                        sqr2.setLocation(point.x,point.y);
                        sqr1.setLocation(point1.x,point1.y);
                        point.y-- ;
                        point1.y-- ;
                        try {
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {}
                    }
                }
            };
            thread.start();
            }
        });
     btn3.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e) {
        btn3.setEnabled(false);
        Thread thread = new Thread() {
        Point p3 = sqr3.getLocation();
        Point p1 = sqr1.getLocation();
        Point p2 = sqr2.getLocation();
        @Override
        public void run() {
                while (p3.x!=202) {
                    sqr3.setLocation(p3.x,40);
                    p3.x++ ;
                    try {                          
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {}
                }
                    while(sqr1.getLocation().y != 91){System.out.println();/* wait */} 
                    
                            p3 = sqr3.getLocation();
                            p1 = sqr1.getLocation();
                            p2 = sqr2.getLocation();
                            
                    while (p3.x!=500) {
                        sqr3.setLocation(p3.x,p3.y);
                        sqr1.setLocation(p1.x,p1.y);
                        sqr2.setLocation(p2.x,p2.y);
                        p3.x++ ;
                        p1.x++ ;
                        p2.x++ ;
                        try {             
                            Thread.sleep(20);
                        } catch (InterruptedException ex) {}
                    }
                }
            };
            thread.start();
            }
        });
     btn4.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            btn4.setEnabled(false);
            btn1.doClick();
            btn2.doClick();
            btn3.doClick();
         }
     }); 
    }
}