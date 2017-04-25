package com.tencent.mm.sdk.platformtools;

import android.os.Looper;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class ar<K, V> {
    public final ah aSW;
    public volatile boolean aSZ = false;
    private final long ajO;
    public final x<K, a<V>> gJW;
    public final LinkedHashMap<K, b<K, V>> nkG = new LinkedHashMap();
    private final c<K, V> nkH;
    public final ah nkI;
    private final long nkJ;
    private boolean nkK = true;
    protected Object tag;
    private final long threshold;

    static class a<V> {
        final V nkM;

        a(V v) {
            this.nkM = v;
        }

        public final boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.nkM != null) {
                return this.nkM.equals(aVar.nkM);
            }
            if (aVar.nkM == null) {
                return true;
            }
            return false;
        }
    }

    public static class b<K, V> {
        public K lTL;
        public int nkN;
        public V values;
    }

    public interface c<K, V> {
        boolean Ke();

        void Kf();

        void a(ar<K, V> arVar, b<K, V> bVar);
    }

    public ar(c<K, V> cVar, Looper looper, int i, int i2, long j, long j2) {
        if (cVar == null) {
            throw new IllegalArgumentException("arg appender can not be null!");
        } else if (looper == null) {
            throw new IllegalArgumentException("arg looper can not be null!");
        } else if (i <= 0) {
            throw new IllegalArgumentException("arg size can not be <= 0!");
        } else {
            this.nkH = cVar;
            this.gJW = new x(i);
            this.threshold = i2 > 0 ? (long) i2 : 40;
            if (j <= 0) {
                j = 60000;
            }
            this.nkJ = j;
            if (j2 <= 0) {
                j2 = 60000;
            }
            this.ajO = j2;
            this.aSW = new ah(looper, new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ ar nkL;

                {
                    this.nkL = r1;
                }

                public final boolean oU() {
                    long currentTimeMillis = System.currentTimeMillis();
                    this.nkL.iy(false);
                    v.i("MicroMsg.RWCache", "summer timer onTimerExpired e appendAll takes: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                    return false;
                }
            }, false);
            this.nkI = new ah(new ad("RWCache_timeoutChecker").htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ ar nkL;

                {
                    this.nkL = r1;
                }

                public final boolean oU() {
                    this.nkL.aSZ = true;
                    return false;
                }
            }, false);
        }
    }

    public final Object getTag() {
        return this.tag;
    }

    public final void setTag(Object obj) {
        this.tag = obj;
    }

    public final V get(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        a aVar = (a) this.gJW.get(k);
        if (aVar != null) {
            return aVar.nkM;
        }
        this.gJW.put(k, new a(null));
        return null;
    }

    public final boolean q(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        a aVar = (a) this.gJW.get(k);
        a aVar2 = new a(v);
        if (aVar2.equals(aVar)) {
            return false;
        }
        int i;
        this.gJW.put(k, aVar2);
        b bVar = new b();
        bVar.lTL = k;
        bVar.values = v;
        if (v == null) {
            i = 2;
        } else {
            i = 1;
        }
        bVar.nkN = i;
        synchronized (this) {
            this.nkG.put(k, bVar);
            if (this.nkK && ((long) this.nkG.size()) > this.threshold) {
                this.aSW.ea(0);
                this.nkK = false;
            } else if (this.aSW.btC()) {
                this.aSW.ea(this.nkJ);
            }
        }
        return true;
    }

    public final void iy(boolean z) {
        v.i("MicroMsg.RWCache", "summer appendAll force: " + z + " tid: " + Thread.currentThread().getId() + " holderMap size: " + this.nkG.size());
        synchronized (this) {
            this.nkK = true;
            if (this.nkG.isEmpty()) {
            } else if (this.nkH.Ke()) {
                Iterator it = this.nkG.entrySet().iterator();
                if (z) {
                    while (it.hasNext()) {
                        this.nkH.a(this, (b) ((Entry) it.next()).getValue());
                        it.remove();
                    }
                } else {
                    this.aSZ = false;
                    this.nkI.ea(this.ajO);
                    while (!this.aSZ && it.hasNext()) {
                        this.nkH.a(this, (b) ((Entry) it.next()).getValue());
                        it.remove();
                    }
                    this.nkI.QI();
                }
                this.nkH.Kf();
            }
        }
    }
}
