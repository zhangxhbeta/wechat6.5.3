package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.e.b.af;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.f;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.modelbiz.u;
import com.tencent.mm.protocal.c.ail;
import com.tencent.mm.protocal.c.arf;
import com.tencent.mm.protocal.c.ays;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.ml;
import com.tencent.mm.sdk.h.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.bizchat.BizChatConversationUI;
import com.tencent.mm.ui.conversation.BaseConversationUI.b;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.transmit.SelectConversationUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

public class EnterpriseConversationUI extends BaseConversationUI {
    private View dtW;

    public static class a extends b implements j.b, e {
        private long bYN = 0;
        private String cBj;
        long dbx = 0;
        private p dwg;
        private TextView euo;
        private boolean eut = false;
        private String eyY = SQLiteDatabase.KeyEmpty;
        private l eyZ;
        private int fromScene;
        private d hkn;
        private String oKb;
        private m oLF;
        private View oLG = null;
        private EnterpriseFullHeightListView oLH;
        private c oLI;
        private String oLJ = null;
        private ac oLK;
        private int oLL = -2;
        private long oLM = 0;
        private String oLN = null;
        private boolean ohC = true;
        private int ohD = 0;
        private boolean ohE = false;
        private com.tencent.mm.modelbiz.c.a ohH = new com.tencent.mm.modelbiz.c.a(this) {
            final /* synthetic */ a oLO;

            {
                this.oLO = r1;
            }

            public final void a(com.tencent.mm.modelbiz.c.a.a aVar) {
                if (aVar != null && !be.kS(aVar.cBj) && aVar.cBj.equals(this.oLO.cBj)) {
                    boolean q = this.oLO.ohE;
                    this.oLO.ohE = u.DF().hf(this.oLO.cBj);
                    if (this.oLO.ohE != q) {
                        this.oLO.bDu();
                    }
                }
            }
        };
        private ImageButton ohx = null;
        private int ohz;

        static /* synthetic */ void Pm(String str) {
            ak.yW();
            if (c.wH().LX(str) == null) {
                v.e("MicroMsg.EnterpriseConversationUI", "changed biz stick status failed, contact is null, talker = " + str);
                return;
            }
            ak.yW();
            if (c.wK().Mn(str)) {
                com.tencent.mm.model.m.m(str, true);
            } else {
                f.ec(str);
            }
        }

        static /* synthetic */ void a(a aVar, int i) {
            if (i <= 0) {
                aVar.euo.setVisibility(0);
                aVar.oLH.setVisibility(8);
                return;
            }
            aVar.euo.setVisibility(8);
            aVar.oLH.setVisibility(0);
        }

        static /* synthetic */ void a(a aVar, String str) {
            if (be.kS(str)) {
                v.e("MicroMsg.EnterpriseConversationUI", "Delete Conversation and messages fail because username is null or nil.");
                return;
            }
            ak.yW();
            bx MH = c.wJ().MH(str);
            com.tencent.mm.ba.a mlVar = new ml();
            mlVar.moM = new arf().JF(be.ma(str));
            mlVar.mcb = MH.field_msgSvrId;
            ak.yW();
            c.wG().b(new com.tencent.mm.ak.j.a(8, mlVar));
            aVar.eut = false;
            Context bzo = aVar.bzo();
            aVar.getString(2131231164);
            final ProgressDialog a = g.a(bzo, aVar.getString(2131231182), true, new OnCancelListener(aVar) {
                final /* synthetic */ a oLO;

                {
                    this.oLO = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    this.oLO.eut = true;
                }
            });
            aw.a(str, new com.tencent.mm.model.aw.a(aVar) {
                final /* synthetic */ a oLO;

                public final boolean zp() {
                    return this.oLO.eut;
                }

                public final void zo() {
                    if (a != null) {
                        a.dismiss();
                    }
                }
            });
            ak.yW();
            c.wK().Mf(str);
            ak.yW().cra.Lx(u.Dy().ho(str).field_enterpriseFather);
        }

