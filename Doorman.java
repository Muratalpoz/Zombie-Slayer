public class Doorman extends Thread {
    ZombieCounter zc;
    public Doorman( ZombieCounter zc ){
        this.zc=zc;
    }

    public void run(){
        while(!zc.tooManyZombiesInTheRoom () && !zc.killed100Zombies ()){
            double r= Math.random ();
            if(r<0.5){
                zc.zombieEntered ();
            }
            try
            {
                Thread.sleep(2000);
            }
            catch (InterruptedException e){
                e.printStackTrace ();
            }

        }

    }


}
