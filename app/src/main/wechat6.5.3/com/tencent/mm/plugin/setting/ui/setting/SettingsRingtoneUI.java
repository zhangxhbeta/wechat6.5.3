package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import com.tencent.mm.h.i;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.k.b;

public class SettingsRingtoneUI extends MMActivity implements OnItemClickListener, Runnable {
    private Cursor Ay;
    private RingtoneManager iMH;
    LayoutInflater iMI;
    private int iMJ = -1;
    private int iMK = -1;
    private Ringtone iML;
    private ac mHandler;

    private class a extends BaseAdapter {
        Cursor bbY;
        int count = 0;
        final /* synthetic */ SettingsRingtoneUI iMM;
        int padding = 0;

        public final /* synthetic */ Object getItem(int i) {
            return hd(i);
        }

        public a(SettingsRingtoneUI settingsRingtoneUI, Cursor cursor) {
            this.iMM = settingsRingtoneUI;
            this.bbY = cursor;
            this.count = cursor.getCount() + 1;
            v.d("RingtonePickerActivity", "count = " + this.count);
            this.padding = settingsRingtoneUI.getResources().getDimensionPixelSize(2131493168);
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) this.iMM.iMI.inflate(2130904328, null);
            if (i == 0) {
                checkedTextView.setBackgroundResource(2130838046);
                checkedTextView.setText(2131235084);
            } else {
                checkedTextView.setBackgroundResource(2130838046);
                checkedTextView.setText(hd(i));
            }
            checkedTextView.setPadding(this.padding, 0, this.padding, 0);
            checkedTextView.setCheckMarkDrawable(2130839059);
            return checkedTextView;
        }

        public final int getCount() {
            return this.count;
        }

        private String hd(int i) {
            if (this.bbY.isClosed() || !this.bbY.moveToPosition(i - 1)) {
                return "";
            }
            return this.bbY.getString(this.bbY.getColumnIndex(FFmpegMetadataRetriever.METADATA_KEY_TITLE));
        }

        public final long getItemId(int i) {
            return (long) i;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mHandler = new ac();
        this.iMI = LayoutInflater.from(this);
        this.iMH = new RingtoneManager(this);
        this.iMH.setType(2);
        setVolumeControlStream(5);
        this.iML = RingtoneManager.getRingtone(this, RingtoneManager.getDefaultUri(2));
        vD(2131235085);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsRingtoneUI iMM;

            {
                this.iMM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.iMM.axg();
                this.iMM.finish();
                return true;
            }
        });
        a(0, getString(2131235036), new OnMenuItemClickListener(this) {
            final /* synthetic */ SettingsRingtoneUI iMM;

            {
                this.iMM = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                String uri;
                Editor edit = this.iMM.getSharedPreferences(aa.bti(), 0).edit();
                if (this.iMM.iMK != 0) {
                    Uri a = this.iMM.iMH.getRingtoneUri(this.iMM.iMK - 1);
                    v.d("RingtonePickerActivity", "set ringtone to " + a);
                    if (a != null) {
                        uri = a.toString();
                        String a2 = RingtoneManager.getRingtone(this.iMM, a).getTitle(this.iMM);
                        edit.putString("settings.ringtone.name", a2);
                        v.d("RingtonePickerActivity", "ringtone name: " + a2);
                    } else {
                        uri = i.cgI;
                        edit.putString("settings.ringtone.name", this.iMM.getString(2131235084));
                        v.d("RingtonePickerActivity", "set ringtone follow system");
                    }
                } else {
                    uri = i.cgI;
                    edit.putString("settings.ringtone.name", this.iMM.getString(2131235084));
                    v.d("RingtonePickerActivity", "set ringtone follow system");
                }
                edit.commit();
                i.dz(uri);
                this.iMM.finish();
                return true;
            }
        }, b.nET);
        ListView listView = (ListView) findViewById(2131759091);
        View view = new View(this);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131493135);
        view.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        View view2 = new View(this);
        view2.setLayoutParams(new LayoutParams(-1, dimensionPixelSize));
        view.setClickable(false);
        view2.setClickable(false);
        listView.addHeaderView(view);
        listView.addFooterView(view2);
        this.Ay = this.iMH.getCursor();
        listView.setAdapter(new a(this, this.Ay));
        listView.setItemsCanFocus(false);
        listView.setOnItemClickListener(this);
        String sw = i.sw();
        if (sw != i.cgI) {
            int ringtonePosition = this.iMH.getRingtonePosition(Uri.parse(sw));
            if (ringtonePosition >= 0) {
                ringtonePosition += 2;
            } else {
                ringtonePosition = 1;
            }
            this.iMJ = ringtonePosition;
            this.iMK = this.iMJ - 1;
        } else {
            this.iMJ = 1;
        }
        listView.setItemChecked(this.iMJ, true);
        listView.setSelection(this.iMJ);
    }

    protected final int getLayoutId() {
        return 2130904360;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.mHandler.removeCallbacks(this);
        this.iMK = i - 1;
        this.mHandler.postDelayed(this, 300);
    }

    public void run() {
        if (!isFinishing()) {
            Ringtone ringtone;
            if (this.iMK == 0) {
                ringtone = this.iML;
            } else {
                ringtone = this.iMH.getRingtone(this.iMK - 1);
            }
            if (ringtone != null) {
                try {
                    ringtone.play();
                } catch (Throwable e) {
                    v.a("RingtonePickerActivity", e, "play ringtone error", new Object[0]);
                }
            }
        }
    }

    protected void onStop() {
        this.iMH.stopPreviousRingtone();
        super.onStop();
    }

    protected void onDestroy() {
        this.mHandler.removeCallbacks(this);
        if (!(this.Ay == null || this.Ay.isClosed())) {
            this.Ay.close();
            this.Ay = null;
        }
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 24 || i == 25) {
            return super.onKeyUp(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
