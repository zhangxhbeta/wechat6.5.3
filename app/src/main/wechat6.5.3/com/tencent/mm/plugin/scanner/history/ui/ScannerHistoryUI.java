package com.tencent.mm.plugin.scanner.history.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.a.g;
import com.tencent.mm.ae.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.scanner.a.i;
import com.tencent.mm.plugin.scanner.ui.ProductUI;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.j;

public class ScannerHistoryUI extends MMActivity {
    private ListView Eq;
    private View dZV;
    private LinearLayout eLD;
    private View eLE;
    private TextView eLF;
    private a ivB;

    class a extends j<com.tencent.mm.plugin.scanner.history.a.a> {
        final /* synthetic */ ScannerHistoryUI ivC;

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (com.tencent.mm.plugin.scanner.history.a.a) obj;
            if (obj == null) {
                obj = new com.tencent.mm.plugin.scanner.history.a.a();
            }
            obj.b(cursor);
            return obj;
        }

        public a(ScannerHistoryUI scannerHistoryUI) {
            this.ivC = scannerHistoryUI;
            super(scannerHistoryUI, new com.tencent.mm.plugin.scanner.history.a.a());
            iQ(true);
        }

        public final void Ol() {
            setCursor(com.tencent.mm.plugin.scanner.b.aKQ().Kp());
            notifyDataSetChanged();
        }

