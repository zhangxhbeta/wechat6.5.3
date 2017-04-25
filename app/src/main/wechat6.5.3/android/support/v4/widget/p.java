package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class p extends e {
    private int CC;
    private int CD;
    private LayoutInflater CE;

    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.CE.inflate(this.CC, viewGroup, false);
    }

    public final View newDropDownView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.CE.inflate(this.CD, viewGroup, false);
    }
}
