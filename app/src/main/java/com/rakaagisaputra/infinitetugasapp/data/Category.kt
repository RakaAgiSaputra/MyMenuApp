package com.rakaagisaputra.infinitetugasapp.data

// TODO: Membuat struktur data untuk menyimpan informasi tentang kategori makanan.
data class Category(val idCategory: String,
    val strCategory: String,
    val strCategoryThumb: String,
    val strCategoryDescription: String)


// TODO: respons dari API yang berisi daftar kategori makanan.
//  Properti categories adalah daftar (List) objek Category.
//  Parsing json to Gson
data class CategoryResponse(val categories: List<Category>)


// Struktur API
//"categories": [
//{
//    "idCategory": "1",
//    "strCategory": "Beef",
//    "strCategoryThumb": "https://www.themealdb.com/images/category/beef.png",
//    "strCategoryDescription": "Beef is the culinary name for meat from cattle, particularly skeletal muscle. Humans have been eating beef since prehistoric times.[1] Beef is a source of high-quality protein and essential nutrients.[2]"
//},]