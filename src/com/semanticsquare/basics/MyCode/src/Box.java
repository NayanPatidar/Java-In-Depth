public class Box {

    double  width =1 ;
    double  length = 1 ;
    double  height = 1 ;

        Box(double x , double h , double d){
            System.out.println("In constructing phase! ");
           this.width = x;
           this.length = h;
          this.height = d;
        }

        Box(double x , double y){
            System.out.println("In constructing phase");
            this.length = x;
            this.width = y;
        }

        double volume(){
            return length*width*height;
        }

}


