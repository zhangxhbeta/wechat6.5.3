package com.tencent.mm.plugin.safedevice.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.safedevice.a.c;
import com.tencent.mm.plugin.safedevice.a.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import com.tencent.tmassistantsdk.storage.helper.DBResult;

public class SafeDeviceListPreference extends Preference implements e {
    private Context context;
    private ProgressDialog dwR;
    private Button eVF;
    c iuV;
    private boolean iuW;
    a iuX;
    b iuY;
    private int mode;

    public interface a {
        void yN(String str);
    }

    public interface b {
        void yM(String str);
    }

    public SafeDeviceListPreference(Context context) {
        this(context, null);
    }

    public SafeDeviceListPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SafeDeviceListPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mode = -2;
        this.iuW = false;
        this.context = context;
    }

    protected final View onCreateView(ViewGroup viewGroup) {
        View onCreateView = super.onCreateView(viewGroup);
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        ViewGroup viewGroup2 = (ViewGroup) onCreateView.findViewById(2131755329);
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
            layoutInflater.inflate(2130904040, viewGroup2);
        }
        return onCreateView;
    }

    protected final void onBindView(View view) {
        this.iuW = true;
        this.eVF = (Button) view.findViewById(2131756570);
        NI();
        super.onBindView(view);
    }

    public final void oU(int i) {
        this.mode = i;
        NI();
    }

    private void LL() {
        ak.vy().b(362, this);
    }

    private void NI() {
        if (this.iuW) {
            switch (this.mode) {
                case DBResult.RET_EXCEPTION /*-2*/:
                    setWidgetLayoutResource(2130904064);
                    return;
                case 1:
                    setWidgetLayoutResource(2130903449);
                    if (this.eVF != null) {
                        this.eVF.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ SafeDeviceListPreference iuZ;

                            {
                                this.iuZ = r1;
                            }

                            public final void onClick(View view) {
                                g.b(this.iuZ.context, this.iuZ.context.getString(2131234700, new Object[]{this.iuZ.iuV.field_name}), "", com.tencent.mm.bd.a.O(this.iuZ.context, 2131234701), com.tencent.mm.bd.a.O(this.iuZ.context, 2131231010), new DialogInterface.OnClickListener(this.iuZ) {
                                    final /* synthetic */ SafeDeviceListPreference iuZ;

                                    {
                                        this.iuZ = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        ak.vy().a(362, this.iuZ);
                                        final com.tencent.mm.plugin.safedevice.a.a aVar = new com.tencent.mm.plugin.safedevice.a.a(this.iuZ.iuV.field_uid);
                                        ak.vy().a(aVar, 0);
                                        this.iuZ.dwR = g.a(this.iuZ.context, com.tencent.mm.bd.a.O(this.iuZ.context, 2131231182), true, new OnCancelListener(this) {
                                            final /* synthetic */ AnonymousClass1 ivb;

                                            public final void onCancel(DialogInterface dialogInterface) {
                                                ak.vy().c(aVar);
                                                this.ivb.iuZ.LL();
                                            }
                                        });
                                    }
                                }, new DialogInterface.OnClickListener(this.iuZ) {
                                    final /* synthetic */ SafeDeviceListPreference iuZ;

                                    {
                                        this.iuZ = r1;
                                    }

                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                    }
                                });
                            }
                        });
                        return;
                    }
                    return;
                default:
                    setWidgetLayoutResource(2130904064);
                    return;
            }
        }
        v.d("MicroMsg.SafeDeviceListPreference", "has not binded");
    }

    public final void a(int i, int i2, String str, k kVar) {
        LL();
        if (this.dwR != null && this.dwR.isShowing()) {
            this.dwR.dismiss();
            this.dwR = null;
        }
        if (i2 == 0 && i2 == 0) {
            f.aKJ().c(this.iuV, new String[0]);
            if (this.iuY != null) {
                this.iuY.yM(this.dnU);
            }
        } else if (!com.tencent.mm.plugin.a.a.drq.a(this.context, i, i2, str)) {
            Toast.makeText(this.context, this.context.getString(2131234702, new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}), 0).show();
            if (this.iuX != null) {
                this.iuX.yN(this.iuV.field_uid);
            }
        }
    }
}
