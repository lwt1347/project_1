package project;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

class AddMapData {


	ArrayList<String[]> edges;	//����
	ArrayList<String[]> nodes;  //�ε�
	LoadFile loadFile = new LoadFile();//���� �ε�

	Random random = new Random();

	private static File cedgeFile = new File("./s_edge.txt");
	private static File cnodeFile = new File("./s_node.txt");
	ArrayList<SF_cnode> nodeArray = new ArrayList<SF_cnode>();		//���� �� ����
	ArrayList<SF_cedge> edgeArray = new ArrayList<SF_cedge>();		//���� �� ����
	ArrayList<SF_cnode> randCarArray = new ArrayList<SF_cnode>();
	
	int temp;
	
	/**
	 * ��� �߰�
	 */
	public ArrayList<SF_cnode> addNode(){
		
		nodes = loadFile.LoadFile(cnodeFile, 3);
		 for (int i = 0; i < nodes.size(); i++) {
	            String[] sArray = (String[])nodes.get(i);
	            SF_cnode theNode = new SF_cnode();
	            theNode.setNodeID((new Integer(sArray[0])).intValue());
	            theNode.setNormalizedX((new Double(sArray[1])).doubleValue());
	            theNode.setNormalizedY((new Double(sArray[2])).doubleValue());
	            
	            nodeArray.add(theNode);
	    
	        }
		 return nodeArray;
		//********************************************************************************************************************
	}
	
	public ArrayList<SF_cedge> addEdge(){
		 /**
		  * ���� �߰�
		  */
		 		edges = loadFile.LoadFile(cedgeFile, 4);
		 		for (int i = 0; i < edges.size(); i++) {
	            String[] sArray = (String[])edges.get(i);
	            
	            
	            SF_cedge theEdge = new SF_cedge();
	           
	            theEdge.setEdgeID((new Integer(sArray[0])).intValue());
	            theEdge.setStart_NodeID((new Integer(sArray[1])).intValue());
	            theEdge.setEnd_NodeID((new Integer(sArray[2])).intValue());
	            theEdge.setL2Distance((new Double(sArray[3])).doubleValue());
	            edgeArray.add(theEdge);
	            
	        }
		 //********************************************************************************************************************
		 return edgeArray;
	}
	
	/**
	 * ���� �߰�
	 * @return 
	 */
	public ArrayList<SF_cnode> addCar(int count){
		
		//���� ���� �߰�
		for(int i=0; i<count; i++){
			temp = random.nextInt(nodeArray.size());	//���� ���� ����
			randCarArray.add(nodeArray.get(temp));		//������ ��� ��ġ
		}
		
		
		
		return randCarArray;
	}
	
	
	
	
	
	
	
	
	/**
	 * �׷��� ���� �Լ�
	 * @param theEdge
	 */
	 private Graph.mapLine[] GRAPH = new Graph.mapLine[23874];
	 public Graph.mapLine[] edge2Graph(SF_cedge theEdge)
	 {
	    	SF_cnode theNode1 = nodeArray.get(theEdge.getStart_NodeID());
	               
	        assert theNode1 != null;
	        SF_cnode theNode2 = nodeArray.get(theEdge.getEnd_NodeID());
	        
	        assert theNode2 != null;
	    		GRAPH[theEdge.getEdgeID()] = new Graph.mapLine(theEdge.getStart_NodeID(),theEdge.getEnd_NodeID()
	    				,theEdge.getL2Distance());
	    		
	        return GRAPH;
	  }
	//********************************************************************************************************************
	
	
	
	
	
	
	
	
	
}






















