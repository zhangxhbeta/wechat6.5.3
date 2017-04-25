package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.protocal.c.dy;
import com.tencent.mm.protocal.c.ej;
import com.tencent.mm.protocal.c.ek;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.IOException;
import java.util.LinkedList;

public final class g extends a {
    public String bNv;
    private b cif;
    private dy emC;

    public g(int i, String str, String str2, LinkedList<dx> linkedList, int i2) {
        Throwable e;
        int i3;
        String str3;
        String str4;
        Object[] objArr;
        a aVar = new a();
        aVar.czn = new ej();
        aVar.czo = new ek();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatuploadmsg";
        this.cif = aVar.Bv();
        this.emC = new dy();
        this.emC.eeu = linkedList;
        this.emC.eet = linkedList.size();
        ej ejVar = (ej) this.cif.czk.czs;
        ejVar.mfa = i;
        byte[] bArr = null;
        int i4 = 0;
        int length = com.tencent.mm.plugin.backup.g.b.Vl() == null ? -1 : com.tencent.mm.plugin.backup.g.b.Vl().length;
        if (length <= 0) {
            try {
                ejVar.mfp = this.emC;
            } catch (IOException e2) {
                e = e2;
                v.a("MicroMsg.NetSceneBakChatUploadMsg", e, "dkbak %s", SQLiteDatabase.KeyEmpty);
                ejVar.mfp = this.emC;
                ejVar.meZ = str;
                ejVar.mcN = str2;
                i3 = 0;
                i3 = this.emC.toByteArray().length;
                ejVar.mdB = i3;
                this.emo = i2;
                this.cyu = i2;
                this.emn = i;
                this.ehp = str;
                this.bNv = str2;
                str3 = "MicroMsg.NetSceneBakChatUploadMsg";
                str4 = "dkbak buf[%d,%d] pass:%d backList:%d data:%d dataBuf:%d datalen:%d bakPacketSize:%d cliid:%s svrid:%d bakcliid:%s ";
                objArr = new Object[11];
                objArr[0] = Integer.valueOf(i4);
                objArr[1] = Integer.valueOf(bArr == null ? bArr.length : -1);
                objArr[2] = Integer.valueOf(length);
                objArr[3] = Integer.valueOf(this.emC.eet);
                objArr[4] = Integer.valueOf(ejVar.mfp.eet);
                if (ejVar.mfq == null) {
                    length = ejVar.mfq.mQu;
                } else {
                    length = -1;
                }
                objArr[5] = Integer.valueOf(length);
                objArr[6] = Integer.valueOf(ejVar.mdB);
                objArr[7] = Integer.valueOf(this.emo);
                objArr[8] = ejVar.mcN;
                objArr[9] = Integer.valueOf(ejVar.mfa);
                objArr[10] = ejVar.meZ;
                v.i(str3, str4, objArr);
            }
        }
        byte[] toByteArray = this.emC.toByteArray();
        i4 = toByteArray == null ? -1 : toByteArray.length;
        try {
            bArr = AesEcb.aesCryptEcb(toByteArray, com.tencent.mm.plugin.backup.g.b.Vl(), true, true);
            if (bArr != null) {
                if (bArr.length % 2 > 0) {
                    str4 = "MicroMsg.NetSceneBakChatUploadMsg";
                    String str5 = "dkbak ERR aesCryptEcb Buf Size Wrong.buf[%d,%d] pass:%d";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = Integer.valueOf(i4);
                    objArr2[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
                    objArr2[2] = Integer.valueOf(length);
                    v.e(str4, str5, objArr2);
                    ejVar.mfp = this.emC;
                }
            }
            ejVar.mfq = new are().ba(bArr);
            LinkedList linkedList2 = new LinkedList();
            dy dyVar = new dy();
            dyVar.eeu = linkedList2;
            dyVar.eet = 0;
            ejVar.mfp = dyVar;
        } catch (Throwable e3) {
            Throwable th = e3;
            bArr = toByteArray;
            e = th;
            v.a("MicroMsg.NetSceneBakChatUploadMsg", e, "dkbak %s", SQLiteDatabase.KeyEmpty);
            ejVar.mfp = this.emC;
            ejVar.meZ = str;
            ejVar.mcN = str2;
            i3 = 0;
            i3 = this.emC.toByteArray().length;
            ejVar.mdB = i3;
            this.emo = i2;
            this.cyu = i2;
            this.emn = i;
            this.ehp = str;
            this.bNv = str2;
            str3 = "MicroMsg.NetSceneBakChatUploadMsg";
            str4 = "dkbak buf[%d,%d] pass:%d backList:%d data:%d dataBuf:%d datalen:%d bakPacketSize:%d cliid:%s svrid:%d bakcliid:%s ";
            objArr = new Object[11];
            objArr[0] = Integer.valueOf(i4);
            if (bArr == null) {
            }
            objArr[1] = Integer.valueOf(bArr == null ? bArr.length : -1);
            objArr[2] = Integer.valueOf(length);
            objArr[3] = Integer.valueOf(this.emC.eet);
            objArr[4] = Integer.valueOf(ejVar.mfp.eet);
            if (ejVar.mfq == null) {
                length = -1;
            } else {
                length = ejVar.mfq.mQu;
            }
            objArr[5] = Integer.valueOf(length);
            objArr[6] = Integer.valueOf(ejVar.mdB);
            objArr[7] = Integer.valueOf(this.emo);
            objArr[8] = ejVar.mcN;
            objArr[9] = Integer.valueOf(ejVar.mfa);
            objArr[10] = ejVar.meZ;
            v.i(str3, str4, objArr);
        }
        ejVar.meZ = str;
        ejVar.mcN = str2;
        i3 = 0;
        try {
            i3 = this.emC.toByteArray().length;
        } catch (Throwable e4) {
            v.a("MicroMsg.NetSceneBakChatUploadMsg", e4, "dkbak toByteArray %s", SQLiteDatabase.KeyEmpty);
        }
        ejVar.mdB = i3;
        this.emo = i2;
        this.cyu = i2;
        this.emn = i;
        this.ehp = str;
        this.bNv = str2;
        str3 = "MicroMsg.NetSceneBakChatUploadMsg";
        str4 = "dkbak buf[%d,%d] pass:%d backList:%d data:%d dataBuf:%d datalen:%d bakPacketSize:%d cliid:%s svrid:%d bakcliid:%s ";
        objArr = new Object[11];
        objArr[0] = Integer.valueOf(i4);
        if (bArr == null) {
        }
        objArr[1] = Integer.valueOf(bArr == null ? bArr.length : -1);
        objArr[2] = Integer.valueOf(length);
        objArr[3] = Integer.valueOf(this.emC.eet);
        objArr[4] = Integer.valueOf(ejVar.mfp.eet);
        if (ejVar.mfq == null) {
            length = -1;
        } else {
            length = ejVar.mfq.mQu;
        }
        objArr[5] = Integer.valueOf(length);
        objArr[6] = Integer.valueOf(ejVar.mdB);
        objArr[7] = Integer.valueOf(this.emo);
        objArr[8] = ejVar.mcN;
        objArr[9] = Integer.valueOf(ejVar.mfa);
        objArr[10] = ejVar.meZ;
        v.i(str3, str4, objArr);
    }

    public final p BD() {
        return this.cif;
    }

    public final int getType() {
        return 323;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneBakChatUploadMsg", "dkbak onGYNetEnd [%d,%d,%s] clientid:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.bNv);
        if (i2 == 0 && i3 == 0) {
            this.cii.a(i2, i3, str, this);
        } else {
            this.cii.a(i2, i3, str, this);
        }
    }
}
