package com.example.mvp.data.entity

data class BooksEntity(
    var Items: ArrayList<ItemsData>?
)

data class ItemsData(
    var Item:ItemData?
)

data class ItemData(
    //商品タイトル
    var title: String ="",
    //値段
    var itemPrice: String ="",
    //画像URL
    var largeImageUrl: String ="",
)
