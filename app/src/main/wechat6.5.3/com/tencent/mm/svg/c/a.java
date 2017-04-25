package com.tencent.mm.svg.c;

import java.lang.reflect.Field;

public final class a<T> {
    private boolean cfB;
    public Field cfC;
    private String classname;
    private String fieldName;
    public Object obj;

    public a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException("obj cannot be null");
        }
        this.obj = obj;
        this.fieldName = str;
        this.classname = null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void prepare() {
        /*
        r7 = this;
        r1 = 1;
        r0 = r7.cfB;
        if (r0 == 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r7.cfB = r1;
        r0 = r7.obj;
        r0 = r0.getClass();
        r1 = r0;
    L_0x000f:
        if (r1 == 0) goto L_0x0005;
    L_0x0011:
        r0 = r7.fieldName;	 Catch:{ Exception -> 0x0021, all -> 0x005a }
        r0 = r1.getDeclaredField(r0);	 Catch:{ Exception -> 0x0021, all -> 0x005a }
        r2 = 1;
        r0.setAccessible(r2);	 Catch:{ Exception -> 0x0021, all -> 0x005a }
        r7.cfC = r0;	 Catch:{ Exception -> 0x0021, all -> 0x005a }
        r1.getSuperclass();
        goto L_0x0005;
    L_0x0021:
        r0 = move-exception;
        r0 = r7.classname;	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        if (r0 == 0) goto L_0x0051;
    L_0x0026:
        r0 = r7.classname;	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        r2 = "";
        r0 = r0.equals(r2);	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        if (r0 != 0) goto L_0x0051;
    L_0x0031:
        r2 = r1.getDeclaredFields();	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        r3 = r2.length;	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        r0 = 0;
    L_0x0037:
        if (r0 >= r3) goto L_0x0051;
    L_0x0039:
        r4 = r2[r0];	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        r5 = r4.getType();	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        r5 = r5.getName();	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        r6 = r7.classname;	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        r5 = r5.equals(r6);	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        if (r5 == 0) goto L_0x0057;
    L_0x004b:
        r0 = 1;
        r4.setAccessible(r0);	 Catch:{ Exception -> 0x005f, all -> 0x005a }
        r7.cfC = r4;	 Catch:{ Exception -> 0x005f, all -> 0x005a }
    L_0x0051:
        r0 = r1.getSuperclass();
        r1 = r0;
        goto L_0x000f;
    L_0x0057:
        r0 = r0 + 1;
        goto L_0x0037;
    L_0x005a:
        r0 = move-exception;
        r1.getSuperclass();
        throw r0;
    L_0x005f:
        r0 = move-exception;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.svg.c.a.prepare():void");
    }

    public final T get() {
        prepare();
        if (this.cfC == null) {
            throw new NoSuchFieldException();
        }
        try {
            return this.cfC.get(this.obj);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("unable to cast object");
        }
    }
}
