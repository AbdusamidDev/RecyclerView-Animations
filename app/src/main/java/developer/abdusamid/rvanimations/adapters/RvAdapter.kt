package developer.abdusamid.rvanimations.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import developer.abdusamid.rvanimations.MainActivity
import developer.abdusamid.rvanimations.R
import developer.abdusamid.rvanimations.models.User
import kotlinx.android.synthetic.main.item_rv.view.*

class RvAdapter(val context: Context, var rvClick: MainActivity, var list: List<User>) :
    RecyclerView.Adapter<RvAdapter.VH>() {
    inner class VH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(user: User) {
            val animation = AnimationUtils.loadAnimation(context, R.anim.my_animation)
            itemView.startAnimation(animation)
            itemView.item_textview.text = user.name
            Picasso.get().load(user.imageLink).into(itemView.item_image)
            itemView.setOnClickListener {
                rvClick.onClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.item_rv, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    interface RvClick {
        fun onClick(user: User)
    }
}