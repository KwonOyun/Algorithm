package jagu9_2018;

import java.util.LinkedList;
import java.util.List;

public class TestOrderTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		OrderedTree treeA, treeB, treeD, treeE, treeG;
		OrderedTree treeC = new OrderedTree('C');OrderedTree treeF = new OrderedTree('F');
		OrderedTree treeH = new OrderedTree('H');OrderedTree treeI = new OrderedTree('I');
		OrderedTree treeJ = new OrderedTree('J');OrderedTree treeK = new OrderedTree('K');
		OrderedTree treeL = new OrderedTree('L');OrderedTree treeM = new OrderedTree('M');
		
		List subtreesOfE = new LinkedList();    //E노드 설정
		subtreesOfE.add(treeH); subtreesOfE.add(treeI);
		treeE = new OrderedTree('E', subtreesOfE);
		
		List subtreesOfG = new LinkedList();    //G노드 설정
		subtreesOfG.add(treeJ); subtreesOfG.add(treeK); subtreesOfG.add(treeL); subtreesOfG.add(treeM);
		treeG = new OrderedTree('G', subtreesOfG);
		
		List subtreesOfB = new LinkedList();    //B노드 설정
		subtreesOfB.add(treeE); subtreesOfB.add(treeF);
		treeB = new OrderedTree('B', subtreesOfB);
		
		List subtreesOfD = new LinkedList();   //D노드 설정
		subtreesOfD.add(treeG);
		treeD = new OrderedTree('D', subtreesOfD);
		
		List subtreesOfA = new LinkedList();   //A노드 설정
		subtreesOfA.add(treeB); subtreesOfA.add(treeC); subtreesOfA.add(treeD);
		treeA = new OrderedTree('A', subtreesOfA);
		
		treeA.levelOrder();  //A노드에 대해 레벨 순서 순회
	}

}
