package presentation;

import buisinesslogic.OrderManager;
import domain.OrderList;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class OrderFrame extends JFrame {

	public static void main(String[] args) {
            //Aanmaken van frame en paneel
		JFrame frame = new JFrame();
		frame.setSize(1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bestellingsoverzicht");
		
		JPanel paneel = new Paneel();
	    frame.setContentPane( paneel );
	    frame.setVisible(true);
	}
	

}

class Paneel extends JPanel {
	private static final long serialVersionUID = 1L;
        //Declareren van alle componenten die aanwezig zijn
        //op het paneel.
        private JPanel menu;
        private JPanel overview;
        private OrderList ol;
        public OrderManager o = new OrderManager();
        
        private JButton m1, m2, d1, d2;
	
	  public Paneel() {
              //Grid layout met oneindig aantal rijen en een maximum van 4 kolommen
              setLayout(new GridLayout( 0, 4, 5, 5));
              
                  m1 = new JButton(o.getAllMeals().get(1).getName() + "\n " + o.getAllMeals().get(1).getPrice());
                  m1.addActionListener(new m1Handler());
                  
                  m2 = new JButton(o.getAllMeals().get(2).getName() + "\n " + o.getAllMeals().get(2).getPrice());
                  m2.addActionListener(new m2Handler());
                  
                  d1 = new JButton(o.getAllDrinks().get(1).getName() + "\n " + o.getAllDrinks().get(1).getPrice());
                  d1.addActionListener(new d1Handler());
                  
                  d2 = new JButton(o.getAllDrinks().get(2).getName() + "\n " + o.getAllDrinks().get(2).getPrice());
                  d2.addActionListener(new d2Handler());
                  
                  menu = new JPanel();
                  menu.add(m1);
                  menu.add(m2);
                  menu.add(d1);
                  menu.add(d2);
                  //Voeg alle componenten
                  add(menu);
                  add(overview);
	  }
          
          class m1Handler implements ActionListener {
                         public void actionPerformed( ActionEvent e )
                          {
                              ol.addConsumable(o.getAllMeals().get(1));
                          }
                  }
          
          class m2Handler implements ActionListener {
                         public void actionPerformed( ActionEvent e )
                          {
                              ol.addConsumable(o.getAllMeals().get(2));
                          }
                  }
          
          class d1Handler implements ActionListener {
                         public void actionPerformed( ActionEvent e )
                          {
                              ol.addConsumable(o.getAllDrinks().get(1));
                          }
                  }
          
          class d2Handler implements ActionListener {
                         public void actionPerformed( ActionEvent e )
                          {
                              ol.addConsumable(o.getAllDrinks().get(2));
                          }
                  }
}


