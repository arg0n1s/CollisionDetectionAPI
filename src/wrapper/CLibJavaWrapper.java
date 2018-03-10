package wrapper;

import utils.Vector3D;

public class CLibJavaWrapper {
	
	public CLibJavaWrapper () {
			System.loadLibrary("VTKVisualizationModule");
			System.loadLibrary("CLibCollisionDetection");
			
			initCollisionLibraryCLib();
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
	
	public void initCollisionController() {
		initCollisionControllerCLib();
	}
	
	public void createAgent(String agentSpecID, int agentID) {
		createAgentCLib(agentSpecID, agentID);
	}
	
	public void connectAgents(int agentID1, int agentID2, int siteID1, int siteID2) {
		connectAgentsCLib(agentID1, agentID2, siteID1, siteID2);
	}
	
	public void createOctTreeFromCluster(int clusterID) {
		octTreeFromClusterCLib(clusterID);
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
	
	private native void addSiteSpecificationCLib(String agentSpecID, int siteSpecID, int coordType, double c1, double c2, double c3);
	
	private native void addShapeSpecificationCLib(String shapeSpecID, int shapeType, double c1);
	
	private native void addShapeSpecificationCLib(String shapeSpecID, int shapeType, double c1, double c2);
	
	private native void addShapeSpecificationCLib(String shapeSpecID, int shapeType, double c1, double c2, double c3);
	
	private native void addAgentSpecificationCLib(String agentSpecID, String shapeSpecID);
	
	private native void initCollisionControllerCLib();
	
	private native void createAgentCLib(String agentSpecID, int agentID);
	
	private native void connectAgentsCLib(int agentID1, int agentID2, int siteID1, int siteID2);
	
	private native void octTreeFromClusterCLib(int clusterID);
	
	private native void showAgentCLib(int agentID);
	
	private native void showClusterCLib(int clusterID);
	
	private native void showOctTreeCLib(int clusterID);
	
	private native String agentToString(int agentID);
	
	private native String clusterToString(int clusterID);
	
	private native String collisionControllerToString();

}
