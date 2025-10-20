public class FictionalBook extends Book{
    private String bookType = "Fictional Book";

    public String getFictinalBook(){
        return this.bookType;
    }

    public void setFictionalBookType(String new_name){
        this.bookType = new_name;
    }

    public String displayBinding(){
        return this.bindingType;
    }
}
