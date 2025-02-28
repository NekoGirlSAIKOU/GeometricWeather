package wangdaye.com.geometricweather.settings.dialogs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import wangdaye.com.geometricweather.R;
import wangdaye.com.geometricweather.common.basic.GeoDialog;
import wangdaye.com.geometricweather.common.basic.models.weather.WeatherCode;
import wangdaye.com.geometricweather.theme.resource.ResourceHelper;
import wangdaye.com.geometricweather.theme.resource.providers.ResourceProvider;

public class MinimalIconDialog extends GeoDialog {

    public static void show(Context context,
                            WeatherCode code,
                            boolean daytime,
                            ResourceProvider provider) {
        View view = LayoutInflater
                .from(context)
                .inflate(R.layout.dialog_minimal_icon, null, false);
        initWidget(view, code, daytime, provider);

        new MaterialAlertDialogBuilder(context)
                .setTitle(code.name() + (daytime ? "_DAY" : "_NIGHT"))
                .setView(view)
                .show();
    }

    @SuppressLint("SetTextI18n")
    private static void initWidget(View view,
                                   WeatherCode code,
                                   boolean daytime,
                                   ResourceProvider provider) {
        AppCompatImageView lightIconView = view.findViewById(R.id.dialog_minimal_icon_lightIcon);
        lightIconView.setImageDrawable(ResourceHelper.getWidgetNotificationIcon(
                provider, code, daytime, true, "light"));

        AppCompatImageView greyIconView = view.findViewById(R.id.dialog_minimal_icon_greyIcon);
        greyIconView.setImageDrawable(ResourceHelper.getWidgetNotificationIcon(
                provider, code, daytime, true, "grey"));

        AppCompatImageView darkIconView = view.findViewById(R.id.dialog_minimal_icon_darkIcon);
        darkIconView.setImageDrawable(ResourceHelper.getWidgetNotificationIcon(
                provider, code, daytime, true, "dark"));
    }
}
