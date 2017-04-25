package com.tencent.mm.plugin.webview.stub;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import com.tencent.mm.ay.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.i;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.j;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.g;
import java.util.ArrayList;

@a(7)
public class WebViewStubTempUI extends MMActivity implements android.support.v4.app.a.a, MMActivity.a {
    private int lhU = 0;
    private boolean lhV = false;
    private Dialog lhW = null;

    private static final class StartActivityForResultTask implements Parcelable {
        public static final Creator<StartActivityForResultTask> CREATOR = new Creator<StartActivityForResultTask>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new StartActivityForResultTask(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StartActivityForResultTask[i];
            }
        };
        int aZt;
        String iEp;
        int lfA;
        String lib;
        Intent lic;
        boolean lid;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.iEp);
            parcel.writeString(this.lib);
            parcel.writeParcelable(this.lic, i);
            parcel.writeInt(this.aZt);
            parcel.writeByte(this.lid ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.lfA);
        }

        StartActivityForResultTask() {
        }

        StartActivityForResultTask(Parcel parcel) {
            this.iEp = parcel.readString();
            this.lib = parcel.readString();
            this.lic = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
            this.aZt = parcel.readInt();
            this.lid = parcel.readByte() != (byte) 0;
            this.lfA = parcel.readInt();
        }
    }

    public static void a(Context context, String str, String str2, Intent intent, int i) {
        Intent intent2 = new Intent(context, WebViewStubTempUI.class);
        intent2.addFlags(268435456);
        intent2.putExtra("key_action_code", 2);
        Parcelable startActivityForResultTask = new StartActivityForResultTask();
        startActivityForResultTask.iEp = str;
        startActivityForResultTask.lib = str2;
        startActivityForResultTask.lic = intent;
        startActivityForResultTask.aZt = 15;
        startActivityForResultTask.lid = false;
        startActivityForResultTask.lfA = i;
        intent2.putExtra("key_activity_result_task", startActivityForResultTask);
        context.startActivity(intent2);
    }

    public static void a(Context context, String str, String str2, String str3, String str4, final OnClickListener onClickListener, final OnClickListener onClickListener2) {
        Intent intent = new Intent(context, WebViewStubTempUI.class);
        intent.addFlags(268435456);
        intent.putExtra("key_action_code", 0);
        intent.putExtra("key_alert_cancelable", false);
        intent.putExtra("key_alert_message", str);
        intent.putExtra("key_alert_title", str2);
        intent.putExtra("key_alert_yes", str3);
        intent.putExtra("key_alert_no", str4);
        intent.putExtra("key_alert_result_receiver", new ResultReceiver(ac.fetchFreeHandler()) {
            protected final void onReceiveResult(int i, Bundle bundle) {
                switch (i) {
                    case 0:
                        onClickListener.onClick(null, 0);
                        return;
                    case 1:
                        onClickListener2.onClick(null, 0);
                        return;
                    default:
                        return;
                }
            }
        });
        context.startActivity(intent);
    }

    public static boolean a(Context context, String[] strArr, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 <= 0; i2++) {
            String str = strArr[0];
            if (android.support.v4.content.a.d(context, str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            return true;
        }
        Intent intent = new Intent(context, WebViewStubTempUI.class);
        intent.addFlags(268435456);
        intent.putExtra("key_action_code", 1);
        intent.putExtra("key_permission_types", (String[]) arrayList.toArray(new String[arrayList.size()]));
        intent.putExtra("key_permission_request_code", 116);
        intent.putExtra("key_binder_id", i);
        context.startActivity(intent);
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        switch (getIntent().getIntExtra("key_action_code", -1)) {
            case 0:
                final ResultReceiver resultReceiver = (ResultReceiver) getIntent().getParcelableExtra("key_alert_result_receiver");
                if (resultReceiver == null) {
                    finish();
                    return;
                }
                this.lhW = g.a(this, getIntent().getBooleanExtra("key_alert_cancelable", false), getIntent().getStringExtra("key_alert_message"), getIntent().getStringExtra("key_alert_title"), getIntent().getStringExtra("key_alert_yes"), getIntent().getStringExtra("key_alert_no"), new OnClickListener(this) {
                    final /* synthetic */ WebViewStubTempUI lia;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        resultReceiver.send(0, null);
                        this.lia.finish();
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ WebViewStubTempUI lia;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        resultReceiver.send(1, null);
                        this.lia.finish();
                    }
                });
                this.lhW.setOnCancelListener(new OnCancelListener(this) {
                    final /* synthetic */ WebViewStubTempUI lia;

                    {
                        this.lia = r1;
                    }

                    public final void onCancel(DialogInterface dialogInterface) {
                        this.lia.finish();
                    }
                });
                return;
            case 1:
                android.support.v4.app.a.a(this, getIntent().getStringArrayExtra("key_permission_types"), getIntent().getIntExtra("key_permission_request_code", 0));
                return;
            case 2:
                StartActivityForResultTask startActivityForResultTask = (StartActivityForResultTask) getIntent().getParcelableExtra("key_activity_result_task");
                this.lhU = startActivityForResultTask.lfA;
                this.lhV = true;
                this.nDS = this;
                c.a(this, startActivityForResultTask.iEp, startActivityForResultTask.lib, startActivityForResultTask.lic, startActivityForResultTask.aZt, startActivityForResultTask.lid);
                return;
            default:
                finish();
                return;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.lhW != null) {
            this.lhW.dismiss();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int intExtra = getIntent().getIntExtra("key_binder_id", 0);
        switch (i) {
            case 113:
            case 115:
            case 116:
            case 117:
            case 118:
                if (iArr[0] != 0) {
                    j.tl(intExtra).a(i, 0, null);
                    break;
                } else {
                    j.tl(intExtra).a(i, -1, null);
                    break;
                }
        }
        finish();
    }

    public final void a(int i, int i2, Intent intent) {
        if (this.lhV) {
            i tl = j.tl(this.lhU);
            if (tl != null) {
                tl.a(i, i2, intent);
            }
        }
        finish();
    }

    public final int getLayoutId() {
        return -1;
    }
}
