package com.tencent.mm.p;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public final class a {
    static a ciq;
    public b cir = new b();
    ArrayList<WeakReference<a>> cis = new ArrayList();
    public boolean cit = false;
    private final int ciu = 0;
    private final int civ = 1;
    private ac handler = new ac(this, Looper.getMainLooper()) {
        final /* synthetic */ a ciw;

        public final void handleMessage(Message message) {
            if (message.what == 0 && (message.obj instanceof b)) {
                b bVar = (b) message.obj;
                if (bVar.ciy != null) {
                    a aVar = this.ciw;
                    com.tencent.mm.storage.t.a aVar2 = bVar.ciy;
                    ArrayList arrayList = null;
                    Iterator it = aVar.cis.iterator();
                    while (it.hasNext()) {
                        WeakReference weakReference = (WeakReference) it.next();
                        if (weakReference == null || weakReference.get() == null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(weakReference);
                        } else {
                            ((a) weakReference.get()).a(aVar2);
                        }
                    }
                    if (arrayList != null) {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            aVar.cis.remove((WeakReference) it2.next());
                        }
                        arrayList.clear();
                    }
                } else {
                    a.a(this.ciw, bVar.cix, bVar.type, bVar.value);
                }
            }
            if (message.what == 1 && (message.obj instanceof c)) {
                c cVar = (c) message.obj;
                if (cVar.ciy != null) {
                    a.a(this.ciw, cVar.ciA, cVar.ciy);
                } else {
                    a.a(this.ciw, cVar.ciz, cVar.cix);
                }
            }
        }
    };

    public interface a {
        void a(com.tencent.mm.storage.t.a aVar);

        void er(int i);

        void es(int i);
    }

    class b {
        final /* synthetic */ a ciw;
        int cix;
        com.tencent.mm.storage.t.a ciy;
        int type;
        String value;

        public b(a aVar, int i, int i2, String str) {
            this.ciw = aVar;
            this.cix = i;
            this.type = i2;
            this.value = str;
        }

        public b(a aVar, com.tencent.mm.storage.t.a aVar2, int i, String str) {
            this.ciw = aVar;
            this.ciy = aVar2;
            this.type = 1;
            this.value = str;
        }
    }

    class c {
        com.tencent.mm.storage.t.a ciA;
        final /* synthetic */ a ciw;
        int cix;
        com.tencent.mm.storage.t.a ciy;
        int ciz;

        public c(a aVar, int i, int i2) {
            this.ciw = aVar;
            this.ciz = i;
            this.cix = i2;
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2) {
        ArrayList arrayList = null;
        Iterator it = aVar.cis.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                ((a) weakReference.get()).es(i);
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.cis.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    static /* synthetic */ void a(a aVar, int i, int i2, String str) {
        ArrayList arrayList = null;
        Iterator it = aVar.cis.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                ((a) weakReference.get()).er(i);
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.cis.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    static /* synthetic */ void a(a aVar, com.tencent.mm.storage.t.a aVar2, com.tencent.mm.storage.t.a aVar3) {
        ArrayList arrayList = null;
        Iterator it = aVar.cis.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            if (weakReference == null || weakReference.get() == null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(weakReference);
            } else {
                weakReference.get();
            }
        }
        if (arrayList != null) {
            it = arrayList.iterator();
            while (it.hasNext()) {
                aVar.cis.remove((WeakReference) it.next());
            }
            arrayList.clear();
        }
    }

    public final void init() {
        this.cit = true;
        b bVar = this.cir;
        ak.yW();
        bVar.ciG = com.tencent.mm.model.c.vf();
    }

    public final void s(int i, boolean z) {
        a(i, 1, !z ? "0" : "1");
    }

    public final void a(com.tencent.mm.storage.t.a aVar, boolean z) {
        String str = !z ? "0" : "1";
        if (this.cit) {
            b bVar = this.cir;
            v.d("MicroMsg.NewBandageDecoder", "[carl] updateDataSourceValue, dataSourceKey %s, type %d, value %s", aVar, Integer.valueOf(1), str);
            com.tencent.mm.p.b.a e = bVar.e(aVar);
            if (e == null) {
                e = bVar.a(aVar, 1, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                bVar.ciC.put(aVar, e);
                bVar.a(e);
            }
            e.value = str;
            e.type = 1;
            e.bax = bVar.ur();
            bVar.a(e);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(this, aVar, 1, str)));
            return;
        }
        v.w("MicroMsg.NewBandage", "updateDataSource NewBandage has not initialized");
    }

    public final void t(int i, boolean z) {
        a(i, 2, !z ? "0" : "1");
    }

    private void a(int i, int i2, String str) {
        if (this.cit) {
            b bVar = this.cir;
            v.d("MicroMsg.NewBandageDecoder", "[carl] updateDataSourceValue, dataSourceId %d, type %d, value %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            com.tencent.mm.p.b.a ew = bVar.ew(i);
            if (ew == null) {
                ew = bVar.a(i, i2, SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty);
                bVar.ciB.put(i, ew);
                bVar.a(ew);
            }
            ew.value = str;
            ew.type = i2;
            ew.bax = bVar.ur();
            bVar.a(ew);
            this.handler.sendMessage(this.handler.obtainMessage(0, new b(this, i, i2, str)));
            return;
        }
        v.w("MicroMsg.NewBandage", "updateDataSource NewBandage has not initialized");
    }

    public final boolean ax(int i, int i2) {
        if (this.cit) {
            com.tencent.mm.p.b.a p = this.cir.p(i, i2, 1);
            if (p == null || parseInt(p.value) == 0) {
                return false;
            }
            return true;
        }
        v.w("MicroMsg.NewBandage", "hasNew NewBandage has not initialized");
        return false;
    }

    public final boolean a(com.tencent.mm.storage.t.a aVar, com.tencent.mm.storage.t.a aVar2) {
        if (this.cit) {
            com.tencent.mm.p.b.a aVar3;
            b bVar = this.cir;
            v.d("MicroMsg.NewBandageDecoder", "[carl] peek, dataSourceKey %s, watcherKey %s, type %d", aVar, aVar2, Integer.valueOf(1));
            com.tencent.mm.p.b.a e = bVar.e(aVar);
            if (e == null) {
                v.d("MicroMsg.NewBandageDecoder", "[carl] peek, dataSource == null");
                aVar3 = null;
            } else if ((e.type & 1) == 0) {
                v.d("MicroMsg.NewBandageDecoder", "[alex] peek, dataSource.type is wrong");
                aVar3 = null;
            } else {
                com.tencent.mm.p.b.b bVar2;
                String str;
                com.tencent.mm.p.b.b bVar3 = (com.tencent.mm.p.b.b) bVar.ciE.get(aVar2);
                if (bVar3 == null) {
                    bVar3 = bVar.c(aVar2);
                    if (bVar3 == null) {
                        v.e("MicroMsg.NewBandageDecoder", "[carl] loadWatcher watcher == null");
                        bVar2 = null;
                        if (bVar2 == null) {
                            str = (String) bVar2.ciK.get(aVar.name());
                            if (str == null && str.equals(e.bax)) {
                                aVar3 = null;
                            } else {
                                if (str == null) {
                                    bVar2.ciK.put(aVar.name(), bVar.ur());
                                    bVar.a(bVar2);
                                }
                                aVar3 = e;
                            }
                        } else {
                            v.e("MicroMsg.NewBandageDecoder", "[carl] peek, watcher == null");
                            aVar3 = null;
                        }
                    } else {
                        bVar.ciE.put(aVar2, bVar3);
                    }
                }
                bVar2 = bVar3;
                if (bVar2 == null) {
                    v.e("MicroMsg.NewBandageDecoder", "[carl] peek, watcher == null");
                    aVar3 = null;
                } else {
                    str = (String) bVar2.ciK.get(aVar.name());
                    if (str == null) {
                    }
                    if (str == null) {
                        bVar2.ciK.put(aVar.name(), bVar.ur());
                        bVar.a(bVar2);
                    }
                    aVar3 = e;
                }
            }
            if (aVar3 == null) {
                return false;
            }
            if (parseInt(aVar3.value) == 0) {
                return false;
            }
            return true;
        }
        v.w("MicroMsg.NewBandage", "hasNew NewBandage has not initialized");
        return false;
    }

    public final boolean ay(int i, int i2) {
        if (this.cit) {
            com.tencent.mm.p.b.a p = this.cir.p(i, i2, 2);
            if (p == null || parseInt(p.value) == 0) {
                return false;
            }
            return true;
        }
        v.w("MicroMsg.NewBandage", "hasDot NewBandage has not initialized");
        return false;
    }

    public final void az(int i, int i2) {
        if (this.cit) {
            b bVar = this.cir;
            v.d("MicroMsg.NewBandageDecoder", "[carl] doWatch, doWatch %d, watcherId %d", Integer.valueOf(i), Integer.valueOf(i2));
            com.tencent.mm.p.b.a ew = bVar.ew(i);
            if (ew == null) {
                v.d("MicroMsg.NewBandageDecoder", "[carl] doWatch, dataSource == null");
            } else {
                com.tencent.mm.p.b.b ex = bVar.ex(i2);
                if (ex == null) {
                    v.e("MicroMsg.NewBandageDecoder", "[carl] doWatch, watcher == null, do some fix");
                    ex = bVar.ev(i2);
                    bVar.ciD.put(i2, ex);
                }
                ex.ciJ.put(i, ew.bax);
                bVar.a(ex);
            }
            this.handler.sendMessage(this.handler.obtainMessage(1, new c(this, i2, i)));
            return;
        }
        v.w("MicroMsg.NewBandage", "markRead NewBandage has not initialized");
    }

    public final boolean uq() {
        if (this.cit) {
            com.tencent.mm.p.b.a ew = this.cir.ew(262146);
            if (ew == null || parseInt(ew.value) == 0) {
                return false;
            }
            return true;
        }
        v.w("MicroMsg.NewBandage", "queryHasNewSourceValue NewBandage has not initialized");
        return false;
    }

    public static int parseInt(String str) {
        if (be.kS(str)) {
            return 0;
        }
        return be.KL(str);
    }

    public final void a(a aVar) {
        if (this.cit) {
            this.cis.add(new WeakReference(aVar));
        } else {
            v.w("MicroMsg.NewBandage", "addWatch NewBandage has not initialized");
        }
    }

    public final void b(a aVar) {
        if (this.cit) {
            ArrayList arrayList = null;
            for (int i = 0; i < this.cis.size(); i++) {
                WeakReference weakReference = (WeakReference) this.cis.get(i);
                if (weakReference == null || weakReference.get() == null || weakReference.get() == aVar) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(weakReference);
                }
            }
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.cis.remove((WeakReference) it.next());
                }
                arrayList.clear();
                return;
            }
            return;
        }
        v.w("MicroMsg.NewBandage", "removeWatch NewBandage has not initialized");
    }
}
