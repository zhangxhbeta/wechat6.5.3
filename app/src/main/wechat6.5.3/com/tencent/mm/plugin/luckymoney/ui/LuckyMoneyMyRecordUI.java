package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.luckymoney.c.h;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.plugin.luckymoney.c.x;
import com.tencent.mm.plugin.luckymoney.c.y;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.MMLoadMoreListView;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.wallet_core.ui.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LuckyMoneyMyRecordUI extends LuckyMoneyBaseUI {
    private ImageView eXC;
    private boolean ffH = false;
    public String hch = "";
    private MMLoadMoreListView heW;
    private d heX;
    private TextView hea;
    private boolean heg = true;
    private List<h> hen = new LinkedList();
    private Map<String, Integer> heo = new HashMap();
    public String heq = "";
    private TextView hfC;
    private TextView hfD;
    private TextView hfE;
    private TextView hfF;
    private TextView hfG;
    private TextView hfH;
    private TextView hfI;
    private TextView hfJ;
    private String hfK;
    private int hfL = -1;
    public List<String> hfM = new ArrayList();
    private int mType;
    private int vI = 0;

    class a extends BaseAdapter {
        int gLb;
        List<String> hfM;
        final /* synthetic */ LuckyMoneyMyRecordUI hfN;

        a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI) {
            this.hfN = luckyMoneyMyRecordUI;
        }

        public final /* synthetic */ Object getItem(int i) {
            return hd(i);
        }

        public final int getCount() {
            return this.hfM.size();
        }

        public final String hd(int i) {
            return (String) this.hfM.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) LayoutInflater.from(this.hfN.nDR.nEl).inflate(2130904652, viewGroup, false);
            checkedTextView.setText(hd(i));
            if (i == this.gLb) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    }

    static /* synthetic */ void a(LuckyMoneyMyRecordUI luckyMoneyMyRecordUI, h hVar, int i) {
        if (hVar == null || i < 0 || i > luckyMoneyMyRecordUI.heX.getCount()) {
            v.e("MicroMsg.LuckyMoneyMyRecordUI", "param is illegal");
            return;
        }
        luckyMoneyMyRecordUI.j(new y(hVar.haB, hVar.haI, luckyMoneyMyRecordUI.mType, i, "v1.0"));
    }

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                View inflate = LayoutInflater.from(this).inflate(2130903905, null);
                ListView listView = (ListView) inflate.findViewById(2131757945);
                final a aVar = new a(this);
                List list = this.hfM;
                if (list == null) {
                    aVar.hfM = new ArrayList();
                } else {
                    aVar.hfM = list;
                }
                aVar.notifyDataSetChanged();
                aVar.gLb = 0;
                listView.setAdapter(aVar);
                listView.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ LuckyMoneyMyRecordUI hfN;

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        this.hfN.dismissDialog(1);
                        String hd = aVar.hd(i);
                        aVar.gLb = i;
                        if (!hd.equals(this.hfN.hfK)) {
                            this.hfN.hfK = hd;
                            this.hfN.hfH.setText(this.hfN.getString(2131233650, new Object[]{this.hfN.hfK}));
                            this.hfN.vI = 0;
                            this.hfN.hen.clear();
                            this.hfN.heo.clear();
                            this.hfN.ayh();
                        }
                        g.iuh.h(11701, new Object[]{Integer.valueOf(this.hfN.ayq()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(3), hd});
                    }
                });
                com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(this);
                aVar2.wm(2131233656);
                aVar2.cC(inflate);
                aVar2.c(null);
                return aVar2.RX();
            default:
                return null;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 2);
        NI();
        ayh();
        g.iuh.h(11701, new Object[]{Integer.valueOf(ayq()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1)});
    }

    protected final void NI() {
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ LuckyMoneyMyRecordUI hfN;

            {
                this.hfN = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.hfN.finish();
                return true;
            }
        });
        this.hfJ = (TextView) findViewById(2131757868);
        this.heW = (MMLoadMoreListView) findViewById(2131757867);
        View inflate = LayoutInflater.from(this).inflate(2130903892, null);
        this.heW.addHeaderView(inflate);
        this.eXC = (ImageView) inflate.findViewById(2131757854);
        this.hfC = (TextView) inflate.findViewById(2131757855);
        this.hea = (TextView) inflate.findViewById(2131757856);
        this.hfD = (TextView) inflate.findViewById(2131757858);
        this.hfE = (TextView) inflate.findViewById(2131757859);
        this.hfF = (TextView) inflate.findViewById(2131757860);
        this.hfG = (TextView) inflate.findViewById(2131757861);
        this.hfH = (TextView) inflate.findViewById(2131757852);
        this.hfI = (TextView) inflate.findViewById(2131757862);
        if (this.mType == 1) {
            Fd(getString(2131233631));
            n.a(this.nDR.nEl, this.hfC, getString(2131233657, new Object[]{k.xH()}));
            this.hfE.setText(2131233660);
            this.heX = new e(this.nDR.nEl);
            this.hfI.setVisibility(0);
        } else {
            Fd(getString(2131233629));
            n.a(this.nDR.nEl, this.hfC, getString(2131233648, new Object[]{k.xH()}));
            this.hfE.setText(2131233649);
            this.heX = new c(this.nDR.nEl);
            inflate.findViewById(2131757857).setVisibility(0);
        }
        this.heW.setAdapter(this.heX);
        this.heW.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ LuckyMoneyMyRecordUI hfN;

            {
                this.hfN = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                int i2 = 3;
                int i3 = (int) j;
                g.iuh.h(11701, new Object[]{Integer.valueOf(this.hfN.ayq()), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
                if (i3 >= 0 && i3 < this.hfN.heX.getCount()) {
                    h mF = this.hfN.heX.mF(i3);
                    if (mF != null && !be.kS(mF.haB)) {
                        Intent intent = new Intent();
                        if (mF.haW == 2) {
                            v.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go busi detail");
                            intent.setClass(this.hfN.nDR.nEl, LuckyMoneyBusiDetailUI.class);
                        } else {
                            v.d("MicroMsg.LuckyMoneyMyRecordUI", "onItemClick: go normal detail");
                            intent.setClass(this.hfN.nDR.nEl, LuckyMoneyDetailUI.class);
                        }
                        intent.putExtra("key_sendid", mF.haB);
                        if (this.hfN.mType != 1) {
                            i2 = 1;
                        }
                        intent.putExtra("key_jump_from", i2);
                        this.hfN.startActivity(intent);
                    }
                }
            }
        });
        this.heW.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ LuckyMoneyMyRecordUI hfN;

            {
                this.hfN = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i > 0 && i <= this.hfN.heX.getCount()) {
                    final int i2 = i - 1;
                    com.tencent.mm.ui.base.g.a(this.hfN, this.hfN.getResources().getString(2131233625), null, this.hfN.getResources().getString(2131231020), new c(this) {
                        final /* synthetic */ AnonymousClass3 hfP;

                        public final void gT(int i) {
                            switch (i) {
                                case 0:
                                    h mF = this.hfP.hfN.heX.mF(i2);
                                    if (mF != null) {
                                        this.hfP.hfN.hfL = i2;
                                        LuckyMoneyMyRecordUI.a(this.hfP.hfN, mF, i2);
                                        return;
                                    }
                                    return;
                                default:
                                    return;
                            }
                        }
                    });
                }
                return true;
            }
        });
        this.heW.nWA = new com.tencent.mm.ui.base.MMLoadMoreListView.a(this) {
            final /* synthetic */ LuckyMoneyMyRecordUI hfN;

            {
                this.hfN = r1;
            }

            public final void adB() {
                if (!this.hfN.hdT.axG()) {
                    this.hfN.ffH = false;
                }
                if (this.hfN.heg && !this.hfN.ffH) {
                    this.hfN.ayh();
                }
            }
        };
        b.o(this.eXC, k.xF());
        this.eXC.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ LuckyMoneyMyRecordUI hfN;

            {
                this.hfN = r1;
            }

            public final void onClick(View view) {
                if (be.kS(this.hfN.hch)) {
                    v.w("MicroMsg.LuckyMoneyMyRecordUI", "hy: no avatar jump h5");
                } else {
                    e.l(this.hfN, this.hfN.hch, true);
                }
            }
        });
        this.hfH.setText(getString(2131233650, new Object[]{be.ma(this.hfK)}));
    }

    public final boolean d(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        h hVar;
        if (kVar instanceof x) {
            if (i == 0 && i2 == 0) {
                x xVar = (x) kVar;
                List list = xVar.hce.haY;
                this.heq = xVar.hbT;
                this.hch = xVar.hch;
                if (this.vI == 0) {
                    this.hfM = xVar.hcf;
                    this.hfK = xVar.hcg;
                    View findViewById = findViewById(2131757851);
                    ImageView imageView = (ImageView) findViewById(2131757853);
                    if (this.hfM.size() > 1) {
                        imageView.setVisibility(0);
                        findViewById.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ LuckyMoneyMyRecordUI hfN;

                            {
                                this.hfN = r1;
                            }

                            public final void onClick(View view) {
                                this.hfN.showDialog(1);
                            }
                        });
                    }
                    this.hfH.setText(getString(2131233650, new Object[]{this.hfK}));
                }
                com.tencent.mm.plugin.luckymoney.c.g gVar = xVar.hce;
                if (gVar != null) {
                    if (this.mType == 1) {
                        this.hea.setText(e.m(((double) gVar.hbf) / 100.0d));
                        String str2 = gVar.hbe;
                        CharSequence string = getString(2131233659, new Object[]{str2});
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(getResources().getColor(2131689839));
                        int indexOf = string.indexOf(str2);
                        CharSequence spannableString = new SpannableString(string);
                        spannableString.setSpan(foregroundColorSpan, indexOf, str2.length() + indexOf, 33);
                        this.hfI.setText(spannableString);
                    } else {
                        this.hea.setText(e.m(((double) gVar.hbd) / 100.0d));
                        this.hfD.setText(gVar.hbc);
                        this.hfF.setText(gVar.cWd);
                    }
                }
                if (list != null) {
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        hVar = (h) list.get(i3);
                        if (!this.heo.containsKey(hVar.haB)) {
                            this.hen.add(list.get(i3));
                            this.heo.put(hVar.haB, Integer.valueOf(1));
                        }
                    }
                    this.vI += list.size();
                    this.heg = xVar.axO();
                    this.ffH = false;
                    this.heX.aJ(this.hen);
                }
                if (this.hen == null || this.hen.size() == 0) {
                    this.hfJ.setVisibility(0);
                } else {
                    this.hfJ.setVisibility(8);
                }
                if (this.heg) {
                    this.heW.bCi();
                } else {
                    this.heW.bCj();
                }
                return true;
            }
            this.hch = null;
            return false;
        } else if (!(kVar instanceof y)) {
            return false;
        } else {
            int i4 = this.hfL;
            this.hfL = -1;
            if (i != 0 || i2 != 0) {
                return false;
            }
            hVar = this.heX.mF(i4);
            if (hVar != null) {
                Toast.makeText(this, 2131233626, 0).show();
                this.heX.a(hVar);
                this.heX.notifyDataSetChanged();
            } else {
                v.e("MicroMsg.LuckyMoneyMyRecordUI", "can't found local record");
            }
            return true;
        }
    }

    protected final int getLayoutId() {
        return 2130903894;
    }

    private void ayh() {
        this.ffH = true;
        if (this.vI == 0) {
            this.heq = "";
        }
        j(new x(11, this.vI, this.mType, this.hfK, "v1.0", this.heq));
    }

    private int ayq() {
        if (this.mType == 1) {
            return 8;
        }
        return 9;
    }
}
