package com.message.copy.service;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

import java.util.List;

/**
 * Created by bill.wang on 2016/9/23.
 */
public class MyAccessibilityService extends AccessibilityService {
    private static final String TAG = "MyAccessibilityService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: ");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.e(TAG, "onServiceConnected: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: " );
        return super.onUnbind(intent);
    }


    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        int eventType = event.getEventType();
        switch (eventType) {
            case AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED://红包主体弹框,未打开
                Log.d(TAG, "TYPE_WINDOW_STATE_CHANGED");
                break;
            case AccessibilityEvent.TYPE_GESTURE_DETECTION_START:
                Log.d(TAG, "TYPE_GESTURE_DETECTION_START");
                break;
            case AccessibilityEvent.TYPE_GESTURE_DETECTION_END:
                Log.d(TAG, "TYPE_GESTURE_DETECTION_END");
                break;
            case AccessibilityEvent.TYPE_ANNOUNCEMENT:
                Log.d(TAG, "TYPE_ANNOUNCEMENT");
                break;
            case AccessibilityEvent.TYPE_ASSIST_READING_CONTEXT:
                Log.d(TAG, "TYPE_ASSIST_READING_CONTEXT");
                break;
            case AccessibilityEvent.TYPE_NOTIFICATION_STATE_CHANGED:
                Log.d(TAG, "TYPE_NOTIFICATION_STATE_CHANGED");
                break;
            case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_END:
                Log.d(TAG, "TYPE_TOUCH_EXPLORATION_GESTURE_END");
                break;
            case AccessibilityEvent.TYPE_TOUCH_EXPLORATION_GESTURE_START:
                Log.d(TAG, "TYPE_TOUCH_EXPLORATION_GESTURE_START");
                break;
            case AccessibilityEvent.TYPE_VIEW_FOCUSED:
                Log.d(TAG, "TYPE_VIEW_FOCUSED");
                break;
            case AccessibilityEvent.TYPE_VIEW_SCROLLED://有红包过来
                Log.d(TAG, "TYPE_VIEW_SCROLLED");
                break;
            case AccessibilityEvent.TYPE_VIEW_LONG_CLICKED:
                Log.d(TAG, "TYPE_VIEW_LONG_CLICKED");
                break;
            case AccessibilityEvent.TYPE_VIEW_SELECTED:
                Log.d(TAG, "TYPE_VIEW_SELECTED");
                break;
            case AccessibilityEvent.TYPE_VIEW_CONTEXT_CLICKED:
                Log.d(TAG, "TYPE_VIEW_CONTEXT_CLICKED");
                break;
            case AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED:
                Log.d(TAG, "TYPE_VIEW_ACCESSIBILITY_FOCUSED");
                break;
            case AccessibilityEvent.TYPE_VIEW_TEXT_CHANGED:
                Log.d(TAG, "TYPE_VIEW_TEXT_CHANGED");
                List<CharSequence> textList = event.getText();
                for (CharSequence text : textList) {
                    Log.d(TAG, "text=" + text +
                            ",package=" + event.getPackageName() +
                            ",time=" + event.getEventTime() +
                            ",className=" + event.getClassName() +
                            ",beforeText=" + event.getBeforeText() +
                            ",content" + event.getContentDescription() +
                            ",addedCount" + event.getAddedCount() +
                            ",recordCount=" + event.getRecordCount());
                }
                break;
        }

    }

    @Override
    public void onInterrupt() {
        Log.e(TAG, "onInterrupt: ");

    }
}
