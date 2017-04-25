package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;

public class TimelineRefreshImageView extends ImageView {
    public TimelineRefreshImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TimelineRefreshImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void buildDrawingCache(boolean z) {
        try {
            Field declaredField = View.class.getDeclaredField(z ? "mDrawingCache" : "mUnscaledDrawingCache");
            declaredField.setAccessible(true);
            v.d("MicroMsg.TimelineRefreshImageView", ((Bitmap) declaredField.get(this)) == null ? "cache is null" : String.format("cache.width: %s, cache.height: %s, width: %s, height: %s", new Object[]{Integer.valueOf(((Bitmap) declaredField.get(this)).getWidth()), Integer.valueOf(((Bitmap) declaredField.get(this)).getHeight()), Integer.valueOf(getWidth()), Integer.valueOf(getHeight())}));
        } catch (Throwable e) {
            v.a("MicroMsg.TimelineRefreshImageView", e, "", new Object[0]);
            v.e("MicroMsg.TimelineRefreshImageView", "checkIfCanReuseDrawingCache error: %s", new Object[]{e.getMessage()});
        }
        v.d("MicroMsg.TimelineRefreshImageView", "buildDrawingCache, autoScale: %s, width: %s, height: %s, hash: %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(hashCode())});
        super.buildDrawingCache(z);
    }

    public void destroyDrawingCache() {
        super.destroyDrawingCache();
        v.d("MicroMsg.TimelineRefreshImageView", "destroyDrawingCache, width: %s, height: %s, hash: %s", new Object[]{Integer.valueOf(getWidth()), Integer.valueOf(getHeight()), Integer.valueOf(hashCode())});
    }
}
