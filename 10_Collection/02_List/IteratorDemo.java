import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

    public static void main(String[] args){
        Iterable<String> iterable = List.of("One", "Two", "Three");
        Iterator<String> it = iterable.iterator();

        while(it.hasNext()){
            String s = it.next();
            System.out.println(s);
        }
    }
}
