package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.a.a.h;
import android.support.v7.app.a.a.AnonymousClass1;
import android.support.v7.app.a.a.AnonymousClass2;
import android.support.v7.app.a.a.AnonymousClass3;
import android.support.v7.app.a.a.AnonymousClass4;
import android.support.v7.app.b;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import java.util.ArrayList;

public final class e implements l, OnItemClickListener {
    public LayoutInflater CE;
    int Pa;
    public ExpandedMenuView Po;
    private int Pp;
    int Pq;
    public a Pr;
    public android.support.v7.view.menu.l.a dU;
    f dV;
    private int dW;
    Context mContext;

    private class a extends BaseAdapter {
        private int Ps = -1;
        final /* synthetic */ e Pt;

        public final /* synthetic */ Object getItem(int i) {
            return av(i);
        }

        public a(e eVar) {
            this.Pt = eVar;
            dw();
        }

        public final int getCount() {
            int size = this.Pt.dV.dG().size() - this.Pt.Pp;
            return this.Ps < 0 ? size : size - 1;
        }

        public final h av(int i) {
            ArrayList dG = this.Pt.dV.dG();
            int a = this.Pt.Pp + i;
            if (this.Ps >= 0 && a >= this.Ps) {
                a++;
            }
            return (h) dG.get(a);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.Pt.CE.inflate(this.Pt.Pa, viewGroup, false);
            } else {
                inflate = view;
            }
            ((android.support.v7.view.menu.m.a) inflate).a(av(i));
            return inflate;
        }

        private void dw() {
            h hVar = this.Pt.dV.PO;
            if (hVar != null) {
                ArrayList dG = this.Pt.dV.dG();
                int size = dG.size();
                for (int i = 0; i < size; i++) {
                    if (((h) dG.get(i)) == hVar) {
                        this.Ps = i;
                        return;
                    }
                }
            }
            this.Ps = -1;
        }

