package com.tencent.mm.plugin.clean.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.clean.b.b;
import com.tencent.mm.plugin.clean.b.d;
import com.tencent.mm.plugin.clean.b.e;
import com.tencent.mm.plugin.clean.b.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class CleanChattingUI extends MMActivity implements g {
    private ProgressDialog dwR;
    private Button eVF;
    private e eVG;
    private a eVJ;
    private ListView eVK;
    private TextView eVL;
    private View edu;
    private CheckBox edw;
    private TextView edx;

    static /* synthetic */ void a(CleanChattingUI cleanChattingUI) {
        if (d.adN() != null) {
            Object arrayList = new ArrayList();
            arrayList.addAll(cleanChattingUI.eVJ.edo);
            Collections.sort(arrayList);
            Collections.reverse(arrayList);
            ArrayList arrayList2 = new ArrayList();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                int intValue = ((Integer) it.next()).intValue();
                if (intValue < d.Tu().size()) {
                    arrayList2.addAll(((b) d.Tu().get(intValue)).eUn);
                    d.Tu().remove(intValue);
                }
            }
            cleanChattingUI.eVJ.adV();
            cleanChattingUI.eVJ.notifyDataSetChanged();
            if (cleanChattingUI.eVG != null) {
                cleanChattingUI.eVG.adU();
            }
            cleanChattingUI.eVG = new e(d.adN(), cleanChattingUI, arrayList2);
            cleanChattingUI.eVG.start();
            cleanChattingUI.dwR.show();
            cleanChattingUI.dwR.setMessage(cleanChattingUI.getString(2131231932, new Object[]{"0%"}));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d.adS();
        v.i("MicroMsg.CleanChattingUI", "Create!!");
        vD(2131231937);
        this.eVK = (ListView) findViewById(2131756338);
        this.eVJ = new a(this);
        this.eVK.setAdapter(this.eVJ);
        this.eVK.setEmptyView(findViewById(2131755521));
        this.edu = findViewById(2131755528);
        this.eVL = (TextView) findViewById(2131756337);
        this.edw = (CheckBox) findViewById(2131755526);
        this.edx = (TextView) findViewById(2131755527);
        if (!u.bsU()) {
            this.eVL.setTextSize(1, 14.0f);
            this.edx.setTextSize(1, 14.0f);
        }
        this.eVF = (Button) findViewById(2131756336);
        this.eVF.setEnabled(false);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CleanChattingUI eVM;

            {
                this.eVM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.eVM.finish();
                return false;
            }
        });
        this.eVK.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ CleanChattingUI eVM;

            {
                this.eVM = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent(this.eVM, CleanChattingDetailUI.class);
                intent.putExtra("key_position", i);
                this.eVM.startActivityForResult(intent, 0);
            }
        });
        this.eVF.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CleanChattingUI eVM;

            {
                this.eVM = r1;
            }

            public final void onClick(View view) {
                com.tencent.mm.ui.base.g.b(this.eVM, this.eVM.getString(2131231971), "", this.eVM.getString(2131232277), this.eVM.getString(2131231565), new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 eVN;

                    {
                        this.eVN = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        CleanChattingUI.a(this.eVN.eVM);
                    }
                }, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass3 eVN;

                    {
                        this.eVN = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
            }
        });
        this.edu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ CleanChattingUI eVM;

            {
                this.eVM = r1;
            }

            public final void onClick(View view) {
                a b = this.eVM.eVJ;
                if (b.edo.size() == b.getCount()) {
                    b.edo.clear();
                } else {
                    for (int i = 0; i < b.getCount(); i++) {
                        b.edo.add(Integer.valueOf(i));
                    }
                }
                b.notifyDataSetChanged();
                b.eVj.a(b.edo);
            }
        });
        getString(2131231164);
        this.dwR = com.tencent.mm.ui.base.g.a(this, getString(2131231926), false, new OnCancelListener(this) {
            final /* synthetic */ CleanChattingUI eVM;

            {
                this.eVM = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        this.dwR.dismiss();
    }

    public final void a(HashSet<Integer> hashSet) {
        HashSet hashSet2 = new HashSet();
        Iterator it = hashSet.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Integer) it.next()).intValue();
            if (intValue < d.Tu().size()) {
                i = (int) (((b) d.Tu().get(intValue)).beE + ((long) i));
            } else {
                hashSet2.add(Integer.valueOf(intValue));
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            hashSet.remove((Integer) it2.next());
        }
        if (hashSet.size() != 0 || i > 0) {
            this.eVL.setText(getString(2131232280, new Object[]{be.aw((long) i)}));
            this.eVF.setEnabled(true);
            if (hashSet.size() == this.eVJ.getCount()) {
                this.edw.setChecked(true);
                return;
            } else {
                this.edw.setChecked(false);
                return;
            }
        }
        this.eVL.setText("");
        this.eVF.setEnabled(false);
        this.edw.setChecked(false);
    }

    protected void onDestroy() {
        if (this.dwR.isShowing()) {
            this.dwR.dismiss();
        }
        if (this.eVG != null) {
            this.eVG.adU();
        }
        d.adT();
        d.adR();
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903381;
    }

    public final void bv(int i, int i2) {
        this.dwR.setMessage(getString(2131231932, new Object[]{((i * 100) / i2) + "%"}));
    }

    public final void aR(long j) {
        this.dwR.dismiss();
        d.aQ(d.adP() + j);
        d.aP(d.adO() - j);
        com.tencent.mm.ui.base.g.a(this, getString(2131231927, new Object[]{be.aw(j)}), "", new DialogInterface.OnClickListener(this) {
            final /* synthetic */ CleanChattingUI eVM;

            {
                this.eVM = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                if (d.Tu().size() == 0) {
                    this.eVM.finish();
                }
            }
        });
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.eVJ.notifyDataSetChanged();
        super.onActivityResult(i, i2, intent);
    }
}
