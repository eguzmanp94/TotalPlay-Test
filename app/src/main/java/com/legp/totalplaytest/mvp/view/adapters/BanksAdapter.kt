package com.legp.totalplaytest.mvp.view.adapters

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.legp.totalplaytest.R
import com.legp.totalplaytest.databinding.ActivityLoginBinding
import com.legp.totalplaytest.databinding.ItemBancoBinding
import com.legp.totalplaytest.mvp.model.response.BankModel
import com.legp.totalplaytest.utils.inflate
import com.legp.totalplaytest.utils.loadGlideString

class BanksAdapter(val context: Context, val lst: ArrayList<BankModel>) :
    RecyclerView.Adapter<BanksAdapter.BankViewHolder>() {

    private lateinit var binding: ItemBancoBinding

    override fun getItemCount() = lst.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankViewHolder {
        binding = ItemBancoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BankViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BankViewHolder, position: Int) {
        holder.bind(lst[position],context)
    }

    class BankViewHolder(var binding: ItemBancoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemBank: BankModel, context: Context) {

            var arrText = itemBank.reference.split("Ref").toMutableList()
            if(arrText.size>1)
                arrText[1] = "Ref ${arrText[1]}"
            val stringHtml = arrText.joinToString("<br>")
            binding.tvReferencia.text = Html.fromHtml(stringHtml)

            if (itemBank.images != null && itemBank.images.size > 0) {
                val urlImage = itemBank.images.find { x -> !x.url3X3.isNullOrEmpty() }!!.url3X3
                if (!urlImage.isNullOrEmpty())
                    binding.ivBank.loadGlideString(urlImage)
            }else{
                binding.ivBank.setImageDrawable(context.getDrawable(R.drawable.spei)  )
            }

        }
    }


}