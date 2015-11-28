package geometriezeichnen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Dies ist die Klasse in der die geometrische Flaeche mitsamt all ihrer Figuren generiert wird.
 * 
 * @author Lukas Schramm
 * @version 1.0
 *
 */
public class FigurenZeichnen {

	private Canvas canvas1 = new Canvas() {
	    public void paint(Graphics stift) {
	    	geopaint(stift);
	    }
	};
	private JFrame frame1 = new JFrame("Figuren malen!");
	private int frameWidth = 800;
	private int frameHeight = 500;
	private int anzahlquader;
	private int anzahldreiecksprismen;
	private int anzahlpyramiden;
	private ArrayList<Quader> quaderliste = new ArrayList<Quader>();
	private ArrayList<Dreiecksprisma> dreiecksprismaliste = new ArrayList<Dreiecksprisma>();
	private ArrayList<Pyramide> pyramidenliste = new ArrayList<Pyramide>();
	
	public FigurenZeichnen() {
		frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	    frame1.setPreferredSize(new Dimension(800,500));
	    frame1.setResizable(false);
	    Container cp = frame1.getContentPane();
	    cp.setLayout(new GridLayout(1,1));
	    canvas1.setBackground(new Color(0xF5DEB3));
	    frame1.add(canvas1);
	    frame1.pack();
	    frame1.setLocationRelativeTo(null);
	    frame1.setVisible(false);
	    generierung();
	}
	
	/**
	 * Diese Methode generiert eine Menge an Figuren anhand zahlreicher Zufallswerte und fuegt sie in entsprechende Listen ein..
	 */
	private void generierung() {
		Random zufall = new Random();
		anzahlquader = 20;
		anzahldreiecksprismen = 20;
		anzahlpyramiden = 20;
		
		for(int n=0;n<anzahlquader;n++) {
			quaderliste.add(new Quader());
		}
		for(int n=0;n<anzahldreiecksprismen;n++) {
			dreiecksprismaliste.add(new Dreiecksprisma());
		}
		for(int n=0;n<anzahlpyramiden;n++) {
			pyramidenliste.add(new Pyramide());
		}
		
		for(Quader q:quaderliste) {
			q.setX(zufall.nextInt(frameWidth));
			q.setY(zufall.nextInt(frameHeight));
			q.setH(zufall.nextInt(30)+10);
			q.setB(zufall.nextInt(30)+10);
			q.setT(zufall.nextInt(30)+10);
		}
		for(Dreiecksprisma dp:dreiecksprismaliste) {
			dp.setX(zufall.nextInt(frameWidth));
			dp.setY(zufall.nextInt(frameHeight));
			dp.setH(zufall.nextInt(50)+10);
			dp.setB(zufall.nextInt(30)+10);
			dp.setT(zufall.nextInt(40)+10);
			dp.setPkta(zufall.nextInt(99)+1);
		}
		for(Pyramide p:pyramidenliste) {
			p.setX(zufall.nextInt(frameWidth));
			p.setY(zufall.nextInt(frameHeight));
			p.setB(zufall.nextInt(40)+10);
			p.setT(zufall.nextInt(40)+10);
			p.setH(zufall.nextInt(40)+10);
		}
		frame1.setVisible(true);
	}
	
