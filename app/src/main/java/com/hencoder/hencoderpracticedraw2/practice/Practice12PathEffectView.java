package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Path path = new Path();

    public Practice12PathEffectView(Context context) {
        super(context);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setStyle(Paint.Style.STROKE);

        path.moveTo(50, 100);
        path.rLineTo(50, 100);
        path.rLineTo(80, -150);
        path.rLineTo(100, 100);
        path.rLineTo(70, -120);
        path.rLineTo(150, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        PathEffect cornerPath =new CornerPathEffect(10);
        paint.setPathEffect(cornerPath);
        canvas.drawPath(path, paint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect
        PathEffect pathEffect =new DiscretePathEffect(20,10);
        paint.setPathEffect(pathEffect);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        PathEffect dashPath =new DashPathEffect(new float[]{10,20},10);
        paint.setPathEffect(dashPath);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        // 第四处：PathDashPathEffect
        Path path1 =new Path();
        path1.moveTo(0,0);
        path1.lineTo(20,20);
        path1.lineTo(40,0);
        path1.close();
//        path1.addCircle(5,5,10, Path.Direction.CW);
        PathEffect pathEffect1 =new PathDashPathEffect(path1,50,20,PathDashPathEffect.Style.TRANSLATE);
        paint.setPathEffect(pathEffect1);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        PathEffect sumPath1 =new DashPathEffect(new float[]{20,10},10);
        PathEffect sumPath2 =new DiscretePathEffect(20,10);
        PathEffect sumPath =new SumPathEffect(sumPath1,sumPath2);
        paint.setPathEffect(sumPath);
        canvas.drawPath(path, paint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect
        PathEffect composePath1 =new DashPathEffect(new float[]{20,10},10);//长短虚线
        PathEffect composePath2 =new DiscretePathEffect(20,10);//偏移抖动
        PathEffect composePath =new ComposePathEffect(composePath1,composePath2);
        paint.setPathEffect(composePath);
        canvas.drawPath(path, paint);
        canvas.restore();
    }
}
