package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.ba.a;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.exdevice.e.f;
import com.tencent.mm.plugin.exdevice.e.g;
import com.tencent.mm.plugin.exdevice.e.j;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.z;
import java.util.zip.CRC32;

public final class e extends d {
    public e(long j, int i, int i2, byte[] bArr) {
        super(j, i, i2, bArr);
        v.i("MicroMsg.exdevice.ExDeviceCmdInit", "onDeviceRequest deviceId = " + j + " seq = " + i + " cmdId = " + i2);
    }

    protected final a ai(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            v.e("MicroMsg.exdevice.ExDeviceCmdInit", "data is null");
            return null;
        }
        a fVar = new f();
        try {
            fVar.az(bArr);
            v.i("MicroMsg.exdevice.ExDeviceCmdInit", "------Init Request parse is ok------ ");
            this.frf = fVar;
            return fVar;
        } catch (Throwable e) {
            v.e("MicroMsg.exdevice.ExDeviceCmdInit", "pase error : " + e.getMessage());
            v.a("MicroMsg.exdevice.ExDeviceCmdInit", e, "", new Object[0]);
            return null;
        }
    }

    public final void a(int i, String str, byte[] bArr, byte[] bArr2, int i2, int i3) {
        int[] iArr;
        int i4;
        v.i("MicroMsg.exdevice.ExDeviceCmdInit", "------initResponse------ errorCode = %d, errMsg = %s, filter = %s, challenge = %s, initScene = %d, second = %d", new Object[]{Integer.valueOf(i), str, b.ak(bArr), b.ak(bArr2), Integer.valueOf(i2), Integer.valueOf(i3)});
        j gVar = new g();
        gVar.fvT = F(0, "ok");
        String xF = k.xF();
        if (be.kS(xF)) {
            iArr = null;
        } else {
            long j;
            String toLowerCase = z.Kg(xF).toLowerCase();
            v.i("MicroMsg.exdevice.Util", "user md5 : [%s]", new Object[]{toLowerCase});
            if (be.kS(toLowerCase)) {
                v.e("MicroMsg.exdevice.Util", "get hash code failed, value is null or nill");
                j = 0;
            } else {
                i4 = 0;
                char[] toCharArray = toLowerCase.toCharArray();
                if (toCharArray.length > 0) {
                    for (char c : toCharArray) {
                        i4 = (i4 * 31) + c;
                    }
                }
                v.i("MicroMsg.exdevice.Util", "get int hashcode value = %d, long hashcode = %d", new Object[]{Integer.valueOf(i4), Long.valueOf(((long) i4) & 4294967295L)});
                j = r4;
            }
            iArr = new int[]{(int) ((j >> 32) & 4294967295L), (int) (j & 4294967295L)};
        }
        gVar.fvG = iArr[0];
        gVar.fvH = iArr[1];
        if (!be.bl(bArr2)) {
            if (bArr2 == null || bArr2.length == 0) {
                i4 = 0;
            } else {
                CRC32 crc32 = new CRC32();
                crc32.update(bArr2);
                i4 = (int) crc32.getValue();
            }
            gVar.fvI = i4;
        }
        if (!be.bl(bArr)) {
            if ((bArr[0] & 4) != 0) {
                gVar.eeB = d.lWb;
            }
            if ((bArr[0] & 8) != 0) {
                gVar.fvN = d.lWe;
            }
            if ((bArr[0] & 2) != 0) {
                gVar.fvM = 2;
            }
            if ((bArr[0] & 16) != 0) {
                gVar.fvO = (int) be.Nh();
            }
            if ((bArr[0] & 32) != 0) {
                gVar.fvP = b.akJ();
            }
            if ((bArr[0] & 64) != 0) {
                gVar.fvQ = b.akG();
            }
            if ((bArr[0] & 1) != 0) {
                gVar.fvL = k.xH();
            }
        }
        gVar.fvJ = i2;
        gVar.fvK = i3;
        this.fre = gVar;
        this.frc = (short) 20003;
    }
}
