package in.conceptarchitect.app;

import in.conceptarchitect.data.List; //check this package for unqualified class names.
import com.javapeople.data.Tree;

class FurnitureApp{
    public static void main(String []args){

            List list=new List();   //in.conceptarchitect.data.List
            System.out.println(list);
            list.add();
           
            Tree tree=new Tree();
            System.out.println(tree);

            com.javapeople.data.List list2=new com.javapeople.data.List();
            list2.append();
            System.out.println(list2);
      
    }
} 