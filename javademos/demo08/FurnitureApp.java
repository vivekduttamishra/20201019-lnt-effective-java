
class FurnitureApp{

    public static void main(String []args){

        Chair chair=new Chair();

        Bed bed=new Bed();

        Table table=new Table();

        List list=new List();

        System.out.printf("The price of %s is %d\n",chair, chair.price());
        System.out.printf("The price of %s is %d\n",bed, bed.price());
        System.out.printf("The price of %s is %d\n",
        table, table.price());
        
     
        System.out.println("list is "+list);
    }
}