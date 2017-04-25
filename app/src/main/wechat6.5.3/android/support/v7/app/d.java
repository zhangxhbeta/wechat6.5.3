package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

public abstract class d {
    static int FC = -1;

    public abstract void addContentView(View view, LayoutParams layoutParams);

    public abstract ActionBar cV();

    public abstract void cW();

    public abstract void cX();

    public abstract boolean cY();

    public abstract View findViewById(int i);

    public abstract MenuInflater getMenuInflater();

    public abstract void invalidateOptionsMenu();

    public abstract void onConfigurationChanged(Configuration configuration);

    public abstract void onCreate(Bundle bundle);

    public abstract void onDestroy();

    public abstract void onPostResume();

    public abstract void onSaveInstanceState(Bundle bundle);

    public abstract void onStop();

    public abstract boolean requestWindowFeature(int i);

    public abstract void setContentView(int i);

    public abstract void setContentView(View view);

    public abstract void setContentView(View view, LayoutParams layoutParams);

    public abstract void setTitle(CharSequence charSequence);

    public static d a(Activity activity, c cVar) {
        return a(activity, activity.getWindow(), cVar);
    }

    public static d a(Dialog dialog, c cVar) {
        return a(dialog.getContext(), dialog.getWindow(), cVar);
    }

    private static d a(Context context, Window window, c cVar) {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            return new h(context, window, cVar);
        }
        if (i >= 14) {
            return new g(context, window, cVar);
        }
        if (i >= 11) {
            return new f(context, window, cVar);
        }
        return new AppCompatDelegateImplV7(context, window, cVar);
    }

    d() {
    }
}
