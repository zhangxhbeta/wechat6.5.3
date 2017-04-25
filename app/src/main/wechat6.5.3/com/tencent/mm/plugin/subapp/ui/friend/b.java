package com.tencent.mm.plugin.subapp.ui.friend;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.gmtrace.Constants;
import com.tencent.mm.ar.f;
import com.tencent.mm.ar.l;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.pluginsdk.ui.applet.a.2;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.d;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.j;
import java.util.LinkedList;
import junit.framework.Assert;

public final class b extends j<com.tencent.mm.ar.b> {
    private Context context;
    private OnClickListener kga = new OnClickListener(this) {
        final /* synthetic */ b kgc;

        {
            this.kgc = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b) {
                v.d("MicroMsg.FMessageConversationUI", "addOnClick onClick");
                final com.tencent.mm.pluginsdk.ui.preference.b bVar = (com.tencent.mm.pluginsdk.ui.preference.b) view.getTag();
                if (bVar == null || be.kS(bVar.username)) {
                    v.e("MicroMsg.FMessageConversationUI", "cpan add contact failed. username is null.");
                    return;
                }
                final f kH = l.KC().kH(bVar.username);
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.kgc.context, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                    final /* synthetic */ AnonymousClass2 kgf;

                    public final void a(boolean z, boolean z2, String str, String str2) {
                        if (z) {
                            ak.yW();
                            u LX = c.wH().LX(bVar.username);
                            if (((int) LX.chr) == 0) {
                                LX = b.a(this.kgf.kgc, kH);
                                ak.yW();
                                if (!c.wH().N(LX)) {
                                    v.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                                    return;
                                }
                            }
                            m.n(LX);
                            l.KD().A(bVar.username, 1);
                            g.bf(this.kgf.kgc.context, this.kgf.kgc.context.getString(2131230902));
                            b.a(this.kgf.kgc, bVar.username);
                        } else if (z2) {
                            l.KD().A(bVar.username, 2);
                        } else {
                            v.e("MicroMsg.FMessageConversationUI", "canAddContact fail, username = " + bVar.username);
                            return;
                        }
                        this.kgf.kgc.notifyDataSetChanged();
                    }
                });
                v.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar.username + ", opcode = MM_VERIFYUSER_ADDCONTACT");
                LinkedList linkedList = new LinkedList();
                linkedList.add(Integer.valueOf(bVar.iRy));
                aVar.b(bVar.username, linkedList, true);
            }
        }
    };
    private OnClickListener kgb = new OnClickListener(this) {
        final /* synthetic */ b kgc;

        {
            this.kgc = r1;
        }

        public final void onClick(View view) {
            if (view.getTag() instanceof com.tencent.mm.pluginsdk.ui.preference.b) {
                v.d("MicroMsg.FMessageConversationUI", "verifyOkOnClick onClick");
                final com.tencent.mm.pluginsdk.ui.preference.b bVar = (com.tencent.mm.pluginsdk.ui.preference.b) view.getTag();
                final f kH = l.KC().kH(bVar.username);
                if (kH == null || kH.field_msgContent == null) {
                    v.e("MicroMsg.FMessageConversationUI", "lastRecvFmsg is null, verify fail, talker = " + bVar.username);
                    return;
                }
                d MB = d.MB(kH.field_msgContent);
                v.d("MicroMsg.FMessageConversationUI", "try to addcontact, username = " + bVar.username + ", opcode = MM_VERIFYUSER_VERIFYOK");
                if (MB.nvS == 1) {
                    g.a(this.kgc.context, MB.nvT, null, this.kgc.context.getString(2131232846), this.kgc.context.getString(2131231010), true, new DialogInterface.OnClickListener(this) {
                        final /* synthetic */ AnonymousClass3 kgg;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.a(this.kgg.kgc.context, kH, false);
                        }
                    }, null);
                    return;
                }
                com.tencent.mm.pluginsdk.ui.applet.a aVar = new com.tencent.mm.pluginsdk.ui.applet.a(this.kgc.context, new com.tencent.mm.pluginsdk.ui.applet.a.a(this) {
                    final /* synthetic */ AnonymousClass3 kgg;

                    public final void a(boolean z, boolean z2, String str, String str2) {
                        if (z) {
                            ak.yW();
                            u LX = c.wH().LX(bVar.username);
                            if (((int) LX.chr) == 0) {
                                LX = b.a(this.kgg.kgc, kH);
                                ak.yW();
                                if (!c.wH().N(LX)) {
                                    v.e("MicroMsg.FMessageConversationUI", "canAddContact fail, insert fail");
                                    return;
                                }
                            }
                            m.n(LX);
                            l.KD().A(bVar.username, 1);
                            g.bf(this.kgg.kgc.context, this.kgg.kgc.context.getString(2131230902));
                            b.Cw(LX.field_username);
                            ak.oH().qs();
                            b.a(this.kgg.kgc, bVar.username);
                        } else if (!z2) {
                            Toast.makeText(this.kgg.kgc.context, 2131232854, 1).show();
                        }
                        this.kgg.kgc.notifyDataSetChanged();
                    }
                });
                String str = bVar.username;
                String str2 = MB.hUb;
                int i = MB.scene;
                String str3 = "username is null";
                boolean z = str != null && str.length() > 0;
                Assert.assertTrue(str3, z);
                aVar.onStart();
                if (aVar.lJl) {
                    Context context = aVar.context;
                    aVar.context.getString(2131231164);
                    aVar.dwg = g.a(context, aVar.context.getString(2131231996), true, new 2(aVar));
                }
                ak.vy().a(new com.tencent.mm.pluginsdk.model.m(str, str2, i), 0);
            }
        }
    };

    static class a {
        public TextView hWx;
        public MaskLayout kgh;
        public Button kgi;
        public Button kgj;
        public TextView kgk;
        public TextView kgl;
        public TextView kgm;

        a() {
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (com.tencent.mm.ar.b) obj;
        if (obj == null) {
            obj = new com.tencent.mm.ar.b();
        }
        obj.b(cursor);
        return obj;
    }

    static /* synthetic */ u a(b bVar, f fVar) {
        u uVar = new u();
        if (fVar == null) {
            return uVar;
        }
        if (fVar.field_type == 0) {
            com.tencent.mm.storage.at.a My = com.tencent.mm.storage.at.a.My(fVar.field_msgContent);
            uVar = new u();
            uVar.setUsername(My.lct);
            uVar.bP(My.bLc);
            uVar.bS(My.getDisplayName());
            uVar.bT(My.cIE);
            uVar.bU(My.cIF);
            uVar.cV(My.bBZ);
            uVar.cg(My.getProvince());
            uVar.ch(My.getCity());
            uVar.cf(My.bCj);
            uVar.cR(My.ldy);
            uVar.ck(My.bCp);
            return uVar;
        }
        d MB = d.MB(fVar.field_msgContent);
        uVar = new u();
        uVar.setUsername(MB.lct);
        uVar.bP(MB.bLc);
        uVar.bS(MB.cID);
        uVar.bT(MB.cIE);
        uVar.bU(MB.cIF);
        uVar.cV(MB.bBZ);
        uVar.cf(MB.bCj);
        uVar.cg(MB.getProvince());
        uVar.ch(MB.getCity());
        return uVar;
    }

    static /* synthetic */ void a(b bVar, final String str) {
        if (bVar.context instanceof FMessageConversationUI) {
            ad.g(new Runnable(bVar) {
                final /* synthetic */ b kgc;

                public final void run() {
                    a.e(this.kgc.context, str, false);
                }
            }, 1000);
        }
    }

    public b(Context context) {
        super(context, new com.tencent.mm.ar.b());
        this.context = context;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.context, 2130903652, null);
            a aVar2 = new a();
            aVar2.kgh = (MaskLayout) view.findViewById(2131757061);
            aVar2.hWx = (TextView) view.findViewById(2131757067);
            aVar2.kgm = (TextView) view.findViewById(2131757068);
            aVar2.kgi = (Button) view.findViewById(2131757063);
            aVar2.kgi.setOnClickListener(this.kga);
            aVar2.kgj = (Button) view.findViewById(2131757064);
            aVar2.kgj.setOnClickListener(this.kgb);
            aVar2.kgk = (TextView) view.findViewById(2131757065);
            aVar2.kgl = (TextView) view.findViewById(2131757066);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.ar.b bVar = (com.tencent.mm.ar.b) getItem(i);
        com.tencent.mm.pluginsdk.ui.a.b.m((ImageView) aVar.kgh.view, bVar.field_talker);
        aVar.hWx.setText(e.a(this.context, bVar.field_displayName, aVar.hWx.getTextSize()));
        com.tencent.mm.pluginsdk.ui.preference.b a;
        u LX;
        f kH;
        int i2;
        View findViewById;
        int i3;
        if (bVar.field_fmsgSysRowId <= 0) {
            v.w("MicroMsg.FMessageConversationUI", "getView, fconv fmsgSysRowId is invalid, try getLastFmsg");
            f kG = l.KC().kG(bVar.field_talker);
            if (kG == null) {
                v.e("MicroMsg.FMessageConversationUI", "getView, lastFmsg is null, talker = " + bVar.field_talker);
                aVar.kgi.setVisibility(8);
                aVar.kgj.setVisibility(8);
                aVar.kgk.setVisibility(8);
                aVar.kgl.setVisibility(8);
                aVar.kgm.setVisibility(8);
            } else {
                a = com.tencent.mm.pluginsdk.ui.preference.b.a(this.context, kG);
                v.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg talker = " + bVar.field_talker);
                if (bVar.field_state == 1) {
                    ak.yW();
                    LX = c.wH().LX(bVar.field_talker);
                    if (!(LX == null || ((int) LX.chr) == 0 || com.tencent.mm.i.a.ei(LX.field_type))) {
                        l.KD().A(bVar.field_talker, 0);
                    }
                }
                if (a != null) {
                    v.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + bVar.field_talker);
                    aVar.kgi.setVisibility(8);
                    aVar.kgj.setVisibility(8);
                    aVar.kgk.setVisibility(8);
                    aVar.kgl.setVisibility(8);
                    aVar.kgm.setVisibility(8);
                } else {
                    a.iRy = bVar.field_addScene;
                    aVar.kgm.setText(e.a(this.context, a.cqK, aVar.kgm.getTextSize()));
                    switch (bVar.field_state) {
                        case 0:
                            if (bVar.field_fmsgSysRowId > 0) {
                                v.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
                                kH = l.KC().kH(a.username);
                                i2 = kH != null ? 0 : kH.field_type;
                            } else {
                                i2 = bVar.field_recvFmsgType;
                            }
                            if (i2 != 0 || i2 == 3) {
                                aVar.kgi.setVisibility(0);
                                aVar.kgi.setTag(a);
                                aVar.kgj.setVisibility(8);
                            } else {
                                aVar.kgj.setVisibility(0);
                                aVar.kgj.setTag(a);
                                aVar.kgi.setVisibility(8);
                            }
                            aVar.kgk.setVisibility(8);
                            aVar.kgl.setVisibility(8);
                            break;
                        case 1:
                            aVar.kgl.setVisibility(0);
                            aVar.kgi.setVisibility(8);
                            aVar.kgj.setVisibility(8);
                            aVar.kgk.setVisibility(8);
                            break;
                        case 2:
                            aVar.kgk.setVisibility(0);
                            aVar.kgi.setVisibility(8);
                            aVar.kgj.setVisibility(8);
                            aVar.kgl.setVisibility(8);
                            break;
                        default:
                            aVar.kgi.setVisibility(8);
                            aVar.kgj.setVisibility(8);
                            aVar.kgk.setVisibility(8);
                            aVar.kgl.setVisibility(8);
                            break;
                    }
                    findViewById = view.findViewById(2131757060);
                    if (bVar.field_isNew != 0) {
                        i3 = 2130838666;
                    } else {
                        i3 = 2130838045;
                    }
                    findViewById.setBackgroundResource(i3);
                }
            }
        } else {
            a = com.tencent.mm.pluginsdk.ui.preference.b.a(this.context, bVar.field_fmsgSysRowId, bVar.field_fmsgIsSend % 2 == 0, bVar.field_talker, bVar.field_fmsgContent, bVar.field_fmsgType, bVar.field_contentFromUsername, bVar.field_contentNickname, bVar.field_contentPhoneNumMD5, bVar.field_contentFullPhoneNumMD5, bVar.field_contentVerifyContent, bVar.field_addScene);
            v.i("MicroMsg.FMessageConversationUI", "getView, lastFmsg sysrowid = " + bVar.field_fmsgSysRowId + ", talker = " + bVar.field_talker);
            if (bVar.field_state == 1) {
                ak.yW();
                LX = c.wH().LX(bVar.field_talker);
                l.KD().A(bVar.field_talker, 0);
            }
            if (a != null) {
                a.iRy = bVar.field_addScene;
                aVar.kgm.setText(e.a(this.context, a.cqK, aVar.kgm.getTextSize()));
                switch (bVar.field_state) {
                    case 0:
                        if (bVar.field_fmsgSysRowId > 0) {
                            i2 = bVar.field_recvFmsgType;
                        } else {
                            v.w("MicroMsg.FMessageConversationUI", "getView, fmsgSysRowId invalid, try use lastRecvFmsg");
                            kH = l.KC().kH(a.username);
                            if (kH != null) {
                            }
                        }
                        if (i2 != 0) {
                            break;
                        }
                        aVar.kgi.setVisibility(0);
                        aVar.kgi.setTag(a);
                        aVar.kgj.setVisibility(8);
                        aVar.kgk.setVisibility(8);
                        aVar.kgl.setVisibility(8);
                        break;
                    case 1:
                        aVar.kgl.setVisibility(0);
                        aVar.kgi.setVisibility(8);
                        aVar.kgj.setVisibility(8);
                        aVar.kgk.setVisibility(8);
                        break;
                    case 2:
                        aVar.kgk.setVisibility(0);
                        aVar.kgi.setVisibility(8);
                        aVar.kgj.setVisibility(8);
                        aVar.kgl.setVisibility(8);
                        break;
                    default:
                        aVar.kgi.setVisibility(8);
                        aVar.kgj.setVisibility(8);
                        aVar.kgk.setVisibility(8);
                        aVar.kgl.setVisibility(8);
                        break;
                }
                findViewById = view.findViewById(2131757060);
                if (bVar.field_isNew != 0) {
                    i3 = 2130838045;
                } else {
                    i3 = 2130838666;
                }
                findViewById.setBackgroundResource(i3);
            } else {
                v.e("MicroMsg.FMessageConversationUI", "getView, fProvider is null, talker = " + bVar.field_talker);
                aVar.kgi.setVisibility(8);
                aVar.kgj.setVisibility(8);
                aVar.kgk.setVisibility(8);
                aVar.kgl.setVisibility(8);
                aVar.kgm.setVisibility(8);
            }
        }
        return view;
    }

    public final void Ol() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            setCursor(l.KD().Kp());
            notifyDataSetChanged();
            return;
        }
        ad.o(new Runnable(this) {
            final /* synthetic */ b kgc;

            {
                this.kgc = r1;
            }

            public final void run() {
                this.kgc.setCursor(l.KD().Kp());
                this.kgc.notifyDataSetChanged();
            }
        });
    }

    protected final void Om() {
        avc();
        Ol();
    }

    public static void Cw(String str) {
        f[] kF = l.KC().kF(str);
        com.tencent.mm.pluginsdk.ui.preference.b[] a = com.tencent.mm.pluginsdk.ui.preference.b.a(aa.getContext(), kF);
        if (a != null) {
            int i = 0;
            int length = a.length;
            int i2 = 0;
            while (i2 < length) {
                int i3;
                com.tencent.mm.pluginsdk.ui.preference.b bVar = a[i2];
                at atVar = new at();
                atVar.setContent(bVar.cqK);
                int fp = m.fp(bVar.username);
                if (kF != null) {
                    i3 = i + 1;
                    long j = kF[i].field_createTime;
                    atVar.z(j);
                    v.d("MicroMsg.FMessageConversationUI", "[" + atVar.field_content + "]" + j);
                } else {
                    i3 = i;
                }
                atVar.cH(bVar.username);
                atVar.setType(fp);
                if (bVar.cFQ) {
                    atVar.dh(2);
                    atVar.di(1);
                } else {
                    atVar.di(0);
                    atVar.dh(6);
                }
                ak.yW();
                long R = c.wJ().R(atVar);
                Assert.assertTrue(R != -1);
                v.i("MicroMsg.FMessageConversationUI", "new msg inserted to db , local id = " + R);
                i2++;
                i = i3;
            }
            at atVar2 = new at();
            if (kF != null) {
                atVar2.z(kF[kF.length - 1].field_createTime + 1);
            }
            atVar2.cH(str);
            atVar2.setContent(aa.getContext().getString(2131235699));
            atVar2.setType(Constants.THREAD_BITSET_SIZE);
            atVar2.di(0);
            atVar2.dh(6);
            ak.yW();
            c.wJ().R(atVar2);
        }
    }
}