        static /* synthetic */ void b(a aVar, final String str) {
            final Context context = aVar.nDR.nEl;
            g.b(context, context.getString(2131232460), SQLiteDatabase.KeyEmpty, context.getString(2131232459), context.getString(2131231010), new OnClickListener(aVar) {
                final /* synthetic */ a oLO;

                public final void onClick(DialogInterface dialogInterface, int i) {
                    final k cVar = new com.tencent.mm.plugin.profile.a.c(str, true);
                    ak.vy().a(1394, this.oLO);
                    ak.vy().a(cVar, 0);
                    a aVar = this.oLO;
                    Context context = context;
                    context.getString(2131231164);
                    aVar.dwg = g.a(context, context.getString(2131231182), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass5 oLP;

                        public final void onCancel(DialogInterface dialogInterface) {
                            ak.vy().c(cVar);
                            ak.vy().b(1394, this.oLP.oLO);
                        }
                    });
                }
            }, null);
        }

        static /* synthetic */ void e(a aVar) {
            if (be.kS(aVar.bIn())) {
                com.tencent.mm.ui.f.g(aVar.nDR.nEl, aVar.cBj, false);
                return;
            }
            Intent intent = new Intent(aVar.bzo(), BizChatConversationUI.class);
            intent.putExtra("Contact_User", aVar.bIn());
            intent.addFlags(67108864);
            intent.putExtra("biz_chat_from_scene", 6);
            aVar.startActivity(intent);
        }

