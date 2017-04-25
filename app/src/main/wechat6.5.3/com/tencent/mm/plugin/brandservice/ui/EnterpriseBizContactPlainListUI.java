package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.l;
import com.tencent.mm.model.m;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.d;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.j;
import java.util.HashMap;

public class EnterpriseBizContactPlainListUI extends MMActivity {
    private String cBj;
    private ListView eyT;
    private a ezg;
    private long ezh;
    private OnItemClickListener ezi;
    private int scene;

    class a extends j<b> implements com.tencent.mm.sdk.h.j.b {
        com.tencent.mm.ui.applet.b cHD = new com.tencent.mm.ui.applet.b(new com.tencent.mm.ui.applet.b.a(this) {
            final /* synthetic */ a ezm;

            {
                this.ezm = r1;
            }

            public final Bitmap iG(String str) {
                return com.tencent.mm.u.b.a(str, false, -1);
            }
        });
        private com.tencent.mm.ui.applet.b.b cHE = null;
        final /* synthetic */ EnterpriseBizContactPlainListUI ezj;

        class a {
            ImageView cHH;
            TextView cHI;
            final /* synthetic */ a ezm;

            a(a aVar) {
                this.ezm = aVar;
            }

            public final void clear() {
                if (this.cHH != null) {
                    this.cHH.setImageDrawable(null);
                    this.cHH.setVisibility(8);
                }
                if (this.cHI != null) {
                    this.cHI.setText("");
                    this.cHI.setVisibility(8);
                }
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (b) obj;
            if (obj == null) {
                v.e("MicroMsg.EnterpriseBizListAdapter", "item == null");
                obj = new b();
            }
            if (cursor != null) {
                u uVar = new u();
                uVar.b(cursor);
                BizInfo bizInfo = new BizInfo();
                bizInfo.b(cursor);
                obj.userName = uVar.field_username;
                obj.euW = uVar;
                obj.exj = bizInfo;
                v.d("MicroMsg.EnterpriseBizListAdapter", "convertFrom userName = %s", new Object[]{obj.userName});
            }
            return obj;
        }

        public a(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, Context context) {
            this.ezj = enterpriseBizContactPlainListUI;
            super(context, new b());
            Ol();
        }

