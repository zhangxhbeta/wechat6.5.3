package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.modelbiz.a.j;
import com.tencent.mm.pluginsdk.ui.applet.f.AnonymousClass3;
import com.tencent.mm.pluginsdk.ui.applet.f.AnonymousClass4;
import com.tencent.mm.pluginsdk.ui.applet.f.b;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference extends Preference {
    private int lKD = -1;
    public d lKE;
    public f lKF;

    public interface a {
        void adp();

        void jo(int i);

        void jp(int i);

        void jq(int i);
    }

    public ContactListExpandPreference(Context context, int i) {
        super(context);
        if (i == 0) {
            bpm();
        } else if (i == 1) {
            this.lKD = 1;
            this.lKF = new f();
        }
        setLayoutResource(2130904007);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        bpm();
        setLayoutResource(2130904007);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bpm();
        setLayoutResource(2130904007);
    }

    private void bpm() {
        this.lKD = 0;
        this.lKE = new d(this.mContext);
    }

    public final void onBindView(View view) {
        if (this.lKD == 1) {
            f fVar = this.lKF;
            ViewGroup viewGroup = view.getId() == 2131758239 ? (ViewGroup) view : (ViewGroup) view.findViewById(2131758239);
            if (fVar.row == 0) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(2131493143), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(2131493152));
            } else if (fVar.row == (fVar.lJM.getCount() / e.lJX) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(2131493143));
            } else {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(2131493152), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(2131493152));
            }
            if ((fVar.lJM.lKg % e.lJX == e.lJX - 1 || fVar.lJM.lKg % e.lJX == 0) && fVar.ePp && fVar.row == (fVar.lJM.getCount() / e.lJX) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), 0);
            } else if (!fVar.ePp && fVar.lJM.lKg % e.lJX == 0 && fVar.row == (fVar.lJM.getCount() / e.lJX) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), (int) viewGroup.getContext().getResources().getDimension(2131493199));
            }
            if (fVar.lJM != null) {
                int i;
                viewGroup.setOnClickListener(fVar.iqU);
                if (viewGroup.getChildCount() > e.lJX) {
                    int childCount = viewGroup.getChildCount();
                    for (i = 0; i < childCount - e.lJX; i++) {
                        viewGroup.removeViewAt(i);
                    }
                    viewGroup.requestLayout();
                }
                for (i = 0; i < fVar.lKG; i++) {
                    View inflate;
                    int dimensionPixelSize;
                    if (viewGroup.getChildAt(i) == null) {
                        inflate = View.inflate(viewGroup.getContext(), 2130904283, null);
                        viewGroup.addView(inflate);
                    } else {
                        inflate = viewGroup.getChildAt(i);
                    }
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (e.lJX == 4) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(2131493168);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    } else {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(2131493152);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    if (!fVar.lJM.bpk() && fVar.lJM.lKg == 1) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(2131492971);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    inflate.setLayoutParams(layoutParams);
                    int i2 = (fVar.row * fVar.lKG) + i;
                    fVar.lJM.getView(i2, inflate, viewGroup);
                    if (fVar.lJT != null) {
                        inflate.setOnClickListener(new AnonymousClass3(fVar, viewGroup, i2));
                    }
                    if (fVar.lKH != null) {
                        inflate.setOnLongClickListener(new AnonymousClass4(fVar, viewGroup, i2));
                    }
                }
                if (fVar.lJM.bpk() || fVar.lJM.lKg > 1) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else {
                    ((LinearLayout) viewGroup).setGravity(19);
                }
            }
        }
        super.onBindView(view);
    }

    public final void a(f fVar, String str) {
        if (this.lKE != null) {
            d dVar = this.lKE;
            if (fVar != null && str != null) {
                dVar.dxf = fVar;
                dVar.lJI = str;
                fVar.aO(str, true);
            }
        }
    }

    public final void a(d dVar) {
        if (this.lKE != null) {
            this.lKE.lJM.lKh = dVar;
        }
    }

    public final void notifyChanged() {
        if (this.lKE != null) {
            this.lKE.aIO();
        }
    }

    public final void j(String str, List<String> list) {
        if (this.lKE != null) {
            d dVar = this.lKE;
            dVar.username = str;
            if (list == null) {
                list = new ArrayList(0);
            }
            dVar.lJM.bt(list);
            dVar.vV(str);
        }
    }

    public final void X(ArrayList<u> arrayList) {
        if (this.lKE != null) {
            d dVar = this.lKE;
            dVar.lJM.W(arrayList);
            dVar.vV(null);
        }
    }

    public final void bpn() {
        if (this.lKE != null) {
            this.lKE.lJM.lKx = false;
        }
    }

    public final void bpo() {
        if (this.lKE != null) {
            this.lKE.lJM.lKp = true;
        }
    }

    public final void HA(String str) {
        if (this.lKE != null) {
            this.lKE.lJM.lKq = str;
        }
    }

    public final boolean tW(int i) {
        if (this.lKE != null) {
            return this.lKE.lJM.tW(i);
        }
        return false;
    }

    public final j tX(int i) {
        if (this.lKE != null && this.lKE.lJM.tW(i) && (this.lKE.lJM.getItem(i) instanceof j)) {
            return (j) this.lKE.lJM.getItem(i);
        }
        return null;
    }

    public final String tY(int i) {
        if (this.lKE == null || !this.lKE.lJM.tW(i)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return ((u) this.lKE.lJM.getItem(i)).field_username;
    }

    public final String tZ(int i) {
        if (this.lKE == null || !this.lKE.lJM.tW(i)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return ((u) this.lKE.lJM.getItem(i)).field_nickname;
    }

    public final String ua(int i) {
        if (this.lKE == null || !this.lKE.lJM.tW(i)) {
            return SQLiteDatabase.KeyEmpty;
        }
        return ((u) this.lKE.lJM.getItem(i)).field_conRemark;
    }

    public final void bpp() {
        if (this.lKE != null) {
            e eVar = this.lKE.lJM;
            eVar.eRm = false;
            eVar.notifyChanged();
        }
    }

    public final ContactListExpandPreference hZ(boolean z) {
        if (this.lKE != null) {
            this.lKE.lJM.lKj = z;
        }
        return this;
    }

    public final ContactListExpandPreference ia(boolean z) {
        if (this.lKE != null) {
            this.lKE.lJM.lKi = z;
        }
        return this;
    }

    public final ContactListExpandPreference bpq() {
        if (this.lKE != null) {
            this.lKE.lJM.lKk = false;
        }
        return this;
    }

    public final void bpr() {
        boolean z = false;
        if (this.lKE != null) {
            d dVar = this.lKE;
            dVar.lJK = false;
            if (dVar.lJK) {
                z = true;
            }
            dVar.lJL = z;
        }
    }

    public final void aH(List<String> list) {
        if (this.lKE != null) {
            e eVar = this.lKE.lJM;
            eVar.bt(list);
            eVar.notifyChanged();
        }
    }

    public final void a(b bVar) {
        if (this.lKE != null) {
            this.lKE.lJN = bVar;
        }
    }

    public final void a(a aVar) {
        if (this.lKE != null) {
            this.lKE.lJO = aVar;
        }
    }
}
