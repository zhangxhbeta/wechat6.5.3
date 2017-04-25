package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.ay.c;
import com.tencent.mm.modelappbrand.AppBrandExportUrlParams;
import com.tencent.mm.plugin.appbrand.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfig;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import org.json.JSONObject;

public final class t extends a {
    public static final int CTRL_INDEX = 145;
    public static final String NAME = "enterContact";

    public final void a(final h hVar, JSONObject jSONObject, int i) {
        int i2 = -1;
        if (jSONObject == null) {
            hVar.y(i, c("fail", null));
            v.e("MicroMsg.JsApiEnterContact", "data is null");
            return;
        }
        String optString = jSONObject.optString("sessionFrom");
        if (be.kS(optString)) {
            hVar.y(i, c("fail", null));
            v.e("MicroMsg.JsApiEnterContact", "sessionFrom is null");
            return;
        }
        String str;
        int i3;
        String str2 = "";
        String str3 = "";
        String str4 = "";
        String str5 = "";
        AppBrandSysConfig mr = a.mr(hVar.dzg);
        if (mr != null) {
            str = mr.aWH;
            str2 = mr.aZU;
            str3 = mr.dDo;
            i3 = mr.dDB.dBs;
            i2 = mr.dDB.dBr;
        } else {
            str = str2;
            str2 = str3;
            str3 = str4;
            i3 = -1;
        }
        if (hVar.dNn != null) {
            str5 = hVar.dNn.dOM;
        }
        if (be.kS(str)) {
            v.e("MicroMsg.JsApiEnterContact", "onInsertView username is empty!!!");
        }
        final MainProcessTask jsApiChattingTask = new JsApiChattingTask();
        jsApiChattingTask.username = str;
        jsApiChattingTask.dFs = optString;
        jsApiChattingTask.cID = str2;
        jsApiChattingTask.dFt = str3;
        jsApiChattingTask.dJA = str5;
        jsApiChattingTask.dBr = i2;
        jsApiChattingTask.dBs = i3;
        jsApiChattingTask.dFu = new Runnable(this) {
            final /* synthetic */ t dGr;

            public final void run() {
                v.d("MicroMsg.JsApiEnterContact", "go to the chattingUI");
                Intent intent = new Intent();
                intent.setFlags(67108864);
                intent.putExtra("Chat_User", jsApiChattingTask.username);
                intent.putExtra("app_brand_chatting_from_scene", 2);
                intent.putExtra("app_brand_chatting_export_url_params", new AppBrandExportUrlParams(hVar.dzg, 5, jsApiChattingTask.dJA, jsApiChattingTask.dBs, jsApiChattingTask.dBr));
                intent.putExtra("key_temp_session_from", jsApiChattingTask.dFs);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                c.a(hVar.getContext(), ".ui.chatting.AppBrandServiceChattingUI", intent);
                jsApiChattingTask.PR();
            }
        };
        jsApiChattingTask.PQ();
        AppBrandMainProcessService.a(jsApiChattingTask);
    }
}
