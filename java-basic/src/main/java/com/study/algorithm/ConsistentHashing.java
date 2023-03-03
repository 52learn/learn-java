package com.study.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO: incomplete
 */
public class ConsistentHashing {


    public static void main(String[] args) {
        List<VirtualNode> virtualNodeList = new ArrayList<>();
        for(int i=0;i<3;i++){
            for(int j=1;j<10;j++){
                VirtualNode virtualNode = new VirtualNode("redis"+i,j);
                virtualNodeList.add(virtualNode);
            }
        }
        System.out.println(virtualNodeList);

        System.out.println("sss".hashCode());
        System.out.println("fffsssss".hashCode());
    }

    static class VirtualNode implements Comparable<VirtualNode>{
        public int hashCode;
        public String realNodeName;

        public String virtualNodeName;

        public VirtualNode(String realNodeName,int i){
            this.virtualNodeName = realNodeName+"#"+i;
            this.hashCode = Math.abs(this.virtualNodeName.hashCode());
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
           return this.virtualNodeName+":"+this.hashCode;
        }
    }
}
