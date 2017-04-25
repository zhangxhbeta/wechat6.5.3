package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.protocal.c.mc;
import com.tencent.mm.storage.RegionCodeDecoder;

public final class c {
    public static void a(Intent intent, ars com_tencent_mm_protocal_c_ars, int i) {
        String a = m.a(com_tencent_mm_protocal_c_ars.moM);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", m.a(com_tencent_mm_protocal_c_ars.mEj));
        intent.putExtra("Contact_PyInitial", m.a(com_tencent_mm_protocal_c_ars.moC));
        intent.putExtra("Contact_QuanPin", m.a(com_tencent_mm_protocal_c_ars.moD));
        intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_ars.cHh);
        intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_ars.cHc);
        intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_ars.mFv);
        intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_ars.mFu);
        intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_ars.mFy);
        intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_ars.mFw);
        intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_ars.mFx);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(com_tencent_mm_protocal_c_ars.cHl, com_tencent_mm_protocal_c_ars.cHd, com_tencent_mm_protocal_c_ars.cHe));
        intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_ars.cHf);
        intent.putExtra("Contact_BrandList", com_tencent_mm_protocal_c_ars.cHm);
        intent.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_ars.mFA.cHn);
        intent.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_ars.mFA.cHp);
        intent.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_ars.mFA.cHo);
        intent.putExtra("Contact_BIZ_KF_WORKER_ID", com_tencent_mm_protocal_c_ars.mQJ);
        BizInfo bizInfo = new BizInfo();
        bizInfo.field_username = a;
        bizInfo.field_brandList = com_tencent_mm_protocal_c_ars.cHm;
        bizInfo.field_kfWorkerId = com_tencent_mm_protocal_c_ars.mQJ;
        mc mcVar = com_tencent_mm_protocal_c_ars.mFB;
        if (mcVar != null) {
            bizInfo.field_brandFlag = mcVar.cHq;
            bizInfo.field_brandInfo = mcVar.cHs;
            bizInfo.field_extInfo = mcVar.cHr;
            bizInfo.field_brandIconURL = mcVar.cHt;
        }
        if (!u.Dy().e(bizInfo)) {
            u.Dy().d(bizInfo);
        }
    }

    public static void a(Intent intent, arq com_tencent_mm_protocal_c_arq, int i) {
        String a = m.a(com_tencent_mm_protocal_c_arq.moM);
        intent.putExtra("Contact_User", a);
        intent.putExtra("Contact_Nick", m.a(com_tencent_mm_protocal_c_arq.mEj));
        intent.putExtra("Contact_PyInitial", m.a(com_tencent_mm_protocal_c_arq.moC));
        intent.putExtra("Contact_QuanPin", m.a(com_tencent_mm_protocal_c_arq.moD));
        intent.putExtra("Contact_Alias", com_tencent_mm_protocal_c_arq.cHh);
        intent.putExtra("Contact_Sex", com_tencent_mm_protocal_c_arq.cHc);
        intent.putExtra("Contact_VUser_Info", com_tencent_mm_protocal_c_arq.mFv);
        intent.putExtra("Contact_VUser_Info_Flag", com_tencent_mm_protocal_c_arq.mFu);
        intent.putExtra("Contact_KWeibo_flag", com_tencent_mm_protocal_c_arq.mFy);
        intent.putExtra("Contact_KWeibo", com_tencent_mm_protocal_c_arq.mFw);
        intent.putExtra("Contact_KWeiboNick", com_tencent_mm_protocal_c_arq.mFx);
        intent.putExtra("Contact_Scene", i);
        intent.putExtra("Contact_KHideExpose", true);
        intent.putExtra("Contact_RegionCode", RegionCodeDecoder.Y(com_tencent_mm_protocal_c_arq.cHl, com_tencent_mm_protocal_c_arq.cHd, com_tencent_mm_protocal_c_arq.cHe));
        intent.putExtra("Contact_Signature", com_tencent_mm_protocal_c_arq.cHf);
        intent.putExtra("Contact_BrandList", com_tencent_mm_protocal_c_arq.cHm);
        intent.putExtra("Contact_KSnsIFlag", com_tencent_mm_protocal_c_arq.mFA.cHn);
        intent.putExtra("Contact_KSnsBgId", com_tencent_mm_protocal_c_arq.mFA.cHp);
        intent.putExtra("Contact_KSnsBgUrl", com_tencent_mm_protocal_c_arq.mFA.cHo);
        BizInfo bizInfo = new BizInfo();
        bizInfo.field_username = a;
        bizInfo.field_brandList = com_tencent_mm_protocal_c_arq.cHm;
        mc mcVar = com_tencent_mm_protocal_c_arq.mFB;
        if (mcVar != null) {
            bizInfo.field_brandFlag = mcVar.cHq;
            bizInfo.field_brandInfo = mcVar.cHs;
            bizInfo.field_extInfo = mcVar.cHr;
            bizInfo.field_brandIconURL = mcVar.cHt;
        }
        if (!u.Dy().e(bizInfo)) {
            u.Dy().d(bizInfo);
        }
    }
}
