package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.model.bl;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.k.b;

public class SetTextSizeUI extends MMPreference {
    private f dxf;
    private float iKm;
    private int iKn = 1;

    private class a extends Preference {
        private float iKm;
        final /* synthetic */ SetTextSizeUI iKo;

        public a(SetTextSizeUI setTextSizeUI, Context context, float f) {
            this.iKo = setTextSizeUI;
            super(context);
            this.iKm = f;
        }

        protected final void onBindView(View view) {
            super.onBindView(view);
            TextView textView = (TextView) view.findViewById(16908310);
            if (textView != null) {
                textView.setTextSize(1, SetTextSizeUI.S(this.iKm));
            }
        }
    }

    public final int Oo() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected final void NI() {
        this.iKm = cv(this);
        this.dxf = this.ocZ;
        vD(2131235168);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SetTextSizeUI iKo;

            {
                this.iKo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iKo.axg();
                this.iKo.finish();
                return true;
            }
        });
        a(0, getString(2131235036), new OnMenuItemClickListener(this) {
            final /* synthetic */ SetTextSizeUI iKo;

            {
                this.iKo = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.bd.a.c(this.iKo, this.iKo.iKm);
                bl.zQ().b(25, new Object[]{Integer.valueOf(this.iKo.iKn)});
                this.iKo.finish();
                return true;
            }
        }, b.nET);
        refresh();
    }

    public static float cv(Context context) {
        float ds = com.tencent.mm.bd.a.ds(context);
        if (ds == 1.0f || ds == 0.875f || ds == 1.125f || ds == 1.25f || ds == 1.375f) {
            return ds;
        }
        return 1.0f;
    }

    public static int cw(Context context) {
        float cv = cv(context);
        if (cv == 0.875f) {
            return 2131234941;
        }
        if (cv == 1.125f) {
            return 2131234939;
        }
        if (cv == 1.25f) {
            return 2131234942;
        }
        if (cv == 1.375f) {
            return 2131234937;
        }
        return 2131234940;
    }

    public static float S(float f) {
        if (f == 0.875f) {
            return 14.0f;
        }
        if (f == 1.0f) {
            return 16.0f;
        }
        if (f == 1.125f) {
            return 18.0f;
        }
        if (f == 1.25f) {
            return 20.0f;
        }
        if (f == 1.375f) {
            return 22.0f;
        }
        return 16.0f;
    }

    public static float T(float f) {
        if (f == 0.875f) {
            return 0.0f;
        }
        if (f == 1.0f) {
            return 1.0f;
        }
        if (f == 1.125f) {
            return 2.0f;
        }
        if (f == 1.25f) {
            return 3.0f;
        }
        if (f == 1.375f) {
            return 4.0f;
        }
        return 1.0f;
    }

    public final boolean a(f fVar, Preference preference) {
        String str = preference.dnU;
        this.iKn = 1;
        if (str.equals("setting_text_size_small")) {
            this.iKm = 0.875f;
            this.iKn = 0;
        } else if (str.equals("setting_text_size_normal")) {
            this.iKm = 1.0f;
            this.iKn = 1;
        } else if (str.equals("setting_text_size_large")) {
            this.iKm = 1.125f;
            this.iKn = 2;
        } else if (str.equals("setting_text_size_super")) {
            this.iKm = 1.25f;
            this.iKn = 3;
        } else if (str.equals("setting_text_size_huge")) {
            this.iKm = 1.375f;
            this.iKn = 4;
        }
        refresh();
        return false;
    }

    private void refresh() {
        this.dxf.removeAll();
        a aVar = new a(this, this, 0.875f);
        aVar.setKey("setting_text_size_small");
        aVar.setLayoutResource(2130903996);
        if (this.iKm == 0.875f) {
            aVar.setWidgetLayoutResource(2130904059);
        } else {
            aVar.setWidgetLayoutResource(2130904060);
        }
        this.dxf.a(aVar);
        aVar = new a(this, this, 1.0f);
        aVar.setKey("setting_text_size_normal");
        aVar.setLayoutResource(2130903996);
        if (this.iKm == 1.0f) {
            aVar.setWidgetLayoutResource(2130904059);
        } else {
            aVar.setWidgetLayoutResource(2130904060);
        }
        this.dxf.a(aVar);
        aVar = new a(this, this, 1.125f);
        aVar.setKey("setting_text_size_large");
        aVar.setLayoutResource(2130903996);
        if (this.iKm == 1.125f) {
            aVar.setWidgetLayoutResource(2130904059);
        } else {
            aVar.setWidgetLayoutResource(2130904060);
        }
        this.dxf.a(aVar);
        aVar = new a(this, this, 1.25f);
        aVar.setKey("setting_text_size_super");
        aVar.setLayoutResource(2130903996);
        if (this.iKm == 1.25f) {
            aVar.setWidgetLayoutResource(2130904059);
        } else {
            aVar.setWidgetLayoutResource(2130904060);
        }
        this.dxf.a(aVar);
        aVar = new a(this, this, 1.375f);
        aVar.setKey("setting_text_size_huge");
        aVar.setLayoutResource(2130903996);
        if (this.iKm == 1.375f) {
            aVar.setWidgetLayoutResource(2130904059);
        } else {
            aVar.setWidgetLayoutResource(2130904060);
        }
        this.dxf.a(aVar);
        this.dxf.a(new PreferenceCategory(this));
        this.dxf.notifyDataSetChanged();
        ViewGroup viewGroup = (ViewGroup) this.nDR.nDX;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof TextView) {
                v.d("ui.settings.SetTextSize", "id=" + childAt.getId());
            }
        }
    }
}
