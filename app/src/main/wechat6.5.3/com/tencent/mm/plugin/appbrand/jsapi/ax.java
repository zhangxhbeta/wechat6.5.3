package com.tencent.mm.plugin.appbrand.jsapi;

import android.text.TextUtils;
import com.tencent.mm.plugin.appbrand.f;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONObject;

public final class ax extends a {
    private static final int CTRL_INDEX = 45;
    private static final String NAME = "reportAction";

    public final void a(f fVar, JSONObject jSONObject, int i) {
        Throwable e;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(Columns.VALUE);
        v.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[]{optString, optString2});
        if (be.kS(optString) || be.kS(optString2)) {
            v.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            fVar.y(i, c("fail", null));
            return;
        }
        if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > 1024) {
            v.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            fVar.y(i, c("fail", null));
        }
        String str = "";
        String str2 = "";
        String str3 = "";
        if (TextUtils.isEmpty(fVar.dzg)) {
            v.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
            fVar.y(i, c("fail", null));
        }
        v.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", new Object[]{r12});
        int i2 = 0;
        if (ak.isConnected(fVar.mContext)) {
            if (ak.isWifi(fVar.mContext)) {
                i2 = 1;
            } else if (ak.is4G(fVar.mContext)) {
                i2 = 4;
            } else if (ak.is3G(fVar.mContext)) {
                i2 = 3;
            } else if (ak.is2G(fVar.mContext)) {
                i2 = 2;
            }
            v.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", new Object[]{Integer.valueOf(i2)});
        }
        long Nh = be.Nh();
        v.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[]{Long.valueOf(Nh), Integer.valueOf(13579), r12, Integer.valueOf(i2), str2, str3, str, optString, optString2});
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        try {
            str4 = URLEncoder.encode(be.ma(str2), "UTF-8");
            str5 = URLEncoder.encode(str3, "UTF-8");
            optString = URLEncoder.encode(optString, "UTF-8");
            try {
                str7 = URLEncoder.encode(optString2, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                v.a("MicroMsg.JsApiReportAction", e, "", new Object[0]);
                g.iuh.h(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Nh), Long.valueOf(Nh)});
                fVar.y(i, c("ok", null));
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            optString = str6;
            e = th;
            v.a("MicroMsg.JsApiReportAction", e, "", new Object[0]);
            g.iuh.h(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Nh), Long.valueOf(Nh)});
            fVar.y(i, c("ok", null));
        }
        g.iuh.h(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Nh), Long.valueOf(Nh)});
        fVar.y(i, c("ok", null));
    }

    public final void a(h hVar, JSONObject jSONObject, int i) {
        Throwable e;
        String optString = jSONObject.optString("key");
        String optString2 = jSONObject.optString(Columns.VALUE);
        v.i("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey =  %s, actionValue =  %s", new Object[]{optString, optString2});
        if (be.kS(optString) || be.kS(optString2)) {
            v.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue is null");
            hVar.y(i, c("fail", null));
            return;
        }
        if (optString.length() <= 0 || optString.length() > 32 || optString2.length() <= 0 || optString2.length() > 1024) {
            v.e("MicroMsg.JsApiReportAction", "doReportActionInfo, actionKey or actionValue size is bad");
            hVar.y(i, c("fail", null));
        }
        String str = "";
        String str2 = "";
        String str3 = "";
        if (TextUtils.isEmpty(hVar.dzg)) {
            v.e("MicroMsg.JsApiReportAction", "doReportActionInfo, appId is empty");
            hVar.y(i, c("fail", null));
        }
        v.i("MicroMsg.JsApiReportAction", "doReportActionInfo, appId %s", new Object[]{r12});
        int i2 = 0;
        if (ak.isConnected(hVar.getContext())) {
            if (ak.isWifi(hVar.getContext())) {
                i2 = 1;
            } else if (ak.is4G(hVar.getContext())) {
                i2 = 4;
            } else if (ak.is3G(hVar.getContext())) {
                i2 = 3;
            } else if (ak.is2G(hVar.getContext())) {
                i2 = 2;
            }
            v.i("MicroMsg.JsApiReportAction", "doReportActionInfo, get networkType %d", new Object[]{Integer.valueOf(i2)});
        }
        long Nh = be.Nh();
        v.d("MicroMsg.JsApiReportAction", "report(%s), clickTimestamp : %d, appID %s, networkType %d, userAgent %s, url : %s, sessionID : %s, actionKey : %s, actionValue : %s", new Object[]{Long.valueOf(Nh), Integer.valueOf(13579), r12, Integer.valueOf(i2), str2, str3, str, optString, optString2});
        String str4 = "";
        String str5 = "";
        String str6 = "";
        String str7 = "";
        try {
            str4 = URLEncoder.encode(be.ma(str2), "UTF-8");
            str5 = URLEncoder.encode(str3, "UTF-8");
            optString = URLEncoder.encode(optString, "UTF-8");
            try {
                str7 = URLEncoder.encode(optString2, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                v.a("MicroMsg.JsApiReportAction", e, "", new Object[0]);
                g.iuh.h(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Nh), Long.valueOf(Nh)});
                hVar.y(i, c("ok", null));
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            optString = str6;
            e = th;
            v.a("MicroMsg.JsApiReportAction", e, "", new Object[0]);
            g.iuh.h(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Nh), Long.valueOf(Nh)});
            hVar.y(i, c("ok", null));
        }
        g.iuh.h(13579, new Object[]{r12, Integer.valueOf(i2), str4, str5, str, optString, str7, Long.valueOf(Nh), Long.valueOf(Nh)});
        hVar.y(i, c("ok", null));
    }
}
