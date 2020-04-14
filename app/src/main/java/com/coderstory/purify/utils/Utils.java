package com.coderstory.purify.utils;

import android.content.Context;

public class Utils {
    public static int convertDpToPixel(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
}
