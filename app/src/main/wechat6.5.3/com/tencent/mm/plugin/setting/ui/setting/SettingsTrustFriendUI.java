package com.tencent.mm.plugin.setting.ui.setting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.bag;
import com.tencent.mm.protocal.c.zt;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.contact.r;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SettingsTrustFriendUI extends MMActivity implements e {
    private static int iNc = 5;
    private p fHW;
    private GridView gff;
    private TextView gxt;
    private List<String> iMY;
    private a iMZ;
    private View iNa;
    private boolean iNb;

    private class a extends BaseAdapter {
        final /* synthetic */ SettingsTrustFriendUI iNd;

        private class a {
            TextView emU;
            ImageView iCF;
            ImageView iNg;
            final /* synthetic */ a iNh;

            private a(a aVar) {
                this.iNh = aVar;
            }
        }

        private a(SettingsTrustFriendUI settingsTrustFriendUI) {
            this.iNd = settingsTrustFriendUI;
        }

        public final int getCount() {
            int size = this.iNd.iMY.size();
            if (this.iNd.iNb) {
                return size;
            }
            if (size == 0) {
                return 1;
            }
            if (size <= 0 || size >= SettingsTrustFriendUI.iNc) {
                return size >= SettingsTrustFriendUI.iNc ? size + 1 : 0;
            } else {
                return size + 2;
            }
        }

        public final Object getItem(int i) {
            if (getItemViewType(i) == 0) {
                return this.iNd.iMY.get(i);
            }
            return null;
        }

        public final int getItemViewType(int i) {
            int size = this.iNd.iMY.size();
            if (this.iNd.iNb || i < size) {
                return 0;
            }
            if (size == 0) {
                return 1;
            }
            if (size >= SettingsTrustFriendUI.iNc) {
                return 2;
            }
            if (i == size) {
                return 1;
            }
            if (i == size + 1) {
                return 2;
            }
            return -1;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.iNd.getLayoutInflater().inflate(2130904364, null);
                ImageView imageView = (ImageView) view.findViewById(2131759106);
                ImageView imageView2 = (ImageView) view.findViewById(2131759107);
                TextView textView = (TextView) view.findViewById(2131759108);
                a aVar2 = new a();
                aVar2.iCF = imageView;
                aVar2.iNg = imageView2;
                aVar2.emU = textView;
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                String str = (String) this.iNd.iMY.get(i);
                ak.yW();
                u LX = c.wH().LX(str);
                aVar.iCF.setScaleType(ScaleType.FIT_XY);
                b.m(aVar.iCF, str);
                aVar.emU.setText(com.tencent.mm.pluginsdk.ui.d.e.a(this.iNd, LX.tU(), aVar.emU.getTextSize()));
                if (this.iNd.iNb) {
                    aVar.iNg.setVisibility(0);
                } else {
                    aVar.iNg.setVisibility(8);
                }
            } else {
                aVar.emU.setVisibility(4);
                aVar.iNg.setVisibility(8);
                aVar.iCF.setScaleType(ScaleType.FIT_XY);
                if (getItemViewType(i) == 1) {
                    aVar.iCF.setImageResource(2130837697);
                } else if (getItemViewType(i) == 2) {
                    aVar.iCF.setImageResource(2130837698);
                }
            }
            return view;
        }
    }

    static /* synthetic */ void a(SettingsTrustFriendUI settingsTrustFriendUI) {
        final com.tencent.mm.plugin.setting.a.c cVar = new com.tencent.mm.plugin.setting.a.c();
        ak.vy().a(cVar, 0);
        settingsTrustFriendUI.getString(2131231035);
        settingsTrustFriendUI.fHW = g.a(settingsTrustFriendUI, settingsTrustFriendUI.getString(2131233521), true, new OnCancelListener(settingsTrustFriendUI) {
            final /* synthetic */ SettingsTrustFriendUI iNd;

            public final void onCancel(DialogInterface dialogInterface) {
                ak.vy().c(cVar);
            }
        });
    }

    static /* synthetic */ void h(SettingsTrustFriendUI settingsTrustFriendUI) {
        if (settingsTrustFriendUI.iMY.size() <= 0 || settingsTrustFriendUI.iMY.size() >= 3) {
            final com.tencent.mm.plugin.setting.a.a aVar = new com.tencent.mm.plugin.setting.a.a(settingsTrustFriendUI.iMY);
            ak.vy().a(aVar, 0);
            if (settingsTrustFriendUI.fHW != null) {
                settingsTrustFriendUI.fHW.dismiss();
            }
            settingsTrustFriendUI.getString(2131231035);
            settingsTrustFriendUI.fHW = g.a(settingsTrustFriendUI, settingsTrustFriendUI.getString(2131231151), true, new OnCancelListener(settingsTrustFriendUI) {
                final /* synthetic */ SettingsTrustFriendUI iNd;

                public final void onCancel(DialogInterface dialogInterface) {
                    ak.vy().c(aVar);
                }
            });
            return;
        }
        g.A(settingsTrustFriendUI, settingsTrustFriendUI.getString(2131235181, new Object[]{Integer.valueOf(3)}), settingsTrustFriendUI.getString(2131231164));
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ak.yW();
        String str = (String) c.vf().get(352277, null);
        if (!be.kS(str)) {
            this.iMY = be.g(str.split(","));
        }
        if (this.iMY == null) {
            this.iMY = new ArrayList();
        }
        this.nDR.dtW.post(new Runnable(this) {
            final /* synthetic */ SettingsTrustFriendUI iNd;

            {
                this.iNd = r1;
            }

            public final void run() {
                SettingsTrustFriendUI.a(this.iNd);
            }
        });
        NI();
    }

    protected final int getLayoutId() {
        return 2130904363;
    }

    public void onStart() {
        super.onStart();
        ak.vy().a(869, this);
        ak.vy().a(583, this);
    }

    protected void onStop() {
        super.onStop();
        ak.vy().b(869, this);
        ak.vy().b(583, this);
    }

    protected final void NI() {
        vD(2131235178);
        this.gff = (GridView) findViewById(2131759105);
        this.iMZ = new a();
        this.gff.setColumnWidth(getResources().getDimensionPixelSize(2131493160));
        this.gff.setNumColumns(-1);
        this.gff.setStretchMode(1);
        this.gff.setHorizontalSpacing(getResources().getDimensionPixelSize(2131493457) * 2);
        this.gff.setVerticalSpacing(getResources().getDimensionPixelSize(2131493458));
        this.gff.setAdapter(this.iMZ);
        ((ViewGroup) this.gff.getParent()).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI iNd;

            {
                this.iNd = r1;
            }

            public final void onClick(View view) {
                if (this.iNd.iNb) {
                    this.iNd.iNb = false;
                    this.iNd.iMZ.notifyDataSetChanged();
                }
            }
        });
        this.gff.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ SettingsTrustFriendUI iNd;

            {
                this.iNd = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (!this.iNd.iNb || motionEvent.getAction() != 1 || this.iNd.gff.pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY()) != -1) {
                    return false;
                }
                this.iNd.iNb = false;
                this.iNd.iMZ.notifyDataSetChanged();
                return true;
            }
        });
        this.gff.setHorizontalScrollBarEnabled(false);
        this.gff.setVerticalScrollBarEnabled(false);
        this.gff.setOnItemClickListener(new OnItemClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI iNd;

            {
                this.iNd = r1;
            }

            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.iNd.iMZ.getItemViewType(i) == 1) {
                    Intent intent = new Intent();
                    intent.putExtra("list_type", 12);
                    intent.putExtra("titile", this.iNd.getString(2131230883));
                    intent.putExtra("scene", 2);
                    intent.putExtra("max_limit_num", SettingsTrustFriendUI.iNc);
                    intent.putExtra("stay_in_wechat", true);
                    intent.putExtra("already_select_contact", be.b(this.iNd.iMY, ","));
                    intent.putExtra("block_contact", k.xF());
                    intent.putExtra("list_attr", r.do(r.oHO, 256));
                    intent.putExtra("too_many_member_tip_string", this.iNd.getString(2131235180, new Object[]{Integer.valueOf(SettingsTrustFriendUI.iNc)}));
                    com.tencent.mm.ay.c.a(this.iNd, ".ui.contact.SelectContactUI", intent, 1);
                    return;
                }
                if (this.iNd.iMZ.getItemViewType(i) == 2) {
                    if (!this.iNd.iNb) {
                        this.iNd.iNb = true;
                    } else {
                        return;
                    }
                } else if (this.iNd.iMZ.getItemViewType(i) == 0 && this.iNd.iNb) {
                    this.iNd.iMY.remove(this.iNd.iMZ.getItem(i));
                    if (this.iNd.iMY.size() == 0) {
                        this.iNd.iNb = false;
                    }
                } else {
                    return;
                }
                this.iNd.iMZ.notifyDataSetChanged();
            }
        });
        this.gxt = (TextView) findViewById(2131759103);
        this.gxt.setText(getResources().getString(2131235182, new Object[]{Integer.valueOf(3)}));
        this.iNa = findViewById(2131759101);
        this.iNa.setVisibility(8);
        ((TextView) this.iNa.findViewById(2131759102)).setText(getString(2131235181, new Object[]{Integer.valueOf(3)}));
        this.iNa.findViewById(2131758433).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI iNd;

            {
                this.iNd = r1;
            }

            public final void onClick(View view) {
                this.iNd.iNa.setVisibility(8);
            }
        });
        findViewById(2131759104).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI iNd;

            {
                this.iNd = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", "https://weixin110.qq.com/security/readtemplate?t=w_security_center_website/trusted_friend_guide");
                com.tencent.mm.ay.c.b(this.iNd, "webview", ".ui.tools.WebViewUI", intent);
            }
        });
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI iNd;

            {
                this.iNd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iNd.aNp();
                return true;
            }
        });
        a(1, getString(2131231065), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsTrustFriendUI iNd;

            {
                this.iNd = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                SettingsTrustFriendUI.h(this.iNd);
                return true;
            }
        });
        iU(true);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (!be.kS(stringExtra)) {
                this.iMY.clear();
                this.iMY.addAll(be.g(stringExtra.split(",")));
                this.iMZ.notifyDataSetChanged();
            }
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.d("MicroMsg.SettingsTrustFriendUI", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.fHW != null) {
            this.fHW.dismiss();
        }
        if (i == 0 && i2 == 0) {
            if (kVar.getType() == 869) {
                int i3;
                zt ztVar = (zt) ((com.tencent.mm.v.b) kVar.BD()).czl.czs;
                iNc = ztVar.mBh;
                List<bag> list = ztVar.mch;
                if (list.size() != this.iMY.size()) {
                    i3 = 1;
                    break;
                } else if (list.size() == 0) {
                    i3 = 0;
                } else {
                    for (bag com_tencent_mm_protocal_c_bag : list) {
                        if (!this.iMY.contains(com_tencent_mm_protocal_c_bag.gln)) {
                            i3 = 1;
                            break;
                        }
                    }
                    i3 = 0;
                }
                if (i3 != 0) {
                    this.iMY.clear();
                    for (bag com_tencent_mm_protocal_c_bag2 : list) {
                        this.iMY.add(com_tencent_mm_protocal_c_bag2.gln);
                    }
                    this.iMZ.notifyDataSetChanged();
                }
                if (this.iMY.size() > 0 && this.iMY.size() < 3) {
                    this.iNa.setVisibility(0);
                }
                ak.yW();
                c.vf().set(352277, be.b(this.iMY, ","));
            } else if (kVar.getType() == 583) {
                ak.yW();
                c.vf().set(352277, be.b(this.iMY, ","));
                finish();
            }
        } else if (!be.kS(str)) {
            g.bf(this, str);
        }
    }

    private void aNp() {
        ak.yW();
        String str = (String) c.vf().get(352277, null);
        ArrayList arrayList = new ArrayList();
        if (be.kS(str)) {
            Object obj = arrayList;
        } else {
            Collection g = be.g(str.split(","));
        }
        if (this.iMY.size() == g.size() && this.iMY.containsAll(g)) {
            finish();
        } else {
            g.a(this, getString(2131234726), getString(2131231164), getString(2131231146), getString(2131231105), true, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsTrustFriendUI iNd;

                {
                    this.iNd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    SettingsTrustFriendUI.h(this.iNd);
                }
            }, new DialogInterface.OnClickListener(this) {
                final /* synthetic */ SettingsTrustFriendUI iNd;

                {
                    this.iNd = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    this.iNd.finish();
                }
            });
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        aNp();
        return true;
    }
}
