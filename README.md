# AnimationDemo
Android动画总结

Android 动画总结

1.帧动画：将图片一张张的播放，从而达到一种动画效果。它容易产生OOM，使用中应该避免使用过多的尺寸较大的图片。
实现步骤：
1.在res/drawable/目录下定义一个XML动画文件；
2.在Java代码中调用start()方法开启动画。
 

京东动画实现

<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:drawable="@drawable/a_0"
        android:duration="100" />
    <item
        android:drawable="@drawable/a_1"
        android:duration="100" />
    <item
        android:drawable="@drawable/a_2"
        android:duration="100" />
</animation-list>


protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);
        ImageView animationImg1 = (ImageView) findViewById(R.id.animation1);
         animationImg1.setImageResource(R.drawable.frame_anim1);
         AnimationDrawable animationDrawable1 = (AnimationDrawable) animationImg1.getBackground;

         animationDrawable1.start();
       }

2.补间动画/View动画:可以对View实现透明度（对应AlphaAnimation类）、旋转（RotateAnimation）、

平移（TranslateAnimation）、缩放（ScaleAnimation）四种动画操作。
这四种动画既可以通过XML文件来定义，也可以通过代码动态创建。为了动画可读性更好，推荐使用XML文件来定义动画。
使用步骤：
1.在res/anim/文件夹下定义一个动画资源文件；
2.在JAVA代码中按照如下方式加载这个动画。
eg：

<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:shareInterpolator="true">
    <alpha
        android:duration="300"
        android:fromAlpha="0"
        android:toAlpha="1" />
    <rotate
        android:duration="600"
        android:fromDegrees="0"
        android:toDegrees="90" />
    <scale
        android:duration="400"
        android:fromXScale="0.5"
        android:fromYScale="0.5"
        android:toXScale="2"
        android:toYScale="2" />
    <translate
        android:duration="100"
        android:fromXDelta="0"
        android:fromYDelta="0"
        android:toXDelta="100"
        android:toYDelta="100" />
</set>

//            使用AnimationUtils工具类加载res/anim/下面的一个动画资源文件
     Animation animation= AnimationUtils.loadAnimation(MainActivity.this,R.anim.alpha_animation);
                /*
                *  也可以使用JAVA代码创建动画
                *  AlphaAnimation animation = new AlphaAnimation(0, 1);
                   animation.setDuration(3000);
                *
                * */
//             对按钮进行动画操作
               btn.startAnimation(animation);


3.属性动画：API11新加入的特性，操作对象不限于View，而是对任意对象。它对应着三个类：ObjectAnimator（继承自ValueAnimator）、ValueAnimator、AnimatorSet(动画集)。
可以在res/animator/下面定义一个属性动画的XML文件，但是有些对象的属性起始值无法预先知道，因此推荐在代码中动态创建。
eg:

//           使用属性动画改变按钮的背景色,在3秒内实现颜色从蓝色渐变为绿色，动画会无限播放并且会有反转效果
                ObjectAnimator colorAnim=ObjectAnimator.ofInt(btn,"backgroundColor", Color.BLUE,Color.GREEN);
                colorAnim.setDuration(3000);
                colorAnim.setEvaluator(new ArgbEvaluator());
                colorAnim.setRepeatCount(ValueAnimator.INFINITE);
                colorAnim.setRepeatMode(ValueAnimator.REVERSE);
                colorAnim.start();














