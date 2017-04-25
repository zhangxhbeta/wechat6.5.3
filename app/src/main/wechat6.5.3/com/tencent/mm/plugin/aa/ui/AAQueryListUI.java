package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.aa.a.c.b;
import com.tencent.mm.plugin.aa.ui.a.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.protocal.c.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.vending.g.d;
import java.util.List;

public class AAQueryListUI extends BaseAAPresenterActivity {
    private b dtH = ((b) i(b.class));
    private ListView dtI;
    private b dtJ;
    private Dialog dtK;
    private boolean dtL = false;
    private boolean dtM = false;
    private View dtN;
    private AAQueryListH5UrlFooterView dtO;
    private String dtP;

    static /* synthetic */ void k(AAQueryListUI aAQueryListUI) {
        if (be.kS(aAQueryListUI.dtP)) {
            v.i("MicroMsg.AAQueryListUI", "empty h5 url!");
            aAQueryListUI.dtO.setVisibility(8);
            return;
        }
        TextView textView = aAQueryListUI.dtO.dtG;
        textView.setClickable(true);
        textView.setOnTouchListener(new h(aAQueryListUI));
        CharSequence spannableStringBuilder = new SpannableStringBuilder(aAQueryListUI.getString(2131230763));
        spannableStringBuilder.setSpan(new a(new a(aAQueryListUI) {
            final /* synthetic */ AAQueryListUI dtQ;

            {
                this.dtQ = r1;
            }

            public final void ND() {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.dtQ.dtP);
                c.b(this.dtQ, "webview", ".ui.tools.WebViewUI", intent);
            }
        }), 0, spannableStringBuilder.length(), 18);
        textView.setText(spannableStringBuilder);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ AAQueryListUI dtQ;

