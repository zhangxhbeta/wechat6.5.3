package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ar.b;
import com.tencent.mm.ar.c;
import com.tencent.mm.ar.f;
import com.tencent.mm.ar.l;
import com.tencent.mm.e.a.es;
import com.tencent.mm.model.ak;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.h.g;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ah.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.u.d;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.s;
import com.tencent.mmdb.FileUtils;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

public final class k extends RelativeLayout {
    public static Boolean oGv = Boolean.valueOf(true);
    private Context context = null;
    private View fDt = null;
    private boolean isVisible = true;
    private View oGw = null;
    private final ah oGx = new ah(new a(this) {
        final /* synthetic */ k oGA;

        {
            this.oGA = r1;
        }

        public final boolean oU() {
            v.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
            k.bHC();
            this.oGA.init();
            return false;
        }
    }, true);
    g.a oGy = new g.a(this) {
        final /* synthetic */ k oGA;

        {
            this.oGA = r1;
        }

        public final void a(String str, i iVar) {
            v.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
            if (!this.oGA.oGx.btC()) {
                this.oGA.oGx.QI();
            }
            this.oGA.oGx.ea(this.oGA.oGz ? 500 : 1000);
        }
    };
    boolean oGz = false;

    public k(Context context) {
        super(context);
        this.context = context;
        l.KD().c(this.oGy);
        bHC();
        init();
    }