        public final void a(String str, i iVar) {
            v.i("MicroMsg.EnterpriseBizListAdapter", "onNotifyChange");
            ad.o(new Runnable(this) {
                final /* synthetic */ a ezm;

                {
                    this.ezm = r1;
                }

                public final void run() {
                    this.ezm.Om();
                    TextView textView = (TextView) this.ezm.ezj.findViewById(2131756768);
                    if (!(this.ezm.ezj.eyT == null || textView == null)) {
                        ak.yW();
                        u LX = c.wH().LX(this.ezm.ezj.cBj);
                        if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
                            this.ezm.ezj.eyT.setVisibility(8);
                            textView.setVisibility(0);
                        } else if (this.ezm.ezj.ezg.getCount() <= 0) {
                            this.ezm.ezj.eyT.setVisibility(8);
                            textView.setVisibility(0);
                        } else {
                            this.ezm.ezj.eyT.setVisibility(0);
                            textView.setVisibility(8);
                            this.ezm.ezj.eyT.setAdapter(this.ezm.ezj.ezg);
                            this.ezm.ezj.eyT.setOnItemClickListener(this.ezm.ezj.ezi);
                        }
                    }
                    if (textView.getVisibility() == 0 && this.ezm.ezj.scene == 2) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838177, 0, 0);
                    }
                    this.ezm.notifyDataSetChanged();
                }
            });
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (this.cHE == null) {
                this.cHE = new com.tencent.mm.ui.applet.b.b(this) {
                    final /* synthetic */ a ezm;

                    {
                        this.ezm = r1;
                    }

                    public final String fo(int i) {
                        if (i < 0 || i >= this.ezm.getCount()) {
                            v.e("MicroMsg.EnterpriseBizListAdapter", "pos is invalid");
                            return null;
                        }
                        b bVar = (b) this.ezm.getItem(i);
                        return bVar == null ? null : bVar.userName;
                    }

                    public final int EU() {
                        return this.ezm.getCount();
                    }
                };
            }
            if (this.cHD != null) {
                this.cHD.a(i, this.cHE);
            }
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.context, 2130903524, null);
                aVar.cHH = (ImageView) view.findViewById(2131756765);
                aVar.cHI = (TextView) view.findViewById(2131756766);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            b bVar = (b) getItem(i);
            if (bVar == null) {
                aVar.clear();
            } else {
                aVar.clear();
                int paddingBottom = view.getPaddingBottom();
                int paddingTop = view.getPaddingTop();
                int paddingRight = view.getPaddingRight();
                int paddingLeft = view.getPaddingLeft();
                view.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.context, 2130838046));
                view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                aVar.cHI.setText(e.a(this.context, be.ma(bVar.euW.tT()), aVar.cHI.getTextSize()));
                aVar.cHI.setVisibility(0);
                aVar.cHH.setVisibility(0);
                if (be.kS(bVar.euW.field_username)) {
                    aVar.cHH.setImageDrawable(null);
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.m(aVar.cHH, bVar.euW.field_username);
                }
            }
            return view;
        }

        protected final void Om() {
            Ol();
        }

        public final void Ol() {
            Cursor cursor = null;
            if (ak.uz()) {
                avc();
                switch (this.ezj.scene) {
                    case 1:
                        com.tencent.mm.modelbiz.u.Dy();
                        cursor = d.s(this.ezj.cBj, 25);
                        break;
                    case 2:
                        com.tencent.mm.modelbiz.u.Dy();
                        String c = this.ezj.cBj;
                        StringBuilder stringBuilder = new StringBuilder();
                        d.b(stringBuilder);
                        d.c(stringBuilder);
                        d.a(stringBuilder, c);
                        d.b(stringBuilder, false);
                        d.a(stringBuilder, false);
                        stringBuilder.append(" order by ");
                        stringBuilder.append(d.Dc());
                        v.i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", new Object[]{stringBuilder.toString()});
                        ak.yW();
                        cursor = c.wE().rawQuery(c, null);
                        break;
                    case 3:
                        com.tencent.mm.modelbiz.u.Dy();
                        cursor = d.s(this.ezj.cBj, 128);
                        break;
                    case 4:
                        BizInfo hw = com.tencent.mm.modelbiz.e.hw(this.ezj.cBj);
                        if (!(hw == null || hw.field_enterpriseFather == null)) {
                            cursor = com.tencent.mm.modelbiz.u.Dy().hq(hw.field_enterpriseFather);
                            break;
                        }
                    default:
                        com.tencent.mm.modelbiz.u.Dy();
                        cursor = d.u(this.ezj.cBj, true);
                        break;
                }
                setCursor(cursor);
                return;
            }
            v.e("MicroMsg.EnterpriseBizListAdapter", "accHasReady");
        }
    }

    static /* synthetic */ void a(EnterpriseBizContactPlainListUI enterpriseBizContactPlainListUI, int i) {
        final b bVar = (b) enterpriseBizContactPlainListUI.ezg.getItem(i);
        if (bVar == null || bVar.userName == null) {
            v.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "item is null.");
        } else if (enterpriseBizContactPlainListUI.scene == 1) {
            com.tencent.mm.pluginsdk.ui.applet.c.b(enterpriseBizContactPlainListUI.nDR, bVar.userName, enterpriseBizContactPlainListUI.getString(2131234559), l.eq(bVar.userName), null, enterpriseBizContactPlainListUI.getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(enterpriseBizContactPlainListUI) {
                final /* synthetic */ EnterpriseBizContactPlainListUI ezj;

                public final void a(boolean z, String str, int i) {
                    if (z) {
                        Intent intent = this.ezj.getIntent();
                        intent.putExtra("enterprise_biz_name", bVar.userName);
                        this.ezj.setResult(-1, intent);
                        this.ezj.finish();
                    }
                }
            });
        } else if (enterpriseBizContactPlainListUI.scene == 2) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", bVar.userName);
            com.tencent.mm.plugin.brandservice.a.drp.d(intent, enterpriseBizContactPlainListUI);
        } else if (enterpriseBizContactPlainListUI.scene == 3) {
            HashMap hashMap = (HashMap) enterpriseBizContactPlainListUI.getIntent().getSerializableExtra("enterprise_extra_params");
            String str = (String) hashMap.get("img_url");
            String str2 = (String) hashMap.get("desc");
            String str3 = (String) hashMap.get("title");
            final String str4 = bVar.userName;
            com.tencent.mm.pluginsdk.ui.applet.c.a(enterpriseBizContactPlainListUI.nDR, str3, str, str2, false, enterpriseBizContactPlainListUI.getResources().getString(2131231149), new com.tencent.mm.pluginsdk.ui.applet.c.a(enterpriseBizContactPlainListUI) {
                final /* synthetic */ EnterpriseBizContactPlainListUI ezj;

                public final void a(boolean z, String str, int i) {
                    if (z && this.ezj.scene == 3) {
                        Intent intent = this.ezj.getIntent();
                        intent.putExtra("enterprise_biz_name", str4);
                        this.ezj.setResult(-1, intent);
                        this.ezj.finish();
                    }
                }
            });
        } else if (enterpriseBizContactPlainListUI.scene == 4) {
            BizInfo hw = com.tencent.mm.modelbiz.e.hw(bVar.userName);
            String CE = hw == null ? null : hw.CE();
            if (!be.kS(CE)) {
                com.tencent.mm.modelbiz.b gZ = com.tencent.mm.modelbiz.u.DF().gZ(hw.CF());
                int i2 = gZ != null ? gZ.field_qyUin : 0;
                int i3 = gZ != null ? gZ.field_userUin : 0;
                int hb = com.tencent.mm.modelbiz.u.DF().hb(hw.field_username);
                g.iuh.h(13419, new Object[]{Integer.valueOf(i2), Integer.valueOf(hb), Integer.valueOf(i3), Integer.valueOf(1)});
                v.d("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizEnterpriseActive report fatherUin:%d,childUin:%d,userUin:%d,scene:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(hb), Integer.valueOf(i3), Integer.valueOf(1)});
                Intent intent2 = new Intent();
                intent2.putExtra("rawUrl", CE);
                intent2.putExtra("useJs", true);
                intent2.putExtra("srcUsername", bVar.userName);
                intent2.putExtra("enterprise_biz_name", enterpriseBizContactPlainListUI.cBj);
                intent2.putExtra("biz_chat_chat_id", enterpriseBizContactPlainListUI.ezh);
                com.tencent.mm.ay.c.b(enterpriseBizContactPlainListUI.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent2, 1);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.scene = getIntent().getIntExtra("enterprise_scene", 2);
        this.cBj = getIntent().getStringExtra("enterprise_biz_name");
        this.ezh = getIntent().getLongExtra("biz_chat_chat_id", -1);
        v.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "bizName = %s", new Object[]{this.cBj});
        NI();
        com.tencent.mm.modelbiz.u.Dy().c(this.ezg);
        ak.yW();
        c.wH().a(this.ezg);
    }

    protected final void NI() {
        this.eyT = (ListView) findViewById(2131756767);
        if (this.ezg == null) {
            this.ezg = new a(this, this);
            this.ezi = new OnItemClickListener(this) {
                final /* synthetic */ EnterpriseBizContactPlainListUI ezj;

                {
                    this.ezj = r1;
                }

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    v.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "onItemClick position = %s", new Object[]{Integer.valueOf(i)});
                    EnterpriseBizContactPlainListUI.a(this.ezj, i);
                }
            };
        }
        v.i("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "count = %s", new Object[]{Integer.valueOf(this.ezg.getCount())});
        ak.yW();
        u LX = c.wH().LX(this.cBj);
        if (this.scene == 2) {
            vD(2131232463);
        } else if (LX != null) {
            Fd(LX.tT());
        }
        if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type) || this.ezg.getCount() <= 0) {
            this.eyT.setVisibility(8);
            TextView textView = (TextView) findViewById(2131756768);
            if (this.scene == 2) {
                textView.setText(2131232464);
                textView.setCompoundDrawablesWithIntrinsicBounds(0, 2130838177, 0, 0);
            } else {
                textView.setText(2131232470);
            }
            textView.setVisibility(0);
        } else {
            this.eyT.setVisibility(0);
            this.eyT.setAdapter(this.ezg);
            this.eyT.setOnItemClickListener(this.ezi);
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ EnterpriseBizContactPlainListUI ezj;

            {
                this.ezj = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.ezj.axg();
                this.ezj.finish();
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener(this) {
            final /* synthetic */ EnterpriseBizContactPlainListUI ezj;

            {
                this.ezj = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.ezj.eyT);
            }
        };
    }

    protected void onResume() {
        super.onResume();
        if (!m.eC(this.cBj)) {
            v.e("MicroMsg.BrandService.EnterpriseBizContactPlainListUI", "%s !isContact", new Object[]{this.cBj});
            finish();
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        com.tencent.mm.modelbiz.u.Dy().d(this.ezg);
        ak.yW();
        c.wH().b(this.ezg);
        this.ezg.avc();
        a aVar = this.ezg;
        if (aVar.cHD != null) {
            aVar.cHD.detach();
            aVar.cHD = null;
        }
        super.onDestroy();
    }

    protected final int getLayoutId() {
        return 2130903526;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.scene == 4) {
            finish();
        }
    }
}
