package utils;

public class Vector3D {
	public double x, y, z;
	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	@Override
	public String toString() {
		return "["+x+", "+y+", "+z+"]";
	}
}
