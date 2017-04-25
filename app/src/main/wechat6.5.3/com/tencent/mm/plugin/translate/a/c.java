package com.tencent.mm.plugin.translate.a;

import android.util.SparseArray;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.m;
import com.tencent.mm.protocal.c.bae;
import com.tencent.mm.protocal.c.baf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

public final class c implements a {
    public ArrayList<a> cis;
    public int knN;
    public final d[] knO;
    public Queue<c> knP;
    public HashMap<String, Integer> knQ;

    public interface a {
        void a(int i, SparseArray<c> sparseArray);
    }

    private static final class b {
        public static final c knR = new c();
    }

    public static class c {
        private static int knU = 0;
        public String aHM;
        public String bpg;
        public String bqH;
        public String bqN;
        public String id;
        public int knS;
        public String knT;
        public int ret;
        public int type;

        public c(String str, String str2, int i, String str3) {
            this.bqH = str;
            this.id = str2;
            this.type = i;
            this.aHM = str3;
            if (knU == Integer.MAX_VALUE) {
                knU = 0;
            }
            int i2 = knU + 1;
            knU = i2;
            this.knS = i2;
            if (i == 1) {
                i2 = aw.fK(str);
                if (i2 != -1) {
                    String trim = str.substring(0, i2).trim();
                    if (trim != null && trim.length() > 0) {
                        this.knT = trim;
                        this.bqH = str.substring(i2 + 1).trim();
                    }
                }
            }
        }
    }

    private c() {
        this.knN = 0;
        this.cis = new ArrayList(1);
        this.knP = new LinkedList();
        this.knQ = new HashMap();
        this.knO = new d[1];
    }

    private void b(int i, SparseArray<c> sparseArray) {
        Iterator it = this.cis.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(i, sparseArray);
        }
    }

    public final void baN() {
        v.d("MicroMsg.TranslateServiceManager", "current waitings : %s", new Object[]{Integer.valueOf(this.knP.size())});
        if (this.knP.size() != 0 && this.knN <= this.knO.length) {
            for (int i = 0; i < this.knO.length; i++) {
                if (this.knO[i] == null) {
                    this.knO[i] = new d(i, this);
                    ak.vy().a(631, this.knO[i]);
                }
                if (!this.knO[i].knW) {
                    Object obj;
                    d dVar = this.knO[i];
                    Queue queue = this.knP;
                    if (dVar.knW) {
                        obj = null;
                    } else {
                        dVar.knV = new SparseArray();
                        if (queue.size() == 0) {
                            obj = null;
                        } else {
                            dVar.knW = true;
                            LinkedList linkedList = new LinkedList();
                            int i2 = 0;
                            while (i2 < 512 && queue.size() > 0) {
                                c cVar = (c) queue.peek();
                                int length = cVar.bqH.getBytes().length;
                                if (i2 == 0 || i2 + length <= 512) {
                                    queue.poll();
                                    bae com_tencent_mm_protocal_c_bae = new bae();
                                    com_tencent_mm_protocal_c_bae.mWO = cVar.knS;
                                    com_tencent_mm_protocal_c_bae.mWP = cVar.bqH;
                                    if (cVar.type == 1 || m.dE(cVar.aHM)) {
                                        com_tencent_mm_protocal_c_bae.mWQ = cVar.aHM;
                                    }
                                    switch (cVar.type) {
                                        case 0:
                                            com_tencent_mm_protocal_c_bae.maG = 1;
                                            break;
                                        case 1:
                                            com_tencent_mm_protocal_c_bae.maG = 4;
                                            break;
                                        case 2:
                                            com_tencent_mm_protocal_c_bae.maG = 2;
                                            break;
                                        case 3:
                                            com_tencent_mm_protocal_c_bae.maG = 3;
                                            break;
                                    }
                                    v.d("MicroMsg.WorkingTranslate", "eventMsg.type: %d, msg.Scene:%d, id: %s", new Object[]{Integer.valueOf(cVar.type), Integer.valueOf(com_tencent_mm_protocal_c_bae.maG), cVar.id});
                                    linkedList.add(com_tencent_mm_protocal_c_bae);
                                    dVar.knV.put(cVar.knS, cVar);
                                }
                                i2 += length;
                            }
                            dVar.knX = new b(linkedList);
                            ak.vy().a(dVar.knX, 0);
                            dVar.start = System.currentTimeMillis();
                            dVar.knZ.ea(60000);
                            obj = 1;
                        }
                    }
                    if (obj != null) {
                        this.knN++;
                    }
                }
            }
        }
    }

    public final boolean CI(String str) {
        return this.knQ.containsKey(str);
    }

    public final void a(int i, SparseArray<c> sparseArray, LinkedList<baf> linkedList) {
        int i2;
        HashMap hashMap;
        this.knN--;
        if (linkedList == null || sparseArray.size() != linkedList.size()) {
            v.d("MicroMsg.TranslateServiceManager", "originals.size() != translatedMsg.size()");
            HashMap hashMap2 = new HashMap();
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                hashMap2.put(((c) sparseArray.valueAt(i2)).id, Integer.valueOf(((c) sparseArray.valueAt(i2)).knS));
            }
            hashMap = hashMap2;
        } else {
            hashMap = null;
        }
        c cVar;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                baf com_tencent_mm_protocal_c_baf = (baf) it.next();
                cVar = (c) sparseArray.get(com_tencent_mm_protocal_c_baf.mWO);
                String str = com_tencent_mm_protocal_c_baf.mWR;
                if (cVar.type == 1) {
                    str = aw.K(str, cVar.knT);
                    cVar.bqH = aw.K(cVar.bqH, cVar.knT);
                }
                cVar.bqN = str;
                cVar.ret = com_tencent_mm_protocal_c_baf.mcj;
                cVar.bpg = com_tencent_mm_protocal_c_baf.mWS;
                this.knQ.remove(cVar.id);
                if (hashMap != null) {
                    hashMap.remove(cVar.id);
                }
            }
        } else {
            for (i2 = 0; i2 < sparseArray.size(); i2++) {
                cVar = (c) sparseArray.valueAt(i2);
                if (cVar.type == 1) {
                    cVar.bqH = aw.K(cVar.bqH, cVar.knT);
                }
            }
        }
        if (hashMap != null && hashMap.size() > 0) {
            for (Entry key : hashMap.entrySet()) {
                this.knQ.remove(key.getKey());
                v.d("MicroMsg.TranslateServiceManager", "we found missing translate, msgId : %s, clientId : %s", new Object[]{key.getKey(), key.getValue()});
            }
        }
        b(i, sparseArray);
        baN();
    }
}
