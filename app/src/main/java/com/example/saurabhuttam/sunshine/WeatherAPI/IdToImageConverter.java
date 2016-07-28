package com.example.saurabhuttam.sunshine.WeatherAPI;

import android.app.Activity;

import com.example.saurabhuttam.sunshine.R;

/**
 * Created by Saurabh Uttam on 7/28/2016.
 */
public class IdToImageConverter {
    private IdToImageConverter()
    {

    }
    public static String getConverter(Activity activity, int icon)
    {

        String iconText="";
        switch (icon)
        {
            case 200:
                iconText=activity.getString(R.string.icon_200);
                break;
            case 201:
                iconText=activity.getString(R.string.icon_201);
                break;
            case 202:
                iconText=activity.getString(R.string.icon_202);
                break;
            case 210:
                iconText=activity.getString(R.string.icon_210);
                break;
            case 211:
                iconText=activity.getString(R.string.icon_211);
                break;
            case 212:
                iconText=activity.getString(R.string.icon_212);
                break;
            case 221:
                iconText=activity.getString(R.string.icon_221);
                break;
            case 230:
                iconText=activity.getString(R.string.icon_230);
                break;
            case 231:
                iconText=activity.getString(R.string.icon_231);
                break;
            case 232:
                iconText=activity.getString(R.string.icon_232);
                break;
            case 300:
                iconText=activity.getString(R.string.icon_300);
                break;
            case 301:
                iconText=activity.getString(R.string.icon_301);
                break;
            case 302:
                iconText=activity.getString(R.string.icon_302);
                break;
            case 310:
                iconText=activity.getString(R.string.icon_310);
                break;
            case 311:
                iconText=activity.getString(R.string.icon_311);
                break;
            case 312:
                iconText=activity.getString(R.string.icon_312);
                break;
            case 313:
                iconText=activity.getString(R.string.icon_313);
                break;
            case 314:
                iconText=activity.getString(R.string.icon_314);
                break;
            case 321:
                iconText=activity.getString(R.string.icon_321);
                break;
            case 500:
                iconText=activity.getString(R.string.icon_500);
                break;
            case 501:
                iconText=activity.getString(R.string.icon_500);
                break;
            case 502:
                iconText=activity.getString(R.string.icon_502);
                break;
            case 503:
                iconText=activity.getString(R.string.icon_503);
                break;
            case 504:
                iconText=activity.getString(R.string.icon_504);
                break;
            case 511:
                iconText=activity.getString(R.string.icon_511);
                break;
            case 520:
                iconText=activity.getString(R.string.icon_520);
                break;
            case 521:
                iconText=activity.getString(R.string.icon_521);
                break;
            case 522:
                iconText=activity.getString(R.string.icon_522);
                break;
            case 531:
                iconText=activity.getString(R.string.icon_531);
                break;
            case 600:
                iconText=activity.getString(R.string.icon_600);
                break;
            case 601:
                iconText=activity.getString(R.string.icon_601);
                break;
            case 602:
                iconText=activity.getString(R.string.icon_602);
                break;
            case 611:
                iconText=activity.getString(R.string.icon_611);
                break;
            case 612:
                iconText=activity.getString(R.string.icon_612);
                break;
            case 615:
                iconText=activity.getString(R.string.icon_615);
                break;
            case 616:
                iconText=activity.getString(R.string.icon_616);
                break;
            case 620:
                iconText=activity.getString(R.string.icon_620);
                break;
            case 621:
                iconText=activity.getString(R.string.icon_621);
                break;
            case 622:
                iconText=activity.getString(R.string.icon_622);
                break;
            case 701:
                iconText=activity.getString(R.string.icon_701);
                break;
            case 711:
                iconText=activity.getString(R.string.icon_711);
                break;
            case 721:
                iconText=activity.getString(R.string.icon_721);
                break;
            case 731:
                iconText=activity.getString(R.string.icon_731);
                break;
            case 741:
                iconText=activity.getString(R.string.icon_741);
                break;
            case 761:
                iconText=activity.getString(R.string.icon_761);
                break;
            case 762:
                iconText=activity.getString(R.string.icon_762);
                break;
            case 771:
                iconText=activity.getString(R.string.icon_771);
                break;
            case 781:
                iconText=activity.getString(R.string.icon_781);
                break;
            case 800:
                iconText=activity.getString(R.string.icon_800);
                break;
            case 801:
                iconText=activity.getString(R.string.icon_801);
                break;
            case 802:
                iconText=activity.getString(R.string.icon_802);
                break;
            case 803:
                iconText=activity.getString(R.string.icon_803);
                break;
            case 804:
                iconText=activity.getString(R.string.icon_804);
                break;
            case 900:
                iconText=activity.getString(R.string.icon_900);
                break;
            case 901:
                iconText=activity.getString(R.string.icon_901);
                break;
            case 902:
                iconText=activity.getString(R.string.icon_902);
                break;
            case 903:
                iconText=activity.getString(R.string.icon_903);
                break;
            case 904:
                iconText=activity.getString(R.string.icon_904);
                break;
            case 905:
                iconText=activity.getString(R.string.icon_905);
                break;
            case 906:
                iconText=activity.getString(R.string.icon_906);
                break;
            case 957:
                iconText=activity.getString(R.string.icon_957);
                break;
            default:
                iconText=icon+"";



        }
        return iconText;
    }



}
