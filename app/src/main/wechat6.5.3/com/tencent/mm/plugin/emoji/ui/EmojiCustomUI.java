package com.tencent.mm.plugin.emoji.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.lb;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.emoji.d.f;
import com.tencent.mm.plugin.emoji.d.o;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.h.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.HeaderGridView;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.v.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class EmojiCustomUI extends MMActivity implements OnItemClickListener, e {
    private ProgressDialog eZg;
    private int fgT = c.fhA;
    private b fgU;
    private HeaderGridView fgV;
    private View fgW;
    private Button fgX;
    private Button fgY;
    private com.tencent.mm.plugin.emoji.g.a.a fgZ = com.tencent.mm.plugin.emoji.g.a.a.Default;
    private View fha;
    private TextView fhb;
    private Button fhc;
    private boolean fhd = false;
    private boolean fhe = false;
    private boolean fhf = false;
    private a fhg = a.EMPTY;
    private ArrayList<String> fhh = new ArrayList();
    private OnClickListener fhi = new OnClickListener(this) {
        final /* synthetic */ EmojiCustomUI fhp;

        {
            this.fhp = r1;
        }

        public final void onClick(View view) {
            switch (this.fhp.fhg) {
                case START:
                    g.b(this.fhp.nDR.nEl, this.fhp.getResources().getString(2131232434), "", this.fhp.getResources().getString(2131232432), this.fhp.getResources().getString(2131231010), new DialogInterface.OnClickListener(this.fhp) {
                        final /* synthetic */ EmojiCustomUI fhp;

                        {
                            this.fhp = r1;
                        }

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            com.tencent.mm.plugin.emoji.g.c cVar = com.tencent.mm.plugin.emoji.model.g.afu().feA;
                            cVar.feN = true;
                            cVar.afU();
                            com.tencent.mm.plugin.report.service.g.iuh.h(11595, new Object[]{Integer.valueOf(1)});
                        }
                    }, null);
                    return;
                case PAUSE:
                    com.tencent.mm.plugin.emoji.model.g.afu().feA.afV();
                    return;
                default:
                    return;
            }
        }
    };
    private OnClickListener fhj = new OnClickListener(this) {
        final /* synthetic */ EmojiCustomUI fhp;

        {
            this.fhp = r1;
        }

        public final void onClick(View view) {
            g.a(this.fhp.nDR.nEl, this.fhp.getResources().getString(2131232338), "", this.fhp.getResources().getString(2131231020), this.fhp.getResources().getString(2131231010), new DialogInterface.OnClickListener(this.fhp) {
                final /* synthetic */ EmojiCustomUI fhp;

                {
                    this.fhp = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    EmojiCustomUI.j(this.fhp);
                }
            }, null, 2131690173);
        }
    };
    private OnClickListener fhk = new OnClickListener(this) {
        final /* synthetic */ EmojiCustomUI fhp;

        {
            this.fhp = r1;
        }

        public final void onClick(View view) {
            EmojiCustomUI.d(this.fhp);
        }
    };
    private final com.tencent.mm.sdk.h.g.a fhl = new com.tencent.mm.sdk.h.g.a(this) {
        final /* synthetic */ EmojiCustomUI fhp;

        {
            this.fhp = r1;
        }

        public final void a(String str, i iVar) {
            if (!be.kS(str)) {
                if ((str.length() == 32 || str.equals("event_update_emoji")) && this.fhp.fgU != null) {
                    this.fhp.fgU.agO();
                    this.fhp.fgU.notifyDataSetChanged();
                }
            }
        }
    };
    private final com.tencent.mm.plugin.emoji.g.d fhm = new com.tencent.mm.plugin.emoji.g.d.a(this) {
        final /* synthetic */ EmojiCustomUI fhp;

        {
            this.fhp = r1;
        }

        public final void afY() {
            this.fhp.fgZ = com.tencent.mm.plugin.emoji.model.g.afu().afT();
            if (this.fhp.mHandler != null) {
                this.fhp.mHandler.sendEmptyMessage(1001);
            }
        }

        public final void afZ() {
            if (this.fhp.mHandler != null) {
                this.fhp.mHandler.sendEmptyMessage(1002);
            }
        }
    };
    private com.tencent.mm.ae.a.c.d fhn = new com.tencent.mm.ae.a.c.d(this) {
        final /* synthetic */ EmojiCustomUI fhp;

        {
            this.fhp = r1;
        }

        public final byte[] f(Object... objArr) {
            if (objArr != null && objArr.length > 0) {
                Object obj = objArr[0];
                if (obj != null && (obj instanceof com.tencent.mm.storage.a.c)) {
                    return f.aeV().a((com.tencent.mm.storage.a.c) obj);
                }
            }
            return null;
        }
    };
    private com.tencent.mm.storage.a.c fho;
    private ac mHandler = new ac(this) {
        final /* synthetic */ EmojiCustomUI fhp;

        {
            this.fhp = r1;
        }

        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    EmojiCustomUI.g(this.fhp);
                    return;
                case 1002:
                    com.tencent.mm.plugin.emoji.model.g.afu();
                    if (!com.tencent.mm.plugin.emoji.g.c.aeT()) {
                        return;
                    }
                    if (com.tencent.mm.plugin.emoji.model.g.afu().afT() == com.tencent.mm.plugin.emoji.g.a.a.Syncing) {
                        this.fhp.cv(true);
                        return;
                    } else {
                        this.fhp.cv(false);
                        return;
                    }
                case 1003:
                    this.fhp.fha.setVisibility(8);
                    this.fhp.fgU.notifyDataSetChanged();
                    return;
                case 1004:
                    if (this.fhp.fgU != null) {
                        this.fhp.fgU.agO();
                        this.fhp.fgU.notifyDataSetChanged();
                    }
                    com.tencent.mm.sdk.c.a.nhr.z(new lb());
                    return;
                default:
                    v.e("MicroMsg.emoji.EmojiCustomUI", "unknow Msg");
                    return;
            }
        }
    };

    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] fhs = new int[c.agP().length];

        static {
            try {
                fhs[c.fhA - 1] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                fhs[c.fhB - 1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                fhs[c.fhC - 1] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                fhs[c.fhD - 1] = 4;
            } catch (NoSuchFieldError e4) {
            }
            fhr = new int[com.tencent.mm.plugin.emoji.g.a.a.values().length];
            try {
                fhr[com.tencent.mm.plugin.emoji.g.a.a.Default.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                fhr[com.tencent.mm.plugin.emoji.g.a.a.Syncing.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                fhr[com.tencent.mm.plugin.emoji.g.a.a.PauseSync.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                fhr[com.tencent.mm.plugin.emoji.g.a.a.PauseSyncOffline.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
            try {
                fhr[com.tencent.mm.plugin.emoji.g.a.a.PauseSyncSDCardFull.ordinal()] = 5;
            } catch (NoSuchFieldError e9) {
            }
            try {
                fhr[com.tencent.mm.plugin.emoji.g.a.a.FinishSync.ordinal()] = 6;
            } catch (NoSuchFieldError e10) {
            }
            fhq = new int[a.values().length];
            try {
                fhq[a.EMPTY.ordinal()] = 1;
            } catch (NoSuchFieldError e11) {
            }
            try {
                fhq[a.START.ordinal()] = 2;
            } catch (NoSuchFieldError e12) {
            }
            try {
                fhq[a.PAUSE.ordinal()] = 3;
            } catch (NoSuchFieldError e13) {
            }
        }
    }

    private enum a {
        START,
        PAUSE,
        EMPTY
    }

    class b extends BaseAdapter {
        final /* synthetic */ EmojiCustomUI fhp;
        private ArrayList<com.tencent.mm.storage.a.c> fhy;
        private Animation fhz;

        public final /* synthetic */ Object getItem(int i) {
            return jP(i);
        }

        public b(EmojiCustomUI emojiCustomUI) {
            this.fhp = emojiCustomUI;
            this.fhz = AnimationUtils.loadAnimation(emojiCustomUI, 2130968658);
            this.fhz.setInterpolator(new LinearInterpolator());
        }

        public final int getCount() {
            return this.fhy == null ? 2 : this.fhy.size() + 2;
        }

        public final com.tencent.mm.storage.a.c jP(int i) {
            if (i < getCount() - 2 && this.fhy != null) {
                return (com.tencent.mm.storage.a.c) this.fhy.get(i);
            }
            return null;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final android.view.View getView(int r8, android.view.View r9, android.view.ViewGroup r10) {
            /*
            r7 = this;
            r6 = 8;
            r5 = 0;
            r4 = 0;
            if (r9 == 0) goto L_0x000c;
        L_0x0006:
            r0 = r9.getTag();
            if (r0 != 0) goto L_0x0067;
        L_0x000c:
            r0 = r7.fhp;
            r0 = r0.nDR;
            r0 = r0.nEl;
            r0 = android.view.LayoutInflater.from(r0);
            r1 = 2130903474; // 0x7f0301b2 float:1.7413767E38 double:1.052806201E-314;
            r9 = r0.inflate(r1, r4);
            r9.setVisibility(r5);
            r0 = new com.tencent.mm.plugin.emoji.ui.EmojiCustomUI$d;
            r0.<init>(r9);
            r9.setTag(r0);
            r1 = r0;
        L_0x0029:
            r0 = 1;
            r2 = r7.fhp;
            r2 = r2.fgT;
            r3 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.c.fhD;
            if (r2 == r3) goto L_0x003e;
        L_0x0034:
            r2 = r7.fhp;
            r2 = r2.fgT;
            r3 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.c.fhB;
            if (r2 != r3) goto L_0x003f;
        L_0x003e:
            r0 = 2;
        L_0x003f:
            r2 = r7.getCount();
            r2 = r2 - r0;
            if (r8 >= r2) goto L_0x007b;
        L_0x0046:
            r0 = r8 % 5;
            if (r0 != 0) goto L_0x0072;
        L_0x004a:
            r0 = r1.fhF;
            r2 = 2130838156; // 0x7f02028c float:1.7281286E38 double:1.0527739297E-314;
            r0.setBackgroundResource(r2);
        L_0x0052:
            r0 = r1.fhG;
            r0.clearAnimation();
            r0 = com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.AnonymousClass9.fhs;
            r2 = r7.fhp;
            r2 = r2.fgT;
            r2 = r2 + -1;
            r0 = r0[r2];
            switch(r0) {
                case 1: goto L_0x0092;
                case 2: goto L_0x012e;
                case 3: goto L_0x00dc;
                case 4: goto L_0x0195;
                default: goto L_0x0066;
            };
        L_0x0066:
            return r9;
        L_0x0067:
            r9.setVisibility(r5);
            r0 = r9.getTag();
            r0 = (com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.d) r0;
            r1 = r0;
            goto L_0x0029;
        L_0x0072:
            r0 = r1.fhF;
            r2 = 2130838161; // 0x7f020291 float:1.7281296E38 double:1.052773932E-314;
            r0.setBackgroundResource(r2);
            goto L_0x0052;
        L_0x007b:
            r2 = r7.getCount();
            r0 = r2 - r0;
            if (r8 != r0) goto L_0x008c;
        L_0x0083:
            r0 = r1.fhF;
            r2 = 2130838160; // 0x7f020290 float:1.7281294E38 double:1.0527739317E-314;
            r0.setBackgroundResource(r2);
            goto L_0x0052;
        L_0x008c:
            r0 = r1.fhF;
            r0.setBackgroundColor(r5);
            goto L_0x0052;
        L_0x0092:
            r0 = r7.getCount();
            r0 = r0 + -1;
            if (r8 != r0) goto L_0x00b1;
        L_0x009a:
            r0 = com.tencent.mm.ae.n.GL();
            r2 = "";
            r3 = r1.fhG;
            r0.a(r2, r3);
            r0 = r1.fhG;
            r0.setImageBitmap(r4);
        L_0x00ab:
            r0 = r1.fhH;
            r0.setVisibility(r6);
            goto L_0x0066;
        L_0x00b1:
            r0 = r7.getCount();
            r0 = r0 + -2;
            if (r8 != r0) goto L_0x00ce;
        L_0x00b9:
            r0 = com.tencent.mm.ae.n.GL();
            r2 = "";
            r3 = r1.fhG;
            r0.a(r2, r3);
            r0 = r1.fhG;
            r2 = 2131165479; // 0x7f070127 float:1.7945176E38 double:1.052935649E-314;
            r0.setImageResource(r2);
            goto L_0x00ab;
        L_0x00ce:
            r0 = r7.fhy;
            r0 = r0.get(r8);
            r0 = (com.tencent.mm.storage.a.c) r0;
            r2 = r1.fhG;
            r7.a(r2, r0);
            goto L_0x00ab;
        L_0x00dc:
            r0 = r7.getCount();
            r0 = r0 + -1;
            if (r8 != r0) goto L_0x00fc;
        L_0x00e4:
            r0 = com.tencent.mm.ae.n.GL();
            r2 = "";
            r3 = r1.fhG;
            r0.a(r2, r3);
            r0 = r1.fhG;
            r0.setImageBitmap(r4);
        L_0x00f5:
            r0 = r1.fhH;
            r0.setVisibility(r6);
            goto L_0x0066;
        L_0x00fc:
            r0 = r7.getCount();
            r0 = r0 + -2;
            if (r8 != r0) goto L_0x0120;
        L_0x0104:
            r0 = com.tencent.mm.ae.n.GL();
            r2 = "";
            r3 = r1.fhG;
            r0.a(r2, r3);
            r0 = r1.fhG;
            r2 = 2130838931; // 0x7f020593 float:1.7282858E38 double:1.0527743126E-314;
            r0.setImageResource(r2);
            r0 = r1.fhG;
            r2 = r7.fhz;
            r0.startAnimation(r2);
            goto L_0x00f5;
        L_0x0120:
            r0 = r7.fhy;
            r0 = r0.get(r8);
            r0 = (com.tencent.mm.storage.a.c) r0;
            r2 = r1.fhG;
            r7.a(r2, r0);
            goto L_0x00f5;
        L_0x012e:
            r0 = r7.getCount();
            r0 = r0 + -1;
            if (r8 != r0) goto L_0x014e;
        L_0x0136:
            r0 = com.tencent.mm.ae.n.GL();
            r2 = "";
            r3 = r1.fhG;
            r0.a(r2, r3);
            r0 = r1.fhG;
            r0.setImageBitmap(r4);
        L_0x0147:
            r0 = r1.fhH;
            r0.setVisibility(r6);
            goto L_0x0066;
        L_0x014e:
            r0 = r7.getCount();
            r0 = r0 + -2;
            if (r8 != r0) goto L_0x0168;
        L_0x0156:
            r0 = com.tencent.mm.ae.n.GL();
            r2 = "";
            r3 = r1.fhG;
            r0.a(r2, r3);
            r0 = r1.fhG;
            r0.setImageBitmap(r4);
            goto L_0x0147;
        L_0x0168:
            r0 = r7.fhy;
            r0 = r0.get(r8);
            r0 = (com.tencent.mm.storage.a.c) r0;
            r2 = r1.fhG;
            r7.a(r2, r0);
            r2 = r0.field_catalog;
            r3 = com.tencent.mm.storage.a.a.nwK;
            if (r2 == r3) goto L_0x0147;
        L_0x017b:
            r2 = r1.fhH;
            r2.setVisibility(r5);
            r1 = r1.fhH;
            r2 = r7.fhp;
            r2 = r2.fhh;
            r0 = r0.EB();
            r0 = r2.contains(r0);
            r1.setChecked(r0);
            goto L_0x0066;
        L_0x0195:
            r0 = r7.getCount();
            r0 = r0 + -1;
            if (r8 != r0) goto L_0x01af;
        L_0x019d:
            r0 = com.tencent.mm.ae.n.GL();
            r2 = "";
            r3 = r1.fhG;
            r0.a(r2, r3);
            r0 = r1.fhG;
            r0.setImageBitmap(r4);
            goto L_0x0147;
        L_0x01af:
            r0 = r7.getCount();
            r0 = r0 + -2;
            if (r8 != r0) goto L_0x01ca;
        L_0x01b7:
            r0 = com.tencent.mm.ae.n.GL();
            r2 = "";
            r3 = r1.fhG;
            r0.a(r2, r3);
            r0 = r1.fhG;
            r0.setImageBitmap(r4);
            goto L_0x0147;
        L_0x01ca:
            r0 = r7.fhy;
            r0 = r0.get(r8);
            r0 = (com.tencent.mm.storage.a.c) r0;
            r2 = r1.fhG;
            r7.a(r2, r0);
            goto L_0x0147;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.b.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
        }

        public final boolean agO() {
            ak.yW();
            if (com.tencent.mm.model.c.isSDCardAvailable()) {
                com.tencent.mm.storage.a.f fVar = com.tencent.mm.plugin.emoji.model.g.afx().fch;
                List arrayList = new ArrayList();
                Cursor rawQuery = fVar.cie.rawQuery("select * from EmojiInfo where catalog=? order by reserved3 asc", new String[]{com.tencent.mm.storage.a.a.nwL});
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToFirst();
                    do {
                        ak.yW();
                        com.tencent.mm.storage.a.c cVar = new com.tencent.mm.storage.a.c(com.tencent.mm.model.c.wY());
                        cVar.b(rawQuery);
                        arrayList.add(cVar);
                    } while (rawQuery.moveToNext());
                }
                rawQuery.close();
                this.fhy = (ArrayList) arrayList;
            } else {
                this.fhy = new ArrayList();
            }
            if (this.fhp.fgT == c.fhB) {
                int size = this.fhp.fhh == null ? 0 : this.fhp.fhh.size();
                this.fhp.Fd(this.fhp.getString(2131232359, new Object[]{Integer.valueOf(size)}));
            } else {
                this.fhp.Fd(this.fhp.getString(2131232337, new Object[]{Integer.valueOf(this.fhy.size())}));
            }
            return true;
        }

        private void a(ImageView imageView, com.tencent.mm.storage.a.c cVar) {
            imageView.setImageBitmap(null);
            String dR = cVar.dR(cVar.field_groupId, cVar.EB());
            String str = dR + "_cover";
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPx = 1;
            aVar.cPE = true;
            aVar.bdZ = str;
            aVar.cPu = dR;
            aVar.cPT = new Object[]{cVar};
            com.tencent.mm.ae.a.a.c GU = aVar.GU();
            n.GL().a(dR, imageView, GU, null, this.fhp.fhn);
        }
    }

    private enum c {
        ;

        public static int[] agP() {
            return (int[]) fhE.clone();
        }

        static {
            fhA = 1;
            fhB = 2;
            fhC = 3;
            fhD = 4;
            fhE = new int[]{fhA, fhB, fhC, fhD};
        }
    }

    static class d {
        View fhF;
        ImageView fhG;
        CheckBox fhH;

        public d(View view) {
            this.fhF = view.findViewById(2131755464);
            this.fhG = (ImageView) view.findViewById(2131755052);
            this.fhH = (CheckBox) view.findViewById(2131756633);
        }
    }

    static /* synthetic */ void d(EmojiCustomUI emojiCustomUI) {
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "topCustom mSelectedList size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(emojiCustomUI.fhh == null ? 0 : emojiCustomUI.fhh.size());
        v.i(str, str2, objArr);
        if (emojiCustomUI.fhh == null || emojiCustomUI.fhh.size() <= 0) {
            v.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            return;
        }
        emojiCustomUI.rK(emojiCustomUI.getString(2131232441));
        ArrayList arrayList = emojiCustomUI.fhh;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "topSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        v.i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            v.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
        } else {
            ak.vy().a(new com.tencent.mm.plugin.emoji.e.c(3, emojiCustomUI.fhh), 0);
        }
    }

    static /* synthetic */ void g(EmojiCustomUI emojiCustomUI) {
        v.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateSyncView status:%s]", new Object[]{emojiCustomUI.fgZ.toString()});
        if (emojiCustomUI.fgT != c.fhB && !emojiCustomUI.fhe) {
            switch (emojiCustomUI.fgZ) {
                case Default:
                    emojiCustomUI.fhf = false;
                    emojiCustomUI.U(0, true);
                    emojiCustomUI.agK();
                    emojiCustomUI.jO(c.fhA);
                    return;
                case Syncing:
                    emojiCustomUI.U(0, false);
                    com.tencent.mm.plugin.emoji.model.g.afu();
                    if (com.tencent.mm.plugin.emoji.g.c.aeT()) {
                        emojiCustomUI.fhf = false;
                        emojiCustomUI.fha.setVisibility(0);
                        emojiCustomUI.a(a.PAUSE);
                        emojiCustomUI.cv(true);
                    } else {
                        com.tencent.mm.plugin.emoji.model.g.afu();
                        if (com.tencent.mm.plugin.emoji.g.c.afX() && !emojiCustomUI.fhf) {
                            emojiCustomUI.fhf = true;
                            emojiCustomUI.agK();
                            emojiCustomUI.a(a.EMPTY);
                        }
                    }
                    if (emojiCustomUI.fgT != c.fhC) {
                        emojiCustomUI.jO(c.fhC);
                        return;
                    }
                    return;
                case PauseSync:
                    emojiCustomUI.fhf = false;
                    emojiCustomUI.U(0, false);
                    if (emojiCustomUI.mHandler != null) {
                        emojiCustomUI.mHandler.removeMessages(1003);
                    }
                    emojiCustomUI.fha.setVisibility(0);
                    emojiCustomUI.cv(false);
                    emojiCustomUI.a(a.START);
                    emojiCustomUI.jO(c.fhD);
                    return;
                case PauseSyncOffline:
                    emojiCustomUI.fhf = false;
                    emojiCustomUI.U(0, false);
                    emojiCustomUI.agK();
                    emojiCustomUI.jO(c.fhD);
                    return;
                case PauseSyncSDCardFull:
                    emojiCustomUI.fhf = false;
                    emojiCustomUI.U(0, true);
                    emojiCustomUI.fha.setVisibility(0);
                    int bxQ = com.tencent.mm.plugin.emoji.model.g.afx().fch.bxQ();
                    int i = com.tencent.mm.plugin.emoji.model.g.afu().feA.feL;
                    emojiCustomUI.fhb.setText(2131232431);
                    emojiCustomUI.fhb.setText(String.format(emojiCustomUI.getString(2131232431), new Object[]{Integer.valueOf(i - bxQ), Integer.valueOf(i)}));
                    emojiCustomUI.fhc.setVisibility(4);
                    emojiCustomUI.jO(c.fhD);
                    return;
                case FinishSync:
                    emojiCustomUI.fhf = false;
                    emojiCustomUI.U(0, true);
                    emojiCustomUI.agK();
                    emojiCustomUI.jO(c.fhA);
                    return;
                default:
                    return;
            }
        }
    }

    static /* synthetic */ void j(EmojiCustomUI emojiCustomUI) {
        String str = "MicroMsg.emoji.EmojiCustomUI";
        String str2 = "deleteEmoji mSelectedList size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(emojiCustomUI.fhh == null ? 0 : emojiCustomUI.fhh.size());
        v.i(str, str2, objArr);
        if (emojiCustomUI.fhh == null || emojiCustomUI.fhh.size() <= 0) {
            v.w("MicroMsg.emoji.EmojiCustomUI", "empty seleted list");
            return;
        }
        emojiCustomUI.rK(emojiCustomUI.getString(2131232340));
        ArrayList arrayList = emojiCustomUI.fhh;
        str2 = "MicroMsg.emoji.EmojiCustomUI";
        String str3 = "deleteSyncEmoji list size:%d";
        Object[] objArr2 = new Object[1];
        objArr2[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
        v.i(str2, str3, objArr2);
        if (arrayList == null || arrayList.size() <= 0) {
            v.i("MicroMsg.emoji.EmojiCustomUI", "empty size.");
        } else {
            ak.vy().a(new com.tencent.mm.plugin.emoji.e.c(2, emojiCustomUI.fhh), 0);
        }
        v.i("MicroMsg.emoji.EmojiCustomUI", "touchBatchEmojiBackup over emoji size. need touch :%b", new Object[]{Boolean.valueOf(emojiCustomUI.fhd)});
        if (emojiCustomUI.fhd) {
            emojiCustomUI.fhd = false;
            ak.yW();
            com.tencent.mm.model.c.vf().set(348162, Boolean.valueOf(true));
            com.tencent.mm.plugin.emoji.b.a.aeP();
        }
        emojiCustomUI.agL();
    }

    private void a(a aVar) {
        v.i("MicroMsg.emoji.EmojiCustomUI", "dz[updateButtonType,button type:%s]", new Object[]{aVar.toString()});
        this.fhg = aVar;
        switch (aVar) {
            case EMPTY:
                this.fhc.setVisibility(4);
                return;
            case START:
                this.fhc.setVisibility(0);
                this.fhc.setText(2131232432);
                return;
            case PAUSE:
                this.fhc.setVisibility(0);
                this.fhc.setText(2131232433);
                return;
            default:
                return;
        }
    }

    private void cv(boolean z) {
        int bxQ = com.tencent.mm.plugin.emoji.model.g.afx().fch.bxQ();
        int i = com.tencent.mm.plugin.emoji.model.g.afu().feA.feL;
        if (bxQ != i || z) {
            int i2;
            if (i == 0) {
                i2 = bxQ;
            } else {
                i2 = 0;
            }
            i += i2;
            this.fhb.setText(String.format(getString(z ? 2131232437 : 2131232430), new Object[]{Integer.valueOf(i - bxQ), Integer.valueOf(i)}));
            return;
        }
        this.fhb.setText(2131232435);
    }

    public void onCreate(Bundle bundle) {
        long currentTimeMillis = System.currentTimeMillis();
        super.onCreate(bundle);
        this.fgU = new b(this);
        this.fgU.agO();
        NI();
        com.tencent.mm.plugin.emoji.model.g.afu().cu(true);
        jO(c.fhA);
        ak.yW();
        v.i("MicroMsg.emoji.EmojiCustomUI", "[cpan] touch batch emoji download from EmojiCustomUI needDownload:%b", new Object[]{Boolean.valueOf(((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noK, Boolean.valueOf(true))).booleanValue())});
        if (((Boolean) com.tencent.mm.model.c.vf().get(com.tencent.mm.storage.t.a.noK, Boolean.valueOf(true))).booleanValue()) {
            ak.vy().a(new com.tencent.mm.plugin.emoji.e.e(), 0);
        }
        com.tencent.mm.plugin.emoji.model.g.afx().fch.c(this.fhl);
        com.tencent.mm.plugin.report.service.g.iuh.a(406, 9, 1, false);
        com.tencent.mm.plugin.report.service.g.iuh.a(406, 11, System.currentTimeMillis() - currentTimeMillis, false);
    }

    protected void onResume() {
        super.onResume();
        com.tencent.mm.plugin.emoji.g.a afu = com.tencent.mm.plugin.emoji.model.g.afu();
        com.tencent.mm.plugin.emoji.g.d dVar = this.fhm;
        com.tencent.mm.plugin.emoji.g.c cVar = afu.feA;
        if (cVar.feZ == null) {
            cVar.feZ = new HashSet();
        }
        if (!cVar.feZ.contains(dVar)) {
            cVar.feZ.add(dVar);
        }
        agL();
        ak.vy().a(698, this);
    }

    protected void onPause() {
        super.onPause();
        com.tencent.mm.plugin.emoji.g.a afu = com.tencent.mm.plugin.emoji.model.g.afu();
        com.tencent.mm.plugin.emoji.g.d dVar = this.fhm;
        com.tencent.mm.plugin.emoji.g.c cVar = afu.feA;
        if (cVar.feZ == null) {
            cVar.feZ = new HashSet();
        }
        if (cVar.feZ.contains(dVar)) {
            cVar.feZ.remove(dVar);
        }
        ak.vy().b(698, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.emoji.model.g.afx().fch.d(this.fhl);
        com.tencent.mm.plugin.emoji.model.g.afu().cu(false);
        com.tencent.mm.plugin.emoji.g.c cVar = com.tencent.mm.plugin.emoji.model.g.afu().feA;
        if (cVar.feR) {
            cVar.feR = false;
        }
    }

    protected final int getLayoutId() {
        return 2130903473;
    }

    protected final int NO() {
        return 1;
    }

    protected final void NI() {
        this.fha = getLayoutInflater().inflate(2130903475, null);
        this.fhb = (TextView) this.fha.findViewById(2131756635);
        this.fhc = (Button) this.fha.findViewById(2131756636);
        this.fhc.setOnClickListener(this.fhi);
        this.fgV = (HeaderGridView) findViewById(2131756629);
        HeaderGridView headerGridView = this.fgV;
        View view = this.fha;
        ListAdapter adapter = headerGridView.getAdapter();
        if (adapter == null || (adapter instanceof c)) {
            a aVar = new a();
            ViewGroup bVar = new b(headerGridView, headerGridView.getContext());
            bVar.addView(view);
            aVar.view = view;
            aVar.nSF = bVar;
            aVar.data = null;
            aVar.isSelectable = false;
            headerGridView.nSE.add(aVar);
            if (adapter != null) {
                ((c) adapter).nSH.notifyChanged();
            }
            this.fgV.a(this.fgU);
            this.fgV.setOnItemClickListener(this);
            this.fgV.setFocusableInTouchMode(false);
            this.fgW = findViewById(2131756630);
            this.fgX = (Button) findViewById(2131756632);
            this.fgX.setOnClickListener(this.fhj);
            this.fgY = (Button) findViewById(2131756631);
            this.fgY.setOnClickListener(this.fhk);
            return;
        }
        throw new IllegalStateException("Cannot add header view to grid -- setAdapter has already been called.");
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.fgU != null) {
            int size = i - (this.fgV.nSE.size() * 5);
            if (this.fgT == c.fhA && size == this.fgU.getCount() - 2) {
                ak.yW();
                if (com.tencent.mm.model.c.isSDCardAvailable()) {
                    if (agM() - 1 >= o.afk()) {
                        g.a(this, getString(2131232444), "", new DialogInterface.OnClickListener(this) {
                            final /* synthetic */ EmojiCustomUI fhp;

                            {
                                this.fhp = r1;
                            }

                            public final void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });
                    } else {
                        l.S(this);
                    }
                    com.tencent.mm.plugin.report.service.g.iuh.h(11596, new Object[]{Integer.valueOf(0)});
                } else {
                    s.ey(this);
                    return;
                }
            }
            if (this.fgT == c.fhB && size < this.fgU.getCount() - 2) {
                com.tencent.mm.storage.a.c jP = this.fgU.jP(size);
                d dVar = null;
                if (view != null) {
                    dVar = (d) view.getTag();
                }
                if (jP.field_catalog == com.tencent.mm.storage.a.a.nwK) {
                    g.f(this.nDR.nEl, 2131231769, 2131231769).show();
                } else if (this.fhh.contains(jP.EB())) {
                    r2 = jP.EB();
                    if (this.fhh != null) {
                        this.fhh.remove(r2);
                    }
                    if (dVar != null) {
                        dVar.fhH.setChecked(false);
                        this.fgU.notifyDataSetChanged();
                    }
                    v.i("MicroMsg.emoji.EmojiCustomUI", "unselected md5:%s", new Object[]{jP.EB()});
                } else {
                    r2 = jP.EB();
                    if (this.fhh != null) {
                        this.fhh.add(r2);
                    }
                    if (dVar != null) {
                        dVar.fhH.setChecked(true);
                    }
                    v.i("MicroMsg.emoji.EmojiCustomUI", "selected md5:%s", new Object[]{jP.EB()});
                }
                agJ();
                if (dVar == null) {
                    this.fgU.notifyDataSetChanged();
                }
            }
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        v.d("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: requestCode[%d],resultCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (i2 == -1) {
            switch (i) {
                case 205:
                    if (intent != null) {
                        Intent intent2 = new Intent();
                        intent2.putExtra("CropImageMode", 3);
                        ak.yW();
                        intent2.putExtra("CropImage_OutputPath", com.tencent.mm.model.c.wY());
                        com.tencent.mm.plugin.emoji.a.drp.a(intent2, 206, this, intent);
                        return;
                    }
                    return;
                case 206:
                    if (intent == null) {
                        v.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult MAT_IMAGE_IN_CROP_ACTIVITY return null.");
                        return;
                    }
                    String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                    final int intExtra = intent.getIntExtra("emoji_type", 0);
                    if (stringExtra != null && stringExtra.length() > 0) {
                        stringExtra = stringExtra.substring(stringExtra.lastIndexOf(47) + 1);
                        StringBuilder stringBuilder = new StringBuilder();
                        ak.yW();
                        String stringBuilder2 = stringBuilder.append(com.tencent.mm.model.c.wY()).append(stringExtra).toString();
                        this.fho = com.tencent.mm.plugin.emoji.model.g.afx().fch.NF(stringExtra);
                        com.tencent.mm.ui.tools.a.b PE = com.tencent.mm.ui.tools.a.b.PE(stringBuilder2);
                        PE.hO = com.tencent.mm.h.b.sH();
                        PE.ym(com.tencent.mm.h.b.sI()).a(new com.tencent.mm.ui.tools.a.b.a(this) {
                            final /* synthetic */ EmojiCustomUI fhp;

                            public final void a(com.tencent.mm.ui.tools.a.b bVar) {
                                if (this.fhp.fho == null) {
                                    if (intExtra == 0) {
                                        this.fhp.fho = com.tencent.mm.plugin.emoji.model.g.afx().fch.b(stringExtra, "", com.tencent.mm.storage.a.a.nwM, com.tencent.mm.storage.a.c.nwS, bVar.oWu, "");
                                    } else {
                                        this.fhp.fho = com.tencent.mm.plugin.emoji.model.g.afx().fch.b(stringExtra, "", com.tencent.mm.storage.a.a.nwM, com.tencent.mm.storage.a.c.nwT, bVar.oWu, "");
                                    }
                                }
                                com.tencent.mm.plugin.emoji.model.g.aft().a(this.fhp.nDR.nEl, this.fhp.fho, 1, k.xF());
                                if (this.fhp.fgU != null) {
                                    this.fhp.fgU.agO();
                                    this.fhp.fgU.notifyDataSetChanged();
                                }
                            }

                            public final void agF() {
                                g.a(this.fhp.nDR.nEl, this.fhp.nDR.nEl.getString(2131232335), "", this.fhp.nDR.nEl.getString(2131233285), false, null);
                            }
                        });
                        return;
                    }
                    return;
                case 214:
                    if (this.fgU != null) {
                        this.fgU.agO();
                        this.fgU.notifyDataSetChanged();
                        return;
                    }
                    return;
                default:
                    v.e("MicroMsg.emoji.EmojiCustomUI", "onActivityResult: not found this requestCode");
                    return;
            }
        }
    }

    public void onBackPressed() {
        if (this.fgT == c.fhB) {
            jO(c.fhA);
        } else {
            super.onBackPressed();
        }
    }

    private void jO(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        this.fgT = i;
        switch (AnonymousClass9.fhs[i - 1]) {
            case 1:
                b(new OnMenuItemClickListener(this) {
                    final /* synthetic */ EmojiCustomUI fhp;

                    {
                        this.fhp = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.fhp.finish();
                        return true;
                    }
                });
                iS(true);
                a(0, getString(2131232372), new OnMenuItemClickListener(this) {
                    final /* synthetic */ EmojiCustomUI fhp;

                    {
                        this.fhp = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.fhp.jO(c.fhB);
                        com.tencent.mm.plugin.report.service.g.iuh.h(11596, new Object[]{Integer.valueOf(1)});
                        return true;
                    }
                });
                this.fgW.setVisibility(8);
                agL();
                agH();
                break;
            case 2:
                b(new OnMenuItemClickListener(this) {
                    final /* synthetic */ EmojiCustomUI fhp;

                    {
                        this.fhp = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.fhp.jO(c.fhA);
                        return true;
                    }
                });
                a(0, getString(2131231065), new OnMenuItemClickListener(this) {
                    final /* synthetic */ EmojiCustomUI fhp;

                    {
                        this.fhp = r1;
                    }

                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        this.fhp.jO(c.fhA);
                        return true;
                    }
                });
                this.fgW.setVisibility(0);
                agK();
                agJ();
                break;
            case 3:
                agI();
                break;
            case 4:
                break;
        }
        agI();
        if (this.fgU != null) {
            this.fgU.agO();
            this.fgU.notifyDataSetChanged();
        }
        v.d("MicroMsg.emoji.EmojiCustomUI", "updateMode use time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void agH() {
        if (this.fhh != null) {
            this.fhh.clear();
        }
        v.i("MicroMsg.emoji.EmojiCustomUI", "clear md5 list. updateMode NORMAL");
    }

    private void agI() {
        this.fgW.setVisibility(this.fgT == c.fhB ? 0 : 8);
    }

    private void agJ() {
        if (this.fgT == c.fhB) {
            if ((this.fhh == null ? 0 : this.fhh.size()) > 0) {
                this.fgX.setText(getResources().getString(2131231020));
                this.fgX.setEnabled(true);
                this.fgY.setEnabled(true);
            } else {
                this.fgX.setText(getResources().getString(2131231020));
                this.fgX.setEnabled(false);
                this.fgY.setEnabled(false);
            }
            Fd(getResources().getString(2131232359, new Object[]{Integer.valueOf(r0)}));
        }
    }

    private boolean rJ(String str) {
        g.b(this.nDR.nEl, str, "", "", getString(2131233285), null, null);
        return true;
    }

    private void agK() {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessageDelayed(1003, 0);
        }
    }

    private void agL() {
        boolean z = true;
        com.tencent.mm.plugin.emoji.model.g.afu();
        if (com.tencent.mm.sdk.platformtools.ak.isConnected(aa.getContext())) {
            if (agM() > o.afk()) {
                this.fhd = true;
                this.fha.setVisibility(0);
                this.fhb.setTextColor(getResources().getColor(2131689960));
                this.fhb.setText(getString(2131232429, new Object[]{Integer.valueOf(o.afk())}));
                this.fhc.setVisibility(8);
                this.fgU.notifyDataSetChanged();
                U(0, true);
                this.fhe = true;
            } else {
                z = false;
            }
            if (!z) {
                this.fhe = false;
                return;
            }
            return;
        }
        agK();
    }

    private int agM() {
        if (this.fgU != null) {
            return this.fgU.getCount() - 2;
        }
        return 0;
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        v.i("MicroMsg.emoji.EmojiCustomUI", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (kVar instanceof com.tencent.mm.plugin.emoji.e.c) {
            switch (((com.tencent.mm.plugin.emoji.e.c) kVar).cKy) {
                case 2:
                    agt();
                    if (i == 0 && i2 == 0) {
                        for (int i3 = 0; i3 < this.fhh.size(); i3++) {
                            v.i("MicroMsg.emoji.EmojiCustomUI", "mSelectedList md5:%s", new Object[]{this.fhh.get(i3)});
                            com.tencent.mm.plugin.report.service.g.iuh.Y(10613, (String) this.fhh.get(i3));
                        }
                        com.tencent.mm.plugin.emoji.g.a afu = com.tencent.mm.plugin.emoji.model.g.afu();
                        ArrayList arrayList = this.fhh;
                        com.tencent.mm.plugin.emoji.g.c cVar = afu.feA;
                        String str2 = "MicroMsg.BKGLoader.BKGLoaderManager";
                        String str3 = "cleanUploadTasks size%s";
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(arrayList == null ? 0 : arrayList.size());
                        v.i(str2, str3, objArr);
                        if (cVar.feX != null && arrayList != null && cVar.feX.size() > 0 && arrayList.size() > 0) {
                            com.tencent.mm.plugin.emoji.g.e eVar;
                            ArrayList arrayList2 = new ArrayList();
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                String str4 = (String) it.next();
                                if (!be.kS(str4)) {
                                    Iterator it2 = cVar.feX.iterator();
                                    while (it2.hasNext()) {
                                        eVar = (com.tencent.mm.plugin.emoji.g.e) it2.next();
                                        if (!be.kS(eVar.getKey()) && eVar.getKey().equalsIgnoreCase(str4)) {
                                            arrayList2.add(eVar);
                                        }
                                    }
                                }
                            }
                            if (cVar.feX != null && cVar.feX.size() > 0 && arrayList2.size() > 0) {
                                Iterator it3 = arrayList2.iterator();
                                while (it3.hasNext()) {
                                    cVar.feX.remove((com.tencent.mm.plugin.emoji.g.e) it3.next());
                                    v.i("MicroMsg.BKGLoader.BKGLoaderManager", "clean upload task :%s", new Object[]{eVar.getKey()});
                                }
                            }
                            arrayList2.clear();
                        }
                        com.tencent.mm.plugin.emoji.model.g.afx().fch.ci(this.fhh);
                        agH();
                        agJ();
                        this.mHandler.sendEmptyMessageDelayed(1004, 100);
                        return;
                    }
                    v.i("MicroMsg.emoji.EmojiCustomUI", "delete failed");
                    rJ(getString(2131232440));
                    return;
                case 3:
                    agt();
                    if (i == 0 && i2 == 0) {
                        com.tencent.mm.plugin.emoji.model.g.afx().fch.cj(this.fhh);
                        agH();
                        agJ();
                        this.mHandler.sendEmptyMessageDelayed(1004, 100);
                        return;
                    }
                    rJ(getString(2131232440));
                    return;
                default:
                    return;
            }
        }
        v.w("MicroMsg.emoji.EmojiCustomUI", "no emoji operate");
    }

    private void rK(String str) {
        getString(2131231164);
        this.eZg = g.a(this, str, true, new OnCancelListener(this) {
            final /* synthetic */ EmojiCustomUI fhp;

            {
                this.fhp = r1;
            }

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
    }

    private void agt() {
        if (this.eZg != null && this.eZg.isShowing()) {
            this.eZg.dismiss();
        }
    }
}
