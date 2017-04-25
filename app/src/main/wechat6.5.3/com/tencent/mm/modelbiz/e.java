package com.tencent.mm.modelbiz;

import com.tencent.mm.ak.j;
import com.tencent.mm.ba.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.aw.AnonymousClass3;
import com.tencent.mm.model.c;
import com.tencent.mm.protocal.c.ail;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ac;
import com.tencent.mmdb.FileUtils;
import java.util.List;

public final class e {
    public static BizInfo hw(String str) {
        BizInfo ho = u.Dy().ho(str);
        return ho.field_updateTime > 0 ? ho : null;
    }

    public static boolean hx(String str) {
        BizInfo hw = hw(str);
        if (hw != null && hw.Cw()) {
            return true;
        }
        return false;
    }

    public static boolean hy(String str) {
        BizInfo hw = hw(str);
        if (hw == null) {
            return false;
        }
        return hw.Cx();
    }

    public static boolean hz(String str) {
        BizInfo hw = hw(str);
        if (hw != null && hw.Cy()) {
            return true;
        }
        return false;
    }

    public static boolean hA(String str) {
        BizInfo hw = hw(str);
        if (hw != null && hw.CA()) {
            return true;
        }
        return false;
    }

    public static boolean hB(String str) {
        if (str == null) {
            return false;
        }
        BizInfo hw = hw(str);
        if (hw == null || !hw.Cz()) {
            return false;
        }
        return true;
    }

    public static boolean hC(String str) {
        BizInfo hw = hw(str);
        if (hw != null && hw.CB()) {
            return true;
        }
        return false;
    }

    public static boolean hD(String str) {
        BizInfo hw = hw(str);
        if (hw != null && hw.CC()) {
            return true;
        }
        return false;
    }

    public static boolean hE(String str) {
        BizInfo hw = hw(str);
        if (hw == null) {
            return false;
        }
        return hw.Cr();
    }

    public static void f(BizInfo bizInfo) {
        if (bizInfo == null) {
            v.e("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession bizInfo is Null");
            return;
        }
        a com_tencent_mm_protocal_c_ail = new ail();
        com_tencent_mm_protocal_c_ail.cHq = bizInfo.field_brandFlag;
        com_tencent_mm_protocal_c_ail.gln = bizInfo.field_username;
        ak.yW();
        c.wG().b(new j.a(58, com_tencent_mm_protocal_c_ail));
        boolean a = u.Dy().a((com.tencent.mm.sdk.h.c) bizInfo, new String[0]);
        v.i("MicroMsg.BizInfoStorageLogic", "updateBrandFlagForTempSession ret = %b, BrandFlag = %b", Boolean.valueOf(a), Integer.valueOf(bizInfo.field_brandFlag));
    }

    public static void g(BizInfo bizInfo) {
        if (bizInfo != null) {
            a com_tencent_mm_protocal_c_ail = new ail();
            com_tencent_mm_protocal_c_ail.cHq = bizInfo.field_brandFlag;
            com_tencent_mm_protocal_c_ail.gln = bizInfo.field_username;
            ak.yW();
            c.wG().b(new j.a(47, com_tencent_mm_protocal_c_ail));
            u.Dy().a((com.tencent.mm.sdk.h.c) bizInfo, new String[0]);
        }
    }

    public static boolean De() {
        return u.Dy().fh(1) > 0;
    }

    public static List<String> Df() {
        return u.Dy().fg(2);
    }

    public static boolean Dg() {
        return u.Dy().fh(4) > 0;
    }

    public static boolean Dh() {
        return u.Dy().fh(8) > 0;
    }

    public static List<String> Di() {
        return u.Dy().fg(16);
    }

    public static boolean Dj() {
        return u.Dy().fh(16) > 0;
    }

    public static List<String> Dk() {
        return u.Dy().fg(32);
    }

    public static boolean Dl() {
        return u.Dy().fh(64) > 0;
    }

    public static List<String> Dm() {
        return u.Dy().fg(FileUtils.S_IWUSR);
    }

    public static boolean Dn() {
        return u.Dy().fh(FileUtils.S_IWUSR) > 0;
    }

    public static boolean Do() {
        return u.Dy().fh(FileUtils.S_IRUSR) > 0;
    }

    public static boolean Dp() {
        return u.Dy().fh(512) > 0;
    }

    public static void hF(String str) {
        aw.a(str, null);
        ak.yW();
        c.wK().Mf(str);
        BizInfo hw = hw(str);
        if (hw == null) {
            u.DF().hc(str);
            return;
        }
        if (hw.Cz()) {
            ak.yW();
            com.tencent.mm.sdk.h.j wK = c.wK();
            v.d("MicroMsg.ConversationStorage", "delEnterpriseFatherAndChildConv %s %d", str, Integer.valueOf(wK.cie.delete(ac.Me(str), "username=? or parentRef =?", new String[]{str, str})));
            if (wK.cie.delete(ac.Me(str), "username=? or parentRef =?", new String[]{str, str}) != 0) {
                wK.b(5, wK, str);
            }
            u.Dy();
            List hr = d.hr(str);
            if (hr == null || hr.size() <= 0) {
                v.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers, empty talkers");
            } else {
                v.d("MicroMsg.MsgInfoStorageLogic", "deleteMsgByTalkers");
                g.vx();
                g.vA().x(new AnonymousClass3(hr, null));
            }
            for (int i = 0; i < hr.size(); i++) {
                String str2 = (String) hr.get(i);
                if (hC(str2)) {
                    com.tencent.mm.modelbiz.a.e.v(str2, true);
                }
                u.Dy().hp(str2);
            }
        }
        if (hw.CB()) {
            com.tencent.mm.modelbiz.a.e.v(str, true);
        }
        u.Dy().c(hw);
        u.DF().hc(str);
    }
}
