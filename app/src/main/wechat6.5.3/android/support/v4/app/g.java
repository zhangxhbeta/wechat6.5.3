package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

public class g extends Fragment implements OnCancelListener, OnDismissListener {
    boolean oA;
    boolean oB;
    int ot = 0;
    int ou = 0;
    boolean ov = true;
    public boolean ow = true;
    int ox = -1;
    Dialog oy;
    boolean oz;

    public void a(k kVar, String str) {
        this.oA = false;
        this.oB = true;
        n aW = kVar.aW();
        aW.a((Fragment) this, str);
        aW.commit();
    }

    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!this.oB) {
            this.oA = false;
        }
    }

    public final void onDetach() {
        super.onDetach();
        if (!this.oB && !this.oA) {
            this.oA = true;
        }
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ow = this.oY == 0;
        if (bundle != null) {
            this.ot = bundle.getInt("android:style", 0);
            this.ou = bundle.getInt("android:theme", 0);
            this.ov = bundle.getBoolean("android:cancelable", true);
            this.ow = bundle.getBoolean("android:showsDialog", this.ow);
            this.ox = bundle.getInt("android:backStackId", -1);
        }
    }

    public final LayoutInflater c(Bundle bundle) {
        if (!this.ow) {
            return super.c(bundle);
        }
        this.oy = aF();
        if (this.oy == null) {
            return (LayoutInflater) this.oU.mContext.getSystemService("layout_inflater");
        }
        Dialog dialog = this.oy;
        switch (this.ot) {
            case 1:
            case 2:
                break;
            case 3:
                dialog.getWindow().addFlags(24);
                break;
        }
        dialog.requestWindowFeature(1);
        return (LayoutInflater) this.oy.getContext().getSystemService("layout_inflater");
    }

    public Dialog aF() {
        return new Dialog(aG(), this.ou);
    }

    public void onCancel(DialogInterface dialogInterface) {
    }

    public void onDismiss(DialogInterface dialogInterface) {
        if (!this.oz && !this.oA) {
            this.oA = true;
            this.oB = false;
            if (this.oy != null) {
                this.oy.dismiss();
                this.oy = null;
            }
            this.oz = true;
            if (this.ox >= 0) {
                this.oT.F(this.ox);
                this.ox = -1;
                return;
            }
            n aW = this.oT.aW();
            aW.a(this);
            aW.commitAllowingStateLoss();
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.ow) {
            View view = this.mView;
            if (view != null) {
                if (view.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                this.oy.setContentView(view);
            }
            this.oy.setOwnerActivity(aG());
            this.oy.setCancelable(this.ov);
            this.oy.setOnCancelListener(this);
            this.oy.setOnDismissListener(this);
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle("android:savedDialogState");
                if (bundle2 != null) {
                    this.oy.onRestoreInstanceState(bundle2);
                }
            }
        }
    }

    public final void onStart() {
        super.onStart();
        if (this.oy != null) {
            this.oz = false;
            this.oy.show();
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.oy != null) {
            Bundle onSaveInstanceState = this.oy.onSaveInstanceState();
            if (onSaveInstanceState != null) {
                bundle.putBundle("android:savedDialogState", onSaveInstanceState);
            }
        }
        if (this.ot != 0) {
            bundle.putInt("android:style", this.ot);
        }
        if (this.ou != 0) {
            bundle.putInt("android:theme", this.ou);
        }
        if (!this.ov) {
            bundle.putBoolean("android:cancelable", this.ov);
        }
        if (!this.ow) {
            bundle.putBoolean("android:showsDialog", this.ow);
        }
        if (this.ox != -1) {
            bundle.putInt("android:backStackId", this.ox);
        }
    }

    public final void onStop() {
        super.onStop();
        if (this.oy != null) {
            this.oy.hide();
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        if (this.oy != null) {
            this.oz = true;
            this.oy.dismiss();
            this.oy = null;
        }
    }
}
