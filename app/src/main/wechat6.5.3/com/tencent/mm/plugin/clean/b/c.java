package com.tencent.mm.plugin.clean.b;

import android.database.Cursor;
import android.os.Looper;
import android.os.StatFs;
import com.tencent.mm.a.e;
import com.tencent.mm.ae.n;
import com.tencent.mm.as.k;
import com.tencent.mm.as.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public final class c implements com.tencent.mm.plugin.clean.b.a.a.a, Runnable {
    private static final Long eUo = Long.valueOf(604800000);
    private static final Long eUp = Long.valueOf(7776000000L);
    private static final int eUq = (com.tencent.mm.model.c.xq().length() - 1);
    private ac cnC = new ac(Looper.getMainLooper());
    private com.tencent.mm.plugin.clean.b.a.b eUr;
    private f eUs;
    private int eUt = 0;
    private int eUu = 0;
    public boolean eUv;
    private ConcurrentHashMap<String, b> eUw = new ConcurrentHashMap();
    private long eUx;
    private long eUy;
    private long endTime = 0;
    private long startTime = 0;

    public class a extends com.tencent.mm.plugin.clean.b.a.a {
        final /* synthetic */ c eUA;
        private String username;

        public a(c cVar, String str) {
            this.eUA = cVar;
            super(cVar);
            this.username = str;
        }

        public final void execute() {
            ak.yW();
            Cursor MQ = com.tencent.mm.model.c.wJ().MQ(this.username);
            if (MQ.moveToFirst()) {
                b bVar = new b();
                bVar.username = this.username;
                bVar.eUn = new ArrayList();
                bVar.beE = 0;
                a aVar = null;
                while (!MQ.isAfterLast()) {
                    at atVar = new at();
                    atVar.b(MQ);
                    switch (l.tD(atVar.field_type)) {
                        case 3:
                            aVar = c.a(this.eUA, atVar, this.username);
                            break;
                        case 43:
                        case 44:
                        case 62:
                            aVar = c.b(atVar, this.username);
                            break;
                        case 49:
                            aVar = c.a(atVar, this.username);
                            break;
                    }
                    if (aVar != null) {
                        bVar.eUn.add(aVar);
                        bVar.beE += aVar.size;
                        aVar = null;
                    }
                    if (MQ.moveToNext()) {
                        if (this.eUA.eUv) {
                        }
                    }
                    MQ.close();
                    if (bVar.eUn.size() > 0) {
                        this.eUA.eUw.put(this.username, bVar);
                    }
                    v.i("MicroMsg.CleanController", "Finish user:%s", new Object[]{this.username});
                    return;
                }
                MQ.close();
                if (bVar.eUn.size() > 0) {
                    this.eUA.eUw.put(this.username, bVar);
                }
                v.i("MicroMsg.CleanController", "Finish user:%s", new Object[]{this.username});
                return;
            }
            v.d("MicroMsg.CleanController", "Message count of user:%s is empty", new Object[]{this.username});
            MQ.close();
        }
    }

    class b extends com.tencent.mm.plugin.clean.b.a.a {
        final /* synthetic */ c eUA;
        private String filePath;

        public b(c cVar, String str) {
            this.eUA = cVar;
            super(cVar);
            this.filePath = str;
        }

        public final void execute() {
            String str = this.filePath;
            int i = (str.length() <= c.eUq || str.substring(c.eUq).indexOf("temp") != 0) ? 0 : 1;
            if (i != 0) {
                v.i("MicroMsg.CleanController", "Delete temp folder: %s", new Object[]{this.filePath});
                qR(this.filePath);
                File parentFile = new File(this.filePath).getParentFile();
                if (parentFile.list() == null || parentFile.list().length == 0) {
                    parentFile.delete();
                    return;
                }
                return;
            }
            qS(this.filePath);
        }

        private void qR(String str) {
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    for (String str2 : list) {
                        qR(str + File.separator + str2);
                    }
                }
                v.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[]{str});
                file.delete();
                return;
            }
            v.v("MicroMsg.CleanController", "delete file rootFile: %s", new Object[]{str});
            c.a(this.eUA, file.length());
            file.delete();
        }

        private void qS(String str) {
            int i = 0;
            if (str.endsWith(File.separator + "sns")) {
                v.i("MicroMsg.CleanController", "Scan sns folder: rootPath=%s", new Object[]{str});
                qT(str);
            } else if (str.endsWith(File.separator + "music")) {
                v.i("MicroMsg.CleanController", "Scan music folder: rootPath=%s", new Object[]{str});
                this.eUA.qP(str);
            } else {
                File file = new File(str);
                if (file.isDirectory()) {
                    String[] list = file.list();
                    if (list != null) {
                        int length = list.length;
                        while (i < length) {
                            qS(str + "/" + list[i]);
                            i++;
                        }
                        return;
                    }
                    return;
                }
                this.eUA.aO((long) e.aQ(str));
            }
        }

        private void qT(String str) {
            int i = 0;
            File file = new File(str);
            if (file.isDirectory()) {
                String[] list = file.list();
                if (list != null) {
                    int length = list.length;
                    while (i < length) {
                        qT(str + "/" + list[i]);
                        i++;
                    }
                }
            } else if (System.currentTimeMillis() - file.lastModified() > c.eUo.longValue()) {
                v.v("MicroMsg.CleanController", "Clean 7 days file in sns rootPath=%s", new Object[]{str});
                file.delete();
            } else {
                this.eUA.aO((long) e.aQ(str));
            }
        }
    }

    static /* synthetic */ long a(c cVar, long j) {
        long j2 = cVar.eUx + j;
        cVar.eUx = j2;
        return j2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.tencent.mm.plugin.clean.b.a a(com.tencent.mm.plugin.clean.b.c r11, com.tencent.mm.storage.at r12, java.lang.String r13) {
        /*
        r4 = 1;
        r0 = com.tencent.mm.ae.n.GH();
        r1 = r12.field_imgPath;
        r2 = r0.w(r1, r4);
        r0 = r12.field_isSend;
        if (r0 != r4) goto L_0x0023;
    L_0x000f:
        r0 = com.tencent.mm.ae.n.GH();
        r6 = r12.field_msgId;
        r1 = (int) r6;
        r6 = (long) r1;
        r0 = r0.ai(r6);
        r6 = r0.cLu;
        r8 = 0;
        r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r1 != 0) goto L_0x002d;
    L_0x0023:
        r0 = com.tencent.mm.ae.n.GH();
        r6 = r12.field_msgSvrId;
        r0 = r0.ah(r6);
    L_0x002d:
        r1 = 0;
        r3 = r12.field_isSend;
        if (r3 != r4) goto L_0x007e;
    L_0x0032:
        r3 = com.tencent.mm.ae.n.GH();
        r0 = r0.cLv;
        r5 = "";
        r6 = "";
        r3 = r3.l(r0, r5, r6);
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r0 != 0) goto L_0x007d;
    L_0x0048:
        r0 = com.tencent.mm.a.e.aR(r3);
        if (r0 == 0) goto L_0x007d;
    L_0x004e:
        r0 = "MicroMsg.CleanController";
        r1 = new java.lang.StringBuilder;
        r5 = "bigImgPath ";
        r1.<init>(r5);
        r1 = r1.append(r3);
        r5 = " ";
        r1 = r1.append(r5);
        r5 = com.tencent.mm.a.e.aQ(r3);
        r1 = r1.append(r5);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.v(r0, r1);
        r1 = new com.tencent.mm.plugin.clean.b.a;
        r6 = r12.field_msgId;
        r8 = r12.field_createTime;
        r5 = r13;
        r1.<init>(r2, r3, r4, r5, r6, r8);
    L_0x007d:
        return r1;
    L_0x007e:
        r3 = r0.Go();
        if (r3 == 0) goto L_0x007d;
    L_0x0084:
        r3 = com.tencent.mm.ae.n.GH();
        r5 = r0.cLv;
        r6 = "";
        r7 = "";
        r10 = r3.l(r5, r6, r7);
        r3 = "";
        r5 = r0.Gp();
        if (r5 == 0) goto L_0x00fc;
    L_0x009d:
        r5 = r0.Gp();
        if (r5 == 0) goto L_0x011b;
    L_0x00a3:
        r5 = com.tencent.mm.ae.n.GH();
        r6 = r0.cLE;
        r5 = r5.fC(r6);
        if (r5 == 0) goto L_0x011b;
    L_0x00af:
        if (r5 == 0) goto L_0x00fc;
    L_0x00b1:
        r0 = r5.equals(r0);
        if (r0 != 0) goto L_0x00fc;
    L_0x00b7:
        r0 = com.tencent.mm.ae.n.GH();
        r3 = r5.cLv;
        r5 = "";
        r6 = "";
        r3 = r0.l(r3, r5, r6);
        r0 = "MicroMsg.CleanController";
        r5 = new java.lang.StringBuilder;
        r6 = "hdPath ";
        r5.<init>(r6);
        r5 = r5.append(r3);
        r6 = " ";
        r5 = r5.append(r6);
        r6 = com.tencent.mm.a.e.aQ(r3);
        r5 = r5.append(r6);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.v.v(r0, r5);
        r0 = com.tencent.mm.a.e.aR(r3);
        if (r0 == 0) goto L_0x00fc;
    L_0x00f2:
        r1 = new com.tencent.mm.plugin.clean.b.a;
        r6 = r12.field_msgId;
        r8 = r12.field_createTime;
        r5 = r13;
        r1.<init>(r2, r3, r4, r5, r6, r8);
    L_0x00fc:
        r0 = com.tencent.mm.a.e.aR(r10);
        if (r0 == 0) goto L_0x007d;
    L_0x0102:
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r10);
        if (r0 != 0) goto L_0x007d;
    L_0x0108:
        r0 = r10.equals(r3);
        if (r0 != 0) goto L_0x007d;
    L_0x010e:
        r1 = new com.tencent.mm.plugin.clean.b.a;
        r6 = r12.field_msgId;
        r8 = r12.field_createTime;
        r3 = r10;
        r5 = r13;
        r1.<init>(r2, r3, r4, r5, r6, r8);
        goto L_0x007d;
    L_0x011b:
        r5 = r0;
        goto L_0x00af;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.clean.b.c.a(com.tencent.mm.plugin.clean.b.c, com.tencent.mm.storage.at, java.lang.String):com.tencent.mm.plugin.clean.b.a");
    }

    static /* synthetic */ a a(at atVar, String str) {
        String KK = be.KK(atVar.field_content);
        com.tencent.mm.q.a.a dV = KK != null ? com.tencent.mm.q.a.a.dV(KK) : null;
        if (dV == null) {
            v.e("MicroMsg.CleanController", "content is null");
            return null;
        }
        String w = n.GH().w(atVar.field_imgPath, true);
        com.tencent.mm.pluginsdk.model.app.b Gu;
        switch (dV.type) {
            case 2:
                Gu = am.Wf().Gu(dV.aXa);
                if ((Gu == null || !Gu.bnj()) && (atVar.field_isSend != 1 || Gu == null || !Gu.field_isUpload)) {
                    return null;
                }
                String str2 = Gu.field_fileFullPath;
                if (!e.aR(str2)) {
                    return null;
                }
                v.v("MicroMsg.CleanController", "image " + str2);
                return new a(w, str2, 1, str, atVar.field_msgId, atVar.field_createTime);
            case 6:
                Gu = am.Wf().Gu(dV.aXa);
                if ((Gu == null || !Gu.bnj()) && (atVar.field_isSend != 1 || Gu == null || !Gu.field_isUpload)) {
                    return null;
                }
                v.v("MicroMsg.CleanController", "full path " + Gu.field_fileFullPath);
                if (!e.aR(Gu.field_fileFullPath)) {
                    return null;
                }
                return new a(w, Gu.field_fileFullPath, 4, str, atVar.field_msgId, atVar.field_createTime);
            case 7:
                Gu = am.Wf().Gu(dV.aXa);
                if ((Gu == null || !Gu.bnj()) && (atVar.field_isSend != 1 || Gu == null || !Gu.field_isUpload)) {
                    return null;
                }
                v.v("MicroMsg.CleanController", "full path " + Gu.field_fileFullPath);
                if (!e.aR(Gu.field_fileFullPath)) {
                    return null;
                }
                return new a(w, Gu.field_fileFullPath, 4, str, atVar.field_msgId, atVar.field_createTime);
            default:
                return null;
        }
    }

    static /* synthetic */ a b(at atVar, String str) {
        k.KV();
        String lc = o.lc(atVar.field_imgPath);
        String str2 = atVar.field_imgPath;
        com.tencent.mm.as.n kZ = be.kS(str2) ? null : k.KV().kZ(str2);
        Object obj = (kZ == null || kZ.status == 199) ? 1 : null;
        k.KV();
        String ld = o.ld(atVar.field_imgPath);
        File file = new File(lc);
        if (obj == null || !file.exists()) {
            return null;
        }
        return new a(ld, lc, 3, str, atVar.field_msgId, atVar.field_createTime);
    }

    static {
        ak.yW();
    }

    public c(com.tencent.mm.plugin.clean.b.a.b bVar, f fVar) {
        this.eUs = fVar;
        this.eUr = bVar;
    }

    public final void run() {
        v.i("MicroMsg.CleanController", "Start to run clean controller");
        this.startTime = System.currentTimeMillis();
        String str = com.tencent.mm.compatible.util.e.cnj;
        v.v("MicroMsg.CleanController", "root path: %s", new Object[]{str});
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                for (String str2 : list) {
                    String str3 = str + str2;
                    if (str2.length() >= 32) {
                        v.v("MicroMsg.CleanController", "add subfile list: %s", new Object[]{str2});
                        Collection qQ = qQ(str3);
                        if (arrayList.size() > 0) {
                            arrayList.addAll(0, qQ);
                        } else {
                            arrayList.addAll(qQ);
                        }
                    } else {
                        v.v("MicroMsg.CleanController", "subfile: %s", new Object[]{str2});
                        if (arrayList.size() > 0) {
                            arrayList.add(0, str3);
                        } else {
                            arrayList.add(str3);
                        }
                    }
                }
            }
        } else {
            aO((long) e.aQ(str));
        }
        ArrayList adK = adK();
        this.eUt = arrayList.size() + adK.size();
        if (this.eUt == 0) {
            v.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=0");
            adH();
            return;
        }
        v.i("MicroMsg.CleanController", "Clean Controller totalTaskCount=%d", new Object[]{Integer.valueOf(this.eUt)});
        int i = 0;
        while (!this.eUv && i < arrayList.size()) {
            v.d("MicroMsg.CleanController", "while loop index=%d | filePath=%s", new Object[]{Integer.valueOf(i), (String) arrayList.get(i)});
            b bVar = new b(this, r0);
            while (!this.eUr.a(bVar)) {
                try {
                    Thread.sleep(2147483647L);
                } catch (InterruptedException e) {
                }
            }
            v.d("MicroMsg.CleanController", "Start task： filePath＝%s", new Object[]{r0});
            i++;
        }
        i = 0;
        while (!this.eUv && i < adK.size()) {
            v.d("MicroMsg.CleanController", "while loop index=%d | username=%s", new Object[]{Integer.valueOf(i), (String) adK.get(i)});
            a aVar = new a(this, r0);
            while (!this.eUr.a(aVar)) {
                try {
                    Thread.sleep(2147483647L);
                } catch (InterruptedException e2) {
                }
            }
            v.d("MicroMsg.CleanController", "Start task： user＝%s", new Object[]{r0});
            i++;
        }
    }

    public final void adG() {
        com.tencent.mm.sdk.i.e.H(this);
        this.eUu++;
        if (!(this.eUs == null || this.eUv)) {
            this.cnC.post(new Runnable(this) {
                final /* synthetic */ c eUA;

                {
                    this.eUA = r1;
                }

                public final void run() {
                    this.eUA.eUs.bu(this.eUA.eUu, this.eUA.eUt);
                }
            });
        }
        if (this.eUu == this.eUt) {
            adH();
        }
    }

    private void adH() {
        this.endTime = System.currentTimeMillis();
        v.i("MicroMsg.CleanController", "totalUserTime:%d", new Object[]{Long.valueOf(this.endTime - this.startTime)});
        if (this.eUs != null && !this.eUv) {
            final Object arrayList = new ArrayList();
            for (b add : this.eUw.values()) {
                arrayList.add(add);
            }
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            this.cnC.post(new Runnable(this) {
                final /* synthetic */ c eUA;

                public final void run() {
                    this.eUA.eUs.a(this.eUA.eUx, this.eUA.eUy, arrayList);
                }
            });
        }
    }

    public static long adI() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.e.cni);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getBlockCount());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    public static long adJ() {
        long blockSize;
        try {
            StatFs statFs = new StatFs(com.tencent.mm.compatible.util.e.cni);
            blockSize = ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Exception e) {
            blockSize = 0;
        }
        return blockSize <= 0 ? 1 : blockSize;
    }

    private static ArrayList<String> adK() {
        ArrayList<String> arrayList = new ArrayList();
        List linkedList = new LinkedList();
        for (Object add : m.crG) {
            linkedList.add(add);
        }
        ak.yW();
        Cursor b = com.tencent.mm.model.c.wK().b(m.crA, linkedList, "*");
        if (b.moveToFirst()) {
            do {
                ab abVar = new ab();
                abVar.b(b);
                if (!be.kS(abVar.field_username)) {
                    ak.yW();
                    if (!u.vd(com.tencent.mm.model.c.wH().LX(abVar.field_username).field_verifyFlag)) {
                        arrayList.add(abVar.field_username);
                    }
                }
                if (!b.moveToNext()) {
                    break;
                }
            } while (!b.isAfterLast());
        }
        b.close();
        return arrayList;
    }

    private void qP(String str) {
        int i = 0;
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list != null) {
                int length = list.length;
                while (i < length) {
                    qP(str + "/" + list[i]);
                    i++;
                }
            }
        } else if (System.currentTimeMillis() - file.lastModified() > eUp.longValue()) {
            v.v("MicroMsg.CleanController", "Clean 90 days file in music rootPath=%s", new Object[]{str});
            file.delete();
        } else {
            aO((long) e.aQ(str));
        }
    }

    private static ArrayList<String> qQ(String str) {
        ArrayList<String> arrayList = new ArrayList();
        File file = new File(str);
        if (file.isDirectory()) {
            String[] list = file.list();
            if (list == null || list.length <= 0) {
                arrayList.add(str);
            } else {
                for (String str2 : list) {
                    arrayList.add(str + File.separator + str2);
                }
            }
        } else {
            arrayList.add(str);
        }
        return arrayList;
    }

    private synchronized void aO(long j) {
        if (j < 0) {
            v.w("MicroMsg.CleanController", "summerclean file size[%d] overlimit ", new Object[]{Long.valueOf(j)});
            this.eUy += 60;
        } else {
            this.eUy += j;
        }
    }
}
