package android.support.v4.content;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Process;
import java.io.File;

public class a {
    public static final Drawable a(Context context, int i) {
        if (VERSION.SDK_INT >= 21) {
            return context.getDrawable(i);
        }
        return context.getResources().getDrawable(i);
    }

    public static final int b(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColor(i);
        }
        return context.getResources().getColor(i);
    }

    public static int d(Context context, String str) {
        if (str != null) {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        }
        throw new IllegalArgumentException("permission is null");
    }

    public static synchronized File b(File file) {
        synchronized (a.class) {
            if (!(file.exists() || file.mkdirs() || file.exists())) {
                new StringBuilder("Unable to create files subdir ").append(file.getPath());
                file = null;
            }
        }
        return file;
    }
}