        public final void notifyDataSetChanged() {
            dw();
            super.notifyDataSetChanged();
        }
    }

    public e(Context context, int i) {
        this(i);
        this.mContext = context;
        this.CE = LayoutInflater.from(this.mContext);
    }

    private e(int i) {
        this.Pa = i;
        this.Pq = 0;
    }

    public final void a(Context context, f fVar) {
        if (this.Pq != 0) {
            this.mContext = new ContextThemeWrapper(context, this.Pq);
            this.CE = LayoutInflater.from(this.mContext);
        } else if (this.mContext != null) {
            this.mContext = context;
            if (this.CE == null) {
                this.CE = LayoutInflater.from(this.mContext);
            }
        }
        this.dV = fVar;
        if (this.Pr != null) {
            this.Pr.notifyDataSetChanged();
        }
    }

    public final ListAdapter getAdapter() {
        if (this.Pr == null) {
            this.Pr = new a(this);
        }
        return this.Pr;
    }

    public final void f(boolean z) {
        if (this.Pr != null) {
            this.Pr.notifyDataSetChanged();
        }
    }

    public final boolean a(p pVar) {
        if (!pVar.hasVisibleItems()) {
            return false;
        }
        g gVar = new g(pVar);
        f fVar = gVar.dV;
        android.support.v7.app.b.a aVar = new android.support.v7.app.b.a(fVar.mContext);
        gVar.PR = new e(aVar.Fy.mContext, h.JS);
        gVar.PR.dU = gVar;
        gVar.dV.a(gVar.PR);
        aVar.Fy.EK = gVar.PR.getAdapter();
        aVar.Fy.Fi = gVar;
        View view = fVar.PH;
        if (view != null) {
            aVar.Fy.EJ = view;
        } else {
            aVar.Fy.jP = fVar.PG;
            aVar.Fy.up = fVar.PF;
        }
        aVar.Fy.Fg = gVar;
        b bVar = new b(aVar.Fy.mContext, aVar.ou);
        android.support.v7.app.a.a aVar2 = aVar.Fy;
        android.support.v7.app.a a = bVar.Fx;
        if (aVar2.EJ != null) {
            a.EJ = aVar2.EJ;
        } else {
            if (aVar2.up != null) {
                a.setTitle(aVar2.up);
            }
            if (aVar2.jP != null) {
                Drawable drawable = aVar2.jP;
                a.jP = drawable;
                a.EH = 0;
                if (a.kH != null) {
                    if (drawable != null) {
                        a.kH.setVisibility(0);
                        a.kH.setImageDrawable(drawable);
                    } else {
                        a.kH.setVisibility(8);
                    }
                }
            }
            if (aVar2.EH != 0) {
                a.setIcon(aVar2.EH);
            }
            if (aVar2.EX != 0) {
                int i = aVar2.EX;
                TypedValue typedValue = new TypedValue();
                a.mContext.getTheme().resolveAttribute(i, typedValue, true);
                a.setIcon(typedValue.resourceId);
            }
        }
        if (aVar2.Ep != null) {
            CharSequence charSequence = aVar2.Ep;
            a.Ep = charSequence;
            if (a.jp != null) {
                a.jp.setText(charSequence);
            }
        }
        if (aVar2.EY != null) {
            a.a(-1, aVar2.EY, aVar2.EZ, null);
        }
        if (aVar2.Fa != null) {
            a.a(-2, aVar2.Fa, aVar2.Fb, null);
        }
        if (aVar2.Fc != null) {
            a.a(-3, aVar2.Fc, aVar2.Fd, null);
        }
        if (!(aVar2.Fh == null && aVar2.Ay == null && aVar2.EK == null)) {
            ListAdapter cVar;
            ListView listView = (ListView) aVar2.CE.inflate(a.EO, null);
            Object simpleCursorAdapter;
            if (!aVar2.Fk) {
                int i2 = aVar2.Fl ? a.EQ : a.ER;
                if (aVar2.Ay != null) {
                    simpleCursorAdapter = new SimpleCursorAdapter(aVar2.mContext, i2, aVar2.Ay, new String[]{aVar2.Fn}, new int[]{16908308});
                } else {
                    cVar = aVar2.EK != null ? aVar2.EK : new c(aVar2.mContext, i2, aVar2.Fh);
                }
            } else if (aVar2.Ay == null) {
                cVar = new AnonymousClass1(aVar2, aVar2.mContext, a.EP, aVar2.Fh, listView);
            } else {
                simpleCursorAdapter = new AnonymousClass2(aVar2, aVar2.mContext, aVar2.Ay, listView, a);
            }
            a.EK = cVar;
            a.EL = aVar2.EL;
            if (aVar2.Fi != null) {
                listView.setOnItemClickListener(new AnonymousClass3(aVar2, a));
            } else if (aVar2.Fm != null) {
                listView.setOnItemClickListener(new AnonymousClass4(aVar2, listView, a));
            }
            if (aVar2.Fp != null) {
                listView.setOnItemSelectedListener(aVar2.Fp);
            }
            if (aVar2.Fl) {
                listView.setChoiceMode(1);
            } else if (aVar2.Fk) {
                listView.setChoiceMode(2);
            }
            a.Eq = listView;
        }
        if (aVar2.mView != null) {
            if (aVar2.Ew) {
                View view2 = aVar2.mView;
                int i3 = aVar2.Es;
                int i4 = aVar2.Et;
                int i5 = aVar2.Eu;
                int i6 = aVar2.Ev;
                a.mView = view2;
                a.Er = 0;
                a.Ew = true;
                a.Es = i3;
                a.Et = i4;
                a.Eu = i5;
                a.Ev = i6;
            } else {
                a.mView = aVar2.mView;
                a.Er = 0;
                a.Ew = false;
            }
        } else if (aVar2.Er != 0) {
            i = aVar2.Er;
            a.mView = null;
            a.Er = i;
            a.Ew = false;
        }
        bVar.setCancelable(aVar.Fy.ov);
        if (aVar.Fy.ov) {
            bVar.setCanceledOnTouchOutside(true);
        }
        bVar.setOnCancelListener(aVar.Fy.Fe);
        bVar.setOnDismissListener(aVar.Fy.Ff);
        if (aVar.Fy.Fg != null) {
            bVar.setOnKeyListener(aVar.Fy.Fg);
        }
        gVar.PQ = bVar;
        gVar.PQ.setOnDismissListener(gVar);
        LayoutParams attributes = gVar.PQ.getWindow().getAttributes();
        attributes.type = MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED;
        attributes.flags |= 131072;
        gVar.PQ.show();
        if (this.dU != null) {
            this.dU.d(pVar);
        }
        return true;
    }

    public final void a(f fVar, boolean z) {
        if (this.dU != null) {
            this.dU.a(fVar, z);
        }
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.dV.a(this.Pr.av(i), (l) this, 0);
    }

    public final boolean E() {
        return false;
    }

    public final boolean b(h hVar) {
        return false;
    }

    public final boolean c(h hVar) {
        return false;
    }

    public final int getId() {
        return this.dW;
    }

    public final Parcelable onSaveInstanceState() {
        if (this.Po == null) {
            return null;
        }
        Parcelable bundle = new Bundle();
        SparseArray sparseArray = new SparseArray();
        if (this.Po != null) {
            this.Po.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
        SparseArray sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.Po.restoreHierarchyState(sparseParcelableArray);
        }
    }
}
