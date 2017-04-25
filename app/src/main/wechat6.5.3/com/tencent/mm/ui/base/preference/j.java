package com.tencent.mm.ui.base.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.InflateException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

public final class j {
    private static HashMap<String, Constructor<?>> odr = new HashMap();
    private static final Class<?>[] ods = new Class[]{Context.class, AttributeSet.class};
    final Object[] GM = new Object[2];
    final Context mContext;

    public j(Context context) {
        this.mContext = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.mm.ui.base.preference.Preference a(java.lang.String r7, java.lang.String r8, android.util.AttributeSet r9) {
        /*
        r6 = this;
        r0 = odr;
        r0 = r0.get(r7);
        r0 = (java.lang.reflect.Constructor) r0;
        if (r0 != 0) goto L_0x00af;
    L_0x000a:
        r1 = r6.mContext;	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x007b }
        r2 = r1.getClassLoader();	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x007b }
        if (r8 == 0) goto L_0x003e;
    L_0x0012:
        r1 = new java.lang.StringBuilder;	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x007b }
        r1.<init>();	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x007b }
        r1 = r1.append(r8);	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x007b }
        r1 = r1.append(r7);	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x007b }
        r1 = r1.toString();	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x007b }
    L_0x0023:
        r1 = r2.loadClass(r1);	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x007b }
        r2 = ods;	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x007b }
        r1 = r1.getConstructor(r2);	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x007b }
        r0 = odr;	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x00aa }
        r0.put(r7, r1);	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x00aa }
    L_0x0032:
        r0 = r6.GM;	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x00aa }
        r2 = 1;
        r0[r2] = r9;	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x00aa }
        r0 = r1.newInstance(r0);	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x00aa }
        r0 = (com.tencent.mm.ui.base.preference.Preference) r0;	 Catch:{ NoSuchMethodException -> 0x0040, ClassNotFoundException -> 0x0079, Exception -> 0x00aa }
        return r0;
    L_0x003e:
        r1 = r7;
        goto L_0x0023;
    L_0x0040:
        r0 = move-exception;
        r1 = new android.view.InflateException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r9.getPositionDescription();
        r2 = r2.append(r3);
        r3 = ": Error inflating class ";
        r2 = r2.append(r3);
        if (r8 == 0) goto L_0x006a;
    L_0x0059:
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3 = r3.append(r8);
        r3 = r3.append(r7);
        r7 = r3.toString();
    L_0x006a:
        r2 = r2.append(r7);
        r2 = r2.toString();
        r1.<init>(r2);
        r1.initCause(r0);
        throw r1;
    L_0x0079:
        r0 = move-exception;
        throw r0;
    L_0x007b:
        r1 = move-exception;
    L_0x007c:
        r2 = new android.view.InflateException;
        if (r9 == 0) goto L_0x008b;
    L_0x0080:
        r0 = r9.getPositionDescription();
    L_0x0084:
        r2.<init>(r0);
        r2.initCause(r1);
        throw r2;
    L_0x008b:
        r3 = new java.lang.StringBuilder;
        r4 = "(null): Error inflating class ";
        r3.<init>(r4);
        r3 = r3.append(r0);
        r3 = r3.toString();
        if (r3 == 0) goto L_0x00a6;
    L_0x009d:
        r0 = r0.getClass();
        r0 = r0.getName();
        goto L_0x0084;
    L_0x00a6:
        r0 = "(null)";
        goto L_0x0084;
    L_0x00aa:
        r0 = move-exception;
        r5 = r0;
        r0 = r1;
        r1 = r5;
        goto L_0x007c;
    L_0x00af:
        r1 = r0;
        goto L_0x0032;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.base.preference.j.a(java.lang.String, java.lang.String, android.util.AttributeSet):com.tencent.mm.ui.base.preference.Preference");
    }

    Preference a(String str, AttributeSet attributeSet) {
        InflateException inflateException;
        try {
            if (-1 == str.indexOf(46)) {
                return a(str, "com.tencent.mm.ui.base.preference.", attributeSet);
            }
            return a(str, null, attributeSet);
        } catch (InflateException e) {
            throw e;
        } catch (Throwable e2) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e2);
            throw inflateException;
        } catch (Throwable e22) {
            inflateException = new InflateException(attributeSet.getPositionDescription() + ": Error inflating class " + str);
            inflateException.initCause(e22);
            throw inflateException;
        }
    }

    void a(XmlPullParser xmlPullParser, f fVar, AttributeSet attributeSet) {
        int depth = xmlPullParser.getDepth();
        int next = xmlPullParser.next();
        while (true) {
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next != 2) {
                next = xmlPullParser.next();
            } else {
                fVar.a(a(xmlPullParser.getName(), attributeSet), -1);
                next = xmlPullParser.next();
            }
        }
    }
}
