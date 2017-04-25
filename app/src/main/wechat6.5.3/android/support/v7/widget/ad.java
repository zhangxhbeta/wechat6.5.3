package android.support.v7.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

class ad extends Resources {
    private final Resources BE;

    public ad(Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.BE = resources;
    }

    public CharSequence getText(int i) {
        return this.BE.getText(i);
    }

    public CharSequence getQuantityText(int i, int i2) {
        return this.BE.getQuantityText(i, i2);
    }

    public String getString(int i) {
        return this.BE.getString(i);
    }

    public String getString(int i, Object... objArr) {
        return this.BE.getString(i, objArr);
    }

    public String getQuantityString(int i, int i2, Object... objArr) {
        return this.BE.getQuantityString(i, i2, objArr);
    }

    public String getQuantityString(int i, int i2) {
        return this.BE.getQuantityString(i, i2);
    }

    public CharSequence getText(int i, CharSequence charSequence) {
        return this.BE.getText(i, charSequence);
    }

    public CharSequence[] getTextArray(int i) {
        return this.BE.getTextArray(i);
    }

    public String[] getStringArray(int i) {
        return this.BE.getStringArray(i);
    }

    public int[] getIntArray(int i) {
        return this.BE.getIntArray(i);
    }

    public TypedArray obtainTypedArray(int i) {
        return this.BE.obtainTypedArray(i);
    }

    public float getDimension(int i) {
        return this.BE.getDimension(i);
    }

    public int getDimensionPixelOffset(int i) {
        return this.BE.getDimensionPixelOffset(i);
    }

    public int getDimensionPixelSize(int i) {
        return this.BE.getDimensionPixelSize(i);
    }

    public float getFraction(int i, int i2, int i3) {
        return this.BE.getFraction(i, i2, i3);
    }

    public Drawable getDrawable(int i) {
        return this.BE.getDrawable(i);
    }

    public Drawable getDrawable(int i, Theme theme) {
        return this.BE.getDrawable(i, theme);
    }

    public Drawable getDrawableForDensity(int i, int i2) {
        return this.BE.getDrawableForDensity(i, i2);
    }

    public Drawable getDrawableForDensity(int i, int i2, Theme theme) {
        return this.BE.getDrawableForDensity(i, i2, theme);
    }

    public Movie getMovie(int i) {
        return this.BE.getMovie(i);
    }

    public int getColor(int i) {
        return this.BE.getColor(i);
    }

    public ColorStateList getColorStateList(int i) {
        return this.BE.getColorStateList(i);
    }

    public boolean getBoolean(int i) {
        return this.BE.getBoolean(i);
    }

    public int getInteger(int i) {
        return this.BE.getInteger(i);
    }

    public XmlResourceParser getLayout(int i) {
        return this.BE.getLayout(i);
    }

    public XmlResourceParser getAnimation(int i) {
        return this.BE.getAnimation(i);
    }

    public XmlResourceParser getXml(int i) {
        return this.BE.getXml(i);
    }

    public InputStream openRawResource(int i) {
        return this.BE.openRawResource(i);
    }

    public InputStream openRawResource(int i, TypedValue typedValue) {
        return this.BE.openRawResource(i, typedValue);
    }

    public AssetFileDescriptor openRawResourceFd(int i) {
        return this.BE.openRawResourceFd(i);
    }

    public void getValue(int i, TypedValue typedValue, boolean z) {
        this.BE.getValue(i, typedValue, z);
    }

    public void getValueForDensity(int i, int i2, TypedValue typedValue, boolean z) {
        this.BE.getValueForDensity(i, i2, typedValue, z);
    }

    public void getValue(String str, TypedValue typedValue, boolean z) {
        this.BE.getValue(str, typedValue, z);
    }

    public TypedArray obtainAttributes(AttributeSet attributeSet, int[] iArr) {
        return this.BE.obtainAttributes(attributeSet, iArr);
    }

    public void updateConfiguration(Configuration configuration, DisplayMetrics displayMetrics) {
        super.updateConfiguration(configuration, displayMetrics);
        if (this.BE != null) {
            this.BE.updateConfiguration(configuration, displayMetrics);
        }
    }

    public DisplayMetrics getDisplayMetrics() {
        return this.BE.getDisplayMetrics();
    }

    public Configuration getConfiguration() {
        return this.BE.getConfiguration();
    }

    public int getIdentifier(String str, String str2, String str3) {
        return this.BE.getIdentifier(str, str2, str3);
    }

    public String getResourceName(int i) {
        return this.BE.getResourceName(i);
    }

    public String getResourcePackageName(int i) {
        return this.BE.getResourcePackageName(i);
    }

    public String getResourceTypeName(int i) {
        return this.BE.getResourceTypeName(i);
    }

    public String getResourceEntryName(int i) {
        return this.BE.getResourceEntryName(i);
    }

    public void parseBundleExtras(XmlResourceParser xmlResourceParser, Bundle bundle) {
        this.BE.parseBundleExtras(xmlResourceParser, bundle);
    }

    public void parseBundleExtra(String str, AttributeSet attributeSet, Bundle bundle) {
        this.BE.parseBundleExtra(str, attributeSet, bundle);
    }
}
