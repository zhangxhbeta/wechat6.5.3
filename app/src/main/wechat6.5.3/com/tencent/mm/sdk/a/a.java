package com.tencent.mm.sdk.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class a {

    public static class a {
        public String content;
        public int flags = -1;
        public String nhj;
        public String nhk;
        public Bundle nhl;

        public final String toString() {
            return "targetPkgName:" + this.nhj + ", targetClassName:" + this.nhk + ", content:" + this.content + ", flags:" + this.flags + ", bundle:" + this.nhl;
        }
    }

    public static boolean a(Context context, a aVar) {
        if (context == null) {
            v.e("MicroMsg.SDK.MMessageAct", "send fail, invalid argument");
            return false;
        } else if (be.kS(aVar.nhj)) {
            v.e("MicroMsg.SDK.MMessageAct", "send fail, invalid targetPkgName, targetPkgName = " + aVar.nhj);
            return false;
        } else {
            if (be.kS(aVar.nhk)) {
                aVar.nhk = aVar.nhj + ".wxapi.WXEntryActivity";
            }
            v.d("MicroMsg.SDK.MMessageAct", "send, targetPkgName = " + aVar.nhj + ", targetClassName = " + aVar.nhk);
            Intent intent = new Intent();
            intent.setClassName(aVar.nhj, aVar.nhk);
            if (aVar.nhl != null) {
                intent.putExtras(aVar.nhl);
            }
            String packageName = context.getPackageName();
            intent.putExtra("_mmessage_sdkVersion", 587333634);
            intent.putExtra("_mmessage_appPackage", packageName);
            intent.putExtra("_mmessage_content", aVar.content);
            String str = "_mmessage_checksum";
            String str2 = aVar.content;
            StringBuffer stringBuffer = new StringBuffer();
            if (str2 != null) {
                stringBuffer.append(str2);
            }
            stringBuffer.append(587333634);
            stringBuffer.append(packageName);
            stringBuffer.append("mMcShCsTr");
            intent.putExtra(str, g.m(stringBuffer.toString().substring(1, 9).getBytes()).getBytes());
            if (aVar.flags == -1) {
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY).addFlags(134217728);
            } else {
                intent.setFlags(aVar.flags);
            }
            try {
                context.startActivity(intent);
                v.d("MicroMsg.SDK.MMessageAct", "send mm message, intent=" + intent);
                return true;
            } catch (Exception e) {
                v.e("MicroMsg.SDK.MMessageAct", "send fail, ex = %s", e.getMessage());
                return false;
            }
        }
    }
}
