package oicq.wlogin_sdk.request;

import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;
import java.lang.reflect.Array;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.ab;
import oicq.wlogin_sdk.a.ac;
import oicq.wlogin_sdk.a.ad;
import oicq.wlogin_sdk.a.af;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.ai;
import oicq.wlogin_sdk.a.ak;
import oicq.wlogin_sdk.a.al;
import oicq.wlogin_sdk.a.am;
import oicq.wlogin_sdk.a.ap;
import oicq.wlogin_sdk.a.e;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.g;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.j;
import oicq.wlogin_sdk.a.l;
import oicq.wlogin_sdk.a.m;
import oicq.wlogin_sdk.a.n;
import oicq.wlogin_sdk.a.o;
import oicq.wlogin_sdk.a.p;
import oicq.wlogin_sdk.a.q;
import oicq.wlogin_sdk.a.s;
import oicq.wlogin_sdk.a.t;
import oicq.wlogin_sdk.a.u;
import oicq.wlogin_sdk.a.v;
import oicq.wlogin_sdk.a.w;
import oicq.wlogin_sdk.a.x;
import oicq.wlogin_sdk.a.z;
import oicq.wlogin_sdk.tools.ErrMsg;
import oicq.wlogin_sdk.tools.util;

public class d {
    protected static int pMP = 0;
    int pMH = 4096;
    int pMI = 0;
    int pMJ = 27;
    int pMK = 0;
    public int pML = 15;
    protected int pMM = 0;
    protected byte[] pMN = new byte[this.pMH];
    protected int pMO = 8001;
    protected int pMQ = 0;
    protected int pMR = 0;
    protected int pMS = 0;
    protected int pMT = 0;
    protected int pMU = 0;
    byte pMV;
    protected i pMW;

    public final void a(int i, int i2, int i3, long j, int i4, int i5, int i6, int i7, byte[] bArr) {
        int length = bArr.length;
        int i8 = pMP + 1;
        pMP = i8;
        this.pMI = 0;
        util.m(this.pMN, this.pMI, 2);
        this.pMI++;
        util.n(this.pMN, this.pMI, (this.pMJ + 2) + length);
        this.pMI += 2;
        util.n(this.pMN, this.pMI, i);
        this.pMI += 2;
        util.n(this.pMN, this.pMI, i2);
        this.pMI += 2;
        util.n(this.pMN, this.pMI, i8);
        this.pMI += 2;
        util.o(this.pMN, this.pMI, (int) j);
        this.pMI += 4;
        util.m(this.pMN, this.pMI, 3);
        this.pMI++;
        util.m(this.pMN, this.pMI, 0);
        this.pMI++;
        util.m(this.pMN, this.pMI, i4);
        this.pMI++;
        util.o(this.pMN, this.pMI, i5);
        this.pMI += 4;
        util.o(this.pMN, this.pMI, i6);
        this.pMI += 4;
        util.o(this.pMN, this.pMI, i7);
        this.pMI += 4;
        if ((this.pMI + length) + 1 > this.pMH) {
            this.pMH = ((this.pMI + length) + 1) + FileUtils.S_IWUSR;
            Object obj = new byte[this.pMH];
            System.arraycopy(this.pMN, 0, obj, 0, this.pMI);
            this.pMN = obj;
        }
        System.arraycopy(bArr, 0, this.pMN, this.pMI, length);
        this.pMI = length + this.pMI;
        util.m(this.pMN, this.pMI, 3);
        this.pMI++;
    }

