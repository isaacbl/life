import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;

public class Lanzar extends JFrame	 {
	
	JButton boton,botonN;
	JToolBar toolbar;
	JPanel panel;
	JScrollPane sPane;
	
	public Lanzar(){
		super("Juego de la vida - Isaac Baza López");
		final Panel pec = new Panel(900, 900);
		
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		setMinimumSize(new Dimension(1600,900));
		setResizable(true);
		
		toolbar = new JToolBar();
		
		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.gridx =0;
		gc.gridy =0;
		gc.gridheight=1;
		gc.gridwidth=1;
		
		add(toolbar,gc);
		
		toolbar.setLayout(new GridBagLayout());
		
		boton = new JButton();
		boton.setText("Empezar");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pec.setEstado(true);
				botonN.setEnabled(false);
				
				
				
			}
		});
		
		gc.fill = GridBagConstraints.WEST;
		gc.gridx =0;
		gc.gridy =0;
		gc.gridheight=1;
		gc.gridwidth=1;
		toolbar.add(boton,gc);
		
		
		boton = new JButton();
		boton.setText("Detener");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				pec.setEstado(false);
				botonN.setEnabled(true);
			}
		});
		
		gc.fill = GridBagConstraints.WEST;
		gc.gridx =1;
		gc.gridy =0;
		gc.gridheight=1;
		gc.gridwidth=1;
		toolbar.add(boton,gc);
		
		botonN = new JButton();
		botonN.setText("Paso");
		botonN.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pec.nextFase();
				
			}
		});
		gc.fill = GridBagConstraints.NONE;
		gc.gridx =2;
		gc.gridy =0;
		gc.gridheight=1;
		gc.gridwidth=1;
		toolbar.add(botonN,gc);
		
		
		
		boton = new JButton();
		boton.setText("Reset");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pec.reiniciar();
				pec.setEstado(false);
				botonN.setEnabled(true);
			}
		});
		
		gc.fill = GridBagConstraints.EAST;
		gc.gridx =3;
		gc.gridy =0;
		gc.gridheight=1;
		gc.gridwidth=1;
		toolbar.add(boton,gc);
		
		boton = new JButton();
		boton.setText("Acercar");
		
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pec.setZoom(pec.getZoom()+2);
				
			}
		});
		gc.fill = GridBagConstraints.EAST;
		gc.gridx =4;
		gc.gridy =0;
		gc.gridheight=1;
		gc.gridwidth=1;
		toolbar.add(boton,gc);
		
		boton = new JButton();
		boton.setText("Alejar");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pec.setZoom(pec.getZoom()-2);
				
			}
		});
		gc.fill = GridBagConstraints.EAST;
		gc.gridx =5;
		gc.gridy =0;
		gc.gridheight=1;
		gc.gridwidth=1;
		toolbar.add(boton,gc);
		
		boton = new JButton();
		boton.setText("Aleatorias");
		boton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				pec.setAleatorias();
				
			}
		});
		gc.fill = GridBagConstraints.CENTER;
		gc.gridx =6;
		gc.gridy =0;
		gc.gridheight=1;
		gc.weightx = 0;
		gc.weighty = 2;
		gc.gridwidth=1;
		toolbar.add(boton,gc);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		gc.fill = GridBagConstraints.BOTH;
		gc.gridx =0;
		gc.gridy =1;
		gc.gridheight=4;
		gc.gridwidth=1;
		gc.weightx=5;
		gc.weighty=5;
		
		add(pec,gc);
		
		new Thread (pec).start();   
		
		pack();
		
	}


	public static void main(String[] args){
		new Lanzar().setVisible(true);
		
		
	}
	
	
}