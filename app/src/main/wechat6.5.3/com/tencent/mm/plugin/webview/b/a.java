package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.a.g;
import com.tencent.mm.e.a.jy;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.Map;

public final class a implements e {
    a lcI = new a();
    private c lcJ = new c<jy>(this) {
        final /* synthetic */ a lcK;

        {
            this.lcK = r2;
            this.nhz = jy.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            jy jyVar = (jy) bVar;
            if (!(jyVar instanceof jy)) {
                return false;
            }
            this.lcK.lcI.a(jyVar.bkB.type, jyVar.bkB.bkC, jyVar.bkB.bkD, jyVar.bkB.bkE, jyVar.bkB.bkF);
            return true;
        }
    };

    private class a {
        boolean aHp;
        boolean bbq;
        final /* synthetic */ a lcK;
        private b lcL;
        private String lcM;
        private long lcN;

        private a(a aVar) {
            this.lcK = aVar;
        }

        public final void a(int i, String str, String str2, int i2, long j) {
            String str3;
            if (be.kS(str)) {
                String str4 = "MicroMsg.emoji.EmojiStoreWebViewLogic";
                String str5 = "error query:%s type:%d pagebuf:%s ";
                Object[] objArr = new Object[3];
                objArr[0] = str;
                objArr[1] = Integer.valueOf(i);
                if (str2 == null) {
                    str3 = "";
                } else {
                    str3 = str2.toString();
                }
                objArr[2] = str3;
                v.i(str4, str5, objArr);
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str);
            stringBuffer.append(i);
            str3 = g.m(stringBuffer.toString().getBytes());
            if (!be.kS(this.lcM) && this.lcM.equals(str3) && System.currentTimeMillis() - this.lcN <= 8000 && be.kS(str2)) {
                if (this.bbq) {
                    v.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "hit the search cache %s", new Object[]{str});
                    j.tl(i2).a(this.lcL.bhY().mQO, true, m.b(this.lcL.bhY().mxT), this.lcL.bhY().mxW);
                    return;
                } else if (this.aHp) {
                    if (this.lcL != null) {
                        this.lcL.lcO = i2;
                    }
                    v.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "wait the netscene running");
                    return;
                } else {
                    v.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "netscene error try again");
                }
            }
            v.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "start New NetScene query:%s newMD5:%s webviewID:%d", new Object[]{str, str3, Integer.valueOf(i2)});
            if (this.lcL != null) {
                ak.vy().c(this.lcL);
            }
            this.lcM = str3;
            this.lcN = System.currentTimeMillis();
            this.aHp = true;
            this.bbq = false;
            ak.vy().a(234, this.lcK);
            this.lcL = new b(i, str, str2.getBytes(), i2, j);
            ak.vy().a(this.lcL, 0);
        }
    }

    public a() {
        com.tencent.mm.sdk.c.a.nhr.e(this.lcJ);
    }

    public final boolean C(Map<String, Object> map) {
        v.i("MicroMsg.emoji.EmojiStoreWebViewLogic", "getSearchEmotionData: %s", new Object[]{map.toString()});
        String n = n(map, "keyword");
        String n2 = n(map, "nextPageBuffer");
        int o = o(map, Columns.TYPE);
        int o2 = o(map, "webview_instance_id");
        String n3 = n(map, "searchID");
        this.lcI.a(o, n, n2, o2, be.kS(n3) ? 0 : Long.valueOf(n3).longValue());
        return false;
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar instanceof b) {
            ak.vy().b(234, this);
            this.lcI.aHp = false;
            b bVar = (b) kVar;
            if (i == 0 && i2 == 0) {
                this.lcI.bbq = true;
            } else {
                this.lcI.bbq = false;
                j.tl(bVar.lcO).a("{}", bVar.lcP, "", 0);
            }
            j.tl(bVar.lcO).a(bVar.bhY().mQO, bVar.lcP, m.b(bVar.bhY().mxT), bVar.bhY().mxW);
        }
    }

    public static String n(Map<String, Object> map, String str) {
        if (map.containsKey(str)) {
            return map.get(str) != null ? map.get(str).toString() : "";
        } else {
            return "";
        }
    }

    public static int o(Map<String, Object> map, String str) {
        String n = n(map, str);
        if (be.kS(n)) {
            return 0;
        }
        return Integer.valueOf(n).intValue();
    }
}
