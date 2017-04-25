package com.tencent.mm.plugin.sight.encode.ui;

import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mm.modelsearch.p;
import com.tencent.mm.modelsearch.p.h;
import com.tencent.mm.modelsearch.p.k;
import com.tencent.mm.modelsearch.p.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public final class d implements TextWatcher, OnClickListener, OnFocusChangeListener, k {
    private Comparator<h> eAz = new com.tencent.mm.modelsearch.p.b();
    private ac handler = new ac(Looper.getMainLooper());
    public EditText iZa;
    public TextView iZb;
    public View iZc;
    private l iZd;
    InputMethodManager iZe;
    public int iZf = b.iZi;
    a iZg;

    public interface a {
        void aQo();

        void aQp();

        void bk(List<String> list);
    }

    public enum b {
        ;

        static {
            iZh = 1;
            iZi = 2;
            iZj = new int[]{iZh, iZi};
        }
    }

    public final boolean aQl() {
        return this.iZf == b.iZh;
    }

    public final void onFocusChange(View view, boolean z) {
        if (!z) {
            this.iZa.clearFocus();
            be.cw(this.iZa);
        }
    }

    public final void onClick(View view) {
        if (view.getId() == 2131758002 && aQl()) {
            aQm();
        }
    }

    public final void aQm() {
        if (aQl()) {
            aQn();
        } else if (!aQl()) {
            this.iZf = b.iZh;
            this.iZc.setVisibility(0);
            if (this.iZg != null) {
                this.iZg.aQo();
            }
            this.iZa.requestFocus();
            this.iZe.showSoftInput(this.iZa, 0);
        }
    }

    public final void aQn() {
        if (aQl()) {
            this.iZa.setText(SQLiteDatabase.KeyEmpty);
            this.iZa.clearFocus();
            be.cw(this.iZa);
            this.iZf = b.iZi;
            this.iZc.setVisibility(8);
            if (this.iZg != null) {
                this.iZg.aQp();
            }
        }
    }

    public final void a(l lVar, List<h> list, HashSet<String> hashSet, String[] strArr, String str) {
        if (list != null && this.iZg != null) {
            List arrayList = new ArrayList();
            for (h hVar : list) {
                arrayList.add(hVar.cWv);
            }
            this.iZg.bk(arrayList);
        }
    }

    public final void jI(String str) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (!be.kS(editable.toString())) {
            v.i("MicroMsg.MainSightSelectContactSearchHelper", "doSearch: query=%s", editable.toString());
            if (this.iZd != null) {
                p.a(this.iZd);
                this.iZd = null;
            }
            this.iZd = p.a(r0, new int[]{131072, 131075}, 3, this.eAz, (k) this, this.handler);
        }
    }
}
