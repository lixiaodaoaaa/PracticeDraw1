package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ComposeShader;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

public class Practice1DrawColorView extends View{
    
    
    private Paint paint;
    
    private int mWidth;
    private int mHeight;
    
    private float rectWidth=150;
    private float rectHeight=170;
    private float marginTop=50.0f;
    
    
    public Practice1DrawColorView(Context context){
        super(context);
    }
    
    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
    }
    
    public Practice1DrawColorView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
    }
    
    
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        super.onSizeChanged(w, h, oldw, oldh);
        mWidth=w;
        mHeight=h;
    }
    
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.FILL);
        
        Shader shader=new ComposeShader(getBitmapShader01(), getBitmapShader02(), PorterDuff.Mode.SRC_OVER);
        paint.setShader(shader);
        float radius=mWidth / 2 - mWidth / 5;
        canvas.drawCircle(mWidth / 2, mHeight / 2, radius, paint);
    
    }
    
    private BitmapShader getBitmapShader01(){
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        
        return new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR);
    }
    
    private BitmapShader getBitmapShader02(){
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.sample_path);
        return new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }
}
