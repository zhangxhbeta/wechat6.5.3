package com.tencent.mm.plugin.ipcall.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager.e;
import android.support.v4.view.t;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMDotView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class i extends AlertDialog implements e {
    private TextView EI;
    private View eEX;
    private MMDotView fjs;
    private b gOq;
    private IPCallShareViewPager gOr;
    private OnClickListener gOs;
    private LinkedList<Integer> gOt;
    private Context mContext;
    private CharSequence up;

    public static class a extends BaseAdapter {
        OnClickListener gOu;
        List<Integer> grq = null;
        private Context mContext;

        public class a {
            final /* synthetic */ a gOv;
            RelativeLayout gOw;
            TextView gOx;
            ImageView gOy;
            int id;

            public a(a aVar) {
                this.gOv = aVar;
            }
        }

        public a(Context context) {
            Assert.assertTrue(context != null);
            this.mContext = context;
        }

        public final int getCount() {
            return this.grq == null ? 0 : this.grq.size();
        }

        public final Object getItem(int i) {
            if (this.grq != null) {
                return this.grq.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130903840, viewGroup, false);
                aVar = new a(this);
                aVar.gOw = (RelativeLayout) view.findViewById(2131757519);
                aVar.gOx = (TextView) view.findViewById(2131757651);
                aVar.gOy = (ImageView) view.findViewById(2131757650);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            aVar.id = ((Integer) getItem(i)).intValue();
            IPCallShareCouponCardUI.a(this.mContext, aVar.id, aVar.gOx, aVar.gOy);
            aVar.gOw.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ a gOv;

                {
                    this.gOv = r1;
                }

                public final void onClick(View view) {
                    if (this.gOv.gOu != null) {
                        this.gOv.gOu.onClick(view);
                    }
                }
            });
            return view;
        }
    }

    public class b extends t {
        ArrayList<View> gOA = new ArrayList();
        final /* synthetic */ i gOB;
        OnClickListener gOu;
        LinkedList<Integer> gOz;
        int mCount = 0;

        public b(i iVar) {
            this.gOB = iVar;
        }

        public final int getCount() {
            return this.mCount;
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            v.v("MicroMsg.IPCallShareDialog", "destroy item: %d", new Object[]{Integer.valueOf(i)});
            viewGroup.removeView((View) obj);
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view;
            if (this.gOA.get(i) != null) {
                view = (View) this.gOA.get(i);
            } else {
                view = null;
            }
            if (view != null) {
                if (view.getParent() != null) {
                    ((ViewGroup) view.getParent()).removeView(view);
                }
                if (viewGroup != null) {
                    viewGroup.addView(view, 0);
                }
            }
            return view;
        }

        public final int j(Object obj) {
            return super.j(obj);
        }
    }

    protected final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().getAttributes().width = getWindow().getWindowManager().getDefaultDisplay().getWidth();
        getWindow().setGravity(80);
        getWindow().getDecorView().setPadding(0, 0, 0, 0);
        setContentView(this.eEX);
    }

    public final void W(int i) {
        if (this.gOq.getCount() <= 1) {
            this.fjs.setVisibility(4);
            return;
        }
        this.fjs.setVisibility(0);
        this.fjs.wt(this.gOq.getCount());
        this.fjs.wu(i);
    }

    public final void X(int i) {
    }

    public final void a(int i, float f, int i2) {
    }

    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.up = charSequence;
        } else {
            this.up = null;
        }
    }

    public final void show() {
        if (this.gOt != null && this.gOt.size() != 0) {
            this.gOr.b(this);
            b bVar = new b(this);
            bVar.gOu = this.gOs;
            bVar.gOz = this.gOt;
            if (bVar.gOz.size() > 0) {
                bVar.mCount = ((bVar.gOz.size() - 1) / 9) + 1;
            } else {
                bVar.mCount = 0;
            }
            int i = 0;
            while (i < bVar.mCount) {
                View inflate = ((LayoutInflater) bVar.gOB.mContext.getSystemService("layout_inflater")).inflate(2130903839, null);
                GridView gridView = (GridView) inflate.findViewById(2131757649);
                List arrayList = new ArrayList();
                int i2 = i * 9;
                while (i2 < bVar.gOz.size() && i2 < (i * 9) + 9) {
                    arrayList.add(bVar.gOz.get(i2));
                    i2++;
                }
                ListAdapter aVar = new a(bVar.gOB.getContext());
                aVar.gOu = bVar.gOu;
                aVar.grq = arrayList;
                gridView.setAdapter(aVar);
                bVar.gOA.add(inflate);
                i++;
            }
            this.gOq = bVar;
            this.gOr.a(this.gOq);
            this.EI.setText(this.up);
            super.show();
        }
    }

    public final void dismiss() {
        try {
            super.dismiss();
        } catch (Exception e) {
            v.e("MicroMsg.IPCallShareDialog", "dismiss exception, e = " + e.getMessage());
        }
    }
}
