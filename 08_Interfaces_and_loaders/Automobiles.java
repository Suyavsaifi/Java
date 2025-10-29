import java.util.Calendar;

public interface Automobiles {


//    String safetyStandard = "Global Safety Standard";

    String get_model();

    String get_make();

    Double get_year();

    default String release_date() {
        return getReleaseDate();
    }

    static String getReleaseDate() {
        Calendar now = Calendar.getInstance();
        return String.format("Day = %s, Month = %s and Year = %s", now.get(Calendar.DAY_OF_MONTH), now.get(Calendar.MONTH), now.get(Calendar.YEAR));
    }
}
