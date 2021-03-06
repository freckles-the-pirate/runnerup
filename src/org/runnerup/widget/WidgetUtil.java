/*
 * Copyright (C) 2013 jonas.oreland@gmail.com
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.runnerup.widget;

import org.runnerup.R;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WidgetUtil {

	public static void setEditable(EditText editText, boolean onoff) {
		if (onoff == true) {
			editText.setClickable(onoff);
			editText.setFocusable(onoff);
			editText.setFocusableInTouchMode(onoff);
		} else {
			editText.setClickable(onoff);
			editText.setFocusable(onoff);
		}
	}

	public static View createHoloTabIndicator(Context ctx, String title) {
        Resources res = ctx.getResources(); // Resource object to get Drawables
        TextView txtTab = new TextView(ctx);
        txtTab.setText(title);
        txtTab.setTextColor(Color.WHITE);
        txtTab.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_HORIZONTAL);
        Drawable drawable = res.getDrawable(R.drawable.tab_indicator_holo);
        txtTab.setBackgroundDrawable(drawable); // R.drawable.tab_indicator_holo);
        txtTab.setLineSpacing(1 + 2 * drawable.getIntrinsicHeight(), 1);
        return txtTab;
    }
}
