package com.tencent.mm.ui.widget;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.DragSortListView.h;
import com.tencent.smtt.sdk.WebView;

public class i implements h {
    private ListView Eq;
    private ImageView fqF;
    private Bitmap pen;
    int peo = WebView.NIGHT_MODE_COLOR;

    public i(ListView listView) {
        this.Eq = listView;
    }

    public final View yu(int i) {
        View childAt = this.Eq.getChildAt((this.Eq.getHeaderViewsCount() + i) - this.Eq.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.pen = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.fqF == null) {
            this.fqF = new ImageView(this.Eq.getContext());
        }
        this.fqF.setBackgroundColor(this.peo);
        this.fqF.setPadding(0, 0, 0, 0);
        this.fqF.setImageBitmap(this.pen);
        this.fqF.setLayoutParams(new LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.fqF;
    }

    public void d(Point point) {
    }

    public final void dc(View view) {
        ((ImageView) view).setImageDrawable(null);
        v.i("MicroMsg.SimpleFloatViewManager", "bitmap recycle %s", this.pen.toString());
        this.pen.recycle();
        this.pen = null;
    }
}
