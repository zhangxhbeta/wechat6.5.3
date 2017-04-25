package com.tencent.mm.plugin.backup.backuppcmodel;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PLong;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public final class c implements com.tencent.mm.plugin.backup.b.b.d, com.tencent.mm.plugin.backup.backupmodel.b.b, e {
    private static boolean ebJ = false;
    private static long ecs = 0;
    com.tencent.mm.plugin.backup.backuppcmodel.a.c eaC;
    public com.tencent.mm.plugin.backup.backuppcmodel.a.b ecb;
    private boolean eck = false;
    private int ecl = 0;
    private LinkedList<String> ecm;
    private com.tencent.mm.plugin.backup.backupmodel.b ecn;
    private long eco = 0;
    private long ecp = 0;
    private HandlerThread ecq;
    private a ecr;
    public ac handler;

    public class a {
        String bYE;
        LinkedList<com.tencent.mm.plugin.backup.backuppcmodel.a.a> ebv;
        final /* synthetic */ c ect;
        private ah ecv;
        int ecw;

        public a(final c cVar, Looper looper) {
            this.ect = cVar;
            this.ecw = 0;
            this.ecw = 0;
            this.ecv = new ah(looper, new com.tencent.mm.sdk.platformtools.ah.a(this) {
                final /* synthetic */ a ecy;

                public final boolean oU() {
                    v.i("MicroMsg.BackupPcServer.dkbackup", "packDataPushTimerHandler onTimerExpired tryPackDataPush.");
                    a aVar = this.ecy;
                    while (aVar.ecw < aVar.ebv.size()) {
                        com.tencent.mm.plugin.backup.backuppcmodel.a.a aVar2 = (com.tencent.mm.plugin.backup.backuppcmodel.a.a) aVar.ebv.get(aVar.ecw);
                        String str = aVar2.ebF;
                        if (!aVar2.ebJ) {
                            aVar2.ebJ = true;
                            c.ebJ = true;
                        }
                        af Mh = com.tencent.mm.plugin.backup.g.b.Vd().wK().Mh(str);
                        if (Mh != null && aVar2.ebI.value == 0) {
                            aVar2.ebI.value = Mh.field_unReadCount;
                        }
                        v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backupPcImp username:%s, startTime:%d, endTime:%d, unReadCount:%d", str, Long.valueOf(aVar2.ebG.value), Long.valueOf(aVar2.ebH.value), Integer.valueOf(aVar2.ebI.value));
                        if (!aVar.a(str, aVar.bYE, aVar2.ebI, aVar2.ebG, aVar2.ebH)) {
                            v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backupPcImp.backupChatMsg canceled");
                            break;
                        }
                        aVar.ecw++;
                    }
                    if (aVar.ect.eck) {
                        v.e("MicroMsg.BackupPcServer.dkbackup", "Backup canceled!");
                    } else {
                        v.i("MicroMsg.BackupPcServer.dkbackup", "backup finish.");
                        c.TZ();
                        com.tencent.mm.plugin.backup.g.b.UL().ebf = aVar.ect.ecl;
                        aVar.ect.hU(5);
                        c.TX();
                        com.tencent.mm.plugin.backup.g.b.UL().TF();
                        com.tencent.mm.plugin.backup.g.b.UL().TI();
                        g.iuh.a(400, 11, 1, false);
                        aVar.ect.ecp = System.currentTimeMillis();
                        g.iuh.a(400, 12, aVar.ect.ecp - aVar.ect.eco, false);
                        g.iuh.a(400, 13, c.ecs, false);
                        g.iuh.h(13737, Integer.valueOf(MMGIFException.D_GIF_ERR_OPEN_FAILED), Long.valueOf(c.ecs), Long.valueOf(r8), Integer.valueOf(1));
                        v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backupfinish, backupDataSize:%d, backupCostTime:%d, backupStartTime:%d, backupEndTime:%d", Long.valueOf(c.ecs), Long.valueOf(r8), Long.valueOf(aVar.ect.eco), Long.valueOf(aVar.ect.ecp));
                        com.tencent.mm.plugin.backup.g.b.i(new Runnable(aVar) {
                            final /* synthetic */ a ecy;

                            {
                                this.ecy = r1;
                            }

                            public final void run() {
                                v.i("MicroMsg.BackupPcServer.dkbackup", "backupcloseTempDB end");
                                v.bta();
                            }
                        });
                    }
                    return false;
                }
            }, false);
            this.ebv = com.tencent.mm.plugin.backup.g.b.UL().ebv;
            if (this.ebv == null) {
                v.e("MicroMsg.BackupPcServer.dkbackup", "summerbak backupSessionList is null.");
                com.tencent.mm.plugin.backup.g.b.UL();
                a.TK();
                cVar.bl(false);
                cVar.hU(-7);
                return;
            }
            this.bYE = (String) com.tencent.mm.plugin.backup.g.b.Vd().vf().get(2, null);
            com.tencent.mm.plugin.backup.g.b.UL().ebf = 1;
            com.tencent.mm.plugin.backup.g.b.UL().ebg = this.ebv.size();
            cVar.hU(4);
        }

        public final synchronized void Ub() {
            if (this.ect.eck) {
                this.ecv.QI();
            } else {
                this.ecv.ea(0);
            }
        }

        public final boolean a(String str, String str2, PInt pInt, PLong pLong, PLong pLong2) {
            Cursor ae;
            Throwable e;
            Iterator it;
            com.tencent.mm.plugin.backup.f.g gVar;
            String str3;
            String str4;
            String str5;
            if (pLong2.value == 0) {
                ae = com.tencent.mm.plugin.backup.g.b.Vd().wJ().ae(str, pLong.value);
            } else {
                ae = com.tencent.mm.plugin.backup.g.b.Vd().wJ().l(str, pLong.value, pLong2.value);
            }
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            PLong pLong3 = new PLong();
            Object obj = 1;
            int i = 0;
            PLong pLong4 = new PLong();
            PLong pLong5 = new PLong();
            c cVar = new c(this.ect, str);
            if (ae.moveToFirst()) {
                int i2 = 0;
                LinkedList linkedList3 = linkedList;
                while (!ae.isAfterLast()) {
                    if (this.ect.eck) {
                        v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backupImp cancel");
                        this.ecv.QI();
                        return false;
                    }
                    Object a;
                    int i3;
                    bx atVar = new at();
                    atVar.b(ae);
                    if (obj != null) {
                        pLong4.value = atVar.field_createTime;
                        obj = null;
                    }
                    pLong5.value = atVar.field_createTime;
                    try {
                        a = com.tencent.mm.plugin.backup.g.d.a(atVar, false, str2, pLong3, linkedList2, pInt.value > 0);
                        try {
                            pInt.value--;
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                v.a("MicroMsg.BackupPcServer.dkbackup", e, "backupChatMsg", new Object[0]);
                                if (a != null) {
                                    linkedList3.add(a);
                                }
                                i3 = i2 + 1;
                                it = linkedList2.iterator();
                                while (it.hasNext()) {
                                    gVar = (com.tencent.mm.plugin.backup.f.g) it.next();
                                    v.i("MicroMsg.BackupPcServer.dkbackup", "add mediaIdHashSet, mediaId:%s, mediaPath:%s", gVar.mediaId, gVar.path);
                                    str3 = gVar.mediaId;
                                    str4 = gVar.path;
                                    cVar.ecF.add(str3);
                                    cVar.ecG.add(str3);
                                    cVar.ecC.aW(str3, str4);
                                }
                                linkedList2.clear();
                                if (((long) i3) >= 200) {
                                    i = i3;
                                    a = obj;
                                } else {
                                    str5 = "MSG_" + System.currentTimeMillis() + "_" + pLong3.value;
                                    v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak limitSize, msgListDataId:%s, msg count:%d", str5, Integer.valueOf(i3));
                                    cVar.a(str5, linkedList3);
                                    a(str, pLong4.value, pLong5.value, str5, cVar);
                                    cVar = new c(this.ect, str);
                                    pLong.value = pLong5.value;
                                    linkedList3 = new LinkedList();
                                    pLong3.value = 0;
                                    i = 0;
                                    a = 1;
                                    pLong4.value = 0;
                                    pLong5.value = 0;
                                    this.ecv.QI();
                                }
                                ae.moveToNext();
                                i2 = i;
                                obj = a;
                            } finally {
                                ae.close();
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        a = null;
                        v.a("MicroMsg.BackupPcServer.dkbackup", e, "backupChatMsg", new Object[0]);
                        if (a != null) {
                            linkedList3.add(a);
                        }
                        i3 = i2 + 1;
                        it = linkedList2.iterator();
                        while (it.hasNext()) {
                            gVar = (com.tencent.mm.plugin.backup.f.g) it.next();
                            v.i("MicroMsg.BackupPcServer.dkbackup", "add mediaIdHashSet, mediaId:%s, mediaPath:%s", gVar.mediaId, gVar.path);
                            str3 = gVar.mediaId;
                            str4 = gVar.path;
                            cVar.ecF.add(str3);
                            cVar.ecG.add(str3);
                            cVar.ecC.aW(str3, str4);
                        }
                        linkedList2.clear();
                        if (((long) i3) >= 200) {
                            str5 = "MSG_" + System.currentTimeMillis() + "_" + pLong3.value;
                            v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak limitSize, msgListDataId:%s, msg count:%d", str5, Integer.valueOf(i3));
                            cVar.a(str5, linkedList3);
                            a(str, pLong4.value, pLong5.value, str5, cVar);
                            cVar = new c(this.ect, str);
                            pLong.value = pLong5.value;
                            linkedList3 = new LinkedList();
                            pLong3.value = 0;
                            i = 0;
                            a = 1;
                            pLong4.value = 0;
                            pLong5.value = 0;
                            this.ecv.QI();
                        } else {
                            i = i3;
                            a = obj;
                        }
                        ae.moveToNext();
                        i2 = i;
                        obj = a;
                    }
                    if (a != null) {
                        linkedList3.add(a);
                    }
                    i3 = i2 + 1;
                    it = linkedList2.iterator();
                    while (it.hasNext()) {
                        gVar = (com.tencent.mm.plugin.backup.f.g) it.next();
                        v.i("MicroMsg.BackupPcServer.dkbackup", "add mediaIdHashSet, mediaId:%s, mediaPath:%s", gVar.mediaId, gVar.path);
                        str3 = gVar.mediaId;
                        str4 = gVar.path;
                        cVar.ecF.add(str3);
                        cVar.ecG.add(str3);
                        cVar.ecC.aW(str3, str4);
                    }
                    linkedList2.clear();
                    if (((long) i3) >= 200) {
                        str5 = "MSG_" + System.currentTimeMillis() + "_" + pLong3.value;
                        v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak limitSize, msgListDataId:%s, msg count:%d", str5, Integer.valueOf(i3));
                        cVar.a(str5, linkedList3);
                        a(str, pLong4.value, pLong5.value, str5, cVar);
                        cVar = new c(this.ect, str);
                        pLong.value = pLong5.value;
                        linkedList3 = new LinkedList();
                        pLong3.value = 0;
                        i = 0;
                        a = 1;
                        pLong4.value = 0;
                        pLong5.value = 0;
                        this.ecv.QI();
                    } else {
                        i = i3;
                        a = obj;
                    }
                    ae.moveToNext();
                    i2 = i;
                    obj = a;
                }
                i = i2;
                linkedList = linkedList3;
            }
            str5 = "MSG_" + System.currentTimeMillis() + "_" + pLong3.value;
            if (i > 0 || pLong3.value > 0) {
                v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak session finished, msgListDataId:%s, msg count:%d", str5, Integer.valueOf(i));
                cVar.a(str5, linkedList);
            }
            a(str, pLong4.value, pLong5.value, str5, cVar);
            LinkedList linkedList4 = new LinkedList();
            pLong3.value = 0;
            pLong4.value = 0;
            pLong5.value = 0;
            linkedList2.clear();
            this.ecv.QI();
            ae.close();
            return true;
        }

        private void a(String str, long j, long j2, String str2, c cVar) {
            v.i("MicroMsg.BackupPcServer.dkbackup", "~~~~ finishSendTagData start %s", str);
            Collection Uc = cVar.Uc();
            if (!this.ect.eck) {
                v.i("MicroMsg.BackupPcServer.dkbackup", "~~~~ finishSendTagData  step 1 finish little media and text %s :%s", str, Integer.valueOf(Uc.size()));
                b bVar = new b(this.ect, str);
                LinkedList oR = bVar.oR(str);
                HashSet w = (oR == null || oR.size() == 0) ? null : bVar.w(oR);
                if (!this.ect.eck) {
                    v.i("MicroMsg.BackupPcServer.dkbackup", "~~~~ finishSendTagData  step 2 sendAndWaitBigFiles %s ", str);
                    if (c.ebJ) {
                        this.ect.ecl = this.ect.ecl + 1;
                        com.tencent.mm.plugin.backup.g.b.UL().ebf = this.ect.ecl;
                        c cVar2 = this.ect;
                        com.tencent.mm.plugin.backup.g.b.UL();
                        cVar2.hU(a.TD());
                        c.ebJ = false;
                    }
                    if (!this.ect.eck) {
                        if (w == null) {
                            try {
                                w = new HashSet();
                            } catch (Exception e) {
                                Object obj = w;
                            }
                        }
                        w.addAll(Uc);
                        Collection collection = w;
                        new d(this.ect).a(str, j, j2, str2, new LinkedList(collection));
                        v.i("MicroMsg.BackupPcServer.dkbackup", "~~~~ finishSendTagData all step BackupPcSendTag %s ", str);
                        System.gc();
                    }
                }
            }
        }
    }

    public class b {
        final e ecA = new e(this) {
            final /* synthetic */ b ecE;

            {
                this.ecE = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                com.tencent.mm.plugin.backup.b.b.b(13, this.ecE.ecA);
                v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backup receive svrid response.");
                this.ecE.ecz = true;
                if (i != 0 || i2 != 0) {
                    v.e("MicroMsg.BackupPcServer.dkbackup", "svrid request failed");
                    this.ecE.ect.hU(-8);
                }
            }
        };
        private com.tencent.mm.plugin.backup.a.b.c ecB = new com.tencent.mm.plugin.backup.a.b.c(this) {
            final /* synthetic */ b ecE;

            {
                this.ecE = r1;
            }

            public final void ae(String str, int i) {
                this.ecE.ecD.remove(str);
                c.aE((long) i);
                v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak bigFileDataPush onSceneEnd left: size:%d，dataSize:%d", Integer.valueOf(this.ecE.ecD.size()), Integer.valueOf(i));
            }
        };
        private com.tencent.mm.plugin.backup.a.b ecC = new com.tencent.mm.plugin.backup.a.b();
        HashSet<String> ecD = new HashSet();
        final /* synthetic */ c ect;
        boolean ecz = false;

        final LinkedList<Long> oR(String str) {
            int size = com.tencent.mm.plugin.backup.g.b.UL().ebs.size();
            v.i("MicroMsg.BackupPcServer.dkbackup", "sendAndWaitBigFiles session:%s bigFileCnt:%d", str, Integer.valueOf(size));
            if (size <= 0) {
                return null;
            }
            com.tencent.mm.plugin.backup.b.b.a(13, this.ecA);
            com.tencent.mm.plugin.backup.a.d dVar = new com.tencent.mm.plugin.backup.a.d(str, com.tencent.mm.plugin.backup.g.b.UL().ebs, com.tencent.mm.plugin.backup.g.b.UL().ebt, com.tencent.mm.plugin.backup.g.b.UL().ebu);
            dVar.Uh();
            a UL = com.tencent.mm.plugin.backup.g.b.UL();
            UL.ebs = new LinkedList();
            UL.ebt = new LinkedList();
            UL.ebu = new LinkedList();
            v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak sendAndWaitBigFiles, bakChatName:%s, svrId size:%d .waiting BackupSvrIdScene....", str, Integer.valueOf(size));
            while (!this.ect.eck && !this.ecz) {
                v.v("MicroMsg.BackupPcServer.dkbackup", "sendAndWaitBigFiles isBackupPcServerCancel:%b isSceneEdn:%b ", Boolean.valueOf(this.ect.eck), Boolean.valueOf(this.ecz));
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                }
            }
            LinkedList<Long> linkedList = dVar.edi.efG;
            String str2 = "MicroMsg.BackupPcServer.dkbackup";
            String str3 = "summerbak sendAndWaitBigFiles , bakChatName:%s, svrId size:%d .!finish BackupSvrIdScene....: %d";
            Object[] objArr = new Object[3];
            objArr[0] = str;
            objArr[1] = Integer.valueOf(size);
            objArr[2] = Integer.valueOf(linkedList == null ? -1 : linkedList.size());
            v.i(str2, str3, objArr);
            return linkedList;
        }

        public b(c cVar, String str) {
            this.ect = cVar;
            this.ecC.a(str + "_BigFiles", this.ecB);
        }

        public final HashSet<String> w(LinkedList<Long> linkedList) {
            HashSet<String> hashSet = new HashSet();
            HashMap hashMap = com.tencent.mm.plugin.backup.g.b.UL().ebr;
            for (int i = 0; i < linkedList.size(); i++) {
                Long l = (Long) linkedList.get(i);
                com.tencent.mm.plugin.backup.f.g gVar = (com.tencent.mm.plugin.backup.f.g) hashMap.get(l);
                String str = "MicroMsg.BackupPcServer.dkbackup";
                String str2 = "backupBigDataFiles svrIdIndex:%d(%d), svrId:%d mediaInfo:%s";
                Object[] objArr = new Object[4];
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(linkedList.size());
                objArr[2] = l;
                objArr[3] = gVar == null ? "null" : gVar.mediaId;
                v.i(str, str2, objArr);
                if (gVar != null) {
                    hashSet.add(gVar.mediaId);
                    this.ecC.aW(gVar.mediaId, gVar.path);
                    this.ecD.add(gVar.mediaId);
                    if (this.ect.eck) {
                        break;
                    }
                }
            }
            while (!this.ect.eck) {
                v.v("MicroMsg.BackupPcServer.dkbackup", "backupBigDataFiles isBackupPcServerCancel:%b bigFileIdSet:%d ", Boolean.valueOf(this.ect.eck), Integer.valueOf(this.ecD.size()));
                if (this.ecD.size() <= 0) {
                    break;
                }
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                }
            }
            this.ecC.reset();
            return hashSet;
        }
    }

    public class c {
        private com.tencent.mm.plugin.backup.a.b.c ecB = new com.tencent.mm.plugin.backup.a.b.c(this) {
            final /* synthetic */ c ecH;

            {
                this.ecH = r1;
            }

            public final void ae(String str, int i) {
                this.ecH.ecG.remove(str);
                c.aE((long) i);
                v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak datapush onSceneEnd left: size:%d，dataSize:%d", Integer.valueOf(this.ecH.ecG.size()), Integer.valueOf(i));
            }
        };
        com.tencent.mm.plugin.backup.a.b ecC = new com.tencent.mm.plugin.backup.a.b();
        HashSet<String> ecF = new HashSet();
        HashSet<String> ecG = new HashSet();
        final /* synthetic */ c ect;

        public c(c cVar, String str) {
            this.ect = cVar;
            this.ecC.a(str + "_LittleFiles", this.ecB);
        }

        public final HashSet<String> Uc() {
            while (!this.ect.eck) {
                v.v("MicroMsg.BackupPcServer.dkbackup", "finishSendTagData running:%d  checkfinish:%b", Integer.valueOf(this.ecG.size()), Boolean.valueOf(this.ecC.Ug()));
                if (this.ecG.size() <= 0) {
                    break;
                }
                try {
                    Thread.sleep(300);
                } catch (Exception e) {
                }
            }
            this.ecC.reset();
            return this.ecF;
        }

        public final boolean a(String str, LinkedList<dx> linkedList) {
            this.ecG.add(str);
            com.tencent.mm.plugin.backup.a.b bVar = this.ecC;
            v.i("MicroMsg.BackupPcDataPush.dkbackup", "startdatapush [%s] queue[%d,%d] text id:%s list:%d ", bVar.ecR, Integer.valueOf(bVar.ecP.size()), Integer.valueOf(bVar.ecO.size()), str, Integer.valueOf(linkedList.size()));
            com.tencent.mm.plugin.backup.a.b.b eVar = new com.tencent.mm.plugin.backup.a.b.e(bVar, bVar.cAR, str, linkedList);
            bVar.a(str, eVar);
            bVar.a(eVar);
            return true;
        }
    }

    public class d {
        e ecI = new e(this) {
            final /* synthetic */ d ecJ;

            {
                this.ecJ = r1;
            }

            public final void a(int i, int i2, String str, k kVar) {
                v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backup receive tag response.");
                this.ecJ.ecz = true;
                com.tencent.mm.plugin.backup.b.b.b(15, this.ecJ.ecI);
                if (i != 0 || i2 != 0) {
                    v.e("MicroMsg.BackupPcServer.dkbackup", "data tag failed");
                    this.ecJ.ect.hU(-8);
                }
            }
        };
        final /* synthetic */ c ect;
        boolean ecz = false;

        public d(c cVar) {
            this.ect = cVar;
        }

        public final void a(String str, long j, long j2, String str2, LinkedList<String> linkedList) {
            String D;
            com.tencent.mm.plugin.backup.b.b.a(15, this.ecI);
            if (m.dE(str)) {
                D = l.D(str, str);
            } else {
                D = l.er(str);
            }
            com.tencent.mm.plugin.backup.a.a aVar = new com.tencent.mm.plugin.backup.a.a(str, j, j2, str2, D, linkedList);
            v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backupPcSendTag, bakChatName:%s, startTime:%d, endTime:%d, msgDataID:%s, nickName:%s, mediaLinkedList size:%d", str, Long.valueOf(j), Long.valueOf(j2), str2, D, Integer.valueOf(linkedList.size()));
            aVar.Uh();
            while (!this.ect.eck) {
                v.v("MicroMsg.BackupPcServer.dkbackup", "BackupPcSendTag isBackupPcServerCancel:%b isSceneEnd:%b ", Boolean.valueOf(this.ect.eck), Boolean.valueOf(this.ecz));
                if (!this.ecz) {
                    try {
                        Thread.sleep(300);
                    } catch (Exception e) {
                    }
                } else {
                    return;
                }
            }
        }
    }

    static /* synthetic */ long aE(long j) {
        long j2 = ecs + j;
        ecs = j2;
        return j2;
    }

    public final void a(com.tencent.mm.plugin.backup.backuppcmodel.a.c cVar) {
        this.eaC = cVar;
        this.handler = new ac(Looper.getMainLooper());
    }

    public final void init() {
        this.eck = false;
        this.ecl = 0;
        this.eco = 0;
        ecs = 0;
    }

    public final void bl(boolean z) {
        v.e("MicroMsg.BackupPcServer.dkbackup", "summerbak backupPcServer cancel, stack:%s", be.bur());
        if (!z) {
            com.tencent.mm.plugin.backup.g.b.UL();
            a.TK();
        }
        this.eck = true;
        if (this.ecn != null) {
            this.ecn.cancel();
            this.ecn = null;
        }
        if (this.ecq != null) {
            this.ecq.quit();
            this.ecq = null;
        }
        v.i("MicroMsg.BackupPcServer.dkbackup", "cancel , notifyall.");
        com.tencent.mm.plugin.backup.g.b.UL().TF();
        com.tencent.mm.plugin.backup.g.b.UL().TI();
    }

    public static void TX() {
        v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak clearContinueBackupData.");
        ak.yW();
        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.valueOf(false));
        Editor edit = com.tencent.mm.plugin.backup.g.b.UU().edit();
        edit.putString("BACKUP_PC_CHOOSE_SESSION", null);
        edit.commit();
    }

    private void TY() {
        if (this.ecq != null) {
            this.ecq.quit();
        }
        this.ecq = com.tencent.mm.sdk.i.e.bJ("backupPcPackThread", 10);
        this.ecq.start();
        this.ecr = new a(this, this.ecq.getLooper());
        this.ecr.Ub();
        com.tencent.mm.plugin.backup.g.b.UL().TE();
        this.eco = System.currentTimeMillis();
        v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backupStartTime:%d", Long.valueOf(this.eco));
    }

    public final void a(boolean z, int i, byte[] bArr, int i2) {
        long j;
        String str = "MicroMsg.BackupPcServer.dkbackup";
        String str2 = "summerbak onNotify isLocal:%b type:%d seq:%d buf:%d";
        Object[] objArr = new Object[4];
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(i2);
        objArr[3] = Integer.valueOf(bArr == null ? -1 : bArr.length);
        v.i(str, str2, objArr);
        if (z && bArr != null && 10011 == i) {
            com.tencent.mm.plugin.backup.g.b.UL();
            v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak local disconnect, backupPcState:%d", Integer.valueOf(a.TD()));
            switch (a.TD()) {
                case -11:
                case -9:
                case -8:
                case -7:
                case -6:
                    com.tencent.mm.plugin.backup.g.b.UP().stop();
                    break;
                case -1:
                    bl(true);
                    break;
                case 1:
                case 2:
                    com.tencent.mm.plugin.backup.g.b.UP().stop();
                    hU(-100);
                    break;
                case 3:
                case 4:
                    bl(true);
                    com.tencent.mm.plugin.backup.g.b.UP().stop();
                    hU(-1);
                    g.iuh.a(400, 9, 1, false);
                    j = 0;
                    if (this.eco != 0) {
                        j = System.currentTimeMillis() - this.eco;
                    }
                    g.iuh.h(13737, Integer.valueOf(MMGIFException.D_GIF_ERR_NOT_GIF_FILE), Long.valueOf(ecs), Long.valueOf(j), Integer.valueOf(1));
                    v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backup transfer disconnect, backupDataSize:%d, backupCostTime:%d", Long.valueOf(ecs), Long.valueOf(j));
                    break;
                case 5:
                    com.tencent.mm.plugin.backup.g.b.UP().stop();
                    hU(-100);
                    break;
            }
        }
        if (1 != com.tencent.mm.plugin.backup.g.b.UL().eaT && 3 != com.tencent.mm.plugin.backup.g.b.UL().eaT) {
            return;
        }
        if (i == 10) {
            com.tencent.mm.plugin.backup.d.d dVar = new com.tencent.mm.plugin.backup.d.d();
            try {
                dVar.az(bArr);
                j = dVar.eba;
                long j2 = com.tencent.mm.plugin.backup.g.b.UL().eba;
                v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak receive heartbeat response, ack:%d, currentAck:%d", Long.valueOf(j), Long.valueOf(j2));
            } catch (Throwable e) {
                v.a("MicroMsg.BackupPcServer.dkbackup", e, "summerbak heartbeat resp parse from buf error.", new Object[0]);
            }
        } else if (i == 5) {
            v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak receive command cancel");
            bl(true);
            if (this.ecn != null) {
                this.ecn.cancel();
                this.ecn = null;
            }
            hU(-100);
        } else if (i == 18) {
            v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak receive command response");
            com.tencent.mm.plugin.backup.d.b bVar = new com.tencent.mm.plugin.backup.d.b();
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        switch (kVar.getType()) {
            case 3:
                v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backup receive startrequest response.");
                com.tencent.mm.plugin.backup.b.b.b(3, this);
                if (i == 0 && i2 == 0) {
                    com.tencent.mm.plugin.backup.b.c cVar = (com.tencent.mm.plugin.backup.b.c) kVar;
                    com.tencent.mm.plugin.backup.g.b.UL().ebo = cVar.eeg.eeG;
                    v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backup start response big datasize:%d", Long.valueOf(cVar.eeg.eeG));
                    ak.yW();
                    com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false));
                    com.tencent.mm.plugin.backup.b.b.a(11, (e) this);
                    com.tencent.mm.plugin.backup.a.c cVar2 = new com.tencent.mm.plugin.backup.a.c(this.ecm);
                    v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backupPcSendRequestSession, users size:%d", Integer.valueOf(this.ecm.size()));
                    cVar2.Uh();
                    return;
                }
                v.e("MicroMsg.BackupPcServer.dkbackup", "start request failed, errMsg:" + str);
                hU(-8);
                return;
            case 11:
                v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backup receive requestsession response.");
                com.tencent.mm.plugin.backup.b.b.b(11, this);
                if (i != 0 || i2 != 0) {
                    v.e("MicroMsg.BackupPcServer.dkbackup", "request session failed");
                    hU(-8);
                    return;
                } else if (com.tencent.mm.plugin.backup.g.b.UL().ebp == null || com.tencent.mm.plugin.backup.g.b.UL().ebq == null || com.tencent.mm.plugin.backup.g.b.UL().ebq.size() != com.tencent.mm.plugin.backup.g.b.UL().ebp.size() * 2) {
                    v.e("MicroMsg.BackupPcServer.dkbackup", "request session resp sessionName or timeInterval null or request session resp number error.");
                    com.tencent.mm.plugin.backup.g.b.UL();
                    a.TK();
                    hU(-7);
                    return;
                } else {
                    com.tencent.mm.plugin.backup.g.b.UL().a(com.tencent.mm.plugin.backup.g.b.UL().ebp, com.tencent.mm.plugin.backup.g.b.UL().ebq);
                    if (1 == com.tencent.mm.plugin.backup.g.b.UL().eaT) {
                        if (this.ecm == null) {
                            PLong pLong = new PLong();
                            PInt pInt = new PInt();
                            if (this.ecn != null) {
                                this.ecn.cancel();
                            }
                            this.ecn = new com.tencent.mm.plugin.backup.backupmodel.b(this, null);
                            this.ecm = this.ecn.a(pLong, pInt);
                            v(this.ecm);
                        }
                        if (this.ecm == null) {
                            v.i("MicroMsg.BackupPcServer.dkbackup", "backupCalculator has been canceled");
                            return;
                        }
                        TY();
                    } else if (3 == com.tencent.mm.plugin.backup.g.b.UL().eaT) {
                        TY();
                    }
                    com.tencent.mm.plugin.backup.g.b.UL().TH();
                    return;
                }
            default:
                return;
        }
    }

    public final void v(LinkedList<String> linkedList) {
        this.ecm = linkedList;
        Editor edit = com.tencent.mm.plugin.backup.g.b.UU().edit();
        if (1 == com.tencent.mm.plugin.backup.g.b.UL().eaT) {
            edit.putString("BACKUP_PC_CHOOSE_SESSION", a.a(SQLiteDatabase.KeyEmpty, ",", (String[]) linkedList.toArray(new String[linkedList.size()])));
        }
        ak.yW();
        com.tencent.mm.model.c.vf().a(com.tencent.mm.storage.t.a.USERINFO_BACKUP_PC_BACKUPING_BOOLEAN, Boolean.valueOf(true));
        edit.commit();
    }

    public final void aD(long j) {
        com.tencent.mm.plugin.backup.b.b.a(3, (e) this);
        com.tencent.mm.plugin.backup.b.c cVar = new com.tencent.mm.plugin.backup.b.c(com.tencent.mm.plugin.backup.g.b.UZ());
        PLong pLong = new PLong();
        PLong pLong2 = new PLong();
        ak.yW();
        com.tencent.mm.plugin.backup.g.g.a(0, pLong, pLong2, com.tencent.mm.model.c.xq());
        ak.yW();
        int aQ = com.tencent.mm.a.e.aQ(com.tencent.mm.model.c.xn());
        ak.yW();
        long aQ2 = (long) (aQ + com.tencent.mm.a.e.aQ(com.tencent.mm.model.c.xo()));
        long j2 = pLong2.value - aQ2;
        com.tencent.mm.plugin.backup.g.b.UL().h(aQ2, pLong2.value);
        if (j2 <= 0) {
            com.tencent.mm.plugin.backup.g.b.UL();
            a.TK();
            hU(-9);
            g.iuh.a(400, 61, 1, false);
            g.iuh.h(13736, Integer.valueOf(MMGIFException.D_GIF_ERR_NOT_GIF_FILE), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1));
            return;
        }
        ak.yW();
        if (((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.USERINFO_BACKUP_OLD_RECORDS_BOOLEAN, Boolean.valueOf(false))).booleanValue()) {
            aQ = 0;
        } else {
            aQ = 1;
        }
        com.tencent.mm.plugin.backup.g.b.UL();
        com.tencent.mm.plugin.backup.d.g aC = a.aC(pLong2.value);
        cVar.eef.eeG = 0;
        cVar.eef.eeH = j;
        cVar.eef.eeI = 0;
        cVar.eef.eeJ = aC;
        cVar.eef.eeK = 0;
        cVar.eef.eeL = aQ;
        v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backupPcSendStartRequest, sessionCount:%d, transferType:%d", Long.valueOf(j), Integer.valueOf(aQ));
        cVar.Uh();
    }

    public static void TZ() {
        com.tencent.mm.plugin.backup.c.b bVar = new com.tencent.mm.plugin.backup.c.b();
        bVar.ID = com.tencent.mm.plugin.backup.g.b.UZ();
        try {
            v.i("MicroMsg.BackupPcServer.dkbackup", "summerbak backupPcSendFinishRequest.");
            com.tencent.mm.plugin.backup.b.b.r(bVar.toByteArray(), 8);
        } catch (Throwable e) {
            v.a("MicroMsg.BackupPcServer.dkbackup", e, "summerbak BackupFinishRequest parse req failed.", new Object[0]);
        }
    }

    public final void TR() {
        if (this.eaC != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ c ect;

                {
                    this.ect = r1;
                }

                public final void run() {
                    this.ect.eaC.TR();
                }
            });
        }
    }

    public final void hU(int i) {
        com.tencent.mm.plugin.backup.g.b.UL();
        a.hO(i);
        if (this.eaC != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ c ect;

                {
                    this.ect = r1;
                }

                public final void run() {
                    this.ect.eaC.TS();
                }
            });
        }
        if (this.ecb != null) {
            this.handler.post(new Runnable(this) {
                final /* synthetic */ c ect;

                {
                    this.ect = r1;
                }

                public final void run() {
                    this.ect.ecb.TQ();
                }
            });
        }
    }
}
