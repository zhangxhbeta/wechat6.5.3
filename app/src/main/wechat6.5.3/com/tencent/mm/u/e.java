package com.tencent.mm.u;

import android.annotation.SuppressLint;
import com.tencent.mm.a.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.network.t;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.InputStream;
import java.io.OutputStream;
import junit.framework.Assert;

public final class e implements com.tencent.mm.v.e {
    h cya = null;
    b cyj = null;
    k cyk = null;
    boolean cyl = false;
    private ap cym = null;

    public interface b {
        int aG(int i, int i2);
    }

    @SuppressLint({"DefaultLocale"})
    class a implements com.tencent.mm.sdk.platformtools.ap.a {
        public h cxW = null;
        public String cyn = null;
        public boolean cyo = true;
        private com.tencent.mm.compatible.util.g.a cyp;
        final /* synthetic */ e cyq;

        public a(e eVar, h hVar) {
            this.cyq = eVar;
            this.cxW = hVar;
            n.AX();
            this.cyn = d.s(hVar.getUsername(), true);
            this.cyp = new com.tencent.mm.compatible.util.g.a();
        }

        public final boolean AZ() {
            Throwable e;
            t tVar;
            Object obj;
            OutputStream outputStream;
            InputStream inputStream = null;
            if (this.cxW == null) {
                return false;
            }
            String Be = this.cxW.Be();
            String str = SQLiteDatabase.KeyEmpty;
            if (ak.uz()) {
                r4 = new Object[4];
                ak.yW();
                r4[1] = o.getString(c.ww());
                r4[2] = Integer.valueOf(com.tencent.mm.sdk.platformtools.ak.getNetTypeForStat(aa.getContext()));
                r4[3] = Integer.valueOf(com.tencent.mm.sdk.platformtools.ak.getStrength(aa.getContext()));
                str = String.format("http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d", r4);
            }
            v.d("MicroMsg.GetHDHeadImgHelper", "dkreferer dkavatar user: %s referer: %s  url:%s", this.cxW.getUsername(), str, Be);
            this.cyo = true;
            try {
                t a = com.tencent.mm.network.b.a(Be, null);
                try {
                    a.setRequestMethod("GET");
                    a.setRequestProperty("referer", str);
                    a.setConnectTimeout(5000);
                    a.setReadTimeout(5000);
                    if (com.tencent.mm.network.b.a(a) != 0) {
                        v.e("MicroMsg.GetHDHeadImgHelper", "checkHttpConnection failed! url:%s", Be);
                        return true;
                    }
                    InputStream inputStream2 = a.getInputStream();
                    if (inputStream2 == null) {
                        try {
                            v.d("MicroMsg.GetHDHeadImgHelper", "getInputStream failed. url:%s", Be);
                            return true;
                        } catch (Exception e2) {
                            e = e2;
                            tVar = a;
                            inputStream = inputStream2;
                            obj = null;
                            v.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", be.e(e));
                            this.cyo = true;
                            if (tVar != null) {
                                try {
                                    tVar.dmc.disconnect();
                                } catch (Throwable e3) {
                                    v.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", be.e(e3));
                                    v.e("MicroMsg.GetHDHeadImgHelper", "close conn failed : %s", e3.getMessage());
                                }
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            return true;
                        }
                    }
                    byte[] bArr = new byte[1024];
                    OutputStream gt = FileOp.gt(this.cyn + ".tmp");
                    while (true) {
                        try {
                            int read = inputStream2.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            gt.write(bArr, 0, read);
                        } catch (Exception e4) {
                            e3 = e4;
                            inputStream = inputStream2;
                            outputStream = gt;
                            tVar = a;
                        }
                    }
                    this.cyo = false;
                    gt.close();
                    a.dmc.disconnect();
                    try {
                        inputStream2.close();
                        outputStream = null;
                        tVar = null;
                    } catch (Exception e5) {
                        e3 = e5;
                        tVar = null;
                        inputStream = inputStream2;
                        obj = null;
                        v.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", be.e(e3));
                        this.cyo = true;
                        if (tVar != null) {
                            tVar.dmc.disconnect();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (outputStream != null) {
                            outputStream.close();
                        }
                        return true;
                    }
                    if (tVar != null) {
                        tVar.dmc.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return true;
                } catch (Exception e6) {
                    e3 = e6;
                    outputStream = null;
                    tVar = a;
                    v.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", be.e(e3));
                    this.cyo = true;
                    if (tVar != null) {
                        tVar.dmc.disconnect();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    return true;
                }
            } catch (Exception e7) {
                e3 = e7;
                outputStream = null;
                tVar = null;
                v.e("MicroMsg.GetHDHeadImgHelper", "exception:%s", be.e(e3));
                this.cyo = true;
                if (tVar != null) {
                    tVar.dmc.disconnect();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                return true;
            }
        }

        public final boolean Ba() {
            if (this.cyq.cyl) {
                return false;
            }
            if (this.cyo || be.kS(this.cyn)) {
                this.cyq.cyj.aG(4, -1);
                return false;
            }
            v.d("MicroMsg.GetHDHeadImgHelper", "dkavatar user:" + this.cxW.getUsername() + " urltime:" + this.cyp.sn());
            if (com.tencent.mm.model.ab.a.csa != null) {
                com.tencent.mm.model.ab.a.csa.aC((int) FileOp.jP(this.cyn + ".tmp"), 0);
            }
            FileOp.deleteFile(this.cyn);
            FileOp.ab(this.cyn + ".tmp", this.cyn);
            k.P(this.cyn, this.cyq.cya.getUsername());
            this.cyq.cyj.aG(0, 0);
            return true;
        }
    }

    public e() {
        ak.vy().a(158, (com.tencent.mm.v.e) this);
    }

    public final void Bb() {
        ak.vy().b(158, (com.tencent.mm.v.e) this);
    }

    public final int a(String str, b bVar) {
        Assert.assertTrue("GetHDHeadImg must set callback", true);
        if (be.kS(str)) {
            bVar.aG(3, -101);
            return -101;
        }
        String LM;
        this.cyj = bVar;
        if (u.ew(str)) {
            LM = u.LM(str);
        } else {
            LM = str;
        }
        this.cya = n.Bo().gQ(LM);
        v.d("MicroMsg.GetHDHeadImgHelper", "GetHDHeadImg: %s", LM);
        if (this.cya == null || !this.cya.getUsername().equals(LM)) {
            this.cya = new h();
            this.cya.username = LM;
        }
        if (be.kS(this.cya.Be())) {
            v.w("MicroMsg.GetHDHeadImgHelper", "dkhurl [%s] has NO URL flag:%d !", str, Integer.valueOf(this.cya.bBY));
            this.cyk = new k(LM);
            if (ak.vy().a(this.cyk, 0)) {
                return 0;
            }
            bVar.aG(3, -102);
            return -102;
        }
        h hVar = this.cya;
        if (this.cym == null || this.cym.btK()) {
            this.cym = new ap(1, "get-hd-headimg", 1);
        }
        if (this.cym.c(new a(this, hVar)) == 0) {
            return 0;
        }
        bVar.aG(3, -103);
        return -103;
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.cyj.aG(i, i2);
    }
}
