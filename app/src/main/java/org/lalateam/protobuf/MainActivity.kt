package org.lalateam.protobuf

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.centling.protobuf.ProtoEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = assets.open("CDBASIC")
        tv.append("大小: ${input.available() / 1024f / 1024f}mb\n")
        val t = System.currentTimeMillis()
        val list = ProtoEntity.basecodelist.parseFrom(input)
        tv.append("耗时: ${System.currentTimeMillis() - t}ms\n")
        tv.append("项数: ${list.entityOrBuilderList.size}\n")
        tv.append("\n前20项数据:\n")
        list.entityOrBuilderList.take(20).forEach { tv.append("${it.attrcd}\t\t${it.cd}\t\t\t${it.speccn}\n") }
        input.close()
    }
}
