package com.tencent.mm.plugin.gallery.model;

import android.net.Uri;
import android.provider.MediaStore.Images.Media;
import com.tencent.mm.plugin.gallery.model.GalleryItem.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class i extends k {
    private String[] gen = new String[]{"camera", "screenshot", "download"};

    protected final int getType() {
        return 1;
    }

    public final ArrayList<a> aqE() {
        return super.aqE();
    }

    public final Uri aqF() {
        return Media.EXTERNAL_CONTENT_URI;
    }

    public final String[] getProjection() {
        return new String[]{"_id", "_data", "bucket_display_name", "count(*)", "COALESCE(" + k.ger, k.geq + ",0) AS " + ges, k.ger, k.geq, "mime_type"};
    }

    public final String getSelection() {
        return "0==0) GROUP BY (bucket_display_name";
    }

    public final String aqH() {
        return k.ges + " desc,_id desc";
    }

    protected final String aqI() {
        return "bucket_display_name";
    }

    protected final String[] aqG() {
        return new String[]{"_id", "_data", "COALESCE(" + k.ger, k.geq + ",0) AS " + ges, k.ger, k.geq, "mime_type"};
    }

    protected final String tX(String str) {
        if (!be.kS(str)) {
            return "bucket_display_name=\"" + str + "\"";
        }
        v.w("MicroMsg.ImageQuery", "get media item selection, but album name is null, do select all");
        String stringBuilder = new StringBuilder("_size>10240").toString();
        String[] strArr = this.gen;
        int length = strArr.length;
        int i = 0;
        while (i < length) {
            i++;
            stringBuilder = stringBuilder + " or lower(_data) like '%" + strArr[i] + "%'";
        }
        v.d("MicroMsg.ImageQuery", "where %s", new Object[]{stringBuilder});
        return stringBuilder;
    }
}
