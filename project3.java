//balls float
float ball1X, ball1Y, ball1DX, ball1DY;
float ball2X, ball2Y, ball2DX, ball2DY;
float ball3X, ball3Y, ball3DX, ball3DY;
float ball4X, ball4Y, ball4DX, ball4DY;
float ball5X, ball5Y, ball5DX, ball5DY;


//String title= 
//String news=;
//String author= "Danny Raymundo";

float left=50, right=850, top=200, bottom= 550;  //table bounderies
float middle=550;
boolean wall=true, all=false, rat=false;;

int tableRed=212, tableGreen=216, tableBlue=216;  //red table
int score=0,m=0,k=0;
 

int number=0;
//Table
void setup() {
  size( 640, 480 );
  
  //table boundaries
  left=50;
  right=590;
  top=200;
  bottom=430;
  middle=430;
  reset();
}
void reset() {
  ball1X= random(middle,right); ball1Y= random(top,bottom);
  ball2X= random(middle,right); ball2Y= random(top, bottom);
  ball3X= random(middle, right); ball3Y= random(top, bottom);
  ball4X= random(middle, right); ball4Y= random(top, bottom);
  ball5X= random(middle, right); ball5Y= random(top, bottom);
  
  ball1DX= random(1,3); ball1DY= random(1,3);
  ball2DX= random(1,3); ball2DY= random(1,3);
  ball3DX= random(1,3); ball3DY= random(1,3);
  ball4DX= random(1,3); ball4DY= random(1,3);
  ball5DX= random(1,3); ball5DY= random(1,3);
}
//table, bounce, collisions
void draw() {
  background(131,235,255);
  rectMode( CORNERS );
  table( left, top, right, bottom );
  //buttons();
  bounce();
  //collisions();
  show();
 // messages();
}

//keys, click
void keyPressed() {
  if (key == 'q') {exit(); }
  if (key == 'r') {reset();}
}
//table with wall
void table( float east, float north, float west, float south ){
  fill(tableRed, tableGreen, tableBlue );  //pool table
  strokeWeight (25);
  stroke(173,7,7); //red walls
  rect( east-20, north-20, west+20, south+20 );
  
  //wall in the middle
  if (wall) {
    float middle= (east+west)/2;
    stroke( 0,127,0);
    line( middle,north+10, middle,south-10);
  }
  stroke(0);
  strokeWeight(1);
}

//bounce off walls
void bounce(){
  ball1X += ball1DX; if ( ball1X< left || ball1X>right ) ball1DX*= -1;
  ball1Y += ball1DY; if ( ball1Y<top || ball1Y>bottom ) ball1DY*= -1;
  
  ball2X += ball2DX; if ( ball2X<left || ball2X>right ) ball2DX*= -1;
  ball2Y += ball2DY; if ( ball2Y<top || ball2Y>bottom ) ball2DY*= -1;
  
  ball3X += ball3DX; if ( ball3X<left || ball3X>right ) ball3DX*= -1;
  ball3Y += ball3DY; if ( ball3Y<top || ball3Y>bottom ) ball3DY*= -1;
  
  ball4X += ball4DX; if ( ball4X< left || ball4X>right ) ball4DX*= -1;
  ball4Y += ball4DY; if ( ball4Y<top || ball4Y>bottom ) ball4DY*= -1;
 
  ball5X += ball5DX; if ( ball5X< left || ball5X>right ) ball5DX*= -1;
  ball5Y += ball5DY; if ( ball5Y<top || ball5Y>bottom ) ball5DY*= -1;
  
}
void collisions() {
  float tmp;
  if ( dist( ball1X,ball1Y, ball2X,ball2Y ) < 30 ) {
    tmp=ball2DX;  ball2DX=ball1DX; ball1DX=tmp;
    tmp=ball2DY; ball2DY=ball1DY; ball1DY=tmp;
  }
  if ( dist( ball1X,ball1Y, ball3X,ball3Y ) < 30 ) {
    tmp=ball3DX; ball3DX=ball1DX; ball1DX=tmp;
    tmp=ball3DY; ball3DY=ball1DY; ball1DY=tmp;
  }
  if ( dist( ball1X,ball1Y, ball4X,ball4Y ) < 40 ) {
    tmp=ball4DX;  ball4DX=ball1DX; ball1DX=tmp;
    tmp=ball4DY; ball4DY=ball1DY; ball1DY=tmp;
  }
  if ( dist( ball1X,ball1Y, ball5X,ball5Y ) < 30 ) {
    tmp=ball5DX;  ball5DX=ball1DX; ball1DX=tmp;
    tmp=ball5DY; ball5DY=ball1DY; ball1DY=tmp;
  }
  if ( dist( ball2X,ball2Y, ball3X,ball3Y ) < 30 ) {
    tmp=ball3DX; ball3DX=ball2DX; ball2DX=tmp;
    tmp=ball3DY; ball3DY=ball2DY; ball2DY=tmp;
  }
}
//balls
void show() {
  fill( 36,132,255); ellipse( ball1X,ball1Y, 30,30 ); 
  fill(237,218,2); ellipse( ball2X,ball2Y, 30,30 );
  fill(44,44,44); ellipse( ball3X,ball3Y, 30,30 );
  fill( 20,132,155); ellipse( ball4X,ball4Y, 30,30 );
  fill( 53,113,135); ellipse( ball5X,ball5Y, 30,30 );
}
