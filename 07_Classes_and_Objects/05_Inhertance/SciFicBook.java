public class SciFicBook extends Book {
    private String bookType = "SciFi Book";

    public String getSciFiBook(){
        return this.bookType;
    }

    public void setSciFiBookType(String new_name){
        this.bookType = new_name;
    }

    public String displayBinding(){
        return this.bindingType;
    }
}
