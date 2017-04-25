package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.platformtools.j.a;
import com.tencent.mm.plugin.shake.e.b;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.util.List;

public class TVThumbPreference extends Preference implements a {
    f ezq;
    private ImageView iTf;
    private ImageView iTg;
    private ImageView iTh;
    List<String> iTi;

    public TVThumbPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iTi = null;
        setLayoutResource(2130904560);
        setWidgetLayoutResource(0);
        j.a(this);
    }

    public TVThumbPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TVThumbPreference(Context context) {
        this(context, null);
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        return super.onCreateView(viewGroup);
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.iTf = (ImageView) view.findViewById(2131759596);
        this.iTg = (ImageView) view.findViewById(2131759597);
        this.iTh = (ImageView) view.findViewById(2131759598);
        if (this.iTi != null && this.iTi.size() > 0) {
            b bVar = new b((String) this.iTi.get(0));
            this.iTf.setTag(bVar.MW());
            Bitmap a = j.a(bVar);
            if (!(a == null || a.isRecycled())) {
                this.iTf.setImageBitmap(a);
            }
            this.iTf.setVisibility(0);
            if (1 < this.iTi.size()) {
                bVar = new b((String) this.iTi.get(1));
                this.iTg.setTag(bVar.MW());
                a = j.a(bVar);
                if (!(a == null || a.isRecycled())) {
                    this.iTg.setImageBitmap(a);
                }
                this.iTg.setVisibility(0);
                if (2 < this.iTi.size()) {
                    bVar = new b((String) this.iTi.get(2));
                    this.iTh.setTag(bVar.MW());
                    a = j.a(bVar);
                    if (!(a == null || a.isRecycled())) {
                        this.iTh.setImageBitmap(a);
                    }
                    this.iTh.setVisibility(0);
                }
            }
        }
    }

    public final void k(String str, final Bitmap bitmap) {
        if (str != null && bitmap != null && !bitmap.isRecycled()) {
            if (this.iTf != null && this.iTf.getTag() != null && str.equals((String) this.iTf.getTag())) {
                this.iTf.post(new Runnable(this) {
                    final /* synthetic */ TVThumbPreference iTj;

                    public final void run() {
                        this.iTj.iTf.setImageBitmap(bitmap);
                        if (this.iTj.ezq != null) {
                            this.iTj.ezq.notifyDataSetChanged();
                        }
                    }
                });
            } else if (this.iTg != null && this.iTg.getTag() != null && str.equals((String) this.iTg.getTag())) {
                this.iTg.post(new Runnable(this) {
                    final /* synthetic */ TVThumbPreference iTj;

                    public final void run() {
                        this.iTj.iTg.setImageBitmap(bitmap);
                        if (this.iTj.ezq != null) {
                            this.iTj.ezq.notifyDataSetChanged();
                        }
                    }
                });
            } else if (this.iTh != null && this.iTh.getTag() != null && str.equals((String) this.iTh.getTag())) {
                this.iTh.post(new Runnable(this) {
                    final /* synthetic */ TVThumbPreference iTj;

                    public final void run() {
                        this.iTj.iTh.setImageBitmap(bitmap);
                        if (this.iTj.ezq != null) {
                            this.iTj.ezq.notifyDataSetChanged();
                        }
                    }
                });
            }
        }
    }
}
