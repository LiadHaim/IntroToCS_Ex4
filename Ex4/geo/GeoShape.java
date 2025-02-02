package geo;

/**
 * This interface represents a geometric (2D) shape in the plane. 
 * The methods include:
 * moving a shape by a vector, testing if a shape contains a point, area, 
 * perimeter, toString, a method (getPoints) for getting the points representing this 
 * GeoShape, a rotation method and a rescale method.
 * 
 * Ex4: you should NOT change this interface!
 * @author boaz.benmoshe
 */

public interface GeoShape {
	/**
	 * Computes if the point (ot) falls inside this (closed) shape.
	 * Note: Assumes a closed shape - aka if ot is on the boundary it is inside the shape.
	 * 
	 * @param ot - a query 2D point
	 * @return true iff the point falls with in this shape (as a closed shape).
	 */
	public boolean contains(Point_2D ot);
	
	/**
	 * Computes the area of this shape, in case of a point, and a segment should return 0.
	 * @return - the area of this GeoShape.
	 */
	public double area();
	/**
	 * Computes the perimeter of this shape, return 0 in case of a point and twice the length in the segment in case of a segment. 
	 * @return the perimeter of this GeoShape.
	 */
	public double perimeter();
	/**
	 * Move this shape by the vector 0,0-->vec
	 * Note: this method changes the inner state of the object.
	 * @param vec - a vector from the 0,0
	 */
	public void translate(Point_2D vec);
	
	/** This method computes a new (deep) copy of this GeoShape 
	 * @return a deep copy of this GeoShape.
	 */
	public GeoShape copy();
	/**
	 * This method returns a String representing this shape,
	 * such that one can use this string for saving the shape into a text file.
	 * @return a String representing this shape
	 */
	public String toString();
	
	/**
	 * Rescales this GeoShape with respect to the given center point.
	 * rescaling with ratio 1: will not change this shape.
	 * rescaling with center (ORIGN) and ratio 2 will transform (aka move)
	 * each point of this shape by each self-vector (from the ORIGN).
	 * rescaling with center (10,-20) and ratio 0f 0.75 will transform (aka move).
	 * rescaling with ratio -1 (twice) will result the same shape as the original.
	 * each point of this shape will be moved to the center by 25% factor 
	 * (the length of the vector from each point to the center will decrease by a factor of
	 *  0.75, yet the normalized vectors will remain the same as in the original shape).
	 * @param center - center point from which the rescaling is being done.
	 * @param ratio - the ratio of rescaling.
	 */
	public void scale(Point_2D center, double ratio);
	/**
	 * Rotates this GeoShape with respect to the given center point by an angle.
	 * rotating with an angle 0 (or n*360, n=0,1,-1,2,-2...): will not change this shape.
	 * rotating with center (ORIGN) and an angle of 30 2 will transform (rotate) each point
	 * of this shape as if the vector form the center point to each point "moves" a single "hour" back in time
	 * (say moving form 3 to 2).
	 * @param center - center point from which the rotation is being done.
	 * @param angleDegrees - the angle (in Degrees) the shape should be rotated by.
	 */
	public void rotate(Point_2D center, double angleDegrees);

	Point_2D[] getAllPoints();
}
