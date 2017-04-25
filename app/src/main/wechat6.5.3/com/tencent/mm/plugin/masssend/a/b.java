package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.a.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiPausePlayVoice;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.v;

public final class b extends g {
    public static final String[] cic = new String[]{"CREATE TABLE IF NOT EXISTS massendinfo ( clientid text  PRIMARY KEY , status int  , createtime long  , lastmodifytime long  , filename text  , thumbfilename text  , tolist text  , tolistcount int  , msgtype int  , mediatime int  , datanetoffset int  , datalen int  , thumbnetoffset int  , thumbtotallen int  , reserved1 int  , reserved2 int  , reserved3 text  , reserved4 text  ) ", "CREATE INDEX IF NOT EXISTS  massendinfostatus_index ON massendinfo ( status )"};
    public com.tencent.mm.bg.g cuX;

    public b(com.tencent.mm.bg.g gVar) {
        this.cuX = gVar;
    }

    public static Bitmap b(String str, float f) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        Bitmap c = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.c(stringBuilder.append(c.wP()).append(trim).toString(), f);
        if (c != null) {
            return Bitmap.createScaledBitmap(c, (int) (((float) c.getWidth()) * f), (int) (((float) c.getHeight()) * f), true);
        }
        return c;
    }

    public static Bitmap wj(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        String trim = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        return j.lW(stringBuilder.append(c.wP()).append(trim).toString());
    }

    public static a f(String str, String str2, int i, int i2) {
        if (!e.aR(str)) {
            return null;
        }
        ak.yW();
        String wP = c.wP();
        int JQ = ExifHelper.JQ(str);
        String m = com.tencent.mm.a.g.m((str + System.currentTimeMillis()).getBytes());
        v.d("MicroMsg.MasSendInfoStorage", "insert : original img path = " + str);
        Options JS = d.JS(str);
        if (i2 != 0 || (e.aQ(str) <= 204800 && (JS == null || (JS.outHeight <= 960 && JS.outWidth <= 960)))) {
            e.a(wP, m, ".jpg", e.c(str, 0, e.aQ(str)));
        } else {
            if (!d.a(str, 960, 960, CompressFormat.JPEG, 70, wP, m)) {
                return null;
            }
            e.h(wP, m, m + ".jpg");
        }
        String str3 = m + ".jpg";
        v.d("MicroMsg.MasSendInfoStorage", "insert: compressed bigImgPath = " + str3);
        if (i2 == 0 && JQ != 0 && !d.a(wP + str3, JQ, CompressFormat.JPEG, wP, m + ".jpg")) {
            return null;
        }
        m = com.tencent.mm.a.g.m((str3 + System.currentTimeMillis()).getBytes());
        if (!d.a(wP + str3, 120, 120, CompressFormat.JPEG, 90, wP, m)) {
            return null;
        }
        v.d("MicroMsg.MasSendInfoStorage", "insert: thumbName = " + m);
        a aVar = new a();
        aVar.msgType = 3;
        aVar.hjq = str2;
        aVar.hjr = i;
        aVar.hjp = m;
        aVar.filename = str3;
        return aVar;
    }

    public static String a(a aVar) {
        switch (aVar.msgType) {
            case 1:
                return aVar.ayY();
            case 3:
                return aa.getContext().getResources().getString(2131231122);
            case JsApiPausePlayVoice.CTRL_INDEX /*34*/:
                return aa.getContext().getResources().getString(2131231177);
            case 43:
                return aa.getContext().getResources().getString(2131231176);
            default:
                return aa.getContext().getResources().getString(2131232084);
        }
    }

    public final a wk(String str) {
        a aVar = null;
        Cursor rawQuery = this.cuX.rawQuery("select massendinfo.clientid,massendinfo.status,massendinfo.createtime,massendinfo.lastmodifytime,massendinfo.filename,massendinfo.thumbfilename,massendinfo.tolist,massendinfo.tolistcount,massendinfo.msgtype,massendinfo.mediatime,massendinfo.datanetoffset,massendinfo.datalen,massendinfo.thumbnetoffset,massendinfo.thumbtotallen,massendinfo.reserved1,massendinfo.reserved2,massendinfo.reserved3,massendinfo.reserved4 from massendinfo   where massendinfo.clientid = \"" + be.lZ(str) + "\"", null);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                aVar = new a();
                aVar.b(rawQuery);
            }
            rawQuery.close();
        }
        return aVar;
    }
}
