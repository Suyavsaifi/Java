public class FoorEachLoop {
    public static void main(String[] args){

        String[] cityName = {"New York", "London", "Belgium", "Bengaluru", "New Delhi"};
        for (String city:cityName){
//            if (city=="London"){
//                continue;
//            }
            if (city == "Bengaluru"){
                break;
            }
            System.out.println("City Name is " + city);
        }
        System.out.println("Exited the Loop");
    }
}
