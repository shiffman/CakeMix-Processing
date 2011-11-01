import cakemix.*;

CakeMix mix;

void setup() {
  size(400, 400);
  smooth();
  mix = new CakeMix(this, "shiffman", "icm");
}

void draw() {
  background(255);
  for (int i = 0; i < mix.getTotal(); i++) {
    String x = mix.get(i, "x");
    String y = mix.get(i, "y");
    fill(0);
    ellipse(int(x), int(y), 10, 10);
  }
}

void mousePressed() {
  mix.reloadData();
}