    private void init() {
        c KD = l.KD();
        v.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", Integer.valueOf(4));
        List arrayList = new ArrayList();
        Cursor rawQuery = KD.cie.rawQuery(new StringBuilder("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4").toString(), null);
        v.d("MicroMsg.FMessageConversationStorage", "getNewLimit, count = %d", Integer.valueOf(rawQuery.getCount()));
        if (rawQuery.getCount() <= 0) {
            v.d("MicroMsg.FMessageConversationStorage", "getNewLimit, cursor count is zero");
        } else if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                b bVar = new b();
                bVar.b(rawQuery);
                rawQuery.moveToNext();
                if (!be.kS(bVar.field_talker)) {
                    arrayList.add(bVar);
                }
            }
        }
        rawQuery.close();
        int size = arrayList.size();
        v.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", Integer.valueOf(size));
        removeAllViews();
        if (size <= 0) {
            if (this.context == null) {
                v.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
            } else {
                this.fDt = View.inflate(this.context, 2130903648, this);
                this.oGw = this.fDt.findViewById(2131757052);
                this.fDt.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ k oGA;

                    {
                        this.oGA = r1;
                    }

                    public final void onClick(View view) {
                        v.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
                        com.tencent.mm.ay.c.b(this.oGA.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                    }
                });
                MaskLayout maskLayout = (MaskLayout) this.fDt.findViewById(2131757053);
                n.AX();
                ((ImageView) maskLayout.view).setImageBitmap(d.gK("fmessage"));
            }
        } else if (size == 1) {
            b bVar2 = (b) arrayList.get(0);
            if (this.context == null) {
                v.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
            } else {
                CharSequence string;
                if (com.tencent.mm.bd.a.dt(this.context)) {
                    this.fDt = View.inflate(this.context, 2130903651, this);
                } else {
                    this.fDt = View.inflate(this.context, 2130903650, this);
                }
                ((TextView) this.fDt.findViewById(2131757058)).setText(e.a(this.context, bVar2.field_displayName));
                TextView textView = (TextView) this.fDt.findViewById(2131757059);
                f kG = l.KC().kG(bVar2.field_talker);
                Context context = this.context;
                int i = kG.field_type;
                int i2 = bVar2.field_addScene;
                String str = kG.field_msgContent;
                v.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(!kG.Ku()));
                if (i == 0) {
                    if (str != null) {
                        at.a My = at.a.My(str);
                        switch (My.scene) {
                            case 4:
                                string = context.getString(2131231782);
                                break;
                            case 10:
                            case 11:
                                com.tencent.mm.sdk.c.b esVar = new es();
                                esVar.bdu.bdr = My.nvG;
                                esVar.bdu.bds = My.nvH;
                                com.tencent.mm.sdk.c.a.nhr.z(esVar);
                                string = context.getString(2131231785, new Object[]{be.ah(esVar.bdv.bdw, SQLiteDatabase.KeyEmpty)});
                                break;
                            case 31:
                                string = context.getString(2131231794);
                                break;
                            case FileUtils.S_IRGRP /*32*/:
                                string = context.getString(2131231788);
                                break;
                            case 58:
                            case 59:
                            case 60:
                                string = context.getString(2131231783);
                                break;
                            default:
                                string = context.getString(2131231787);
                                break;
                        }
                    }
                    v.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
                    string = null;
                } else if (r2) {
                    Object obj = str;
                } else {
                    at.d MB = at.d.MB(str);
                    string = (MB.content == null || MB.content.trim().equals(SQLiteDatabase.KeyEmpty)) ? context.getString(2131232845) : MB.content;
                }
                if (t.kS(string)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(string);
                }
                this.oGw = this.fDt.findViewById(2131757051);
                this.fDt.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ k oGA;

                    {
                        this.oGA = r1;
                    }

                    public final void onClick(View view) {
                        v.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
                        ak.yW();
                        com.tencent.mm.model.c.vf().set(143618, Integer.valueOf(0));
                        com.tencent.mm.ay.c.b(this.oGA.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                    }
                });
                com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) ((MaskLayout) this.fDt.findViewById(2131757053)).view, bVar2.field_talker);
            }
        } else if (this.context == null) {
            v.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
        } else {
            this.fDt = View.inflate(this.context, 2130903649, this);
            int size2 = arrayList.size();
            v.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", Integer.valueOf(size2));
            MaskLayout maskLayout2 = (MaskLayout) this.fDt.findViewById(2131757053);
            com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) maskLayout2.view, ((b) arrayList.get(0)).field_talker);
            maskLayout2.setVisibility(0);
            maskLayout2 = (MaskLayout) this.fDt.findViewById(2131757055);
            com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) maskLayout2.view, ((b) arrayList.get(1)).field_talker);
            maskLayout2.setVisibility(0);
            if (size2 > 2) {
                maskLayout2 = (MaskLayout) this.fDt.findViewById(2131757056);
                com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) maskLayout2.view, ((b) arrayList.get(2)).field_talker);
                maskLayout2.setVisibility(0);
            }
            if (size2 > 3) {
                maskLayout2 = (MaskLayout) this.fDt.findViewById(2131757057);
                com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) maskLayout2.view, ((b) arrayList.get(3)).field_talker);
                maskLayout2.setVisibility(0);
            }
            this.oGw = this.fDt.findViewById(2131757051);
            this.oGw.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ k oGA;

                {
                    this.oGA = r1;
                }

                public final void onClick(View view) {
                    v.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
                    ak.yW();
                    com.tencent.mm.model.c.vf().set(143618, Integer.valueOf(0));
                    com.tencent.mm.ay.c.b(this.oGA.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                }
            });
        }
        View findViewById = this.fDt.findViewById(2131757051);
        if (findViewById != null) {
            findViewById.setVisibility(this.isVisible ? 0 : 8);
        }
        this.oGw.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ k oGA;

            {
                this.oGA = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.oGA.context instanceof MMActivity) {
                    ((MMActivity) this.oGA.context).axg();
                }
                return false;
            }
        });
        int Kr = l.KD().Kr();
        v.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", Integer.valueOf(Kr));
        TextView textView2 = (TextView) this.fDt.findViewById(2131757054);
        textView2.setBackgroundResource(s.eN(this.context));
        if (Kr <= 0) {
            textView2.setVisibility(8);
            oGv = Boolean.valueOf(false);
            return;
        }
        textView2.setVisibility(0);
        oGv = Boolean.valueOf(true);
        if (Kr > 99) {
            textView2.setText(getContext().getString(2131235710));
        } else {
            textView2.setText(String.valueOf(Kr));
        }
    }

    public final void setVisible(boolean z) {
        v.d("MicroMsg.FMessageContactView", "setVisible visible = " + z);
        View findViewById = this.fDt.findViewById(2131757051);
        if (findViewById != null) {
            findViewById.setVisibility(z ? 0 : 8);
        }
        this.isVisible = z;
    }

    private static void bHC() {
        int Kr = l.KD().Kr();
        v.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", Integer.valueOf(Kr));
        if (Kr > 0) {
            ak.yW();
            com.tencent.mm.model.c.vf().set(143618, Integer.valueOf(Kr));
        }
    }

    public static void bHD() {
        ak.yW();
        if (com.tencent.mm.model.c.wC()) {
            ak.yW();
            if (com.tencent.mm.model.c.vf().getInt(143618, 0) > 0) {
                ae.z("fmessage", 2);
            }
        }
        ak.yW();
        com.tencent.mm.model.c.vf().set(143618, Integer.valueOf(0));
    }
}
