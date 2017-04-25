package com.samsung.android.sdk.look.airbutton;

import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.ArrayList;

public class SlookAirButtonAdapter {
    private CharSequence mEmptyText;
    private ArrayList<AirButtonItem> mItemList = null;

    public static class AirButtonItem {
        private Object mData = null;
        private String mDescription = null;
        private Drawable mImage = null;
        private String mSubDescription = null;
        private View mView = null;

        public AirButtonItem(View view, Object obj) {
            if (view == null && obj == null) {
                throw new IllegalArgumentException("You should set the View and Object in Param");
            }
            set(view, obj);
        }

        public AirButtonItem(Drawable drawable, String str, Object obj) {
            if (drawable == null && str == null && obj == null) {
                throw new IllegalArgumentException("You should set the Drawable, String and Object in Param");
            }
            set(drawable, str, obj);
        }

        public AirButtonItem(Drawable drawable, String str, String str2, Object obj) {
            if (drawable == null && str == null && str2 == null && obj == null) {
                throw new IllegalArgumentException("You should set the Drawable, String, subDescription and Object in Param");
            }
            set(drawable, str, str2, obj);
        }

        public void set(View view, Object obj) {
            this.mView = view;
            this.mData = obj;
        }

        public void set(Drawable drawable, String str, Object obj) {
            this.mImage = drawable;
            this.mDescription = str;
            this.mData = obj;
        }

        public void set(Drawable drawable, String str, String str2, Object obj) {
            this.mImage = drawable;
            this.mDescription = str;
            this.mSubDescription = str2;
            this.mData = obj;
        }

        public View getView() {
            return this.mView;
        }

        public Drawable getImage() {
            return this.mImage;
        }

        public String getDescription() {
            return this.mDescription;
        }

        public String getSubDescription() {
            return this.mSubDescription;
        }

        public Object getData() {
            return this.mData;
        }
    }

    public SlookAirButtonAdapter(ArrayList<AirButtonItem> arrayList) {
        addItem((ArrayList) arrayList);
    }

    public void addItem(AirButtonItem airButtonItem) {
        if (this.mItemList == null) {
            this.mItemList = new ArrayList();
        }
        this.mItemList.add(airButtonItem);
    }

    public int addItem(ArrayList<AirButtonItem> arrayList) {
        if (this.mItemList != null) {
            this.mItemList.clear();
        }
        this.mItemList = arrayList;
        return this.mItemList.size() - 1;
    }

    public void insertItem(int i, AirButtonItem airButtonItem) {
        if (this.mItemList != null) {
            this.mItemList.add(i, airButtonItem);
        } else if (i == 0) {
            addItem(airButtonItem);
        } else {
            throw new IllegalArgumentException("The list is empty.");
        }
    }

    public void removeItem(int i) {
        if (this.mItemList == null) {
            throw new IllegalArgumentException("The list is empty.");
        }
        this.mItemList.remove(i);
    }

    public void updateItem(int i, AirButtonItem airButtonItem) {
        if (this.mItemList == null) {
            throw new IllegalArgumentException("The list is empty.");
        }
        this.mItemList.set(i, airButtonItem);
    }

    public void clear() {
        if (this.mItemList != null) {
            this.mItemList.clear();
        }
    }

    public int getCount() {
        if (this.mItemList == null) {
            return 0;
        }
        return this.mItemList.size();
    }

    public AirButtonItem getItem(int i) {
        if (this.mItemList == null || i >= this.mItemList.size()) {
            return null;
        }
        return (AirButtonItem) this.mItemList.get(i);
    }

    public void setEmptyText(CharSequence charSequence) {
        this.mEmptyText = charSequence;
    }

    public CharSequence getEmptyText() {
        return this.mEmptyText;
    }

    public boolean onHoverEnter(View view) {
        return true;
    }

    public void onHoverExit(View view) {
    }

    public void onShow(View view) {
    }

    public void onHide(View view) {
    }

    public void onDismiss(View view) {
    }
}
