package aufgabe3;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import aufgabe1_1.Complex;

/**
 * @author RSEfi
 * @version v0.4 (27.11.13)
 */
public class GUI extends JFrame implements Serializable, ActionListener, ListSelectionListener{

	private static final long serialVersionUID = 10;
	private JPanel contentPane;
	private JTextField textSum;
	private JTextField textProd;
	private JTextField textReal;
	private JTextField textImag;
	private DefaultListModel<Complex> listModel;
	private JList list;
	private JTextField textRe;
	private JTextField textIm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI("Complex Number");
					//frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI(String title) {
		super(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {28};
		gbl_contentPane.rowHeights = new int[] {17};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPane.setLayout(gbl_contentPane);	
		
		// Koodrinatensystem
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		PaintComplex koord = new PaintComplex();
		gbc_panel.gridwidth = 17;
		gbc_panel.gridheight = 17;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel.add(koord), gbc_panel);
		//panel.add(koord);
		
		// Anzeige der Complexen Summe
		JLabel lblSum = new JLabel("Summe =");
		GridBagConstraints gbc_lblSum = new GridBagConstraints();
		gbc_lblSum.anchor = GridBagConstraints.EAST;
		gbc_lblSum.gridwidth = 5;
		gbc_lblSum.insets = new Insets(0, 0, 5, 5);
		gbc_lblSum.gridx = 18;
		gbc_lblSum.gridy = 1;
		contentPane.add(lblSum, gbc_lblSum);
		
		textSum = new JTextField();
		textSum.setEditable(false);
		GridBagConstraints gbc_textSum = new GridBagConstraints();
		gbc_textSum.gridwidth = 5;
		gbc_textSum.insets = new Insets(0, 0, 5, 0);
		gbc_textSum.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSum.gridx = 24;
		gbc_textSum.gridy = 1;
		contentPane.add(textSum, gbc_textSum);
		textSum.setColumns(10);
				
		// Anzeige des Complexen Produkts
		JLabel lblProd = new JLabel("Produkt =");
		GridBagConstraints gbc_lblProd = new GridBagConstraints();
		gbc_lblProd.anchor = GridBagConstraints.EAST;
		gbc_lblProd.gridwidth = 5;
		gbc_lblProd.insets = new Insets(0, 0, 5, 5);
		gbc_lblProd.gridx = 18;
		gbc_lblProd.gridy = 3;
		contentPane.add(lblProd, gbc_lblProd);
		
		textProd = new JTextField();
		textProd.setEditable(false);
		GridBagConstraints gbc_textProd = new GridBagConstraints();
		gbc_textProd.gridwidth = 5;
		gbc_textProd.insets = new Insets(0, 0, 5, 0);
		gbc_textProd.fill = GridBagConstraints.HORIZONTAL;
		gbc_textProd.gridx = 24;
		gbc_textProd.gridy = 3;
		contentPane.add(textProd, gbc_textProd);
		textProd.setColumns(10);
		
		// JScrollPane
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 23;
		gbc_scrollPane.gridy = 5;
		contentPane.add(scrollPane, gbc_scrollPane);
		
		// Liste
		listModel = new DefaultListModel<Complex>();
		list = new JList(listModel);
		scrollPane.setViewportView(list);
		list.addListSelectionListener(this);
	
		// Hinzufügen Button
		JButton btnAdd = new JButton("Add");
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.EAST;
		gbc_btnAdd.gridwidth = 3;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdd.gridx = 26;
		gbc_btnAdd.gridy = 12;
		btnAdd.setActionCommand("add");
		btnAdd.addActionListener(this);
		
		textRe = new JTextField();
		GridBagConstraints gbc_textRe = new GridBagConstraints();
		gbc_textRe.anchor = GridBagConstraints.EAST;
		gbc_textRe.gridwidth = 3;
		gbc_textRe.insets = new Insets(0, 0, 5, 5);
		gbc_textRe.gridx = 18;
		gbc_textRe.gridy = 12;
		contentPane.add(textRe, gbc_textRe);
		textRe.setColumns(10);
		
		JLabel lblj = new JLabel("+j");
		GridBagConstraints gbc_lblj = new GridBagConstraints();
		gbc_lblj.anchor = GridBagConstraints.EAST;
		gbc_lblj.insets = new Insets(0, 0, 5, 5);
		gbc_lblj.gridx = 21;
		gbc_lblj.gridy = 12;
		contentPane.add(lblj, gbc_lblj);
		
