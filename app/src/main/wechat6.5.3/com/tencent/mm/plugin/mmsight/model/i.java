package com.tencent.mm.plugin.mmsight.model;

import android.media.MediaMetadataRetriever;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.protocal.c.ahn;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;

public final class i {
    public static boolean a(String str, VideoTransPara videoTransPara, ahn com_tencent_mm_protocal_c_ahn, f fVar) {
        try {
            if (be.kS(str) || videoTransPara == null) {
                return false;
            }
            if (com_tencent_mm_protocal_c_ahn == null) {
                com_tencent_mm_protocal_c_ahn = new ahn();
            }
            v.i("MicroMsg.SightSendVideoLogic", "check localCaptureVideo %s videoPath %s videoParams %s", new Object[]{Boolean.valueOf(com_tencent_mm_protocal_c_ahn.mHd), str, videoTransPara});
            if (!com_tencent_mm_protocal_c_ahn.mHd || be.kS(str)) {
                return false;
            }
            SightVideoJNI.tagMP4Dscp(str, d.En().getWeixinMeta());
            if (!be.kS(com_tencent_mm_protocal_c_ahn.pRv)) {
                SightVideoJNI.tagMp4RecordInfo(str, com_tencent_mm_protocal_c_ahn.pRv);
            }
            long Nj = be.Nj();
            SightVideoJNI.optimizeMP4(str);
            v.i("MicroMsg.SightSendVideoLogic", "optimizeMP4 used %sms", new Object[]{Long.valueOf(be.az(Nj))});
            fVar.azE();
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(str);
            v.i("MicroMsg.SightSendVideoLogic", "videopath %d %d", new Object[]{Integer.valueOf(be.getInt(mediaMetadataRetriever.extractMetadata(18), 0)), Integer.valueOf(be.getInt(mediaMetadataRetriever.extractMetadata(19), 0))});
            int min = Math.min(r3, min);
            if (min <= videoTransPara.width || (min > videoTransPara.width && min % 16 == 0 && Math.abs(min - videoTransPara.width) < 16)) {
                return false;
            }
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.SightSendVideoLogic", "checkShouldRemuxing error: %s %s", new Object[]{e.getMessage(), str});
            return false;
        }
    }

    public static int b(String str, VideoTransPara videoTransPara, ahn com_tencent_mm_protocal_c_ahn, f fVar) {
        if (com_tencent_mm_protocal_c_ahn == null || !com_tencent_mm_protocal_c_ahn.mHd || !FileOp.aR(str)) {
            return -1;
        }
        try {
            String str2;
            String substring;
            String jR = FileOp.jR(str);
            if (jR.endsWith("/")) {
                str2 = jR;
            } else {
                str2 = jR + "/";
            }
            jR = new File(str).getName();
            int lastIndexOf = jR.lastIndexOf(46);
            if (lastIndexOf > 0) {
                substring = jR.substring(0, lastIndexOf);
            } else {
                substring = jR;
            }
            jR = str2 + substring + "_hd";
            if (str.endsWith(".mp4")) {
                jR = jR + ".mp4";
            }
            String str3 = str2 + substring + "tempRemuxing.mp4";
            FileOp.p(str, jR);
            v.i("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg, dir: %s, oldFileName: %s, hdFilePath: %s, remuxingOutputFile: %s extInfotrycount %d", new Object[]{str2, substring, jR, str3, Integer.valueOf(com_tencent_mm_protocal_c_ahn.mHe)});
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(jR);
            int i = be.getInt(mediaMetadataRetriever.extractMetadata(18), 0);
            int i2 = be.getInt(mediaMetadataRetriever.extractMetadata(19), 0);
            if (Math.min(i, i2) <= videoTransPara.width) {
                return 0;
            }
            int i3;
            int i4;
            if (i < i2) {
                i3 = videoTransPara.width;
                i4 = (int) (((double) i2) / ((1.0d * ((double) i)) / ((double) i3)));
            } else {
                i4 = videoTransPara.width;
                i3 = (int) (((double) i) / ((1.0d * ((double) i2)) / ((double) i4)));
            }
            v.i("MicroMsg.SightSendVideoLogic", "start remuxing %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s videoParams: %s", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), videoTransPara});
            if (i4 % 2 != 0) {
                i4++;
            }
            if (i3 % 2 != 0) {
                i3++;
            }
            long Nj = be.Nj();
            v.i("MicroMsg.SightSendVideoLogic", "doremuxing finish %s,  rawwith %s, rawheight %s, outputWidth: %s, outputHeight: %s duration: %s, used %sms", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(SightVideoJNI.remuxing(jR, str3, i3, i4, videoTransPara.cGx, videoTransPara.cGn, 8, videoTransPara.cGm, 25.0f, 30.0f, null, 0)), Long.valueOf(be.az(Nj))});
            FileOp.ab(str3, str);
            long Nj2 = be.Nj();
            if (com_tencent_mm_protocal_c_ahn.mHd) {
                SightVideoJNI.tagMP4Dscp(str, d.En().getWeixinMeta());
                if (!be.kS(com_tencent_mm_protocal_c_ahn.pRv)) {
                    SightVideoJNI.tagMp4RecordInfo(str, com_tencent_mm_protocal_c_ahn.pRv);
                }
            }
            fVar.azE();
            v.i("MicroMsg.SightSendVideoLogic", "tagMP4Dscp used %sms", new Object[]{Long.valueOf(be.az(Nj2))});
            return r2;
        } catch (Exception e) {
            v.e("MicroMsg.SightSendVideoLogic", "doRemuxingSendVideoMsg error: %s", new Object[]{e.getMessage()});
            return -1;
        }
    }
}
