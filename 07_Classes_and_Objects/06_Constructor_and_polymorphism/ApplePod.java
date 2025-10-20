public class ApplePod extends SmarkSpeaker{
    public ApplePod(){
        super("Apple Pod");
    }
    @Override
    public void wakeCommand(){
        System.out.println("Wake Command: Hi Siri");
    }
}
