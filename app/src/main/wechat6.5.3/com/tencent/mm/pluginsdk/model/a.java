package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import java.util.List;

public final class a extends s {
    private final a lyR;
    private final Intent lyS;
    private final w lyT = new w();

    public enum a {
        TencentMap(0),
        GoogleMap(1),
        SogouMap(2),
        BaiduMap(3),
        AutonaviMap(4);
        
        public final int aJW;

        private a(int i) {
            this.aJW = i;
        }

        public final String getPackage() {
            switch (this) {
                case TencentMap:
                    return "com.tencent.map";
                case GoogleMap:
                    return "com.google.android.apps.maps";
                case SogouMap:
                    return "com.sogou.map.android.maps";
                case BaiduMap:
                    return "com.baidu.BaiduMap";
                case AutonaviMap:
                    return "com.autonavi.minimap";
                default:
                    return "com.tencent.map";
            }
        }

        public static a tt(int i) {
            switch (i) {
                case 0:
                    return TencentMap;
                case 1:
                    return GoogleMap;
                case 2:
                    return SogouMap;
                case 3:
                    return BaiduMap;
                case 4:
                    return AutonaviMap;
                default:
                    return TencentMap;
            }
        }
    }

    public a(Bundle bundle) {
        if (bundle == null || bundle.getParcelable("key_target_intent") == null) {
            this.lyR = a.TencentMap;
        } else {
            a tt = a.tt(bundle.getInt("key_map_app", a.TencentMap.aJW));
            if (a(aa.getContext(), tt, null) == null) {
                this.lyR = a.TencentMap;
            } else {
                this.lyR = tt;
            }
        }
        if (this.lyR == a.TencentMap) {
            this.lyS = null;
        } else {
            this.lyS = (Intent) bundle.getParcelable("key_target_intent");
        }
    }

    private static ResolveInfo a(Context context, a aVar, Intent intent) {
        if (intent == null) {
            intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("geo:%f,%f", new Object[]{Float.valueOf(0.0f), Float.valueOf(0.0f)})));
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (be.bP(queryIntentActivities)) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo != null && resolveInfo.activityInfo != null && aVar.getPackage().equals(resolveInfo.activityInfo.packageName)) {
                return resolveInfo;
            }
        }
        return null;
    }

    public final boolean dc(Context context) {
        if (this.lyR == a.TencentMap) {
            return this.lyT.dc(context);
        }
        return a(context, this.lyR, this.lyS) != null;
    }

    public final boolean Gn(String str) {
        return this.lyR.getPackage().equals(str);
    }

    public final String MV() {
        return this.lyR == a.TencentMap ? "http://softroute.map.qq.com/downloadfile?cid=00008&referer=wx_client" : null;
    }

    public final String bmO() {
        return this.lyR == a.TencentMap ? "TencentMap.apk" : null;
    }

    public final com.tencent.mm.pluginsdk.model.t.a bmP() {
        if (this.lyR == a.TencentMap) {
            return this.lyT.bmP();
        }
        com.tencent.mm.pluginsdk.model.t.a aVar = new com.tencent.mm.pluginsdk.model.t.a();
        aVar.lzY = -1;
        aVar.lzV = -1;
        ResolveInfo a = a(aa.getContext(), this.lyR, this.lyS);
        if (a == null) {
            return aVar;
        }
        aVar.lzZ = a(aa.getContext(), a);
        return aVar;
    }

    public final String a(Context context, ResolveInfo resolveInfo) {
        return this.lyT.a(context, resolveInfo);
    }
}
