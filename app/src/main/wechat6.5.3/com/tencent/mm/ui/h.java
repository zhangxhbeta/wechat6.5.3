package com.tencent.mm.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mm.sdk.platformtools.aa;

public abstract class h extends Fragment {
    public boolean nAV;
    public boolean nAW;
    private FragmentActivity nAX;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nAX = aG();
    }

    public void onDestroy() {
        super.onDestroy();
        this.nAW = true;
    }

    public h(boolean z) {
        this.nAW = false;
        this.nAV = z;
    }

    public h() {
        this.nAW = false;
        this.nAV = false;
    }

    public void startActivity(Intent intent) {
        FragmentActivity bzo = bzo();
        if (bzo == null) {
            aa.getContext().startActivity(intent);
        } else {
            bzo.a((Fragment) this, intent, -1);
        }
    }

    public void finish() {
        if (this.nAV) {
            if (bzo() != null) {
                bzo().finish();
            }
        } else if (bzo() != null) {
            bzo().aS().popBackStack();
        }
    }

    public final int getIntExtra(String str, int i) {
        if (this.nAV && this.oJ == null && bzo() != null) {
            return bzo().getIntent().getIntExtra(str, i);
        }
        if (this.oJ != null) {
            return this.oJ.getInt(str, i);
        }
        return i;
    }

    public final String getStringExtra(String str) {
        String str2 = null;
        if (this.nAV && bzo() != null) {
            str2 = bzo().getIntent().getStringExtra(str);
        }
        if (str2 != null || this.oJ == null) {
            return str2;
        }
        return this.oJ.getString(str);
    }

    public final SharedPreferences NV(String str) {
        return bzo().getSharedPreferences(str, 0);
    }

    public FragmentActivity bzo() {
        if (this.nAX == null) {
            this.nAX = aG();
        }
        return this.nAX;
    }

    public final View findViewById(int i) {
        View view = this.mView;
        View view2 = null;
        if (view != null) {
            view2 = view.findViewById(i);
        }
        return view2 != null ? view2 : bzo().findViewById(i);
    }

    public final void sendBroadcast(Intent intent) {
        bzo().sendBroadcast(intent);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        } else if (i == 82 && keyEvent.getAction() == 1) {
            return onKeyUp(i, keyEvent);
        } else {
            return false;
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    public final boolean isFinishing() {
        if (bzo() == null) {
            return true;
        }
        return bzo().isFinishing();
    }

    public final void setRequestedOrientation(int i) {
        if (bzo() != null) {
            bzo().setRequestedOrientation(i);
        }
    }

    public final WindowManager getWindowManager() {
        if (bzo() != null) {
            return bzo().getWindowManager();
        }
        return null;
    }

    public void openContextMenu(View view) {
        if (bzo() != null) {
            bzo().openContextMenu(view);
        }
    }

    public final Boolean aL(String str, boolean z) {
        if (this.nAV && this.oJ == null) {
            return Boolean.valueOf(bzo().getIntent().getBooleanExtra(str, z));
        }
        return Boolean.valueOf(this.oJ.getBoolean(str, z));
    }

    public final long NW(String str) {
        if (this.nAV && this.oJ == null) {
            return bzo().getIntent().getLongExtra(str, -1);
        }
        if (this.oJ != null) {
            return this.oJ.getLong(str, -1);
        }
        return -1;
    }

    public final void bzp() {
        if (this.nAV) {
            bzo().setResult(-1);
        }
    }

    public final void overridePendingTransition(int i, int i2) {
        if (bzo() != null) {
            bzo().overridePendingTransition(i, i2);
        }
    }

    public final boolean isShowing() {
        return !this.nAW;
    }
}
