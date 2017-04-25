package com.tencent.mm.plugin.ext.provider;

import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.bg.d;
import com.tencent.mm.e.a.ij;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelgeo.c;
import com.tencent.mm.protocal.c.afs;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.u.d.a;
import com.tencent.mm.u.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@JgClassChecked(author = 32, fComment = "checked", lastDate = "20141016", reviewer = 20, vComment = {EType.PROVIDERCHECK})
public final class ExtControlProviderNearBy extends ExtContentProviderBase implements a {
    private static final UriMatcher fHK;
    private static boolean fHM = false;
    private static ah fHN = new ah(new ah.a() {
        public final boolean oU() {
            ExtControlProviderNearBy.fHM = false;
            return false;
        }
    }, false);
    private static final String[] tc = new String[]{"nickname", "avatar", "distance", "signature", "sex"};
    private boolean aHw;
    private com.tencent.mm.modelgeo.a.a bYl = new com.tencent.mm.modelgeo.a.a(this) {
        final /* synthetic */ ExtControlProviderNearBy fHO;

        {
            this.fHO = r1;
        }

        public final boolean a(boolean z, float f, float f2, int i, double d, double d2) {
            if (!this.fHO.fHL) {
                this.fHO.fHL = true;
                if (z) {
                    b ijVar = new ij();
                    ijVar.biF.bdf = this.fHO.fHD;
                    ijVar.biF.biH = f;
                    ijVar.biF.bhs = f2;
                    ijVar.biF.biI = (int) d2;
                    ijVar.biF.biJ = i;
                    ijVar.biF.biK = SQLiteDatabase.KeyEmpty;
                    ijVar.biF.biL = SQLiteDatabase.KeyEmpty;
                    if (com.tencent.mm.sdk.c.a.nhr.z(ijVar)) {
                        v.i("MicroMsg.ExtControlProviderNearBy", "do get nearby friend");
                    }
                } else {
                    v.e("MicroMsg.ExtControlProviderNearBy", "get location failed");
                    ExtControlProviderNearBy.f(this.fHO);
                    this.fHO.fHH.countDown();
                }
            }
            return false;
        }
    };
    private c cCR;
    private com.tencent.mm.pluginsdk.d.b ePJ = new com.tencent.mm.pluginsdk.d.b(this) {
        final /* synthetic */ ExtControlProviderNearBy fHO;

        {
            this.fHO = r2;
        }

        public final void a(int i, int i2, String str, b bVar) {
            if ((bVar instanceof ij) && this.fHO.fHH != null) {
                ij ijVar = (ij) bVar;
                v.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend errcode: " + i2 + ", errType: " + i);
                if (i == 0 && i2 == 0) {
                    this.fHO.fHE = ijVar.biG.biN;
                    if (this.fHO.fHE == null || this.fHO.fHE.size() == 0) {
                        v.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend list size:0");
                        this.fHO.fHH.countDown();
                    } else {
                        if (this.fHO.fHE.size() > 10) {
                            v.i("MicroMsg.ExtControlProviderNearBy", "get lbsfriend size > 10," + this.fHO.fHE.size());
                            this.fHO.fHE.subList(10, this.fHO.fHE.size()).clear();
                        }
                        this.fHO.fHI = new CountDownLatch(this.fHO.fHE.size());
                        this.fHO.fHH.countDown();
                        ExtControlProviderNearBy.e(this.fHO);
                    }
                } else {
                    v.e("MicroMsg.ExtControlProviderNearBy", "get lbsfriend failed: errCode = " + i2 + ", errType=" + i);
                    this.fHO.fHH.countDown();
                }
                ExtControlProviderNearBy.f(this.fHO);
            }
        }
    };
    private int fHD;
    private List<afs> fHE;
    private d fHF;
    private Set<String> fHG;
    private CountDownLatch fHH;
    private CountDownLatch fHI;
    private afs fHJ;
    private boolean fHL = false;

