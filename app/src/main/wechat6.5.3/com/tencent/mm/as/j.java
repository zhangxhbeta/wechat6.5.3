package com.tencent.mm.as;

import com.tencent.mm.a.e;
import com.tencent.mm.e.a.hy;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.sight.base.d;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public class j implements ag {
    private HashMap<String, a> dha = new HashMap();
    private c<hy> dhb = new c<hy>(this) {
        final /* synthetic */ j dhe;

        {
            this.dhe = r2;
            this.nhz = hy.class.getName().hashCode();
        }

        private boolean a(hy hyVar) {
            v.d("MicroMsg.SubCoreMediaRpt", "get media info report event.");
            if (hyVar == null) {
                return false;
            }
            String str;
            String str2 = hyVar.bhL.path;
            try {
                if (str2.endsWith(".tmp")) {
                    str2 = str2.substring(0, str2.lastIndexOf(".tmp"));
                    v.i("MicroMsg.SubCoreMediaRpt", "media info event path[%s, %s]", str2, hyVar.bhL.path);
                }
                str = str2;
            } catch (Exception e) {
                str = str2;
            }
            this.dhe.a(hyVar.bhL.bhM, hyVar.bhL.bhM, hyVar.bhL.bhN, hyVar.bhL.bhO, hyVar.bhL.bhR, hyVar.bhL.bhP, hyVar.bhL.startTime, hyVar.bhL.endTime, str, hyVar.bhL.bhQ);
            return false;
        }
    };

    class a {
        String bNo;
        final /* synthetic */ j dhe;
        String dhn;
        String dho;
        String dhp;
        int dhq;
        int dhr;
        long startTime;
        String toUser;

        a(j jVar) {
            this.dhe = jVar;
        }
    }

    static /* synthetic */ void aT(int i, int i2) {
        int i3;
        int i4;
        switch (i2) {
            case 1:
                i3 = MMGIFException.D_GIF_ERR_OPEN_FAILED;
                i4 = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
                break;
            case 2:
                i3 = MMGIFException.D_GIF_ERR_NOT_READABLE;
                i4 = 116;
                break;
            case 4:
                i3 = 131;
                i4 = 136;
                break;
            case 5:
                i3 = 121;
                i4 = 126;
                break;
            default:
                return;
        }
        g.iuh.a(422, (long) be.f((Integer) g.a(i / 1000, new int[]{350, 544, 800, 1200, 1600}, i3, i4)), 1, false);
        v.i("MicroMsg.SubCoreMediaRpt", "rptIdkey [%d] bitrate [%d] sendScene [%d]", Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
    }

    private j() {
        com.tencent.mm.sdk.c.a.nhr.e(this.dhb);
    }

    public static j KT() {
        j jVar = (j) ak.yP().fY(j.class.getName());
        if (jVar != null) {
            return jVar;
        }
        Object jVar2 = new j();
        ak.yP().a(j.class.getName(), jVar2);
        return jVar2;
    }

    public final void a(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        a aVar = (a) this.dha.get(str2);
        if (aVar == null) {
            aVar = new a(this);
        }
        aVar.dhn = str;
        aVar.dho = str2;
        aVar.toUser = str3;
        aVar.bNo = str4;
        aVar.dhp = str5;
        aVar.dhr = i;
        aVar.dhq = i2;
        aVar.startTime = be.Ni();
        this.dha.put(str2, aVar);
        v.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", str, str2, str3, str4, str5, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final void a(final keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, final String str) {
        if (com_tencent_mm_modelcdntran_keep_SceneResult != null && !be.kS(str)) {
            ak.vA().x(new Runnable(this) {
                final /* synthetic */ j dhe;

                public final void run() {
                    a aVar = (a) this.dhe.dha.get(str);
                    if (aVar != null) {
                        int i;
                        com.tencent.mm.plugin.sight.base.a aVar2;
                        int aQ = e.aQ(aVar.dho);
                        com.tencent.mm.plugin.sight.base.a zD = d.zD(aVar.dho);
                        if (be.kS(aVar.dhn)) {
                            i = aQ;
                            aVar2 = zD;
                        } else {
                            com.tencent.mm.plugin.sight.base.a zD2 = d.zD(aVar.dhn);
                            i = e.aQ(aVar.dhn);
                            aVar2 = zD2;
                        }
                        if (aVar2 == null || zD == null) {
                            v.w("MicroMsg.SubCoreMediaRpt", "upload video but media info is null. %s", aVar.dho);
                            return;
                        }
                        StringBuffer stringBuffer;
                        int dQ = com.tencent.mm.sdk.platformtools.ak.dQ(aa.getContext());
                        long j = com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime != 0 ? com_tencent_mm_modelcdntran_keep_SceneResult.field_startTime : aVar.startTime;
                        long Ni = com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime != 0 ? com_tencent_mm_modelcdntran_keep_SceneResult.field_endTime : be.Ni();
                        String str = null;
                        if (com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps != null) {
                            stringBuffer = new StringBuffer();
                            for (String append : com_tencent_mm_modelcdntran_keep_SceneResult.field_usedSvrIps) {
                                stringBuffer.append(append).append("|");
                            }
                            str = stringBuffer.toString();
                        }
                        stringBuffer = new StringBuffer();
                        stringBuffer.append(aVar.toUser).append(",").append(aVar.bNo).append(",");
                        stringBuffer.append(dQ).append(",").append(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId).append(",");
                        stringBuffer.append(com_tencent_mm_modelcdntran_keep_SceneResult.field_filemd5).append(",").append(aVar.dhp).append(",");
                        stringBuffer.append(j).append(",").append(Ni).append(",");
                        stringBuffer.append(i).append(",").append(aVar2.hpy).append(",");
                        stringBuffer.append(aVar2.cGx / 1000).append(",").append(aVar2.cGk / 1000).append(",");
                        stringBuffer.append(aVar2.hqh).append(",").append(aVar2.width).append(",");
                        stringBuffer.append(aVar2.height).append(",").append(aVar.dhq).append(",");
                        stringBuffer.append(aQ).append(",").append(zD.hpy).append(",");
                        stringBuffer.append(zD.cGx / 1000).append(",").append(zD.cGk / 1000).append(",");
                        stringBuffer.append(zD.hqh).append(",").append(zD.width).append(",");
                        stringBuffer.append(zD.height).append(",").append(aVar.dhr).append(",");
                        stringBuffer.append(str).append(",").append(aVar2.iTr).append(",").append(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl);
                        v.i("MicroMsg.SubCoreMediaRpt", "upload video rpt %s", stringBuffer.toString());
                        g.iuh.Y(13794, stringBuffer.toString());
                        j.aT(zD.cGx, aVar.dhr);
                    }
                }
            });
        }
    }

    public final void a(String str, String str2, int i, String str3, String str4, String str5, long j, long j2, String str6, String[] strArr) {
        final String str7 = str6;
        final String[] strArr2 = strArr;
        final String str8 = str;
        final String str9 = str2;
        final int i2 = i;
        final String str10 = str3;
        final String str11 = str4;
        final String str12 = str5;
        final long j3 = j;
        final long j4 = j2;
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ j dhe;

            public final void run() {
                com.tencent.mm.plugin.sight.base.a zD = d.zD(str7);
                if (zD == null) {
                    v.w("MicroMsg.SubCoreMediaRpt", "get media info is null. %s", str7);
                    return;
                }
                int aQ = e.aQ(str7);
                String str = null;
                if (strArr2 != null) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String append : strArr2) {
                        stringBuffer.append(append).append("|");
                    }
                    str = stringBuffer.toString();
                }
                int dQ = com.tencent.mm.sdk.platformtools.ak.dQ(aa.getContext());
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(str8).append(",").append(str9).append(",");
                stringBuffer2.append(i2).append(",").append(str10).append(",");
                stringBuffer2.append(str11).append(",").append(dQ).append(",");
                stringBuffer2.append(str12).append(",").append(j3).append(",");
                stringBuffer2.append(j4).append(",").append(aQ).append(",");
                stringBuffer2.append(zD.hpy).append(",").append(zD.cGx / 1000).append(",");
                stringBuffer2.append(zD.cGk / 1000).append(",").append(zD.hqh).append(",");
                stringBuffer2.append(zD.width).append(",").append(zD.height).append(",");
                stringBuffer2.append(str).append(",").append(zD.iTr);
                v.i("MicroMsg.SubCoreMediaRpt", "download video rpt %s ", stringBuffer2.toString());
                g.iuh.Y(13795, stringBuffer2.toString());
            }
        });
    }

    public final HashMap<Integer, com.tencent.mm.bg.g.c> ti() {
        return null;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
    }

    public final void aH(boolean z) {
    }

    public final void th() {
    }
}
