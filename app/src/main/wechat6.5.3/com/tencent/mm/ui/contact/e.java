package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mm.ay.c;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.u;

public final class e {
    public static void j(Intent intent, String str) {
        intent.putExtra("Contact_User", str);
    }

    public static void a(Intent intent, String str) {
        if (intent == null || str == null || str.length() == 0) {
            v.e("MicroMsg.ContactInfoUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            return;
        }
        af iM = ah.FQ().iM(str);
        if (iM != null) {
            intent.putExtra("Contact_Uin", iM.cIA);
            intent.putExtra("Contact_QQNick", iM.getDisplayName());
        }
        b iA = ah.FL().iA(str);
        if (iA != null) {
            intent.putExtra("Contact_Mobile_MD5", iA.EB());
        }
    }

    public static void a(Context context, a aVar) {
        a(context, aVar, false, false, null);
    }

    public static void a(Context context, a aVar, boolean z, boolean z2, Bundle bundle) {
        if (context != null && aVar != null) {
            u uVar = new u();
            uVar.setUsername(aVar.lct);
            uVar.bS(aVar.getDisplayName());
            uVar.bT(aVar.cIE);
            uVar.bU(aVar.cIF);
            a(context, uVar, aVar, z, z2, bundle, aVar.hWt);
        }
    }

    public static void a(Context context, u uVar, a aVar) {
        a(context, uVar, aVar, false, false, null, aVar.hWt);
    }

    public static void a(Context context, u uVar, a aVar, boolean z, boolean z2, Bundle bundle, String str) {
        if (uVar != null && aVar != null && uVar.field_username != null && uVar.field_username.length() > 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", uVar.field_username);
            intent.putExtra("Contact_Alias", uVar.pD());
            intent.putExtra("Contact_Nick", uVar.tT());
            intent.putExtra("Contact_QuanPin", uVar.pF());
            intent.putExtra("Contact_PyInitial", uVar.pE());
            intent.putExtra("Contact_Sex", aVar.bBZ);
            intent.putExtra("Contact_Province", aVar.getProvince());
            intent.putExtra("Contact_City", aVar.getCity());
            intent.putExtra("Contact_Signature", aVar.bCj);
            intent.putExtra("Contact_Uin", aVar.hWq);
            intent.putExtra("Contact_Mobile_MD5", aVar.nvG);
            intent.putExtra("Contact_full_Mobile_MD5", aVar.nvH);
            intent.putExtra("Contact_QQNick", aVar.bwI());
            intent.putExtra("User_From_Fmessage", true);
            intent.putExtra("Contact_Scene", aVar.scene);
            intent.putExtra("Contact_from_msgType", 40);
            if (z) {
                intent.putExtra("Contact_ShowUserName", false);
            }
            if (z2) {
                intent.putExtra("Contact_KSnsIFlag", 0);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            if (!TextUtils.isEmpty(str)) {
                intent.putExtra("verify_gmail", str);
            }
            c.b(context, "profile", ".ui.ContactInfoUI", intent);
        }
    }
}
