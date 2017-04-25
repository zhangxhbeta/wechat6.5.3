package com.tencent.mm.plugin.mmsight.model;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.modelsns.c;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class h {
    public static void azW() {
        v.i("MicroMsg.MMSightRecorderIDKeyStat", "markCapture");
        g.iuh.a(440, 0, 1, false);
        int i = 36;
        if (g.hns.ceR == 1) {
            i = 39;
        }
        if (g.hns.hme == 720) {
            i++;
        } else if (g.hns.aAd()) {
            i += 2;
        }
        g.iuh.a(440, (long) i, 1, false);
    }

    public static void azX() {
        v.i("MicroMsg.MMSightRecorderIDKeyStat", "markFFMpegInitError");
        g.iuh.a(440, 7, 1, false);
    }

    public static void azY() {
        v.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecInitError");
        g.iuh.a(440, 8, 1, false);
    }

    public static void azZ() {
        v.i("MicroMsg.MMSightRecorderIDKeyStat", "markMediaCodecYUVInitError");
        g.iuh.a(440, 16, 1, false);
    }

    public static void b(boolean z, long j) {
        int i;
        v.v("MicroMsg.MMSightRecorderIDKeyStat", "markCaptureProcessCost isPictureMode %s cost_time %s", new Object[]{Boolean.valueOf(z), Long.valueOf(j)});
        a.azP().hml = j;
        a azP = a.azP();
        c cVar = new c();
        c cVar2 = new c();
        cVar.m("model", azP.model + ",");
        cVar.m("apiLevel", azP.hlK + ",");
        cVar.m("memoryClass", azP.hlL + ",");
        cVar.m("totalMemory", azP.hlM + ",");
        cVar.m("maxCpu", azP.hlN + ",");
        cVar.m("screenW", azP.hlO + ",");
        cVar.m("screenH", azP.hlP + ",");
        cVar2.m("model", azP.model + ",");
        cVar2.m("apiLevel", azP.hlK + ",");
        cVar2.m("memoryClass", azP.hlL + ",");
        cVar2.m("totalMemory", azP.hlM + ",");
        cVar2.m("maxCpu", azP.hlN + ",");
        cVar2.m("screenW", azP.hlO + ",");
        cVar2.m("screenH", azP.hlP + ",");
        cVar.m("cropx", azP.hlU + ",");
        cVar.m("cropy", azP.hlV + ",");
        cVar.m("previewx", azP.hlW + ",");
        cVar.m("previewy", azP.hlX + ",");
        cVar.m("encoderx", azP.hlY + ",");
        cVar.m("encodery", azP.hlZ + ",");
        cVar.m("rotate", azP.cdi + ",");
        cVar.m("deviceoutfps", azP.hma + ",");
        cVar.m("recordfps", azP.hmb + ",");
        cVar.m("recordertype", azP.hmc + ",");
        cVar.m("videoBitrate", azP.cGx + ",");
        cVar.m("needRotateEachFrame", azP.ceS + ",");
        cVar.m("isNeedRealtimeScale", azP.hmd + ",");
        cVar.m("resolutionLimit", azP.hme + ",");
        cVar.m("outfps", azP.hmf + ",");
        cVar.m("recordTime", azP.hmg + ",");
        cVar.m("avgcpu", azP.hmh + ",");
        cVar.m("outx", azP.hmi + ",");
        cVar.m("outy", azP.hmj + ",");
        cVar.m("outbitrate", azP.hmk + ",");
        cVar.m("fileSize", azP.fileSize + ",");
        cVar.m("wait2playtime", azP.hml + ",");
        cVar.m("useback", azP.hmm + ",");
        int i2 = 0;
        int i3 = 0;
        Intent registerReceiver = aa.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            i3 = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
            i3 = (i3 == 2 || i3 == 5) ? 1 : 0;
            i2 = registerReceiver.getIntExtra("level", -1);
            i = i3;
            i3 = registerReceiver.getIntExtra("scale", -1);
        } else {
            i = 0;
        }
        v.i("MicroMsg.CaptureStatistics", "battery %s %s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        cVar.m("mIsCharging", i + ",");
        cVar.m("level", i2 + ",");
        cVar.m("scale", i3 + ",");
        cVar.m("createTime", System.currentTimeMillis() + ",");
        cVar2.m("prewViewlist1", azP.hlQ + ",");
        cVar2.m("pictureSize1", azP.hlR + ",");
        cVar2.m("prewViewlist2", azP.hlS + ",");
        cVar2.m("pictureSize2", azP.hlT + ",");
        v.i("MicroMsg.CaptureStatistics", "report " + cVar.JH());
        v.v("MicroMsg.CaptureStatistics", "report " + cVar2.JH());
        g.iuh.Y(13947, cVar.toString());
        g.iuh.Y(13949, cVar2.toString());
        if (z) {
            g.iuh.a(440, 119, 1, false);
            g.iuh.a(440, 120, j, false);
            if (g.hns.hme == 720) {
                g.iuh.a(440, 122, j, false);
                return;
            } else if (g.hns.aAd()) {
                g.iuh.a(440, 123, j, false);
                return;
            } else {
                g.iuh.a(440, 121, j, false);
                return;
            }
        }
        g.iuh.a(440, 124, 1, false);
        g.iuh.a(440, 125, j, false);
        if (g.hns.ceR == 1) {
            g.iuh.a(440, 127, j, false);
            g.iuh.a(440, 131, j, false);
            return;
        }
        g.iuh.a(440, 126, j, false);
        g.iuh.a(440, 130, j, false);
    }
}
