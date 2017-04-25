package com.tencent.mm.plugin.shake.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.shake.b.k;
import com.tencent.mm.plugin.shake.d.a.h;
import com.tencent.mm.plugin.shake.d.a.i;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.tools.l;
import com.tenpay.android.wechat.PayuSecureEncrypt;
import java.io.File;

public class ShakeItemListUI extends MMActivity {
    private int aXx;
    private com.tencent.mm.ae.a.a cOz = null;
    private View eKS;
    private d eus = new d(this) {
        final /* synthetic */ ShakeItemListUI iQZ;

        {
            this.iQZ = r1;
        }

        public final void c(MenuItem menuItem, int i) {
            k.aNO().pl(this.iQZ.id);
        }
    };
    private ListView hFk;
    public long iQW = 0;
    private boolean iQX = false;
    private a iQY;
    private int id;

    class a extends j<com.tencent.mm.plugin.shake.b.d> {
        private int aXx = 0;
        b cHD = new b(new com.tencent.mm.ui.applet.b.a(this) {
            final /* synthetic */ a iRc;

            {
                this.iRc = r1;
            }

            public final Bitmap iG(String str) {
                return com.tencent.mm.u.b.a(str, false, -1);
            }
        });
        private b.b cHE = null;
        final /* synthetic */ ShakeItemListUI iQZ;

        class a {
            ImageView cHH;
            TextView cHI;
            TextView cHJ;
            TextView hFG;
            TextView hFH;
            ImageView hFI;
            final /* synthetic */ a iRc;
            View iRd;
            ImageView iRe;
            TextView iRf;
            LinearLayout iRg;
            TextView iRh;

            a(a aVar) {
                this.iRc = aVar;
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
                if (this.cHJ != null) {
                    this.cHJ.setVisibility(8);
                }
                if (this.iRe != null) {
                    this.iRe.setVisibility(8);
                }
                if (this.hFG != null) {
                    this.hFG.setText("");
                    this.hFG.setVisibility(8);
                }
                if (this.hFH != null) {
                    this.hFH.setVisibility(8);
                    this.iRd.setVisibility(8);
                }
                if (this.hFI != null) {
                    this.hFI.setVisibility(8);
                }
                if (this.iRf != null) {
                    this.iRf.setText("");
                    this.iRf.setVisibility(8);
                }
            }
        }

        public final /* synthetic */ Object a(Object obj, Cursor cursor) {
            obj = (com.tencent.mm.plugin.shake.b.d) obj;
            if (obj == null) {
                obj = new com.tencent.mm.plugin.shake.b.d();
            }
            if (cursor != null) {
                obj.b(cursor);
            }
            return obj;
        }

