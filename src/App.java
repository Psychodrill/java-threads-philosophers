import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Integer count =2;
        ArrayList<Philosopher> philArrList = new ArrayList<Philosopher>();
        for(int i=0; i<count; i++){
            philArrList.add(new Philosopher(i));
        }
        
        for(int i=0; i<count; i++){
            Philosopher left=null;
            Philosopher right=null;
            if(i-1<0){
                left = philArrList.get(philArrList.size()-1);
                right=philArrList.get(i+1);
            }
            else if(i+1>=count){
                right = philArrList.get(0);
                left = philArrList.get(i-1);
            }
            else{
                left = philArrList.get(i-1);
                right=philArrList.get(i+1);
                
            }
            philArrList.get(i).setLeftRight(left, right);

        }

        for (Philosopher item : philArrList) {
            Thread thread = new Thread(item);
            thread.start();
            //thread.join();
        }

    }
}
