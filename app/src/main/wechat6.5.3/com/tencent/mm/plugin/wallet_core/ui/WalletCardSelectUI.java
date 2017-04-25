package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.MaxListView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class WalletCardSelectUI extends WalletBaseUI {
    private int kHe = -1;
    private int kKx = 3;
    private List<ElementQuery> kSY = new LinkedList();
    private List<ElementQuery> kSZ = new LinkedList();
    private CheckedTextView kTa;
    private CheckedTextView kTb;
    private String kTc;
    private int kTd;
    private int kTe = -1;
    private int kTf = -1;
    private a kTg;
    private MaxListView kTh;

    public class a extends BaseAdapter {
        private Context context;
        List<ElementQuery> cwd = new ArrayList();
        final /* synthetic */ WalletCardSelectUI kTi;

        class a {
            CheckedTextView kTj;
            final /* synthetic */ a kTk;

            a(a aVar) {
                this.kTk = aVar;
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return ss(i);
        }

        public a(WalletCardSelectUI walletCardSelectUI, Context context) {
            this.kTi = walletCardSelectUI;
            this.context = context;
        }

        public final boolean isEnabled(int i) {
            return be.kS(((ElementQuery) this.cwd.get(i)).kOh);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CharSequence charSequence;
            a aVar = new a(this);
            View inflate = View.inflate(this.context, 2130904612, null);
            aVar.kTj = (CheckedTextView) inflate.findViewById(2131759800);
            ElementQuery elementQuery = (ElementQuery) this.cwd.get(i);
            String ah = be.ah(elementQuery.kNS, "");
            if (be.kS(elementQuery.kOh)) {
                aVar.kTj.setEnabled(true);
                Object obj = ah;
            } else {
                charSequence = ah + "[" + elementQuery.kOh + "]";
                aVar.kTj.setEnabled(false);
            }
            aVar.kTj.setText(charSequence);
            return inflate;
        }

        public final int getCount() {
            return this.cwd.size();
        }

        public final ElementQuery ss(int i) {
            return (ElementQuery) this.cwd.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        vD(2131236127);
        NI();
        this.kSZ.clear();
        this.kSY.clear();
        if (k.bgi().kLr != null) {
            for (ElementQuery elementQuery : k.bgi().kLr) {
                if (this.kHe == 5 && !elementQuery.kOu) {
                    elementQuery.kOh = getString(2131236536);
                }
                if (2 == elementQuery.kOb) {
                    this.kSZ.add(elementQuery);
                } else if (elementQuery.bfM()) {
                    this.kSY.add(elementQuery);
                }
            }
        }
        if (this.kKx == 3 && !this.kSZ.isEmpty()) {
            if (k.bga().bgA()) {
                Collections.sort(this.kSZ, new Comparator<ElementQuery>(this) {
                    final /* synthetic */ WalletCardSelectUI kTi;

                    {
                        this.kTi = r1;
                    }

                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ElementQuery) obj).kLu - ((ElementQuery) obj2).kLu;
                    }
                });
            } else {
                Collections.sort(this.kSZ, new Comparator<ElementQuery>(this) {
                    final /* synthetic */ WalletCardSelectUI kTi;

                    {
                        this.kTi = r1;
                    }

                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((ElementQuery) obj2).kLu - ((ElementQuery) obj).kLu;
                    }
                });
            }
        }
        int size;
        int i;
        if (this.kSY.isEmpty()) {
            size = this.kSZ.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.kSZ.get(i)).hMt.equals(this.kTc)) {
                    this.kTf = i;
                    hn(false);
                    iT(true);
                    break;
                }
            }
            if (this.kTf < 0) {
                hn(false);
                iT(false);
            }
            this.kTa.setVisibility(8);
            this.kTb.setBackgroundResource(2130838046);
            this.kTb.setCheckMarkDrawable(2130839233);
        } else if (be.kS(this.kTc)) {
            this.kTa.setChecked(false);
            this.kTb.setChecked(false);
            this.kTh.setVisibility(8);
        } else if (this.kTd == 2) {
            size = this.kSZ.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.kSZ.get(i)).hMt.equals(this.kTc)) {
                    this.kTf = i;
                    hn(false);
                    iT(true);
                    break;
                }
            }
            if (this.kTf < 0) {
                hn(false);
                iT(false);
            }
        } else {
            size = this.kSY.size();
            for (i = 0; i < size; i++) {
                if (((ElementQuery) this.kSY.get(i)).hMt.equals(this.kTc)) {
                    this.kTe = i;
                    hn(true);
                    iT(true);
                    break;
                }
            }
            if (this.kTe < 0) {
                hn(false);
                iT(false);
            }
        }
    }

    public final void NI() {
        this.kTc = this.uA.getString("key_bank_type");
        this.kTd = this.uA.getInt("key_bankcard_type", 1);
        this.kKx = this.uA.getInt("key_support_bankcard", 1);
        this.kHe = this.uA.getInt("key_bind_scene", -1);
        this.kTh = (MaxListView) findViewById(2131759873);
        this.kTa = (CheckedTextView) findViewById(2131759871);
        this.kTb = (CheckedTextView) findViewById(2131759872);
        this.kTg = new a(this, this);
        this.kTh.setAdapter(this.kTg);
        this.kTh.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ WalletCardSelectUI kTi;

            {
                this.kTi = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                ElementQuery ss = this.kTi.kTg.ss(i);
                if (be.kS(ss.kOh)) {
                    if (ss.bfM()) {
                        this.kTi.kTe = i;
                    } else {
                        this.kTi.kTf = i;
                    }
                    this.kTi.iT(true);
                    return;
                }
                g.a(this.kTi, ss.kOh, null, true, null);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletCardSelectUI kTi;

            {
                this.kTi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.kTi.finish();
                return true;
            }
        });
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ WalletCardSelectUI kTi;

            {
                this.kTi = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                Parcelable parcelable = null;
                Intent intent = new Intent();
                if (this.kTi.kTa.isChecked() && this.kTi.kTe >= 0) {
                    parcelable = (ElementQuery) this.kTi.kSY.get(this.kTi.kTe);
                } else if (this.kTi.kTb.isChecked() && this.kTi.kTf >= 0) {
                    ElementQuery elementQuery = (ElementQuery) this.kTi.kSZ.get(this.kTi.kTf);
                }
                if (parcelable != null) {
                    intent.putExtra("elemt_query", parcelable);
                    this.kTi.setResult(-1, intent);
                } else {
                    this.kTi.setResult(0);
                }
                this.kTi.finish();
                return true;
            }
        }, b.nET);
        iT(false);
        this.kTa.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardSelectUI kTi;

            {
                this.kTi = r1;
            }

            public final void onClick(View view) {
                this.kTi.hn(true);
            }
        });
        this.kTb.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ WalletCardSelectUI kTi;

            {
                this.kTi = r1;
            }

            public final void onClick(View view) {
                this.kTi.hn(false);
            }
        });
    }

    private void hn(boolean z) {
        this.kTh.setVisibility(0);
        if (z) {
            this.kTa.setChecked(true);
            this.kTb.setChecked(false);
            this.kTg.cwd = this.kSY;
            this.kTg.notifyDataSetChanged();
            this.kTh.clearChoices();
            if (this.kTe >= 0) {
                this.kTh.setItemChecked(this.kTe, true);
                iT(true);
                return;
            }
            iT(false);
            return;
        }
        this.kTa.setChecked(false);
        this.kTb.setChecked(true);
        this.kTg.cwd = this.kSZ;
        this.kTg.notifyDataSetChanged();
        this.kTh.clearChoices();
        if (this.kTf >= 0) {
            this.kTh.setItemChecked(this.kTf, true);
            iT(true);
            return;
        }
        iT(false);
    }

    protected final int getLayoutId() {
        return 2130904629;
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        return false;
    }

    public final boolean ayM() {
        return false;
    }

    protected final int NO() {
        return 1;
    }
}
