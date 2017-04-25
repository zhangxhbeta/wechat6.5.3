package android.support.v4.b;

import android.graphics.Color;
import com.tencent.smtt.sdk.WebView;

public final class a {
    private static final ThreadLocal<double[]> tr = new ThreadLocal();

    public static int h(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int i3 = 255 - (((255 - alpha) * (255 - alpha2)) / WebView.NORMAL_MODE_ALPHA);
        return Color.argb(i3, b(Color.red(i), alpha2, Color.red(i2), alpha, i3), b(Color.green(i), alpha2, Color.green(i2), alpha, i3), b(Color.blue(i), alpha2, Color.blue(i2), alpha, i3));
    }

    private static int b(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * WebView.NORMAL_MODE_ALPHA) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * WebView.NORMAL_MODE_ALPHA);
    }

    public static int i(int i, int i2) {
        if (i2 >= 0 && i2 <= WebView.NORMAL_MODE_ALPHA) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }
}
