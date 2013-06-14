import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class Panel extends JPanel implements Runnable{

	JButton boton;
	MouseListener e;
	EspacioCelular ec;
	boolean estado= false;
	boolean ctrl = true;
	
	public Panel(int alto, int ancho) {
		setPreferredSize(new Dimension(ancho, alto));
		ec = new EspacioCelular(alto, ancho);
		setBackground(Color.BLUE); //Color de las celdas vacias
		setForeground(Color.BLACK); //Color de la "rejilla"
		

		
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				if((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK)
					ec.setViva(e.getX(), e.getY());
					else
					ec.setMoribunda(e.getX(), e.getY());
					repaint();
				
			}
		});
		
	
		
		
		

		
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
			if((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK)
			ec.setViva(e.getX(), e.getY());
			else
			ec.setMoribunda(e.getX(), e.getY());
			repaint();
			}
		});
		
		
		
		
		
		
	
	}
	
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ec.paint(g, getForeground());
	}
	
	
	public void reiniciar(){
		ec.reiniciar();
		repaint();
	}
	
	public void setEstado(boolean estado){
		this.estado = estado;
	}
	
	public void nextFase(){
		ec.nextFase();
		repaint();
	}
	
	
	public void setZoom(int zoom){
		ec.setZoom(zoom);
		repaint();
	}
	
	public void setAleatorias(){
		ec.setAleatorias();
		repaint();
	}
	
	public int getZoom(){
		return ec.getZoom();
	}
	

	
	
	

	@Override
	public void run() {
		while (true){
			
		try {
			
		
			while(estado){
				ec.nextFase();
				repaint();
				
				Thread.sleep(10);
		
		}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		
	}
	
	
}