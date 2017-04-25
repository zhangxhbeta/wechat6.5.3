package com.tencent.mm.plugin.emoji.f;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bo.b;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.protocal.c.nu;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class a implements b {
    public final void a(com.tencent.mm.v.d.a aVar) {
        bm bmVar = aVar.czu;
        if (bmVar.gll == 10002) {
            String a = m.a(bmVar.mbW);
            if (be.kS(a)) {
                v.w("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "msg content is null");
                return;
            }
            Map q = bf.q(a, "sysmsg");
            if (q != null && q.size() > 0) {
                String str = (String) q.get(".sysmsg.$type");
                String bn = be.bn(com.tencent.mm.ba.b.aT(p.rK().getBytes()).uz(16).lVU);
                int intValue;
                if (!be.kS(str) && str.equalsIgnoreCase("EmojiBackup")) {
                    intValue = Integer.valueOf((String) q.get(".sysmsg.EmojiBackup.OpCode")).intValue();
                    str = (String) q.get(".sysmsg.EmojiBackup.DeviceID");
                    v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "client devicesID:%s server devicesID:%s", new Object[]{bn, str});
                    if (be.kS(str) || !str.equalsIgnoreCase(bn)) {
                        ArrayList rD = b.rD(a);
                        if (intValue == 1) {
                            if (rD == null || rD.size() <= 0) {
                                v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                return;
                            }
                            v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. buckupList:%d", new Object[]{Integer.valueOf(rD.size())});
                            ArrayList arrayList = new ArrayList();
                            int size = rD.size();
                            for (int i = 0; i < size; i++) {
                                nu nuVar = (nu) rD.get(i);
                                if (nuVar != null) {
                                    c NF = g.afx().fch.NF(nuVar.mpC);
                                    if (NF != null && NF.bxE() && NF.field_catalog == c.nwR) {
                                        v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "md5:%s not need to download", new Object[]{nuVar.mpC});
                                    } else {
                                        arrayList.add(new com.tencent.mm.plugin.emoji.g.a.a(nuVar.mpC, nuVar.glb, nuVar.hOx, nuVar.mpD, nuVar.mpE, nuVar.mpF, nuVar.mdM));
                                    }
                                }
                            }
                            if (arrayList.size() > 0) {
                                g.afu().w(arrayList);
                                g.afu().feA.afU();
                            }
                        } else if (intValue == 2) {
                            if (rD == null || rD.size() <= 0) {
                                v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                                return;
                            }
                            List arrayList2 = new ArrayList();
                            if (rD != null && rD.size() > 0) {
                                Iterator it = rD.iterator();
                                while (it.hasNext()) {
                                    nu nuVar2 = (nu) it.next();
                                    if (nuVar2 != null) {
                                        arrayList2.add(nuVar2.mpC);
                                    }
                                }
                            }
                            g.afx().fch.ci(arrayList2);
                            ak.yW();
                            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noC, Boolean.valueOf(false));
                        } else if (intValue == 3) {
                            v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "set batch emoji download time to 0. ");
                            ak.yW();
                            com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noN, Long.valueOf(0));
                        }
                        ak.yW();
                        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.noK, Boolean.valueOf(true));
                        return;
                    }
                    v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    return;
                } else if (be.kS(str) || !str.equalsIgnoreCase("EmotionBackup")) {
                    v.e("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not emoji message type :" + str);
                    return;
                } else {
                    intValue = Integer.valueOf((String) q.get(".sysmsg.EmotionBackup.OpCode")).intValue();
                    str = (String) q.get(".sysmsg.EmotionBackup.DeviceID");
                    if (be.kS(str) || !str.equalsIgnoreCase(bn)) {
                        ArrayList rE = b.rE(a);
                        if (rE == null || rE.size() <= 0) {
                            v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "xml syn list is null.");
                            return;
                        } else if (intValue == 1) {
                            v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. add buckupList:%d", new Object[]{Integer.valueOf(rE.size())});
                            ArrayList arrayList3 = new ArrayList();
                            intValue = rE.size();
                            for (int i2 = 0; i2 < intValue; i2++) {
                                arrayList3.add(new com.tencent.mm.plugin.emoji.g.a.b((String) rE.get(i2)));
                            }
                            g.afu().x(arrayList3);
                            g.afu().feA.afU();
                            return;
                        } else if (intValue == 2) {
                            v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "try to sync emoji from newxml. delete buckupList:%d", new Object[]{Integer.valueOf(rE.size())});
                            g.afx().fci.Z(rE);
                            return;
                        } else {
                            return;
                        }
                    }
                    v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "same devices operate ignore.");
                    return;
                }
            }
            return;
        }
        v.i("MicroMsg.emoji.EmojiBackupSysCmdMsgListener", "not new xml type:%d ", new Object[]{Integer.valueOf(bmVar.gll)});
    }
}
