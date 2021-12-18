package com.touch.harvic.testtouchevent;

import android.util.Log;
import android.view.MotionEvent;

public class LogHelper {
    public static void onLog(String str, MotionEvent event){
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.append("  EVENT:");
        switch (event.getAction()){
        case MotionEvent.ACTION_DOWN:{
            stringBuilder.append(" ACTION DOWN");
        }
        break;
        case MotionEvent.ACTION_MOVE:{
            stringBuilder.append(" ACTION_MOVE");
        }
        break;
        case MotionEvent.ACTION_UP:{
            stringBuilder.append(" ACTION_UP");
        }
        break;
        case MotionEvent.ACTION_CANCEL:{
            stringBuilder.append(" ACTION_CANCEL");
        }
        break;
        default:
            stringBuilder.append("  "+event.getAction());
        }
        Log.d("qijian",stringBuilder.toString());



    }
}
