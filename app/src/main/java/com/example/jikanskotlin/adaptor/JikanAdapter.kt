package com.example.jikanskotlin.adaptor

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.jikanskotlin.databinding.JikanRecyclerBinding
import com.example.jikanskotlin.model.JikanResponse
import com.github.twocoffeesoneteam.glidetovectoryou.GlideToVectorYou

class JikanAdapter(private val jikanResponseList: List<JikanResponse>, private val jikanClickListener: JikanClickListener) :
    RecyclerView.Adapter<JikanAdapter.JikanViewHolder>() {

   lateinit var binding: JikanRecyclerBinding



    /**
     * Called when RecyclerView needs a new [ViewHolder] of the given type to represent
     * an item.
     *
     *
     * This new ViewHolder should be constructed with a new View that can represent the items
     * of the given type. You can either create a new View manually or inflate it from an XML
     * layout file.
     *
     *
     * The new ViewHolder will be used to display items of the adapter using
     * [.onBindViewHolder]. Since it will be re-used to display
     * different items in the data set, it is a good idea to cache references to sub views of
     * the View to avoid unnecessary [View.findViewById] calls.
     *
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     * an adapter position.
     * @param viewType The view type of the new View.
     *
     * @return A new ViewHolder that holds a View of the given view type.
     * @see .getItemViewType
     * @see .onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JikanAdapter.JikanViewHolder {
        binding = JikanRecyclerBinding.inflate(LayoutInflater.from(parent.context))
        return JikanViewHolder(binding,jikanClickListener)
    }


    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    override fun getItemCount(): Int {
        return jikanResponseList.size
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder.itemView] to reflect the item at the given
     * position.
     *
     *
     * Note that unlike [android.widget.ListView], RecyclerView will not call this method
     * again if the position of the item changes in the data set unless the item itself is
     * invalidated or the new position cannot be determined. For this reason, you should only
     * use the `position` parameter while acquiring the related data item inside
     * this method and should not keep a copy of it. If you need the position of an item later
     * on (e.g. in a click listener), use [ViewHolder.getAdapterPosition] which will
     * have the updated adapter position.
     *
     * Override [.onBindViewHolder] instead if Adapter can
     * handle efficient partial bind.
     *
     * @param holder The ViewHolder which should be updated to represent the contents of the
     * item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    override fun onBindViewHolder(holder: JikanAdapter.JikanViewHolder, position: Int) {

       /* holder.setAiringText(jikanResponseList[position].results[position].airing)
        holder.setEndDateText(jikanResponseList[position].results[position].end_date)
        holder.setEpisodeText(jikanResponseList[position].results[position].episodes)*/
        holder.setImageUrlText(jikanResponseList[position].results[position].image_url)
        //holder.setRatingText(jikanResponseList[position].results[position].rated)
        holder.setScoreText(jikanResponseList[position].results[position].score)
        /*holder.setStartDateText(jikanResponseList[position].results[position].start_date)
        holder.setTitleText(jikanResponseList[position].results[position].title)
        holder.setUrlText(jikanResponseList[position].results[position].url)
        holder.setSynposisText(jikanResponseList[position].results[position].synopsis)*/
        holder.initOnClicks(jikanResponseList[position])


    }



    //Jikan Viewholder class
    class JikanViewHolder(private val binding: JikanRecyclerBinding, private val jikanClickListener: JikanClickListener) :
    RecyclerView.ViewHolder(binding.root)
    {

       /* fun setSynposisText(synposis: String){

            binding.synopsisText.text = synposis
        }

        fun setEpisodeText(episodes: Int){

            binding.episodesText.text = episodes.toString()
        }

        fun setRatingText(rating: String){

            binding.ratingText.text = rating
        }
*/
        fun setScoreText(score: Double){

            binding.scoreText.text = score.toString()
        }

        /*fun setEndDateText(endDate: String){
            binding.endDateText.text = endDate
        }

        fun setStartDateText(startDate: String){
            binding.startDateText.text = startDate
        }

        fun setAiringText(airing: Boolean){
            binding.airingText.text = airing.toString()
        }

        fun setTitleText(title: String){
            binding.titleText.text = title
        }
*//*
        fun setUrlText(url: String){
            binding.urlText.text = url
        }*/

        fun setImageUrlText(imageUrl: String){
           //GlideToVectorYou.justLoadImage(binding.root.context as Activity?,imageUrl as Uri,binding.animeImage)
            GlideToVectorYou.justLoadImage(binding.root.context as Activity, Uri.parse(imageUrl),binding.animeImage)
        }


        fun initOnClicks(jikanResponse: JikanResponse){

            Toast.makeText(binding.root.context,"clicked",Toast.LENGTH_SHORT).show()

            binding.root.setOnClickListener(){
                jikanClickListener.onClickListener(jikanResponse)
            }
           /* binding.urlText.setOnClickListener(){
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(binding.urlText.text as String?)
                startActivity(intent)

            }*/
        }





    }






}