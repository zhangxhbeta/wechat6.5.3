package com.tencent.mm.ui.bindmobile;

import android.content.Context;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.j;

public abstract class a extends j<com.tencent.mm.modelfriend.b> {

    public interface a {
        void vT(int i);
    }

    public interface b {
        void c(int i, String str, int i2);
    }

    public a(Context context, com.tencent.mm.modelfriend.b bVar) {
        super(context, bVar);
    }

    public void a(a aVar) {
    }

    public void uU(String str) {
    }

    public static void OC(String str) {
        ak.yW();
        com.tencent.mm.i.a LX = c.wH().LX(str);
        if (LX == null) {
            LX = new u(str);
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
            v.e("MicroMsg.MobileFriendAdapterBase", "addContact : insert contact failed");
        } else {
            m.n(LX);
        }
    }
}
