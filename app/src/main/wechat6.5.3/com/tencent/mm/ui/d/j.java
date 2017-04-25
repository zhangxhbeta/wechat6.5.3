package com.tencent.mm.ui.d;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.aw.a;
import com.tencent.mm.model.a.d;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.au;
import com.tencent.mm.model.av;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.modelfriend.n;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.bindgooglecontact.BindGoogleContactIntroUI;
import com.tencent.mm.ui.bindgooglecontact.GoogleFriendUI;
import com.tencent.mm.ui.bindmobile.BindMContactIntroUI;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class j extends b {
    protected au nQV = null;

    static /* synthetic */ void k(Context context, boolean z) {
        if (context != null) {
            Intent intent = new Intent();
            intent.setClass(context, BindMContactIntroUI.class);
            intent.putExtra("key_upload_scene", 8);
            intent.putExtra("is_bind_for_contact_sync", z);
            intent.putExtra("KEnterFromBanner", true);
            MMWizardActivity.w(context, intent);
            d ga = f.Aj().ga("4");
            if (ga != null && !be.kS(ga.value) && (ga.value.equals("1") || ga.value.equals("2"))) {
                f.Aj().ga("4").bfz = "1";
                e.gf("4");
                if (ga.value.equals("1")) {
                    ak.yW();
                    c.vf().set(328195, Boolean.valueOf(true));
                    return;
                }
                ak.yW();
                c.vf().set(328196, Boolean.valueOf(true));
            } else if (z) {
                g.iuh.h(11002, Integer.valueOf(3), Integer.valueOf(1));
            } else {
                g.iuh.h(11002, Integer.valueOf(1), Integer.valueOf(1));
            }
        }
    }

    public j(Context context, au auVar) {
        super(context);
        this.nQV = auVar;
        if (this.view != null) {
            OnClickListener anonymousClass5;
            MMImageView mMImageView = (MMImageView) this.view.findViewById(2131758023);
            TextView textView = (TextView) this.view.findViewById(2131758024);
            switch (this.nQV.type) {
                case 1:
                    mMImageView.setImageResource(2131165988);
                    textView.setText(2131231368);
                    break;
                case 2:
                    mMImageView.setImageResource(2131165989);
                    textView.setText(2131232795);
                    break;
                case 3:
                    mMImageView.setImageResource(2131165987);
                    textView.setText(2131231376);
                    break;
                case 4:
                    mMImageView.setImageResource(2131165995);
                    textView.setText(2131231370);
                    break;
                case 5:
                    mMImageView.setImageResource(2131165992);
                    textView.setText(2131231367);
                    break;
                case 6:
                    mMImageView.setImageResource(2131165990);
                    textView.setText(2131231374);
                    break;
                case 7:
                    mMImageView.setImageResource(2131165991);
                    textView.setText(2131231373);
                    break;
                case 8:
                    mMImageView.setImageResource(2131165993);
                    textView.setText(2131231375);
                    break;
                case 9:
                    mMImageView.setImageResource(2131165994);
                    textView.setText(2131231371);
                    break;
                case 10:
                    mMImageView.setImageResource(2131165986);
                    textView.setText(2131231365);
                    break;
            }
            View view = this.view;
            final int i = this.nQV.type;
            final int i2 = this.nQV.aXx;
            switch (i) {
                case 1:
                    anonymousClass5 = new OnClickListener(this) {
                        final /* synthetic */ j nQX;

                        public final void onClick(View view) {
                            av.zh().aE(i, i2);
                            j.k((Context) this.nQX.lKT.get(), false);
                        }
                    };
                    break;
                case 2:
                    anonymousClass5 = new OnClickListener(this) {
                        final /* synthetic */ j nQX;

                        public final void onClick(View view) {
                            av.zh().aE(i, i2);
                            j.k((Context) this.nQX.lKT.get(), true);
                        }
                    };
                    break;
                case 3:
                    anonymousClass5 = new OnClickListener(this) {
                        final /* synthetic */ j nQX;

                        public final void onClick(View view) {
                            av.zh().aE(i, i2);
                            Context context = (Context) this.nQX.lKT.get();
                            if (context != null) {
                                ak.yW();
                                if (c.isSDCardAvailable()) {
                                    Intent intent = new Intent();
                                    intent.putExtra("intent_set_avatar", true);
                                    intent.putExtra("KEnterFromBanner", true);
                                    com.tencent.mm.ay.c.b(context, "setting", ".ui.setting.SettingsPersonalInfoUI", intent);
                                    g.iuh.h(11002, Integer.valueOf(4), Integer.valueOf(1));
                                    return;
                                }
                                s.ey(context);
                            }
                        }
                    };
                    break;
                case 4:
                    anonymousClass5 = new OnClickListener(this) {
                        final /* synthetic */ j nQX;

                        public final void onClick(View view) {
                            av.zh().aE(i, i2);
                            Context context = (Context) this.nQX.lKT.get();
                            if (context != null) {
                                g.iuh.h(11002, Integer.valueOf(5), Integer.valueOf(1));
                                ak.yW();
                                boolean c = be.c((Boolean) c.vf().get(4103, null));
                                new Intent().putExtra("KEnterFromBanner", true);
                                if (c) {
                                    bf zP = bf.zP();
                                    if (zP == null) {
                                        com.tencent.mm.ay.c.w(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                        return;
                                    }
                                    String ma = be.ma(zP.getProvince());
                                    int a = be.a(Integer.valueOf(zP.bBZ), 0);
                                    if (be.kS(ma) || a == 0) {
                                        com.tencent.mm.ay.c.w(context, "nearby", ".ui.NearbyPersonalInfoUI");
                                        return;
                                    }
                                    LauncherUI bzB = LauncherUI.bzB();
                                    if (bzB != null) {
                                        bzB.NX("tab_find_friend");
                                    }
                                    a.cU(context);
                                    return;
                                }
                                com.tencent.mm.ay.c.w(context, "nearby", ".ui.NearbyFriendsIntroUI");
                            }
                        }
                    };
                    break;
                case 5:
                    anonymousClass5 = new OnClickListener(this) {
                        final /* synthetic */ j nQX;

                        public final void onClick(View view) {
                            av.zh().aE(i, i2);
                            Context context = (Context) this.nQX.lKT.get();
                            if (context != null) {
                                Intent intent;
                                if (!n.Fg()) {
                                    intent = new Intent(context, BindGoogleContactIntroUI.class);
                                    intent.putExtra("enter_scene", 1);
                                    intent.putExtra("KEnterFromBanner", true);
                                    MMWizardActivity.w(context, intent);
                                }
                                intent = new Intent(context, GoogleFriendUI.class);
                                intent.putExtra("enter_scene", 1);
                                intent.putExtra("KEnterFromBanner", true);
                                context.startActivity(intent);
                                g.iuh.h(11002, Integer.valueOf(6), Integer.valueOf(1));
                            }
                        }
                    };
                    break;
                case 6:
                    anonymousClass5 = new OnClickListener(this) {
                        final /* synthetic */ j nQX;

                        public final void onClick(View view) {
                            av.zh().aE(i, i2);
                            Context context = (Context) this.nQX.lKT.get();
                            Intent intent = new Intent();
                            intent.putExtra("preceding_scence", 17);
                            com.tencent.mm.ay.c.b(context, "emoji", ".ui.v2.EmojiStoreV2UI", intent);
                            g.iuh.h(11002, Integer.valueOf(10), Integer.valueOf(1));
                            g.iuh.h(12065, Integer.valueOf(2));
                        }
                    };
                    break;
                case 7:
                    anonymousClass5 = new OnClickListener(this) {
                        final /* synthetic */ j nQX;

                        public final void onClick(View view) {
                            av.zh().aE(i, i2);
                            com.tencent.mm.ay.c.w((Context) this.nQX.lKT.get(), "game", ".ui.GameCenterUI");
                            g.iuh.h(11002, Integer.valueOf(9), Integer.valueOf(1));
                        }
                    };
                    break;
                case 8:
                    anonymousClass5 = new OnClickListener(this) {
                        final /* synthetic */ j nQX;

                        public final void onClick(View view) {
                            int i;
                            av.zh().aE(i, i2);
                            Context context = (Context) this.nQX.lKT.get();
                            if ((k.xQ() & 65536) == 0) {
                                i = 1;
                            } else {
                                i = 0;
                            }
                            if (i != 0) {
                                com.tencent.mm.ay.c.w(context, "masssend", ".ui.MassSendHistoryUI");
                            } else {
                                com.tencent.mm.ay.c.b(context, "profile", ".ui.ContactInfoUI", new Intent().putExtra("Contact_User", "masssendapp"));
                            }
                            g.iuh.h(11002, Integer.valueOf(11), Integer.valueOf(1));
                        }
                    };
                    break;
                case 9:
                    anonymousClass5 = new OnClickListener(this) {
                        final /* synthetic */ j nQX;

                        public final void onClick(View view) {
                            boolean z;
                            av.zh().aE(i, i2);
                            Context context = (Context) this.nQX.lKT.get();
                            ak.yW();
                            String str = (String) c.vf().get(68377, null);
                            ak.yW();
                            c.vf().set(68377, SQLiteDatabase.KeyEmpty);
                            Intent intent = new Intent();
                            intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                            if (be.kS(str)) {
                                z = true;
                            } else {
                                z = false;
                            }
                            if (com.tencent.mm.pluginsdk.j.ak.lyg != null && com.tencent.mm.pluginsdk.j.ak.lyg.Kw() > 0) {
                                z = false;
                            }
                            intent.putExtra("sns_resume_state", z);
                            com.tencent.mm.ay.c.b(context, "sns", ".ui.SnsTimeLineUI", intent);
                            g.iuh.h(11002, Integer.valueOf(8), Integer.valueOf(1));
                        }
                    };
                    break;
                case 10:
                    anonymousClass5 = new OnClickListener(this) {
                        final /* synthetic */ j nQX;

                        public final void onClick(View view) {
                            av.zh().aE(i, i2);
                            com.tencent.mm.ay.c.b((Context) this.nQX.lKT.get(), "subapp", ".ui.autoadd.AutoAddFriendUI", new Intent());
                        }
                    };
                    break;
                default:
                    anonymousClass5 = null;
                    break;
            }
            view.setOnClickListener(anonymousClass5);
        }
    }

    public final int getLayoutId() {
        return 2130903923;
    }

    public final void destroy() {
    }
}
