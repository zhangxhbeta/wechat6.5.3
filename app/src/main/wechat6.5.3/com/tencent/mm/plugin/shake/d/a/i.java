package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.shake.d.b.a;
import com.tencent.mm.protocal.c.ajr;
import com.tencent.mm.protocal.c.auh;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class i {
    public static String aOs() {
        if (ak.uz()) {
            StringBuilder stringBuilder = new StringBuilder();
            ak.yW();
            File file = new File(stringBuilder.append(c.xq()).append("shakemusic/").toString());
            if (!(file.exists() && file.isDirectory())) {
                v.w("MicroMsg.ShakeMusicLogic", "storage dir[%s] not perpare, try to create it", new Object[]{file.getAbsolutePath()});
                file.mkdir();
            }
            File file2 = new File(file, ".nomedia");
            if (!file2.exists()) {
                v.w("MicroMsg.ShakeMusicLogic", "no media file[%s] not exists, try to create it", new Object[]{file.getAbsolutePath()});
                try {
                    file2.createNewFile();
                } catch (Throwable e) {
                    v.a("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
                }
            }
            if (file.exists()) {
                return file.getAbsolutePath() + "/";
            }
            v.w("MicroMsg.ShakeMusicLogic", "create storage dir fail");
            return null;
        }
        v.w("MicroMsg.ShakeMusicLogic", "getSaveDirPath: acc stg has not set uin");
        return null;
    }

    public static ajr a(byte[] bArr, long j) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        try {
            auh com_tencent_mm_protocal_c_auh = (auh) new auh().az(bArr);
            ajr com_tencent_mm_protocal_c_ajr = new ajr();
            com_tencent_mm_protocal_c_ajr.mJV = 4;
            com_tencent_mm_protocal_c_ajr.mJW = String.valueOf(com_tencent_mm_protocal_c_auh.mRR);
            com_tencent_mm_protocal_c_ajr.mJX = com_tencent_mm_protocal_c_auh.mJX;
            com_tencent_mm_protocal_c_ajr.mKa = m.b(com_tencent_mm_protocal_c_auh.mAn);
            com_tencent_mm_protocal_c_ajr.mKb = m.b(com_tencent_mm_protocal_c_auh.mAo);
            com_tencent_mm_protocal_c_ajr.mKg = a.xK(com_tencent_mm_protocal_c_ajr.mKb);
            com_tencent_mm_protocal_c_ajr.mfh = com_tencent_mm_protocal_c_auh.mfh;
            com_tencent_mm_protocal_c_ajr.mKf = m.b(com_tencent_mm_protocal_c_auh.mAm);
            com_tencent_mm_protocal_c_ajr.mJY = m.b(com_tencent_mm_protocal_c_auh.mRS);
            com_tencent_mm_protocal_c_ajr.mJZ = m.b(com_tencent_mm_protocal_c_auh.mRT);
            com_tencent_mm_protocal_c_ajr.mKe = m.b(com_tencent_mm_protocal_c_auh.mRW);
            com_tencent_mm_protocal_c_ajr.mKc = m.b(com_tencent_mm_protocal_c_auh.mRU);
            com_tencent_mm_protocal_c_ajr.mKd = m.b(com_tencent_mm_protocal_c_auh.mRV);
            com_tencent_mm_protocal_c_ajr.jer = j;
            return com_tencent_mm_protocal_c_ajr;
        } catch (Throwable e) {
            v.a("MicroMsg.ShakeMusicLogic", e, "", new Object[0]);
            v.w("MicroMsg.ShakeMusicLogic", "get music wrapper bytes fail");
            return null;
        }
    }
}
