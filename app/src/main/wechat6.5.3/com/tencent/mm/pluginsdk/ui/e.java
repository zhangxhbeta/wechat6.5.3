package com.tencent.mm.pluginsdk.ui;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;
import java.util.Map;

public final class e {
    public int lGe = -7829368;
    public boolean lGf = false;
    public int lGg = -1593835521;
    public boolean lGh = false;
    public int lGi = WebView.NIGHT_MODE_COLOR;
    public boolean lGj = false;
    public int lGk = 0;
    public boolean lGl = false;
    private int version = 0;

    public e(String str) {
        String str2 = "chatbg";
        Map q = bf.q(str, str2);
        String str3 = "." + str2;
        try {
            this.version = be.f(Integer.valueOf((String) q.get(str3 + ".$version")));
            this.lGe = (int) be.a(Long.valueOf(Long.parseLong((String) q.get(str3 + ".$time_color"), 16)), -7829368);
            this.lGf = be.c(Boolean.valueOf((String) q.get(str3 + ".$time_show_shadow_color")));
            this.lGg = (int) be.a(Long.valueOf(Long.parseLong((String) q.get(str3 + ".$time_shadow_color"), 16)), 0);
            this.lGh = be.c(Boolean.valueOf((String) q.get(str3 + ".$time_show_background")));
            this.lGi = (int) be.a(Long.valueOf(Long.parseLong((String) q.get(str3 + ".$voice_second_color"), 16)), -16777216);
            this.lGj = be.c(Boolean.valueOf((String) q.get(str3 + ".$voice_second_show_shadow_color")));
            this.lGk = (int) be.a(Long.valueOf(Long.parseLong((String) q.get(str3 + ".$voice_second_shadow_color"), 16)), 0);
            this.lGl = be.c(Boolean.valueOf((String) q.get(str3 + ".$voice_second_show_background")));
        } catch (Throwable e) {
            v.e("MicroMsg.ChatBgAttr", "parse chatbgattr failed");
            v.a("MicroMsg.ChatBgAttr", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }
}
