package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import com.tencent.mmdb.FileUtils;

public final class s {
    private static final a ry;

    interface a {
        Intent a(Activity activity);

        String a(Context context, ActivityInfo activityInfo);

        boolean a(Activity activity, Intent intent);

        void b(Activity activity, Intent intent);
    }

    static class b implements a {
        b() {
        }

        public Intent a(Activity activity) {
            String b = s.b(activity);
            if (b == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, b);
            try {
                return s.b((Context) activity, componentName) == null ? android.support.v4.content.b.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (NameNotFoundException e) {
                new StringBuilder("getParentActivityIntent: bad parentActivityName '").append(b).append("' in manifest");
                return null;
            }
        }

        public boolean a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        public void b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }

        public String a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
            if (string == null) {
                return null;
            }
            if (string.charAt(0) == '.') {
                return context.getPackageName() + string;
            }
            return string;
        }
    }

    static class c extends b {
        c() {
        }

        public final Intent a(Activity activity) {
            Intent parentActivityIntent = activity.getParentActivityIntent();
            if (parentActivityIntent == null) {
                return super.a(activity);
            }
            return parentActivityIntent;
        }

        public final boolean a(Activity activity, Intent intent) {
            return activity.shouldUpRecreateTask(intent);
        }

        public final void b(Activity activity, Intent intent) {
            activity.navigateUpTo(intent);
        }

        public final String a(Context context, ActivityInfo activityInfo) {
            String str = activityInfo.parentActivityName;
            if (str == null) {
                return super.a(context, activityInfo);
            }
            return str;
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            ry = new c();
        } else {
            ry = new b();
        }
    }

    public static boolean a(Activity activity, Intent intent) {
        return ry.a(activity, intent);
    }

    public static void b(Activity activity, Intent intent) {
        ry.b(activity, intent);
    }

    public static Intent a(Activity activity) {
        return ry.a(activity);
    }

    public static Intent a(Context context, ComponentName componentName) {
        String b = b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return b(context, componentName2) == null ? android.support.v4.content.b.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String b(Activity activity) {
        try {
            return b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String b(Context context, ComponentName componentName) {
        return ry.a(context, context.getPackageManager().getActivityInfo(componentName, FileUtils.S_IWUSR));
    }
}
