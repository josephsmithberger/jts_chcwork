import TurtleGraphics.Pen;

public class Triangle extends AbstractShape {
   private double aLeng, bLeng, cLeng, aAng, bAng, cAng;
   private boolean isRight;

   // Default: isosceles right triangle with legs of length 1
   public Triangle() {
      super();
      aLeng = 1;
      bLeng = 1;
      cLeng = Math.sqrt(2);
      isRight = true;
      aAng = solveAngle(bLeng, cLeng, aLeng);
      bAng = solveAngle(aLeng, cLeng, bLeng);
      cAng = solveAngle(aLeng, bLeng, cLeng);
   }

   // General triangle constructor (3 sides)
   public Triangle(double xLoc, double yLoc, double a, double b, double c) {
      super(xLoc, yLoc);
      aLeng = a;
      bLeng = b;
      cLeng = c;
      isRight = solveRight(a, b, c);
      aAng = solveAngle(bLeng, cLeng, aLeng);
      bAng = solveAngle(aLeng, cLeng, bLeng);
      cAng = solveAngle(aLeng, bLeng, cLeng);
   }

   // Right triangle constructor — c is computed from a and b
   public Triangle(double xLoc, double yLoc, double a, double b) {
      super(xLoc, yLoc);
      aLeng = a;
      bLeng = b;
      cLeng = Math.sqrt((a * a) + (b * b));
      isRight = true;
      aAng = solveAngle(bLeng, cLeng, aLeng);
      bAng = solveAngle(aLeng, cLeng, bLeng);
      cAng = 90.0;
   }

   // Area using Heron's formula (works for any triangle)
   public double area() {
      double s = perimeter() / 2.0;
      return Math.sqrt(s * (s - aLeng) * (s - bLeng) * (s - cLeng));
   }

   public double perimeter() {
      return aLeng + bLeng + cLeng;
   }

   // Law of cosines: angle opposite to 'opp', between side1 and side2
   public double solveAngle(double side1, double side2, double opp) {
      double radians = Math.acos(
         (side1 * side1 + side2 * side2 - opp * opp) / (2.0 * side1 * side2)
      );
      return Math.toDegrees(radians);
   }

   // Overload: angle opposite to hypotenuse in a right triangle (one leg known)
   public double solveAngle(double side1, double side2) {
      // Returns angle at the corner between side1 and hypotenuse
      return Math.toDegrees(Math.asin(side1 / side2));
   }

   public boolean solveRight(double a, double b, double c) {
      // Use tolerance to handle floating-point imprecision
      double max = Math.max(a, Math.max(b, c));
      double sum;
      if (max == c)      sum = a * a + b * b;
      else if (max == b) sum = a * a + c * c;
      else               sum = b * b + c * c;
      return Math.abs(sum - max * max) < 1e-9;
   }

   public void draw(Pen p) {
       p.up();
       p.move(xPos, yPos);
       p.down();
       
       // Draw side a, turn by exterior angle at vertex between a and b
       p.setDirection(0);
       p.move(aLeng);
       p.turn(180 - cAng);  // exterior angle at C (between sides a and b)
       
       p.move(bLeng);
       p.turn(180 - aAng);  // exterior angle at A (between sides b and c)
       
       p.move(cLeng);
       // pen is now back at start, facing original direction
   }

   // Scale all three sides uniformly; recompute angles (they stay the same, but good practice)
   public void stretchBy(double factor) {
      aLeng *= factor;
      bLeng *= factor;
      cLeng *= factor;
      // Angles unchanged by uniform scaling, but recompute for safety
      aAng = solveAngle(bLeng, cLeng, aLeng);
      bAng = solveAngle(aLeng, cLeng, bLeng);
      cAng = solveAngle(aLeng, bLeng, cLeng);
   }

   public boolean isRightTriangle() {
      return isRight;
   }

   public String toString() {
      return "TRIANGLE\n"
           + "A: " + aLeng + " B: " + bLeng + " C: " + cLeng + "\n"
           + "Angles — A: " + String.format("%.2f", aAng)
           + "° B: " + String.format("%.2f", bAng)
           + "° C: " + String.format("%.2f", cAng) + "°\n"
           + "Right Triangle: " + isRight + "\n"
           + "(X,Y) Position: (" + xPos + "," + yPos + ")\n"
           + "Area: " + String.format("%.4f", area()) + "\n"
           + "Perimeter: " + String.format("%.4f", perimeter());
   }
}