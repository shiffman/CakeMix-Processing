package cakemix.examples;

import cakemix.CakeMix;
import processing.core.PApplet;

public class CakeMixPost extends PApplet {

	
	CakeMix mix;
	
	public void setup() {
		size(400,400);
		mix = new CakeMix(this,"shiffman","icm");
		background(255);
		smooth();
		
	}
	
	public void draw() {
		
	}
	
	public void mousePressed() {
		mix.addData("x",mouseX);
		mix.addData("y",mouseY);
		mix.post();
		fill(0);
		ellipse(mouseX,mouseY,10,10);
	}
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"cakemix.examples.CakeMixPost"});
	}
	
}
