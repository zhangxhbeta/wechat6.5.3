package oicq.wlogin_sdk.request;

import com.tencent.mmdb.FileUtils;
import oicq.wlogin_sdk.a.a;
import oicq.wlogin_sdk.a.aa;
import oicq.wlogin_sdk.a.ae;
import oicq.wlogin_sdk.a.ag;
import oicq.wlogin_sdk.a.ah;
import oicq.wlogin_sdk.a.aj;
import oicq.wlogin_sdk.a.an;
import oicq.wlogin_sdk.a.b;
import oicq.wlogin_sdk.a.c;
import oicq.wlogin_sdk.a.f;
import oicq.wlogin_sdk.a.h;
import oicq.wlogin_sdk.a.i;
import oicq.wlogin_sdk.a.k;
import oicq.wlogin_sdk.a.r;
import oicq.wlogin_sdk.a.y;
import oicq.wlogin_sdk.tools.util;

public final class j extends d {
    public j(i iVar) {
        this.pMT = 2064;
        this.pMU = 9;
        this.pMW = iVar;
    }

    public final byte[] a(long j, long j2, byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2, int i3, byte[] bArr4) {
        Object bH;
        int i4 = this.pMW.pNg;
        this.pMW._uin = j2;
        util.eo("IMEI", util.bP(this.pMW.pNh));
        byte[] bArr5 = this.pMW.pMY;
        byte[] bArr6 = this.pMW.pNh;
        byte[] bQW = this.pMW.pNb.bQW();
        byte[] bArr7 = this.pMW.pNl;
        an anVar = new an();
        b bVar = new b();
        a hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object a = anVar.a(522017402, i4, j2, 0);
        Object f = bVar.f(j2, bArr);
        Object a2 = hVar.a(522017402, i4, j2, bArr2, bArr, bArr3, bArr5, this.pMW.pNt, this.pMW.pNh);
        this.pMW.pNx = super.bE(hVar.bQW());
        Object a3 = cVar.a(522017402, 1, i4, 8256);
        Object t = iVar.t(0, 1, 102400, 1);
        Object a4 = rVar.a(i, i2, null);
        Object bL = ahVar.bL(this.pMW.pNh);
        int i5 = 7;
        Object obj = new byte[0];
        byte[] bArr8 = new byte[0];
        Object obj2 = new byte[0];
        Object obj3 = new byte[0];
        if (bArr4.length > 0) {
            obj = jVar.bI(bArr4);
            i5 = 8;
        }
        if (bArr6.length > 0) {
            bArr8 = kVar.bJ(bArr6);
        }
        Object a5 = agVar.a(bArr8, yVar.a(util.bRb(), util.bRc(), this.pMW.pNk, this.pMW.pNj, new byte[0], this.pMW.pNm), aaVar.a(this.pMW.pNs, this.pMW.pNt, this.pMW.pNu, this.pMW.pNq, this.pMW.pNh), ajVar.a(522017402, this.pMW.pNo, this.pMW.pNp), this.pMW.pMY);
        i5++;
        Object bK = aeVar.bK(bArr7);
        int i6 = i5 + 1;
        if (bQW.length > 0) {
            bH = fVar.bH(bQW);
            i6++;
        } else {
            bH = obj2;
        }
        Object obj4 = new byte[(((((((((((a.length + f.length) + a2.length) + a4.length) + a3.length) + t.length) + obj.length) + a5.length) + bH.length) + bK.length) + 0) + bL.length)];
        System.arraycopy(a, 0, obj4, 0, a.length);
        int length = a.length + 0;
        System.arraycopy(f, 0, obj4, length, f.length);
        length += f.length;
        System.arraycopy(a2, 0, obj4, length, a2.length);
        length += a2.length;
        System.arraycopy(a4, 0, obj4, length, a4.length);
        length += a4.length;
        System.arraycopy(a3, 0, obj4, length, a3.length);
        length += a3.length;
        System.arraycopy(t, 0, obj4, length, t.length);
        length += t.length;
        System.arraycopy(obj, 0, obj4, length, obj.length);
        int length2 = obj.length + length;
        System.arraycopy(a5, 0, obj4, length2, a5.length);
        length2 += a5.length;
        System.arraycopy(bK, 0, obj4, length2, bK.length);
        length2 += bK.length;
        System.arraycopy(obj3, 0, obj4, length2, 0);
        length2 += 0;
        System.arraycopy(bH, 0, obj4, length2, bH.length);
        System.arraycopy(bL, 0, obj4, bH.length + length2, bL.length);
        long j3 = j2;
        int i7 = i4;
        a(this.pMO, this.pMT, pMP, j3, this.pMQ, this.pMR, i7, this.pMS, super.h(obj4, this.pMU, i6));
        return super.bQT();
    }

