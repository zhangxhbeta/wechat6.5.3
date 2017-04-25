package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.zero.a.i;
import com.tencent.mm.protocal.c.kz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class c {
    protected static List<Class<? extends i>> lxq = new ArrayList();
    private a lxr = new a();

    private static class a extends com.tencent.mm.av.a<i> implements i {
        private a() {
        }

        public final void aK(final Object obj) {
            a(new com.tencent.mm.av.a.a<i>(this) {
                final /* synthetic */ a lxt;

                public final /* synthetic */ void an(Object obj) {
                    ((i) obj).aK(obj);
                }
            });
        }

        public final void a(Object obj, int i, int i2, kz kzVar, byte[] bArr, boolean z) {
            final Object obj2 = obj;
            final int i3 = i;
            final int i4 = i2;
            final kz kzVar2 = kzVar;
            final byte[] bArr2 = bArr;
            final boolean z2 = z;
            a(new com.tencent.mm.av.a.a<i>(this) {
                final /* synthetic */ a lxt;

                public final /* synthetic */ void an(Object obj) {
                    ((i) obj).a(obj2, i3, i4, kzVar2, bArr2, z2);
                }
            });
        }

        public final void aL(final Object obj) {
            a(new com.tencent.mm.av.a.a<i>(this) {
                final /* synthetic */ a lxt;

                public final /* synthetic */ void an(Object obj) {
                    ((i) obj).aL(obj);
                }
            });
        }

        public final void aM(final Object obj) {
            a(new com.tencent.mm.av.a.a<i>(this) {
                final /* synthetic */ a lxt;

                public final /* synthetic */ void an(Object obj) {
                    ((i) obj).aM(obj);
                }
            });
        }
    }

    public static synchronized void k(Class<? extends i> cls) {
        synchronized (c.class) {
            if (!lxq.contains(cls)) {
                lxq.add(cls);
            }
        }
    }

    public c() {
        synchronized (c.class) {
            List<Class> arrayList = new ArrayList(lxq);
        }
        for (Class newInstance : arrayList) {
            try {
                this.lxr.ay(newInstance.newInstance());
            } catch (Throwable e) {
                v.a("MicroMsg.SyncDoCmdDelegate", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            } catch (Throwable e2) {
                v.a("MicroMsg.SyncDoCmdDelegate", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
    }

    public final void aK(Object obj) {
        this.lxr.aK(obj);
    }

    public final boolean a(Object obj, int i, int i2, kz kzVar, boolean z) {
        if (g.uz()) {
            long Ni = be.Ni();
            byte[] a = m.a(kzVar.mnB);
            v.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", Long.valueOf(Ni), Integer.valueOf(kzVar.bkM), Integer.valueOf(be.bm(a)), Long.valueOf(Thread.currentThread().getId()));
            if (be.bl(a)) {
                v.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
                return false;
            }
            try {
                this.lxr.a(obj, i, i2, kzVar, a, z);
                v.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", Long.valueOf(Ni), Integer.valueOf(kzVar.bkM), Long.valueOf(be.ay(Ni)));
                return true;
            } catch (Throwable e) {
                v.a("MicroMsg.SyncDoCmdDelegate", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                return false;
            }
        }
        v.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
        return false;
    }

    public final void aL(Object obj) {
        this.lxr.aL(obj);
    }

    public final void aM(Object obj) {
        this.lxr.aM(obj);
    }
}
