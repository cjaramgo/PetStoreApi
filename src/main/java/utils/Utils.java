package utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Utils {

    public static String getPetKind(){
        final String[] kind = {"Dog", "Cat"};
        Random random = new Random();
        int index = random.nextInt(kind.length);
        return kind[index];
    }

    public static String getCurrentDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return sdf.format(Calendar.getInstance().getTime());
    }

}