        public final void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            this.cBj = bzo().getIntent().getStringExtra("enterprise_biz_name");
            this.oKb = bzo().getIntent().getStringExtra("enterprise_biz_display_name");
            this.fromScene = bzo().getIntent().getIntExtra("enterprise_from_scene", 5);
            Fd(this.oKb);
            this.oLH = (EnterpriseFullHeightListView) findViewById(2131756759);
            this.euo = (TextView) findViewById(2131756760);
            this.euo.setText(2131232465);
            b(new OnMenuItemClickListener(this) {
                final /* synthetic */ a oLO;

                {
                    this.oLO = r1;
                }

                public final boolean onMenuItemClick(MenuItem menuItem) {
                    this.oLO.finish();
                    return true;
                }
            });
            AnonymousClass10 anonymousClass10 = new View.OnClickListener(this) {
                final /* synthetic */ a oLO;

                {
                    this.oLO = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.platformtools.a.b.a(this.oLO.oLH);
                }
            };
            if (com.tencent.mm.modelbiz.e.hw(this.cBj) != null) {
                bIm();
                a(1, 2131235684, 2131165206, new OnMenuItemClickListener(this) {
                    final /* synthetic */ a oLO;

                    {
                        this.oLO = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        Intent intent = new Intent();
                        intent.putExtra("enterprise_biz_name", this.oLO.cBj);
                        intent.addFlags(67108864);
                        com.tencent.mm.ay.c.b(this.oLO.nDR.nEl, "brandservice", ".ui.EnterpriseBizSearchUI", intent);
                        return true;
                    }
                });
                a(2, 2131230800, 2131165188, new OnMenuItemClickListener(this) {
                    final /* synthetic */ a oLO;

                    {
                        this.oLO = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        if (this.oLO.oLF != null) {
                            this.oLO.oLF.dismiss();
                            this.oLO.oLF = null;
                        }
                        this.oLO.oLF = new m(this.oLO.nDR.nEl);
                        this.oLO.oLF.jXn = new n.c(this) {
                            final /* synthetic */ AnonymousClass12 oLQ;

                            {
                                this.oLQ = r1;
                            }

                            public final void a(com.tencent.mm.ui.base.l lVar) {
                                lVar.S(1, 2131232472, 2131165195);
                                lVar.S(2, 2131232155, 2131165801);
                                lVar.S(3, 2131232463, 2131165196);
                                lVar.S(4, 2131230801, 2131165208);
                            }
                        };
                        this.oLO.oLF.jXo = new d(this) {
                            final /* synthetic */ AnonymousClass12 oLQ;

                            {
                                this.oLQ = r1;
                            }

                            public final void c(MenuItem menuItem, int i) {
                                int i2 = 2;
                                Intent intent;
                                switch (menuItem.getItemId()) {
                                    case 1:
                                        intent = new Intent();
                                        intent.putExtra("from_userName", this.oLQ.oLO.cBj);
                                        com.tencent.mm.ay.c.b(this.oLQ.oLO.nDR.nEl, "setting", ".ui.setting.SelfQRCodeUI", intent);
                                        break;
                                    case 2:
                                        Intent intent2 = new Intent(this.oLQ.oLO.bzo(), SelectConversationUI.class);
                                        intent2.putExtra("Select_Talker_Name", this.oLQ.oLO.cBj);
                                        intent2.putExtra("Select_block_List", this.oLQ.oLO.cBj);
                                        intent2.putExtra("Select_Send_Card", true);
                                        intent2.putExtra("Select_Conv_Type", 3);
                                        this.oLQ.oLO.startActivityForResult(intent2, 1);
                                        i2 = 3;
                                        break;
                                    case 3:
                                        Intent intent3 = new Intent();
                                        intent3.putExtra("enterprise_biz_name", this.oLQ.oLO.cBj);
                                        intent3.putExtra("enterprise_scene", 2);
                                        com.tencent.mm.ay.c.b(this.oLQ.oLO.bzo(), "brandservice", ".ui.EnterpriseBizContactPlainListUI", intent3);
                                        i2 = 4;
                                        break;
                                    case 4:
                                        i2 = 5;
                                        intent = new Intent();
                                        intent.putExtra("Contact_User", this.oLQ.oLO.cBj);
                                        com.tencent.mm.ay.c.b(this.oLQ.oLO.bzo(), "profile", ".ui.ContactInfoUI", intent);
                                        break;
                                    default:
                                        i2 = 0;
                                        break;
                                }
                                com.tencent.mm.ui.f.bZ(this.oLQ.oLO.cBj, i2);
                            }
                        };
                        this.oLO.oLF.dQ();
                        com.tencent.mm.ui.f.bZ(this.oLO.cBj, 1);
                        return false;
                    }
                });
                this.oLI = new c(bzo(), this.cBj, new com.tencent.mm.ui.j.a(this) {
                    final /* synthetic */ a oLO;

                    {
                        this.oLO = r1;
                    }

                    public final void Oi() {
                        a.a(this.oLO, this.oLO.oLI.getCount());
                        if (this.oLO.oLH != null) {
                            this.oLO.oLH.bIo();
                        }
                    }

                    public final void Oj() {
                    }
                });
                this.oLI.a(new MMSlideDelView.c(this) {
                    final /* synthetic */ a oLO;

                    {
                        this.oLO = r1;
                    }

                    public final int bN(View view) {
                        return this.oLO.oLH.getPositionForView(view);
                    }
                });
                this.oLI.a(new MMSlideDelView.f(this) {
                    final /* synthetic */ a oLO;

                    {
                        this.oLO = r1;
                    }

                    public final void p(View view, int i) {
                        this.oLO.oLH.performItemClick(view, i, 0);
                    }
                });
                this.oLI.a(new MMSlideDelView.e(this) {
                    final /* synthetic */ a oLO;

                    {
                        this.oLO = r1;
                    }

                    public final void aE(Object obj) {
                        if (obj == null) {
                            v.e("MicroMsg.EnterpriseConversationUI", "onItemDel object null");
                            return;
                        }
                        a.a(this.oLO, obj.toString());
                    }
                });
                this.oLH.setAdapter(this.oLI);
                this.oLH.setOnItemClickListener(new OnItemClickListener(this) {
                    final /* synthetic */ a oLO;

                    {
                        this.oLO = r1;
                    }

                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        String str = null;
                        if (i >= this.oLO.oLH.getHeaderViewsCount()) {
                            ab abVar = (ab) this.oLO.oLI.getItem(i - this.oLO.oLH.getHeaderViewsCount());
                            if (abVar == null) {
                                v.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", Integer.valueOf(r2), Integer.valueOf(this.oLO.oLI.getCount()));
                                this.oLO.oLI.notifyDataSetChanged();
                            } else if (com.tencent.mm.modelbiz.e.hC(abVar.field_username)) {
                                Intent intent = new Intent(this.oLO.bzo(), BizChatConversationUI.class);
                                intent.putExtra("Contact_User", abVar.field_username);
                                intent.putExtra("biz_chat_from_scene", 7);
                                intent.addFlags(67108864);
                                this.oLO.startActivity(intent);
                            } else if (com.tencent.mm.modelbiz.e.hD(abVar.field_username)) {
                                BizInfo hw = com.tencent.mm.modelbiz.e.hw(abVar.field_username);
                                if (hw != null) {
                                    str = hw.CD();
                                }
                                if (str == null) {
                                    str = SQLiteDatabase.KeyEmpty;
                                }
                                Intent intent2 = new Intent();
                                intent2.putExtra("rawUrl", str);
                                intent2.putExtra("useJs", true);
                                intent2.putExtra("srcUsername", abVar.field_username);
                                intent2.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
                                intent2.addFlags(67108864);
                                com.tencent.mm.ay.c.b(this.oLO.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent2);
                            } else {
                                this.oLO.oJX.a(abVar.field_username, null, true);
                            }
                        } else if (i == 0) {
                            a.e(this.oLO);
                        }
                    }
                });
                this.eyZ = new l(bzo());
                this.hkn = new d(this) {
                    final /* synthetic */ a oLO;

                    {
                        this.oLO = r1;
                    }

                    public final void c(MenuItem menuItem, int i) {
                        switch (menuItem.getItemId()) {
                            case 1:
                                a.a(this.oLO, this.oLO.eyY);
                                return;
                            case 2:
                                a.b(this.oLO, this.oLO.eyY);
                                return;
                            case 3:
                                a.Pm(this.oLO.eyY);
                                return;
                            default:
                                return;
                        }
                    }
                };
                this.oLH.setOnItemLongClickListener(new OnItemLongClickListener(this) {
                    final /* synthetic */ a oLO;

                    {
                        this.oLO = r1;
                    }

                    public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                        if (i < this.oLO.oLH.getHeaderViewsCount()) {
                            v.w("MicroMsg.EnterpriseConversationUI", "on header view long click, ignore");
                        } else {
                            int headerViewsCount = i - this.oLO.oLH.getHeaderViewsCount();
                            this.oLO.eyY = ((ab) this.oLO.oLI.getItem(headerViewsCount)).field_username;
                            this.oLO.eyZ.a(view, headerViewsCount, j, this.oLO, this.oLO.hkn);
                        }
                        return true;
                    }
                });
            }
            this.bYN = System.currentTimeMillis() / 1000;
            ak.yW();
            af Mh = c.wK().Mh(this.cBj);
            if (Mh != null) {
                this.oLL = Mh.field_unReadCount;
                if (this.oLL == 0 && Mh.field_unReadMuteCount > 0) {
                    this.oLL = -1;
                }
                this.oLM = Mh.field_conversationTime / 1000;
                this.oLN = Mh.field_isSend == 1 ? null : Mh.field_digestUser;
            }
            u.DF().a(this.ohH, bzo().getMainLooper());
            ak.yW();
            c.wK().a(this);
            ak.yW();
            c.wH().a(this);
            if (this.oLI != null) {
                if (this.oLK == null) {
                    this.oLK = new ac(this) {
                        final /* synthetic */ a oLO;

                        {
                            this.oLO = r1;
                        }

                        public final void handleMessage(Message message) {
                            if (message != null && message.what == 1 && this.oLO.bzo() != null && !this.oLO.bzo().isFinishing()) {
                                int i;
                                int count = this.oLO.oLI.getCount();
                                LinkedList linkedList = new LinkedList();
                                LinkedList linkedList2 = new LinkedList();
                                int i2 = 0;
                                int i3 = 0;
                                int i4 = 0;
                                int i5 = 0;
                                while (i5 < count) {
                                    ab abVar = (ab) this.oLO.oLI.getItem(i5);
                                    if (abVar != null) {
                                        String str = abVar.field_username;
                                        if (str != null) {
                                            if (com.tencent.mm.model.m.eC(str) && com.tencent.mm.modelbiz.e.hE(str)) {
                                                ak.yW();
                                                com.tencent.mm.e.b.ab LX = c.wH().LX(str);
                                                ak.yW();
                                                boolean Mn = c.wK().Mn(str);
                                                Object obj = (LX == null || (LX.field_type & 2048) == 0) ? null : 1;
                                                if (obj != null && !Mn) {
                                                    ak.yW();
                                                    c.wK().Ml(str);
                                                } else if (obj == null && Mn) {
                                                    ak.yW();
                                                    c.wK().Mm(str);
                                                }
                                                if (com.tencent.mm.modelbiz.e.hD(str)) {
                                                    linkedList2.add(str);
                                                }
                                                if (abVar.field_unReadCount > 0) {
                                                    if (com.tencent.mm.model.m.fs(str)) {
                                                        int i6 = i4;
                                                        i4 = i3;
                                                        i3 = i2 + 1;
                                                        i = i6;
                                                    } else {
                                                        i = abVar.field_unReadCount + i4;
                                                        i4 = i3 + 1;
                                                        i3 = i2;
                                                    }
                                                    i5++;
                                                    i2 = i3;
                                                    i3 = i4;
                                                    i4 = i;
                                                }
                                            } else {
                                                v.d("MicroMsg.EnterpriseConversationUI", "checkEnterpriseChildConv delete conv %s", str);
                                                linkedList.add(str);
                                                i = i4;
                                                i4 = i3;
                                                i3 = i2;
                                                i5++;
                                                i2 = i3;
                                                i3 = i4;
                                                i4 = i;
                                            }
                                        }
                                    }
                                    i = i4;
                                    i4 = i3;
                                    i3 = i2;
                                    i5++;
                                    i2 = i3;
                                    i3 = i4;
                                    i4 = i;
                                }
                                com.tencent.mm.modelbiz.b gZ = u.DF().gZ(this.oLO.cBj);
                                i = gZ != null ? gZ.field_qyUin : 0;
                                int i7 = 0;
                                if (!be.kS(this.oLO.oLN)) {
                                    i7 = u.DF().hb(this.oLO.oLN);
                                }
                                com.tencent.mm.plugin.report.service.g.iuh.h(12892, this.oLO.cBj, Integer.valueOf(this.oLO.fromScene), Integer.valueOf(count), SQLiteDatabase.KeyEmpty, Integer.valueOf(this.oLO.oLL), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.oLO.oLM), Integer.valueOf(i7), Integer.valueOf(i));
                                v.d("MicroMsg.EnterpriseConversationUI", "enter biz enterprise father report: %s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", this.oLO.cBj, Integer.valueOf(this.oLO.fromScene), Integer.valueOf(count), SQLiteDatabase.KeyEmpty, Integer.valueOf(this.oLO.oLL), Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.oLO.oLM), Integer.valueOf(i7), Integer.valueOf(i));
                                if (linkedList.size() > 0) {
                                    ak.yW();
                                    c.wK().ai(linkedList);
                                    this.oLO.oLI.Ol();
                                }
                                if (u.DI().a(this.oLO.cBj, null)) {
                                    u.DF();
                                    com.tencent.mm.modelbiz.c.a(this.oLO.cBj, null);
                                }
                                u.DI().a(this.oLO.bIn(), null);
                                if (linkedList2.size() > 0) {
                                    for (i4 = 0; i4 < linkedList2.size(); i4++) {
                                        u.DI().a((String) linkedList2.get(i4), null);
                                    }
                                }
                            }
                        }
                    };
                } else {
                    this.oLK.removeMessages(1);
                }
                this.oLK.sendEmptyMessageDelayed(1, 500);
            }
        }

        protected final int getLayoutId() {
            return 2130903521;
        }

        public final String getUserName() {
            return this.cBj;
        }

        public final void onDestroy() {
            u.DF().a(this.ohH);
            if (ak.uz()) {
                ak.yW();
                c.wK().b(this);
                ak.yW();
                c.wH().b(this);
            }
            if (this.oLI != null) {
                j.b bVar = this.oLI;
                bVar.oKu.QI();
                if (bVar.ohm != null) {
                    bVar.ohm.clear();
                    bVar.ohm = null;
                }
                bVar.avc();
                bVar.nDK = null;
                ak.yW();
                c.wK().b(bVar);
            }
            ak.vy().b(1394, (e) this);
            if (this.bYN > 0 && this.dbx > 0) {
                long j = this.dbx - this.bYN;
                com.tencent.mm.modelbiz.b gZ = u.DF().gZ(this.cBj);
                int i = gZ != null ? gZ.field_qyUin : 0;
                int i2 = gZ != null ? gZ.field_userUin : 0;
                com.tencent.mm.plugin.report.service.g.iuh.h(13465, SQLiteDatabase.KeyEmpty, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j));
                v.d("MicroMsg.EnterpriseConversationUI", "quit biz enterprise father report: %s,%s,%s,%s,%s", Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(i2), Integer.valueOf(1), Long.valueOf(j));
            }
            super.onDestroy();
        }

        public final void onResume() {
            v.v("MicroMsg.EnterpriseConversationUI", "on resume");
            if (this.oLI != null) {
                this.oLI.onResume();
            }
            super.onResume();
            if (!com.tencent.mm.model.m.eC(this.cBj)) {
                finish();
            }
        }

        public final void onPause() {
            v.v("MicroMsg.EnterpriseConversationUI", "on pause");
            ak.yW();
            c.wK().Mj(this.cBj);
            if (this.oLI != null) {
                this.oLI.onPause();
            }
            super.onPause();
        }

        public final void onActivityResult(int i, int i2, Intent intent) {
            super.onActivityResult(i, i2, intent);
            switch (i) {
                case 1:
                    if (i2 == -1 && intent != null) {
                        String stringExtra = intent.getStringExtra("be_send_card_name");
                        String stringExtra2 = intent.getStringExtra("received_card_name");
                        boolean booleanExtra = intent.getBooleanExtra("Is_Chatroom", false);
                        String stringExtra3 = intent.getStringExtra("custom_send_text");
                        com.tencent.mm.pluginsdk.j.a.bmt().m(stringExtra, stringExtra2, booleanExtra);
                        com.tencent.mm.pluginsdk.j.a.bmt().df(stringExtra3, stringExtra2);
                        com.tencent.mm.ui.snackbar.a.f(bzo(), this.nDR.nEl.getString(2131232839));
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        private void bIm() {
            this.ohE = u.DF().hf(this.cBj);
            boolean z = !be.kS(bIn());
            this.oLH.oLR = true;
            if (z || this.ohE) {
                if (com.tencent.mm.bd.a.dt(this.nDR.nEl)) {
                    this.oLG = View.inflate(this.nDR.nEl, 2130903535, null);
                } else {
                    this.oLG = View.inflate(this.nDR.nEl, 2130903534, null);
                }
                TextView textView = (TextView) this.oLG.findViewById(2131755456);
                ((ImageView) this.oLG.findViewById(2131756771)).setImageResource(2131165496);
                textView.setText(2131232456);
                bDt();
                bDu();
                this.oLH.addHeaderView(this.oLG);
                this.oLH.bIp();
                this.ohz = (int) getResources().getDimension(2131493147);
            }
        }

        private void bDt() {
            if (this.oLG != null) {
                int i;
                ak.yW();
                af Mh = c.wK().Mh(bIn());
                if (Mh != null) {
                    if (Mh.field_unReadMuteCount + Mh.field_unReadCount > 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                    i = 0;
                }
                View findViewById = this.oLG.findViewById(2131756772);
                if (i != 0) {
                    findViewById.setVisibility(0);
                } else {
                    findViewById.setVisibility(8);
                }
            }
        }

        private void bDu() {
            if (this.oLG != null) {
                this.ohx = (ImageButton) this.oLG.findViewById(2131756773);
                if ((!be.kS(bIn()) ? 1 : 0) != 0 && this.ohE) {
                    final boolean hg = u.DF().hg(this.cBj);
                    if (hg) {
                        this.ohx.setImageResource(2131165498);
                    }
                    this.ohx.setVisibility(0);
                    this.ohx.setOnClickListener(new View.OnClickListener(this) {
                        final /* synthetic */ a oLO;

                        public final void onClick(View view) {
                            if (hg) {
                                this.oLO.ohx.setImageResource(2131165497);
                                u.DF().hd(this.oLO.cBj);
                            }
                            com.tencent.mm.ui.f.g(this.oLO.nDR.nEl, this.oLO.cBj, true);
                        }
                    });
                }
            }
        }

        private String bIn() {
            if (this.oLJ == null) {
                u.Dy();
                String hs = com.tencent.mm.modelbiz.d.hs(this.cBj);
                if (be.kS(hs)) {
                    hs = SQLiteDatabase.KeyEmpty;
                }
                this.oLJ = hs;
            }
            return be.kS(this.oLJ) ? null : this.oLJ;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (this.dwg != null && this.dwg.isShowing()) {
                this.dwg.dismiss();
            }
            if (i == 0 && i2 == 0 && kVar.getType() == 1394) {
                ays aGA = ((com.tencent.mm.plugin.profile.a.c) kVar).aGA();
                ayt aGz = ((com.tencent.mm.plugin.profile.a.c) kVar).aGz();
                if (aGz == null || aGz.mhP == null || aGz.mhP.ret != 0) {
                    if (aGz == null || aGz.mhP == null) {
                        v.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:resp == null", Integer.valueOf(kVar.getType()));
                        return;
                    }
                    v.w("MicroMsg.EnterpriseConversationUI", "chuangchen onSceneEnd type:%s, err:code:%s", Integer.valueOf(kVar.getType()), Integer.valueOf(aGz.mhP.ret));
                } else if (aGA.mVW) {
                    com.tencent.mm.sdk.h.c hw = com.tencent.mm.modelbiz.e.hw(aGA.mhJ);
                    hw.field_brandFlag |= 1;
                    com.tencent.mm.ba.a com_tencent_mm_protocal_c_ail = new ail();
                    com_tencent_mm_protocal_c_ail.cHq = hw.field_brandFlag;
                    com_tencent_mm_protocal_c_ail.gln = aGA.mhJ;
                    ak.yW();
                    c.wG().b(new com.tencent.mm.ak.j.a(47, com_tencent_mm_protocal_c_ail));
                    u.Dy().a(hw, new String[0]);
                    ak.yW();
                    c.wK().Mf(hw.field_username);
                    ak.yW();
                    if (c.wK().Mq(hw.field_enterpriseFather) <= 0) {
                        ak.yW();
                        c.wK().Mf(hw.field_enterpriseFather);
                        return;
                    }
                    ak.yW().cra.Lx(hw.field_enterpriseFather);
                }
            }
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
            ak.yW();
            com.tencent.mm.e.b.ab LX = c.wH().LX(this.eyY);
            if (LX == null) {
                v.e("MicroMsg.EnterpriseConversationUI", "onCreateContextMenu, contact is null, talker = " + this.eyY);
                return;
            }
            CharSequence tU = LX.tU();
            if (tU.toLowerCase().endsWith("@chatroom") && be.kS(LX.field_nickname)) {
                tU = getString(2131231879);
            }
            AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
            contextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.e.a(bzo(), tU));
            if (LX.tP()) {
                contextMenu.add(adapterContextMenuInfo.position, 3, 0, 2131233706);
            } else {
                contextMenu.add(adapterContextMenuInfo.position, 3, 0, 2131232476);
            }
            contextMenu.add(adapterContextMenuInfo.position, 2, 1, 2131232469);
            contextMenu.add(adapterContextMenuInfo.position, 1, 2, 2131233710);
        }

        public final void a(int i, j jVar, Object obj) {
            String str = (String) obj;
            if (!be.kS(str)) {
                BizInfo hw = com.tencent.mm.modelbiz.e.hw(str);
                if (hw != null && hw.CB() && this.cBj.equals(hw.field_enterpriseFather)) {
                    u.Dy();
                    String hs = com.tencent.mm.modelbiz.d.hs(this.cBj);
                    if (be.kS(hs)) {
                        hs = SQLiteDatabase.KeyEmpty;
                    }
                    this.oLJ = hs;
                    if (this.oLG == null) {
                        bIm();
                        this.oLH.setAdapter(this.oLI);
                        return;
                    }
                    bDt();
                    bDu();
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.dtW = q.em(this).inflate(2130903184, null);
        setContentView(this.dtW);
        this.oJN = new a();
        aS().aW().a(2131755641, this.oJN).commit();
        com.tencent.mm.pluginsdk.e.a(this, this.dtW);
    }

    public void finish() {
        if (this.oJN != null && (this.oJN instanceof a)) {
            ((a) this.oJN).dbx = System.currentTimeMillis() / 1000;
        }
        super.finish();
    }
}
