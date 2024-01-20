package com.route.routecontactsapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView

 class ContactsRecyclerAdapter (val contacts:List<Contact>) // val mean new variable (object)
    :RecyclerView.Adapter<ContactsRecyclerAdapter.MyViewHolder>() {
     // no val before itemView because parent class have public variable named itemView
     class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
         //generic fun in generic class
         val image: ImageView = itemView.findViewById(R.id.imv_contact_item)
         val name: TextView = itemView.findViewById(R.id.tv_contact_item_name)
         val phone: TextView = itemView.findViewById(R.id.tv_contact_item_Phone)
     fun bind(contact: Contact){
         image.setImageResource(R.drawable.profile)
         name.text = contact?.name
         phone.text = contact?.phone
     }
     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
         // any activity has life cycle
         // adapter doesn't have context
         // activity , fragments extends class context
         // need context to know life cycle
         // Rv extends ViewGroup extends View
         // ViewGroup is RV
         // View doesn't extends context
         // parent is RV parent.context
         // return type of inflate is view
         // attach root ? we will attach or Adapter
         // itemView is item_contact
         // holder is constrain layout of item view
         val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
         return MyViewHolder(itemView)
     }

     override fun getItemCount(): Int {
         return contacts?.size ?:0
     }
     // binding is  attach dtata with views
     override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
         val contact = contacts.get(position)
         holder.bind(contact)
         if (onContactClickListener!=null){
             holder.itemView.setOnClickListener{
                 onContactClickListener?.onContactClick(contact,position)

             }
         }
     }
     // refrence nullable (name :type) from interface مندوب
     var onContactClickListener:OnContactClickListener?=null
     fun interface OnContactClickListener {
         fun onContactClick(contact: Contact ,position: Int)

     }
 }