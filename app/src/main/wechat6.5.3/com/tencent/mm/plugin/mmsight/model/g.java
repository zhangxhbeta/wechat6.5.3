package com.tencent.mm.plugin.mmsight.model;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.hardware.Camera.Parameters;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.ui.base.s;

public final class g {
    static int hlL;
    public static boolean hnq = true;
    private static boolean hnr = false;
    public static l hns;
    static double hnt;

    public static boolean b(Point point) {
        if (hnr) {
            String str;
            Context context = aa.getContext();
            Resources resources = aa.getResources();
            Object[] objArr = new Object[1];
            if (hns == null) {
                str = "";
            } else {
                str = Integer.valueOf(hns.fWf);
            }
            objArr[0] = str;
            s.makeText(context, resources.getString(2131233286, objArr), 1).show();
            return false;
        }
        v.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy, deviceInfo recorderType: %s", new Object[]{Integer.valueOf(p.ceH.ceR)});
        if (p.ceH.ceR != -1) {
            return true;
        }
        if (hns != null && 1 == hns.ceR) {
            return true;
        }
        if (point == null) {
            return false;
        }
        if (b.mV(point.x) && b.mV(point.y)) {
            return true;
        }
        if (hns != null) {
            v.i("MicroMsg.MMSightRecorderConfig", "checkMediaCodecHappy not happy %s", new Object[]{point.toString()});
            hns.ceR = 1;
        }
        return false;
    }

    public static void a(Parameters parameters, boolean z) {
        if (hnr) {
            String str;
            Context context = aa.getContext();
            Resources resources = aa.getResources();
            Object[] objArr = new Object[1];
            if (hns == null) {
                str = "";
            } else {
                str = Integer.valueOf(hns.fWf);
            }
            objArr[0] = str;
            s.makeText(context, resources.getString(2131233286, objArr), 1).show();
            return;
        }
        l lVar;
        boolean z2;
        Point azJ = b.azJ();
        int i = be.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19);
        v.i("MicroMsg.MMSightRecorderConfig", "apiLevel: %s record1080pApiLevel: %s, record720pApiLevel: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(be.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight1080pRecordMinApiLevel"), 19)), Integer.valueOf(be.getInt(CaptureMMProxy.getInstance().getDynamicConfig("Sight720pRecordMinApiLevel"), 19))});
        if ((p.ceH.ceX == -1 || (p.ceH.ceX & 1) != 0) && d.dW(r3) && hlL >= 512 && hnt >= 2025.0d && Math.min(azJ.x, azJ.y) >= 1080) {
            lVar = hns;
            lVar.hnF = d.a(parameters, b.azJ(), lVar.hnB.width * 2, lVar.hnB.width * 2, z);
            if (lVar.hnF != null) {
                hns.aAc().hnD = true;
                z2 = true;
                if (p.ceH.ceS == -1) {
                    hns.hnC = p.ceH.ceS != 1;
                } else {
                    hns.hnC = false;
                }
                if ((p.ceH.ceX == -1 || (p.ceH.ceX & 2) != 0) && !r0 && d.dW(r5) && hlL >= 512 && hnt >= 1725.0d && Math.min(azJ.x, azJ.y) >= 720) {
                    lVar = hns;
                    lVar.hnF = d.a(parameters, b.azJ(), 720, lVar.hnB.width + 16, z);
                    if (lVar.hnF == null) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        lVar = hns.aAa();
                        lVar.hnD = false;
                        lVar.aAb();
                    }
                }
                hns.fWf = -1;
                v.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[]{hns.toString()});
            }
        }
        z2 = false;
        if (p.ceH.ceS == -1) {
            hns.hnC = false;
        } else {
            if (p.ceH.ceS != 1) {
            }
            hns.hnC = p.ceH.ceS != 1;
        }
        lVar = hns;
        lVar.hnF = d.a(parameters, b.azJ(), 720, lVar.hnB.width + 16, z);
        if (lVar.hnF == null) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            lVar = hns.aAa();
            lVar.hnD = false;
            lVar.aAb();
        }
        hns.fWf = -1;
        v.i("MicroMsg.MMSightRecorderConfig", "autoConfig parameter byserver %s", new Object[]{hns.toString()});
    }

    public static void b(VideoTransPara videoTransPara) {
        boolean z = true;
        hnr = false;
        hlL = ((ActivityManager) aa.getContext().getSystemService("activity")).getLargeMemoryClass();
        hnt = (double) b.azK();
        String bxj = az.bxj();
        v.i("MicroMsg.MMSightRecorderConfig", "MXM_DynaCfg_AV_Item_Key_SightMediaCodecMinApiLevel: %s", new Object[]{Integer.valueOf(be.getInt(CaptureMMProxy.getInstance().getDynamicConfig("SightMediaCodecMinApiLevel"), 19))});
        if (CaptureMMProxy.getInstance() != null) {
            p.dr(CaptureMMProxy.getInstance().getDeviceInfoConfig());
        }
        v.i("MicroMsg.MMSightRecorderConfig", "init large memory class: %sMB, totalMemory: %sGB  fingerprint: %s mmSightRecorderInfo: %s", new Object[]{Integer.valueOf(hlL), Double.valueOf(hnt), bxj, p.ceH});
        hns = l.a(((Integer) CaptureMMProxy.getInstance().get(a.ntF, Integer.valueOf(-1))).intValue(), videoTransPara);
        int intValue = ((Integer) CaptureMMProxy.getInstance().get(a.ntI, Integer.valueOf(1))).intValue();
        if (hns != null) {
            if (intValue == 1) {
                hns.hnE = true;
            } else {
                hns.hnE = false;
            }
            hnr = true;
            Context context = aa.getContext();
            Resources resources = aa.getResources();
            Object[] objArr = new Object[1];
            if (hns == null) {
                bxj = "";
            } else {
                bxj = Integer.valueOf(hns.fWf);
            }
            objArr[0] = bxj;
            s.makeText(context, resources.getString(2131233286, objArr), 1).show();
            return;
        }
        hns = l.a(1, videoTransPara);
        if (intValue == 1) {
            hns.hnE = true;
        } else {
            hns.hnE = false;
        }
        if (p.ceH.ceR != -1) {
            hns.ceR = p.ceH.ceR;
        } else if (d.dW(r3)) {
            hns.ceR = 2;
        } else {
            hns.ceR = 1;
        }
        if (p.ceH.ceU != -1) {
            boolean z2;
            if (p.ceH.ceU == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            hnq = z2;
        }
        if (p.ceH.ceS != -1) {
            l lVar = hns;
            if (p.ceH.ceS != 1) {
                z = false;
            }
            lVar.hnC = z;
            return;
        }
        hns.hnC = false;
    }

    public static void a(d.b bVar) {
        if (bVar.hnk == null) {
            v.i("MicroMsg.MMSightRecorderConfig", "checkMore start %s", new Object[]{bVar.toString()});
            bVar.hnk = bVar.pRb;
            bVar.hnl = bVar.pRc;
            bVar.hnm = bVar.pRd;
            if (Math.min(bVar.hnl.y, bVar.hnl.x) >= hns.hnB.width + 16) {
                hns.aAb();
                hns.hnD = false;
                hns.hnC = false;
                v.i("MicroMsg.MMSightRecorderConfig", "checkMore out %s", new Object[]{bVar.toString()});
            }
        }
    }
}
