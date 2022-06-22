package developer.abdusamid.rvanimations

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import developer.abdusamid.rvanimations.adapters.RvAdapter
import developer.abdusamid.rvanimations.models.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RvAdapter.RvClick {
    lateinit var list: ArrayList<User>
    lateinit var userAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()
        rv.layoutManager = LinearLayoutManager(this)
        userAdapter = RvAdapter(this, this, list)
        rv.adapter = userAdapter
    }

    private fun loadData() {
        list = ArrayList()
        for (i in 0 until 50) {
            list.add(
                User(
                    "https://www.pngwing.com/ru/free-png-znzwp",
                    "Google"
                )
            )
            list.add(
                User(
                    "https://www.pngplay.com/ru/image/tag/windows-microsoft",
                    "Microsoft"
                )
            )
            list.add(
                User(
                    "https://ar.pinterest.com/pin/833377106021543612/",
                    "FaceBook"
                )
            )
        }
    }

    override fun onClick(user: User) {
        Toast.makeText(this, user.name, Toast.LENGTH_SHORT).show()
    }
}