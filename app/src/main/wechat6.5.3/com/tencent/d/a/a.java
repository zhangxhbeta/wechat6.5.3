package com.tencent.d.a;

import com.tencent.d.d;
import com.tencent.d.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a {
    public HashMap<String, Object> pHx = new HashMap();
    public Object pHy = new Object();
    c pHz;

    public final void a(d dVar, String[] strArr) {
        if (dVar != null && strArr != null) {
            synchronized (this.pHy) {
                for (Object obj : strArr) {
                    if (obj != null) {
                        Object obj2 = this.pHx.get(obj);
                        if (obj2 == null) {
                            this.pHx.put(obj, dVar);
                        } else if (obj2 instanceof d) {
                            d dVar2 = (d) obj2;
                            if (dVar2 == dVar) {
                                return;
                            }
                            LinkedList linkedList = new LinkedList();
                            linkedList.add(dVar2);
                            linkedList.add(dVar);
                            this.pHx.put(obj, linkedList);
                        } else if (obj2 instanceof List) {
                            LinkedList linkedList2 = (LinkedList) obj2;
                            if (linkedList2.indexOf(dVar) >= 0) {
                                return;
                            }
                            linkedList2.add(dVar);
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
    }

    public final void b(String str, int i, Object obj) {
        LinkedList linkedList = null;
        d dVar = this.pHz;
        e bPe = dVar.bPe();
        if (bPe == null) {
            bPe = dVar.bPd();
        } else {
            bPe.reset();
        }
        e eVar = (e) bPe;
        eVar.biq = str;
        eVar.pHB = i;
        eVar.arg1 = 0;
        eVar.arg2 = 0;
        eVar.obj = obj;
        if (eVar != null && eVar.biq != null) {
            d dVar2;
            System.currentTimeMillis();
            String str2 = eVar.biq;
            synchronized (this.pHy) {
                Object obj2 = this.pHx.get(str2);
                if (obj2 != null) {
                    if (obj2 instanceof d) {
                        dVar2 = (d) obj2;
                    } else if (obj2 instanceof List) {
                        linkedList = (LinkedList) ((LinkedList) obj2).clone();
                        obj2 = null;
                    }
                }
                dVar2 = null;
            }
            if (dVar2 != null) {
                dVar2.cs(str2, eVar.pHB);
            }
            if (linkedList != null) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    ((d) it.next()).cs(str2, eVar.pHB);
                }
            }
            dVar = this.pHz;
            synchronized (dVar.mLock) {
                if (dVar.iUN < dVar.pHj.length) {
                    dVar.pHj[dVar.iUN] = eVar;
                    dVar.iUN++;
                }
            }
        }
    }
}
