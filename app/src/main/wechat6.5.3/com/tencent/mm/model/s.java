package com.tencent.mm.model;

import android.content.Context;
import com.tencent.mm.i.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.storage.u;

public final class s {
    private c crW;

    public s(c cVar) {
        this.crW = cVar;
    }

    static int a(boolean z, String str, boolean z2) {
        int i = 3;
        a LX = c.wH().LX(str);
        if (LX == null) {
            LX = new u();
        }
        if (((int) LX.chr) == 0) {
            LX.setUsername(str);
            LX.tp();
            v(LX);
            if (z2) {
                i = 4;
            }
            LX.cU(i);
            LX.tw();
            c.wH().N(LX);
            return 1;
        } else if (!z) {
            return 3;
        } else {
            LX.tw();
            c.wH().a(str, LX);
            return 2;
        }
    }

    public static void u(u uVar) {
        if (uVar == null) {
            uVar = new u();
        }
        if (((int) uVar.chr) == 0) {
            uVar.setUsername("filehelper");
            ak.yW();
            if (c.wK().Mh(uVar.field_username) == null) {
                uVar.tq();
            } else {
                uVar.tp();
            }
            uVar.cU(3);
            ak.yW();
            c.wH().M(uVar);
        }
    }

    static void v(u uVar) {
        String str = uVar.field_username;
        Context context = aa.getContext();
        if (str.equals("qqsync")) {
            uVar.bS(context.getString(2131233257));
            uVar.bT(context.getString(2131233258));
            uVar.bU(context.getString(2131233259));
        }
        if (str.equals("floatbottle")) {
            uVar.bS(context.getString(2131233208));
            uVar.bT(context.getString(2131233209));
            uVar.bU(context.getString(2131233210));
        }
        if (str.equals("shakeapp")) {
            uVar.bS(context.getString(2131233264));
            uVar.bT(context.getString(2131233265));
            uVar.bU(context.getString(2131233266));
        }
        if (str.equals("lbsapp")) {
            uVar.bS(context.getString(2131233229));
            uVar.bT(context.getString(2131233230));
            uVar.bU(context.getString(2131233231));
        }
        if (str.equals("medianote")) {
            uVar.bS(context.getString(2131233238));
            uVar.bT(context.getString(2131233239));
            uVar.bU(context.getString(2131233240));
        }
        if (str.equals("newsapp")) {
            uVar.bS(context.getString(2131233260));
            uVar.bT(context.getString(2131233261));
            uVar.bU(context.getString(2131233262));
        }
        if (str.equals("facebookapp")) {
            uVar.bS(context.getString(2131233214));
            uVar.bT(context.getString(2131233215));
            uVar.bU(context.getString(2131233216));
        }
        if (str.equals("qqfriend")) {
            uVar.bS(context.getString(2131233249));
            uVar.bT(context.getString(2131233250));
            uVar.bU(context.getString(2131233251));
        }
        if (str.equals("googlecontact")) {
            uVar.bS(context.getString(2131233223));
            uVar.bT(context.getString(2131233224));
            uVar.bU(context.getString(2131233225));
        }
        if (str.equals("masssendapp")) {
            uVar.bS(context.getString(2131233235));
            uVar.bT(context.getString(2131233236));
            uVar.bU(context.getString(2131233237));
        }
        if (str.equals("feedsapp")) {
            uVar.bS(context.getString(2131233217));
            uVar.bT(context.getString(2131233218));
            uVar.bU(context.getString(2131233219));
        }
        if (str.equals("qmessage")) {
            uVar.bS(context.getString(2131233248));
            uVar.bT(context.getString(2131233255));
            uVar.bU(context.getString(2131233256));
        }
        if (str.equals("fmessage")) {
            uVar.bS(context.getString(2131233220));
            uVar.bT(context.getString(2131233221));
            uVar.bU(context.getString(2131233222));
        }
        if (str.equals("voipapp")) {
            uVar.bS(context.getString(2131233271));
            uVar.bT(context.getString(2131233272));
            uVar.bU(context.getString(2131233273));
        }
        if (str.equals("officialaccounts")) {
            uVar.bS(context.getString(2131233245));
            uVar.bT(context.getString(2131233246));
            uVar.bU(context.getString(2131233247));
        }
        if (str.equals("helper_entry")) {
            uVar.bS(context.getString(2131233226));
            uVar.bT(context.getString(2131233227));
            uVar.bU(context.getString(2131233228));
        }
        if (str.equals("cardpackage")) {
            uVar.bS(context.getString(2131233211));
            uVar.bT(context.getString(2131233212));
            uVar.bU(context.getString(2131233213));
        }
        if (str.equals("voicevoipapp")) {
            uVar.bS(context.getString(2131233274));
            uVar.bT(context.getString(2131233275));
            uVar.bU(context.getString(2131233276));
        }
        if (str.equals("voiceinputapp")) {
            uVar.bS(context.getString(2131233268));
            uVar.bT(context.getString(2131233269));
            uVar.bU(context.getString(2131233270));
        }
        if (str.equals("qqmail")) {
            uVar.bS(context.getString(2131233252));
            uVar.bT(context.getString(2131233253));
            uVar.bU(context.getString(2131233254));
        }
        if (str.equals("linkedinplugin")) {
            uVar.bS(context.getString(2131233232));
            uVar.bT(context.getString(2131233233));
            uVar.bU(context.getString(2131233234));
        }
        if (str.equals("notifymessage")) {
            uVar.bS(context.getString(2131233242));
            uVar.bT(context.getString(2131233243));
            uVar.bU(context.getString(2131233244));
        }
        if (str.equals("appbrandcustomerservicemsg")) {
            uVar.bS(context.getString(2131233205));
            uVar.bT(context.getString(2131233206));
            uVar.bU(context.getString(2131233207));
        }
    }
}
