package com.tencent.mm.f;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Map;
import org.json.JSONObject;

public final class a {
    public int aXw;
    public int aXx;
    public int aXy;
    public String aXz;
    public String cas;
    public String cat;
    public int cau;
    public String desc;
    public String url;

    public static a dm(String str) {
        if (be.kS(str)) {
            return null;
        }
        a aVar = new a();
        Map q = bf.q(str, "e");
        if (q == null) {
            v.d("MrcroMsg.Broadcast", "this is not errmsg");
            return null;
        }
        aVar.desc = (String) q.get(".e.Content");
        aVar.url = (String) q.get(".e.Url");
        aVar.aXz = (String) q.get(".e.Title");
        aVar.aXy = be.getInt((String) q.get(".e.Action"), 0);
        aVar.aXx = be.getInt((String) q.get(".e.ShowType"), 0);
        aVar.aXw = be.getInt((String) q.get(".e.DispSec"), 30);
        aVar.cas = (String) q.get(".e.Ok");
        aVar.cat = (String) q.get(".e.Cancel");
        aVar.cau = be.getInt((String) q.get("e.Countdown"), 0);
        if (dL(aVar.aXx)) {
            return aVar;
        }
        try {
            JSONObject jSONObject = new JSONObject((String) q.get(".e"));
            aVar.desc = jSONObject.getString("Content");
            aVar.url = jSONObject.getString("Url");
            aVar.aXz = jSONObject.getString("Title");
            aVar.aXy = be.getInt(jSONObject.getString("Action"), 0);
            aVar.aXx = be.getInt(jSONObject.getString("ShowType"), 0);
            aVar.aXw = be.getInt(jSONObject.getString("DispSec"), 30);
            aVar.cas = (String) q.get(".e.Ok");
            aVar.cat = (String) q.get(".e.Cancel");
            aVar.cau = be.getInt((String) q.get("e.Countdown"), 0);
            if (dL(aVar.aXx)) {
                return aVar;
            }
        } catch (Throwable e) {
            v.a("MrcroMsg.Broadcast", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return null;
    }

    private static boolean dL(int i) {
        if (i == 4 || i == 1 || i == 5 || i == 3) {
            return true;
        }
        return false;
    }

    public final boolean a(Context context, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if (this.aXx == 3 || this.aXx == 4) {
            if (be.kS(this.cas) && be.kS(this.cat)) {
                this.cas = context.getString(this.aXx == 3 ? 2131231183 : 2131231107);
                this.cat = context.getString(this.aXx == 3 ? 2131231104 : 2131231010);
            }
            if (be.kS(this.cas) || be.kS(this.cat)) {
                String str;
                String str2 = this.desc;
                String str3 = this.aXz;
                if (be.kS(this.cas)) {
                    str = this.cat;
                } else {
                    str = this.cas;
                }
                if (!be.kS(this.cas)) {
                    onClickListener2 = onClickListener;
                }
                g.a(context, str2, str3, str, onClickListener2);
            } else {
                g.b(context, this.desc, this.aXz, this.cas, this.cat, onClickListener, onClickListener2);
            }
            return true;
        } else if (this.aXx == 1) {
            g.A(context, this.desc, this.aXz);
            return true;
        } else if (this.aXx != 5) {
            return false;
        } else {
            g.A(context, this.desc, this.aXz);
            return true;
        }
    }
}
