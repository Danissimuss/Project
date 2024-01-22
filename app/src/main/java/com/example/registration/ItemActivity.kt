package com.example.registration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()


        items.add(Item(1,"house", "ffff", "Сдаются щикарные апартаменты в городе Батуми в апарт-отеле Орби Резиденс на первой линии с прекрасным видом на море. В апартаментах есть все для комфортного проживания: кондиционер, холодильник, утюг,микровалновая печ и тд.", "Квартира", 100000))
        items.add(Item(2,"home", "fff", "fff", "Дом балдеж", 5000000))
        items.add(Item(3,"garage", "fff", "fff","fff", 200000))

        itemsList.layoutManager = LinearLayoutManager (this)
        itemsList.adapter = ItemsAdapter(items,this)
    }
}