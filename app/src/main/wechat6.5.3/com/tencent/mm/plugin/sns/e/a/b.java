package com.tencent.mm.plugin.sns.e.a;

import com.tencent.mm.memory.n;
import com.tencent.mm.network.t;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.e.as;
import com.tencent.mm.plugin.sns.e.g;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class b extends j<String, Integer, Integer> {
    private static HashSet<String> joH = new HashSet();
    private int aYJ = -1;
    protected aib boL = null;
    private int dll = -1;
    private long dnsCostTime = -1;
    private int eha = 0;
    private int joA = 0;
    private long joB = -1;
    protected long joC = -1;
    protected long joD = -1;
    protected long joE = -1;
    protected String joF = "";
    protected int joG = 0;
    int joI = 0;
    protected a jou;
    protected n jov = null;
    protected a jow = null;
    private String jox = "";
    private String joy = "";
    private String joz = "";

    public interface a {
        void a(int i, aib com_tencent_mm_protocal_c_aib, int i2, boolean z, String str, int i3);
    }

    public abstract boolean a(InputStream inputStream, Map<String, List<String>> map);

    public abstract boolean aTk();

    public final /* synthetic */ Object aRX() {
        return aTl();
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        Integer num = (Integer) obj;
        super.onPostExecute(num);
        if (this.jow != null) {
            v.i("MicroMsg.SnsCdnDownloadBase", "download done result: %d, url:%s, mediaID:%s, totalSize: %d, runningTasksSize: %d", new Object[]{num, this.jow.url, this.jow.mediaId, Integer.valueOf(this.eha), Integer.valueOf(joH.size())});
            joH.remove(this.jow.jke);
            if (this.jow.joq && num.intValue() != 2) {
                as.AD(this.jow.mediaId);
                if (!ad.aSn()) {
                    System.currentTimeMillis();
                    if (this.jow.jdH.jdO == 4) {
                        v.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur thumb");
                        this.jov = com.tencent.mm.plugin.sns.lucky.b.a.cw(this.jow.getPath() + i.c(this.boL), this.jow.getPath() + i.e(this.boL));
                        ad.aSB().a(this.jow.mediaId, this.jov, this.jow.jdH.jdO);
                    } else if (this.jow.jdH.jdO == 5) {
                        v.i("MicroMsg.SnsCdnDownloadBase", "decodeType blur grid");
                        this.jov = com.tencent.mm.plugin.sns.lucky.b.a.cw(this.jow.getPath() + i.c(this.boL), this.jow.getPath() + i.f(this.boL));
                        ad.aSB().a(this.jow.mediaId, this.jov, this.jow.jdH.jdO);
                    } else if (this.jow.jdH.gKQ.size() <= 1) {
                        ad.aSB().a(this.jow.mediaId, this.jov, this.jow.jdH.jdO);
                    } else {
                        ad.aSB().a(this.jow.mediaId, this.jov, 0);
                        List linkedList = new LinkedList();
                        int i = 0;
                        while (i < this.jow.jdH.gKQ.size() && i < 4) {
                            aib com_tencent_mm_protocal_c_aib = (aib) this.jow.jdH.gKQ.get(i);
                            g aSB = ad.aSB();
                            n nVar = aSB.jiY == null ? null : (n) aSB.jiY.get("0-" + com_tencent_mm_protocal_c_aib.gID);
                            if (!i.b(nVar)) {
                                break;
                            }
                            linkedList.add(nVar);
                            v.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap from " + nVar + " " + com_tencent_mm_protocal_c_aib.gID);
                            i++;
                        }
                        this.jov = n.f(i.f(linkedList, ad.aSK()));
                        v.i("MicroMsg.SnsCdnDownloadBase", "merge bitmap " + this.jow.jdH.jdN + " " + this.jov);
                        ad.aSB().a(this.jow.jdH.jdN, this.jov, this.jow.jdH.jdO);
                    }
                    String str = null;
                    if (this.jow.jdH.jdO == 0) {
                        str = "0-" + this.jow.jdH.jdN;
                    } else if (this.jow.jdH.jdO == 1) {
                        str = "1-" + this.jow.jdH.jdN;
                    } else if (this.jow.jdH.jdO == 4) {
                        str = "4-" + this.jow.jdH.jdN;
                    } else if (this.jow.jdH.jdO == 5) {
                        str = "5-" + this.jow.jdH.jdN;
                    }
                    ad.aSB().Aj(str);
                }
            } else if (!this.jow.joq && this.jow.jos == 4) {
                ad.aSB().cy(this.jow.mediaId, this.jow.getPath() + i.i(this.boL));
            }
            this.jou.a(num.intValue(), this.boL, this.jow.jos, this.jow.joq, this.jow.jke, this.eha);
        }
    }

    public static boolean AR(String str) {
        if (joH.contains(i.ac(1, str)) || joH.contains(i.ac(5, str))) {
            return true;
        }
        return false;
    }

    public b(a aVar, a aVar2) {
        this.jou = aVar;
        this.jow = aVar2;
        if (aVar2 != null) {
            this.boL = aVar2.jfX;
            joH.add(aVar2.jke);
            aVar2.init();
        }
    }

    public boolean aTj() {
        return true;
    }

    public String AS(String str) {
        return str;
    }

    public t b(t tVar) {
        return tVar;
    }

    protected static boolean a(int i, long j, PString pString) {
        if (System.currentTimeMillis() - j < 1000) {
            return false;
        }
        pString.value += String.format("ts=%d&size=%d|", new Object[]{Long.valueOf(r2 / 1000), Integer.valueOf(i)});
        return true;
    }

    protected static void a(int i, long j, int i2, String str) {
        c Ls;
        int i3;
        v.i("MicroMsg.SnsCdnDownloadBase", "ready to report logbuffer(13346) packageRecordList:%s", new Object[]{str});
        switch (i2) {
            case 1:
                Ls = com.tencent.mm.model.c.c.Au().Ls("100105");
                break;
            case 2:
                Ls = com.tencent.mm.model.c.c.Au().Ls("100106");
                break;
            case 3:
                Ls = com.tencent.mm.model.c.c.Au().Ls("100100");
                break;
            default:
                return;
        }
        if (Ls.isValid()) {
            i3 = be.getInt((String) Ls.buX().get("needUploadData"), 1);
        } else {
            i3 = 0;
        }
        if (i3 != 0) {
            com.tencent.mm.modelsns.c cVar = new com.tencent.mm.modelsns.c();
            cVar.n("20ImgSize", i + ",");
            cVar.n("21NetType", (ak.isWifi(aa.getContext()) ? 1 : 0) + ",");
            cVar.n("22DelayTime", ",");
            cVar.n("23RetCode", ",");
            cVar.n("24DnsCostTime", ",");
            cVar.n("25ConnectCostTime", ",");
            cVar.n("26SendCostTime", ",");
            cVar.n("27WaitResponseCostTime", ",");
            cVar.n("28ReceiveCostTime", j + ",");
            cVar.n("29ClientAddrIP", ",");
            cVar.n("30ServerAddrIP", ",");
            cVar.n("31dnstype", ",");
            cVar.n("32signal", ",");
            cVar.n("33host", ",");
            cVar.n("34MediaType", i2 + ",");
            cVar.n("35X_Errno", ",");
            cVar.n("36MaxPackageSize", ",");
            cVar.n("37MaxPackageTimeStamp", ",");
            cVar.n("38PackageRecordList", str + ",");
            cVar.n("39ExpLayerId", ",");
            cVar.n("40ExpId", ",");
            cVar.n("41FeedId", ",");
            v.i("MicroMsg.SnsCdnDownloadBase", "report logbuffer(13480 TLMediaFielDownloadRecord): " + cVar.JH());
            com.tencent.mm.plugin.report.service.g.iuh.h(13480, new Object[]{cVar});
        }
    }

    private static boolean a(com.tencent.mm.storage.ak akVar, String str, long j, String str2) {
        if (str == null) {
            return false;
        }
        try {
            URL url = new URL(str);
            if (akVar == null || str2 == null || str2.indexOf(url.getHost()) == -1 || akVar.hrm == 0 || be.ax((long) akVar.hrm) <= j) {
                return false;
            }
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.SnsCdnDownloadBase", "error for check dcip %s", new Object[]{e.getMessage()});
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.Integer aTl() {
        /*
        r14 = this;
        com.tencent.mm.model.ak.yW();
        r0 = com.tencent.mm.model.c.isSDCardAvailable();
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r14.jow;
        if (r0 != 0) goto L_0x0017;
    L_0x000d:
        r0 = 0;
        r14.fT(r0);
        r0 = 2;
        r0 = java.lang.Integer.valueOf(r0);
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = r14.aTj();
        if (r0 == 0) goto L_0x003b;
    L_0x001d:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = r14.jow;
        r1 = r1.jka;
        r0 = r0.append(r1);
        r1 = r14.jow;
        r1 = r1.aTi();
        r0 = r0.append(r1);
        r0 = r0.toString();
        com.tencent.mm.modelsfs.FileOp.deleteFile(r0);
    L_0x003b:
        r4 = java.lang.System.currentTimeMillis();
        r0 = java.lang.System.currentTimeMillis();
        r14.joE = r0;
        r0 = "MicroMsg.SnsCdnDownloadBase";
        r1 = new java.lang.StringBuilder;
        r2 = "to downloadBitmap ";
        r1.<init>(r2);
        r2 = r14.jow;
        r2 = r2.mediaId;
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = r14.jow;
        r2 = r2.joq;
        r1 = r1.append(r2);
        r2 = " type ";
        r1 = r1.append(r2);
        r2 = r14.jow;
        r2 = r2.jos;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.d(r0, r1);
        r1 = 0;
        r9 = 0;
        r0 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r0.getPath();	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        com.tencent.mm.modelsfs.FileOp.jS(r0);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r6 = r0.jot;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = "";
        if (r6 != 0) goto L_0x0306;
    L_0x0091:
        r0 = "";
    L_0x0094:
        r2 = com.tencent.mm.sdk.platformtools.be.kS(r0);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        if (r2 != 0) goto L_0x00aa;
    L_0x009a:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r3 = "&scene=";
        r2.<init>(r3);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
    L_0x00aa:
        r2 = "http://weixin.qq.com/?version=%d&uin=%s&nettype=%d&signal=%d%s";
        r3 = 5;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r7 = 0;
        r8 = com.tencent.mm.protocal.d.lWh;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r3[r7] = r8;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r7 = 1;
        r8 = com.tencent.mm.plugin.sns.e.ad.aSl();	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r8 = com.tencent.mm.a.o.getString(r8);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r3[r7] = r8;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r7 = 2;
        r8 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r8 = com.tencent.mm.sdk.platformtools.ak.getNetTypeForStat(r8);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r3[r7] = r8;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r7 = 3;
        r8 = com.tencent.mm.sdk.platformtools.aa.getContext();	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r8 = com.tencent.mm.sdk.platformtools.ak.getStrength(r8);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r8 = java.lang.Integer.valueOf(r8);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r3[r7] = r8;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r7 = 4;
        r3[r7] = r0;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r7 = java.lang.String.format(r2, r3);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = r2.url;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = r14.AS(r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0.url = r2;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = com.tencent.mm.sdk.platformtools.be.Ni();	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r14.dnsCostTime = r2;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r0.jor;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        if (r0 == 0) goto L_0x0361;
    L_0x0101:
        r0 = "SnsSightDomainList";
        r2 = r0;
    L_0x0105:
        r0 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r0.jor;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        if (r0 == 0) goto L_0x0367;
    L_0x010b:
        r0 = "SnsSightMainStandbyIpSwitchTime";
    L_0x010e:
        r3 = com.tencent.mm.h.j.sU();	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r8 = r3.getValue(r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = com.tencent.mm.h.j.sU();	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r3 = 0;
        r0 = r2.getInt(r0, r3);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = (long) r0;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = "MicroMsg.SnsCdnDownloadBase";
        r10 = "pack.isAlbum %s pack.isthumb %s hostvalue %s dcipTime %s";
        r11 = 4;
        r11 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = 0;
        r13 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r13 = r13.jor;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r13 = java.lang.Boolean.valueOf(r13);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r11[r12] = r13;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = 1;
        r13 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r13 = r13.joq;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r13 = java.lang.Boolean.valueOf(r13);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r11[r12] = r13;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = 2;
        r11[r12] = r8;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = 3;
        r13 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r11[r12] = r13;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        com.tencent.mm.sdk.platformtools.v.i(r0, r10, r11);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r10 = 0;
        r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r0 > 0) goto L_0x0155;
    L_0x0152:
        r2 = 259200; // 0x3f480 float:3.63217E-40 double:1.28062E-318;
    L_0x0155:
        r0 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r0.url;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = a(r6, r0, r2, r8);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r3 = new com.tencent.mm.network.b$b;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r0.url;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r3.<init>(r0, r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r10 = r14.dnsCostTime;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r10 = com.tencent.mm.sdk.platformtools.be.ay(r10);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r14.dnsCostTime = r10;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r3.ip;	 Catch:{ Exception -> 0x0370, all -> 0x0672 }
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r0);	 Catch:{ Exception -> 0x0370, all -> 0x0672 }
        if (r0 == 0) goto L_0x036c;
    L_0x0176:
        r0 = r3.host;	 Catch:{ Exception -> 0x0370, all -> 0x0672 }
        r0 = java.net.InetAddress.getByName(r0);	 Catch:{ Exception -> 0x0370, all -> 0x0672 }
        r0 = r0.getHostAddress();	 Catch:{ Exception -> 0x0370, all -> 0x0672 }
    L_0x0180:
        r8 = "MicroMsg.SnsCdnDownloadBase";
        r10 = "checkAndGetHttpConn[%s] [%s] [id:%s] host ip:%d[%s] [%s] download type[%d] isDcIp[%s] fromScene[%s]";
        r11 = 9;
        r11 = new java.lang.Object[r11];	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = 0;
        r11[r12] = r7;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = 1;
        r13 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r13 = r13.url;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r11[r12] = r13;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = 2;
        r13 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r13 = r13.mediaId;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r11[r12] = r13;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = 3;
        r13 = r3.dll;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r13 = java.lang.Integer.valueOf(r13);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r11[r12] = r13;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = 4;
        r11[r12] = r0;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = 5;
        r12 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = r12.url;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r11[r0] = r12;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = 6;
        r12 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = r12.jos;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r12 = java.lang.Integer.valueOf(r12);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r11[r0] = r12;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = 7;
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r11[r0] = r2;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = 8;
        r2 = r6.toString();	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r11[r0] = r2;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        com.tencent.mm.sdk.platformtools.v.i(r8, r10, r11);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r3.ip;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r14.joz = r0;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r3.dll;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r14.dll = r0;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r10 = com.tencent.mm.sdk.platformtools.be.Ni();	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r14.joC = r10;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r14.jow;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = r0.url;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r1 = com.tencent.mm.network.b.a(r0, r3);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r0 = "GET";
        r1.setRequestMethod(r0);	 Catch:{ Exception -> 0x068c, all -> 0x0676 }
        r0 = "referer";
        r1.setRequestProperty(r0, r7);	 Catch:{ Exception -> 0x068c, all -> 0x0676 }
        r0 = com.tencent.mm.h.j.sU();	 Catch:{ Exception -> 0x068c, all -> 0x0676 }
        r2 = "SnsDownloadHttpKeep";
        r0 = r0.getValue(r2);	 Catch:{ Exception -> 0x068c, all -> 0x0676 }
        r2 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.getInt(r0, r2);	 Catch:{ Exception -> 0x068c, all -> 0x0676 }
        if (r0 <= 0) goto L_0x0211;
    L_0x01ff:
        r0 = "MicroMsg.SnsCdnDownloadBase";
        r2 = "header Connection close ";
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);	 Catch:{ Exception -> 0x068c, all -> 0x0676 }
        r0 = "Connection";
        r2 = "close";
        r1.setRequestProperty(r0, r2);	 Catch:{ Exception -> 0x068c, all -> 0x0676 }
    L_0x0211:
        r0 = 25000; // 0x61a8 float:3.5032E-41 double:1.23516E-319;
        r1.setConnectTimeout(r0);	 Catch:{ Exception -> 0x068c, all -> 0x0676 }
        r0 = 25000; // 0x61a8 float:3.5032E-41 double:1.23516E-319;
        r1.setReadTimeout(r0);	 Catch:{ Exception -> 0x068c, all -> 0x0676 }
        r10 = r14.b(r1);	 Catch:{ Exception -> 0x068c, all -> 0x0676 }
        r2 = r10.getHeaderFields();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = "X-ClientIp";
        r0 = r2.get(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r0 == 0) goto L_0x023d;
    L_0x022e:
        r1 = r0.size();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r1 <= 0) goto L_0x023d;
    L_0x0234:
        r1 = 0;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r14.joy = r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
    L_0x023d:
        r0 = "X-ServerIp";
        r0 = r2.get(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r0 == 0) goto L_0x0257;
    L_0x0248:
        r1 = r0.size();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r1 <= 0) goto L_0x0257;
    L_0x024e:
        r1 = 0;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r14.jox = r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
    L_0x0257:
        r0 = "X-ErrNo";
        r0 = r2.get(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r0 == 0) goto L_0x0275;
    L_0x0262:
        r1 = r0.size();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r1 <= 0) goto L_0x0275;
    L_0x0268:
        r1 = 0;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = com.tencent.mm.sdk.platformtools.be.KL(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r14.joA = r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
    L_0x0275:
        r0 = r10.getResponseCode();	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r14.aYJ = r0;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r0 = r14.aYJ;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 == r1) goto L_0x04ef;
    L_0x0281:
        r0 = r14.aYJ;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r0 == r1) goto L_0x04ef;
    L_0x0287:
        r0 = r10.getHeaderFields();	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        z(r0);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r0 = r14.jow;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r0 = r0.jor;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        if (r0 == 0) goto L_0x03ff;
    L_0x0294:
        r0 = r14.aYJ;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r0 < r1) goto L_0x0376;
    L_0x029a:
        r0 = r14.aYJ;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r0 >= r1) goto L_0x0376;
    L_0x02a0:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = 22;
        r4 = 78;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
    L_0x02ac:
        r0 = r14.jow;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r0 = r0.joq;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        if (r0 == 0) goto L_0x02be;
    L_0x02b2:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r4 = 14;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
    L_0x02be:
        r0 = "MicroMsg.SnsCdnDownloadBase";
        r1 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = "GprsSetting.checkHttpConnection failed! mediaId : ";
        r1.<init>(r2);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = r14.jow;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = r2.mediaId;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = r1.append(r2);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = " ";
        r1 = r1.append(r2);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = r14.jow;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = r2.url;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = r1.append(r2);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = " ";
        r1 = r1.append(r2);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = r14.aYJ;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = r1.append(r2);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = r1.toString();	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r0 = 0;
        r14.fT(r0);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r0 = 2;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        if (r10 == 0) goto L_0x0016;
    L_0x02ff:
        r1 = r10.dmc;
        r1.disconnect();
        goto L_0x0016;
    L_0x0306:
        r2 = com.tencent.mm.storage.ak.nvq;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = r6.equals(r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        if (r2 == 0) goto L_0x0313;
    L_0x030e:
        r0 = "album_friend";
        goto L_0x0094;
    L_0x0313:
        r2 = com.tencent.mm.storage.ak.nvr;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = r6.equals(r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        if (r2 == 0) goto L_0x0320;
    L_0x031b:
        r0 = "album_self";
        goto L_0x0094;
    L_0x0320:
        r2 = com.tencent.mm.storage.ak.nvs;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = r6.equals(r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        if (r2 == 0) goto L_0x032d;
    L_0x0328:
        r0 = "album_stranger";
        goto L_0x0094;
    L_0x032d:
        r2 = com.tencent.mm.storage.ak.nvt;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = r6.equals(r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        if (r2 == 0) goto L_0x033a;
    L_0x0335:
        r0 = "profile_friend";
        goto L_0x0094;
    L_0x033a:
        r2 = com.tencent.mm.storage.ak.nvu;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = r6.equals(r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        if (r2 == 0) goto L_0x0347;
    L_0x0342:
        r0 = "profile_stranger";
        goto L_0x0094;
    L_0x0347:
        r2 = com.tencent.mm.storage.ak.nvv;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = r6.equals(r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        if (r2 == 0) goto L_0x0354;
    L_0x034f:
        r0 = "comment";
        goto L_0x0094;
    L_0x0354:
        r2 = com.tencent.mm.storage.ak.nvp;	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        r2 = r6.equals(r2);	 Catch:{ Exception -> 0x0687, all -> 0x0672 }
        if (r2 == 0) goto L_0x0094;
    L_0x035c:
        r0 = "timeline";
        goto L_0x0094;
    L_0x0361:
        r0 = "SnsAlbumDomainList";
        r2 = r0;
        goto L_0x0105;
    L_0x0367:
        r0 = "SnsAlbumMainStandbyIpSwitchTime";
        goto L_0x010e;
    L_0x036c:
        r0 = r3.ip;	 Catch:{ Exception -> 0x0370, all -> 0x0672 }
        goto L_0x0180;
    L_0x0370:
        r0 = move-exception;
        r0 = "-";
        goto L_0x0180;
    L_0x0376:
        r0 = r14.aYJ;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r0 < r1) goto L_0x02ac;
    L_0x037c:
        r0 = r14.aYJ;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        if (r0 >= r1) goto L_0x02ac;
    L_0x0382:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = 22;
        r4 = 79;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        goto L_0x02ac;
    L_0x0390:
        r0 = move-exception;
        r1 = 0;
        r14.fT(r1);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r1 = r14.jow;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r1 = r1.jor;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r1 == 0) goto L_0x049e;
    L_0x039f:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = 22;
        r4 = 77;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
    L_0x03ab:
        r1 = r14.jow;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r1 = r1.joq;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r1 == 0) goto L_0x03bd;
    L_0x03b1:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r4 = 14;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
    L_0x03bd:
        r1 = "MicroMsg.SnsCdnDownloadBase";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = "GprsSetting.checkHttpConnection failed! socket timeout mediaId : ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = r14.jow;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = r3.mediaId;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = " ";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = r14.jow;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = r3.url;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = " msg:";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        com.tencent.mm.sdk.platformtools.v.e(r1, r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = 2;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r10 == 0) goto L_0x0016;
    L_0x03f8:
        r1 = r10.dmc;
        r1.disconnect();
        goto L_0x0016;
    L_0x03ff:
        r0 = r14.aYJ;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r0 < r1) goto L_0x0476;
    L_0x0405:
        r0 = r14.aYJ;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r0 >= r1) goto L_0x0476;
    L_0x040b:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = 22;
        r4 = 56;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        goto L_0x02ac;
    L_0x0419:
        r0 = move-exception;
        r1 = 0;
        r14.fT(r1);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = r0.getMessage();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r1 = r14.jow;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r1 = r1.joq;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r1 == 0) goto L_0x0434;
    L_0x0428:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r4 = 14;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
    L_0x0434:
        r1 = "MicroMsg.SnsCdnDownloadBase";
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = "GprsSetting.checkHttpConnection failed! mediaId : ";
        r2.<init>(r3);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = r14.jow;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = r3.mediaId;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = " ";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = r14.jow;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = r3.url;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3 = " msg:";
        r2 = r2.append(r3);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = r2.append(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        com.tencent.mm.sdk.platformtools.v.e(r1, r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = 2;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r10 == 0) goto L_0x0016;
    L_0x046f:
        r1 = r10.dmc;
        r1.disconnect();
        goto L_0x0016;
    L_0x0476:
        r0 = r14.aYJ;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r0 < r1) goto L_0x02ac;
    L_0x047c:
        r0 = r14.aYJ;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r1 = 600; // 0x258 float:8.41E-43 double:2.964E-321;
        if (r0 >= r1) goto L_0x02ac;
    L_0x0482:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        r2 = 22;
        r4 = 57;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ SocketTimeoutException -> 0x0390, Exception -> 0x0419, all -> 0x0490 }
        goto L_0x02ac;
    L_0x0490:
        r0 = move-exception;
    L_0x0491:
        if (r9 == 0) goto L_0x0496;
    L_0x0493:
        r9.close();	 Catch:{ IOException -> 0x0661 }
    L_0x0496:
        if (r10 == 0) goto L_0x049d;
    L_0x0498:
        r1 = r10.dmc;
        r1.disconnect();
    L_0x049d:
        throw r0;
    L_0x049e:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = 22;
        r4 = 55;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        goto L_0x03ab;
    L_0x04ac:
        r0 = move-exception;
        r1 = r9;
        r2 = r10;
    L_0x04af:
        r3 = "MicroMsg.SnsCdnDownloadBase";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0682 }
        r5 = "snscdndownload fail : ";
        r4.<init>(r5);	 Catch:{ all -> 0x0682 }
        r5 = r0.getMessage();	 Catch:{ all -> 0x0682 }
        r4 = r4.append(r5);	 Catch:{ all -> 0x0682 }
        r4 = r4.toString();	 Catch:{ all -> 0x0682 }
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0682 }
        com.tencent.mm.sdk.platformtools.v.a(r3, r0, r4, r5);	 Catch:{ all -> 0x0682 }
        r3 = "MicroMsg.SnsCdnDownloadBase";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x0682 }
        com.tencent.mm.sdk.platformtools.v.a(r3, r0, r4, r5);	 Catch:{ all -> 0x0682 }
        r0 = 0;
        r14.fT(r0);	 Catch:{ all -> 0x0682 }
        r0 = 2;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ all -> 0x0682 }
        if (r1 == 0) goto L_0x04e6;
    L_0x04e3:
        r1.close();	 Catch:{ IOException -> 0x0652 }
    L_0x04e6:
        if (r2 == 0) goto L_0x0016;
    L_0x04e8:
        r1 = r2.dmc;
        r1.disconnect();
        goto L_0x0016;
    L_0x04ef:
        r0 = r10.getHeaderFields();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        z(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = c(r10);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r0 != 0) goto L_0x0534;
    L_0x04fc:
        r1 = com.tencent.mm.plugin.report.service.g.iuh;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = 22;
        r4 = 62;
        r6 = 1;
        r8 = 1;
        r1.a(r2, r4, r6, r8);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = "MicroMsg.SnsCdnDownloadBase";
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = "checkHttpConnection failed! nocache mediaId : ";
        r1.<init>(r2);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = r14.jow;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r2 = r2.mediaId;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r1 = r1.append(r2);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        com.tencent.mm.sdk.platformtools.v.e(r0, r1);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = 0;
        r14.fT(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = 2;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r10 == 0) goto L_0x0016;
    L_0x052d:
        r1 = r10.dmc;
        r1.disconnect();
        goto L_0x0016;
    L_0x0534:
        r0 = r14.joC;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = com.tencent.mm.sdk.platformtools.be.ay(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r14.joC = r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = "Content-Length";
        r0 = r2.get(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r0 == 0) goto L_0x055a;
    L_0x0547:
        r1 = r0.size();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        if (r1 <= 0) goto L_0x055a;
    L_0x054d:
        r1 = 0;
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = com.tencent.mm.sdk.platformtools.be.KL(r0);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r14.joG = r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
    L_0x055a:
        r0 = "MicroMsg.SnsCdnDownloadBase";
        r1 = "ip: url %s client ip %s server ip %s svrlen %d %d";
        r3 = 5;
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r6 = 0;
        r7 = r14.jow;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r7 = r7.url;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3[r6] = r7;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r6 = 1;
        r7 = r14.joy;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3[r6] = r7;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r6 = 2;
        r7 = r14.jox;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3[r6] = r7;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r6 = 3;
        r7 = r14.joG;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3[r6] = r7;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r6 = 4;
        r7 = r14.joA;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r3[r6] = r7;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r3);	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = com.tencent.mm.sdk.platformtools.be.Ni();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r14.joD = r0;	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r1 = r10.getInputStream();	 Catch:{ Exception -> 0x04ac, all -> 0x0490 }
        r0 = r14.a(r1, r2);	 Catch:{ Exception -> 0x0691, all -> 0x067a }
        r1.close();	 Catch:{ Exception -> 0x0691, all -> 0x067a }
        r1 = 0;
        r2 = "MicroMsg.SnsCdnDownloadBase";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r6 = "reportResult ret : ";
        r3.<init>(r6);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        com.tencent.mm.sdk.platformtools.v.i(r2, r3);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        if (r0 != 0) goto L_0x05c5;
    L_0x05b3:
        r0 = 0;
        r14.fT(r0);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r0 = 2;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        if (r10 == 0) goto L_0x0016;
    L_0x05be:
        r1 = r10.dmc;
        r1.disconnect();
        goto L_0x0016;
    L_0x05c5:
        r2 = r14.joD;	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r2 = com.tencent.mm.sdk.platformtools.be.ay(r2);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r14.joD = r2;	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r2 = r14.joE;	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r2 = com.tencent.mm.sdk.platformtools.be.ay(r2);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r14.joB = r2;	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r0 = r14.aTk();	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r2 = "MicroMsg.SnsCdnDownloadBase";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r6 = "processData ret : ";
        r3.<init>(r6);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r3 = r3.append(r0);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r3 = r3.toString();	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        com.tencent.mm.sdk.platformtools.v.i(r2, r3);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        if (r0 != 0) goto L_0x0603;
    L_0x05f1:
        r0 = 0;
        r14.fT(r0);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        r0 = 2;
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0691, all -> 0x067e }
        if (r10 == 0) goto L_0x0016;
    L_0x05fc:
        r1 = r10.dmc;
        r1.disconnect();
        goto L_0x0016;
    L_0x0603:
        if (r10 == 0) goto L_0x060a;
    L_0x0605:
        r0 = r10.dmc;
        r0.disconnect();
    L_0x060a:
        r0 = "MicroMsg.SnsCdnDownloadBase";
        r1 = "DOWN FIN time:%d down:%d mediaId:%s url[%s], size %d";
        r2 = 5;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = com.tencent.mm.sdk.platformtools.be.ay(r4);
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r14.joB;
        r4 = java.lang.Long.valueOf(r4);
        r2[r3] = r4;
        r3 = 2;
        r4 = r14.jow;
        r4 = r4.mediaId;
        r2[r3] = r4;
        r3 = 3;
        r4 = r14.jow;
        r4 = r4.url;
        r2[r3] = r4;
        r3 = 4;
        r4 = r14.joI;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = 1;
        r14.fT(r0);
        r0 = r14.jow;
        r0 = r0.joq;
        if (r0 == 0) goto L_0x0670;
    L_0x064b:
        r0 = 3;
    L_0x064c:
        r0 = java.lang.Integer.valueOf(r0);
        goto L_0x0016;
    L_0x0652:
        r1 = move-exception;
        r3 = "MicroMsg.SnsCdnDownloadBase";
        r4 = "";
        r5 = 0;
        r5 = new java.lang.Object[r5];
        com.tencent.mm.sdk.platformtools.v.a(r3, r1, r4, r5);
        goto L_0x04e6;
    L_0x0661:
        r1 = move-exception;
        r2 = "MicroMsg.SnsCdnDownloadBase";
        r3 = "";
        r4 = 0;
        r4 = new java.lang.Object[r4];
        com.tencent.mm.sdk.platformtools.v.a(r2, r1, r3, r4);
        goto L_0x0496;
    L_0x0670:
        r0 = 1;
        goto L_0x064c;
    L_0x0672:
        r0 = move-exception;
        r10 = r1;
        goto L_0x0491;
    L_0x0676:
        r0 = move-exception;
        r10 = r1;
        goto L_0x0491;
    L_0x067a:
        r0 = move-exception;
        r9 = r1;
        goto L_0x0491;
    L_0x067e:
        r0 = move-exception;
        r9 = r1;
        goto L_0x0491;
    L_0x0682:
        r0 = move-exception;
        r9 = r1;
        r10 = r2;
        goto L_0x0491;
    L_0x0687:
        r0 = move-exception;
        r2 = r1;
        r1 = r9;
        goto L_0x04af;
    L_0x068c:
        r0 = move-exception;
        r2 = r1;
        r1 = r9;
        goto L_0x04af;
    L_0x0691:
        r0 = move-exception;
        r2 = r10;
        goto L_0x04af;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.e.a.b.aTl():java.lang.Integer");
    }

    private static void z(Map<String, List<String>> map) {
        if (map != null) {
            try {
                StringBuffer stringBuffer = new StringBuffer();
                for (String str : map.keySet()) {
                    List<String> list = (List) map.get(str);
                    if (list != null) {
                        stringBuffer.append(str + ":");
                        for (String str2 : list) {
                            stringBuffer.append(str2 + "|");
                        }
                        stringBuffer.append(";");
                    }
                }
                v.i("MicroMsg.SnsCdnDownloadBase", "header respone %s", new Object[]{stringBuffer.toString()});
            } catch (Exception e) {
            }
        }
    }

    private static boolean c(t tVar) {
        try {
            List list = (List) tVar.getHeaderFields().get("cache-control");
            if (list == null || list.size() == 0) {
                return true;
            }
            if (be.kS(list.toString()) || !list.toString().contains("no-cache")) {
                return true;
            }
            if (list.toString().contains("no-cache")) {
                return false;
            }
            return false;
        } catch (Throwable e) {
            v.a("MicroMsg.SnsCdnDownloadBase", e, "", new Object[0]);
            return false;
        }
    }

    private static long AT(String str) {
        long j = 0;
        if (str == null || str.length() == 0) {
            return j;
        }
        try {
            String[] split = str.split("\\.");
            return be.getLong(split[3], 0) + (((16777216 * be.getLong(split[0], 0)) + (65536 * be.getLong(split[1], 0))) + (256 * be.getLong(split[2], 0)));
        } catch (Exception e) {
            return j;
        }
    }

    private void fT(boolean z) {
        if (this.jow == null || !this.jow.jor) {
            if (z) {
                com.tencent.mm.plugin.report.service.g.iuh.a(22, 53, this.joB, true);
            } else {
                com.tencent.mm.plugin.report.service.g.iuh.a(22, 52, 1, true);
            }
            com.tencent.mm.plugin.report.service.g.iuh.a(22, 51, 1, true);
        } else {
            if (z) {
                com.tencent.mm.plugin.report.service.g.iuh.a(22, 75, this.joB, true);
            } else {
                com.tencent.mm.plugin.report.service.g.iuh.a(22, 74, 1, true);
            }
            com.tencent.mm.plugin.report.service.g.iuh.a(22, 73, 1, true);
        }
        if (!(this.jow == null || !this.jow.joq || z || i.b(this.jov))) {
            com.tencent.mm.plugin.report.service.g.iuh.a(150, 66, 1, true);
        }
        this.eha = this.joI;
        int i = ak.isWifi(aa.getContext()) ? 1 : 0;
        int strength = ak.getStrength(aa.getContext());
        String str = "MicroMsg.SnsCdnDownloadBase";
        String str2 = "report dns:%d wifi:%d signal:%d [%d,%d,%d]%d serverIp:[%s,%s] xclientip:%s url[%s]";
        Object[] objArr = new Object[11];
        objArr[0] = Integer.valueOf(this.dll);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(strength);
        objArr[3] = Long.valueOf(this.dnsCostTime);
        objArr[4] = Long.valueOf(this.joC);
        objArr[5] = Long.valueOf(this.joD);
        objArr[6] = Long.valueOf(this.joB);
        objArr[7] = this.jox;
        objArr[8] = this.joz;
        objArr[9] = this.joy;
        objArr[10] = this.jow == null ? "" : this.jow.url;
        v.v(str, str2, objArr);
        int netType = ak.getNetType(aa.getContext());
        int i2 = 0;
        if (this.jow != null) {
            i2 = this.jow.jos == 4 ? 1 : 0;
        }
        v.i("MicroMsg.SnsCdnDownloadBase", "retCode :%d totalSize: %d net: %d downloadType %d xErrorNo %d", new Object[]{Integer.valueOf(this.aYJ), Integer.valueOf(this.eha), Integer.valueOf(netType), Integer.valueOf(i2), Integer.valueOf(this.joA)});
        com.tencent.mm.plugin.report.service.g gVar = com.tencent.mm.plugin.report.service.g.iuh;
        Object[] objArr2 = new Object[19];
        objArr2[0] = this.jow == null ? "" : this.jow.url;
        objArr2[1] = Long.valueOf(AT(this.joz));
        objArr2[2] = Long.valueOf(z ? this.joB : 0);
        objArr2[3] = "";
        objArr2[4] = Integer.valueOf(i);
        objArr2[5] = Long.valueOf(this.dnsCostTime);
        objArr2[6] = Long.valueOf(this.joC);
        objArr2[7] = Integer.valueOf(0);
        objArr2[8] = Integer.valueOf(0);
        objArr2[9] = Long.valueOf(this.joD);
        objArr2[10] = Long.valueOf(AT(this.joy));
        objArr2[11] = Long.valueOf(AT(this.jox));
        objArr2[12] = Integer.valueOf(this.dll);
        objArr2[13] = Integer.valueOf(strength);
        objArr2[14] = Integer.valueOf(this.aYJ);
        objArr2[15] = Integer.valueOf(this.eha);
        objArr2[16] = Integer.valueOf(netType);
        objArr2[17] = Integer.valueOf(i2);
        objArr2[18] = Integer.valueOf(this.joA);
        gVar.h(10736, objArr2);
        boolean isConnected = ak.isConnected(aa.getContext());
        v.d("MicroMsg.SnsCdnDownloadBase", "isConntected  " + isConnected + " urlIp: " + this.joF);
        if (!z && !be.kS(this.joF) && isConnected) {
            String str3 = this.joF;
            if (com.tencent.mm.network.b.dlk != null && com.tencent.mm.network.b.dlk.uX() != null) {
                com.tencent.mm.network.b.dlk.uX().reportFailIp(str3);
            }
        }
    }

    public final ac aRW() {
        return ad.aSp();
    }
}
