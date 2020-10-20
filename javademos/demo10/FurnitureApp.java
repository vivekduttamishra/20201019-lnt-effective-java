import data.*; //check this package for unqualified class names.
import furnitures.bedroom.*;
import furnitures.livingroom.* ;
//avoiding wild card conflicts
import data.Table;  //unqualified Table means Data.Table

class FurnitureApp{
    public static void main(String []args){

        List list=new List();  //will be check in global package and data package
        System.out.println(list);

        Table table=new Table();  //data.Table
        System.out.println(table);

        Bed bed=new Bed();       //no conflict
        System.out.println(bed);

        Chair chair=new Chair(); //furnitures.livingroom.Chair
        System.out.println(chair);

        //How do I resolve furnitures.livingroom.Table 
        //by using fully qualified paths
        furnitures.livingroom.Table table2=new furnitures.livingroom.Table();
        System.out.println(table2);

        //same goes for office furnitures
      
    }
} 