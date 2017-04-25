package com.tencent.mm.plugin.record.a;

import android.database.Cursor;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mm.a.g;
import com.tencent.mm.e.a.ez;
import com.tencent.mm.model.ak;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p implements com.tencent.mm.plugin.record.a.i.a, e {
    boolean ipo = false;
    SparseArray<d> ipr = new SparseArray();
    LinkedList<k> ips = new LinkedList();

    private class a implements Runnable {
        final /* synthetic */ p ipI;
        private k ipl;

        public a(p pVar, k kVar) {
            this.ipI = pVar;
            this.ipl = kVar;
        }

        public final void run() {
            Iterator it = this.ipl.field_dataProto.mtR.iterator();
            boolean z = false;
            while (it.hasNext()) {
                String str;
                String c;
                pw pwVar = (pw) it.next();
                if (!be.kS(pwVar.mrS) || com.tencent.mm.a.e.aR(pwVar.msq)) {
                    str = pwVar.msq;
                    c = m.c(pwVar, this.ipl.field_msgId);
                    v.d("MicroMsg.RecordMsgSendService", "summerrecord CdnDataUrl[%s] copy[%s] to [%s] result[%B]", new Object[]{pwVar.mrS, str, c, Boolean.valueOf(j.n(str, c, false))});
                    if (j.n(str, c, false)) {
                        if (be.kS(pwVar.msj)) {
                            v.i("MicroMsg.RecordMsgSendService", "summerrecord not find full md5, try to calculate");
                            pwVar.IH(g.aX(c));
                            z = true;
                        }
                        if (be.kS(pwVar.msl)) {
                            v.i("MicroMsg.RecordMsgSendService", "summerrecord not find head 256 md5, try to calculate");
                            pwVar.II(g.aY(c));
                            z = true;
                        }
                    }
                    pwVar.dQ((long) com.tencent.mm.a.e.aQ(c));
                    str = m.c(pwVar.luu, this.ipl.field_msgId, false);
                    if (s.aJE().yx(str) == null) {
                        g gVar = new g();
                        gVar.field_cdnKey = pwVar.mrU;
                        gVar.field_cdnUrl = pwVar.mrS;
                        gVar.field_dataId = pwVar.luu;
                        gVar.field_mediaId = str;
                        gVar.field_totalLen = (int) pwVar.msn;
                        gVar.field_localId = gVar.field_mediaId.hashCode();
                        gVar.field_path = m.c(pwVar, this.ipl.field_msgId);
                        gVar.field_type = 2;
                        gVar.field_fileType = m.oM(pwVar.aKG);
                        gVar.field_recordLocalId = this.ipl.field_localId;
                        gVar.field_toUser = this.ipl.field_toUser;
                        gVar.field_isThumb = false;
                        boolean a = s.aJE().a(gVar);
                        v.d("MicroMsg.RecordMsgSendService", "summerrecord insert localId[%d] result[%B] fileType[%d], mediaId[%s]", new Object[]{Integer.valueOf(gVar.field_localId), Boolean.valueOf(a), Integer.valueOf(gVar.field_fileType), str});
                    }
                }
                if (!be.kS(pwVar.coj) || com.tencent.mm.a.e.aR(pwVar.mss)) {
                    str = pwVar.mss;
                    c = m.f(pwVar, this.ipl.field_msgId);
                    v.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[]{str, c, Boolean.valueOf(j.n(str, c, false))});
                    pwVar.dR((long) com.tencent.mm.a.e.aQ(c));
                    if (j.n(str, c, false)) {
                        if (be.kS(pwVar.msu)) {
                            v.i("MicroMsg.RecordMsgSendService", "not find ThumbMd5 md5, try to calculate");
                            pwVar.IM(g.aX(c));
                            z = true;
                        }
                        if (be.kS(pwVar.msw)) {
                            v.i("MicroMsg.RecordMsgSendService", "not find Thumb Head 256 Md5, try to calculate");
                            pwVar.IN(g.aY(c));
                            z = true;
                        }
                    }
                    str = m.sX(pwVar.luu);
                    c = m.c(str, this.ipl.field_msgId, false);
                    if (s.aJE().yx(c) == null) {
                        g gVar2 = new g();
                        gVar2.field_cdnKey = pwVar.mrO;
                        gVar2.field_cdnUrl = pwVar.coj;
                        gVar2.field_dataId = str;
                        gVar2.field_mediaId = c;
                        gVar2.field_totalLen = (int) pwVar.msy;
                        gVar2.field_localId = gVar2.field_mediaId.hashCode();
                        gVar2.field_path = m.f(pwVar, this.ipl.field_msgId);
                        gVar2.field_type = 2;
                        gVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
                        gVar2.field_recordLocalId = this.ipl.field_localId;
                        gVar2.field_toUser = this.ipl.field_toUser;
                        gVar2.field_isThumb = true;
                        boolean a2 = s.aJE().a(gVar2);
                        v.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(gVar2.field_localId), Boolean.valueOf(a2)});
                    }
                }
                z = z;
            }
            if (z) {
                v.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[]{Integer.valueOf(this.ipl.field_localId), Long.valueOf(this.ipl.field_msgId), Integer.valueOf(this.ipl.field_type)});
                s.aJD().a(this.ipl, new String[]{"localId"});
            }
            s.aJG().run();
        }
    }

    private class b implements Runnable {
        final /* synthetic */ p ipI;
        private k ipl;

        public b(p pVar, k kVar) {
            this.ipI = pVar;
            this.ipl = kVar;
        }

        public final void run() {
            Iterator it = this.ipl.field_dataProto.mtR.iterator();
            while (it.hasNext()) {
                pw pwVar = (pw) it.next();
                ez ezVar = new ez();
                ezVar.bdQ.type = 2;
                ezVar.bdQ.bdS = pwVar;
                com.tencent.mm.sdk.c.a.nhr.z(ezVar);
                v.d("MicroMsg.RecordMsgSendService", "check dataid[%s] type[%d]", new Object[]{pwVar.luu, Integer.valueOf(pwVar.aKG)});
                if (!be.kS(ezVar.bdR.path)) {
                    String c = m.c(pwVar, this.ipl.field_msgId);
                    v.d("MicroMsg.RecordMsgSendService", "check data ok, try copy[%s] to[%s]", new Object[]{ezVar.bdR.path, c});
                    if (!ezVar.bdR.path.equals(c)) {
                        j.n(ezVar.bdR.path, c, false);
                    }
                }
                if (!be.kS(ezVar.bdR.bdZ)) {
                    String f = m.f(pwVar, this.ipl.field_msgId);
                    v.d("MicroMsg.RecordMsgSendService", "check thumb ok, try copy[%s] to[%s]", new Object[]{ezVar.bdR.bdZ, f});
                    if (!ezVar.bdR.bdZ.equals(f)) {
                        j.n(ezVar.bdR.bdZ, f, false);
                    }
                }
            }
            ak.vy().a(new a(this.ipl), 0);
        }
    }

    private class c implements Runnable {
        final /* synthetic */ p ipI;
        private k ipl;

        public c(p pVar, k kVar) {
            this.ipI = pVar;
            this.ipl = kVar;
        }

        public final void run() {
            Iterator it = this.ipl.field_dataProto.mtR.iterator();
            boolean z = false;
            while (it.hasNext()) {
                String c;
                String c2;
                pw pwVar = (pw) it.next();
                if (!be.kS(pwVar.mrS)) {
                    c = m.c(pwVar, this.ipl.field_oriMsgId);
                    c2 = m.c(pwVar, this.ipl.field_msgId);
                    v.d("MicroMsg.RecordMsgSendService", "copy[%s] to [%s] result[%B]", new Object[]{c, c2, Boolean.valueOf(j.n(c, c2, false))});
                    if (j.n(c, c2, false)) {
                        if (be.kS(pwVar.msj)) {
                            v.i("MicroMsg.RecordMsgSendService", "not find full md5, try to calculate");
                            pwVar.IH(g.aX(c2));
                            z = true;
                        }
                        if (be.kS(pwVar.msl)) {
                            v.i("MicroMsg.RecordMsgSendService", "not find head 256 md5, try to calculate");
                            pwVar.II(g.aY(c2));
                            z = true;
                        }
                    }
                    c = m.c(pwVar.luu, this.ipl.field_msgId, false);
                    if (s.aJE().yx(c) == null) {
                        g gVar = new g();
                        gVar.field_cdnKey = pwVar.mrU;
                        gVar.field_cdnUrl = pwVar.mrS;
                        gVar.field_dataId = pwVar.luu;
                        gVar.field_mediaId = c;
                        gVar.field_totalLen = (int) pwVar.msn;
                        gVar.field_localId = gVar.field_mediaId.hashCode();
                        gVar.field_path = m.c(pwVar, this.ipl.field_msgId);
                        gVar.field_type = 2;
                        gVar.field_fileType = m.oM(pwVar.aKG);
                        gVar.field_recordLocalId = this.ipl.field_localId;
                        gVar.field_toUser = this.ipl.field_toUser;
                        gVar.field_isThumb = false;
                        boolean a = s.aJE().a(gVar);
                        v.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(gVar.field_localId), Boolean.valueOf(a)});
                    }
                }
                if (!be.kS(pwVar.coj)) {
                    boolean n = j.n(m.f(pwVar, this.ipl.field_oriMsgId), m.f(pwVar, this.ipl.field_msgId), false);
                    v.d("MicroMsg.RecordMsgSendService", "copy thumb[%s] to [%s] result[%B]", new Object[]{c, c2, Boolean.valueOf(n)});
                    c = m.sX(pwVar.luu);
                    c2 = m.c(c, this.ipl.field_msgId, false);
                    if (s.aJE().yx(c2) == null) {
                        g gVar2 = new g();
                        gVar2.field_cdnKey = pwVar.mrO;
                        gVar2.field_cdnUrl = pwVar.coj;
                        gVar2.field_dataId = c;
                        gVar2.field_mediaId = c2;
                        gVar2.field_totalLen = (int) pwVar.msy;
                        gVar2.field_localId = gVar2.field_mediaId.hashCode();
                        gVar2.field_path = m.f(pwVar, this.ipl.field_msgId);
                        gVar2.field_type = 2;
                        gVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
                        gVar2.field_recordLocalId = this.ipl.field_localId;
                        gVar2.field_toUser = this.ipl.field_toUser;
                        gVar2.field_isThumb = true;
                        boolean a2 = s.aJE().a(gVar2);
                        v.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(gVar2.field_localId), Boolean.valueOf(a2)});
                    }
                }
            }
            if (z) {
                v.d("MicroMsg.RecordMsgSendService", "update record info, something changed, localid %d msgid %d, type %d", new Object[]{Integer.valueOf(this.ipl.field_localId), Long.valueOf(this.ipl.field_msgId), Integer.valueOf(this.ipl.field_type)});
                s.aJD().a(this.ipl, new String[]{"localId"});
            }
            s.aJG().run();
        }
    }

    private static final class d {
        int dph;
        long ipu;

        private d() {
            this.ipu = SystemClock.elapsedRealtime();
            this.dph = 3;
        }
    }

    public p() {
        ak.vy().a(632, this);
        s.aJE().a((com.tencent.mm.plugin.record.a.i.a) this);
    }

    public final void a(final k kVar) {
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ p ipI;

            public final void run() {
                if (kVar != null) {
                    if (((d) this.ipI.ipr.get(kVar.field_localId)) == null) {
                        v.d("MicroMsg.RecordMsgSendService", "summerrecord do add job, localid %d, msgid %d", new Object[]{Integer.valueOf(kVar.field_localId), Long.valueOf(kVar.field_msgId)});
                        this.ipI.ipr.put(kVar.field_localId, new d());
                    }
                    this.ipI.b(kVar);
                }
                p pVar = this.ipI;
                if (pVar.ipo) {
                    v.d("MicroMsg.RecordMsgSendService", "summerrecord is working, return");
                    return;
                }
                k kVar;
                d dVar;
                if (pVar.ips.isEmpty()) {
                    v.w("MicroMsg.RecordMsgSendService", "summerrecord jobs list size is 0");
                    l aJD = s.aJD();
                    List<k> linkedList = new LinkedList();
                    Cursor Kp = aJD.Kp();
                    if (Kp != null) {
                        Kp.moveToFirst();
                        while (!Kp.isAfterLast()) {
                            k kVar2 = new k();
                            kVar2.b(Kp);
                            linkedList.add(kVar2);
                            Kp.moveToNext();
                        }
                        Kp.close();
                    }
                    v.d("MicroMsg.RecordMsgStorage", "get all finish, result count %d", new Object[]{Integer.valueOf(linkedList.size())});
                    for (k kVar3 : linkedList) {
                        ak.yW();
                        if (com.tencent.mm.model.c.wJ().ek(kVar3.field_msgId).field_type != 49) {
                            v.w("MicroMsg.RecordMsgSendService", "summerrecord record msg not exist, delete record info, localid[%d], msgid[%d]", new Object[]{Integer.valueOf(kVar3.field_localId), Long.valueOf(kVar3.field_msgId)});
                            s.aJD().oL(kVar3.field_localId);
                        } else {
                            dVar = (d) pVar.ipr.get(kVar3.field_localId);
                            if (dVar == null) {
                                pVar.ipr.put(kVar3.field_localId, new d());
                            } else if (dVar.dph >= 0 || SystemClock.elapsedRealtime() - dVar.ipu >= 300000) {
                                if (dVar.dph < 0) {
                                    dVar.dph = 3;
                                }
                            }
                            v.d("MicroMsg.RecordMsgSendService", "summerrecord do add job from db, localid %d, msgid %d", new Object[]{Integer.valueOf(kVar3.field_localId), Long.valueOf(kVar3.field_msgId)});
                            pVar.b(kVar3);
                        }
                    }
                }
                if (pVar.ips.isEmpty()) {
                    v.w("MicroMsg.RecordMsgSendService", "try to do job, but job list size is empty, return");
                    pVar.finish();
                    return;
                }
                boolean z;
                kVar3 = (k) pVar.ips.removeFirst();
                dVar = (d) pVar.ipr.get(kVar3.field_localId);
                if (dVar == null) {
                    dVar = new d();
                    pVar.ipr.put(kVar3.field_localId, dVar);
                }
                dVar.dph--;
                if (dVar.dph < 0) {
                    if (300000 > SystemClock.elapsedRealtime() - dVar.ipu) {
                        z = false;
                        if (z) {
                            pVar.a(null);
                            return;
                        }
                        pVar.ipo = true;
                        switch (kVar3.field_type) {
                            case 0:
                                com.tencent.mm.sdk.i.e.a(new c(pVar, kVar3), "RecordMsgSendService_normalDataCopy");
                                return;
                            case 1:
                                com.tencent.mm.sdk.i.e.a(new b(pVar, kVar3), "RecordMsgSendService_favDataCopy");
                                return;
                            case 2:
                                com.tencent.mm.sdk.i.e.a(new a(pVar, kVar3), "RecordMsgSendService_chatDataCopy");
                                return;
                            default:
                                pVar.ipo = false;
                                return;
                        }
                    }
                    dVar.dph = 2;
                }
                dVar.ipu = SystemClock.elapsedRealtime();
                z = true;
                if (z) {
                    pVar.a(null);
                    return;
                }
                pVar.ipo = true;
                switch (kVar3.field_type) {
                    case 0:
                        com.tencent.mm.sdk.i.e.a(new c(pVar, kVar3), "RecordMsgSendService_normalDataCopy");
                        return;
                    case 1:
                        com.tencent.mm.sdk.i.e.a(new b(pVar, kVar3), "RecordMsgSendService_favDataCopy");
                        return;
                    case 2:
                        com.tencent.mm.sdk.i.e.a(new a(pVar, kVar3), "RecordMsgSendService_chatDataCopy");
                        return;
                    default:
                        pVar.ipo = false;
                        return;
                }
            }

            public final String toString() {
                return super.toString() + "|run";
            }
        });
    }

    final void b(k kVar) {
        if (!this.ips.contains(kVar)) {
            this.ips.add(kVar);
        }
    }

    final void finish() {
        this.ips.clear();
        this.ipr.clear();
        this.ipo = false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.RecordMsgSendService", "on scene end, errType %d errCode %d errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (kVar == null) {
            v.w("MicroMsg.RecordMsgSendService", "on scene end, scene is null");
            return;
        }
        switch (kVar.getType()) {
            case 632:
                v.d("MicroMsg.RecordMsgSendService", "batch tran cdn callback, errType %d, errCode %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                a aVar = (a) kVar;
                if (i == 0 && i2 == 0) {
                    ak.yW();
                    at ek = com.tencent.mm.model.c.wJ().ek(aVar.ipl.field_msgId);
                    if (ek.field_msgId == aVar.ipl.field_msgId) {
                        ek.setContent(aVar.ipk);
                        ek.dh(1);
                        ak.yW();
                        com.tencent.mm.model.c.wJ().a(aVar.ipl.field_msgId, ek);
                    }
                    com.tencent.mm.q.a dz = am.bnC().dz(aVar.ipl.field_msgId);
                    if (dz != null) {
                        dz.field_xml = ek.field_content;
                        am.bnC().a(dz, new String[]{"msgId"});
                    }
                    s.aJD().oL(aVar.ipl.field_localId);
                    this.ipr.remove(aVar.ipl.field_localId);
                    am.bnE();
                    com.tencent.mm.pluginsdk.model.app.al.a.dC(aVar.ipl.field_msgId);
                    v.d("MicroMsg.RecordMsgSendService", "batch tran cdn ok, msgId[%d], recordLocalId[%d], begin send appmsg", new Object[]{Long.valueOf(aVar.ipl.field_msgId), Integer.valueOf(aVar.ipl.field_localId)});
                    break;
                }
                v.w("MicroMsg.RecordMsgSendService", "batch tran cdn fail, msgId[%d], recordLocalId[%d]", new Object[]{Long.valueOf(aVar.ipl.field_msgId), Integer.valueOf(aVar.ipl.field_localId)});
                v.w("MicroMsg.RecordMsgSendService", "try upload from local");
                Iterator it = aVar.ipl.field_dataProto.mtR.iterator();
                while (it.hasNext()) {
                    String c;
                    pw pwVar = (pw) it.next();
                    if (pwVar.msn > 0) {
                        c = m.c(pwVar.luu, aVar.ipl.field_msgId, false);
                        if (s.aJE().yx(c) == null) {
                            g gVar = new g();
                            gVar.field_cdnKey = pwVar.mrU;
                            gVar.field_cdnUrl = pwVar.mrS;
                            gVar.field_dataId = pwVar.luu;
                            gVar.field_mediaId = c;
                            gVar.field_totalLen = (int) pwVar.msn;
                            gVar.field_localId = gVar.field_mediaId.hashCode();
                            gVar.field_path = m.c(pwVar, aVar.ipl.field_msgId);
                            gVar.field_type = 2;
                            gVar.field_fileType = m.oM(pwVar.aKG);
                            gVar.field_recordLocalId = aVar.ipl.field_localId;
                            gVar.field_toUser = aVar.ipl.field_toUser;
                            gVar.field_isThumb = false;
                            boolean a = s.aJE().a(gVar);
                            v.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(gVar.field_localId), Boolean.valueOf(a)});
                        }
                    }
                    if (pwVar.msy > 0) {
                        c = m.sX(pwVar.luu);
                        String c2 = m.c(c, aVar.ipl.field_msgId, false);
                        if (s.aJE().yx(c2) == null) {
                            g gVar2 = new g();
                            gVar2.field_cdnKey = pwVar.mrO;
                            gVar2.field_cdnUrl = pwVar.coj;
                            gVar2.field_dataId = c;
                            gVar2.field_mediaId = c2;
                            gVar2.field_totalLen = (int) pwVar.msy;
                            gVar2.field_localId = gVar2.field_mediaId.hashCode();
                            gVar2.field_path = m.f(pwVar, aVar.ipl.field_msgId);
                            gVar2.field_type = 2;
                            gVar2.field_fileType = com.tencent.mm.modelcdntran.b.MediaType_FULLSIZEIMAGE;
                            gVar2.field_recordLocalId = aVar.ipl.field_localId;
                            gVar2.field_toUser = aVar.ipl.field_toUser;
                            gVar2.field_isThumb = true;
                            boolean a2 = s.aJE().a(gVar2);
                            v.d("MicroMsg.RecordMsgSendService", "insert localId[%d] result[%B]", new Object[]{Integer.valueOf(gVar2.field_localId), Boolean.valueOf(a2)});
                        }
                    }
                }
                s.aJG().run();
                return;
                break;
        }
        this.ipo = false;
        a(null);
    }

    public final void a(int i, g gVar) {
        if (1 != i) {
            v.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care type %d", new Object[]{Integer.valueOf(i)});
        } else if (gVar == null) {
            v.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo is null");
        } else if (2 != gVar.field_type) {
            v.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but cdninfo type is not upload");
        } else if (gVar.field_status == 0 || 1 == gVar.field_status) {
            v.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but not care status");
        } else {
            Object obj;
            i aJE = s.aJE();
            int i2 = gVar.field_recordLocalId;
            List<g> linkedList = new LinkedList();
            Cursor rawQuery = aJE.cie.rawQuery("SELECT * FROM RecordCDNInfo WHERE recordLocalId = " + i2, null);
            if (rawQuery != null) {
                rawQuery.moveToFirst();
                while (!rawQuery.isAfterLast()) {
                    g gVar2 = new g();
                    gVar2.b(rawQuery);
                    linkedList.add(gVar2);
                    rawQuery.moveToNext();
                }
                rawQuery.close();
            }
            v.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[]{Integer.valueOf(linkedList.size())});
            for (g gVar3 : linkedList) {
                if (gVar3.field_status != 0) {
                    if (1 == gVar3.field_status) {
                    }
                }
                v.w("MicroMsg.RecordMsgSendService", "on cdn storage changed, but %s not finish", new Object[]{gVar3.field_mediaId});
                obj = null;
            }
            int i3 = 1;
            if (obj != null) {
                k kVar;
                l aJD = s.aJD();
                v.d("MicroMsg.RecordMsgStorage", "get by local id, sql[%s], local[%d]", new Object[]{"SELECT * FROM RecordMessageInfo WHERE localId=" + gVar.field_recordLocalId, Integer.valueOf(r1)});
                Cursor rawQuery2 = aJD.cie.rawQuery(r2, null);
                if (rawQuery2 == null || !rawQuery2.moveToFirst()) {
                    kVar = null;
                } else {
                    k kVar2 = new k();
                    kVar2.b(rawQuery2);
                    kVar = kVar2;
                }
                if (rawQuery2 != null) {
                    rawQuery2.close();
                }
                String str = "MicroMsg.RecordMsgSendService";
                String str2 = "finish get record info, id %d result %B";
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(gVar.field_recordLocalId);
                objArr[1] = Boolean.valueOf(kVar != null);
                v.d(str, str2, objArr);
                if (kVar != null) {
                    List<pw> list = kVar.field_dataProto.mtR;
                    for (g gVar4 : linkedList) {
                        v.v("MicroMsg.RecordMsgSendService", "check dataid[%s] isThumb[%B]", new Object[]{gVar4.field_dataId, Boolean.valueOf(gVar4.field_isThumb)});
                        if (!gVar4.field_isThumb) {
                            for (pw pwVar : list) {
                                if (gVar4.field_dataId.equals(pwVar.luu)) {
                                    v.d("MicroMsg.RecordMsgSendService", "match data, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[]{pwVar.mrU, gVar4.field_cdnKey, pwVar.mrS, gVar4.field_cdnUrl, Long.valueOf(pwVar.msn), Integer.valueOf(gVar4.field_totalLen)});
                                    pwVar.IB(gVar4.field_cdnKey);
                                    pwVar.IA(gVar4.field_cdnUrl);
                                    break;
                                }
                            }
                        }
                        for (pw pwVar2 : list) {
                            if (gVar4.field_dataId.equals(m.sX(pwVar2.luu))) {
                                v.d("MicroMsg.RecordMsgSendService", "match thumb, old key[%s] new key[%s], old url[%s] new url[%s], old size[%d] new size[%d]", new Object[]{pwVar2.mrO, gVar4.field_cdnKey, pwVar2.coj, gVar4.field_cdnUrl, Long.valueOf(pwVar2.msy), Integer.valueOf(gVar4.field_totalLen)});
                                pwVar2.Iz(gVar4.field_cdnKey);
                                pwVar2.Iy(gVar4.field_cdnUrl);
                                break;
                            }
                        }
                    }
                    ak.yW();
                    at ek = com.tencent.mm.model.c.wJ().ek(kVar.field_msgId);
                    v.i("MicroMsg.RecordMsgSendService", "update msg content, msg null ? %B, msgId %d recordInfoId %d", new Object[]{Boolean.valueOf(false), Long.valueOf(ek.field_msgId), Long.valueOf(kVar.field_msgId)});
                    if (ek.field_msgId == kVar.field_msgId) {
                        ek.setContent(m.b(kVar.field_title, kVar.field_desc, list, kVar.field_favFrom));
                        ek.dh(1);
                        ak.yW();
                        com.tencent.mm.model.c.wJ().a(kVar.field_msgId, ek);
                    }
                    com.tencent.mm.q.a dz = am.bnC().dz(kVar.field_msgId);
                    if (dz != null) {
                        dz.field_xml = ek.field_content;
                        am.bnC().a(dz, new String[]{"msgId"});
                    }
                    s.aJD().oL(kVar.field_localId);
                    this.ipr.remove(kVar.field_localId);
                    am.bnE();
                    com.tencent.mm.pluginsdk.model.app.al.a.dC(kVar.field_msgId);
                }
                for (g gVar32 : linkedList) {
                    s.aJE().a(gVar32, "localId");
                }
                this.ipo = false;
                a(null);
            }
        }
    }
}