    static /* synthetic */ void e(ExtControlProviderNearBy extControlProviderNearBy) {
        n.AX().a((a) extControlProviderNearBy);
        if (extControlProviderNearBy.fHF == null) {
            extControlProviderNearBy.fHF = new d(tc, (byte) 0);
        }
        for (afs a : extControlProviderNearBy.fHE) {
            extControlProviderNearBy.a(a);
        }
        extControlProviderNearBy.fHI.countDown();
    }

    static /* synthetic */ void f(ExtControlProviderNearBy extControlProviderNearBy) {
        boolean z = true;
        v.v("MicroMsg.ExtControlProviderNearBy", "stop()");
        if (ak.uz()) {
            com.tencent.mm.pluginsdk.d.b.b(ij.class.getName(), extControlProviderNearBy.ePJ);
            String str = "MicroMsg.ExtControlProviderNearBy";
            String str2 = "releaseLbsManager(), lbsManager == null ? [%s]";
            Object[] objArr = new Object[1];
            if (extControlProviderNearBy.cCR != null) {
                z = false;
            }
            objArr[0] = Boolean.valueOf(z);
            v.v(str, str2, objArr);
            if (extControlProviderNearBy.cCR != null) {
                extControlProviderNearBy.cCR.c(extControlProviderNearBy.bYl);
                return;
            }
            return;
        }
        v.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
    }

    static {
        UriMatcher uriMatcher = new UriMatcher(-1);
        fHK = uriMatcher;
        uriMatcher.addURI("com.tencent.mm.plugin.ext.NearBy", "male", 1);
        fHK.addURI("com.tencent.mm.plugin.ext.NearBy", "female", 2);
        fHK.addURI("com.tencent.mm.plugin.ext.NearBy", "all", 0);
    }

    private static void cU(boolean z) {
        if (z) {
            fHM = true;
            fHN.ea(15000);
            return;
        }
        fHN.ea(0);
    }

    public final boolean onCreate() {
        return true;
    }

    public final Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        v.i("MicroMsg.ExtControlProviderNearBy", "query() " + uri);
        a(uri, getContext(), 15);
        if (uri == null) {
            kB(3);
            return null;
        } else if (be.kS(this.fHh) || be.kS(akY())) {
            kB(3);
            return null;
        } else if (fHM) {
            v.w("MicroMsg.ExtControlProviderNearBy", "isDoingRequest, return null");
            kB(5);
            return null;
        } else {
            cU(true);
            if (!WN()) {
                cU(false);
                kB(1);
                return this.enz;
            } else if (bG(getContext())) {
                v.i("MicroMsg.ExtControlProviderNearBy", "find type = " + this.fHD);
                getType(uri);
                if (this.fHD < 0) {
                    v.e("MicroMsg.ExtControlProviderNearBy", "unkown uri, return null");
                    cU(false);
                    kB(3);
                    return null;
                }
                try {
                    this.fHE = new ArrayList();
                    this.fHF = new d(tc, (byte) 0);
                    this.fHH = new CountDownLatch(1);
                    this.fHI = null;
                    this.fHG = new HashSet();
                    this.fHE = new ArrayList();
                    this.aHw = false;
                    v.v("MicroMsg.ExtControlProviderNearBy", "start()");
                    if (ak.uz()) {
                        com.tencent.mm.pluginsdk.d.b.a(ij.class.getName(), this.ePJ);
                        ad.o(new Runnable(this) {
                            final /* synthetic */ ExtControlProviderNearBy fHO;

                            {
                                this.fHO = r1;
                            }

                            public final void run() {
                                if (this.fHO.cCR == null) {
                                    this.fHO.cCR = c.FY();
                                }
                                this.fHO.cCR.a(this.fHO.bYl, true);
                            }
                        });
                    } else {
                        v.i("MicroMsg.ExtControlProviderNearBy", "!MMCore.hasSetUin()");
                    }
                    v.i("MicroMsg.ExtControlProviderNearBy", "wait for get lbs info");
                    if (!this.fHH.await(15000, TimeUnit.MILLISECONDS)) {
                        v.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchWait time out");
                    }
                    if (this.fHI != null) {
                        v.i("MicroMsg.ExtControlProviderNearBy", "get lbs info success, wait for get lbs friend");
                        if (!this.fHI.await(15000, TimeUnit.MILLISECONDS)) {
                            v.w("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet time out");
                        }
                    } else {
                        v.i("MicroMsg.ExtControlProviderNearBy", "not init countDownGet. return null");
                    }
                } catch (Throwable e) {
                    v.w("MicroMsg.ExtControlProviderNearBy", e.getMessage());
                    v.a("MicroMsg.ExtControlProviderNearBy", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    kB(4);
                }
                cU(false);
                n.AX().b(this);
                this.aHw = true;
                alc();
                if (this.fHF == null || this.fHF.getCount() <= 0) {
                    kB(4);
                } else {
                    kB(0);
                }
                v.i("MicroMsg.ExtControlProviderNearBy", "return now");
                return this.fHF;
            } else {
                v.w("MicroMsg.ExtControlProviderNearBy", "invalid appid ! return null");
                cU(false);
                kB(2);
                return null;
            }
        }
    }

