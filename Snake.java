import ou.*;
/**
 * partial class Snake - TMA02 Q1.
 * 
 * @author (M250 module team) 
 * @version (1.0)
 */
public class Snake
{
   private Circle head; // provided
   private Circle body; // the body of the snake
   private Circle tail; // the tail of the snake

   /**
    * Constructor for objects of class Snake
    */
   public Snake(int startX, int startY, Circle aHead, Circle aBody, Circle aTail)
   {
      // initialise instance variables
      head = aHead; // provided
      head.setXPos(10); // provided
      head.setYPos(15); // provided
      head.setDiameter(10); // provided
      body = aBody;
      body.setXPos(10);
      body.setYPos(15);
      body.setDiameter(8);
      tail = aTail;
      tail.setXPos(10);
      tail.setYPos(15);
      tail.setDiameter(6);
      this.setColour(OUColour.RED);
   }

   /**
    * sets the colour of head, body and tail all to the argument colour.
    */
   private void setColour(OUColour colour)
   {
      head.setColour(colour); // provided
      body.setColour(colour); 
      tail.setColour(colour);
   }

   /**
    * helper method to return x position of head
    */
   private int getHeadXPos() // provided
   {
      return head.getXPos();
   }
  
   /**
    * helper method to return y position of head
    */
   private int getHeadYPos()
   {
      return head.getYPos();
   }
   
   /**
    * helper method to return x position of body
    */
   private int getBodyXPos()
   {
      return body.getXPos();
   }
    
    /**
    * helper method to return y position of body
    */
   private int getBodyYPos()
   {
      return body.getYPos();
   }
   
   /**
    * provided
    * return true if the argument represents a valid x-position for a head
    */
   private boolean checkX(int anXPos) // check room to make move
   {
      if ((anXPos >= 0) && (anXPos <= (250 - head.getDiameter()))) // constants only happen in Unit 7
      {
         return true;
      }
      else
      {
         return false;
      }
      //alternative one-line version
      // return ((anXPos >= 0) && (anXPos <= (250 - head.getDiameter())));
   }

   /**
    * provided
    * return true if the argument represents a valid y-position for a head
    */
   private boolean checkY( int anYPos)
   {
      return ((anYPos >= 0) && (anYPos <= (350 - head.getDiameter())));
   }
   
   /**
    * provided, but won't compile til earlier parts are completed.
    * once you have completed the methods you are asked to write in
    * parts c and d you can uncomment the body of the method.
    * 
    * if the new position is valid, move the snake so that its head is in the given position
    * move the body to where the head was, and the tail to where the body was.
    * Delay after each move.
    * otherwise
    * leave position unchanged
    * output appropriate message
    */
   private void moveTo(int newHeadX, int newHeadY) // provided
   {
      int oldHeadX = getHeadXPos(); 
      int oldHeadY = getHeadYPos();
      int oldBodyX = getBodyXPos();
      int oldBodyY = getBodyYPos();
      if (checkX(newHeadX) && checkY(newHeadY))
      {
         head.setXPos(newHeadX);
         head.setYPos(newHeadY);
         delay(100);
         body.setXPos(oldHeadX);
         body.setYPos(oldHeadY);
         delay(100);            
         tail.setXPos(oldBodyX);
         tail.setYPos(oldBodyY);
         delay(100);            
      }
      else
      {
         System.out.println("Snake cannot cross boundary!");
      }      
   }
   
   // moves the snake to the right one head diameter
   public void right()
      {
         int newHeadX = getHeadXPos() + head.getDiameter() ;
         moveTo(newHeadX, getHeadYPos());
      }
      
   // moves the snake to the left one head diameter
   public void left()
      {
         int newHeadX = getHeadXPos() - head.getDiameter();       
         moveTo(newHeadX, getHeadYPos());
      }

   // moves the snake up one head diameter
   public void up()
      {
         int newHeadY = getHeadYPos() - head.getDiameter();
         moveTo(getHeadXPos(), newHeadY);
      }

   // moves the snake down one head diameter
   public void down()
      {
         int newHeadY = getHeadYPos() + head.getDiameter();
         moveTo(getHeadXPos(), newHeadY);
      }

   /**
    * provided
    * Causes execution to pause by time number of milliseconds
    * You can use this method without needing to understand how it works
    */
      public void delay(int time)
   {
      try
      {
         Thread.sleep(time); 
      }
      catch (Exception e)
      {
         System.out.println(e);
      } 
   }

   /**
    * A method which makes the snake move 100 steps
    * All steps are random, right, left, up or down.
    */
   public void randomWalk()
   {
      for ( int i= 0; i <= 100; i++){
         int a = randomInteger();
         if (a == 1){
         right();
         }
         else if (a == 2){
            left();
         }
         else if (a == 3){
            up();
         }
         else if (a == 4){
            down();
         }
      }
   }
   
   /**
    * This method moves the snake horizontally one step at a time until the x position of the head is within one head diameter of 125,
    * and then vertically one step at a time until the y position of the head is within one head diameter of 175. 
    */
   public void home(){
   while ((getHeadXPos() < (125 - head.getDiameter())) || (getHeadXPos() > (125 + head.getDiameter()))){
         if (getHeadXPos() < (125 - head.getDiameter())){
            right();
         } else if (getHeadXPos() > (125 + head.getDiameter())){
            left();
         }
   }
   while ((getHeadYPos() < (175 - head.getDiameter())) || (getHeadYPos() > (175 + head.getDiameter()))){
         if (getHeadYPos() < (175 - head.getDiameter())){
            down();
         } else if (getHeadYPos() > (175 + head.getDiameter())){
            up();
         }
   }
}

   /**
    * provided
    * return a random integer between 1 and 4 inclusive
    * You can use this method without needing to understand how it works
    */
   public int randomInteger() 
   {
      java.util.Random r = new java.util.Random();
      return r.nextInt(4) + 1;
   }

}
