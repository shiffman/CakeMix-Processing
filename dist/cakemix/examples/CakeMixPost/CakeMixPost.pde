import cakemix.*;

CakeMix mix;

void setup() {
  size(400, 400);
  mix = new CakeMix(this, "shiffman", "icm");
  background(255);
  smooth();
}

void draw() {
}

void mousePressed() {
  mix.addData("x", mouseX);
  mix.addData("y", mouseY);
  mix.post();
  fill(0);
  ellipse(mouseX, mouseY, 10, 10);
}

