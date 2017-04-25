package android.support.v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ak;
import android.support.v4.app.ak.a;
import android.support.v4.app.s;
import android.support.v4.view.f;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mmdb.database.SQLiteDatabase;

public class AppCompatActivity extends FragmentActivity implements a, c {
    private int FA = 0;
    private boolean FB;
    private d Fz;

    public void onCreate(Bundle bundle) {
        d cU = cU();
        cU.cX();
        cU.onCreate(bundle);
        if (cU.cY() && this.FA != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.FA, false);
            } else {
                setTheme(this.FA);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.FA = i;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        cU().cW();
    }

    public MenuInflater getMenuInflater() {
        return cU().getMenuInflater();
    }

    public void setContentView(int i) {
        cU().setContentView(i);
    }

    public void setContentView(View view) {
        cU().setContentView(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        cU().setContentView(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        cU().addContentView(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        cU().onConfigurationChanged(configuration);
    }

    public void onStop() {
        super.onStop();
        cU().onStop();
    }

    protected void onPostResume() {
        super.onPostResume();
        cU().onPostResume();
    }

    public View findViewById(int i) {
        return cU().findViewById(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        ActionBar cV = cU().cV();
        if (menuItem.getItemId() != 16908332 || cV == null || (cV.getDisplayOptions() & 4) == 0) {
            return false;
        }
        return cT();
    }

    public void onDestroy() {
        super.onDestroy();
        cU().onDestroy();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        cU().setTitle(charSequence);
    }

    public final boolean aq(int i) {
        return cU().requestWindowFeature(i);
    }

    public void aR() {
        cU().invalidateOptionsMenu();
    }

    public void invalidateOptionsMenu() {
        cU().invalidateOptionsMenu();
    }

    private boolean cT() {
        int i = 0;
        Intent a = s.a(this);
        if (a == null) {
            return false;
        }
        if (s.a((Activity) this, a)) {
            Intent a2;
            ak j = ak.j(this);
            if (this instanceof a) {
                a = br();
            } else {
                a = null;
            }
            if (a == null) {
                a2 = s.a(this);
            } else {
                a2 = a;
            }
            if (a2 != null) {
                ComponentName component = a2.getComponent();
                if (component == null) {
                    component = a2.resolveActivity(j.tb.getPackageManager());
                }
                j.a(component);
                j.ta.add(a2);
            }
            if (j.ta.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) j.ta.toArray(new Intent[j.ta.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            Context context = j.tb;
            int i2 = VERSION.SDK_INT;
            if (i2 >= 16) {
                context.startActivities(intentArr, null);
                i = 1;
            } else if (i2 >= 11) {
                context.startActivities(intentArr);
                i = 1;
            }
            if (i == 0) {
                Intent intent = new Intent(intentArr[intentArr.length - 1]);
                intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                j.tb.startActivity(intent);
            }
            try {
                if (VERSION.SDK_INT >= 16) {
                    finishAffinity();
                } else {
                    finish();
                }
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            s.b((Activity) this, a);
        }
        return true;
    }

    public final Intent br() {
        return s.a(this);
    }

    public void onContentChanged() {
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        cU().onSaveInstanceState(bundle);
    }

    public final d cU() {
        if (this.Fz == null) {
            this.Fz = d.a((Activity) this, (c) this);
        }
        return this.Fz;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (f.a(keyEvent, 4096) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                ActionBar cV = cU().cV();
                if (cV != null && cV.isShowing() && cV.requestFocus()) {
                    this.FB = true;
                    return true;
                }
            } else if (action == 1 && this.FB) {
                this.FB = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }
}
