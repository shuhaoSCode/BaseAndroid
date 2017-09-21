##BaseAndroid框架
####使用Gradla导入~不需要在Demo上修改

####一丶集成功能
1.图片加载缓存
2.api请求
3.屏幕适配
4.app更新
5.依赖注入
6.各种工具类~ 好多好多
7.三大服用view的adapter封装
8.防止内存溢出UIImageView控件
9.动画框架
//...

####二丶如何导入
1.Module下
```
dependencies {
    //...
    compile 'com.github.shuhaoSCode:BaseAndroid:1.0.1'
    annotationProcessor 'com.jakewharton:butterknife-compiler:8.8.1'
}
```
2.Project下(对照下都有没有 没有加上就好啦)
```
buildscript {
    repositories {
        //...
        mavenCentral()
    }
    dependencies {
        //...
        classpath 'com.jakewharton:butterknife-gradle-plugin:8.8.1'
    }
}

allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```
完成上两步后点下Syns Now等待完成即可

3.创建MyApplication并继承CommonApplication
4.Activity继承CommonActivity并删除自动生成的onCreate，然后实现
两个方法onCreate和bindLayout。onCreate和父类的Activity的使用方式一样，bindLayout直接return 当前activity的布局文件即可。
```

@Override
    protected void onCreate() {
        getToast("大概就这么使用的~有木有很简单");
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }
```
4.屏幕适配，贴代码~

```
        <meta-data
            android:name="design_width"
            android:value="720" />
        <meta-data
            android:name="design_height"
            android:value="1280" />
```
直接把当前美工给的分辨率直接贴进去，以后所有布局直接写px单位就行，所有的分辨率的设备都能按照比例去设置，在也不用和美工小姐姐们解释什么是dp啦。

####三丶混淆代码
```
-keep class com.blankj.utilcode.** { *; }
-keepclassmembers class com.blankj.utilcode.** { *; }
-dontwarn com.blankj.utilcode.**
```
[![](https://jitpack.io/v/shuhaoSCode/BaseAndroid.svg)](https://jitpack.io/#shuhaoSCode/BaseAndroid)
