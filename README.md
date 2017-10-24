## BaseAndroid框架
#### 使用Gradla导入~不需要在Demo上修改
#### 一丶集成功能
1.图片加载缓存
2.网络请求
3.屏幕适配
4.app更新
5.依赖注入
6.各种工具类~ 好多好多
7.三大常用列表view的adapter封装
8.防止内存溢出UIImageView控件
9.动画框架
10.对Dialog的封装和DialogPool工具类的编写，易于使用并提升响应速度。
11.美化log，并对常用log做封装，如json，array，map的打印
//...
#### 二丶如何导入
1.Module下
```
dependencies {
    //...
    compile 'com.github.shuhaoSCode:BaseAndroid:1.0.2'
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

#### 三丶如何使用
1.创建MyApplication继承CommonApplication，并在manifests中配置
2.Activity继承CommonActivity并删除自动生成的onCreate,然后实现新的onCreate和bindLayout。新的onCreate和原来的使用没有区别，bindlayout设置布局文件。
```
//这么使用就可以~
@Override
    protected void onCreate() {
        getToast("大概就这么使用的~有木有很简单");
    }

    @Override
    protected int bindLayout() {
        return R.layout.activity_main;
    }
```
3.屏幕适配
假如当前设计图为1280*720，
在manifests中application下贴入如下代码
```
        <meta-data
            android:name="design_width"
            android:value="720" />
        <meta-data
            android:name="design_height"
            android:value="1280" />
```
以后所有布局直接写px单位就行，所有的分辨率的设备都能按照比例去设置，在也不用和美工小姐姐们解释什么是dp啦。
4.图片G

#### 四丶混淆代码
```
-keep class com.blankj.utilcode.** { *; }
-keepclassmembers class com.blankj.utilcode.** { *; }
-dontwarn com.blankj.utilcode.**
```
[![](https://jitpack.io/v/shuhaoSCode/BaseAndroid.svg)](https://jitpack.io/#shuhaoSCode/BaseAndroid)
