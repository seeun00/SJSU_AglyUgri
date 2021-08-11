package com.Team8.aglyugri

import android.content.Context
import android.widget.Toast

class SeedData {
    companion object {
        var seeds = 0

        fun getFromReview(t: Context) {
            seeds += 10
            Toast.makeText(t,"Thank you! Get 10 Seeds:)", Toast.LENGTH_SHORT).show()
        }
        fun getFromDirect(t: Context) {
            seeds +=300
            Toast.makeText(t,"Thank you! Get 300 Seeds:)", Toast.LENGTH_SHORT).show()
        }
        fun getFromSubscrip(size: String, t: Context) {
            var s = 300
            if(size == "Big") {
                s=500
                seeds += 500
            }
            else seeds += 300
            Toast.makeText(t,"Thank you! Get ${s} Seeds:)", Toast.LENGTH_SHORT).show()
        }
        fun useSeeds(cnt : Int) {
            seeds -= cnt
        }
        fun getSeedCnd(): Int {
            return seeds
        }
    }
}