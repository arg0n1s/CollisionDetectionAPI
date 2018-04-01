package wrapper;

import utils.Vector3D;
import utils.Quaternion;

public class CLibJavaWrapper {
	public CLibJavaWrapper () {
			System.loadLibrary("VTKVisualizationModule");
			System.loadLibrary("CLibCollisionDetection");
			String currentProjectDir = System.getProperty("user.dir");
			initCollisionLibraryCLib(currentProjectDir + "\\logs");
	}
	
	public void addSiteSpecification(String agentSpecID, int siteSpecID, CoordinateType coordType, Vector3D coordinates) {
		addSiteSpecificationCLib(agentSpecID, siteSpecID, javaEnumToCEnum(coordType), coordinates.x, coordinates.y, coordinates.z);
	}
	
	public void addShapeSpecification(String shapeSpecID, ShapeType shapeType, double c1) {
		addShapeSpecificationCLib(shapeSpecID, javaEnumToCEnum(shapeType), c1);
	}
	
	public void addShapeSpecification(String shapeSpecID, ShapeType shapeType, double c1, double c2) {
		addShapeSpecificationCLib(shapeSpecID, javaEnumToCEnum(shapeType), c1, c2);
	}
	
	public void addShapeSpecification(String shapeSpecID, ShapeType shapeType, double c1, double c2, double c3) {
		addShapeSpecificationCLib(shapeSpecID, javaEnumToCEnum(shapeType), c1, c2, c3);
	}
	
	public void addAgentSpecification(String agentSpecID, String shapeSpecID) {
		addAgentSpecificationCLib(agentSpecID, shapeSpecID);
	}
	
	public void initCollisionController(double minLeafSize, double maxInitialRootSize) {
		initCollisionControllerCLib();
		setMinimalLeafSizeCLib(minLeafSize);
		setMaxInitialRootSizeCLib(maxInitialRootSize);
	}
	
	public void createAgent(String agentSpecID, int agentID) {
		createAgentCLib(agentSpecID, agentID);
	}
	
	public void insertAgentIntoCluster(int agentID, int clusterID) {
		insertAgentIntoClusterCLib(agentID, clusterID);
	}
	
	public void moveAgent(int agentID, Vector3D translation) {
		moveAgentCLib(agentID, translation.x, translation.y, translation.z);
	}
	
	public void rotateAgent(int agentID, Quaternion rotation) {
		rotateAgentCLib(agentID, rotation.w, rotation.x, rotation.y, rotation.z);
	}
	
	public Vector3D getAgentPosition(int agentID) {
		double x = 0;
		double y = 0;
		double z = 0;
		getAgentPositionCLib(agentID, x, y, z);
		return new Vector3D(x, y, z);
	}
	
	public Quaternion getAgentRotation(int agentID) {
		double w = 0;
		double x = 0;
		double y = 0;
		double z = 0;
		getAgentRotationCLib(agentID, w, x, y, z);
		return new Quaternion(w, x, y, z);
	}
	
	public void connectAgents(int agentID1, int agentID2, int siteID1, int siteID2) {
		connectAgentsCLib(agentID1, agentID2, siteID1, siteID2);
	}
	
	public void createOctTreeFromCluster(int clusterID) {
		octTreeFromClusterCLib(clusterID);
	}
	
	public void insertAgentIntoOctTree(int agentID, int clusterID) {
		insertAgentIntoOctTreeCLib(agentID, clusterID);
	}
	
	public int findNearestToAgent(int clusterID, int agentID) {
		return findNearestToAgentCLib(clusterID, agentID);
	}
	
	public boolean checkCollisionBetweenAgents(int agentID1, int agentID2) {
		return checkCollisionBetweenAgentsCLib(agentID1, agentID2);
	}
	
	public double calculateDistance(int agentID1, int agentID2) {
		return calculateDistanceCLib(agentID1, agentID2);
	}
	
	public void showAgent(int agentID) {
		showAgentCLib(agentID);
	}
	
	public void showAgentCluster(int clusterID) {
		showClusterCLib(clusterID);
	}
	
	public void showOctTree(int clusterID) {
		showOctTreeCLib(clusterID);
	}
	
	public void printAgent(int agentID) {
		System.out.println(agentToString(agentID));
	}
	
	public void printAgentCluster(int clusterID) {
		System.out.println(clusterToString(clusterID));
	}
	
	public void printCollisionController() {
		System.out.println(collisionControllerToString());
	}
	
	private static int javaEnumToCEnum(CoordinateType coordType) {
		switch(coordType) {
		case KarthesianAbsolute : {
			return 0;
		}
		case KarthesianPointerToHull : {
			return 1;
		}
		case ParametricAbsolute : {
			return 2;
		}
		case ParametricPointerToHull : {
			return 3;
		}
		default : return 0;
		}
	}
	
	private static int javaEnumToCEnum(ShapeType shapeType) {
		switch(shapeType) {
		case Sphere : {
			return 0;
		}
		case Cylinder : {
			return 1;
		}
		case Ellipsoid : {
			return 2;
		}
		default : return 0;
		}
	}
	private native void initCollisionLibraryCLib();
	
	private native void initCollisionLibraryCLib(String errorLogPath);
	
	private native void addSiteSpecificationCLib(String agentSpecID, int siteSpecID, int coordType, double c1, double c2, double c3);
	
	private native void addShapeSpecificationCLib(String shapeSpecID, int shapeType, double c1);
	
	private native void addShapeSpecificationCLib(String shapeSpecID, int shapeType, double c1, double c2);
	
	private native void addShapeSpecificationCLib(String shapeSpecID, int shapeType, double c1, double c2, double c3);
	
	private native void addAgentSpecificationCLib(String agentSpecID, String shapeSpecID);
	
	private native void initCollisionControllerCLib();
	
	private native void setMinimalLeafSizeCLib(double minLeafSize);
	
	private native void setMaxInitialRootSizeCLib(double maxInitialRootSize);
	
	private native void createAgentCLib(String agentSpecID, int agentID);
	
	private native void insertAgentIntoClusterCLib(int agentID, int clusterID); 
	
	private native void moveAgentCLib(int agentID, double x, double y, double z); 
	
	private native void rotateAgentCLib(int agentID, double w, double x, double y, double z);
	
	private native void getAgentPositionCLib(int agentID, double x, double y, double z);
	
	private native void getAgentRotationCLib(int agentID, double w, double x, double y, double z);
	
	private native void connectAgentsCLib(int agentID1, int agentID2, int siteID1, int siteID2);
	
	private native void octTreeFromClusterCLib(int clusterID);
	
	private native void insertAgentIntoOctTreeCLib(int agentID, int clusterID);
	
	private native int findNearestToAgentCLib(int clusterID, int agentID);
	
	private native boolean checkCollisionBetweenAgentsCLib(int agentID1, int agentID2);
	
	private native double calculateDistanceCLib(int agentID1, int agentID2);
	
	private native void showAgentCLib(int agentID);
	
	private native void showClusterCLib(int clusterID);
	
	private native void showOctTreeCLib(int clusterID);
	
	private native String agentToString(int agentID);
	
	private native String clusterToString(int clusterID);
	
	private native String collisionControllerToString();

}