            {
                this.dtQ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.dtQ.finish();
                return false;
            }
        });
        vD(2131230778);
        vE(2131236646);
        this.dtI = (ListView) findViewById(2131755204);
        this.dtI.setOnScrollListener(new OnScrollListener(this) {
            final /* synthetic */ AAQueryListUI dtQ;

            {
                this.dtQ = r1;
            }

            public final void onScrollStateChanged(AbsListView absListView, int i) {
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
                if (this.dtQ.dtI.getLastVisiblePosition() == this.dtQ.dtI.getCount() - 1 && this.dtQ.dtI.getCount() > 0 && !this.dtQ.dtM && !this.dtQ.dtL) {
                    this.dtQ.dtI.addFooterView(this.dtQ.dtN);
                    this.dtQ.bq(false);
                }
            }
        });
        this.dtI.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ AAQueryListUI dtQ;

            {
                this.dtQ = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.dtQ.dtJ != null) {
                    if (i < 0 || i >= this.dtQ.dtJ.getCount()) {
                        v.i("MicroMsg.AAQueryListUI", "click out of bound! %s", new Object[]{Integer.valueOf(i)});
                        return;
                    }
                    int top = view.getTop();
                    k kVar = (k) this.dtQ.dtJ.getItem(i);
                    if (kVar != null) {
                        if (!be.kS(kVar.lYG)) {
                            Intent intent = new Intent();
                            intent.putExtra("rawUrl", kVar.lYG);
                            c.b(this.dtQ, "webview", ".ui.tools.WebViewUI", intent);
                        } else if (!be.kS(kVar.lYw)) {
                            String str = null;
                            if (kVar.cqN == 2) {
                                str = com.tencent.mm.model.k.xF();
                            }
                            Intent intent2 = new Intent(this.dtQ, PaylistAAUI.class);
                            intent2.putExtra("bill_no", kVar.lYw);
                            intent2.putExtra("launcher_user_name", str);
                            intent2.putExtra("enter_scene", 2);
                            intent2.putExtra("chatroom", kVar.lYx);
                            intent2.putExtra("item_position", i);
                            intent2.putExtra("item_offset", top);
                            this.dtQ.startActivityForResult(intent2, 1);
                        }
                    }
                }
                g.iuh.h(13721, new Object[]{Integer.valueOf(5), Integer.valueOf(3)});
            }
        });
        this.dtN = new AAQueryListLoadingMoreView(this);
        this.dtO = new AAQueryListH5UrlFooterView(this);
        this.dtK = com.tencent.mm.wallet_core.ui.g.a(this, false, null);
        this.dtJ = new b(this);
        this.dtI.setAdapter(this.dtJ);
        this.dtI.setVisibility(4);
        bq(false);
    }

    private void bq(final boolean z) {
        if (this.dtL) {
            v.i("MicroMsg.AAQueryListUI", "getNextPage, loading");
            return;
        }
        this.dtL = true;
        com.tencent.mm.vending.g.g.br(Boolean.valueOf(z)).c(this.dtH.dtc).e(new com.tencent.mm.vending.c.a<Object, com.tencent.mm.vending.j.c<List, String>>(this) {
            final /* synthetic */ AAQueryListUI dtQ;

            public final /* synthetic */ Object aq(Object obj) {
                com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
                List list = (List) cVar.get(0);
                v.i("MicroMsg.AAQueryListUI", "record list size: %s, h5Url: %s", new Object[]{Integer.valueOf(list.size()), cVar.get(1)});
                if (!be.kS((String) cVar.get(1))) {
                    this.dtQ.dtP = (String) cVar.get(1);
                }
                if (z) {
                    this.dtQ.dtJ.dataList.clear();
                }
                b f = this.dtQ.dtJ;
                com.tencent.pb.common.c.c.h("MicroMsg.AAQueryListAdapter", new Object[]{"addNewRecord: %s", list});
                if (list != null && list.size() > 0) {
                    com.tencent.pb.common.c.c.h("MicroMsg.AAQueryListAdapter", new Object[]{"addNewRecord size: %s", Integer.valueOf(list.size())});
                    f.dataList.addAll(list);
                    f.notifyDataSetChanged();
                }
                if (this.dtQ.dtK != null) {
                    this.dtQ.dtK.dismiss();
                    this.dtQ.dtK = null;
                }
                if (this.dtQ.dtI.getVisibility() != 0) {
                    this.dtQ.dtI.setVisibility(0);
                }
                this.dtQ.dtL = false;
                if (list.size() <= 0) {
                    this.dtQ.dtM = true;
                }
                if (this.dtQ.dtI.getFooterViewsCount() > 0) {
                    this.dtQ.dtI.removeFooterView(this.dtQ.dtN);
                }
                if (this.dtQ.dtM) {
                    AAQueryListUI.k(this.dtQ);
                    if (this.dtQ.dtO.getVisibility() == 0) {
                        this.dtQ.dtI.addFooterView(this.dtQ.dtO, null, false);
                    }
                }
                return phb;
            }
        }).a(new d.a(this) {
            final /* synthetic */ AAQueryListUI dtQ;

            {
                this.dtQ = r1;
            }

            public final void aA(Object obj) {
                v.i("MicroMsg.AAQueryListUI", "getNexPage failed: %s", new Object[]{obj});
                if (this.dtQ.dtK != null) {
                    this.dtQ.dtK.dismiss();
                    this.dtQ.dtK = null;
                }
                this.dtQ.dtL = false;
                if (this.dtQ.dtI.getFooterViewsCount() > 0) {
                    this.dtQ.dtI.removeFooterView(this.dtQ.dtN);
                }
                if (obj instanceof String) {
                    Toast.makeText(this.dtQ, obj.toString(), 1).show();
                } else {
                    Toast.makeText(this.dtQ, 2131233184, 1).show();
                }
            }
        });
    }

    protected final int getLayoutId() {
        return 2130903042;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1 && i2 == -1) {
            boolean booleanExtra = intent.getBooleanExtra("close_aa", false);
            int intExtra = intent.getIntExtra("item_position", 0);
            int intExtra2 = intent.getIntExtra("item_offset", 0);
            if (booleanExtra) {
                this.dtI.setSelectionFromTop(intExtra, intExtra2);
                bq(true);
            }
        }
        super.onActivityResult(i, i2, intent);
    }
}
