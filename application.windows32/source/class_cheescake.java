import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.sound.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class class_cheescake extends PApplet {


SoundFile song;
PImage cheesecakeImg;
PImage septicImg;
PImage jackaboyImg;
PImage septicLoveImg;
PImage cookieImg;
PFont thanks;
PFont instructions;
Cheesecake[] cheesecakes;
Cheesecake[] septics;
Septiceye[] septicLove;
Cheesecake[] cookieLove;
int rectX;
int rectY;
int rectY1;
int rectY2;
int rectY3;
int rectY4;
public void setup()
{
  
  thanks = loadFont("BookmanOldStyle-Bold-48.vlw");
  instructions  = loadFont("Borghs-Hollow-CondensedNormal-36.vlw");
  rectX  = 0;
  rectY  = 0;
  rectY1 = 150;
  rectY2 = -150;
  rectY3 = -300;
  rectY4 = 800;
  cheesecakeImg = loadImage("strawberry.png");
  cheesecakeImg.resize(100, 100);
  septicImg = loadImage("septic.png");
  septicImg.resize(100, 100);
  jackaboyImg = loadImage("jackaboy.png");
  septicLoveImg = loadImage("septic love.png");
  septicLoveImg.resize(300, 300);
  cookieImg = loadImage("cookie4.png");
  cookieImg.resize(200,200);
  cheesecakes = new Cheesecake[50];
  septics = new Cheesecake[50];
  septicLove = new Septiceye[20];
  for (int i=0; i<50; i++)
  {
    cheesecakes[i] = new Cheesecake(random(700, width), random(height, height+600), cheesecakeImg, true);
    septics[i]     = new Cheesecake(random(0, 400),     random(height, height+600), septicImg,     true);
   }
  song = new SoundFile(this, "all the way.mp3");
  song.play();
}

public void draw()
{
  background(0);
  image(cookieImg, 100,70);
  image(cookieImg, width-300,70);
  fill(0, 255, 0);
  noStroke();
  rect(0, rectY, width, 50); // rectY
  rectY = rectY + 10;
  if (rectY>height)
  {
    rectY = 0;
  }
  rect(0, rectY1, width, 50);  //rectY1
  rectY1 = rectY1+10;
  if (rectY1>height)
  {
    rectY1 = 0;
  }
  rect(0, rectY2, width, 50);  //rectY2
  rectY2 = rectY2+5;
  if (rectY2>height)
  {
    rectY2 = 0;
  }
  rect(0, rectY3, width, 50);  //rectY3
  rectY3 = rectY3+10;
  if (rectY3>height)
  {
    rectY3 = 0;
  }
  rect(0, rectY4, width, 50);  //rectY4
  rectY4 = rectY4+10;
  if (rectY4>height)
  {
    rectY4 = 0;
  }
  for (int i=0; i<50; i++)
  {
    cheesecakes[i].Update();
    cheesecakes[i].Draw();
    cheesecakes[i].isHeight();
    cheesecakes[i].isCollision();
    septics[i].Update();
    septics[i].Draw();
    septics[i].isHeight();
    septics[i].isCollision();
  }
  image(jackaboyImg, 400, 150);
  image(septicLoveImg, 900, 200);
  image(septicLoveImg, 100, 200);
  fill(0xff17B0FA);
  ellipse(width/2-120, height/2-30, 30, 30);
  ellipse(width/2-20, height/2-30, 30, 30);
  fill(0);
  rect(width/2-160, height/2-70, 70, 20, 300); // left side eye
  rect(width/2-120, height/2-80, 30, 20, 300); // upper eyebrow left side
  rect(width/2-30, height/2-70, 70, 20, 300); // right side eye
  rect(width/2-30, height/2-80, 30, 20, 300); // upper eyebrow right side
  fill(255); // check how to load font from first project

}

class Cheesecake
{
  private float _posX;
  private float _posY;
  private PImage _img;
  private boolean _isActive;

  Cheesecake(float posX, float posY, PImage img, boolean isActive)
  {
    _posX = posX;
    _posY = posY;
    _img = img;
    _isActive = isActive;
  }
  private void Move()
  {
    _posY = _posY-10;
  }
  public void Update()
  {
    Move();
  }
  public void Draw()
  {
    image(_img, _posX, _posY);
  }

  public void isHeight()
  {

    if (_posY<-200)
    {
      _posY = random(height, height+600);
      _posX = random(0, width);
    }
  }
  public void isCollision()
  {
    if (dist(mouseX, mouseY, _posX, _posY) < 100)
    {
      _posY = random(height, height+600);
      _posX = random(0, width);
    }
  }
}
class Septiceye
{
  private float _posX;
  private float _posY;
  private PImage _img;
  private boolean _isActive;

  Septiceye(float posX, float posY, PImage img, boolean isActive)
  {
    _posX = posX;
    _posY = posY;
    _img = img;
    _isActive = isActive;
  }
  private void Move()
  {
    _posY = _posY-10;
  }
  public void Update()
  {
    Move();
  }
  public void Draw()
  {
    image(_img, _posX, _posY);
  }

  public void isHeight()
  {

    if (_posY<-200)
    {
      _posY = random(height, height+600);
      _posX = random(0, width);
    }
  }
  public void isCollision()
  {
    if (dist(mouseX, mouseY, _posX, _posY) < 100)
    {
      _posY = random(height, height+600);
      _posX = random(0, width);
    }
  }
}
  public void settings() {  fullScreen(P3D); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "class_cheescake" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
