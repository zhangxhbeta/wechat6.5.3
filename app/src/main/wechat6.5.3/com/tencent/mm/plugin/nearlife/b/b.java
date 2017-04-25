package com.tencent.mm.plugin.nearlife.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aft;
import com.tencent.mm.protocal.c.afu;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.protocal.c.xb;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.Vector;

public final class b extends k implements j {
    public static Vector<String> hGe = new Vector();
    public int bdf = 0;
    public String bpB = "";
    public final com.tencent.mm.v.b cif;
    private e cii;
    public String hGf = "";
    public String hGg = "";

    public static boolean nA(int i) {
        String valueOf = String.valueOf(i);
        if (hGe.contains(valueOf)) {
            return false;
        }
        hGe.add(valueOf);
        return true;
    }

    public static boolean nB(int i) {
        hGe.remove(String.valueOf(i));
        return true;
    }

    public static void clear() {
        hGe.clear();
    }

    public b(int i, int i2, float f, float f2, int i3, int i4, String str, String str2, are com_tencent_mm_protocal_c_are, String str3, int i5) {
        this.hGf = str3;
        if (!(i == 0 || i == 1)) {
            v.e("MicroMsg.NetSceneGetLbsLifeList", "OpCode Error :" + i);
        }
        this.bdf = i;
        a aVar = new a();
        aVar.czn = new xa();
        aVar.czo = new xb();
        aVar.uri = "/cgi-bin/micromsg-bin/getlbslifelist";
        aVar.czm = 603;
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        xa xaVar = (xa) this.cif.czk.czs;
        afu com_tencent_mm_protocal_c_afu = new afu();
        com_tencent_mm_protocal_c_afu.mrC = str2;
        com_tencent_mm_protocal_c_afu.mrD = i4;
        com_tencent_mm_protocal_c_afu.mjN = f2;
        com_tencent_mm_protocal_c_afu.mjM = f;
        com_tencent_mm_protocal_c_afu.mrB = str;
        com_tencent_mm_protocal_c_afu.mrA = i3;
        xaVar.moG = com_tencent_mm_protocal_c_afu;
        xaVar.muW = str3;
        xaVar.maG = i2;
        xaVar.mzo = i5;
        if (com_tencent_mm_protocal_c_are == null) {
            xaVar.mzn = new are().ba(new byte[0]);
        } else {
            xaVar.mzn = com_tencent_mm_protocal_c_are;
        }
        xaVar.meB = i;
        v.d("MicroMsg.NetSceneGetLbsLifeList", "Req: opcode:" + i + " lon:" + f + " lat:" + f2 + " pre:" + i3 + " gpsSource:" + i4 + " mac" + str + " cell:" + str2 + " scene: " + i2 + " entryTime: " + i5);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final int getType() {
        return 603;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetLbsLifeList", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        xb xbVar = (xb) ((com.tencent.mm.v.b) pVar).czl.czs;
        this.bpB = xbVar.mzu;
        v.d("MicroMsg.NetSceneGetLbsLifeList", "resp " + xbVar.mzr + "searchId " + this.bpB);
        int i4 = (i3 == 0 || i3 == 101) ? 1 : 0;
        if (i2 == 0 || i4 != 0) {
            v.d("MicroMsg.NetSceneGetLbsLifeList", "continueFlag %d lifeCount %d linkCount %d %s", new Object[]{Integer.valueOf(xbVar.miR), Integer.valueOf(xbVar.mzr), Integer.valueOf(xbVar.mzp), xbVar.mzt});
            this.hGg = be.ah(xbVar.mzt, "");
            if (xbVar.mzr > 0) {
                aft com_tencent_mm_protocal_c_aft = (aft) xbVar.mzs.get(0);
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(" Bid " + com_tencent_mm_protocal_c_aft.hHb);
                stringBuffer.append(" title " + com_tencent_mm_protocal_c_aft.aXz);
                stringBuffer.append(" link " + com_tencent_mm_protocal_c_aft.mFI);
                stringBuffer.append(" price " + com_tencent_mm_protocal_c_aft.mFC);
                stringBuffer.append(" rate " + com_tencent_mm_protocal_c_aft.mFH);
                stringBuffer.append(" type " + com_tencent_mm_protocal_c_aft.efm);
                stringBuffer.append(" desc : ");
                Iterator it = com_tencent_mm_protocal_c_aft.mFG.iterator();
                while (it.hasNext()) {
                    stringBuffer.append(((arf) it.next()).mQy + "-");
                }
                v.d("MicroMsg.NetSceneGetLbsLifeList", "resp one %s ", new Object[]{stringBuffer.toString()});
            }
            this.cii.a(i2, i3, str, this);
            return;
        }
        this.cii.a(i2, i3, str, this);
    }

    public final are aDG() {
        are com_tencent_mm_protocal_c_are = ((xb) this.cif.czl.czs).mzn;
        return com_tencent_mm_protocal_c_are == null ? new are().ba(new byte[0]) : com_tencent_mm_protocal_c_are;
    }

    public final int aDH() {
        return ((xb) this.cif.czl.czs).miR;
    }
}
