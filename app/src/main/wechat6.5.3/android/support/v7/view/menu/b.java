package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.y;
import android.support.v7.view.menu.l.a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class b implements l {
    protected LayoutInflater CE;
    public Context OX;
    protected LayoutInflater OY;
    private int OZ;
    private int Pa;
    public m Pb;
    public a dU;
    public f dV;
    public int dW;
    public Context mContext;

    public abstract void a(h hVar, m.a aVar);

    public b(Context context, int i, int i2) {
        this.OX = context;
        this.OY = LayoutInflater.from(context);
        this.OZ = i;
        this.Pa = i2;
    }

    public void a(Context context, f fVar) {
        this.mContext = context;
        this.CE = LayoutInflater.from(this.mContext);
        this.dV = fVar;
    }

    public m c(ViewGroup viewGroup) {
        if (this.Pb == null) {
            this.Pb = (m) this.OY.inflate(this.OZ, viewGroup, false);
            this.Pb.a(this.dV);
            f(true);
        }
        return this.Pb;
    }

    public void f(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.Pb;
        if (viewGroup != null) {
            int i;
            if (this.dV != null) {
                this.dV.dF();
                ArrayList dE = this.dV.dE();
                int size = dE.size();
                int i2 = 0;
                i = 0;
                while (i2 < size) {
                    int i3;
                    h hVar = (h) dE.get(i2);
                    if (e(hVar)) {
                        View childAt = viewGroup.getChildAt(i);
                        h C = childAt instanceof m.a ? ((m.a) childAt).C() : null;
                        View a = a(hVar, childAt, viewGroup);
                        if (hVar != C) {
                            a.setPressed(false);
                            y.aa(a);
                        }
                        if (a != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a);
                            }
                            ((ViewGroup) this.Pb).addView(a, i);
                        }
                        i3 = i + 1;
                    } else {
                        i3 = i;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!c(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    public boolean c(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public View a(h hVar, View view, ViewGroup viewGroup) {
        m.a aVar;
        if (view instanceof m.a) {
            aVar = (m.a) view;
        } else {
            aVar = (m.a) this.OY.inflate(this.Pa, viewGroup, false);
        }
        a(hVar, aVar);
        return (View) aVar;
    }

    public boolean e(h hVar) {
        return true;
    }

    public void a(f fVar, boolean z) {
        if (this.dU != null) {
            this.dU.a(fVar, z);
        }
    }

    public boolean a(p pVar) {
        if (this.dU != null) {
            return this.dU.d(pVar);
        }
        return false;
    }

    public boolean E() {
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
}
