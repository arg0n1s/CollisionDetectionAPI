package test;

import wrapper.CLibJavaWrapper;
import wrapper.CoordinateType;
import wrapper.ShapeType;
import utils.Vector3D;

public class Demo {

	public static void main(String[] args) {
		CLibJavaWrapper collisionLib = new CLibJavaWrapper();
		// Generate MetaSpecs, i.e. Agent templates
		Vector3D specCoordinates0 = new Vector3D(1.0, Math.PI/2, 0.0);
		Vector3D specCoordinates1 = new Vector3D(1.0, Math.PI/2, Math.PI * 3.0/4.0);
		collisionLib.addSiteSpecification("aType1", 0, CoordinateType.ParametricPointerToHull, specCoordinates0);
		collisionLib.addSiteSpecification("aType1", 1, CoordinateType.ParametricPointerToHull, specCoordinates1);
		collisionLib.addShapeSpecification("sType1", ShapeType.Sphere, 1.0);
		collisionLib.addAgentSpecification("aType1", "sType1");
		// Initiate CollisionController object with MetaSpecs
		collisionLib.initCollisionController();
		// Fill Simulation Container with Agents
		collisionLib.createAgent("aType1", 0);
		collisionLib.createAgent("aType1", 1);
		collisionLib.createAgent("aType1", 2);
		collisionLib.createAgent("aType1", 3);
		collisionLib.createAgent("aType1", 4);
		collisionLib.createAgent("aType1", 5);
		collisionLib.createAgent("aType1", 6);
		collisionLib.createAgent("aType1", 7);
		// Connect Agents, i.e. create a cluster
		collisionLib.connectAgents(0, 1, 0, 1);
		collisionLib.connectAgents(1, 2, 0, 1);
		collisionLib.connectAgents(2, 3, 0, 1);
		collisionLib.connectAgents(3, 4, 0, 1);
		collisionLib.connectAgents(4, 5, 0, 1);
		collisionLib.connectAgents(5, 6, 0, 1);
		collisionLib.connectAgents(6, 7, 0, 1);
		// Result
		collisionLib.showAgentCluster(0);
		// Construct OctTree from Cluster and show result
		collisionLib.createOctTreeFromCluster(0);
		collisionLib.showOctTree(0);

	}

}
