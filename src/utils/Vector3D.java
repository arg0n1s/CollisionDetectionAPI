package utils;

public class Vector3D {
	public double x, y, z;
	public Vector3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public Vector3D(double[] vec) {
		this.x = vec[0];
		this.y = vec[1];
		this.z = vec[2];
	}
	
	@Override
	public String toString() {
		return "["+x+", "+y+", "+z+"]";
	}
}
