package com.tencent.mm.pluginsdk.ui.chat;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;

final class i {
    private ContentResolver cYl = this.mContext.getContentResolver();
    protected Context mContext;

    public interface a {
        int bqm();
    }

    protected i(Context context) {
        this.mContext = context;
    }

    private String HK(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.RecentPhotoTips.ImageQuery", "null or nill imageId");
            return null;
        }
        try {
            Cursor query = this.cYl.query(Thumbnails.EXTERNAL_CONTENT_URI, null, "image_id=\"" + str + "\"", null, null);
            if (query == null) {
                v.e("MicroMsg.RecentPhotoTips.ImageQuery", "get cursor null:" + str);
                return null;
            }
            String string;
            if (query.moveToFirst()) {
                do {
                    string = query.getString(query.getColumnIndexOrThrow("_data"));
                } while (query.moveToNext());
            } else {
                string = null;
            }
            query.close();
            return string;
        } catch (Exception e) {
            v.e("MicroMsg.RecentPhotoTips.ImageQuery", "query thumb exception e : %s", e.toString());
            return null;
        }
    }

    public final ArrayList<h> bqr() {
        ArrayList<h> arrayList = new ArrayList();
        String stringBuilder = new StringBuilder("date_added desc limit 1").toString();
        String[] strArr = new String[]{"_id", "_data", "date_added"};
        be.Ni();
        try {
            Cursor query = this.cYl.query(Media.EXTERNAL_CONTENT_URI, strArr, null, null, stringBuilder);
            if (query == null) {
                return arrayList;
            }
            if (query.moveToFirst()) {
                do {
                    String string = query.getString(query.getColumnIndexOrThrow("_id"));
                    String string2 = query.getString(query.getColumnIndexOrThrow("_data"));
                    String string3 = query.getString(query.getColumnIndexOrThrow("date_added"));
                    String HK = HK(string);
                    if (be.kS(string2) || !e.aR(string2)) {
                        v.e("MicroMsg.RecentPhotoTips.ImageQuery", "file not exist");
                    } else if (string2.startsWith(com.tencent.mm.compatible.util.e.cgg)) {
                        v.i("MicroMsg.RecentPhotoTips.ImageQuery", "exclude weixin path image");
                    } else {
                        h hVar = new h();
                        hVar.lNL = be.getLong(string, 0);
                        hVar.geb = be.getLong(string3, 0);
                        if (!be.kS(HK) && e.aR(HK)) {
                            hVar.bdZ = HK;
                        }
                        if (!be.kS(string2) && e.aR(string2)) {
                            hVar.lNM = string2;
                        }
                        if (be.kS(hVar.lNM) && be.kS(hVar.lNM)) {
                            v.e("MicroMsg.RecentPhotoTips.ImageQuery", "thumb file and orignal file both not exist");
                        } else {
                            arrayList.add(hVar);
                        }
                    }
                } while (query.moveToNext());
            }
            query.close();
            return arrayList;
        } catch (Exception e) {
            v.e("MicroMsg.RecentPhotoTips.ImageQuery", "query photo exception e : %s", e.toString());
            return null;
        }
    }
}
