package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.mm.plugin.gallery.model.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageFolderMgrView extends LinearLayout implements OnItemClickListener, com.tencent.mm.plugin.gallery.model.g.a {
    boolean Su = false;
    a ggg = null;
    FrameLayout ggh;
    private View ggi;
    private ListView ggj;
    private b ggk;
    boolean ggl = false;

    public interface a {
        void a(com.tencent.mm.plugin.gallery.model.GalleryItem.a aVar);
    }

    public ImageFolderMgrView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setOrientation(1);
        this.ggh = new FrameLayout(getContext());
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        this.ggh.setVisibility(8);
        addView(this.ggh, layoutParams);
        this.ggi = new View(getContext());
        this.ggi.setBackgroundColor(-872415232);
        this.ggi.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ImageFolderMgrView ggm;

            {
                this.ggm = r1;
            }

            public final void onClick(View view) {
                this.ggm.dl(false);
            }
        });
        this.ggh.addView(this.ggi, new FrameLayout.LayoutParams(-1, -1));
        this.ggj = new ListView(getContext());
        this.ggj.setCacheColorHint(0);
        this.ggj.setBackgroundResource(2131689900);
        this.ggj.setSelector(2130838689);
        this.ggj.setOnItemClickListener(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131493168);
        this.ggj.setPadding(dimensionPixelSize, dimensionPixelSize / 3, dimensionPixelSize, (dimensionPixelSize * 2) / 3);
        layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = getResources().getDimensionPixelSize(2131493015);
        layoutParams.gravity = 80;
        this.ggh.addView(this.ggj, layoutParams);
        this.ggk = new b(getContext(), c.aqn().aqM());
        this.ggj.setAdapter(this.ggk);
    }

    public final void aqT() {
        dl(!this.Su);
    }

    private void dl(boolean z) {
        if (this.Su == z) {
            v.d("MicroMsg.ImageFolderMgrView", "want to expand, but same status, expanded %B", new Object[]{Boolean.valueOf(this.Su)});
        } else if (this.ggl) {
            v.d("MicroMsg.ImageFolderMgrView", "want to expand[%B], but now in animation", new Object[]{Boolean.valueOf(z)});
        } else if (this.Su) {
            this.ggl = true;
            r0 = AnimationUtils.loadAnimation(getContext(), 2130968644);
            r0.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ ImageFolderMgrView ggm;

                {
                    this.ggm = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.ggm.ggh.setVisibility(8);
                    this.ggm.Su = false;
                    this.ggm.ggl = false;
                }
            });
            this.ggj.startAnimation(r0);
            this.ggi.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968623));
        } else {
            this.ggl = true;
            this.ggh.setVisibility(0);
            this.ggi.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130968622));
            r0 = AnimationUtils.loadAnimation(getContext(), 2130968646);
            r0.setAnimationListener(new AnimationListener(this) {
                final /* synthetic */ ImageFolderMgrView ggm;

                {
                    this.ggm = r1;
                }

                public final void onAnimationStart(Animation animation) {
                }

                public final void onAnimationRepeat(Animation animation) {
                }

                public final void onAnimationEnd(Animation animation) {
                    this.ggm.Su = true;
                    this.ggm.ggl = false;
                }
            });
            this.ggj.startAnimation(r0);
        }
    }

    public final void B(ArrayList<com.tencent.mm.plugin.gallery.model.GalleryItem.a> arrayList) {
        b bVar = this.ggk;
        bVar.gfO = arrayList;
        if (!(bVar.gfO == null || bVar.gfO.isEmpty() || ((com.tencent.mm.plugin.gallery.model.GalleryItem.a) bVar.gfO.get(0)).gdX == null)) {
            Iterator it = bVar.gfO.iterator();
            com.tencent.mm.plugin.gallery.model.GalleryItem.a aVar = null;
            while (it.hasNext()) {
                com.tencent.mm.plugin.gallery.model.GalleryItem.a aVar2 = (com.tencent.mm.plugin.gallery.model.GalleryItem.a) it.next();
                if (aVar == null) {
                    aVar = aVar2;
                } else {
                    if (aVar.gdX.geb >= aVar2.gdX.geb) {
                        aVar2 = aVar;
                    }
                    aVar = aVar2;
                }
            }
            if (aVar != null) {
                bVar.gfP.gdX = aVar.gdX;
            }
        }
        c.aqo().o(new Runnable(this) {
            final /* synthetic */ ImageFolderMgrView ggm;

            {
                this.ggm = r1;
            }

            public final void run() {
                this.ggm.ggk.notifyDataSetChanged();
            }

            public final String toString() {
                return super.toString() + "|onQueryAlbumFinished";
            }
        });
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        com.tencent.mm.plugin.gallery.model.GalleryItem.a ln = this.ggk.ln(i);
        if (ln == null) {
            v.d("MicroMsg.ImageFolderMgrView", "get folder failed:" + i);
            return;
        }
        if (this.ggg != null) {
            this.ggg.a(ln);
        }
        this.ggk.gfQ = be.ah(ln.gdW, "");
        this.ggj.setSelection(0);
        this.ggk.notifyDataSetChanged();
        this.ggi.performClick();
    }
}
