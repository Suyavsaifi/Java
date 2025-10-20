public class SmarkSpeaker {
    private String name = "Smart Speaker";
    public SmarkSpeaker(String name){
        this.name = name;

    }

    public void wakeCommand(){
        System.out.format("Use Wake command of %s's SmarkSpeaker\n", this.name);
    }
}
