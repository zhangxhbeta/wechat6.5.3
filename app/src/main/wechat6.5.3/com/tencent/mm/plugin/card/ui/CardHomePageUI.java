package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mars.smc.SmcLogic.IDKey;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.card.a.i;
import com.tencent.mm.plugin.card.base.CardBaseUI;
import com.tencent.mm.plugin.card.base.d;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.plugin.card.model.j;
import com.tencent.mm.plugin.card.model.z;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.plugin.card.sharecard.ui.ShareCardListUI;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.h.g.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.t;
import com.tencent.mm.v.k;
import java.util.ArrayList;

public class CardHomePageUI extends CardBaseUI implements d, a {
    boolean eGA = false;
    private b eGa;
    private boolean eGo = false;
    private boolean eGq = true;
    private boolean eGs = false;
    private String eGt = "";
    private boolean eGu = false;
    private boolean eGv = false;
    private long eGz = 0;
    private h eJR;
    private e eJS;
    private e eJT;
    private e eJU;
    private boolean eJV = true;
    private boolean eJW = false;
    private TextView eJX;
    private int fromScene = 0;
    private long mStartTime = 0;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fromScene = getIntent().getIntExtra("key_home_page_from_scene", 0);
        long currentTimeMillis = System.currentTimeMillis();
        this.mStartTime = currentTimeMillis;
        this.eGz = currentTimeMillis;
        NI();
        af.aao().a(this.eJR);
        ak.vy().a(1164, this);
        ak.vy().a(984, this);
        af.aar().aay();
        af.aaj();
        com.tencent.mm.plugin.card.a.b.iS(1);
        aaW();
        Looper.myQueue().addIdleHandler(new IdleHandler(this) {
            final /* synthetic */ CardHomePageUI eJY;

            {
                this.eJY = r1;
            }

            public final boolean queueIdle() {
                if (this.eJY.eGa != null) {
                    boolean z;
                    ak.yW();
                    Integer num = (Integer) c.vf().get(t.a.npT, Integer.valueOf(0));
                    if (num == null || num.intValue() != 1) {
                        ak.yW();
                        c.vf().a(t.a.npT, Integer.valueOf(1));
                        Cursor iU = af.aak().iU(j.a.eDg);
                        if (iU == null || iU.getCount() <= 0) {
                            v.e("MicroMsg.ShareCardDataMgr", "updateAllCardInfoByBlockField cursor is null or size is 0");
                            z = false;
                        } else {
                            iU.moveToFirst();
                            while (!iU.isAfterLast()) {
                                CardInfo cardInfo = new CardInfo();
                                cardInfo.b(iU);
                                if (cardInfo.field_card_type == -1) {
                                    if (cardInfo.Zv() == null) {
                                        v.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , info.getCardTpInfo() == null");
                                    } else {
                                        cardInfo.field_card_type = cardInfo.Zv().eBL;
                                        if (!af.aak().a(cardInfo, new String[0])) {
                                            v.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , cardId = %s", new Object[]{cardInfo.field_card_id});
                                        }
                                    }
                                }
                                iU.moveToNext();
                            }
                            iU.close();
                            z = true;
                        }
                    } else {
                        z = false;
                    }
                    if (z) {
                        v.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
                        this.eJY.abI();
                    }
                }
                return false;
            }
        });
        af.aar().a(this);
        af.aak().c(this);
    }

    protected final int getLayoutId() {
        return 2130903226;
    }

    protected void onDestroy() {
        if (this.eJW) {
            YU();
        }
        af.aao().b(this.eJR);
        this.eGa.eEo = null;
        ak.vy().b(1164, this);
        ak.vy().b(984, this);
        af.aar().b(this);
        af.aak().d(this);
        i.aaa();
        b.aaF();
        long currentTimeMillis = System.currentTimeMillis() - this.eGz;
        g.iuh.h(13219, new Object[]{"CardHomePageUI", Integer.valueOf(this.fromScene), "", "", Long.valueOf(currentTimeMillis)});
        super.onDestroy();
    }

    protected void onResume() {
        v.i("MicroMsg.CardHomePageUI", "onResume locationPermissionGranted %s, hasInitLocation %s, shouldGetLayout %s", new Object[]{Boolean.valueOf(this.eJW), Boolean.valueOf(this.eGA), Boolean.valueOf(this.eGo)});
        if (this.eJW && this.eGA && this.eGo) {
            this.eGt = "";
            this.eGu = false;
            YT();
        } else if (this.eGo) {
            this.eGt = "";
            aaU();
        }
        this.eGo = false;
        av();
        long currentTimeMillis = System.currentTimeMillis();
        if (this.mStartTime != 0) {
            int i = (int) (currentTimeMillis - this.mStartTime);
            ArrayList arrayList = new ArrayList();
            IDKey iDKey = new IDKey();
            iDKey.SetID(281);
            iDKey.SetKey(0);
            iDKey.SetValue(1);
            IDKey iDKey2 = new IDKey();
            iDKey2.SetID(281);
            iDKey2.SetKey(1);
            iDKey2.SetValue(i);
            arrayList.add(iDKey);
            arrayList.add(iDKey2);
            g gVar = g.iuh;
            g.d(arrayList, true);
            this.mStartTime = 0;
        }
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    protected final void NI() {
        v.i("MicroMsg.CardHomePageUI", "checkPermission checkLocation[%b]", new Object[]{Boolean.valueOf(com.tencent.mm.pluginsdk.i.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 69, null, null))});
        this.eJW = r0;
        if (this.eJW) {
            aaR();
        } else {
            v.e("MicroMsg.CardHomePageUI", "location permission is denied, doGetLayout");
            aaU();
        }
        super.NI();
    }

    protected final void YN() {
        vD(2131231632);
        a(0, getString(2131231656), new OnMenuItemClickListener(this) {
            final /* synthetic */ CardHomePageUI eJY;

            {
                this.eJY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                com.tencent.mm.plugin.card.b.b.a(this.eJY, true);
                g.iuh.h(11582, new Object[]{"CardListMsgMenu", Integer.valueOf(2), Integer.valueOf(0), "", ""});
                return true;
            }
        });
        this.eGa = new b(this);
        this.eGa.init();
        if (this.eJR == null) {
            this.eJR = new h(this, this.nDR.dtW);
            h hVar = this.eJR;
            hVar.eKK = View.inflate(hVar.eBk, 2130903238, null);
            hVar.eKK.setVisibility(8);
            hVar.eKL = (TextView) hVar.eKK.findViewById(2131755933);
            hVar.eKM = (ImageView) hVar.eKK.findViewById(2131755932);
            hVar.eKK.setOnClickListener(new OnClickListener(hVar) {
                final /* synthetic */ h eKQ;

                {
                    this.eKQ = r1;
                }

                public final void onClick(View view) {
                    com.tencent.mm.plugin.card.b.b.a(this.eKQ.eBk, false);
                    af.aao().ZZ();
                    this.eKQ.abN();
                    g.iuh.h(11324, new Object[]{"CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), ""});
                }
            });
            hVar.abN();
            if (hVar.eKN == null) {
                hVar.eKN = ((ViewStub) hVar.eEX.findViewById(2131755882)).inflate();
                hVar.eKN.setVisibility(8);
                hVar.eKO = (TextView) hVar.eKN.findViewById(2131755933);
                hVar.eKP = (ImageView) hVar.eKN.findViewById(2131755932);
                hVar.eKN.setOnClickListener(new OnClickListener(hVar) {
                    final /* synthetic */ h eKQ;

                    {
                        this.eKQ = r1;
                    }

                    public final void onClick(View view) {
                        com.tencent.mm.plugin.card.b.b.a(this.eKQ.eBk, false);
                        af.aao().ZZ();
                        this.eKQ.abN();
                        g.iuh.h(11324, new Object[]{"CardMsgCenterView", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(0), "", Integer.valueOf(0), ""});
                    }
                });
            }
            this.eJR.eGJ = true;
        }
        if (this.eJS == null) {
            this.eJS = new e(this, findViewById(2131755885), 1, this.eGa);
        }
        if (this.eJT == null) {
            this.eJT = new e(this, findViewById(2131755886), 2, this.eGa);
        }
        if (this.eJU == null) {
            this.eJU = new e(this, findViewById(2131755887), 3, this.eGa);
        }
        if (this.eJS != null) {
            this.eJS.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CardHomePageUI eJY;

                {
                    this.eJY = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.eJY, CardIndexUI.class);
                    intent.putExtra("key_card_type", 1);
                    this.eJY.startActivity(intent);
                    g.iuh.h(11324, new Object[]{"GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(1), "", Integer.valueOf(0), Integer.valueOf(0)});
                }
            });
        }
        if (this.eJT != null) {
            this.eJT.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CardHomePageUI eJY;

                {
                    this.eJY = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.eJY, ShareCardListUI.class);
                    intent.putExtra("key_layout_buff", this.eJY.eGt);
                    this.eJY.eJV = true;
                    this.eJY.startActivity(intent);
                    l lVar = (l) af.aap().getValue("key_share_card_layout_data");
                    if (lVar != null) {
                        int i;
                        int i2;
                        int i3;
                        int i4 = lVar.eEI ? 1 : 0;
                        if (lVar.eEJ) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (lVar.eEK != null) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (TextUtils.isEmpty(lVar.eEL)) {
                            i3 = 0;
                        } else {
                            i3 = 1;
                        }
                        g.iuh.h(13685, new Object[]{Integer.valueOf(2), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
                        if (lVar.eEJ) {
                            this.eJY.eGo = true;
                            lVar.eEJ = false;
                        }
                        if (lVar.eEI) {
                            this.eJY.eGo = true;
                            lVar.eEI = false;
                            lVar.eEK = null;
                            lVar.eEL = "";
                        }
                    }
                    ak.yW();
                    c.vf().a(t.a.npF, "");
                    g.iuh.h(11324, new Object[]{"ClickShareCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
                }
            });
        }
        if (this.eJU != null) {
            this.eJU.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CardHomePageUI eJY;

                {
                    this.eJY = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.eJY, CardIndexUI.class);
                    intent.putExtra("key_card_type", 3);
                    this.eJY.startActivity(intent);
                    g.iuh.h(11324, new Object[]{"ClickTicketCard", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
                }
            });
        }
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ CardHomePageUI eJY;

            {
                this.eJY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (this.eJY.fromScene == 1 || this.eJY.fromScene == 2) {
                    this.eJY.abJ();
                } else {
                    this.eJY.finish();
                }
                return true;
            }
        });
    }

    protected final int YO() {
        return j.a.eDl;
    }

    private void aaR() {
        v.d("MicroMsg.CardHomePageUI", "initLocation");
        ak.vA().x(new Runnable(this) {
            final /* synthetic */ CardHomePageUI eJY;

            {
                this.eJY = r1;
            }

            public final void run() {
                this.eJY.cCR = com.tencent.mm.modelgeo.c.FY();
                this.eJY.YS();
                this.eJY.eGA = true;
                v.d("MicroMsg.CardHomePageUI", "initLocation end");
            }
        });
    }

    protected final void YX() {
        v.i("MicroMsg.CardHomePageUI", "onMPermissionGranted locationPermissionGranted " + this.eJW);
        if (!this.eJW) {
            this.eJW = true;
            aaR();
        }
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        aaW();
        this.eGo = true;
        this.eJV = true;
    }

    private void av() {
        v.i("MicroMsg.CardHomePageUI", "updateView()");
        this.eJR.abN();
        abI();
        this.eJT.av();
        this.eJU.av();
    }

    private void abI() {
        v.i("MicroMsg.CardHomePageUI", "updateMemberCardItem()");
        b bVar = (b) this.eAB;
        if (this.eJX == null) {
            this.eJX = (TextView) findViewById(2131755884);
            this.eJX.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ CardHomePageUI eJY;

                {
                    this.eJY = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent(this.eJY, CardIndexUI.class);
                    intent.putExtra("key_card_type", 1);
                    this.eJY.startActivity(intent);
                    g.iuh.h(11324, new Object[]{"GotoMemberCardUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0)});
                }
            });
        }
        if (bVar.getCount() > 0) {
            this.eJX.setVisibility(0);
            this.eJX.setText(getString(2131231699, new Object[]{Integer.valueOf(b.aaz())}));
            this.eJS.setVisibility(8);
            return;
        }
        this.eJX.setVisibility(8);
        this.eJS.setVisibility(0);
    }

    protected final void YY() {
        abI();
    }

    protected final void YV() {
        if (this.eGu) {
            v.e("MicroMsg.CardHomePageUI", "onLocationFinish, has do GetShareCardLayout,don't get again");
            if (this.eJW) {
                YU();
                return;
            }
            return;
        }
        v.d("MicroMsg.CardHomePageUI", "onLocationFinish()");
        this.eGu = true;
        aaU();
        YU();
    }

    protected final void YW() {
        if (this.eGv || this.eGu) {
            YU();
            return;
        }
        this.eGv = true;
        v.i("MicroMsg.CardHomePageUI", "onLocationFail()");
        aaU();
    }

    private void aaU() {
        v.d("MicroMsg.CardHomePageUI", "doGetLayout() >> doNetSceneGetCardsHomePageLayout()");
        if (!this.eJV) {
            v.i("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, shouldGetHomePage is false");
        } else if (this.eGs) {
            v.e("MicroMsg.CardHomePageUI", "doNetSceneGetCardsHomePageLayout, isDoingGetData is true");
        } else {
            if (this.eGq && !be.kS(this.eGt)) {
                this.eGt = "";
            }
            this.eGs = true;
            this.eJV = false;
            ak.vy().a(new com.tencent.mm.plugin.card.sharecard.model.b((double) af.aaq().bYf, (double) af.aaq().bYg, this.eGt), 0);
        }
        if (com.tencent.mm.plugin.card.b.j.acH()) {
            ak.yW();
            int intValue = ((Integer) c.vf().get(t.a.npJ, Integer.valueOf(1))).intValue();
            v.i("MicroMsg.BatchGetCardMgr", "need do getCardsLayoutScene scene is " + intValue);
            ak.vy().a(new z((double) af.aaq().bYf, (double) af.aaq().bYg, intValue), 0);
        } else {
            v.i("MicroMsg.CardHomePageUI", "the card entrance is not open, don't do doNetSceneGetCardsLayout!");
        }
        af.aaq().l("", "", 4);
    }

    protected final boolean YQ() {
        return super.YQ();
    }

    protected final boolean YR() {
        return true;
    }

    protected final void b(com.tencent.mm.plugin.card.base.b bVar) {
        super.b(bVar);
    }

    protected final void c(com.tencent.mm.plugin.card.base.b bVar) {
        super.c(bVar);
    }

    public final void a(int i, int i2, String str, k kVar) {
        super.a(i, i2, str, kVar);
        if (i != 0 || i2 != 0) {
            if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
                this.eGs = false;
            }
            v.i("MicroMsg.CardHomePageUI", "share card list ui, onSceneEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        } else if (kVar instanceof z) {
            abI();
            this.eAH.zk();
            this.eJU.av();
        } else if (kVar instanceof com.tencent.mm.plugin.card.sharecard.model.b) {
            com.tencent.mm.plugin.card.sharecard.model.b bVar = (com.tencent.mm.plugin.card.sharecard.model.b) kVar;
            this.eGs = false;
            this.eGt = bVar.eEw;
            this.eGa.N(bVar.eDn, this.eGq);
            if (!(b.aaG() && b.aaH())) {
                this.eGq = false;
            }
            v.i("MicroMsg.CardHomePageUI", "NetSceneGetShareCardsLayout() >> updateView()");
            av();
        }
    }

    private void aaW() {
        int intExtra = getIntent().getIntExtra("key_from_scene", 22);
        boolean ax = com.tencent.mm.p.c.us().ax(262152, 266256);
        boolean ay = com.tencent.mm.p.c.us().ay(262152, 266256);
        boolean a = com.tencent.mm.p.c.us().a(t.a.npx, t.a.npz);
        boolean a2 = com.tencent.mm.p.c.us().a(t.a.npy, t.a.npA);
        ak.yW();
        String ma = be.ma((String) c.vf().get(t.a.npD, null));
        if (ax) {
            g.iuh.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(2), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        } else if (ay) {
            g.iuh.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(1), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        } else if (a && !a2) {
            g.iuh.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(3), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        } else if (a && a2) {
            g.iuh.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(4), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        } else if (a2) {
            g.iuh.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(5), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        } else {
            g.iuh.h(11324, new Object[]{"CardHomePageUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(intExtra), "", Integer.valueOf(0), ma});
        }
    }

    public final void ZG() {
        this.eGo = true;
    }

    public final void a(String str, com.tencent.mm.sdk.h.i iVar) {
        this.eGo = true;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.fromScene == 1 || this.fromScene == 2) {
                abJ();
            } else {
                finish();
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void abJ() {
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("preferred_tab", 3);
        com.tencent.mm.ay.c.a(this, "com.tencent.mm.ui.LauncherUI", intent);
        finish();
    }
}
