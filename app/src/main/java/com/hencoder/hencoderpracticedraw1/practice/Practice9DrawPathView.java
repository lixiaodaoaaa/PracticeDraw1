package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api=Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
    
    
        Paint paint=new Paint(Paint.ANTI_ALIAS_FLAG);
    
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
    
        Path path = new Path(); // 初始化 Path 对象
    
        // 使用 path 对图形进行描述（这段描述代码不必看懂）
        path.addArc(100, 100, 200, 200, -225, 225);
//        path.arcTo(200, 100, 300, 200, -180, 225, false);
        path.lineTo(200, 300);
        
        canvas.drawPath(path,paint);
    }
}
