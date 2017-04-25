package com.tencent.mm.plugin.multitalk.a;

import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.multitalk.ui.widget.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.pb.talkroom.sdk.MultiTalkGroup;
import com.tencent.pb.talkroom.sdk.MultiTalkGroupMember;
import java.util.List;

public final class i {
    public static final float[][] hzN;

    public enum a {
        WIFI,
        _4G,
        _3GOr_2G,
        None
    }

    static {
        r0 = new float[6][];
        hzN = r0;
        r0[0] = null;
        hzN[1] = new float[]{0.5f, 0.5f};
        hzN[2] = new float[]{0.0f, 0.5f, 1.0f, 0.5f};
        hzN[3] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.5f, 1.0f};
        hzN[4] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        hzN[5] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 2.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 2.0f, 1.0f, 0.0f, 2.0f, 1.0f, 2.0f, 2.0f, 2.0f};
    }

    public static String h(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        List<MultiTalkGroupMember> list = multiTalkGroup.pte;
        stringBuffer.append("->[usernamelist]");
        if (list != null) {
            for (MultiTalkGroupMember multiTalkGroupMember : list) {
                stringBuffer.append(multiTalkGroupMember.ptf + "|");
                stringBuffer.append(multiTalkGroupMember.status + ", ");
            }
        }
        stringBuffer.append(" ->createname:" + multiTalkGroup.ptd);
        stringBuffer.append(" ->talkgroupId:" + multiTalkGroup.pta);
        stringBuffer.append(" ->wxGroupId:" + multiTalkGroup.ptc);
        return stringBuffer.toString();
    }

    public static boolean a(MultiTalkGroup multiTalkGroup, MultiTalkGroup multiTalkGroup2) {
        if (multiTalkGroup == null || multiTalkGroup2 == null) {
            return false;
        }
        if (!be.kS(multiTalkGroup.pta) && !be.kS(multiTalkGroup2.pta) && multiTalkGroup.pta.equals(multiTalkGroup2.pta)) {
            return true;
        }
        if (be.kS(multiTalkGroup.ptb) || be.kS(multiTalkGroup2.ptb) || !multiTalkGroup.ptb.equals(multiTalkGroup2.ptb)) {
            return false;
        }
        return true;
    }

    public static boolean i(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return false;
        }
        boolean z = false;
        boolean z2 = false;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.pte) {
            boolean z3;
            if (multiTalkGroupMember.ptf.equals(k.xF())) {
                if (multiTalkGroupMember.status == 10) {
                    if (z) {
                        return true;
                    }
                    z2 = true;
                }
                z3 = z;
            } else {
                if (multiTalkGroupMember.status == 10) {
                    if (z2) {
                        return true;
                    }
                    z3 = true;
                }
                z3 = z;
            }
            z = z3;
        }
        return false;
    }

    public static boolean j(MultiTalkGroup multiTalkGroup) {
        int i = 0;
        for (MultiTalkGroupMember multiTalkGroupMember : multiTalkGroup.pte) {
            int i2;
            if (multiTalkGroupMember.status == 10 || multiTalkGroupMember.status == 1) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i > 1) {
            return true;
        }
        return false;
    }

    public static boolean c(e eVar) {
        if (eVar == e.Starting || eVar == e.Talking || eVar == e.Inviting) {
            return true;
        }
        return false;
    }

    public static boolean k(MultiTalkGroup multiTalkGroup) {
        return multiTalkGroup.ptd.equals(k.xF());
    }

    public static String l(MultiTalkGroup multiTalkGroup) {
        if (multiTalkGroup == null) {
            return "";
        }
        String str = multiTalkGroup.pta;
        if (be.kS(str)) {
            str = multiTalkGroup.ptb;
        }
        return be.ah(str, "");
    }

    public static String aCw() {
        return l(o.aCG().hzq);
    }

    public static String m(MultiTalkGroup multiTalkGroup) {
        String str = null;
        int i = 0;
        while (i < multiTalkGroup.pte.size()) {
            String str2;
            if (((MultiTalkGroupMember) multiTalkGroup.pte.get(i)).ptf.equals(k.xF())) {
                str2 = ((MultiTalkGroupMember) multiTalkGroup.pte.get(i)).ptg;
            } else {
                str2 = str;
            }
            i++;
            str = str2;
        }
        return str;
    }

    public static String aCx() {
        return m(o.aCG().hzq);
    }

    public static boolean aCy() {
        return ak.is3G(aa.getContext()) || ak.is2G(aa.getContext());
    }

    public static int n(Context context, Intent intent) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("state");
            if (stringExtra != null) {
                if (stringExtra.equals("IDLE")) {
                    return 0;
                }
                if (stringExtra.equals("RINGING")) {
                    return 1;
                }
                if (stringExtra.equals("OFFHOOK")) {
                    return 2;
                }
            }
        }
        return ((TelephonyManager) context.getSystemService("phone")).getCallState();
    }

    public static boolean no(int i) {
        return i == 2 || i == 3;
    }

    public static boolean np(int i) {
        return i == 1 || i == 3;
    }

    public static a aCz() {
        if (ak.isWifi(aa.getContext())) {
            return a.WIFI;
        }
        if (ak.is4G(aa.getContext())) {
            return a._4G;
        }
        if (ak.is3G(aa.getContext()) || ak.is2G(aa.getContext())) {
            return a._3GOr_2G;
        }
        return a.None;
    }
}