        protected final void Om() {
            avc();
            Ol();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            b bVar;
            com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) getItem(i);
            if (view == null) {
                view = View.inflate(this.ivC.nDR.nEl, 2130904292, null);
                b bVar2 = new b();
                bVar2.dQZ = (ImageView) view.findViewById(2131756640);
                bVar2.eLe = (TextView) view.findViewById(2131756713);
                bVar2.eLf = (TextView) view.findViewById(2131758967);
                bVar2.eLg = (TextView) view.findViewById(2131758966);
                view.setTag(bVar2);
                bVar = bVar2;
            } else {
                bVar = (b) view.getTag();
            }
            com.tencent.mm.plugin.scanner.b.n.a aN = i.aN(aVar.field_xmlContent, aVar.field_funcType);
            bVar.eLe.setText(aN.field_title);
            bVar.eLf.setText(o.c(this.ivC, aVar.field_ScanTime, true));
            bVar.eLg.setText(aN.field_subtitle);
            int dimensionPixelSize = this.ivC.getResources().getDimensionPixelSize(2131493553);
            bVar.dQZ.setImageResource(2130838891);
            v.d("MicroMsg.ScannerHistoryUI", "ScannerHistoryUI getView () position : " + i + " logo_url :  " + aN.field_thumburl);
            if (TextUtils.isEmpty(aN.field_thumburl)) {
                bVar.dQZ.setImageResource(2130838891);
            } else {
                String format;
                com.tencent.mm.ae.a.a.c.a aVar2 = new com.tencent.mm.ae.a.a.c.a();
                aVar2.cPv = e.cnj;
                n.GM();
                aVar2.cPN = null;
                com.tencent.mm.plugin.scanner.b aKP = com.tencent.mm.plugin.scanner.b.aKP();
                String str = aN.field_thumburl;
                if (ak.uz()) {
                    format = String.format("%s/scanbook_%s", new Object[]{aKP.cka + "image/scan/img", g.m(str.getBytes())});
                } else {
                    format = "";
                }
                aVar2.cPu = format;
                aVar2.cPs = true;
                aVar2.cPP = false;
                aVar2.cPq = true;
                aVar2.cPz = dimensionPixelSize;
                aVar2.cPy = dimensionPixelSize;
                aVar2.cPH = 2130838891;
                n.GL().a(aN.field_thumburl, bVar.dQZ, aVar2.GU());
            }
            return view;
        }
    }

    private class b {
        ImageView dQZ;
        TextView eLe;
        TextView eLf;
        TextView eLg;
        final /* synthetic */ ScannerHistoryUI ivC;

        private b(ScannerHistoryUI scannerHistoryUI) {
            this.ivC = scannerHistoryUI;
        }
    }

    static /* synthetic */ void a(ScannerHistoryUI scannerHistoryUI, int i) {
        com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) scannerHistoryUI.ivB.getItem(i);
        if (aVar != null) {
            Intent intent = new Intent();
            intent.setClass(scannerHistoryUI, ProductUI.class);
            intent.setFlags(65536);
            intent.putExtra("key_Product_xml", aVar.field_xmlContent);
            intent.putExtra("key_Product_funcType", aVar.field_funcType);
            intent.putExtra("key_Qrcode_Url", aVar.field_qrcodeUrl);
            intent.putExtra("key_need_add_to_history", false);
            scannerHistoryUI.startActivity(intent);
            com.tencent.mm.plugin.report.service.g.iuh.h(12684, new Object[]{Integer.valueOf(0), Integer.valueOf(1)});
        }
    }

    protected final int getLayoutId() {
        return 2130904295;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    protected final void NI() {
        vD(2131234756);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ScannerHistoryUI ivC;

            {
                this.ivC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ivC.finish();
                return true;
            }
        });
        this.Eq = (ListView) findViewById(2131758969);
        this.eLD = (LinearLayout) View.inflate(getBaseContext(), 2130904294, null);
        this.Eq.addHeaderView(this.eLD);
        this.ivB = new a(this);
        this.Eq.setAdapter(this.ivB);
        this.Eq.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ ScannerHistoryUI ivC;

            {
                this.ivC = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    v.v("MicroMsg.ScannerHistoryUI", "onItemClick pos is 0, click headerview");
                    return;
                }
                if (i > 0) {
                    i--;
                }
                ScannerHistoryUI.a(this.ivC, i);
            }
        });
        this.Eq.setOnItemLongClickListener(new OnItemLongClickListener(this) {
            final /* synthetic */ ScannerHistoryUI ivC;

            {
                this.ivC = r1;
            }

            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (i == 0) {
                    v.i("MicroMsg.ScannerHistoryUI", "onItemLongClick pos is 0");
                } else {
                    if (i > 0) {
                        i--;
                    }
                    if (i < this.ivC.ivB.getCount()) {
                        com.tencent.mm.ui.base.g.a(this.ivC, this.ivC.getResources().getString(2131231657), null, this.ivC.getResources().getString(2131231020), new c(this.ivC, i) {
                            final /* synthetic */ ScannerHistoryUI ivC;

                            public final void gT(int i) {
                                switch (i) {
                                    case 0:
                                        com.tencent.mm.plugin.scanner.history.a.a aVar = (com.tencent.mm.plugin.scanner.history.a.a) this.ivC.ivB.getItem(r5);
                                        if (aVar != null) {
                                            com.tencent.mm.plugin.scanner.b.aKQ().c(aVar, new String[0]);
                                            this.ivC.aaI();
                                            this.ivC.ivB.a(null, null);
                                            return;
                                        }
                                        return;
                                    default:
                                        return;
                                }
                            }
                        });
                    }
                }
                return true;
            }
        });
        a(0, getString(2131231596), new OnMenuItemClickListener(this) {
            final /* synthetic */ ScannerHistoryUI ivC;

            {
                this.ivC = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.ui.base.g.a(this.ivC, true, this.ivC.getString(2131234755), "", this.ivC.getString(2131231107), this.ivC.getString(2131231010), new OnClickListener(this.ivC) {
                    final /* synthetic */ ScannerHistoryUI ivC;

                    {
                        this.ivC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        com.tencent.mm.plugin.scanner.b.aKQ().cie.dF("ScanHistoryItem", "delete from ScanHistoryItem");
                        this.ivC.aaI();
                        this.ivC.ivB.a(null, null);
                    }
                }, new OnClickListener(this.ivC) {
                    final /* synthetic */ ScannerHistoryUI ivC;

                    {
                        this.ivC = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                return true;
            }
        });
        this.dZV = findViewById(2131755725);
        this.eLE = View.inflate(this, 2130904293, null);
        if (this.eLD != null) {
            this.eLD.addView(this.eLE);
        }
        this.eLF = (TextView) this.eLE.findViewById(2131758968);
        this.eLF.setText(2131233284);
        aaI();
    }

    private void aaI() {
        if (com.tencent.mm.plugin.scanner.b.aKQ().getCount() > 0) {
            this.Eq.setVisibility(0);
            this.dZV.setVisibility(8);
            this.eLE.setVisibility(0);
            iT(true);
        } else {
            this.Eq.setVisibility(8);
            this.dZV.setVisibility(0);
            this.eLE.setVisibility(8);
            iT(false);
        }
        this.ivB.notifyDataSetChanged();
    }
}
