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