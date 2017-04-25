package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.protocal.c.azr;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;

public final class as implements f {
    private static HashMap<String, b> jnA = new HashMap();
    private static HashMap<String, WeakReference<b>> jnB = new HashMap();

    class a {
        long jnC = -1;
        final /* synthetic */ as jnD;
        String mediaId;

        a(as asVar) {
            this.jnD = asVar;
        }
    }

    class b {
        long endTime = -1;
        boolean gzT = false;
        long jnC = -1;
        final /* synthetic */ as jnD;
        long jnE = -1;
        int jnF = 0;
        int jnG = 0;
        HashMap<String, a> jnH = new HashMap();
        long startTime = -1;

        b(as asVar) {
            this.jnD = asVar;
        }
    }

    public static void AC(String str) {
        if (q.dqK) {
            v.d("MicroMsg.TimelineSmallPicStat", "recordStartLoadSmallPic, mediaId:%s", new Object[]{str});
        }
        WeakReference weakReference = (WeakReference) jnB.get(str);
        if (weakReference != null) {
            b bVar = (b) weakReference.get();
            if (bVar != null) {
                bVar.gzT = true;
            }
        }
    }

    public static void AD(String str) {
        if (q.dqK) {
            v.d("MicroMsg.TimelineSmallPicStat", "recordEndLoadSmallPic, mediaId:%s", new Object[]{str});
        }
        WeakReference weakReference = (WeakReference) jnB.get(str);
        if (weakReference != null) {
            b bVar = (b) weakReference.get();
            if (bVar != null && bVar != null && bVar.jnC == -1) {
                HashMap hashMap = bVar.jnH;
                if (hashMap != null && hashMap.containsKey(str)) {
                    a aVar = (a) hashMap.get(str);
                    if (aVar != null && aVar.jnC == -1) {
                        aVar.jnC = 1;
                        bVar.jnG++;
                    }
                }
            }
        }
    }

    public static void AE(String str) {
        v.d("MicroMsg.TimelineSmallPicStat", "recordClickBigpic, localId:%s", new Object[]{str});
        if (jnA.containsKey(str)) {
            v.d("MicroMsg.TimelineSmallPicStat", "recordClickBigPic, localId:%s, update map", new Object[]{str});
            b bVar = (b) jnA.get(str);
            if (bVar != null && bVar.jnC == -1 && bVar.startTime != -1) {
                bVar.jnC = 1;
                bVar.jnG = bVar.jnF;
                bVar.endTime = System.currentTimeMillis();
                bVar.jnE = bVar.endTime - bVar.startTime;
                for (a aVar : bVar.jnH.values()) {
                    aVar.jnC = 1;
                }
            }
        }
    }

    public final void a(String str, azr com_tencent_mm_protocal_c_azr) {
        if (!jnA.containsKey(str)) {
            if (q.dqK) {
                v.d("MicroMsg.TimelineSmallPicStat", "put localId:%s into reportData", new Object[]{str});
            }
            if (com_tencent_mm_protocal_c_azr != null && com_tencent_mm_protocal_c_azr.mWq != null && com_tencent_mm_protocal_c_azr.mWq.mol == 1 && com_tencent_mm_protocal_c_azr.mWq.mom != null && com_tencent_mm_protocal_c_azr.mWq.mom.size() > 0) {
                b bVar = new b(this);
                bVar.jnF = com_tencent_mm_protocal_c_azr.mWq.mom.size();
                bVar.jnG = 0;
                bVar.jnH = new HashMap();
                Iterator it = com_tencent_mm_protocal_c_azr.mWq.mom.iterator();
                while (it.hasNext()) {
                    aib com_tencent_mm_protocal_c_aib = (aib) it.next();
                    a aVar = new a(this);
                    aVar.mediaId = com_tencent_mm_protocal_c_aib.gID;
                    bVar.jnH.put(com_tencent_mm_protocal_c_aib.gID, aVar);
                    jnB.put(com_tencent_mm_protocal_c_aib.gID, new WeakReference(bVar));
                }
                bVar.startTime = System.currentTimeMillis();
                jnA.put(str, bVar);
            } else if (q.dqK) {
                v.d("MicroMsg.TimelineSmallPicStat", "onItemAdd error, timelineObject is nulli");
            }
        }
    }

    public final void Ah(String str) {
        if (jnA.containsKey(str)) {
            if (q.dqK) {
                v.d("MicroMsg.TimelineSmallPicStat", "load finish localId:%s", new Object[]{str});
            }
            b bVar = (b) jnA.get(str);
            if (bVar != null && bVar.startTime != -1 && bVar.jnC == -1) {
                bVar.endTime = System.currentTimeMillis();
                bVar.jnE = bVar.endTime - bVar.startTime;
                if (bVar.jnG == bVar.jnF) {
                    bVar.jnC = 1;
                } else {
                    bVar.jnC = 2;
                }
            }
        }
    }

    public final void aRQ() {
        v.d("MicroMsg.TimelineSmallPicStat", "reportAll, reportData.size:%d", new Object[]{Integer.valueOf(jnA.size())});
        int aRb = i.aRb();
        for (String str : jnA.keySet()) {
            b bVar = (b) jnA.get(str);
            if (bVar != null && bVar.gzT) {
                if (bVar.jnE == -1 || bVar.jnC == -1 || bVar.startTime == -1) {
                    if (bVar.startTime != -1) {
                        bVar.endTime = System.currentTimeMillis();
                        bVar.jnE = bVar.endTime - bVar.startTime;
                        if (bVar.jnF == bVar.jnG) {
                            bVar.jnC = 1;
                        } else {
                            bVar.jnC = 2;
                        }
                    }
                }
                v.d("MicroMsg.TimelineSmallPicStat", "reportAll, picNum:%d, loadResult:%d, loadCostTime:%d, loadPicNum:%d, networkType:%d", new Object[]{Integer.valueOf(bVar.jnF), Long.valueOf(bVar.jnC), Long.valueOf(bVar.jnE), Integer.valueOf(bVar.jnG), Integer.valueOf(aRb)});
                g.iuh.h(11600, new Object[]{Integer.valueOf(bVar.jnF), Long.valueOf(bVar.jnC), Long.valueOf(bVar.jnE), Integer.valueOf(bVar.jnG), Integer.valueOf(aRb)});
            }
        }
        jnA.clear();
        jnB.clear();
    }
}
