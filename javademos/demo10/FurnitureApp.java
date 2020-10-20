class FurnitureApp{
    public static void main(String []args){

        //Bed bed=new Bed();

        //you must specify a package qualified class name to use class
        furnitures.bedroom.Bed bed=new furnitures.bedroom.Bed();       
        System.out.printf("The price of %s is %d\n",bed, bed.price());
    }
} 