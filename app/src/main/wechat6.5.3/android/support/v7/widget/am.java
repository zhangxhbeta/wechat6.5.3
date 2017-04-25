package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class am extends ContextWrapper {
    private static final ArrayList<WeakReference<am>> adH = new ArrayList();
    private Resources BE;

    public static Context o(Context context) {
        if (context instanceof am) {
            return context;
        }
        Context context2;
        int size = adH.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) adH.get(i);
            context2 = weakReference != null ? (am) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new am(context);
        adH.add(new WeakReference(context2));
        return context2;
    }

    private am(Context context) {
        super(context);
    }

    public final Resources getResources() {
        if (this.BE == null) {
            this.BE = new ao(this, super.getResources());
        }
        return this.BE;
    }
}