        public a(ShakeItemListUI shakeItemListUI, ShakeItemListUI shakeItemListUI2) {
            this.iQZ = shakeItemListUI;
            super(shakeItemListUI2, new com.tencent.mm.plugin.shake.b.d());
            Om();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (this.cHE == null) {
                this.cHE = new b.b(this) {
                    final /* synthetic */ a iRc;

                    {
                        this.iRc = r1;
                    }

                    public final String fo(int i) {
                        if (i < 0 || i >= this.iRc.getCount()) {
                            v.e("MicroMsg.ShakeFriendAdapter", "pos is invalid");
                            return null;
                        }
                        com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) this.iRc.getItem(i);
                        return dVar == null ? null : dVar.field_username;
                    }

                    public final int EU() {
                        return this.iRc.getCount();
                    }
                };
            }
            if (this.cHD != null) {
                this.cHD.a(i, this.cHE);
            }
            if (view == null) {
                aVar = new a(this);
                view = View.inflate(this.context, 2130904368, null);
                aVar.cHH = (ImageView) view.findViewById(2131756765);
                aVar.cHI = (TextView) view.findViewById(2131756766);
                aVar.cHJ = (TextView) view.findViewById(2131758410);
                aVar.iRe = (ImageView) view.findViewById(2131758411);
                aVar.hFG = (TextView) view.findViewById(2131758413);
                aVar.hFH = (TextView) view.findViewById(2131758419);
                aVar.hFI = (ImageView) view.findViewById(2131758412);
                aVar.iRf = (TextView) view.findViewById(2131759124);
                aVar.iRd = view.findViewById(2131758418);
                aVar.iRg = (LinearLayout) view.findViewById(2131759126);
                aVar.iRh = (TextView) view.findViewById(2131759125);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) getItem(i);
            if (dVar != null) {
                aVar.clear();
                if (4 == dVar.field_type || (com.tencent.mm.plugin.shake.d.a.k.pq(dVar.field_type) && 6 != dVar.field_type)) {
                    if (4 != dVar.field_type) {
                        aVar.cHH.setScaleType(ScaleType.CENTER_CROP);
                    }
                    e.a(aVar.cHH, dVar.field_sns_bgurl, 2131165247, false);
                } else if (11 == dVar.field_type) {
                    this.iQZ.cOz.a(dVar.getProvince(), aVar.cHH);
                } else {
                    com.tencent.mm.pluginsdk.ui.a.b.m(aVar.cHH, dVar.field_username);
                }
                aVar.cHH.setVisibility(0);
                if (7 != dVar.field_type && 10 != dVar.field_type && 12 != dVar.field_type && (8 != dVar.field_type || !be.kS(dVar.field_nickname) || !be.kS(dVar.field_username))) {
                    aVar.iRh.setVisibility(8);
                    aVar.iRg.setVisibility(0);
                    if (8 == dVar.field_type && be.kS(dVar.field_nickname)) {
                        dVar.field_nickname = dVar.field_distance;
                        dVar.field_distance = dVar.field_username;
                    }
                    aVar.cHI.setText(e.a(this.context, be.ma(dVar.field_nickname), aVar.cHI.getTextSize()));
                    aVar.cHI.setVisibility(0);
                    int paddingBottom = view.getPaddingBottom();
                    int paddingTop = view.getPaddingTop();
                    int paddingRight = view.getPaddingRight();
                    int paddingLeft = view.getPaddingLeft();
                    if (dVar.field_insertBatch == 2) {
                        view.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.context, 2130838045));
                    } else {
                        view.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.context, 2130838046));
                    }
                    view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
                    switch (dVar.field_type) {
                        case 1:
                        case 2:
                        case 3:
                            aVar.iRf.setText(dVar.field_nickname);
                            aVar.iRf.setVisibility(0);
                            break;
                        default:
                            aVar.iRd.setVisibility(0);
                            aVar.hFG.setText(dVar.field_distance);
                            aVar.hFG.setVisibility(0);
                            if (dVar.field_signature == null || dVar.field_signature.trim().equals("")) {
                                aVar.hFH.setVisibility(8);
                            } else {
                                aVar.hFH.setVisibility(0);
                                aVar.hFH.setText(e.a(this.context, dVar.field_signature, aVar.cHI.getTextSize()));
                            }
                            if (dVar.field_sex == 1) {
                                aVar.iRe.setVisibility(0);
                                aVar.iRe.setImageDrawable(com.tencent.mm.bd.a.a(this.context, 2131165606));
                                aVar.iRe.setContentDescription(this.context.getString(2131233728));
                            } else if (dVar.field_sex == 2) {
                                aVar.iRe.setVisibility(0);
                                aVar.iRe.setImageDrawable(com.tencent.mm.bd.a.a(this.context, 2131165605));
                                aVar.iRe.setContentDescription(this.context.getString(2131232762));
                            } else {
                                aVar.iRe.setVisibility(8);
                            }
                            ak.yW();
                            u LX = c.wH().LX(dVar.field_username);
                            if (LX == null || !com.tencent.mm.i.a.ei(LX.field_type)) {
                                aVar.cHJ.setVisibility(8);
                            } else {
                                aVar.cHJ.setVisibility(0);
                                if (u.vd(dVar.field_reserved1)) {
                                    aVar.cHJ.setText(this.context.getString(2131233989));
                                } else {
                                    aVar.cHJ.setText(this.context.getString(2131233994));
                                }
                            }
                            if (6 == dVar.field_type) {
                                aVar.hFG.setText(this.context.getString(2131235235));
                                aVar.cHJ.setVisibility(8);
                            }
                            if (dVar.field_reserved1 == 0) {
                                aVar.hFI.setVisibility(8);
                                break;
                            }
                            aVar.hFI.setVisibility(0);
                            aVar.hFI.setImageBitmap(BackwardSupportUtil.b.c(com.tencent.mm.model.ab.a.csb.eI(dVar.field_reserved1), 2.0f));
                            aVar.iRe.setVisibility(8);
                            break;
                            break;
                    }
                }
                if (8 == dVar.field_type) {
                    aVar.iRh.setText(dVar.field_distance);
                } else {
                    aVar.iRh.setText(dVar.field_nickname);
                }
                aVar.iRh.setVisibility(0);
                aVar.iRg.setVisibility(8);
            } else {
                aVar.clear();
            }
            return view;
        }

        protected final void Om() {
            avc();
            Ol();
        }

        public final void Ol() {
            if (ak.uz()) {
                switch (this.aXx) {
                    case -12:
                        com.tencent.mm.plugin.shake.b.e aNO = k.aNO();
                        int intExtra = this.iQZ.getIntent().getIntExtra("_ibeacon_new_insert_size", 2);
                        setCursor(aNO.rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc limit ? ", new String[]{"11", String.valueOf(intExtra)}));
                        break;
                    case -6:
                        setCursor(k.aNO().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[]{"8", "2"}));
                        break;
                    case -5:
                        setCursor(k.aNO().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by shakeItemID desc ", new String[]{"4", "2"}));
                        break;
                    case -1:
                        setCursor(k.aNO().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? and insertBatch = ?  order by reserved2 desc, shakeItemID desc ", new String[]{"0", "2"}));
                        break;
                    case 0:
                        setCursor(k.aNO().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[]{"0"}));
                        break;
                    case 4:
                        setCursor(k.aNO().aND());
                        break;
                    case 5:
                        setCursor(k.aNO().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type in (?, ?, ?, ?, ?) order by shakeItemID desc ", new String[]{"7", "6", "8", "9", PayuSecureEncrypt.ENCRYPT_VERSION_DEFAULT, "12"}));
                        break;
                    case 11:
                        setCursor(k.aNO().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   where type = ? order by reserved2 desc, shakeItemID desc ", new String[]{"11"}));
                        break;
                    case 100:
                        setCursor(k.aNO().rawQuery("select shakeitem1.shakeItemID,shakeitem1.username,shakeitem1.nickname,shakeitem1.province,shakeitem1.city,shakeitem1.signature,shakeitem1.distance,shakeitem1.sex,shakeitem1.imgstatus,shakeitem1.hasHDImg,shakeitem1.insertBatch,shakeitem1.reserved1,shakeitem1.reserved2,shakeitem1.reserved3,shakeitem1.reserved4,shakeitem1.type,shakeitem1.lvbuffer,shakeitem1.regionCode,shakeitem1.snsFlag,shakeitem1.sns_bgurl from shakeitem1   order by shakeItemID desc ", new String[0]));
                        break;
                }
                super.notifyDataSetChanged();
            }
        }

        protected final void ps(int i) {
            this.aXx = i;
            Om();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        NI();
        k.aNO().c(this.iQY);
        this.iQY.Om();
        v.i("MicroMsg.ShakeItemListUI", "onResume");
    }

    protected final void NI() {
        this.cOz = new com.tencent.mm.ae.a.a(this);
        ak.yW();
        final int a = be.a((Integer) c.vf().get(12290, null), 0);
        this.aXx = getIntent().getIntExtra("_key_show_type_", 0);
        String stringExtra = getIntent().getStringExtra("_key_title_");
        if (!be.kS(stringExtra)) {
            Fd(stringExtra);
        }
        this.iQX = getIntent().getBooleanExtra("_key_show_from_shake_", false);
        a(0, getString(2131231012), new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeItemListUI iQZ;

            {
                this.iQZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                g.a(this.iQZ, true, this.iQZ.getString(2131234730), "", this.iQZ.getString(2131231012), this.iQZ.getString(2131231010), new OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 iRa;

                    {
                        this.iRa = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        switch (this.iRa.iQZ.aXx) {
                            case -12:
                            case 11:
                                k.aNO().pm(11);
                                break;
                            case -6:
                            case 5:
                                k.aNO().pm(7);
                                k.aNO().pm(6);
                                k.aNO().pm(8);
                                k.aNO().pm(9);
                                k.aNO().pm(10);
                                k.aNO().pm(12);
                                break;
                            case -5:
                            case 4:
                                ak.vA().x(new Runnable() {
                                    public final void run() {
                                        com.tencent.mm.a.e.e(new File(i.aOs()));
                                    }

                                    public final String toString() {
                                        return super.toString() + "|asyncClearMusicData";
                                    }
                                });
                                k.aNO().pm(4);
                                break;
                            case -1:
                            case 0:
                                k.aNO().pm(0);
                                break;
                            case 100:
                                k.aNO().pm(0);
                                k.aNO().aNF();
                                break;
                        }
                        this.iRa.iQZ.iQY.Ol();
                        this.iRa.iQZ.hFk.setVisibility(8);
                        TextView textView = (TextView) this.iRa.iQZ.findViewById(2131758407);
                        textView.setText(ShakeItemListUI.pt(this.iRa.iQZ.aXx));
                        textView.setVisibility(0);
                        this.iRa.iQZ.iT(false);
                    }
                }, null);
                return true;
            }
        });
        this.hFk = (ListView) findViewById(2131758406);
        this.eKS = getLayoutInflater().inflate(2130904369, null);
        this.eKS.findViewById(2131759127).setOnClickListener(new View.OnClickListener(this) {
            final /* synthetic */ ShakeItemListUI iQZ;

            {
                this.iQZ = r1;
            }

            public final void onClick(View view) {
                this.iQZ.aXx = this.iQZ.aXx ^ -1;
                this.iQZ.ps(this.iQZ.aXx);
            }
        });
        this.hFk.addFooterView(this.eKS);
        if (this.aXx == -1) {
            this.eKS.findViewById(2131759127).setVisibility(0);
        } else {
            this.eKS.findViewById(2131759127).setVisibility(8);
        }
        this.iQY = new a(this, this);
        this.iQY.ps(this.aXx);
        if (this.iQY.getCount() <= 0) {
            this.hFk.setVisibility(8);
            TextView textView = (TextView) findViewById(2131758407);
            textView.setText(pt(this.aXx));
            textView.setVisibility(0);
            iT(false);
        } else {
            this.hFk.setAdapter(this.iQY);
            this.hFk.setOnItemClickListener(new OnItemClickListener(this) {
                final /* synthetic */ ShakeItemListUI iQZ;

                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    com.tencent.mm.plugin.shake.b.d dVar = (com.tencent.mm.plugin.shake.b.d) this.iQZ.iQY.getItem(i);
                    if (dVar != null) {
                        com.tencent.mm.plugin.shake.b.e aNO = k.aNO();
                        if (dVar == null) {
                            v.w("MicroMsg.NewShakeItemStorage", "setRead, but item is null");
                        } else {
                            dVar.field_insertBatch = 1;
                            dVar.bkU = 1024;
                            if (-1 != aNO.cie.update("shakeitem1", dVar.py(), "shakeItemID=? and insertBatch=?", new String[]{dVar.field_shakeItemID, "2"})) {
                                aNO.Ls();
                            }
                        }
                        int i2 = dVar.field_type;
                        Intent intent;
                        if (i2 == 4) {
                            intent = new Intent();
                            if (com.tencent.mm.ai.c.HI()) {
                                com.tencent.mm.ai.b.b(i.a(dVar.field_lvbuffer, 0));
                            } else {
                                com.tencent.mm.ai.b.HB();
                                intent.putExtra("key_mode", 1);
                                intent.putExtra("KGlobalShakeMusic", true);
                                com.tencent.mm.ai.b.c(i.a(dVar.field_lvbuffer, 0));
                            }
                            intent.putExtra("key_scene", 3);
                            com.tencent.mm.ay.c.b(this.iQZ, "music", ".ui.MusicMainUI", intent);
                        } else if (i2 == 11) {
                            if (System.currentTimeMillis() - this.iQZ.iQW > 2000) {
                                this.iQZ.iQW = System.currentTimeMillis();
                                intent = new Intent();
                                intent.putExtra("rawUrl", dVar.getCity());
                                intent.putExtra("scene", 27);
                                intent.putExtra("stastic_scene", 5);
                                com.tencent.mm.ay.c.b(aa.getContext(), "webview", ".ui.tools.WebViewUI", intent);
                                if (this.iQZ.iQX) {
                                    h.a(dVar);
                                    h.b(dVar);
                                }
                            }
                        } else if (com.tencent.mm.plugin.shake.d.a.k.pq(i2)) {
                            com.tencent.mm.plugin.shake.d.a.k.a(dVar, this.iQZ, true);
                        } else {
                            String str = dVar.field_username;
                            ak.yW();
                            u LX = c.wH().LX(str);
                            v.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + LX.field_username);
                            v.d("MicroMsg.ShakeItemListUI", "isContact:" + com.tencent.mm.i.a.ei(LX.field_type) + "  contact:" + LX);
                            if (com.tencent.mm.i.a.ei(LX.field_type)) {
                                Intent intent2 = new Intent();
                                intent2.putExtra("Contact_User", str);
                                intent2.putExtra("Contact_Scene", a == dVar.field_sex ? 23 : 24);
                                intent2.putExtra("Sns_from_Scene", 22);
                                if (str != null && str.length() > 0) {
                                    if (LX.bvm()) {
                                        com.tencent.mm.plugin.report.service.g.iuh.Y(10298, dVar.field_username + "," + intent2.getIntExtra("Contact_Scene", 23));
                                        intent2.putExtra("Contact_Scene", 23);
                                    }
                                    com.tencent.mm.plugin.shake.a.drp.d(intent2, this.iQZ);
                                    return;
                                }
                                return;
                            }
                            v.d("MicroMsg.ShakeItemListUI", "listView onTtemClick username:" + str + " display:" + dVar.field_nickname + " position:" + i + " contactName" + LX.field_username);
                            Intent intent3 = new Intent();
                            intent3.putExtra("Contact_User", dVar.field_username);
                            intent3.putExtra("Contact_Nick", dVar.field_nickname);
                            intent3.putExtra("Contact_Distance", dVar.field_distance);
                            intent3.putExtra("Contact_Signature", dVar.field_signature);
                            intent3.putExtra("Contact_Province", dVar.getProvince());
                            intent3.putExtra("Contact_City", dVar.getCity());
                            intent3.putExtra("Contact_Sex", dVar.field_sex);
                            intent3.putExtra("Contact_IsLBSFriend", true);
                            intent3.putExtra("Contact_VUser_Info", dVar.field_reserved3);
                            intent3.putExtra("Contact_VUser_Info_Flag", dVar.field_reserved1);
                            intent3.putExtra("Contact_Scene", a == dVar.field_sex ? 23 : 24);
                            intent3.putExtra("Sns_from_Scene", 22);
                            intent3.putExtra("Contact_KSnsIFlag", dVar.field_snsFlag);
                            intent3.putExtra("Contact_KSnsBgUrl", dVar.field_sns_bgurl);
                            if ((dVar.field_reserved1 & 8) > 0) {
                                com.tencent.mm.plugin.report.service.g.iuh.Y(10298, dVar.field_username + "," + intent3.getIntExtra("Contact_Scene", 23));
                            }
                            com.tencent.mm.plugin.shake.a.drp.d(intent3, this.iQZ);
                        }
                    }
                }
            });
            final l lVar = new l(this);
            this.hFk.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                final /* synthetic */ ShakeItemListUI iQZ;

                public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i < this.iQZ.hFk.getHeaderViewsCount()) {
                        v.w("MicroMsg.ShakeItemListUI", "on header view long click, ignore");
                    } else {
                        lVar.a(view, i, j, this.iQZ, this.iQZ.eus);
                    }
                    return true;
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ShakeItemListUI iQZ;

            {
                this.iQZ = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iQZ.axg();
                this.iQZ.finish();
                return true;
            }
        });
        AnonymousClass6 anonymousClass6 = new View.OnClickListener(this) {
            final /* synthetic */ ShakeItemListUI iQZ;

            {
                this.iQZ = r1;
            }

            public final void onClick(View view) {
                BackwardSupportUtil.c.a(this.iQZ.hFk);
            }
        };
        this.hFk.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ ShakeItemListUI iQZ;

            {
                this.iQZ = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.iQZ.iQY != null) {
                    a b = this.iQZ.iQY;
                    if (b.cHD != null) {
                        b.cHD.onTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        });
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        this.id = ((com.tencent.mm.plugin.shake.b.d) this.iQY.getItem(adapterContextMenuInfo.position)).field_shakeItemID;
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, 2131231020);
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        this.iQY.avc();
        a aVar = this.iQY;
        if (aVar.cHD != null) {
            aVar.cHD.detach();
            aVar.cHD = null;
        }
        k.aNO().d(this.iQY);
        v.i("MicroMsg.ShakeItemListUI", "onPause");
        if (this.cOz != null) {
            this.cOz.detach();
        }
        super.onDestroy();
    }

    protected final void ps(int i) {
        this.iQY.ps(i);
        switch (i) {
            case -12:
            case -1:
                if (this.eKS != null) {
                    this.eKS.findViewById(2131759127).setVisibility(0);
                    return;
                }
                return;
            case 0:
            case 11:
                if (this.eKS != null) {
                    this.eKS.findViewById(2131759127).setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    protected final int getLayoutId() {
        return 2130904367;
    }

    public static int pt(int i) {
        switch (i) {
            case -12:
            case 11:
                return 2131235239;
            case -6:
            case 5:
                return 2131235285;
            case -5:
            case 4:
                return 2131235261;
            case 100:
                return 2131235236;
            default:
                return 2131235232;
        }
    }
}
