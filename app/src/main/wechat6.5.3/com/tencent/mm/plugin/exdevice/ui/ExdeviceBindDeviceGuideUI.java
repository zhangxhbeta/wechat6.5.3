package com.tencent.mm.plugin.exdevice.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.LocationManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import junit.framework.Assert;

public class ExdeviceBindDeviceGuideUI extends MMActivity implements e {
    private ListView Eq;
    BroadcastReceiver esp = new BroadcastReceiver(this) {
        final /* synthetic */ ExdeviceBindDeviceGuideUI fzx;

        {
            this.fzx = r1;
        }

        public final void onReceive(Context context, Intent intent) {
            v.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Action broadcast receive...");
            if (intent != null) {
                String action = intent.getAction();
                v.d("MicroMsg.ExdeviceBindDeviceGuideUI", "Receiver action(%s)", new Object[]{action});
                int intExtra;
                if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action) && this.fzx.fzw) {
                    intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", -1);
                    if (intExtra == 12) {
                        if (!this.fzx.fyT || this.fzx.fyS.isProviderEnabled("gps")) {
                            this.fzx.kp(2);
                            return;
                        }
                    } else if (intExtra == 10) {
                        this.fzx.kp(3);
                        return;
                    } else {
                        return;
                    }
                } else if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action) && this.fzx.fzv) {
                    intExtra = intent.getIntExtra("wifi_state", -1);
                    v.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Wifi state changed action: wifiState(%d)", new Object[]{Integer.valueOf(intExtra)});
                    if (intExtra == 3) {
                        this.fzx.kp(1);
                        return;
                    } else if (intExtra == 1) {
                        this.fzx.kp(5);
                        return;
                    } else {
                        return;
                    }
                } else if (!this.fzx.fyT || !"android.location.MODE_CHANGED".equals(action)) {
                    return;
                } else {
                    if (this.fzx.fyS.isProviderEnabled("gps")) {
                        if (com.tencent.mm.plugin.c.a.e.a.Xw()) {
                            this.fzx.kp(2);
                            return;
                        } else {
                            this.fzx.kp(3);
                            return;
                        }
                    }
                }
                this.fzx.kp(6);
            }
        }
    };
    private String fto;
    private String ftp;
    private String fyJ;
    private String fyK;
    private TextView fyP;
    private LocationManager fyS;
    private boolean fyT = false;
    private String fyr;
    private a fzh;
    private Button fzi;
    private Button fzj;
    private TextView fzk;
    private ScrollView fzl;
    private ImageView fzm;
    private TextView fzn;
    private String fzo;
    private String fzp;
    private String fzq;
    private String fzr;
    private long fzs;
    private ArrayList<String> fzt;
    private String fzu;
    private boolean fzv = false;
    private boolean fzw = false;
    private String mTitle;
    private String sa;

    private static final class a extends BaseAdapter {
        private ArrayList<String> fzy;

        private static class a {
            TextView fzA;
            View fzB;
            View fzC;
            TextView fzz;

            private a() {
            }
        }

        public final /* synthetic */ Object getItem(int i) {
            return hd(i);
        }

        public a(ArrayList<String> arrayList) {
            this.fzy = arrayList;
        }

        public final int getCount() {
            if (this.fzy != null) {
                return this.fzy.size();
            }
            return 0;
        }

        private String hd(int i) {
            if (this.fzy == null || this.fzy.size() <= 0) {
                return null;
            }
            return (String) this.fzy.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (this.fzy == null || this.fzy.size() <= 0) {
                return null;
            }
            a aVar;
            CharSequence hd = hd(i);
            if (view == null) {
                a aVar2 = new a();
                view = View.inflate(viewGroup.getContext(), 2130903541, null);
                aVar2.fzA = (TextView) view.findViewById(2131756787);
                aVar2.fzz = (TextView) view.findViewById(2131756785);
                aVar2.fzB = view.findViewById(2131756784);
                aVar2.fzC = view.findViewById(2131756786);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.fzz.setText(Integer.toString(i + 1));
            aVar.fzA.setText(hd);
            if (i == 0 && this.fzy.size() == 1) {
                aVar.fzB.setVisibility(4);
                aVar.fzC.setVisibility(4);
                return view;
            } else if (i == 0) {
                aVar.fzB.setVisibility(4);
                aVar.fzC.setVisibility(0);
                return view;
            } else if (i != this.fzy.size() - 1) {
                return view;
            } else {
                aVar.fzC.setVisibility(4);
                aVar.fzB.setVisibility(0);
                return view;
            }
        }
    }

    protected final int getLayoutId() {
        return 2130903542;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ ExdeviceBindDeviceGuideUI fzx;

            {
                this.fzx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.fzx.finish();
                return true;
            }
        });
        if (!(!f.dW(23) || VERSION.RELEASE.equalsIgnoreCase("6.0") || VERSION.RELEASE.equalsIgnoreCase("6.0.0"))) {
            v.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth limited version(%s)", new Object[]{VERSION.RELEASE});
            this.fyT = true;
        }
        Intent intent = getIntent();
        this.fzo = intent.getStringExtra("device_scan_mode");
        this.fzp = intent.getStringExtra("device_scan_conn_proto");
        this.ftp = intent.getStringExtra("device_id");
        this.fyr = intent.getStringExtra("device_type");
        this.fzq = intent.getStringExtra("device_title");
        this.fyJ = intent.getStringExtra("device_desc");
        this.fyK = intent.getStringExtra("device_icon_url");
        this.sa = intent.getStringExtra("device_category_id");
        this.fto = intent.getStringExtra("device_brand_name");
        this.fzr = intent.getStringExtra("bind_ticket");
        this.fzs = intent.getLongExtra("device_ble_simple_proto", -1);
        this.fzt = intent.getStringArrayListExtra("device_airkiss_steps");
        this.fzu = intent.getStringExtra("device_airkiss_key");
        this.mTitle = intent.getStringExtra("device_airkiss_title");
        v.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Category config guide steps(%d)", new Object[]{Integer.valueOf(this.fzt.size())});
        this.fyS = (LocationManager) this.nDR.nEl.getSystemService("location");
        this.Eq = (ListView) findViewById(2131756789);
        View inflate = View.inflate(this, 2130903536, null);
        this.fzk = (TextView) inflate.findViewById(2131756774);
        this.fzh = new a(this.fzt);
        this.Eq.addHeaderView(inflate);
        this.Eq.setDividerHeight(0);
        this.Eq.setClickable(false);
        this.Eq.setFooterDividersEnabled(false);
        this.Eq.setAdapter(this.fzh);
        this.fzm = (ImageView) findViewById(2131756777);
        this.fzl = (ScrollView) findViewById(2131756788);
        this.fzi = (Button) findViewById(2131756790);
        this.fzj = (Button) findViewById(2131756791);
        this.fyP = (TextView) findViewById(2131756778);
        this.fzn = (TextView) findViewById(2131756779);
        String str = "";
        if (this.fzo.compareTo("SCAN_CATALOG") != 0) {
            Assert.assertTrue(false);
        } else if (this.fzp.contains("wifi")) {
            this.fzv = true;
            str = this.nDR.nEl.getString(2131232521);
        } else if (this.fzp.contains("blue")) {
            this.fzw = true;
            str = this.nDR.nEl.getString(2131232499);
        } else {
            Assert.assertTrue(false);
        }
        Fd(str);
        if (this.fzw && !this.fzv) {
            if (!com.tencent.mm.plugin.c.a.e.a.by(this.nDR.nEl)) {
                v.i("MicroMsg.ExdeviceBindDeviceGuideUI", "now sdk version not support ble device : %d", new Object[]{Integer.valueOf(VERSION.SDK_INT)});
                kp(4);
            } else if (!com.tencent.mm.plugin.c.a.e.a.Xw()) {
                v.i("MicroMsg.ExdeviceBindDeviceGuideUI", "Bluetooth is not open, Just leave");
                kp(3);
            } else if (!(this.fyS == null || !this.fyT || this.fyS.isProviderEnabled("gps"))) {
                v.i("MicroMsg.ExdeviceBindDeviceGuideUI", "BLE limited version, GPS do not open");
                kp(6);
            }
            this.fzi.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ExdeviceBindDeviceGuideUI fzx;

                {
                    this.fzx = r1;
                }

                public final void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("device_scan_mode", this.fzx.fzo);
                    intent.putExtra("device_scan_conn_proto", this.fzx.fzp);
                    intent.putExtra("device_id", this.fzx.ftp);
                    intent.putExtra("device_type", this.fzx.fyr);
                    intent.putExtra("device_title", this.fzx.fzq);
                    intent.putExtra("device_desc", this.fzx.fyJ);
                    intent.putExtra("device_icon_url", this.fzx.fyK);
                    intent.putExtra("device_category_id", this.fzx.sa);
                    intent.putExtra("device_brand_name", this.fzx.fto);
                    intent.putExtra("bind_ticket", this.fzx.fzr);
                    intent.putExtra("device_ble_simple_proto", this.fzx.fzs);
                    intent.putExtra("encryptKey", this.fzx.fzu);
                    intent.putExtra("jumpToBindDevice", true);
                    if (this.fzx.fzw && !this.fzx.fzv) {
                        c.b(this.fzx.nDR.nEl, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    } else if (this.fzx.fzv && !this.fzx.fzw) {
                        intent.putExtra("exdevice_airkiss_open_type", 2);
                        c.b(this.fzx.nDR.nEl, "exdevice", ".ui.ExdeviceConnectWifiUI", intent);
                    }
                }
            });
            this.fzj.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ ExdeviceBindDeviceGuideUI fzx;

                {
                    this.fzx = r1;
                }

                public final void onClick(View view) {
                    if (this.fzx.fzv && !this.fzx.fzw) {
                        Intent intent = new Intent();
                        intent.putExtra("device_scan_mode", this.fzx.fzo);
                        intent.putExtra("device_scan_conn_proto", this.fzx.fzp);
                        intent.putExtra("device_id", this.fzx.ftp);
                        intent.putExtra("device_type", this.fzx.fyr);
                        intent.putExtra("device_title", this.fzx.fzq);
                        intent.putExtra("device_desc", this.fzx.fyJ);
                        intent.putExtra("device_icon_url", this.fzx.fyK);
                        intent.putExtra("device_category_id", this.fzx.sa);
                        intent.putExtra("device_brand_name", this.fzx.fto);
                        intent.putExtra("bind_ticket", this.fzx.fzr);
                        c.b(this.fzx.nDR.nEl, "exdevice", ".ui.ExdeviceBindDeviceUI", intent);
                    }
                }
            });
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter.addAction("android.location.MODE_CHANGED");
            this.nDR.nEl.registerReceiver(this.esp, intentFilter);
        }
        if (!this.fzw && this.fzv && !ak.isWifi(this.nDR.nEl)) {
            v.i("MicroMsg.ExdeviceBindDeviceGuideUI", "wifi is not open, Just leave");
            kp(5);
            this.fzi.setOnClickListener(/* anonymous class already generated */);
            this.fzj.setOnClickListener(/* anonymous class already generated */);
            IntentFilter intentFilter2 = new IntentFilter();
            intentFilter2.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter2.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter2.addAction("android.location.MODE_CHANGED");
            this.nDR.nEl.registerReceiver(this.esp, intentFilter2);
        } else if (!this.fzv || this.fzw) {
            if (this.fzw && !this.fzv) {
                kp(2);
            }
            this.fzi.setOnClickListener(/* anonymous class already generated */);
            this.fzj.setOnClickListener(/* anonymous class already generated */);
            IntentFilter intentFilter22 = new IntentFilter();
            intentFilter22.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter22.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter22.addAction("android.location.MODE_CHANGED");
            this.nDR.nEl.registerReceiver(this.esp, intentFilter22);
        } else {
            kp(1);
            this.fzi.setOnClickListener(/* anonymous class already generated */);
            this.fzj.setOnClickListener(/* anonymous class already generated */);
            IntentFilter intentFilter222 = new IntentFilter();
            intentFilter222.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter222.addAction("android.net.wifi.WIFI_STATE_CHANGED");
            intentFilter222.addAction("android.location.MODE_CHANGED");
            this.nDR.nEl.registerReceiver(this.esp, intentFilter222);
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.nDR.nEl.unregisterReceiver(this.esp);
    }

    public final void a(int i, int i2, String str, k kVar) {
    }

    private void kp(int i) {
        switch (i) {
            case 1:
                this.fzi.setText(this.nDR.nEl.getString(2131232521));
                this.fzj.setText(this.nDR.nEl.getString(2131232494));
                this.fzk.setText(this.nDR.nEl.getString(2131232522));
                break;
            case 2:
                this.fzi.setText(this.nDR.nEl.getString(2131232514));
                this.fzj.setVisibility(8);
                this.fzk.setText(this.nDR.nEl.getString(2131232513));
                break;
            case 3:
                this.fzm.setImageResource(2131165309);
                this.fyP.setText(2131232508);
                this.fzn.setText(2131232496);
                break;
            case 4:
                this.fzm.setImageResource(2131165309);
                this.fyP.setText(2131232506);
                this.fzn.setText("");
                break;
            case 5:
                this.fzm.setImageResource(2131166033);
                this.fyP.setText(2131232508);
                this.fzn.setText(2131232503);
                break;
            case 6:
                this.fzm.setImageResource(2131165309);
                this.fyP.setText(2131232508);
                this.fzn.setText(2131232543);
                break;
        }
        switch (i) {
            case 1:
            case 2:
                this.fzm.setVisibility(8);
                this.fyP.setVisibility(8);
                this.fzn.setVisibility(8);
                this.Eq.setVisibility(0);
                this.fzl.setVisibility(0);
                return;
            case 3:
            case 4:
            case 5:
            case 6:
                this.fzm.setVisibility(0);
                this.fyP.setVisibility(0);
                this.Eq.setVisibility(8);
                this.fzl.setVisibility(8);
                if (i == 4) {
                    this.fzn.setVisibility(8);
                    return;
                } else {
                    this.fzn.setVisibility(0);
                    return;
                }
            default:
                return;
        }
    }
}
