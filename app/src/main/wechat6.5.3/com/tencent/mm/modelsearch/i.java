package com.tencent.mm.modelsearch;

import android.content.SharedPreferences;
import android.util.Base64;
import com.tencent.mm.model.k;
import com.tencent.mm.model.m;
import com.tencent.mm.protocal.c.ajn;
import com.tencent.mm.protocal.c.ajo;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public final class i {
    public static ajo cVV;

    public static ajo Ik() {
        if (cVV == null) {
            String Il = Il();
            cVV = new ajo();
            Il = aa.getContext().getSharedPreferences("fts_recent_biz_sp", 0).getString(Il, SQLiteDatabase.KeyEmpty);
            if (!be.kS(Il)) {
                try {
                    cVV.az(Base64.decode(Il.getBytes(), 0));
                } catch (IOException e) {
                }
            }
        }
        return cVV;
    }

    private static String Il() {
        return "key_pb_most_search_biz_list" + k.xF();
    }

    public static void jF(String str) {
        if (m.eD(str)) {
            ajn com_tencent_mm_protocal_c_ajn;
            if (cVV == null) {
                Ik();
            }
            long currentTimeMillis = System.currentTimeMillis();
            ajn com_tencent_mm_protocal_c_ajn2 = null;
            int i = 0;
            while (i < cVV.eeu.size()) {
                com_tencent_mm_protocal_c_ajn = (ajn) cVV.eeu.get(i);
                long j = (currentTimeMillis - com_tencent_mm_protocal_c_ajn.mJU) / 86400000;
                com_tencent_mm_protocal_c_ajn.mJT *= Math.pow(0.98d, (double) j);
                com_tencent_mm_protocal_c_ajn.mJU = (j * 86400000) + com_tencent_mm_protocal_c_ajn.mJU;
                v.d("MicroMsg.FTS.FTSMostSearchBizLogic", "after update: %.2f %d %s", Double.valueOf(com_tencent_mm_protocal_c_ajn.mJT), Long.valueOf(com_tencent_mm_protocal_c_ajn.mJU), com_tencent_mm_protocal_c_ajn.mdw);
                if (!com_tencent_mm_protocal_c_ajn.mdw.equals(str)) {
                    com_tencent_mm_protocal_c_ajn = com_tencent_mm_protocal_c_ajn2;
                }
                i++;
                com_tencent_mm_protocal_c_ajn2 = com_tencent_mm_protocal_c_ajn;
            }
            if (com_tencent_mm_protocal_c_ajn2 == null) {
                com_tencent_mm_protocal_c_ajn = new ajn();
                com_tencent_mm_protocal_c_ajn.mJT = 1.0d;
                com_tencent_mm_protocal_c_ajn.mJU = currentTimeMillis;
                com_tencent_mm_protocal_c_ajn.mdw = str;
                cVV.eeu.add(com_tencent_mm_protocal_c_ajn);
                v.i("MicroMsg.FTS.FTSMostSearchBizLogic", "add new use %s", str);
            } else {
                com_tencent_mm_protocal_c_ajn2.mJT += 1.0d;
                v.i("MicroMsg.FTS.FTSMostSearchBizLogic", "update use %s %.2f", str, Double.valueOf(com_tencent_mm_protocal_c_ajn2.mJT));
            }
            Collections.sort(cVV.eeu, new Comparator<ajn>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    ajn com_tencent_mm_protocal_c_ajn = (ajn) obj;
                    ajn com_tencent_mm_protocal_c_ajn2 = (ajn) obj2;
                    if (com_tencent_mm_protocal_c_ajn.mJT > com_tencent_mm_protocal_c_ajn2.mJT) {
                        return 1;
                    }
                    return com_tencent_mm_protocal_c_ajn.mJT < com_tencent_mm_protocal_c_ajn2.mJT ? -1 : 0;
                }
            });
            for (int size = cVV.eeu.size() - 1; size < cVV.eeu.size() && cVV.eeu.size() > 8; size++) {
                if (((ajn) cVV.eeu.get(size)).mJT < 0.5d) {
                    cVV.eeu.remove(size);
                }
            }
            SharedPreferences sharedPreferences = aa.getContext().getSharedPreferences("fts_recent_biz_sp", 0);
            try {
                sharedPreferences.edit().putString(Il(), Base64.encodeToString(cVV.toByteArray(), 0)).commit();
                v.i("MicroMsg.FTS.FTSMostSearchBizLogic", "useBiz pbListString %s", r2);
            } catch (IOException e) {
            }
        }
    }
}
