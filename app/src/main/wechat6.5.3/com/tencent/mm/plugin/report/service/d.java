package com.tencent.mm.plugin.report.service;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class d {
    public static void a(long j, String str, boolean z, boolean z2) {
        if (z2) {
            try {
                SmcLogic.writeImportKvData(j, str, z);
                return;
            } catch (Throwable e) {
                v.e("MicroMsg.KVEasyReport", "localReport :%s", be.e(e));
                return;
            }
        }
        SmcLogic.writeKvData(j, str, z);
    }

    public static void a(long j, byte[] bArr, boolean z, boolean z2) {
        if (z2) {
            try {
                SmcLogic.writeImportKvPbData(j, bArr, z);
                return;
            } catch (Throwable e) {
                v.e("MicroMsg.KVEasyReport", "localReport :%s", be.e(e));
                return;
            }
        }
        SmcLogic.writeKvPbData(j, bArr, z);
    }

    public static void b(long j, long j2, long j3, boolean z) {
        SmcLogic.reportIDKey(j, j2, j3, z);
    }

    public static void b(ArrayList<IDKey> arrayList, boolean z) {
        if (arrayList != null) {
            SmcLogic.reportListIDKey((IDKey[]) arrayList.toArray(new IDKey[arrayList.size()]), z);
        }
    }
}