    public final int F(byte[] bArr, int i) {
        int i2 = 0;
        if (i <= this.pML + 2) {
            return -1009;
        }
        this.pMM = (i - this.pML) - 2;
        if (i > this.pMH) {
            this.pMH = i + FileUtils.S_IWUSR;
            this.pMN = new byte[this.pMH];
        }
        this.pMI = i;
        System.arraycopy(bArr, 0, this.pMN, 0, i);
        int i3 = this.pML + 1;
        Object decrypt = oicq.wlogin_sdk.tools.d.decrypt(this.pMN, i3, this.pMM, this.pMW.pNa);
        if (decrypt == null) {
            i2 = -1002;
        } else {
            this.pMM = decrypt.length;
            if ((decrypt.length + this.pML) + 2 > this.pMH) {
                this.pMH = (decrypt.length + this.pML) + 2;
                Object obj = new byte[this.pMH];
                System.arraycopy(this.pMN, 0, obj, 0, this.pMI);
                this.pMN = obj;
            }
            this.pMI = 0;
            System.arraycopy(decrypt, 0, this.pMN, i3, decrypt.length);
            this.pMI = (decrypt.length + (this.pML + 2)) + this.pMI;
        }
        if (i2 >= 0) {
            return j(this.pMN, this.pML + 1, this.pMM);
        }
        return -1002;
    }

    public final byte[] bQT() {
        Object obj = new byte[this.pMI];
        System.arraycopy(this.pMN, 0, obj, 0, this.pMI);
        return obj;
    }

    final byte[] h(byte[] bArr, int i, int i2) {
        Object obj = new byte[(bArr.length + 4)];
        util.n(obj, 0, i);
        util.n(obj, 2, i2);
        System.arraycopy(bArr, 0, obj, 4, bArr.length);
        obj = oicq.wlogin_sdk.tools.d.b(obj, obj.length, this.pMW.pNa);
        Object obj2 = new byte[(obj.length + this.pMW.pNa.length)];
        System.arraycopy(this.pMW.pNa, 0, obj2, 0, this.pMW.pNa.length);
        System.arraycopy(obj, 0, obj2, this.pMW.pNa.length, obj.length);
        return obj2;
    }

    public final int G(byte[] bArr, int i) {
        this.pMV = bArr[i];
        return bArr[i] & WebView.NORMAL_MODE_ALPHA;
    }

    public final void i(byte[] bArr, int i, int i2) {
        a aiVar = new ai();
        if (aiVar.l(bArr, i, i2) >= 0) {
            ErrMsg errMsg = this.pMW.pNw;
            Object obj = new byte[aiVar.pOl];
            System.arraycopy(aiVar.pMN, aiVar.pNC + 6, obj, 0, aiVar.pOl);
            errMsg.title = new String(obj);
            errMsg = this.pMW.pNw;
            obj = new byte[aiVar.pOm];
            System.arraycopy(aiVar.pMN, (aiVar.pNC + 8) + aiVar.pOl, obj, 0, aiVar.pOm);
            errMsg.aJX = new String(obj);
            errMsg = this.pMW.pNw;
            obj = new byte[aiVar.pOn];
            System.arraycopy(aiVar.pMN, ((aiVar.pNC + 12) + aiVar.pOl) + aiVar.pOm, obj, 0, aiVar.pOn);
            errMsg.pOu = new String(obj);
            return;
        }
        this.pMW.pNw.bRa();
    }

    public final void bQU() {
        this.pMW.pNw.bRa();
    }

