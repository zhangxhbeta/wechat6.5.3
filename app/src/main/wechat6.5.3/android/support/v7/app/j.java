package android.support.v7.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.y;
import android.support.v7.a.a.k;
import android.support.v7.view.d;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

final class j {
    private static final Class<?>[] GI = new Class[]{Context.class, AttributeSet.class};
    private static final int[] GJ = new int[]{16843375};
    private static final String[] GK = new String[]{"android.widget.", "android.view.", "android.webkit."};
    private static final Map<String, Constructor<? extends View>> GL = new android.support.v4.e.a();
    private final Object[] GM = new Object[2];

    private static class a implements OnClickListener {
        private final View GN;
        private final String GO;
        private Method GP;
        private Context GQ;

        public a(View view, String str) {
            this.GN = view;
            this.GO = str;
        }

        public final void onClick(View view) {
            if (this.GP == null) {
                for (Context context = this.GN.getContext(); context != null; context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null) {
                    try {
                        if (!context.isRestricted()) {
                            Method method = context.getClass().getMethod(this.GO, new Class[]{View.class});
                            if (method != null) {
                                this.GP = method;
                                this.GQ = context;
                            }
                        }
                    } catch (NoSuchMethodException e) {
                    }
                }
                int id = this.GN.getId();
                throw new IllegalStateException("Could not find method " + this.GO + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.GN.getClass() + (id == -1 ? SQLiteDatabase.KeyEmpty : " with id '" + this.GN.getContext().getResources().getResourceEntryName(id) + "'"));
            }
            try {
                this.GP.invoke(this.GQ, new Object[]{view});
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e2);
            } catch (Throwable e22) {
                throw new IllegalStateException("Could not execute method for android:onClick", e22);
            }
        }
    }

    j() {
    }

    final View a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.GM[0] = context;
            this.GM[1] = attributeSet;
            View b;
            if (-1 == str.indexOf(46)) {
                for (String b2 : GK) {
                    b = b(context, str, b2);
                    if (b != null) {
                        return b;
                    }
                }
                this.GM[0] = null;
                this.GM[1] = null;
                return null;
            }
            b = b(context, str, null);
            this.GM[0] = null;
            this.GM[1] = null;
            return b;
        } catch (Exception e) {
            return null;
        } finally {
            this.GM[0] = null;
            this.GM[1] = null;
        }
    }

    static void a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || y.al(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GJ);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    private View b(Context context, String str, String str2) {
        Constructor constructor = (Constructor) GL.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(GI);
                GL.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.GM);
    }

    static Context a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        int resourceId;
        int resourceId2;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.dD, 0, 0);
        if (z) {
            resourceId = obtainStyledAttributes.getResourceId(k.Ni, 0);
        } else {
            resourceId = 0;
        }
        if (resourceId == 0) {
            resourceId2 = obtainStyledAttributes.getResourceId(k.Nj, 0);
        } else {
            resourceId2 = resourceId;
        }
        obtainStyledAttributes.recycle();
        if (resourceId2 == 0) {
            return context;
        }
        if ((context instanceof d) && ((d) context).NH == resourceId2) {
            return context;
        }
        return new d(context, resourceId2);
    }
}
