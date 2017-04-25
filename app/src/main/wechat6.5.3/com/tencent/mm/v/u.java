package com.tencent.mm.v;

import com.tencent.mm.network.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class u {
    public static b cAQ = null;

    public interface a {
        int a(int i, int i2, String str, b bVar, k kVar);
    }

    public interface b {
        n uU();
    }

    static /* synthetic */ int a(boolean z, a aVar, int i, int i2, String str, b bVar, k kVar) {
        if (aVar != null) {
            final a aVar2;
            final int i3;
            final int i4;
            final String str2;
            final b bVar2;
            final k kVar2;
            if (z) {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                kVar2 = kVar;
                cAQ.uU().ckz.x(new Runnable() {
                    public final void run() {
                        aVar2.a(i3, i4, str2, bVar2, kVar2);
                    }

                    public final String toString() {
                        return super.toString() + "|tryCallback";
                    }
                });
            } else {
                aVar2 = aVar;
                i3 = i;
                i4 = i2;
                str2 = str;
                bVar2 = bVar;
                kVar2 = kVar;
                ad.o(new Runnable() {
                    public final void run() {
                        aVar2.a(i3, i4, str2, bVar2, kVar2);
                    }
                });
            }
        }
        return 0;
    }

    public static boolean Cp() {
        if (cAQ == null) {
            v.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            return false;
        } else if (cAQ.uU() != null) {
            return true;
        } else {
            v.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            return false;
        }
    }

    public static b a(b bVar) {
        a(bVar, null, false);
        return bVar;
    }

    public static b a(b bVar, a aVar) {
        a(bVar, aVar, false);
        return bVar;
    }

    public static k a(final b bVar, final a aVar, final boolean z) {
        if (cAQ == null) {
            v.e("MicroMsg.RunCgi", "ERROR: MMCore Not init interface IGetNetSceneQueue.");
            return null;
        } else if (cAQ.uU() == null) {
            v.e("MicroMsg.RunCgi", "ERROR: Get NetscneQueue is null.");
            return null;
        } else if (bVar == null) {
            v.e("MicroMsg.RunCgi", "ERROR: Param CommReqResp is null");
            return null;
        } else {
            k anonymousClass1 = new k() {
                e cAR = null;
                final k cAS = this;
                int cAT = 0;
                ah cAU = new ah(u.cAQ.uU().ckz.htb.getLooper(), new com.tencent.mm.sdk.platformtools.ah.a(this) {
                    final /* synthetic */ AnonymousClass1 cAY;

                    {
                        this.cAY = r1;
                    }

                    public final boolean oU() {
                        v.w("MicroMsg.RunCgi", "Warning: Never should go here. usr canceled:%b Or NetsceneQueue Not call onGYNetEnd! %d func:%d time:%d", Boolean.valueOf(this.cAY.cAS.czH), Integer.valueOf(this.cAY.cAS.hashCode()), Integer.valueOf(this.cAY.getType()), Long.valueOf(be.Ni() - this.cAY.startTime));
                        if (!(this.cAY.cAS.czH || this.cAY.cAT == 1)) {
                            this.cAY.cAT = 2;
                            u.a(z, aVar, 3, -1, SQLiteDatabase.KeyEmpty, bVar, this.cAY.cAS);
                        }
                        return false;
                    }

                    public final String toString() {
                        return super.toString() + "|protectNotCallback";
                    }
                }, false);
                private j czi = new j(this) {
                    final /* synthetic */ AnonymousClass1 cAY;

                    {
                        this.cAY = r1;
                    }

                    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
                        if (this.cAY.cAT != 2) {
                            this.cAY.cAU.QI();
                            this.cAY.cAT = 1;
                            u.a(z, aVar, i2, i3, str, bVar, this.cAY.cAS);
                        } else {
                            v.w("MicroMsg.RunCgi", "Has been callback by protect:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(this.cAY.cAS.hashCode()), Integer.valueOf(this.cAY.getType()), Long.valueOf(be.Ni() - this.cAY.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                        }
                        this.cAY.cAR.a(i2, i3, str, this.cAY.cAS);
                        v.i("MicroMsg.RunCgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(this.cAY.cAS.hashCode()), Integer.valueOf(this.cAY.getType()), Long.valueOf(be.Ni() - this.cAY.startTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                    }
                };
                final long startTime = be.Ni();

                public final int getType() {
                    return bVar.czm;
                }

                public final int a(e eVar, e eVar2) {
                    this.cAR = eVar2;
                    int a = a(eVar, bVar, this.czi);
                    v.i("MicroMsg.RunCgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.cAS.hashCode()), Integer.valueOf(bVar.czm), Integer.valueOf(a), Long.valueOf(be.Ni() - this.startTime));
                    if (aVar != null) {
                        if (a < 0) {
                            u.a(z, aVar, 3, -1, SQLiteDatabase.KeyEmpty, bVar, this.cAS);
                        } else {
                            this.cAU.ea(60000);
                        }
                    }
                    return a;
                }
            };
            if (cAQ.uU().a(anonymousClass1, 0)) {
                return anonymousClass1;
            }
            return null;
        }
    }
}
