public class Book {
    public String bookType = "Global Book";
    public String bindingType = "Spiral";

    public String getBook(){
        return this.bookType;
    }

    public void setBookType(String new_book_name){
        this.bookType = new_book_name;
    }

    public String displayBinding(){
        return this.bindingType;
    }
}
