public class Cookie {

    public String id;
    public String userName;
    public int itemsInCart;

    private static String cookieType = "CLASS_COOKIE";

    public Cookie(String id, String userName, int itemsInCart){
        this.id = id;
        this.userName = userName;
        this.itemsInCart = itemsInCart;
    }

    public static String getCookie(){
        return Cookie.cookieType;
    }

    public static void setCookie(String new_cookie){
        Cookie.cookieType = new_cookie;

    }

    @Override
    public String toString(){
        return "Cookie [id=" + id + " ,name="+userName + " and #Cart=" + itemsInCart + "]";
    }




}
