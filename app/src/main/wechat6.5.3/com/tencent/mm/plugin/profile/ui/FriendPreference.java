package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.a.o;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.modelfriend.b;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.u.d;
import com.tencent.mm.u.d.a;
import com.tencent.mm.u.e;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.List;
import junit.framework.Assert;

public class FriendPreference extends Preference implements a {
    private MMActivity aWn;
    private TextView dtB;
    private u euW;
    private boolean fyL;
    private TextView hWl;
    private ImageView hWm;
    private ImageView hWn;
    private b hWo;
    private String hWp;
    private long hWq;
    private long hWr;
    private int hWs;
    private String hWt;

    public final /* synthetic */ CharSequence getSummary() {
        return this.hWl.getText().toString();
    }

    static /* synthetic */ void a(FriendPreference friendPreference, String str) {
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setFlags(268435456);
        intent.setData(Uri.parse("tel:" + str));
        friendPreference.aWn.startActivity(intent);
    }

    static /* synthetic */ void a(FriendPreference friendPreference, final String str, final String str2) {
        if (be.kS(str) || be.kS(str2)) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(2131232148), 0).show();
            return;
        }
        n.AX();
        Bitmap gJ = d.gJ(str);
        if (gJ == null) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(2131232149), 0).show();
            final e eVar = new e();
            eVar.a(str, new e.b(friendPreference) {
                final /* synthetic */ FriendPreference hWv;

                public final int aG(int i, int i2) {
                    eVar.Bb();
                    v.i("MicroMsg.FriendPreference", "onSceneEnd: errType=%d, errCode=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
                    if (i == 0 && i2 == 0) {
                        n.AX();
                        if (this.hWv.o(str2, d.gJ(str))) {
                            Toast.makeText(this.hWv.mContext, this.hWv.mContext.getString(2131232150), 0).show();
                            return 0;
                        }
                    }
                    Toast.makeText(this.hWv.mContext, this.hWv.mContext.getString(2131232148), 0).show();
                    return 0;
                }
            });
        } else if (friendPreference.o(str2, gJ)) {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(2131232150), 0).show();
        } else {
            Toast.makeText(friendPreference.mContext, friendPreference.mContext.getString(2131232148), 0).show();
        }
    }

    public FriendPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.aWn = (MMActivity) context;
        init();
    }

    public FriendPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setLayoutResource(2130903996);
        setWidgetLayoutResource(2130904064);
        init();
    }

    private void init() {
        this.fyL = false;
        this.euW = null;
        this.hWo = null;
        this.hWp = "";
        this.hWq = 0;
        this.hWr = 0;
        this.hWs = 0;
        this.hWt = "";
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        viewGroup2.removeAllViews();
        layoutInflater.inflate(2130904013, viewGroup2);
        return onCreateView;
    }

    public final void onBindView(View view) {
        this.dtB = (TextView) view.findViewById(2131755226);
        this.hWl = (TextView) view.findViewById(2131756108);
        this.hWm = (ImageView) view.findViewById(2131756901);
        this.hWn = (ImageView) view.findViewById(2131758288);
        this.fyL = true;
        NI();
        super.onBindView(view);
    }

    private void NI() {
        if (this.euW == null || !this.fyL) {
            v.d("MicroMsg.FriendPreference", "initView : contact = " + this.euW + " bindView = " + this.fyL);
        } else if (this.hWq != -1 && new o(this.hWq).longValue() > 0) {
            setWidgetLayoutResource(2130904065);
            if (this.euW == null || !this.fyL) {
                v.d("MicroMsg.FriendPreference", "initView : contact = " + this.euW + " bindView = " + this.fyL);
                return;
            }
            this.hWs = 2;
            this.dtB.setText(this.mContext.getString(2131232048));
            this.hWl.setText(be.ma(this.hWp) + " " + new o(this.hWq).longValue());
            r0 = com.tencent.mm.u.b.P(this.hWq);
            if (r0 == null) {
                r0 = com.tencent.mm.compatible.f.a.decodeStream(this.mContext.getResources().openRawResource(2131165458));
            }
            if (r0 != null) {
                this.hWm.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(Bitmap.createScaledBitmap(r0, 48, 48, false), true, 0.0f));
            }
            ak.yW();
            if (!c.isSDCardAvailable()) {
                this.hWm.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.aWn, 2131165440));
            }
        } else if (this.hWo != null) {
            setWidgetLayoutResource(2130904056);
            if (this.euW == null || !this.fyL) {
                v.d("MicroMsg.FriendPreference", "initView : contact = " + this.euW + " bindView = " + this.fyL);
            } else if (this.hWo != null) {
                this.hWs = 1;
                this.dtB.setText(this.mContext.getString(2131232047));
                final Object obj = be.ma(this.hWo.ED()) + " " + be.ma(this.hWo.EJ()).replace(" ", "");
                this.hWl.setText(obj);
                Bitmap a = m.a(this.hWo.EC(), this.mContext);
                if (a == null) {
                    this.hWm.setImageDrawable(com.tencent.mm.bd.a.a(this.aWn, 2131165453));
                } else {
                    this.hWm.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(Bitmap.createScaledBitmap(a, 48, 48, false), true, 0.0f));
                }
                ak.yW();
                if (c.wH().LT(this.hWo.getUsername())) {
                    this.hWn.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ FriendPreference hWv;

                        public final void onClick(View view) {
                            String[] stringArray;
                            if (this.hWv.hWo == null || be.kS(this.hWv.hWo.cyx)) {
                                stringArray = this.hWv.aWn.getResources().getStringArray(2131296267);
                            } else {
                                stringArray = this.hWv.aWn.getResources().getStringArray(2131296266);
                            }
                            if (com.tencent.mm.plugin.profile.a.drq.oB()) {
                                List g = be.g(stringArray);
                                g.add(this.hWv.aWn.getResources().getString(2131231860));
                                stringArray = (String[]) g.toArray(new String[g.size()]);
                                g.iuh.h(11621, new Object[]{Integer.valueOf(2), Integer.valueOf(3)});
                            }
                            com.tencent.mm.ui.base.g.a(this.hWv.aWn, null, stringArray, null, new com.tencent.mm.ui.base.g.c(this) {
                                final /* synthetic */ AnonymousClass1 hWw;

                                public final void gT(int i) {
                                    switch (i) {
                                        case 0:
                                            if (obj != null && obj.length() != 0) {
                                                int lastIndexOf = obj.lastIndexOf(32) + 1;
                                                if (lastIndexOf > 0) {
                                                    FriendPreference.a(this.hWw.hWv, obj.substring(lastIndexOf));
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case 1:
                                            if (obj != null && obj.length() != 0) {
                                                String substring = obj.substring(0, obj.lastIndexOf(32));
                                                if (substring != null && substring.length() != 0) {
                                                    com.tencent.mm.model.m.b(this.hWw.hWv.euW, substring.trim());
                                                    return;
                                                }
                                                return;
                                            }
                                            return;
                                        case 2:
                                            if (stringArray != null && stringArray.length > 2 && this.hWw.hWv.hWo != null && this.hWw.hWv.euW != null) {
                                                if (!(this.hWw.hWv.hWo == null || be.kS(this.hWw.hWv.hWo.cyx))) {
                                                    FriendPreference.a(this.hWw.hWv, this.hWw.hWv.euW.field_username, this.hWw.hWv.hWo.cyx);
                                                    return;
                                                }
                                            }
                                            return;
                                            break;
                                        case 3:
                                            break;
                                        default:
                                            return;
                                    }
                                    Intent intent = new Intent();
                                    Bundle bundle = new Bundle();
                                    bundle.putInt("fromScene", 2);
                                    intent.putExtra("reportArgs", bundle);
                                    com.tencent.mm.plugin.profile.a.drp.k(intent, this.hWw.hWv.aWn);
                                }
                            });
                        }
                    });
                } else {
                    this.hWn.setVisibility(4);
                }
            }
        } else if (this.hWr > 0) {
            if (this.euW == null || !this.fyL) {
                v.d("MicroMsg.FriendPreference", "initView : contact = " + this.euW + " bindView = " + this.fyL);
                return;
            }
            this.hWs = 3;
            this.dtB.setText(this.mContext.getString(2131233214));
            this.hWl.setText(be.ma(this.euW.bCa));
            r0 = com.tencent.mm.u.b.gy(this.hWr);
            if (r0 == null) {
                r0 = com.tencent.mm.compatible.f.a.decodeStream(this.mContext.getResources().openRawResource(2131165458));
            }
            if (r0 != null) {
                this.hWm.setImageBitmap(com.tencent.mm.sdk.platformtools.d.a(Bitmap.createScaledBitmap(r0, 48, 48, false), true, 0.0f));
            }
            ak.yW();
            if (!c.isSDCardAvailable()) {
                this.hWm.setBackgroundDrawable(com.tencent.mm.bd.a.a(this.aWn, 2131165440));
            }
        } else if (TextUtils.isEmpty(this.hWt)) {
            Assert.assertTrue(false);
        } else if (this.euW == null || !this.fyL) {
            v.d("MicroMsg.FriendPreference", "initView : contact = " + this.euW + " bindView = " + this.fyL);
        } else {
            this.hWs = 3;
            this.dtB.setText(this.mContext.getString(2131234380));
            this.hWl.setText(be.ma(this.hWt));
            this.hWm.setVisibility(8);
        }
    }

    private boolean o(String str, Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        return m.a(str, this.mContext, byteArrayOutputStream.toByteArray());
    }

    public final boolean XS() {
        n.AX().e(this);
        return true;
    }

    public final void gM(String str) {
        long gA = com.tencent.mm.u.b.gA(str);
        if (gA > 0 && this.hWq == gA && com.tencent.mm.u.b.a(str, false, -1) != null) {
            NI();
        }
        if (com.tencent.mm.u.b.gz(str) == this.hWr && com.tencent.mm.u.b.a(str, false, -1) != null) {
            NI();
        }
    }
}
