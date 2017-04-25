package com.tencent.mm.plugin.gallery.model;

import android.net.Uri;
import android.provider.MediaStore.Video.Media;
import com.tencent.mm.plugin.gallery.model.GalleryItem.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

public final class n extends k {
    protected final int getType() {
        return 2;
    }

    public final ArrayList<a> aqE() {
        return super.aqE();
    }

    protected final Uri aqF() {
        return Media.EXTERNAL_CONTENT_URI;
    }

    protected final String[] getProjection() {
        return new String[]{"_id", "_data", "bucket_display_name", "count(*)", "COALESCE(" + k.ger, k.geq + ",0) AS " + ges, k.ger, k.geq, "mime_type"};
    }

    protected final String getSelection() {
        return "0==0) GROUP BY (bucket_display_name";
    }

    protected final String aqH() {
        return k.ger + " desc,_id desc";
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
        v.w("MicroMsg.VideoQuery", "get media item selection, but album name is null, do select all");
        return null;
    }
}
