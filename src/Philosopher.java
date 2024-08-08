
public class Philosopher implements Runnable{

    private Philosopher rigthPh;
    private Philosopher leftPh;
    private Integer number;
    private Integer eatCount =3;
    private volatile boolean doThink = true;// false = eat true = think

    public Philosopher(int number){
        //this.rigthPh=right;
        //this.leftPh=left;
        this.number=number;
    }
    @Override
    public void run() {
       int i=0;
        while(i<eatCount){
            Boolean left;
            Boolean right;
            synchronized(Philosopher.class){
                left = leftPh.getDoThink();
                right=rigthPh.getDoThink();
                if( left && right){
                    this.doThink=false;
                }
            }
            if( left && right){

                //System.out.println(String.format("Ph n %s doThink left %s doThink right %s",number, leftPh.getDoThink(),rigthPh.getDoThink()));
                try {
                    //this.doThink=false;
                    System.out.println(String.format("Philosopher number %s begin eating", number));
                    
                    Thread.sleep(5000);
                    
                    System.out.println(String.format("Philosopher number %s end eating", number));
                    this.doThink=true;
                    System.out.println(String.format("Philosopher number %s begin thinking", number));
                    
                    Thread.sleep(1000);
                    System.out.println(String.format("Philosopher number %s end thinking", number));
                    
                } catch (InterruptedException e) {
                    
                    e.printStackTrace();
                }
                i++;
            }
            

            
        }

    }
    public void setLeftRight(Philosopher left, Philosopher right){
        
        this.rigthPh=right;
        this.leftPh=left;
    }

    public synchronized boolean getDoThink(){
        return this.doThink;
    }



}