    private afs sJ(String str) {
        if (str == null || str.length() <= 0) {
            v.e("MicroMsg.ExtControlProviderNearBy", "username is null or nill");
            return null;
        }
        for (afs com_tencent_mm_protocal_c_afs : this.fHE) {
            if (com_tencent_mm_protocal_c_afs.gln.equals(str)) {
                return com_tencent_mm_protocal_c_afs;
            }
        }
        return null;
    }

    private void a(afs com_tencent_mm_protocal_c_afs) {
        if (com_tencent_mm_protocal_c_afs == null || com_tencent_mm_protocal_c_afs.gln == null) {
            v.e("MicroMsg.ExtControlProviderNearBy", "lbsContactInfo is null or lbsContactInfo's userName is null");
            return;
        }
        this.fHG.add(com_tencent_mm_protocal_c_afs.gln);
        Bitmap a = com.tencent.mm.u.b.a(com_tencent_mm_protocal_c_afs.gln, false, -1);
        v.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet now count: " + this.fHI.getCount());
        if (a != null) {
            v.i("MicroMsg.ExtControlProviderNearBy", "countDownLatchGet countDown now");
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[0];
            if (a.compress(CompressFormat.PNG, 100, byteArrayOutputStream)) {
                bArr = byteArrayOutputStream.toByteArray();
            }
            this.fHG.remove(com_tencent_mm_protocal_c_afs.gln);
            this.fHF.addRow(new Object[]{com_tencent_mm_protocal_c_afs.efy, bArr, com_tencent_mm_protocal_c_afs.mFt, com_tencent_mm_protocal_c_afs.cHf, Integer.valueOf(com_tencent_mm_protocal_c_afs.cHc)});
            v.i("MicroMsg.ExtControlProviderNearBy", "bitmap recycle %s", a);
            a.recycle();
        }
    }

    public final void gM(String str) {
        v.i("MicroMsg.ExtControlProviderNearBy", "notifyChanged: " + str);
        if (this.aHw) {
            v.i("MicroMsg.ExtControlProviderNearBy", "has finished");
            return;
        }
        a(sJ(str));
        this.fHI.countDown();
    }

    private void alc() {
        if (this.fHG.size() > 0) {
            for (String str : this.fHG) {
                v.i("MicroMsg.ExtControlProviderNearBy", "add lbsfriend has no avatar: " + str);
                this.fHJ = sJ(str);
                if (!(this.fHJ == null || this.fHJ.gln == null)) {
                    this.fHF.addRow(new Object[]{this.fHJ.efy, null, this.fHJ.mFt, this.fHJ.cHf, Integer.valueOf(this.fHJ.cHc)});
                }
            }
            return;
        }
        v.i("MicroMsg.ExtControlProviderNearBy", "all user has got avatar");
    }

    public final String getType(Uri uri) {
        this.fHD = -1;
        switch (fHK.match(uri)) {
            case 0:
                this.fHD = 1;
                break;
            case 1:
                this.fHD = 3;
                break;
            case 2:
                this.fHD = 4;
                break;
            default:
                this.fHD = -1;
                break;
        }
        return null;
    }

    public final Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public final int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public final int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