    public final byte[] a(long j, long j2, byte[] bArr, byte[] bArr2, int i, int i2, int i3, byte[] bArr3) {
        int i4 = this.pMW.pNg;
        this.pMW._uin = j2;
        Object bF = super.bF(bArr2);
        if (bF == null) {
            return null;
        }
        Object obj;
        byte[] bArr4 = this.pMW.pNh;
        byte[] bQW = this.pMW.pNb.bQW();
        byte[] bArr5 = this.pMW.pNl;
        an anVar = new an();
        b bVar = new b();
        a hVar = new h();
        r rVar = new r();
        c cVar = new c();
        i iVar = new i();
        oicq.wlogin_sdk.a.j jVar = new oicq.wlogin_sdk.a.j();
        k kVar = new k();
        f fVar = new f();
        y yVar = new y();
        aa aaVar = new aa();
        ae aeVar = new ae();
        ag agVar = new ag();
        ah ahVar = new ah();
        aj ajVar = new aj();
        Object a = anVar.a(522017402, i4, j2, 0);
        Object f = bVar.f(j2, bArr);
        this.pMW.pNx = super.bE(bF);
        int length = bF.length;
        if (hVar.pNC + length > hVar.pMH) {
            hVar.pMH = (hVar.pNC + length) + FileUtils.S_IWUSR;
            obj = new byte[hVar.pMH];
            System.arraycopy(hVar.pMN, 0, obj, 0, hVar.pNC);
            hVar.pMN = obj;
        }
        hVar.pMI = hVar.pNC + length;
        System.arraycopy(bF, 0, hVar.pMN, hVar.pNC, length);
        hVar.pND = length;
        util.n(hVar.pMN, 0, hVar.pMT);
        util.n(hVar.pMN, 2, hVar.pND);
        Object bQT = hVar.bQT();
        util.eo("req2 a1:", util.bP(bQT));
        Object a2 = cVar.a(522017402, 1, i4, 8256);
        Object t = iVar.t(0, 1, 102400, 1);
        Object a3 = rVar.a(i, i2, null);
        Object bL = ahVar.bL(this.pMW.pNh);
        int i5 = 7;
        Object obj2 = new byte[0];
        byte[] bArr6 = new byte[0];
        Object obj3 = new byte[0];
        Object obj4 = new byte[0];
        if (bArr3.length > 0) {
            obj2 = jVar.bI(bArr3);
            i5 = 8;
        }
        if (bArr4.length > 0) {
            bArr6 = kVar.bJ(bArr4);
        }
        Object a4 = agVar.a(bArr6, yVar.a(util.bRb(), util.bRc(), this.pMW.pNk, this.pMW.pNj, new byte[0], this.pMW.pNm), aaVar.a(this.pMW.pNs, this.pMW.pNt, this.pMW.pNu, this.pMW.pNq, this.pMW.pNh), ajVar.a(522017402, this.pMW.pNo, this.pMW.pNp), this.pMW.pMY);
        i5++;
        Object bK = aeVar.bK(bArr5);
        int i6 = i5 + 1;
        if (bQW.length > 0) {
            obj = fVar.bH(bQW);
            i6++;
        } else {
            obj = obj3;
        }
        Object obj5 = new byte[(((((((((((a.length + f.length) + bQT.length) + a3.length) + a2.length) + t.length) + obj2.length) + a4.length) + obj.length) + bK.length) + 0) + bL.length)];
        System.arraycopy(a, 0, obj5, 0, a.length);
        int length2 = a.length + 0;
        System.arraycopy(f, 0, obj5, length2, f.length);
        length2 += f.length;
        System.arraycopy(bQT, 0, obj5, length2, bQT.length);
        length2 += bQT.length;
        System.arraycopy(a3, 0, obj5, length2, a3.length);
        length2 += a3.length;
        System.arraycopy(a2, 0, obj5, length2, a2.length);
        length2 += a2.length;
        System.arraycopy(t, 0, obj5, length2, t.length);
        length2 += t.length;
        System.arraycopy(obj2, 0, obj5, length2, obj2.length);
        length = obj2.length + length2;
        System.arraycopy(a4, 0, obj5, length, a4.length);
        length += a4.length;
        System.arraycopy(bK, 0, obj5, length, bK.length);
        length += bK.length;
        System.arraycopy(obj4, 0, obj5, length, 0);
        length += 0;
        System.arraycopy(obj, 0, obj5, length, obj.length);
        System.arraycopy(bL, 0, obj5, length + obj.length, bL.length);
        long j3 = j2;
        int i7 = i4;
        a(this.pMO, this.pMT, pMP, j3, this.pMQ, this.pMR, i7, this.pMS, super.h(obj5, this.pMU, i6));
        return super.bQT();
    }
}
