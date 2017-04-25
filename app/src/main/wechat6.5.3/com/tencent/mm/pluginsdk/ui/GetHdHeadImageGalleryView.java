package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.MMGestureGallery.f;

public class GetHdHeadImageGalleryView extends MMGestureGallery {
    public String iJV;
    public o lGs;
    private Bitmap lGt;
    private Bitmap lGu;
    private a lGv;
    public String username;

    private class a extends BaseAdapter {
        final /* synthetic */ GetHdHeadImageGalleryView lGw;

        class a {
            ImageView bgv;
            ProgressBar gtf;
            View lGx;
            final /* synthetic */ a lGy;

            a(a aVar) {
                this.lGy = aVar;
            }
        }

        private a(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
            this.lGw = getHdHeadImageGalleryView;
        }

        public final int getCount() {
            return 1;
        }

        public final Object getItem(int i) {
            return Integer.valueOf(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                a aVar2 = new a(this);
                view = View.inflate(this.lGw.getContext(), 2130904577, null);
                aVar2.gtf = (ProgressBar) view.findViewById(2131759636);
                aVar2.bgv = (ImageView) view.findViewById(2131759634);
                aVar2.lGx = view.findViewById(2131759635);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            view.setLayoutParams(new LayoutParams(-1, -1));
            if (this.lGw.lGu != null) {
                aVar.gtf.setVisibility(8);
                aVar.bgv.setVisibility(8);
                aVar.lGx.setVisibility(8);
                view = new MultiTouchImageView(this.lGw.getContext(), this.lGw.lGu.getWidth(), this.lGw.lGu.getHeight());
                view.setLayoutParams(new LayoutParams(-1, -1));
                view.setImageBitmap(this.lGw.lGu);
                view.ah(2.0f);
                view.oad = true;
                return view;
            }
            aVar.gtf.setVisibility(0);
            aVar.lGx.setVisibility(0);
            if (this.lGw.lGt != null) {
                aVar.bgv.setVisibility(0);
                aVar.bgv.setImageBitmap(this.lGw.lGt);
                return view;
            }
            aVar.bgv.setVisibility(8);
            return view;
        }
    }

    private class b implements com.tencent.mm.ui.tools.MMGestureGallery.c {
        final /* synthetic */ GetHdHeadImageGalleryView lGw;

        private b(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
            this.lGw = getHdHeadImageGalleryView;
        }

        public final void amC() {
            if (this.lGw.iJV != null && this.lGw.username != null) {
                g.a(this.lGw.getContext(), null, this.lGw.getContext().getResources().getStringArray(2131296280), "", new com.tencent.mm.ui.base.g.c(this) {
                    final /* synthetic */ b lGz;

                    {
                        this.lGz = r1;
                    }

                    public final void gT(int i) {
                        switch (i) {
                            case 0:
                                String str = e.cgg + "hdImg_" + com.tencent.mm.a.g.m(this.lGz.lGw.username.getBytes()) + System.currentTimeMillis() + ".jpg";
                                FileOp.deleteFile(str);
                                FileOp.p(this.lGz.lGw.iJV, str);
                                d.c(str, this.lGz.lGw.getContext());
                                Toast.makeText(this.lGz.lGw.getContext(), this.lGz.lGw.getContext().getString(2131233186, new Object[]{e.cgg}), 1).show();
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        }
    }

    private class c implements f {
        final /* synthetic */ GetHdHeadImageGalleryView lGw;

        private c(GetHdHeadImageGalleryView getHdHeadImageGalleryView) {
            this.lGw = getHdHeadImageGalleryView;
        }

        public final void abF() {
            if (this.lGw.lGs != null) {
                this.lGw.lGs.dismiss();
            }
        }
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public GetHdHeadImageGalleryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        this.lGv = new a();
        setVerticalFadingEdgeEnabled(false);
        setHorizontalFadingEdgeEnabled(false);
        setAdapter(this.lGv);
        setSelection(0);
        this.oTm = new c();
        this.oTn = new b();
    }

    public final void setThumbImage(Bitmap bitmap) {
        this.lGt = bitmap;
        this.lGv.notifyDataSetChanged();
    }

    public final void B(Bitmap bitmap) {
        this.lGu = bitmap;
        this.lGv.notifyDataSetChanged();
    }
}