    public final byte[] bE(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[(bArr.length + this.pMW.pMY.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(this.pMW.pMY, 0, bArr2, bArr.length, this.pMW.pMY.length);
        return bArr2;
    }

    public final byte[] bF(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            return null;
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        int length = bArr2.length - 16;
        Object obj = new byte[length];
        System.arraycopy(bArr2, 0, obj, 0, length);
        this.pMW.pMY = new byte[16];
        System.arraycopy(bArr2, length, this.pMW.pMY, 0, 16);
        return obj;
    }

    private int a(s sVar) {
        long j = 4294967295L;
        a oVar = new o();
        a pVar = new p();
        a lVar = new l();
        a qVar = new q();
        a eVar = new e();
        a tVar = new t();
        a dVar = new oicq.wlogin_sdk.a.d();
        a mVar = new m();
        a uVar = new u();
        a wVar = new w();
        a xVar = new x();
        a jVar = new j();
        a hVar = new h();
        a nVar = new n();
        a zVar = new z();
        a vVar = new v();
        a adVar = new ad();
        a abVar = new ab();
        a afVar = new af();
        a apVar = new ap();
        a akVar = new ak();
        a alVar = new al();
        a amVar = new am();
        byte[] bArr = null;
        byte[] bArr2 = null;
        byte[] bArr3 = null;
        byte[] bArr4 = null;
        byte[] bArr5 = null;
        byte[] bArr6 = null;
        byte[] bArr7 = null;
        byte[] bArr8 = null;
        a acVar = new ac();
        byte[] bQW = sVar.bQW();
        int length = bQW.length;
        oVar.l(bQW, 2, length);
        pVar.l(bQW, 2, length);
        lVar.l(bQW, 2, length);
        qVar.l(bQW, 2, length);
        int l = tVar.l(bQW, 2, length);
        if (l < 0) {
            return l;
        }
        Object obj;
        long L;
        long j2;
        long j3;
        if (eVar.l(bQW, 2, length) >= 0) {
            bArr6 = eVar.bQW();
        }
        if (jVar.l(bQW, 2, length) >= 0) {
            util.a(this.pMW.pMF, jVar.bQW());
        }
        if (dVar.l(bQW, 2, length) >= 0) {
            bArr = dVar.bQW();
        }
        if (mVar.l(bQW, 2, length) >= 0) {
            bArr2 = mVar.bQW();
        }
        if (uVar.l(bQW, 2, length) >= 0) {
            bArr3 = uVar.bQW();
        }
        if (wVar.l(bQW, 2, length) >= 0) {
            bArr4 = wVar.bQW();
        }
        if (xVar.l(bQW, 2, length) >= 0) {
            bArr5 = xVar.bQW();
        }
        if (zVar.l(bQW, 2, length) >= 0) {
            bArr7 = new byte[zVar.pOb];
            System.arraycopy(zVar.pMN, zVar.pNC + 2, bArr7, 0, bArr7.length);
            bArr8 = new byte[zVar.pOc];
            System.arraycopy(zVar.pMN, ((zVar.pNC + 2) + zVar.pOb) + 2, bArr8, 0, bArr8.length);
        }
        if (alVar.l(bQW, 2, length) >= 0) {
            a hVar2 = new h();
            eVar = new n();
            dVar = new am();
            ah ahVar = new ah();
            byte[] bQW2 = alVar.bQW();
            int length2 = bQW2.length;
            if (hVar2.l(bQW2, 2, length2) < 0) {
                obj = null;
            } else if (eVar.l(bQW2, 2, length2) < 0) {
                obj = null;
            } else if (dVar.l(bQW2, 2, length2) < 0) {
                obj = null;
            } else {
                Object bQT = hVar2.bQT();
                obj = eVar.bQT();
                Object bQT2 = dVar.bQT();
                Object bL = ahVar.bL(this.pMW.pNh);
                Object obj2 = new byte[((((bQT.length + 3) + obj.length) + bQT2.length) + bL.length)];
                obj2[0] = (byte) 64;
                util.n(obj2, 1, 4);
                System.arraycopy(bQT, 0, obj2, 3, bQT.length);
                int length3 = bQT.length + 3;
                System.arraycopy(obj, 0, obj2, length3, obj.length);
                int length4 = obj.length + length3;
                System.arraycopy(bQT2, 0, obj2, length4, bQT2.length);
                System.arraycopy(bL, 0, obj2, length4 + bQT2.length, bL.length);
                obj = obj2;
            }
            if (obj == null || obj.length <= 0) {
                this.pMW.pNz = new byte[0];
            } else {
                this.pMW.pNz = (byte[]) obj.clone();
                util.eo("fast data:", util.bP(obj));
            }
        }
        byte[][] bArr9 = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{7, 0});
        if (acVar.l(bQW, 2, length) >= 0) {
            bArr9[0] = acVar.bQW();
        }
        l = nVar.l(bQW, 2, length);
        if (hVar.l(bQW, 2, length) >= 0 && l >= 0) {
            this.pMW.pMY = nVar.bQW();
            this.pMW.pNx = bE(hVar.bQW());
            bArr9[1] = (byte[]) this.pMW.pNx.clone();
        }
        if (abVar.l(bQW, 2, length) >= 0) {
            obj = new byte[abVar.pOe];
            System.arraycopy(abVar.pMN, abVar.pNC + 2, obj, 0, obj.length);
            bArr9[2] = obj;
        }
        if (afVar.l(bQW, 2, length) >= 0) {
            bArr9[3] = afVar.bQW();
        }
        if (apVar.l(bQW, 2, length) >= 0) {
            bArr9[4] = apVar.bQW();
        }
        if (akVar.l(bQW, 2, length) >= 0) {
            bArr9[5] = akVar.bQW();
        }
        if (amVar.l(bQW, 2, length) >= 0) {
            bArr9[6] = amVar.bQW();
        }
        if (vVar.l(bQW, 2, length) >= 0) {
            if (this.pMW.pNf == -1) {
                L = (long) util.L(vVar.pMN, vVar.pNC);
            } else {
                L = this.pMW.pNf;
            }
            j = 4294967295L & ((long) util.L(vVar.pMN, vVar.pNC + 4));
            j2 = L;
        } else {
            j2 = 3600;
        }
        if (adVar.l(bQW, 2, length) < 0 || adVar.bQZ() == 0) {
            L = 2160000;
        } else {
            L = (long) adVar.bQZ();
        }
        if (L < j2) {
            j3 = j2;
        } else {
            j3 = L;
        }
        i iVar = this.pMW;
        long j4 = this.pMW._uin;
        long j5 = this.pMW.pNd;
        long bQV = i.bQV();
        j2 += i.bQV();
        j3 += i.bQV();
        Object obj3 = new byte[2];
        System.arraycopy(tVar.pMN, tVar.pNC, obj3, 0, 2);
        Object obj4 = new byte[1];
        System.arraycopy(tVar.pMN, tVar.pNC + 2, obj4, 0, 1);
        Object obj5 = new byte[1];
        System.arraycopy(tVar.pMN, (tVar.pNC + 2) + 1, obj5, 0, 1);
        Object obj6 = new byte[tVar.pNZ];
        System.arraycopy(tVar.pMN, (((tVar.pNC + 2) + 1) + 1) + 1, obj6, 0, tVar.pNZ);
        iVar.a(j4, j5, j, bQV, j2, j3, obj3, obj4, obj5, obj6, lVar.bQW(), oVar.bQW(), qVar.bQW(), pVar.bQW(), bArr6, bArr2, bArr, bArr3, bArr4, bArr5, bArr7, bArr8, bArr9);
        return 0;
    }

    public int j(byte[] bArr, int i, int i2) {
        a fVar = new f();
        a gVar = new g();
        a sVar = new s();
        if (this.pMT == 2064 && this.pMU == 9) {
            Object obj = null;
        } else if (this.pMT == 2064 && this.pMU == 10) {
            r2 = 1;
        } else if (this.pMT == 2064 && this.pMU == 2) {
            r2 = 2;
        } else if (this.pMT != 2064 || this.pMU != 13) {
            return -1012;
        } else {
            r2 = 4;
        }
        if (i2 < 5) {
            return -1009;
        }
        int G = G(bArr, i + 2);
        bQU();
        int i3 = i + 5;
        switch (G) {
            case 0:
                if (obj != 1) {
                    G = sVar.b(bArr, i3, (this.pMI - i3) - 1, this.pMW.pMY);
                } else if (this.pMW.pMZ == null) {
                    return -1006;
                } else {
                    G = sVar.b(bArr, i3, (this.pMI - i3) - 1, this.pMW.pMZ);
                }
                if (G < 0) {
                    util.Rc("119 can not decrypt, ret=" + G);
                    return G;
                }
                G = a(sVar);
                if (G >= 0) {
                    return 0;
                }
                util.Rc("parse 119 failed, ret=" + G);
                return G;
            case 1:
                i(bArr, i3, (this.pMI - i3) - 1);
                return G;
            case 2:
                int l = fVar.l(bArr, i3, (this.pMI - i3) - 1);
                if (l >= 0) {
                    this.pMW.pNb = fVar;
                    l = gVar.l(bArr, i3, (this.pMI - i3) - 1);
                    if (l >= 0) {
                        this.pMW.pNc = gVar;
                        return G;
                    }
                }
                return l;
            default:
                i(bArr, i3, (this.pMI - i3) - 1);
                return G;
        }
    }
}
