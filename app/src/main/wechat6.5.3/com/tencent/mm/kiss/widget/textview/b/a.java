package com.tencent.mm.kiss.widget.textview.b;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Constructor;

public class a {
    private static boolean cmL;
    private static boolean cmM;
    private static Constructor<StaticLayout> cmN;
    private static Object cmO;

    @TargetApi(18)
    private static synchronized void vU() {
        synchronized (a.class) {
            if (!cmL) {
                try {
                    Class cls;
                    if (VERSION.SDK_INT >= 18) {
                        cls = TextDirectionHeuristic.class;
                        cmO = TextDirectionHeuristics.FIRSTSTRONG_LTR;
                    } else {
                        ClassLoader classLoader = a.class.getClassLoader();
                        cls = classLoader.loadClass("android.text.TextDirectionHeuristic");
                        Class loadClass = classLoader.loadClass("android.text.TextDirectionHeuristics");
                        cmO = loadClass.getField("FIRSTSTRONG_LTR").get(loadClass);
                    }
                    Constructor declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TruncateAt.class, Integer.TYPE, Integer.TYPE});
                    cmN = declaredConstructor;
                    declaredConstructor.setAccessible(true);
                    cmL = true;
                } catch (NoSuchMethodException e) {
                    v.e("StaticTextView.StaticLayoutWithMaxLines", "StaticLayout constructor with max lines not found.", e);
                    cmM = true;
                    cmL = true;
                } catch (ClassNotFoundException e2) {
                    v.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristic class not found.", e2);
                    cmM = true;
                    cmL = true;
                } catch (NoSuchFieldException e3) {
                    v.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not found.", e3);
                    cmM = true;
                    cmL = true;
                } catch (IllegalAccessException e4) {
                    v.e("StaticTextView.StaticLayoutWithMaxLines", "TextDirectionHeuristics.FIRSTSTRONG_LTR not accessible.", e4);
                    cmM = true;
                    cmL = true;
                } catch (Exception e5) {
                    v.e("StaticTextView.StaticLayoutWithMaxLines", "Other error.", e5);
                    cmM = true;
                    cmL = true;
                } catch (Throwable th) {
                    cmL = true;
                }
                v.i("StaticTextView.StaticLayoutWithMaxLines", "ensureInitialized finish, sInitialError: " + cmM);
            }
        }
    }

    public static synchronized StaticLayout a(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, float f, float f2, boolean z, TruncateAt truncateAt, int i4, int i5) {
        StaticLayout staticLayout;
        synchronized (a.class) {
            vU();
            if (cmM) {
                throw new IllegalStateException("initialize error, cannot create StaticLayout");
            }
            try {
                staticLayout = (StaticLayout) cmN.newInstance(new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), textPaint, Integer.valueOf(i3), alignment, cmO, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), truncateAt, Integer.valueOf(i4), Integer.valueOf(i5)});
            } catch (Exception e) {
                throw new IllegalStateException("Error creating StaticLayout with max lines: " + e.getCause());
            }
        }
        return staticLayout;
    }

    public static synchronized StaticLayout a(CharSequence charSequence, int i, int i2, TextPaint textPaint, int i3, Alignment alignment, TextDirectionHeuristic textDirectionHeuristic, float f, float f2, boolean z, TruncateAt truncateAt, int i4, int i5) {
        StaticLayout staticLayout;
        synchronized (a.class) {
            vU();
            if (cmM) {
                throw new IllegalStateException("initialize error, cannot create StaticLayout");
            }
            try {
                staticLayout = (StaticLayout) cmN.newInstance(new Object[]{charSequence, Integer.valueOf(i), Integer.valueOf(i2), textPaint, Integer.valueOf(i3), alignment, textDirectionHeuristic, Float.valueOf(f), Float.valueOf(f2), Boolean.valueOf(z), truncateAt, Integer.valueOf(i4), Integer.valueOf(i5)});
            } catch (Exception e) {
                throw new IllegalStateException("Error creating StaticLayout with max lines: " + e.getCause());
            }
        }
        return staticLayout;
    }
}
