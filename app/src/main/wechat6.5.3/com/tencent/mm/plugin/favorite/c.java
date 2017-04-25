package com.tencent.mm.plugin.favorite;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.model.ab.a;
import com.tencent.mm.model.ab.b;
import com.tencent.mm.model.k;
import com.tencent.mm.model.o;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class c implements i {
    public static h drp;
    public static g drq;

    public final void a(h hVar) {
        drp = hVar;
    }

    public static void j(Intent intent, Context context) {
        intent.putExtra("geta8key_scene", 14);
        drp.j(intent, context);
    }

    public static void a(long j, qc qcVar, String str, String str2, ArrayList<String> arrayList, Context context) {
        if (qcVar != null && context != null) {
            Intent intent = new Intent();
            intent.putExtra("KFavLocSigleView", true);
            intent.putExtra("map_view_type", 2);
            intent.putExtra("kFavInfoLocalId", j);
            intent.putExtra("kwebmap_slat", qcVar.lat);
            intent.putExtra("kwebmap_lng", qcVar.lng);
            intent.putExtra("kPoiName", qcVar.bkV);
            intent.putExtra("Kwebmap_locaion", qcVar.label);
            if (qcVar.bhu >= 0) {
                intent.putExtra("kwebmap_scale", qcVar.bhu);
            }
            intent.putExtra("kisUsername", str);
            intent.putExtra("kwebmap_from_to", true);
            intent.putExtra("kRemark", str2);
            intent.putExtra("kTags", arrayList);
            intent.putExtra("kFavCanDel", true);
            intent.putExtra("kFavCanRemark", true);
            drp.o(intent, context);
        }
    }

    public static void d(String str, Context context) {
        if (be.kS(str)) {
            v.w("MicroMsg.FavApplication", "share image to timeline fail, filePath is null");
            return;
        }
        Intent intent = new Intent();
        String str2 = "fav_" + k.xF() + "_0";
        String fz = o.fz(str2);
        o.yx().n(fz, true).l("prePublishId", str2);
        intent.putExtra("reportSessionId", fz);
        drp.a(str, intent, context);
    }

    public static void e(String str, Context context) {
        if (be.kS(str)) {
            v.w("MicroMsg.FavApplication", "share image to friend fail, imgPath is null");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", str);
        intent.putExtra("Retr_Compress_Type", 0);
        intent.putExtra("Retr_Msg_Type", 0);
        drp.l(intent, context);
    }

    public static void a(String str, String str2, Context context) {
        if (be.kS(str)) {
            v.w("MicroMsg.FavApplication", "save image fail, path is null");
        } else if (!d.b(str, context)) {
            Toast.makeText(context, str2, 1).show();
        }
    }

    public static String getAppName(Context context, String str) {
        b bVar = a.csc;
        if (bVar != null) {
            return bVar.n(context, str);
        }
        return "";
    }

    public final void a(g gVar) {
        drq = gVar;
    }

    public static String bx(long j) {
        if (j == 0) {
            return "0KB";
        }
        if ((((double) j) * 1.0d) / 1048576.0d >= 1.0d) {
            return String.format("%dMB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1048576.0d))});
        } else if ((((double) j) * 1.0d) / 1024.0d < 1.0d) {
            return "1KB";
        } else {
            return String.format("%dKB", new Object[]{Integer.valueOf((int) ((((double) j) * 1.0d) / 1024.0d))});
        }
    }
}
