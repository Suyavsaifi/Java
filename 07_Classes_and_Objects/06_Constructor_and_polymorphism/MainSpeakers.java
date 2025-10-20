public class MainSpeakers {
    public static void main(String[] args){
        AmazonEcho amazon = new AmazonEcho();
        ApplePod apple = new ApplePod();
        GoogleAI google = new GoogleAI();

        amazon.wakeCommand();
        apple.wakeCommand();
        google.wakeCommand();
    }
}
