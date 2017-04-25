package com.tencent.mmdb.support;

import android.annotation.SuppressLint;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap(0, 0.75f, true);
    }

    public void resize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = i;
        }
        trimToSize(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000b;
    L_0x0002:
        r0 = new java.lang.NullPointerException;
        r1 = "key == null";
        r0.<init>(r1);
        throw r0;
    L_0x000b:
        monitor-enter(r4);
        r0 = r4.map;	 Catch:{ all -> 0x002b }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002b }
        if (r0 == 0) goto L_0x001c;
    L_0x0014:
        r1 = r4.hitCount;	 Catch:{ all -> 0x002b }
        r1 = r1 + 1;
        r4.hitCount = r1;	 Catch:{ all -> 0x002b }
        monitor-exit(r4);	 Catch:{ all -> 0x002b }
    L_0x001b:
        return r0;
    L_0x001c:
        r0 = r4.missCount;	 Catch:{ all -> 0x002b }
        r0 = r0 + 1;
        r4.missCount = r0;	 Catch:{ all -> 0x002b }
        monitor-exit(r4);	 Catch:{ all -> 0x002b }
        r1 = r4.create(r5);
        if (r1 != 0) goto L_0x002e;
    L_0x0029:
        r0 = 0;
        goto L_0x001b;
    L_0x002b:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002b }
        throw r0;
    L_0x002e:
        monitor-enter(r4);
        r0 = r4.createCount;	 Catch:{ all -> 0x0054 }
        r0 = r0 + 1;
        r4.createCount = r0;	 Catch:{ all -> 0x0054 }
        r0 = r4.map;	 Catch:{ all -> 0x0054 }
        r0 = r0.put(r5, r1);	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x004a;
    L_0x003d:
        r2 = r4.map;	 Catch:{ all -> 0x0054 }
        r2.put(r5, r0);	 Catch:{ all -> 0x0054 }
    L_0x0042:
        monitor-exit(r4);	 Catch:{ all -> 0x0054 }
        if (r0 == 0) goto L_0x0057;
    L_0x0045:
        r2 = 0;
        r4.entryRemoved(r2, r5, r1, r0);
        goto L_0x001b;
    L_0x004a:
        r2 = r4.size;	 Catch:{ all -> 0x0054 }
        r3 = r4.safeSizeOf(r5, r1);	 Catch:{ all -> 0x0054 }
        r2 = r2 + r3;
        r4.size = r2;	 Catch:{ all -> 0x0054 }
        goto L_0x0042;
    L_0x0054:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0054 }
        throw r0;
    L_0x0057:
        r0 = r4.maxSize;
        r4.trimToSize(r0);
        r0 = r1;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmdb.support.LruCache.get(java.lang.Object):V");
    }

    public final V put(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.putCount++;
            this.size += safeSizeOf(k, v);
            put = this.map.put(k, v);
            if (put != null) {
                this.size -= safeSizeOf(k, put);
            }
        }
        if (put != null) {
            entryRemoved(false, k, put, v);
        }
        trimToSize(this.maxSize);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r6) {
        /*
        r5 = this;
        r1 = 0;
    L_0x0001:
        monitor-enter(r5);
        r0 = r5.size;	 Catch:{ all -> 0x0034 }
        if (r0 < 0) goto L_0x0012;
    L_0x0006:
        r0 = r5.map;	 Catch:{ all -> 0x0034 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0034 }
        if (r0 == 0) goto L_0x0037;
    L_0x000e:
        r0 = r5.size;	 Catch:{ all -> 0x0034 }
        if (r0 == 0) goto L_0x0037;
    L_0x0012:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0034 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0034 }
        r1.<init>();	 Catch:{ all -> 0x0034 }
        r2 = r5.getClass();	 Catch:{ all -> 0x0034 }
        r2 = r2.getName();	 Catch:{ all -> 0x0034 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0034 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0034 }
        r1 = r1.toString();	 Catch:{ all -> 0x0034 }
        r0.<init>(r1);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0034:
        r0 = move-exception;
        monitor-exit(r5);	 Catch:{ all -> 0x0034 }
        throw r0;
    L_0x0037:
        r0 = r5.size;	 Catch:{ all -> 0x0034 }
        if (r0 <= r6) goto L_0x0043;
    L_0x003b:
        r0 = r5.map;	 Catch:{ all -> 0x0034 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0034 }
        if (r0 == 0) goto L_0x0045;
    L_0x0043:
        monitor-exit(r5);	 Catch:{ all -> 0x0034 }
    L_0x0044:
        return;
    L_0x0045:
        r0 = r5.map;	 Catch:{ all -> 0x0034 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0034 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0034 }
        r0 = r0.hasNext();	 Catch:{ all -> 0x0034 }
        if (r0 == 0) goto L_0x008c;
    L_0x0055:
        r0 = r5.map;	 Catch:{ all -> 0x0034 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0034 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0034 }
        r0 = r0.next();	 Catch:{ all -> 0x0034 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0034 }
    L_0x0065:
        if (r0 != 0) goto L_0x0069;
    L_0x0067:
        monitor-exit(r5);	 Catch:{ all -> 0x0034 }
        goto L_0x0044;
    L_0x0069:
        r2 = r0.getKey();	 Catch:{ all -> 0x0034 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0034 }
        r3 = r5.map;	 Catch:{ all -> 0x0034 }
        r3.remove(r2);	 Catch:{ all -> 0x0034 }
        r3 = r5.size;	 Catch:{ all -> 0x0034 }
        r4 = r5.safeSizeOf(r2, r0);	 Catch:{ all -> 0x0034 }
        r3 = r3 - r4;
        r5.size = r3;	 Catch:{ all -> 0x0034 }
        r3 = r5.evictionCount;	 Catch:{ all -> 0x0034 }
        r3 = r3 + 1;
        r5.evictionCount = r3;	 Catch:{ all -> 0x0034 }
        monitor-exit(r5);	 Catch:{ all -> 0x0034 }
        r3 = 1;
        r5.entryRemoved(r3, r2, r0, r1);
        goto L_0x0001;
    L_0x008c:
        r0 = r1;
        goto L_0x0065;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmdb.support.LruCache.trimToSize(int):void");
    }

    public final V remove(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        V remove;
        synchronized (this) {
            remove = this.map.remove(k);
            if (remove != null) {
                this.size -= safeSizeOf(k, remove);
            }
        }
        if (remove != null) {
            entryRemoved(false, k, remove, null);
        }
        return remove;
    }

    public void entryRemoved(boolean z, K k, V v, V v2) {
    }

    protected V create(K k) {
        return null;
    }

    private int safeSizeOf(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected int sizeOf(K k, V v) {
        return 1;
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    @SuppressLint({"DefaultLocale"})
    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.hitCount + this.missCount;
            if (i2 != 0) {
                i = (this.hitCount * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i)});
        }
        return format;
    }
}
