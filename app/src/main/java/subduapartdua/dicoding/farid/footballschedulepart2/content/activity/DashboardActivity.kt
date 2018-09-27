package subduapartdua.dicoding.farid.footballschedulepart2.content.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_dashboard.*
import subduapartdua.dicoding.farid.footballschedulepart2.R

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        onClicked()
}
    private fun onClicked(){
        btn_next_match.setOnClickListener(){
            val intent = Intent(this, NextMatchActivity::class.java)
            startActivity(intent)
        }
        btn_prev_match.setOnClickListener(){
            val intent = Intent(this, PrevMatchActivity::class.java)
            startActivity(intent)
        }
    }
}