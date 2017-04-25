package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.plugin.location.model.LocationInfo;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.pluginsdk.ui.tools.AppChooserUI;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.ArrayList;

public final class d {
    public int cTZ = -1;
    public Context context;
    private ActivityManager gTS;
    public int gTT = 0;
    public int gTU = 0;
    public boolean gTV = false;

    public static int dV(boolean z) {
        v.d("MicroMsg.MapHelper", new StringBuilder("getDefaultZoom isGoogle : false").toString());
        return 16;
    }

    public d(Context context) {
        this.context = context;
        this.gTS = (ActivityManager) context.getSystemService("activity");
    }

    public static Intent a(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        if (z || !locationInfo2.avY()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.gRK + "," + locationInfo.gRL + "?z=" + locationInfo.zoom));
            intent.setPackage("com.baidu.BaiduMap");
            return intent;
        }
        String format = String.format("intent://map/direction?origin=%f,%f&destination=%f,%f&mode=driving&coord_type=gcj02", new Object[]{Double.valueOf(locationInfo2.gRK), Double.valueOf(locationInfo2.gRL), Double.valueOf(locationInfo.gRK), Double.valueOf(locationInfo.gRL)});
        v.d("MicroMsg.MapHelper", "url " + format);
        try {
            format = format + "&referer=tencent|weixin#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end";
            v.d("MicroMsg.MapHelper", "all: " + format);
            return Intent.getIntent(format);
        } catch (Throwable e) {
            v.a("MicroMsg.MapHelper", e, "", new Object[0]);
            return null;
        }
    }

    public static Intent b(LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        if (z || !locationInfo2.avY()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.gRK + "," + locationInfo.gRL + "?z=" + locationInfo.zoom));
            intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(String.format("http://maps.google.com/maps?f=d&saddr=%f,%f&daddr=%f,%f&hl=" + (be.kS(locationInfo.gRN) ? "zh-cn" : locationInfo.gRN), new Object[]{Double.valueOf(locationInfo2.gRK), Double.valueOf(locationInfo2.gRL), Double.valueOf(locationInfo.gRK), Double.valueOf(locationInfo.gRL)})));
        intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
        return intent;
    }

    public static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z) {
        if (z || !locationInfo2.avY()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.gRK + "," + locationInfo.gRL + "?z=" + locationInfo.zoom));
            intent.setPackage("com.tencent.map");
            return intent;
        }
        String str = "&from=%s";
        String str2 = "&to=%s";
        String format = String.format("sosomap://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.gRL), Double.valueOf(locationInfo2.gRK), Double.valueOf(locationInfo.gRL), Double.valueOf(locationInfo.gRK)});
        if (!be.kS(locationInfo2.gRM)) {
            String encode = URLEncoder.encode(locationInfo2.gRM);
            format = format + String.format(str, new Object[]{encode});
        }
        if (!be.kS(locationInfo.gRM)) {
            str = URLEncoder.encode(locationInfo.gRM);
            format = format + String.format(str2, new Object[]{str});
        }
        v.d("MicroMsg.MapHelper", "tencentluxian, url=%s", new Object[]{format + "&referer=wx_client"});
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage("com.tencent.map");
        if (be.m(context, intent)) {
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.gRK + "," + locationInfo.gRL));
        intent.setPackage("com.tencent.map");
        return intent;
    }

    public static Intent a(Context context, LocationInfo locationInfo, LocationInfo locationInfo2, boolean z, String str) {
        if (z || !locationInfo2.avY()) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.gRK + "," + locationInfo.gRL + "?z=" + locationInfo.zoom));
            intent.setPackage(str);
            return intent;
        }
        String str2 = "&from=%s&to=%s";
        String format = String.format("wechatnav://type=nav&fromcoord=%f,%f&tocoord=%f,%f", new Object[]{Double.valueOf(locationInfo2.gRK), Double.valueOf(locationInfo2.gRL), Double.valueOf(locationInfo.gRK), Double.valueOf(locationInfo.gRL)});
        if (!(be.kS(locationInfo2.gRM) || be.kS(locationInfo.gRM))) {
            format = format + String.format(str2, new Object[]{locationInfo2.gRM, locationInfo.gRM});
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
        intent.setPackage(str);
        if (be.m(context, intent)) {
            return intent;
        }
        intent = new Intent("android.intent.action.VIEW", Uri.parse("geo:" + locationInfo.gRK + "," + locationInfo.gRL));
        intent.setPackage(str);
        return intent;
    }

    public final void a(LocationInfo locationInfo, LocationInfo locationInfo2, int i) {
        if (locationInfo != null) {
            v.d("MicroMsg.MapHelper", "moreViewInWeb locationInfo " + locationInfo.gRK + "  " + locationInfo.gRL + " " + locationInfo.gRM);
        }
        if (locationInfo2 != null) {
            v.d("MicroMsg.MapHelper", "moreViewInWeb myLocation " + locationInfo2.gRK + "  " + locationInfo2.gRL + " " + locationInfo2.gRM);
        }
        if (i == 0) {
            if (locationInfo2.avY()) {
                this.cTZ = 1;
            } else {
                this.cTZ = 2;
            }
        } else if (i == 1) {
            if (locationInfo2.avY()) {
                this.cTZ = 3;
            } else {
                this.cTZ = 4;
            }
        }
        if (locationInfo != null) {
            String str = "android.intent.action.VIEW";
            Parcelable intent = new Intent(str, Uri.parse(String.format("geo:%f,%f", new Object[]{Double.valueOf(locationInfo.gRK), Double.valueOf(locationInfo.gRL)})));
            ArrayList arrayList = new ArrayList();
            arrayList.add(locationInfo);
            arrayList.add(locationInfo2);
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("locations", arrayList);
            Serializable arrayList2 = new ArrayList();
            arrayList2.add("com.tencent.map");
            arrayList2.add("com.google.android.apps.maps");
            arrayList2.add("com.baidu.BaiduMap");
            arrayList2.add("com.autonavi.minimap");
            arrayList2.add("com.sogou.map.android.maps");
            Intent intent2 = new Intent();
            intent2.setClass(this.context, AppChooserUI.class);
            intent2.putExtra("type", 1);
            intent2.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, this.context.getResources().getString(2131233527));
            intent2.putExtra("targetintent", intent);
            intent2.putExtra("targetwhitelist", arrayList2);
            intent2.putExtra("transferback", bundle);
            intent2.putExtra("scene", 6);
            ((Activity) this.context).startActivityForResult(intent2, 4098);
        }
    }
}
