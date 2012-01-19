// Daniel Shiffman
// CakeMix Library Example
// January 2012

// Demonstrating how to do a generic post to any URL

import cakemix.*;

Post post;

String url = "http://www.itpcakemix.com/add";

void setup() {
  size(100, 100);
}

void draw() {
  noLoop();
}

void mousePressed() {
  Post post = new Post(url);
  post.addData("user","shiffman");
  post.addData("project","test");  
  // addData() currently requires Strings as arguments
  // mouseX and mouseY must be converted
  post.addData("x", "" + mouseX);
  post.addData("y", "" + mouseY);
  post.post();
}

