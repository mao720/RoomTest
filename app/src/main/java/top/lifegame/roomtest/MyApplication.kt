package top.lifegame.roomtest

import android.app.Application
import com.didichuxing.doraemonkit.DoraemonKit

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DoraemonKit.install(this, "d02bce6a10045cbc58c5e311157bc360")
    }
}