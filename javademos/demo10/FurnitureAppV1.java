class FurnitureApp{
    public static void main(String []args){

        
        furnitures.bedroom.Bed bed=new furnitures.bedroom.Bed();               
        System.out.printf("The price of %s is %d\n",bed, bed.price());

        furnitures.livingroom.Chair chair=new furnitures.livingroom.Chair();               
        System.out.printf("The price of %s is %d\n",chair, chair.price());

        furnitures.livingroom.Table table=new furnitures.livingroom.Table();               
        System.out.printf("The price of %s is %d\n",table, table.price());


        furnitures.office.Chair chair2=new furnitures.office.Chair();               
        System.out.printf("The price of %s is %d\n",chair2, chair2.price());

        furnitures.office.Table table2=new furnitures.office.Table();               
        System.out.printf("The price of %s is %d\n",table2, table2.price());

        data.List list=new data.List();
        System.out.println(list);
        data.Table table3=new data.Table();
        System.out.println(table3);
    }
} 