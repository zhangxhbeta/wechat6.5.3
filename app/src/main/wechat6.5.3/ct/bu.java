package ct;

import android.location.Location;
import android.os.Bundle;

public final class bu {
    public static final Bundle a = new Bundle();
    public static final Location b = new Location("EMPTY");

    public static String a(int i, int i2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://lbs.map.qq.com/loc");
        stringBuilder.append("?");
        stringBuilder.append("c=1");
        stringBuilder.append("&mars=").append(i);
        stringBuilder.append("&obs=").append(i2);
        return stringBuilder.toString();
    }
}
