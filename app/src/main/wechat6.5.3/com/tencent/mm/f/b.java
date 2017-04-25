package com.tencent.mm.f;

import android.content.Intent;
import com.tencent.mm.e.a.ab;
import com.tencent.mm.e.a.ab.a;
import com.tencent.mm.e.a.pm;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.tools.DisasterUI;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;

public final class b {
    public pm cav;
    String caw = null;
    private long cax = 0;
    private String cay = null;
    public c caz = new c<ab>(this) {
        final /* synthetic */ b caA;

        {
            this.caA = r2;
            this.nhz = ab.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ab abVar = (ab) bVar;
            a aVar = abVar.aXt;
            switch (aVar.type) {
                case 1:
                    b bVar2 = this.caA;
                    String str = aVar.aXv;
                    v.i("MicroMsg.BroadcastController", "cancelUIEvent %s", str);
                    if (be.kS(str) || str.equals(bVar2.caw)) {
                        if (bVar2.cav.bqO.visible) {
                            bVar2.cav.bqO.visible = false;
                            v.d("MicroMsg.BroadcastController", "stopTimer");
                            com.tencent.mm.sdk.c.a.nhr.z(bVar2.cav);
                            break;
                        }
                    }
                    v.i("MicroMsg.BroadcastController", "cancelUIEvent now:%s, want to cancel:%s, drop id", bVar2.caw, str);
                    break;
                    break;
                case 2:
                    abVar.aXu.desc = this.caA.cav.bqO.desc;
                    abVar.aXu.aXw = this.caA.cav.bqO.aXw;
                    abVar.aXu.aXx = this.caA.cav.bqO.aXx;
                    abVar.aXu.url = this.caA.cav.bqO.url;
                    abVar.aXu.visible = this.caA.cav.bqO.visible;
                    abVar.aXu.aXA = this.caA.cav.bqO.aXA;
                    abVar.aXu.aXy = this.caA.cav.bqO.aXy;
                    abVar.aXu.aXz = this.caA.cav.bqO.aXz;
                    this.caA.qN();
                    break;
                case 4:
                    this.caA.dn(aVar.aXv);
                    break;
            }
            return false;
        }
    };

    final boolean dn(String str) {
        String str2 = null;
        if (!q.dri) {
            if (this.cax == 0 || be.az(this.cax) >= 1800000) {
                this.cax = be.Nj();
            } else {
                v.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
                return false;
            }
        }
        v.i("MicroMsg.BroadcastController", "handleEventNew event:%s", str);
        if (be.kS(str) || str.indexOf("<") < 0) {
            return false;
        }
        Map q = bf.q(str, "e");
        if (q == null) {
            v.e("MicroMsg.BroadcastController", "this is not errmsg");
            return false;
        }
        if (!q.drj) {
            try {
                if (be.ax(be.getLong((String) q.get(".e.ExpiredTime"), 0)) > 0) {
                    v.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", Long.valueOf(be.getLong((String) q.get(".e.ExpiredTime"), 0)));
                    return false;
                }
            } catch (Exception e) {
                v.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", e);
            }
        }
        this.caw = (String) q.get(".e.NoticeId");
        String string = aa.getContext().getSharedPreferences("disaster_pref", 4).getString("disaster_noticeid_list_key", SQLiteDatabase.KeyEmpty);
        if (q.drk || !string.contains(this.caw)) {
            String str3;
            String str4;
            String dJ = u.dJ(aa.getContext());
            String str5 = null;
            String str6 = null;
            int i = 0;
            while (true) {
                str3 = ".e.Item" + (i == 0 ? SQLiteDatabase.KeyEmpty : Integer.valueOf(i));
                string = (String) q.get(str3 + ".Language");
                if (dJ.equalsIgnoreCase(string)) {
                    break;
                }
                if ("en".equalsIgnoreCase(string)) {
                    string = (String) q.get(str3 + ".Content");
                    str4 = (String) q.get(str3 + ".Url");
                    str3 = (String) q.get(str3 + ".Tips");
                } else {
                    str3 = str2;
                    str4 = str5;
                    string = str6;
                }
                str5 = str4;
                str6 = string;
                i++;
                str2 = str3;
            }
            string = (String) q.get(str3 + ".Content");
            str4 = (String) q.get(str3 + ".Url");
            str3 = (String) q.get(str3 + ".Tips");
            if (be.kS(string)) {
                v.i("MicroMsg.BroadcastController", "handleEventNew cann't hit curLang");
            } else {
                str5 = str4;
                str6 = string;
                str2 = str3;
            }
            if (be.kS(str6)) {
                v.i("MicroMsg.BroadcastController", "handleEventNew defContent is also null");
                return false;
            }
            if (be.kS(str2)) {
                str2 = str6;
            }
            this.cav.bqO.desc = str2;
            this.cav.bqO.url = str5;
            this.cav.bqO.visible = true;
            this.cav.bqO.aXy = 2;
            com.tencent.mm.sdk.c.a.nhr.z(this.cav);
            this.cay = str6;
            if (ak.vy().foreground) {
                qN();
            }
            return true;
        }
        v.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", string, this.caw);
        return false;
    }

    final void qN() {
        if (!be.kS(this.cay)) {
            Intent intent = new Intent();
            intent.putExtra("key_disaster_content", this.cay);
            intent.putExtra("key_disaster_url", this.cav.bqO.url);
            intent.setClass(aa.getContext(), DisasterUI.class).addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            aa.getContext().startActivity(intent);
            this.cay = null;
        }
    }
}
