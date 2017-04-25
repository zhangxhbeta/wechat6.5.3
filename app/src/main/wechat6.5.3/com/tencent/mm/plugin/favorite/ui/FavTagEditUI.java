package com.tencent.mm.plugin.favorite.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.r;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.a.c;
import com.tencent.mm.plugin.favorite.ui.a.d;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel;
import com.tencent.mm.protocal.c.qk;
import com.tencent.mm.protocal.c.ql;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTagPanel.a;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FavTagEditUI extends MMActivity {
    private List<String> fOA;
    private FavTagPanel fOB;
    private FavTagPanel fOC;
    private ListView fOD;
    private ListView fOE;
    private TextView fOF;
    private c fOG;
    private d fOH;
    private boolean fOI;
    private i fOz;

    protected final int getLayoutId() {
        return 2130903616;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        final long longExtra = getIntent().getLongExtra("key_fav_item_id", -1);
        if (-1 != longExtra) {
            this.fOz = h.alu().bB(longExtra);
        }
        this.fOA = getIntent().getStringArrayListExtra("key_fav_result_list");
        this.fOC = (FavTagPanel) findViewById(2131756984);
        this.fOD = (ListView) findViewById(2131756986);
        this.fOE = (ListView) findViewById(2131756990);
        this.fOF = (TextView) findViewById(2131756989);
        this.fOC.ju(true);
        this.fOC.bCv();
        this.fOC.nYp = new a(this) {
            final /* synthetic */ FavTagEditUI fOJ;

            {
                this.fOJ = r1;
            }

            public final void rS(String str) {
                this.fOJ.fOC.removeTag(str);
                this.fOJ.fOG.tk(str);
                if (this.fOJ.fOB != null) {
                    this.fOJ.fOB.aN(str, false);
                }
                this.fOJ.amE();
            }

            public final void rT(String str) {
            }

            public final void rU(String str) {
                this.fOJ.fOC.removeTag(str);
                this.fOJ.fOG.tk(str);
                if (this.fOJ.fOB != null) {
                    this.fOJ.fOB.aN(str, false);
                }
                this.fOJ.amE();
            }

            public final void rV(String str) {
                if (be.kS(str)) {
                    this.fOJ.fOE.setVisibility(8);
                    this.fOJ.fOD.setVisibility(0);
                } else {
                    d h = this.fOJ.fOH;
                    h.fPF.clear();
                    h.fPE.clear();
                    h.fPD = be.ah(str, "");
                    r aln = h.aln();
                    boolean kS = be.kS(str);
                    Collection arrayList = new ArrayList(16);
                    Iterator it = aln.fKR.mtZ.iterator();
                    while (it.hasNext()) {
                        Iterator it2 = ((ql) it.next()).mtY.iterator();
                        while (it2.hasNext()) {
                            qk qkVar = (qk) it2.next();
                            if (kS || qkVar.lnP.contains(str)) {
                                arrayList.add(qkVar.lnP);
                            }
                        }
                    }
                    h.fPE.addAll(arrayList);
                    h.notifyDataSetChanged();
                    this.fOJ.fOE.setVisibility(0);
                    this.fOJ.fOD.setVisibility(8);
                }
                this.fOJ.amE();
            }

            public final void rW(String str) {
                if (be.kS(str)) {
                    v.d("MicroMsg.FavTagEditUI", "on create tag, fail, tag is empty");
                    return;
                }
                this.fOJ.fOC.aM(str, true);
                this.fOJ.amE();
            }

            public final void aii() {
            }

            public final void f(boolean z, int i) {
                this.fOJ.fOI = z;
                this.fOJ.fOF.setVisibility(this.fOJ.fOI ? 0 : 8);
                this.fOJ.fOF.setText(this.fOJ.getString(2131232744, new Object[]{Integer.valueOf(i)}));
                this.fOJ.amE();
            }
        };
        this.fOC.postDelayed(new Runnable(this) {
            final /* synthetic */ FavTagEditUI fOJ;

            {
                this.fOJ = r1;
            }

            public final void run() {
                this.fOJ.fOC.bCz();
                this.fOJ.aJs();
            }
        }, 100);
        if (this.fOz != null) {
            this.fOC.a(this.fOz.field_tagProto.mub, this.fOz.field_tagProto.mub);
        } else if (this.fOA != null) {
            this.fOC.a(this.fOA, this.fOA);
        }
        this.fOG = new c(this, this.nDR.nEl) {
            final /* synthetic */ FavTagEditUI fOJ;

            protected final void th(String str) {
                this.fOJ.fOC.aM(str, true);
                if (this.fOJ.fOB != null) {
                    this.fOJ.fOB.aN(str, true);
                }
                this.fOJ.amE();
            }

            protected final void ti(String str) {
                this.fOJ.fOC.removeTag(str);
                if (this.fOJ.fOB != null) {
                    this.fOJ.fOB.aN(str, false);
                }
                this.fOJ.amE();
            }
        };
        this.fOG.au(this.fOz == null ? null : this.fOz.field_tagProto.mub);
        if (!(this.fOz == null || this.fOz.field_tagProto.mua.isEmpty())) {
            View inflate = View.inflate(this.nDR.nEl, 2130903618, null);
            TextView textView = (TextView) inflate.findViewById(2131756991);
            textView.setText(getString(2131232708));
            textView.setVisibility(0);
            int dimensionPixelSize = getResources().getDimensionPixelSize(2131493076);
            this.fOB = (FavTagPanel) inflate.findViewById(2131756992);
            this.fOB.setVisibility(0);
            this.fOB.a(this.fOz.field_tagProto.mub, this.fOz.field_tagProto.mua);
            this.fOB.setBackgroundResource(2130838472);
            this.fOB.setPadding(0, 0, 0, dimensionPixelSize);
            this.fOB.nYp = new a(this) {
                final /* synthetic */ FavTagEditUI fOJ;

                {
                    this.fOJ = r1;
                }

                public final void rS(String str) {
                    this.fOJ.fOC.removeTag(str);
                    this.fOJ.fOG.tk(str);
                    this.fOJ.amE();
                }

                public final void rT(String str) {
                    this.fOJ.fOC.aM(str, true);
                    this.fOJ.fOG.tj(str);
                    this.fOJ.amE();
                }

                public final void rU(String str) {
                }

                public final void aii() {
                }

                public final void rV(String str) {
                }

                public final void rW(String str) {
                }

                public final void f(boolean z, int i) {
                }
            };
            this.fOD.addHeaderView(inflate);
        }
        if (h.aln().alJ() > 0) {
            this.fOD.addHeaderView(View.inflate(this.nDR.nEl, 2130903617, null));
        }
        this.fOD.setAdapter(this.fOG);
        this.fOD.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavTagEditUI fOJ;

            {
                this.fOJ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.fOJ.fOC.bCA();
                return false;
            }
        });
        this.fOH = new d(this, this.nDR.nEl) {
            final /* synthetic */ FavTagEditUI fOJ;

            protected final void sC(String str) {
                this.fOJ.fOC.aM(str, true);
                this.fOJ.fOG.tj(str);
                this.fOJ.fOC.bCx();
                this.fOJ.fOC.bCA();
                this.fOJ.amE();
            }
        };
        this.fOE.setAdapter(this.fOH);
        this.fOE.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ FavTagEditUI fOJ;

            {
                this.fOJ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                this.fOJ.fOC.bCA();
                return false;
            }
        });
        vD(2131232647);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ FavTagEditUI fOJ;

            {
                this.fOJ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fOJ.amF();
                return true;
            }
        });
        a(0, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ FavTagEditUI fOJ;

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.fOJ.fOI) {
                    this.fOJ.amE();
                } else {
                    Collection bCB = this.fOJ.fOC.bCB();
                    String trim = this.fOJ.fOC.bCw().trim();
                    if (!be.kS(trim)) {
                        bCB.remove(trim);
                        bCB.add(trim);
                    }
                    this.fOJ.fOz = h.alu().bB(longExtra);
                    Intent intent;
                    if (this.fOJ.fOz != null) {
                        com.tencent.mm.plugin.favorite.b.v.a(this.fOJ.fOz, bCB, this.fOJ.getIntent().getIntExtra("key_fav_scene", 1));
                        intent = new Intent();
                        intent.putExtra("key_fav_result_list", bCB);
                        this.fOJ.setResult(-1, intent);
                    } else {
                        String[] strArr = new String[bCB.size()];
                        Iterator it = bCB.iterator();
                        int i = 0;
                        while (it.hasNext()) {
                            int i2 = i + 1;
                            strArr[i] = (String) it.next();
                            i = i2;
                        }
                        intent = new Intent();
                        intent.putExtra("key_fav_result_array", strArr);
                        intent.putExtra("key_fav_result_list", bCB);
                        this.fOJ.setResult(-1, intent);
                    }
                    this.fOJ.finish();
                    this.fOJ.axg();
                }
                return true;
            }
        }, b.nET);
        amE();
        h.aln().a(this.fOG);
    }

    private void amE() {
        if (this.fOI) {
            v.w("MicroMsg.FavTagEditUI", "match max length, disable finish button");
            if (bzW()) {
                U(0, false);
            }
        } else if (this.fOz == null) {
            if (this.fOC.mtZ.size() > 0 || this.fOC.bCw().length() > 0) {
                if (!bzW()) {
                    U(0, true);
                }
            } else if (bzW()) {
                U(0, false);
            }
        } else if (this.fOz.field_tagProto.mub.size() == this.fOC.mtZ.size() && this.fOC.bCw().length() <= 0) {
            List bCB = this.fOC.bCB();
            int i = 0;
            while (i < bCB.size()) {
                if (((String) bCB.get(i)).equals(this.fOz.field_tagProto.mub.get(i))) {
                    i++;
                } else if (!bzW()) {
                    U(0, true);
                    return;
                } else {
                    return;
                }
            }
            if (bzW()) {
                U(0, false);
            }
        } else if (!bzW()) {
            U(0, true);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        r aln = h.aln();
        c cVar = this.fOG;
        if (cVar != null) {
            aln.cJv.remove(cVar.toString());
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        amF();
        return true;
    }

    private void amF() {
        g.b(this.nDR.nEl, getString(2131232707), "", getString(2131230903), getString(2131231010), new OnClickListener(this) {
            final /* synthetic */ FavTagEditUI fOJ;

            {
                this.fOJ = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
                this.fOJ.finish();
            }
        }, null);
    }
}
