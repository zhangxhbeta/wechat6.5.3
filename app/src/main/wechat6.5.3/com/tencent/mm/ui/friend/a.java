package com.tencent.mm.ui.friend;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import java.util.LinkedList;

public final class a implements OnClickListener {
    private Context context;
    private a oNE;

    public interface a {
        void Ps(String str);

        void aS(String str, boolean z);
    }

    public static class b {
        public int hUa;
        public int position;
        public String username;
    }

    static /* synthetic */ void T(u uVar) {
        if (((int) uVar.chr) == 0) {
            ak.yW();
            c.wH().O(uVar);
            if (!be.kS(uVar.field_username)) {
                ak.yW();
                uVar = c.wH().LX(uVar.field_username);
            } else {
                return;
            }
        }
        if (((int) uVar.chr) <= 0) {
            v.e("MicroMsg.AddContactListener", "addContact : insert contact failed");
        } else {
            m.n(uVar);
        }
    }

    public a(Context context, a aVar) {
        this.context = context;
        this.oNE = aVar;
    }

    public final void onClick(View view) {
        b bVar = (b) view.getTag();
        final String str = bVar.username;
        int i = bVar.hUa;
        final int i2 = bVar.position;
        ak.yW();
        final ab LX = c.wH().LX(str);
        if (be.kS(LX.field_username)) {
            LX.setUsername(str);
        }
        com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.context, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
            final /* synthetic */ a oNF;

            public final void a(boolean z, boolean z2, String str, String str2) {
                if (z) {
                    a.T(LX);
                    this.oNF.oNE.Ps(str);
                    return;
                }
                this.oNF.oNE.aS(str, z2);
            }
        });
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(i));
        aVar.c(str, linkedList);
    }
}
