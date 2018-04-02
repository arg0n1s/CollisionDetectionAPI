package utils;

public class Quaternion extends Vector3D {
	public double w;
	public Quaternion(double w, double x, double y, double z) {
		super(x,y,z);
		this.w = w;
	}
	
	public Quaternion(double[] quat) {
		super(quat[1], quat[2], quat[3]);
		this.w = quat[0];
	}
	
	@Override
	public String toString() {
		return "["+w+", "+x+", "+y+", "+z+"]";
	}
}
