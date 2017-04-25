package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.cj;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.x;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.List;

public class ExdeviceManageDeviceUI extends MMActivity {
    private ListView Eq;
    private a fBX;

    private static final class a extends BaseAdapter implements e {
        private p dwg = null;
        private l eAd;
        private d eAj;
        boolean fBZ;
        private WeakReference<Context> fCa;
        private OnClickListener fCb;
        private volatile int fCc = -1;
        private List<b> fyN;
        private c fzb;

        private static class a {
            TextView eVA;
            ImageView eZn;
            View fCf;
            View fCg;

            private a() {
            }
        }

        static /* synthetic */ void a(Context context, b bVar) {
            Intent intent = new Intent();
            intent.putExtra("device_type", bVar.field_deviceType);
            intent.putExtra("device_id", bVar.field_deviceID);
            intent.putExtra("device_mac", bVar.field_mac);
            intent.putExtra("device_brand_name", bVar.field_brandName);
            intent.putExtra("device_desc", bVar.bLe);
            intent.putExtra("device_title", bVar.bLd);
            intent.putExtra("device_icon_url", bVar.iconUrl);
            intent.putExtra("device_alias", bVar.bLc);
            intent.putExtra("device_jump_url", bVar.jumpUrl);
            intent.putExtra("subscribe_flag", 1);
            com.tencent.mm.ay.c.b(context, "exdevice", ".ui.ExdeviceDeviceProfileUI", intent, 1000);
        }

