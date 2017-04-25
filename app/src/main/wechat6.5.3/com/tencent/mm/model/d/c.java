package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.al.j;
import com.tencent.mm.al.n;
import com.tencent.mm.al.t;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mm.v.m;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class c implements e {
    private static c cwZ;
    private ArrayList<a> cis = new ArrayList();
    private SharedPreferences cnm = aa.btk();
    private final int cwV = 21;
    private final String cwW = "trace_config_last_update_time";
    private final long cwX = 86400000;
    private volatile boolean cwY = false;

    interface a {
        void Ay();
    }

    private c() {
    }

    public static c AF() {
        if (cwZ == null) {
            synchronized (c.class) {
                if (cwZ == null) {
                    cwZ = new c();
                }
            }
        }
        return cwZ;
    }

    public final void a(int i, int i2, String str, k kVar) {
        int type = kVar.getType();
        v.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(type));
        if (!(kVar instanceof m) || ((m) kVar).BI() != 21) {
            v.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
        } else if (type == 159) {
            if (i == 0 && i2 == 0) {
                com.tencent.mm.al.m[] fU = t.HS().fU(21);
                if (fU == null || fU.length == 0) {
                    v.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
                    release();
                    return;
                }
                com.tencent.mm.al.m mVar = fU[0];
                v.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + mVar.id + " version:" + mVar.version + " status:" + mVar.status + " type:" + mVar.cUv);
                if (5 == mVar.status) {
                    ak.vy().a(new j(mVar.id, 21), 0);
                    return;
                }
                v.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
                this.cnm.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
                release();
                return;
            }
            release();
        } else if (type == 160) {
            if (i == 0 && i2 == 0) {
                fa(((j) kVar).cUo);
            }
            release();
        }
    }

    private void fa(int i) {
        t.HS();
        try {
            Map q = bf.q(com.tencent.mm.a.e.aV(new File(new File(n.HO()), t.HS().aM(i, 21)).getPath()), "TraceConfig");
            if (q == null) {
                v.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
                return;
            }
            int i2;
            String str = ".TraceConfig.Item";
            Map hashMap = new HashMap();
            int i3 = 0;
            while (true) {
                String str2 = str + (i3 == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i3));
                String str3 = (String) q.get(str2 + ".$key");
                if (str3 == null) {
                    break;
                }
                i2 = i3 + 1;
                long j = be.getLong((String) q.get(str2), -1);
                if (j >= 0) {
                    v.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i2 + " key: " + str3 + "|value: " + j);
                    hashMap.put(str3, Long.valueOf(j));
                    i3 = i2;
                } else {
                    i3 = i2;
                }
            }
            Editor edit = this.cnm.edit();
            for (Entry entry : hashMap.entrySet()) {
                edit.putLong((String) entry.getKey(), ((Long) entry.getValue()).longValue());
            }
            edit.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
            v.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + hashMap.size());
            i2 = this.cis.size();
            for (i3 = 0; i3 < i2; i3++) {
                ((a) this.cis.get(i3)).Ay();
            }
            com.tencent.mm.al.m aK = t.HS().aK(i, 21);
            aK.status = 2;
            t.HS().b(aK);
        } catch (Throwable e) {
            v.a("MicroMsg.TraceConfigUpdater", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    private void release() {
        v.i("MicroMsg.TraceConfigUpdater", "summer release");
        this.cwY = false;
        ak.vy().b(159, (e) this);
        ak.vy().b(160, (e) this);
    }

    public final boolean a(a aVar) {
        if (aVar == null || this.cis.contains(aVar)) {
            return false;
        }
        return this.cis.add(aVar);
    }
}
