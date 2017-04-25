package com.tencent.mm.plugin.ext.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.e.a.ge;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsearch.FTSUtils;
import com.tencent.mm.modelsimple.y;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.ext.ui.RedirectToChattingByPhoneStubUI;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public final class c {
    private static Map<String, a> fGO = null;
    final e cii = new e(this) {
        final /* synthetic */ c fGP;

        {
            this.fGP = r1;
        }

        public final void a(int i, int i2, String str, k kVar) {
            ak.vy().b((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, (e) this);
            if (i == 0 && i2 == 0) {
                v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: searched data.");
                ars Jx = ((y) kVar).Jx();
                v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: contact count: %d", Integer.valueOf(Jx.mxP));
                if (Jx.mxP > 0) {
                    if (Jx.mxQ.isEmpty()) {
                        v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no result is retrieved. start to search UI");
                        c.a(this.fGP, Jx);
                    }
                    if (Jx.mxQ.size() > 1) {
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("add_more_friend_search_scene", 3);
                            intent.putExtra("result", Jx.toByteArray());
                            v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
                            com.tencent.mm.plugin.ext.a.drp.x(intent, this.fGP.mContext);
                            return;
                        } catch (Throwable e) {
                            v.a("MicroMsg.RedirectToChattingByPhoneHelper", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                            return;
                        }
                    }
                    this.fGP.a((arq) Jx.mxQ.getFirst());
                    return;
                }
                v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: only one result is retrieved. start to chatting directly");
                this.fGP.a(Jx);
                return;
            }
            v.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: err net.errType: %d, errCode: %d", Integer.valueOf(i), Integer.valueOf(i2));
            c.a(this.fGP, null);
        }
    };
    private String fGM = SQLiteDatabase.KeyEmpty;
    private boolean fGN = false;
    private Context mContext = null;

    class a {
        final /* synthetic */ c fGP;
        ars fGQ = null;
        arq fGR = null;
        String userName = SQLiteDatabase.KeyEmpty;

        public a(c cVar, String str, ars com_tencent_mm_protocal_c_ars, arq com_tencent_mm_protocal_c_arq) {
            this.fGP = cVar;
            this.userName = str;
            this.fGQ = com_tencent_mm_protocal_c_ars;
            this.fGR = com_tencent_mm_protocal_c_arq;
        }
    }

    static /* synthetic */ void a(c cVar, ars com_tencent_mm_protocal_c_ars) {
        Intent intent = new Intent();
        intent.putExtra("add_more_friend_search_scene", 3);
        if (com_tencent_mm_protocal_c_ars != null) {
            try {
                intent.putExtra("result", com_tencent_mm_protocal_c_ars.toByteArray());
            } catch (IOException e) {
                v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: IOException: %s", e.toString());
            }
        }
        v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: more than one contact is resolved. starting to ContactSearchResultUI");
        com.tencent.mm.plugin.ext.a.drp.x(intent, cVar.mContext);
    }

    public c(Context context, String str) {
        this.mContext = context;
        this.fGM = str;
        this.fGN = true;
    }

    public final int akS() {
        if (this.mContext == null) {
            v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: context is null");
            return -1;
        } else if (be.kS(this.fGM)) {
            v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: phone is null");
            return -1;
        } else {
            String Kq = al.Kq(this.fGM);
            if (be.kS(Kq)) {
                v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: pure num is null");
                return -1;
            }
            a aVar;
            String str = this.fGM;
            if (be.kS(str)) {
                v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when get from cache");
                aVar = null;
            } else {
                if (fGO == null) {
                    fGO = new HashMap();
                }
                aVar = (a) fGO.get(str);
            }
            if (aVar != null) {
                v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: got from cache");
                return a(aVar.userName, aVar.fGQ, aVar.fGR);
            }
            b geVar = new ge();
            geVar.bfG.bfI = Kq;
            com.tencent.mm.sdk.c.a.nhr.z(geVar);
            str = geVar.bfH.userName;
            if (be.kS(str)) {
                v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: not found from local storage. Try to find from search");
                ak.vy().a((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this.cii);
                ak.vy().a(new y(FTSUtils.jG(Kq), 3), 0);
                Intent intent = new Intent(this.mContext, RedirectToChattingByPhoneStubUI.class);
                intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                this.mContext.startActivity(intent);
                return 2;
            }
            v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: has found username: %s", str);
            return a(str, null, null);
        }
    }

    private static void a(String str, a aVar) {
        if (be.kS(str)) {
            v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: username is null when put to cache");
            return;
        }
        if (fGO == null) {
            fGO = new HashMap();
        }
        fGO.put(str, aVar);
    }

    private int a(String str, ars com_tencent_mm_protocal_c_ars, arq com_tencent_mm_protocal_c_arq) {
        if (this.mContext == null) {
            v.w("MicroMsg.RedirectToChattingByPhoneHelper", "hy: error param. start redirect param error: context is null");
            return -1;
        }
        if (!be.kS(str)) {
            ak.yW();
            if (com.tencent.mm.model.c.wH().LT(str)) {
                v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: is friend. direct to chatting");
                sI(str);
                return 0;
            }
        }
        if (com_tencent_mm_protocal_c_ars != null) {
            v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via searchResp");
            a(com_tencent_mm_protocal_c_ars);
            return 1;
        } else if (com_tencent_mm_protocal_c_arq != null) {
            v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: direct via SearchContactItem");
            a(com_tencent_mm_protocal_c_arq);
            return 1;
        } else {
            v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: no matching for starting redirect");
            return -1;
        }
    }

    private void sI(String str) {
        Intent intent = new Intent();
        intent.putExtra("Chat_User", str);
        intent.putExtra("finish_direct", false);
        com.tencent.mm.ay.c.a(this.mContext, ".ui.chatting.ChattingUI", intent);
    }

    private void a(ars com_tencent_mm_protocal_c_ars) {
        if (com_tencent_mm_protocal_c_ars == null) {
            v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: resp or context is null");
            return;
        }
        String a = m.a(com_tencent_mm_protocal_c_ars.moM);
        if (be.kS(a)) {
            v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            return;
        }
        a(this.fGM, new a(this, m.a(com_tencent_mm_protocal_c_ars.moM), com_tencent_mm_protocal_c_ars, null));
        ak.yW();
        if (com.tencent.mm.model.c.wH().LT(a)) {
            v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search response is friend. start to chatting");
            sI(a);
            return;
        }
        Intent intent = new Intent();
        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, com_tencent_mm_protocal_c_ars, 15);
        intent.putExtra("add_more_friend_search_scene", 2);
        com.tencent.mm.plugin.ext.a.drp.d(intent, this.mContext);
    }

    private void a(arq com_tencent_mm_protocal_c_arq) {
        if (com_tencent_mm_protocal_c_arq == null) {
            v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start to profile failed: item or context is null");
            return;
        }
        String a = m.a(com_tencent_mm_protocal_c_arq.moM);
        if (be.kS(a)) {
            v.e("MicroMsg.RedirectToChattingByPhoneHelper", "hy: start failed: no user name");
            return;
        }
        a(this.fGM, new a(this, m.a(com_tencent_mm_protocal_c_arq.moM), null, com_tencent_mm_protocal_c_arq));
        ak.yW();
        if (com.tencent.mm.model.c.wH().LT(a)) {
            v.i("MicroMsg.RedirectToChattingByPhoneHelper", "hy: search item is friend. start to chatting");
            sI(a);
            return;
        }
        Intent intent = new Intent();
        com.tencent.mm.pluginsdk.ui.tools.c.a(intent, com_tencent_mm_protocal_c_arq, 15);
        intent.putExtra("add_more_friend_search_scene", 2);
        com.tencent.mm.plugin.ext.a.drp.d(intent, this.mContext);
    }
}
