package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.protocal.c.azs;
import com.tencent.mm.protocal.c.pu;
import com.tencent.mm.protocal.c.rb;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Iterator;
import java.util.LinkedList;

public final class c {
    public static void a(String str, long j, long j2, int i) {
        if (j2 != 0) {
            rb rbVar;
            rb Bs = ad.aSG().Bs(str);
            if (Bs == null) {
                rbVar = new rb();
            } else {
                rbVar = Bs;
            }
            if (j != 0 || !rbVar.muQ.isEmpty()) {
                if (j == 0) {
                    j = ((pu) rbVar.muQ.getFirst()).mrF;
                }
                pu puVar = new pu();
                puVar.mrF = j;
                puVar.mrG = j2;
                azs com_tencent_mm_protocal_c_azs = new azs();
                com_tencent_mm_protocal_c_azs.mWy = j;
                com_tencent_mm_protocal_c_azs.mWz = j2;
                com_tencent_mm_protocal_c_azs.mWA = i;
                puVar.mrH.add(com_tencent_mm_protocal_c_azs);
                pu puVar2 = puVar;
                while (!rbVar.muQ.isEmpty()) {
                    puVar = (pu) rbVar.muQ.getFirst();
                    if (o(puVar2.mrG, puVar.mrF) > 0) {
                        v.e("MicroMsg.FaultLogic", "has a fault: newerMin:" + puVar2.mrG + " fault.Max" + puVar.mrF);
                        break;
                    } else {
                        rbVar.muQ.removeFirst();
                        puVar2 = a(puVar, puVar2);
                    }
                }
                rbVar.muQ.addFirst(puVar2);
                while (rbVar.muQ.size() > 100) {
                    rbVar.muQ.removeLast();
                }
                if (rbVar.muQ.size() > 0) {
                    v.d("MicroMsg.FaultLogic", "min " + ((pu) rbVar.muQ.get(0)).mrG + " max " + ((pu) rbVar.muQ.get(0)).mrF);
                }
                i Bu = ad.aSG().Bu(str);
                try {
                    Bu.field_userName = str;
                    Bu.field_faultS = rbVar.toByteArray();
                    ad.aSG().c(Bu);
                } catch (Exception e) {
                }
                if (rbVar.muQ.size() > 1) {
                    v.d("MicroMsg.FaultLogic", "fault size : " + rbVar.muQ.size());
                    Iterator it = rbVar.muQ.iterator();
                    while (it.hasNext()) {
                        puVar = (pu) it.next();
                        v.d("MicroMsg.FaultLogic", "min - max " + puVar.mrG + " " + puVar.mrF);
                    }
                }
            }
        }
    }