		textIm = new JTextField();
		GridBagConstraints gbc_textIm = new GridBagConstraints();
		gbc_textIm.anchor = GridBagConstraints.WEST;
		gbc_textIm.gridwidth = 4;
		gbc_textIm.insets = new Insets(0, 0, 5, 5);
		gbc_textIm.gridx = 22;
		gbc_textIm.gridy = 12;
		contentPane.add(textIm, gbc_textIm);
		textIm.setColumns(10);
		contentPane.add(btnAdd, gbc_btnAdd);
		
		// Zufallszahl hinzufügen Button
		JButton btnRand = new JButton("Random");
		GridBagConstraints gbc_btnRand = new GridBagConstraints();
		gbc_btnRand.anchor = GridBagConstraints.EAST;
		gbc_btnRand.gridwidth = 3;
		gbc_btnRand.insets = new Insets(0, 0, 5, 0);
		gbc_btnRand.gridx = 26;
		gbc_btnRand.gridy = 14;
		btnRand.setActionCommand("rand");
		btnRand.addActionListener(this);
		contentPane.add(btnRand, gbc_btnRand);
		
		// Entfernen Button
		JButton btnRemove = new JButton("Remove");
		GridBagConstraints gbc_btnRemove = new GridBagConstraints();
		gbc_btnRemove.anchor = GridBagConstraints.EAST;
		gbc_btnRemove.gridwidth = 3;
		gbc_btnRemove.gridx = 26;
		gbc_btnRemove.gridy = 16;
		btnRemove.setActionCommand("del");
		btnRemove.addActionListener(this);
		contentPane.add(btnRemove, gbc_btnRemove);
		
		// GUI Ende
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if("del".equals(e.getActionCommand())){
			int[] toRemove = list.getSelectedIndices();
			for(int index = toRemove.length-1 ; index >= 0 ; index--){
				listModel.remove(toRemove[index]);
			}
			repaint();
		}
		else if("add".equals(e.getActionCommand())){
			Complex cpz = new Complex(Double.parseDouble(textRe.getText()),Double.parseDouble(textIm.getText()));
			if (listModel.contains(cpz)){
				return;
			}
			listModel.addElement (cpz);
			list.setModel(listModel);
			repaint();
		}
		else if("rand".equals(e.getActionCommand())){
			Complex cpz = new Complex (Math.rint(Math.random()*100/100*5), Math.rint(Math.random()*10/10*5));
			if (listModel.contains(cpz)) {
				return;
			}
			listModel.addElement (cpz);
			list.setModel(listModel);
			repaint();
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
		  repaint();
	}
	
	public class PaintComplex extends JPanel {
		private Point center;
		private Point koord;
		private Point max;
		/**
		 * 
		 */		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			// Koordinatensystem
			center = getCenter(this);
			max = getMax();
			g.setColor(Color.BLACK);
			g.drawLine(center.x,center.y, getWidth()-5, center.y);
			g.drawLine(center.x,center.y, 5, center.y);
			g.drawLine(center.x,center.y, center.x, 5);
			g.drawLine(center.x,center.y, center.x, getHeight()-5);
			//g.drawLine(max.x-, center.y, );
			
			// alle Zeiger aus Liste
			g.setColor(Color.GREEN);
			for (int i = 0 ; i < listModel.getSize() ; i++) {
				koord = getKoord(listModel.elementAt(i).getReal(), listModel.elementAt(i).getImag());
				g.drawLine(center.x, center.y, koord.x, koord.y);
			}
			
			// Markierte Zeiger aus Liste
			g.setColor(Color.BLUE);
			int[] sel = list.getSelectedIndices();
			for (int i = 0 ; i < sel.length ; i++) {
				koord = getKoord(listModel.elementAt(sel[i]).getReal(), listModel.elementAt(sel[i]).getImag());
				g.drawLine(center.x, center.y, koord.x, koord.y);
			}
			System.out.println(max);
			
		}
		public  Point getCenter(PaintComplex panel){
			int x = panel.getWidth() / 2;
			int y = panel.getHeight() / 2;
			//System.out.printf("X: %d   Y: %d\n", x, y);
			return new Point(x, y);
		}
		public Point getKoord(double re, double im){			
			int x = ((int) re) * 10 + center.x;
			int y = ((int) im) * (-10) + center.x;
			
			return new Point(x, y);
		}
		public Point getMax(){
			int maxRe = 0;
			int maxIm = 0;
			
			for (int i = 0 ; i < listModel.size() ; i++) {
				if (maxRe < listModel.getElementAt(i).getReal()){
					maxRe = (int)listModel.getElementAt(i).getReal();
				}
				if (maxIm < listModel.getElementAt(i).getImag()){
					maxIm = (int)listModel.getElementAt(i).getImag();
				}
			}			
			return new Point(maxRe, maxIm);
		}

	}

}
