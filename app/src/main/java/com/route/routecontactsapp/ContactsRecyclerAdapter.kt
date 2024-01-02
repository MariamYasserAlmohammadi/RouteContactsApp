package com.route.routecontactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

 class ContactsRecyclerAdapter (val contacts:List<Contact>)
    :RecyclerView.Adapter<ContactsRecyclerAdapter.MyViewHolder>() {
     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         val image: ImageView = itemView.findViewById(R.id.imv_contact_item)
         val name: TextView = itemView.findViewById(R.id.tv_contact_item_name)
         val phone: TextView = itemView.findViewById(R.id.tv_contact_item_Phone)
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

         val itemView =
             LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
         return MyViewHolder(itemView)
     }

     override fun getItemCount(): Int {
         return contacts?.size ?: 0
     }

     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         val contact = contacts.get(position)
         holder.image.setImageResource(R.drawable.profile)
         holder.name.text = contact?.name
         holder.phone.text = contact?.phone
         if (onContactClickListener!=null){
             holder.itemView.setOnClickListener{
                 onContactClickListener?.onContactClick(contact)

             }
         }
     }


     var onContactClickListener:OnContactClickListener?=null
     fun interface OnContactClickListener {
         fun onContactClick(contact: Contact)

     }
 }