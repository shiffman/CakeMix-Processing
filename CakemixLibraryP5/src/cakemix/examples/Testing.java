package cakemix.examples;


import java.awt.Rectangle;
import java.util.ArrayList;

import org.json.JSONArray;

import cakemix.CakeMix;
import processing.core.PApplet;

public class Testing extends PApplet {

	
	CakeMix mix;
	
	public void setup() {
		size(400,400);
		mix = new CakeMix(this,"shiffman","icm");
		background(255);
		smooth();
		
	}
	
	public void draw() {
		
	}
	
	public void keyPressed() {
		
		Rectangle r = new Rectangle(50,60,100,150);
		JSONArray ja1 = new JSONArray();
		ja1.put(r);
		System.out.println(ja1.toString());
		
		float[] stuff = {1.0f,2.0f,3.0f,5.0f};
		JSONArray ja2 = new JSONArray();
		ja2.put(stuff);
		System.out.println(ja2.toString());
		
		ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
		for (int i = 0; i < 3; i++) {
			rects.add(new Rectangle(i,i*2,i*3,i*4));
		}
		JSONArray ja3 = new JSONArray();
		ja3.put(rects);
		System.out.println(ja3.toString());
		
		
		
		//mix.addData("stuff", r);
		//fill(0);
		//ellipse(mouseX,mouseY,10,10);
	}
	
	public static void main(String[] args) {
		PApplet.main(new String[] {"cakemix.examples.Testing"});
	}
	
}
