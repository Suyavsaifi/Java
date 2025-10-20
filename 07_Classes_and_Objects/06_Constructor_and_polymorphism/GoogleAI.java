public class GoogleAI extends SmarkSpeaker{
    public GoogleAI(){
        super("Google");
    }

    @Override
    public void wakeCommand(){
        System.out.println("Wake command: Hey Google");
    }
}