    private static pu a(pu puVar, pu puVar2) {
        pu puVar3 = new pu();
        if (o(puVar.mrF, puVar2.mrF) > 0) {
            puVar3.mrF = puVar.mrF;
        } else {
            puVar3.mrF = puVar2.mrF;
        }
        if (o(puVar.mrG, puVar2.mrG) < 0) {
            puVar3.mrG = puVar.mrG;
        } else {
            puVar3.mrG = puVar2.mrG;
        }
        LinkedList linkedList = puVar.mrH;
        Iterator it = puVar2.mrH.iterator();
        while (it.hasNext()) {
            azs com_tencent_mm_protocal_c_azs = (azs) it.next();
            if (linkedList.isEmpty()) {
                v.e("MicroMsg.FaultLogic", "fault's segments should not empty!!");
                linkedList.addFirst(com_tencent_mm_protocal_c_azs);
            } else {
                long j = com_tencent_mm_protocal_c_azs.mWz;
                int size = linkedList.size() - 1;
                while (size >= 0) {
                    if (o(j, ((azs) linkedList.get(size)).mWy) <= 0) {
                        break;
                    }
                    size--;
                }
                size = -1;
                j = com_tencent_mm_protocal_c_azs.mWy;
                int i = 0;
                while (i < linkedList.size()) {
                    if (o(j, ((azs) linkedList.get(i)).mWz) >= 0) {
                        break;
                    }
                    i++;
                }
                i = linkedList.size();
                if (size == -1) {
                    linkedList.addFirst(com_tencent_mm_protocal_c_azs);
                } else if (i == linkedList.size()) {
                    linkedList.addLast(com_tencent_mm_protocal_c_azs);
                } else {
                    azs com_tencent_mm_protocal_c_azs2 = (azs) linkedList.get(i);
                    if (o(com_tencent_mm_protocal_c_azs.mWy, com_tencent_mm_protocal_c_azs2.mWy) < 0) {
                        azs com_tencent_mm_protocal_c_azs3 = new azs();
                        com_tencent_mm_protocal_c_azs3.mWy = com_tencent_mm_protocal_c_azs2.mWy;
                        j = com_tencent_mm_protocal_c_azs.mWy;
                        com_tencent_mm_protocal_c_azs3.mWz = j == Long.MAX_VALUE ? Long.MIN_VALUE : j + 1;
                        com_tencent_mm_protocal_c_azs3.mWA = com_tencent_mm_protocal_c_azs2.mWA;
                        linkedList.add(i, com_tencent_mm_protocal_c_azs3);
                        int i2 = i + 1;
                        i = size + 1;
                        size = i2;
                    } else {
                        int i3 = i;
                        i = size;
                        size = i3;
                    }
                    com_tencent_mm_protocal_c_azs2 = (azs) linkedList.get(i);
                    if (o(com_tencent_mm_protocal_c_azs.mWz, com_tencent_mm_protocal_c_azs2.mWz) > 0) {
                        azs com_tencent_mm_protocal_c_azs4 = new azs();
                        com_tencent_mm_protocal_c_azs4.mWz = com_tencent_mm_protocal_c_azs2.mWz;
                        com_tencent_mm_protocal_c_azs4.mWy = cG(com_tencent_mm_protocal_c_azs.mWz);
                        com_tencent_mm_protocal_c_azs4.mWA = com_tencent_mm_protocal_c_azs2.mWA;
                        linkedList.add(i + 1, com_tencent_mm_protocal_c_azs4);
                    }
                    while (i >= size) {
                        linkedList.remove(i);
                        i--;
                    }
                    linkedList.add(size, com_tencent_mm_protocal_c_azs);
                    if (linkedList.size() > 100) {
                        long j2 = ((azs) linkedList.getLast()).mWz;
                        long j3 = ((azs) linkedList.getLast()).mWy;
                        int i4 = ((azs) linkedList.getLast()).mWA;
                        long j4 = j3;
                        while (linkedList.size() >= 100) {
                            int i5;
                            com_tencent_mm_protocal_c_azs = (azs) linkedList.removeLast();
                            j3 = com_tencent_mm_protocal_c_azs.mWy;
                            if (com_tencent_mm_protocal_c_azs.mWA < i4) {
                                i5 = com_tencent_mm_protocal_c_azs.mWA;
                            } else {
                                i5 = i4;
                            }
                            i4 = i5;
                            j4 = j3;
                        }
                        azs com_tencent_mm_protocal_c_azs5 = new azs();
                        com_tencent_mm_protocal_c_azs5.mWy = j4;
                        com_tencent_mm_protocal_c_azs5.mWz = j2;
                        com_tencent_mm_protocal_c_azs5.mWA = i4;
                        linkedList.addLast(com_tencent_mm_protocal_c_azs5);
                    }
                }
            }
        }
        puVar3.mrH = linkedList;
        return puVar3;
    }

    private static long o(long j, long j2) {
        if ((j <= 0 || j2 <= 0) && (j >= 0 || j2 >= 0)) {
            return j < 0 ? 1 : -1;
        } else {
            return j - j2;
        }
    }

    public static long cG(long j) {
        if (j == Long.MIN_VALUE) {
            return Long.MAX_VALUE;
        }
        return j - 1;
    }

    public static int a(long j, long j2, String str) {
        LinkedList linkedList = ad.aSG().Bs(str).muQ;
        v.i("MicroMsg.FaultLogic", "getLastReqTimeByMinId fault.count %s", new Object[]{Integer.valueOf(r0.muQ.size())});
        if (linkedList.isEmpty()) {
            return 0;
        }
        pu puVar = (pu) linkedList.getFirst();
        if (j == 0 || o(puVar.mrG, j) > 0) {
            v.e("MicroMsg.FaultLogic", "has a fault  minId:" + j2 + " fault.min:" + puVar.mrG);
            return 0;
        } else if (j2 == 0 || o(puVar.mrF, j2) >= 0) {
            LinkedList linkedList2 = puVar.mrH;
            if (linkedList2.isEmpty()) {
                return 0;
            }
            Iterator it = linkedList2.iterator();
            int i = Integer.MAX_VALUE;
            while (it.hasNext()) {
                azs com_tencent_mm_protocal_c_azs = (azs) it.next();
                if (j2 == 0 || o(j2, com_tencent_mm_protocal_c_azs.mWz) >= 0) {
                    if (com_tencent_mm_protocal_c_azs.mWA < i) {
                        i = com_tencent_mm_protocal_c_azs.mWA;
                    }
                    if (o(j, com_tencent_mm_protocal_c_azs.mWz) >= 0) {
                        if (i == Integer.MAX_VALUE) {
                            return 0;
                        }
                        return i;
                    }
                }
            }
            v.i("MicroMsg.FaultLogic", "should not to hear  minId:" + j);
            return 0;
        } else {
            v.e("MicroMsg.FaultLogic", ":" + j2 + " fault.max:" + puVar.mrF);
            return 0;
        }
    }
}
