package com.tencent.mm.ae.a;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.lang.ref.WeakReference;

public final class c {
    public WeakReference<ImageView> cOR;
    public int height = 0;
    private String url = SQLiteDatabase.KeyEmpty;
    public int width = 0;

    public c(ImageView imageView, String str) {
        this.cOR = new WeakReference(imageView);
        this.url = str;
    }

    public final ImageView AR() {
        if (this.cOR != null) {
            ImageView imageView = (ImageView) this.cOR.get();
            if (imageView != null) {
                return imageView;
            }
        }
        return null;
    }

    public final int GS() {
        Object obj = null;
        if (this.cOR != null) {
            obj = (View) this.cOR.get();
        }
        return obj == null ? super.hashCode() : obj.hashCode();
    }
}
