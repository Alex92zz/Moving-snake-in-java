//initial creation of snake at (10,15)
Circle t = new Circle();
Circle b = new Circle();
Circle h = new Circle();
Snake s = new Snake(10, 15, h, b, t);

s.right(); // just head moves
s.right(); //head and body move
s.right(); // all snake moves

s.left(); // head moves left, body moves right, tail (obscured) moves right
s.left(); // head moves left, body moves left, tail moves right
s.left(); // all snake moves left
s.left(); // all snake moves left to edge
s.left(); // can't move. hit edge

s.down(); // head down, body left, tail left
s.down(); // head down, body down, tail left
s.down(); // all down

s.up(); // head up, body down, tail down (obscured)
s.up(); // head up, body up, tail down
s.up(); // all up
s.up(); // all up to top edge
s.up(); // can't move up - hit edge


// code for animation
s.home();
s.randomWalk();
s.home();





