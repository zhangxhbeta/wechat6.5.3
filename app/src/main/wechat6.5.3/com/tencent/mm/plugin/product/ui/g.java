package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import java.util.ArrayList;
import java.util.List;

public final class g extends t {
    private List<String> hRK;
    private ArrayList<b> hSg;
    private boolean hSh;
    a hSi;
    Context mContext;

    public interface a {
        void aGu();
    }

    class b implements com.tencent.mm.platformtools.j.a {
        public ImageView bgv = null;
        final /* synthetic */ g hSj;
        public String url;

        public b(final g gVar, String str) {
            this.hSj = gVar;
            this.url = str;
            this.bgv = (ImageView) ((LayoutInflater) gVar.mContext.getSystemService("layout_inflater")).inflate(2130904182, null);
            this.bgv.setImageBitmap(j.a(new c(str)));
            this.bgv.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ b hSl;

                public final void onClick(View view) {
                    v.i("MicroMsg.MallProductImageAdapter", "henryyr user: clicked the ImageView");
                    if (this.hSl.hSj.hSi != null) {
                        this.hSl.hSj.hSi.aGu();
                    }
                }
            });
            j.a(this);
        }

        public final void k(String str, final Bitmap bitmap) {
            v.d("MicroMsg.MallProductImageAdapter", str + ", bitmap = " + (bitmap == null));
            if (this.url != null && str.equals(this.url)) {
                this.bgv.post(new Runnable(this) {
                    final /* synthetic */ b hSl;

                    public final void run() {
                        this.hSl.bgv.setImageBitmap(bitmap);
                    }
                });
            }
        }
    }

    public g(Context context) {
        this(context, (byte) 0);
    }

    private g(Context context, byte b) {
        this.hSh = false;
        this.hSi = null;
        this.mContext = context;
        this.hRK = null;
        aW(this.hRK);
    }

    public final void aW(List<String> list) {
        if (list != null) {
            if (list.size() > 0) {
                this.hRK = list;
            }
            if (this.hSg == null) {
                this.hSg = new ArrayList();
            } else {
                this.hSg.clear();
            }
            for (String bVar : this.hRK) {
                this.hSg.add(new b(this, bVar));
            }
        }
    }

    public final int getCount() {
        if (this.hRK == null) {
            return 0;
        }
        if (this.hSh) {
            return Integer.MAX_VALUE;
        }
        return this.hRK.size();
    }

    public final boolean a(View view, Object obj) {
        return view == obj;
    }

    public final void a(ViewGroup viewGroup, int i, Object obj) {
        v.d("MicroMsg.MallProductImageAdapter", "destroy item");
        if (this.hSg != null) {
            viewGroup.removeView(((b) this.hSg.get(i)).bgv);
        }
    }

    public final int j(Object obj) {
        return -2;
    }

    public final Object b(ViewGroup viewGroup, int i) {
        if (this.hSg == null) {
            return super.b(viewGroup, i);
        }
        v.d("MicroMsg.MallProductImageAdapter", "data valid");
        viewGroup.addView(((b) this.hSg.get(i)).bgv, 0);
        return ((b) this.hSg.get(i)).bgv;
    }
}