	/**
	 * Diese Methode zeichnet alle Figuren nach den oben definierten Eigenschaften.
	 * @param stift Nimmt das GraphicsElement entgegen.
	 */
	private void geopaint(Graphics stift) {
		for(Quader q:quaderliste) {
			stift.setColor(new Color(0x8B4500));
			stift.drawRect(q.getX(), q.getY(), q.getB(), q.getH());
			stift.drawLine(q.getX(), q.getY(), q.getX()+(int)(Math.sqrt(q.getT()*q.getT()/8)), q.getY()-(int)(Math.sqrt(q.getT()*q.getT()/8)));
			stift.drawLine(q.getX()+q.getB(), q.getY(), q.getX()+q.getB()+(int)(Math.sqrt(q.getT()*q.getT()/8)), q.getY()-(int)(Math.sqrt(q.getT()*q.getT()/8)));
			stift.drawLine(q.getX()+(int)(Math.sqrt(q.getT()*q.getT()/8)), q.getY()-(int)(Math.sqrt(q.getT()*q.getT()/8)), q.getX()+q.getB()+(int)(Math.sqrt(q.getT()*q.getT()/8)), q.getY()-(int)(Math.sqrt(q.getT()*q.getT()/8)));
			stift.drawLine(q.getX()+q.getB(), q.getY()+q.getH(),q.getX()+q.getB()+(int)(Math.sqrt(q.getT()*q.getT()/8)),q.getY()+q.getH()-(int)(Math.sqrt(q.getT()*q.getT()/8)));
			stift.drawLine(q.getX()+q.getB()+(int)(Math.sqrt(q.getT()*q.getT()/8)), q.getY()-(int)(Math.sqrt(q.getT()*q.getT()/8)), q.getX()+q.getB()+(int)(Math.sqrt(q.getT()*q.getT()/8)), q.getY()+q.getH()-(int)(Math.sqrt(q.getT()*q.getT()/8)));
		}
		for(Dreiecksprisma dp:dreiecksprismaliste) {
			stift.setColor(new Color(0x8B4500));
			stift.drawRect(dp.getX(), dp.getY(), dp.getB(), dp.getH());
			stift.drawLine(dp.getX(), dp.getY(), dp.getX()+(dp.getB()*dp.getPkta())/100+dp.getT()/(int)(Math.sqrt(8)), dp.getY()-dp.getT()/(int)(Math.sqrt(8)));
			stift.drawLine(dp.getX()+dp.getB(), dp.getY(), dp.getX()+(dp.getB()*dp.getPkta())/100+dp.getT()/(int)(Math.sqrt(8)), dp.getY()-dp.getT()/(int)(Math.sqrt(8)));
			if(dp.getX()+dp.getB() < dp.getX()+(dp.getB()*dp.getPkta())/100+dp.getT()/(int)(Math.sqrt(8))) {
				stift.drawLine(dp.getX()+(dp.getB()*dp.getPkta())/100+dp.getT()/(int)(Math.sqrt(8)), dp.getY()-dp.getT()/(int)(Math.sqrt(8)), dp.getX()+(dp.getB()*dp.getPkta())/100+dp.getT()/(int)(Math.sqrt(8)), dp.getY()+dp.getH()-dp.getT()/(int)(Math.sqrt(8)));
				stift.drawLine(dp.getX()+dp.getB(), dp.getY()+dp.getH(), dp.getX()+(dp.getB()*dp.getPkta())/100+dp.getT()/(int)(Math.sqrt(8)), dp.getY()+dp.getH()-dp.getT()/(int)(Math.sqrt(8)));
			}
			if(dp.getX() > dp.getX()+(dp.getB()*dp.getPkta())/100+dp.getT()/(int)(Math.sqrt(8))) {
				stift.drawLine(dp.getX()+(dp.getB()*dp.getPkta())/100+dp.getT()/(int)(Math.sqrt(8)), dp.getY()-dp.getT()/(int)(Math.sqrt(8)), dp.getX()+(dp.getB()*dp.getPkta())/100+dp.getT()/(int)(Math.sqrt(8)), dp.getY()+dp.getH()-dp.getT()/(int)(Math.sqrt(8)));
				stift.drawLine(dp.getX(), dp.getY()+dp.getH(), dp.getX()+(dp.getB()*dp.getPkta())/100+dp.getT()/(int)(Math.sqrt(8)), dp.getY()+dp.getH()-dp.getT()/(int)(Math.sqrt(8)));
			}
		}
		for(Pyramide p:pyramidenliste) {
			stift.setColor(new Color(0x8B4500));
			stift.drawLine(p.getX(), p.getY(), p.getX()+p.getB(), p.getY());
			stift.drawLine(p.getX()+p.getB(), p.getY(), p.getX()+p.getB()+(int)(Math.sqrt(p.getT()*p.getT()/8)), p.getY()-(int)(Math.sqrt(p.getT()*p.getT()/8)));
			stift.drawLine(p.getX()+p.getB()+(int)(Math.sqrt(p.getT()*p.getT()/8)), p.getY()-(int)(Math.sqrt(p.getT()*p.getT()/8)), p.getX()+p.getB()/2+((int)(Math.sqrt(p.getT()*p.getT()/8)))/2, p.getY()-p.getH()-((int)(Math.sqrt(p.getT()*p.getT()/8)))/2);
			stift.drawLine(p.getX(), p.getY(), p.getX()+p.getB()/2+((int)(Math.sqrt(p.getT()*p.getT()/8)))/2, p.getY()-p.getH()-((int)(Math.sqrt(p.getT()*p.getT()/8)))/2);
			stift.drawLine(p.getX()+p.getB(), p.getY(), p.getX()+p.getB()/2+((int)(Math.sqrt(p.getT()*p.getT()/8)))/2, p.getY()-p.getH()-((int)(Math.sqrt(p.getT()*p.getT()/8)))/2);
		}
	}
	
	public static void main(String[] args) {
		new FigurenZeichnen();
	}
}