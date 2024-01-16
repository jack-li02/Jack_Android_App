package com.example.jackapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val g1 = arrayOfNulls<TextView>(6)
    private val g1n = intArrayOf(R.id.g1_n1, R.id.g1_n2, R.id.g1_n3, R.id.g1_n4, R.id.g1_n5, R.id.g1_n6)
    private val g2 = arrayOfNulls<TextView>(6)
    private val g2n = intArrayOf(R.id.g2_n1, R.id.g2_n2, R.id.g2_n3, R.id.g2_n4, R.id.g2_n5, R.id.g2_n6)
    private val g3 = arrayOfNulls<TextView>(6)
    private val g3n = intArrayOf(R.id.g3_n1, R.id.g3_n2, R.id.g3_n3, R.id.g3_n4, R.id.g3_n5, R.id.g3_n6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    fun initView() {
        for (i in g1.indices) {
            g1[i] = findViewById(g1n[i])
            g1[i]?.text = "-"
        }
        for (i in g2.indices) {
            g2[i] = findViewById(g2n[i])
            g2[i]?.text = "-"
        }
        for (i in g3.indices) {
            g3[i] = findViewById(g3n[i])
            g3[i]?.text = "-"
        }
    }

    fun lottery(view: View) {
        val nums1 = createLottery()
        for (i in g1.indices) {
            g1[i]?.text = nums1[i].toString()
        }
        val nums2 = createLottery()
        for (i in g2.indices) {
            g2[i]?.text = nums2[i].toString()
        }
        val nums3 = createLottery()
        for (i in g3.indices) {
            g3[i]?.text = nums3[i].toString()
        }
    }

    fun createLottery(): IntArray {
        val nums = HashSet<Int>()
        while (nums.size < 6) {
            nums.add((Math.random() * 49 + 1).toInt())
        }
        var i = 0
        val ret = IntArray(6)
        for (num in nums) {
            ret[i] = num
            i++
        }
        return ret
    }
}

