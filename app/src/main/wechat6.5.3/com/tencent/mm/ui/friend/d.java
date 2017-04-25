package com.tencent.mm.ui.friend;

import android.content.Context;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.bl;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelfriend.af;
import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.j;

public abstract class d extends j<af> implements com.tencent.mm.u.d.a {

    public interface a {
        void vT(int i);
    }

    public d(Context context, af afVar) {
        super(context, afVar);
    }

    public void a(a aVar) {
    }

    public void uU(String str) {
    }

    public static void Pt(String str) {
        if (be.kS(str)) {
            v.w("MicroMsg.QQFriendAdapterBase", "deal add friend failed. username is null.");
            return;
        }
        af iM = ah.FQ().iM(str);
        if (iM != null) {
            iM.cIB = 2;
            ah.FQ().a(iM.cIA, iM);
        }
        ak.yW();
        com.tencent.mm.i.a LX = c.wH().LX(str);
        if (LX == null) {
            v.w("MicroMsg.QQFriendAdapterBase", "[cpan] dealAddFriend failed. contact is null.");
            return;
        }
        if (be.kS(LX.field_username)) {
            LX.setUsername(str);
        }
        if (((int) LX.chr) == 0) {
            ak.yW();
            c.wH().O(LX);
            if (!be.kS(LX.field_username)) {
                ak.yW();
                LX = c.wH().LX(LX.field_username);
            } else {
                return;
            }
        }
        if (((int) LX.chr) <= 0) {
            v.e("MicroMsg.QQFriendAdapterBase", "addContact : insert contact failed");
            return;
        }
        m.n(LX);
        bl.zQ().b(26, new Object[0]);
    }
}
