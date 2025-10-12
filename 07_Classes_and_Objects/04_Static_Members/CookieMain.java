public class CookieMain {

    public static void main(String[] args){

        Cookie cookie1 = new Cookie("AA01", "Jackson",3);

//        System.out.println("Before updating cookie value");
//
//        System.out.println("Cookie Type: " + Cookie.getCookie());
//
//        Cookie.setCookie("NEW_CLASS_COOKIE");
//
//        System.out.println("After updating cookie value");
//
//        System.out.println("Cookie Type: " + cookie1.getCookie());




        //        System.out.println("Accessing via class");
//        System.out.println("Static Variable: " + Cookie.cookieType);
//
//        System.out.println("Accessing via class");
//        System.out.println("Static Variable: " + cookie1.cookieType);

//        cookie1.cookieType = "OBJECT_COOKIE";
//        Cookie.cookieType = "CLASS_COOKIE";

//        System.out.println("Accessing via class");
//        System.out.println("Static Variable: " + Cookie.cookieType);
//
//        System.out.println("Accessing via class");
//        System.out.println("Static Variable: " + cookie1.cookieType);


        // Method Overiding

        Cookie cookie2 = new Cookie("AA01", "Jackson",3);

        System.out.println("Cookie Object: " + cookie2.toString());




    }

}
