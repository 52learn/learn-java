package com.study.algorithm;

import java.util.*;

/**
 * TODO: incomplete
 */
public class ConsistentHashing {
    static List<Node> nodes = new ArrayList<>();
    static List<VirtualNode> virtualNodeList = new ArrayList<>();
    static int nodeSize = 3;
    static int totalVirtualNodeSize = 30;
    public static void main(String[] args) {


        for(int i=0;i<nodeSize;i++){
            Node node = new Node("redis"+i);
            for(int j=1;j<=totalVirtualNodeSize/nodeSize;j++){
                VirtualNode virtualNode = new VirtualNode(node,j,totalVirtualNodeSize);
                virtualNodeList.add(virtualNode);
            }
            nodes.add(node);
        }
        System.out.println(virtualNodeList);
        int predictCount = totalVirtualNodeSize/2;

        for(int i=0;i<predictCount;i++){
            String uuid = UUID.randomUUID().toString();
            int index = Math.abs(uuid.hashCode())%(totalVirtualNodeSize);
            System.out.println("uuid:"+uuid+",index:"+index);
        }

    }

    static VirtualNode findVirtualNode(Object item){
        int index = Math.abs(item.hashCode())%(totalVirtualNodeSize);
        for(int i=0;i<totalVirtualNodeSize;i++){

        }
        return null;
    }

    static class VirtualNode implements Comparable<VirtualNode>{
        public int hashCode;
        public Node node;

        public int index;

        public String virtualNodeName;

        public VirtualNode(Node node,int i,int totalVirtualNodeSize){
            this.virtualNodeName = node.name+"#"+i;
            this.hashCode = Math.abs(this.virtualNodeName.hashCode());
            index = Math.abs(hashCode)%totalVirtualNodeSize;
        }

        @Override
        public int compareTo(VirtualNode o) {
            if(this.hashCode>o.hashCode){
                return 1;
            }else if(this.hashCode<o.hashCode){
                return -1;
            }
            return 0;
        }
        @Override
        public String toString(){
           return this.virtualNodeName+":"+this.index;
        }
    }
    static class Node{
        public String name;
        public List<Object> items = new ArrayList<>();
        public Node(String name){
            this.name = name;
        }
    }
}
