package com.tencent.mm.plugin.qqmail.b;

import android.util.Base64;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.bbz;
import com.tencent.mm.protocal.c.ka;
import com.tencent.mm.protocal.c.lp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.k;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public final class w implements com.tencent.mm.v.e {
    String bhM;
    String[] iaY;
    String[] iaZ;
    String iav;
    e ibJ = null;
    String ibL;
    Map<String, String> ibM = new HashMap();
    Map<String, String> ibN = new LinkedHashMap();
    Map<String, String> ibO = new LinkedHashMap();
    private b ibP;
    public u ibQ;
    Map<String, String> ibR = new HashMap();
    f ibS = null;
    HashMap<Long, Integer> ibT = new HashMap();
    HashMap<Long, String> ibU = new HashMap();
    HashMap<String, Integer> ibV = new HashMap();
    int ibW = 0;
    ArrayList<g> ibX = new ArrayList();
    String ibY = null;
    String ibZ = null;
    String[] iba;
    HashMap<String, String> ica = new HashMap();
    c icb;
    d icc;
    int icd = 0;
    com.tencent.mm.v.f ice = new com.tencent.mm.v.f(this) {
        final /* synthetic */ w icf;

        {
            this.icf = r1;
        }

        public final void a(int i, int i2, k kVar) {
            v.i("MicroMsg.ShareModeMailAppService", "currentSendFile: %s, offset: %d, totalLen: %d, filesInfo.size: %d", new Object[]{this.icf.ibY, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.icf.ibX.size())});
            if (i >= i2) {
                this.icf.ica.put(this.icf.ibZ, ((p) kVar).aHz().mon);
                bbz aHz = ((p) kVar).aHz();
                if (this.icf.icc != null) {
                    this.icf.icc.c(this.icf.icd - this.icf.ibX.size(), this.icf.icd, this.icf.ibZ, aHz.mon);
                }
                if (this.icf.ibX.isEmpty()) {
                    v.i("MicroMsg.ShareModeMailAppService", "finished send all files");
                    if (this.icf.icb != null) {
                        this.icf.icb.aHD();
                        return;
                    }
                    return;
                }
                v.i("MicroMsg.ShareModeMailAppService", "finished send one file, continue to send another one");
                g gVar = (g) this.icf.ibX.remove(0);
                this.icf.ibY = gVar.bhO;
                this.icf.ibZ = gVar.aST;
                ak.vy().a(new p(this.icf.ibZ, this.icf.ibY, this), 0);
            }
        }
    };

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int cNh = 100;
        final /* synthetic */ int dKT;
        final /* synthetic */ w icf;

        AnonymousClass1(w wVar, int i, int i2) {
            this.icf = wVar;
            this.dKT = i;
        }

        public final void run() {
            this.icf.ibS.C(this.icf.iav, this.dKT, this.cNh);
        }
    }

    interface a {
        void aHE();
    }

    public interface b {
        void a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap);
    }

    public interface c {
        void aHD();
    }

    public interface d {
        void c(int i, int i2, String str, String str2);
    }

    public interface e {
        void yf(String str);
    }

    public interface f {
        void C(String str, int i, int i2);
    }

    public static class g {
        public String aST;
        public String bhO;

        public g(String str, String str2) {
            this.bhO = str;
            this.aST = str2;
        }
    }

    static /* synthetic */ void a(w wVar, HashMap hashMap) {
        if (wVar.ibR == null) {
            wVar.ibR = new HashMap();
        }
        for (Long l : hashMap.keySet()) {
            String str = (String) hashMap.get(l);
            String str2 = (String) wVar.ibM.get(String.valueOf(l));
            v.i("MicroMsg.ShareModeMailAppService", "appendDownloadImgToAttachIdMap, filePath: %s, attachId: %s", new Object[]{str2, str});
            if (!be.kS(str2)) {
                wVar.ibR.put(str2, str);
            }
        }
    }

    public w() {
        ak.vy().a(483, this);
        ak.vy().a(484, this);
        ak.vy().a(485, this);
    }

    public final void ox(int i) {
        if (this.ibS != null) {
            ad.o(new AnonymousClass1(this, i, 100));
        }
    }

    public final void a(f fVar, e eVar) {
        this.ibS = fVar;
        this.ibJ = eVar;
        if (this.ibM.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.ibM.keySet()) {
                v.i("MicroMsg.ShareModeMailAppService", "check img status, msgSvrId: %s", new Object[]{str});
                arrayList.add(Long.valueOf(be.getLong(str, 0)));
            }
            b anonymousClass2 = new b(this) {
                final /* synthetic */ w icf;

                {
                    this.icf = r1;
                }

                public final void a(ArrayList<Long> arrayList, HashMap<Long, String> hashMap) {
                    w wVar;
                    v.i("MicroMsg.ShareModeMailAppService", "finishChckImgStatus, notUploadedImgIdList.size: %d, attachIdMap.size: %d", new Object[]{Integer.valueOf(arrayList.size()), Integer.valueOf(hashMap.size())});
                    if (arrayList.size() > 0) {
                        wVar = this.icf;
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str = (String) wVar.ibM.get(String.valueOf((Long) it.next()));
                            v.i("MicroMsg.ShareModeMailAppService", "appendAllUndownloadImage, filePath: %s", new Object[]{str});
                            if (!be.kS(str)) {
                                if (wVar.ibX == null) {
                                    wVar.ibX = new ArrayList();
                                }
                                wVar.ibX.add(new g(str, str));
                            }
                        }
                    }
                    if (hashMap.size() > 0) {
                        w.a(this.icf, (HashMap) hashMap);
                    }
                    this.icf.ox(10);
                    wVar = this.icf;
                    v.i("MicroMsg.ShareModeMailAppService", "uploadMsgImg, filesInfo.size = %d", new Object[]{Integer.valueOf(wVar.ibX.size())});
                    if (wVar.ibX == null) {
                        wVar.ibX = new ArrayList();
                    }
                    if (wVar.ibX.size() > 0) {
                        c anonymousClass3 = new c(wVar) {
                            final /* synthetic */ w icf;

                            {
                                this.icf = r1;
                            }

                            public final void aHD() {
                                v.d("MicroMsg.ShareModeMailAppService", "uploadMsgImg, finshed upload all msg img");
                                this.icf.ox(90);
                                w wVar = this.icf;
                                if (wVar.ibX != null && wVar.ibX.size() > 0) {
                                    wVar.ibX.clear();
                                }
                                this.icf.aHC();
                            }
                        };
                        d anonymousClass4 = new d(wVar) {
                            final /* synthetic */ w icf;

                            {
                                this.icf = r1;
                            }

                            public final void c(int i, int i2, String str, String str2) {
                                v.d("MicroMsg.ShareModeMailAppService", "finishedSendOneFile, currentFileCount: %d, totalFileNum: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                                this.icf.ibR.put(str, str2);
                                this.icf.ox((int) (10.0f + (80.0f * (((float) i) / ((float) i2)))));
                            }
                        };
                        v.i("MicroMsg.ShareModeMailAppService", "uploadFile, filesInfo.size: %d", new Object[]{Integer.valueOf(wVar.ibX.size())});
                        wVar.icb = anonymousClass3;
                        wVar.icc = anonymousClass4;
                        wVar.icd = wVar.ibX.size();
                        if (wVar.ibX != null && wVar.ibX.size() > 0) {
                            g gVar = (g) wVar.ibX.remove(0);
                            wVar.ibY = gVar.bhO;
                            wVar.ibZ = gVar.aST;
                            wVar.ica = new HashMap();
                            ak.vy().a(new p(wVar.ibZ, wVar.ibY, wVar.ice), 0);
                            return;
                        }
                        return;
                    }
                    wVar.ox(90);
                    wVar.aHC();
                }
            };
            v.i("MicroMsg.ShareModeMailAppService", "checkImgStatus");
            this.ibW = 0;
            L(arrayList);
            if (this.ibU != null) {
                this.ibU.clear();
                this.ibU = null;
            }
            this.ibU = new HashMap();
            this.ibP = anonymousClass2;
            ak.vy().a(new l(arrayList), 0);
            return;
        }
        ox(90);
        aHC();
    }

    final void aHC() {
        int i;
        int i2;
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr;
        int i3;
        StringBuilder stringBuilder;
        String stringBuilder2;
        int i4 = 0;
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr2 = null;
        if (this.ibN != null && this.ibN.size() > 0) {
            com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr3 = new com.tencent.mm.plugin.qqmail.b.k.a[this.ibN.size()];
            int i5 = 0;
            i = 0;
            for (String str : this.ibN.keySet()) {
                com.tencent.mm.plugin.qqmail.b.k.a aVar = new com.tencent.mm.plugin.qqmail.b.k.a();
                aVar.ibe = (String) this.ibN.get(str);
                aVar.aST = str;
                aVar.name = (String) this.ibO.get(str);
                aVar.fileSize = com.tencent.mm.a.e.aQ(str);
                aVarArr3[i] = aVar;
                v.i("MicroMsg.ShareModeMailAppService", "fileInfos[%d], attachId: %s, fileName: %s, name: %s, fileSize: %d", new Object[]{Integer.valueOf(i), aVar.ibe, aVar.aST, aVar.name, Integer.valueOf(aVar.fileSize)});
                i5 = aVar.fileSize + i5;
                i++;
            }
            i4 = i5;
            aVarArr2 = aVarArr3;
        }
        if (this.ibR == null || this.ibR.size() <= 0) {
            i2 = i4;
            aVarArr = null;
        } else {
            com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr4 = new com.tencent.mm.plugin.qqmail.b.k.a[this.ibR.size()];
            i = i4;
            i3 = 0;
            for (String str2 : this.ibR.keySet()) {
                com.tencent.mm.plugin.qqmail.b.k.a aVar2 = new com.tencent.mm.plugin.qqmail.b.k.a();
                aVar2.ibe = (String) this.ibR.get(str2);
                aVar2.aST = str2;
                aVar2.fileSize = be.a((Integer) this.ibV.get(aVar2.ibe), 0);
                if (aVar2.fileSize == 0) {
                    aVar2.fileSize = com.tencent.mm.a.e.aQ(str2);
                }
                aVarArr4[i3] = aVar2;
                v.i("MicroMsg.ShareModeMailAppService", "imagesFileInfos[%d], attachId: %s, fileName: %s, fileSize: %d", new Object[]{Integer.valueOf(i3), aVar2.ibe, aVar2.aST, Integer.valueOf(aVar2.fileSize)});
                i = aVar2.fileSize + i;
                i3++;
            }
            aVarArr = aVarArr4;
            i2 = i;
        }
        v.i("MicroMsg.ShareModeMailAppService", "totalFileSize = %d", new Object[]{Integer.valueOf(i2)});
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr5 = (aVarArr == null || aVarArr.length == 0) ? null : aVarArr;
        com.tencent.mm.plugin.qqmail.b.k.a[] aVarArr6 = (aVarArr2 == null || aVarArr2.length == 0) ? null : aVarArr2;
        final a anonymousClass5 = new a(this) {
            final /* synthetic */ w icf;

            {
                this.icf = r1;
            }

            public final void aHE() {
                this.icf.ox(100);
            }
        };
        k kVar = new k(this.bhM, this.iaY, this.iaZ, this.iba, this.iav);
        kVar.ibb = this.ibL;
        if (aVarArr6 == null || aVarArr6.length <= 0) {
            kVar.ibd = null;
        } else {
            kVar.ibd = new com.tencent.mm.plugin.qqmail.b.k.a[aVarArr6.length];
            int i6;
            for (i6 = 0; i6 < kVar.ibd.length; i6++) {
                kVar.ibd[i6] = aVarArr6[i6];
            }
            v.i("MicroMsg.MailContentFormatter", "setFileInfo, fileInfos.length = %d", new Object[]{Integer.valueOf(kVar.ibd.length)});
        }
        if (aVarArr5 == null || aVarArr5.length <= 0) {
            kVar.ibc = null;
        } else {
            kVar.ibc = aVarArr5;
        }
        StringBuilder stringBuilder3 = new StringBuilder("");
        StringBuilder stringBuilder4 = new StringBuilder("");
        if (kVar.bhM != null) {
            stringBuilder = new StringBuilder("");
            stringBuilder.append("From: ");
            stringBuilder.append("\"");
            stringBuilder.append("=?utf-8?B?");
            stringBuilder.append(Base64.encodeToString(kVar.bhM.getBytes(), 2));
            stringBuilder.append("?=");
            stringBuilder.append("\"");
            stringBuilder.append(" ");
            stringBuilder.append("<");
            stringBuilder.append(kVar.bhM);
            stringBuilder.append(">");
            stringBuilder2 = stringBuilder.toString();
        } else {
            stringBuilder2 = null;
        }
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.aHw();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.aHx();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder2 = kVar.aHy();
        if (stringBuilder2 != null) {
            stringBuilder4.append(stringBuilder2);
            stringBuilder4.append("\n");
        }
        stringBuilder4.append("Subject: ");
        if (kVar.iav != null) {
            stringBuilder4.append(kVar.iav);
        }
        stringBuilder4.append("\n");
        stringBuilder4.append("Mime-Version: 1.0");
        stringBuilder4.append("\n");
        stringBuilder4.append("Content-Type: multipart/mixed;boundary=\"----=_NextPart_5208D22F_0929AFA8_5112E4AB\"");
        stringBuilder4.append("\n");
        stringBuilder4.append("Content-Transfer-Encoding: 8Bit");
        stringBuilder4.append("\n");
        stringBuilder4.append("Date: " + new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", new Locale("en")).format(new Date()));
        stringBuilder4.append("\n");
        stringBuilder4.append("X-QQ-MIME: TCMime 1.0 by Tencent");
        stringBuilder4.append("\n");
        stringBuilder4.append("X-Mailer: QQMail 2.x");
        stringBuilder4.append("\n");
        stringBuilder4.append("X-QQ-Mailer: QQMail 2.x");
        stringBuilder4.append("\n");
        stringBuilder3.append(stringBuilder4.toString());
        stringBuilder3.append("\r\n");
        stringBuilder3.append("This is a multi-part message in MIME format.");
        stringBuilder3.append("\n");
        stringBuilder3.append("\r\n");
        stringBuilder = new StringBuilder("");
        stringBuilder.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
        stringBuilder.append("\n");
        stringBuilder.append("Content-Type:text/html;charset=\"utf-8\"");
        stringBuilder.append("\n");
        stringBuilder.append("Content-Transfer-Encoding:base64");
        stringBuilder.append("\n");
        stringBuilder.append("\r\n");
        stringBuilder.append(Base64.encodeToString(kVar.ibb.getBytes(), 0));
        stringBuilder.append("\n");
        stringBuilder3.append(stringBuilder.toString());
        stringBuilder3.append("\r\n");
        if (kVar.ibc != null && kVar.ibc.length > 0) {
            for (com.tencent.mm.plugin.qqmail.b.k.a aVar3 : kVar.ibc) {
                String str3 = aVar3.ibe;
                String str4 = aVar3.aST;
                int i7 = aVar3.fileSize;
                StringBuilder stringBuilder5 = new StringBuilder("");
                stringBuilder5.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("Content-Type:image/jpeg;name=\"%s\"", new Object[]{str4}));
                stringBuilder5.append("\n");
                stringBuilder5.append("Content-Transfer-Encoding:base64");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("Content-ID:<%s>", new Object[]{str4}));
                stringBuilder5.append("\n");
                stringBuilder5.append("\r\n");
                stringBuilder5.append(String.format("QQMail-LinkID:%s", new Object[]{str3}));
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i7)}));
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-LineLen:72");
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-BreakType:1");
                stringBuilder5.append("\n");
                stringBuilder5.append(String.format("QQMail-Key:%s", new Object[]{k.yc(str3)}));
                stringBuilder5.append("\n");
                stringBuilder5.append("QQMail-LinkEnd");
                stringBuilder5.append("\n");
                stringBuilder3.append(stringBuilder5.toString());
                stringBuilder3.append("\r\n");
            }
        }
        stringBuilder3.append("\r\n");
        if (kVar.ibd != null && kVar.ibd.length > 0) {
            for (com.tencent.mm.plugin.qqmail.b.k.a aVar4 : kVar.ibd) {
                String str5 = aVar4.ibe;
                int i8 = aVar4.fileSize;
                String str6 = aVar4.name;
                StringBuilder stringBuilder6 = new StringBuilder("");
                stringBuilder6.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-Type:application/octet-stream;charset=\"utf-8\";name=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str6.getBytes(), 2)}));
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-Disposition: attachment; filename=\"=?utf-8?B?%s?=\"", new Object[]{Base64.encodeToString(str6.getBytes(), 2)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("Content-Transfer-Encoding:base64");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("Content-ID:<%s>", new Object[]{Long.valueOf(System.currentTimeMillis())}));
                stringBuilder6.append("\n");
                stringBuilder6.append("\r\n");
                stringBuilder6.append(String.format("QQMail-LinkID:%s", new Object[]{str5}));
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("QQMail-LinkSize:%d", new Object[]{Integer.valueOf(i8)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-LineLen:72");
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-BreakType:1");
                stringBuilder6.append("\n");
                stringBuilder6.append(String.format("QQMail-Key:%s", new Object[]{k.yc(str5)}));
                stringBuilder6.append("\n");
                stringBuilder6.append("QQMail-LinkEnd");
                stringBuilder6.append("\n");
                stringBuilder3.append(stringBuilder6.toString());
                stringBuilder3.append("\r\n");
            }
        }
        stringBuilder3.append("------=_NextPart_5208D22F_0929AFA8_5112E4AB--");
        ak.vy().a(new m(stringBuilder3.toString(), this.bhM, this.iaY, i2, new com.tencent.mm.v.f(this) {
            final /* synthetic */ w icf;

            public final void a(int i, int i2, k kVar) {
                v.i("MicroMsg.ShareModeMailAppService", "composeSend, offset: %d, totalLen: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                if (i >= i2) {
                    v.i("MicroMsg.ShareModeMailAppService", "finish send");
                    if (anonymousClass5 != null) {
                        anonymousClass5.aHE();
                    }
                }
            }
        }), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        v.i("MicroMsg.ShareModeMailAppService", "onSceneEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i != 0 || i2 != 0) {
            v.e("MicroMsg.ShareModeMailAppService", "errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            if (kVar.getType() == 483) {
                a((l) kVar);
            } else if (this.ibJ != null) {
                ad.o(new Runnable(this) {
                    final /* synthetic */ w icf;

                    {
                        this.icf = r1;
                    }

                    public final void run() {
                        this.icf.ibJ.yf(this.icf.iav);
                    }
                });
            }
        } else if (kVar.getType() == 483) {
            a((l) kVar);
        } else if (kVar.getType() != 484) {
            kVar.getType();
        }
    }

    private void L(ArrayList<Long> arrayList) {
        if (this.ibT != null) {
            this.ibT.clear();
            this.ibT = null;
        }
        this.ibT = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.ibT.put(Long.valueOf(((Long) it.next()).longValue()), Integer.valueOf(1));
        }
    }

    private static ArrayList<Long> e(HashMap<Long, Integer> hashMap) {
        ArrayList<Long> arrayList = new ArrayList();
        for (Long add : hashMap.keySet()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    private void a(l lVar) {
        this.ibW++;
        v.i("MicroMsg.ShareModeMailAppService", "processCheckImgStatusSceneEnd, checkTimes: %d", new Object[]{Integer.valueOf(this.ibW)});
        Iterator it = ((ka) lVar.cif.czl.czs).mmx.iterator();
        while (it.hasNext()) {
            lp lpVar = (lp) it.next();
            long j = (long) lpVar.mbT;
            int i = lpVar.eeO;
            if (this.ibT.containsKey(Long.valueOf(j))) {
                v.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, status: %d", new Object[]{Long.valueOf(j), Integer.valueOf(i)});
                if (i == 0) {
                    this.ibT.remove(Long.valueOf(j));
                    if (lpVar.mon != null) {
                        v.i("MicroMsg.ShareModeMailAppService", "msgSvrId: %d, attachId: %s", new Object[]{Long.valueOf(j), lpVar.mon});
                        this.ibU.put(Long.valueOf(j), lpVar.mon);
                        this.ibV.put(lpVar.mon, Integer.valueOf(lpVar.moo));
                    }
                } else {
                    this.ibT.put(Long.valueOf(j), Integer.valueOf(i));
                }
            }
        }
        if (this.ibT.isEmpty()) {
            v.i("MicroMsg.ShareModeMailAppService", "all image is in server");
            if (this.ibP != null) {
                this.ibP.a(new ArrayList(), this.ibU);
            }
        } else if (this.ibW < 3) {
            v.i("MicroMsg.ShareModeMailAppService", "checkTime small than limit, doScene again");
            ak.vy().a(new l(e(this.ibT)), 0);
        } else {
            this.ibP.a(e(this.ibT), this.ibU);
        }
    }
}