        static /* synthetic */ void a(a aVar, final b bVar) {
            if (bVar != null && aVar.fCa != null) {
                Context context = (Context) aVar.fCa.get();
                if (context == null) {
                    v.e("MicroMsg.ExdeviceManageDeviceUI", "context is null.");
                    return;
                }
                context.getString(2131231164);
                aVar.dwg = g.a(context, context.getString(2131231182), true, new OnCancelListener(aVar) {
                    final /* synthetic */ a fCd;

                    {
                        this.fCd = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                ak.vA().x(new Runnable(aVar) {
                    final /* synthetic */ a fCd;

                    public final void run() {
                        abt com_tencent_mm_protocal_c_abt = new abt();
                        com_tencent_mm_protocal_c_abt.eez = bVar.field_deviceID;
                        com_tencent_mm_protocal_c_abt.meq = bVar.field_deviceType;
                        ak.vy().a(new x(com_tencent_mm_protocal_c_abt, 2), 0);
                    }
                });
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return ky(i);
        }

        public a(Context context) {
            this.fCa = new WeakReference(context);
            this.fyN = new LinkedList();
            this.eAd = new l(context);
            com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
            aVar.cPH = 2130838184;
            this.fzb = aVar.GU();
            this.eAj = new d(this) {
                final /* synthetic */ a fCd;

                {
                    this.fCd = r1;
                }

                public final void c(MenuItem menuItem, int i) {
                    int itemId = menuItem.getItemId();
                    v.d("MicroMsg.ExdeviceManageDeviceUI", "onMenuItemSelected, itemId(%d), count(%d).", new Object[]{Integer.valueOf(itemId), Integer.valueOf(this.fCd.getCount())});
                    if (itemId >= 0 && itemId < r1) {
                        this.fCd.fCc = itemId;
                        a.a(this.fCd, (b) this.fCd.fyN.get(itemId));
                        this.fCd.notifyDataSetChanged();
                    }
                }
            };
            this.fCb = new OnClickListener(this) {
                final /* synthetic */ a fCd;

                {
                    this.fCd = r1;
                }

                public final void onClick(View view) {
                    if (!this.fCd.fBZ) {
                        Object tag = view.getTag();
                        if (tag != null && (tag instanceof Integer)) {
                            int intValue = ((Integer) tag).intValue();
                            if (intValue >= 0 && intValue < this.fCd.getCount()) {
                                b ky = this.fCd.ky(intValue);
                                Context context = (Context) this.fCd.fCa.get();
                                if (context == null) {
                                    v.e("MicroMsg.ExdeviceManageDeviceUI", "Start activity failed, context is null.");
                                } else {
                                    a.a(context, ky);
                                }
                            }
                        }
                    }
                }
            };
            an(ac.ajq().ajZ());
        }

        public final void an(List<b> list) {
            this.fyN.clear();
            if (list != null && list.size() != 0) {
                this.fyN.addAll(list);
            }
        }

        public final int getCount() {
            return this.fyN.size();
        }

        public final b ky(int i) {
            return (b) this.fyN.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            CharSequence charSequence;
            b ky = ky(i);
            if (view == null) {
                aVar = new a();
                view = View.inflate(viewGroup.getContext(), 2130903556, null);
                aVar.fCf = view.findViewById(2131755326);
                aVar.eVA = (TextView) view.findViewById(2131756776);
                aVar.fCg = view.findViewById(2131756817);
                aVar.eZn = (ImageView) view.findViewById(2131756775);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            if (ky == null) {
                charSequence = "";
            } else {
                String br = !be.kS(ky.bLc) ? ky.bLc : !be.kS(ky.bLd) ? ky.bLd : ky.field_mac != 0 ? com.tencent.mm.plugin.exdevice.j.b.br(ky.field_mac) : !be.kS(ky.field_deviceID) ? ky.field_deviceID : null;
                charSequence = be.ma(br);
            }
            v.d("MicroMsg.ExdeviceManageDeviceUI", "position(%s), name(%s), mac(%s).", new Object[]{Integer.valueOf(i), charSequence, Long.valueOf(ky.field_mac)});
            aVar.eVA.setText(charSequence);
            n.GL().a(ky.iconUrl, aVar.eZn, this.fzb);
            aVar.fCg.setTag(Integer.valueOf(i));
            if (this.fBZ) {
                aVar.fCg.setVisibility(0);
            } else {
                aVar.fCg.setVisibility(8);
            }
            aVar.fCf.setTag(Integer.valueOf(i));
            aVar.fCf.setOnClickListener(this.fCb);
            return view;
        }

        public final void a(int i, int i2, String str, k kVar) {
            if (kVar == null) {
                v.e("MicroMsg.ExdeviceManageDeviceUI", "scene is null.");
            } else if (kVar instanceof x) {
                if (this.dwg != null && this.dwg.isShowing()) {
                    this.dwg.dismiss();
                }
                if (i == 0 && i2 == 0 && this.fCc >= 0 && this.fCc < this.fyN.size()) {
                    ad.o(new Runnable(this) {
                        final /* synthetic */ a fCd;

                        {
                            this.fCd = r1;
                        }

                        public final void run() {
                            this.fCd.fyN.remove(this.fCd.fCc);
                            this.fCd.notifyDataSetChanged();
                            this.fCd.fCc = -1;
                        }
                    });
                }
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903557;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceManageDeviceUI fBY;

            {
                this.fBY = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fBY.finish();
                return true;
            }
        });
        vD(2131232551);
        cj cjVar = new cj();
        cjVar.bac.bad = true;
        com.tencent.mm.sdk.c.a.nhr.z(cjVar);
        NI();
        ak.vy().a(537, this.fBX);
    }

    protected final void NI() {
        this.Eq = (ListView) findViewById(2131755705);
        this.fBX = new a(this);
        View.inflate(this, 2130903545, null);
        this.Eq.setAdapter(this.fBX);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.fBX.an(ac.ajq().ajZ());
        this.fBX.notifyDataSetChanged();
    }

    protected void onDestroy() {
        super.onDestroy();
        ak.vy().b(537, this.fBX);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getRepeatCount() != 0 || !this.fBX.fBZ) {
            return super.onKeyDown(i, keyEvent);
        }
        aq(0, getString(2131231030));
        a aVar = this.fBX;
        if (aVar.fBZ) {
            aVar.fBZ = false;
            ad.o(new Runnable(aVar) {
                final /* synthetic */ a fCd;

                {
                    this.fCd = r1;
                }

                public final void run() {
                    this.fCd.notifyDataSetChanged();
                }
            });
        }
        return true;
    }
}
