package utils;

public class Quaternion extends Vector3D {
	public double w;
	public Quaternion(double w, double x, double y, double z) {
		super(x,y,z);
		this.w = w;
	}
	
	@Override
	public String toString() {
		return "["+w+", "+x+", "+y+", "+z+"]";
	}
}
