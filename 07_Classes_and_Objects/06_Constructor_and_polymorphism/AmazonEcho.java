public class AmazonEcho extends SmarkSpeaker{
    public AmazonEcho(){
        super("Amazon Echo");
    }

    @Override
    public void wakeCommand(){
        System.out.println("Wake Command: Hi Alexa");
    }
}
