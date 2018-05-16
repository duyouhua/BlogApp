package org.zzrblog.camera;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import org.zzrblog.blogapp.R;
import org.zzrblog.camera.gles.EglCore;

/**
 * Created by zzr on 2018/5/9.
 */

public class ContinuousRecordActivity extends Activity implements SurfaceHolder.Callback {

    public static final String TAG = "ContinuousRecord";

    SurfaceView sv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.continuous_record);

        sv = (SurfaceView) findViewById(R.id.continuousCapture_surfaceView);
        SurfaceHolder sh = sv.getHolder();
        sh.addCallback(this);
    }


    private EglCore mEglCore;

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.d(TAG, "surfaceCreated holder=" + surfaceHolder);
        //首先我们描述一下在这里即将发生的：
        // 我们等到一个surface创建回调给开发者我们，因为不能让一个EGL上下文没有一个渲染表面吧？！，
        mEglCore = new EglCore(null, EglCore.FLAG_RECORDABLE);
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }
}