package cakemix.examples;

import cakemix.CakeMix;
import processing.core.PApplet;

public class CakeMixRetrieve extends PApplet {

	
	CakeMix mix;
	
	public void setup() {
		size(400,400);
		smooth();
		mix = new CakeMix(this,"shiffman","icm");
		
	}
	
	public void draw() {
		background(255);
		for (int i = 0; i < mix.getTotal(); i++) {
			String x = mix.get(i,"x");
			String y = mix.get(i,"y");
			fill(0);
			ellipse(parseInt(x),parseInt(y),10,10);
		}
	}
	
	public void mousePressed() {
		mix.reloadData();
	}
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"cakemix.examples.CakeMixRetrieve"});
	}
	
}
