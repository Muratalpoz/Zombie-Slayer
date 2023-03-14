public class Simulator {
    public static void main(String []args){
        Doorman[] doorman;
        Slayer slayer;
        ZombieCounter zc= new ZombieCounter();
        slayer= new Slayer(zc);
        int n= Integer.parseInt(args[0]);
        doorman= new Doorman[n];
        for(int i=0; i<n ;i++){
            doorman[i]= new Doorman(zc);
        }
        for(int i=0; i<n ; i++){
            doorman[i].start();
        }
        slayer.start();

        try
        {
            slayer.join();
            for(int i=0 ; i<n ; i++){
                doorman[i].join();
            }
        }catch(InterruptedException e)
        {
            e.printStackTrace();

        }

        System.out.println("Game Over\n"
                + "you" + (zc.getKilledCount() >=100? "won!" : "lost!") );
        System.out.println("number of zombies: " + zc.getInTheRoomCount());
        System.out.println("number of killed: " + zc.getKilledCount());
    }

}