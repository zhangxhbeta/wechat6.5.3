package com.qq.taf.jce.dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class StructField extends JceField {
    private static final Comparator<JceField> tagComp = new Comparator<JceField>() {
        public int compare(JceField jceField, JceField jceField2) {
            return jceField.getTag() - jceField2.getTag();
        }
    };
    private JceField[] data;

    StructField(JceField[] jceFieldArr, int i) {
        super(i);
        this.data = jceFieldArr;
    }

    public JceField[] get() {
        return this.data;
    }

    public boolean setByTag(int i, JceField jceField) {
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i), tagComp);
        if (binarySearch >= 0) {
            this.data[binarySearch] = jceField;
            return true;
        }
        binarySearch = (-binarySearch) - 1;
        JceField[] jceFieldArr = new JceField[(this.data.length + 1)];
        for (int i2 = 0; i2 < binarySearch; i2++) {
            jceFieldArr[i2] = this.data[i2];
        }
        jceFieldArr[binarySearch] = jceField;
        while (binarySearch < this.data.length) {
            jceFieldArr[binarySearch + 1] = this.data[binarySearch];
            binarySearch++;
        }
        return false;
    }

    public JceField getFieldByTag(int i) {
        int binarySearch = Arrays.binarySearch(this.data, JceField.createZero(i), tagComp);
        return binarySearch >= 0 ? this.data[binarySearch] : null;
    }
}
