package aufgabe3;

import java.awt.*;

import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import aufgabe1_1.Complex;

/**
 * 
 * @author RSEfi
 * @version v0.2 (23.11.13)
 */
public class GUI extends JFrame implements Serializable, ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 10;
	private JPanel contentPane;	
	private JList list;
	private DefaultListModel listModel;
	private JTextField textSum;
	private JTextField textProd;
	private JTextField textImag;
	private JTextField textReal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI("Complex Number");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param Frame title 
	 */
	public GUI(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		Container cp = getContentPane();
		cp.setLayout(null);
		
		// Panel fürs Koordinatensystem
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 261, 261);
		panel.paintComponents(getGraphics());
		cp.add(panel);
		
		// Textfeld Summe
		textSum = new JTextField();
		textSum.setBounds(344, 13, 86, 20);
		getContentPane().add(textSum);
		textSum.setColumns(10);		
		
		// Texfeld Produkt
		textProd = new JTextField();
		textProd.setBounds(344, 44, 86, 20);
		getContentPane().add(textProd);
		textProd.setColumns(10);		
		
		// Liste
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(344, 75, 90, 79);
		getContentPane().add(scrollPane);		
		listModel = new DefaultListModel();
		list = new JList(listModel);
		scrollPane.setViewportView(list);				
		cp.add(new JLabel("Scrollable list", JLabel.CENTER));				
		list.addListSelectionListener(this);
					
		// Textfeld Realteil
		textReal = new JTextField();
		textReal.setColumns(10);
		textReal.setBounds(271, 163, 30, 20);
		getContentPane().add(textReal);
		
		// Label +j
		JLabel lblJ = new JLabel("+ j");
		lblJ.setBounds(309, 166, 21, 14);
		cp.add(lblJ);
		
		// Textfeld Imaginärteil
		textImag = new JTextField();
		textImag.setBounds(340, 163, 30, 20);
		getContentPane().add(textImag);
		textImag.setColumns(10);
		
		// Add Button
		JButton btnAdd = new JButton("add");
		btnAdd.setBounds(370, 163, 60, 20);
		btnAdd.setActionCommand("add");
		btnAdd.addActionListener(this);
		cp.add(btnAdd);
		
		// Random Button
		JButton btnRandom = new JButton("random");
		btnRandom.setBounds(360, 192, 70, 20);
		btnRandom.setActionCommand("rand");
		btnRandom.addActionListener(this);
		cp.add(btnRandom);
		
		// Remove Button
		JButton btnRemove = new JButton("remove");
		btnRemove.setBounds(360, 223, 70, 20);
		btnRemove.setActionCommand("del");
		btnRemove.addActionListener(this);
		cp.add(btnRemove);
		
		setResizable(false);
	    setVisible(true);		
		// GUI Ende
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if("del".equals(e.getActionCommand())){
			int[] toRemove = list.getSelectedIndices();
			for(int index = toRemove.length-1 ; index >= 0 ; index--){
				listModel.remove(toRemove[index]);
			}
		}
		else if("add".equals(e.getActionCommand())){
			Complex cpz = new Complex(Double.parseDouble(textReal.getText()),Double.parseDouble(textImag.getText()));
			if (listModel.contains(cpz)) return;
			listModel.addElement (cpz);
			list.setModel(listModel);
		}
		else if("rand".equals(e.getActionCommand())){
			Complex cpz = new Complex (Math.rint(Math.random()*100/100*5), Math.rint(Math.random()*10/10*5));
			if (listModel.contains(cpz)) return;
			listModel.addElement (cpz);
			list.setModel(listModel);
		}		
	}

	@Override
	public void valueChanged(ListSelectionEvent evt) {
		   //Summe/Produkt
		  Complex cp1, cp2, mul = null, sum = null;
		  int[] sel = list.getSelectedIndices();
		  for (int i = 0; i < sel.length; i++){
			  cp1 = (Complex)listModel.getElementAt(sel[i]);
		  }
		  if (sel.length >= 2){
			  for (int i = 0; i < sel.length-1; i++){
				  if (i < 1){
					  cp1 = (Complex)listModel.getElementAt(sel[i]);
					  cp2 = (Complex)listModel.getElementAt(sel[i+1]);
					  sum = Complex.add(cp1, cp2);
					  mul = Complex.mul(cp1, cp2);
				  }else{
					  cp1 = (Complex)listModel.getElementAt(sel[i+1]);
					  sum = Complex.add(sum, cp1);
					  mul = Complex.mul(mul, cp1);
				  }
			  }
			  textSum.setText(sum.toString());
			  textProd.setText(mul.toString());
		  }else if (sel.length == 1){ 
			  cp1 = (Complex)listModel.getElementAt(sel[0]);
			  mul = cp1;
			  sum = cp1;
			  textSum.setText(sum.toString());
			  textProd.setText(mul.toString());  
			  
		  }else{
			  textSum.setText("");
			  textProd.setText("");
		  }		
	}
	
	/**
	 * 
	 * Zeichnen funzt noch nicht
	 *
	 */
	public class PaintComplex extends JPanel {
		/**
		* 
		*/
		private static final long serialVersionUID = 1;
		private Point center;

		public void paintComponent(Graphics g){
			super.paintComponent(g);
				
			Graphics2D g2 = (Graphics2D) g;
								
			//draw x-y-ordinates
			center = getCenter(this);
			g2.drawLine(center.x,center.y, getWidth()-5, center.y);
			g2.drawLine(center.x,center.y, 5, center.y);
			g2.drawLine(center.x,center.y, center.x, 5);
			g2.drawLine(center.x,center.y, center.x, getHeight()-5);

		}
		public  Point getCenter(PaintComplex panel){
			int x = panel.getWidth() / 2;
			int y = panel.getHeight() / 2;
			return new Point(x, y);
		}
	}
}

