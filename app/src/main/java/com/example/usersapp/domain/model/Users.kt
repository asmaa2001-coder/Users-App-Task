package com.example.usersapp.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class Users(
    @PrimaryKey
    @SerializedName("id")
    @ColumnInfo(name = "id")
    val id: Int ,
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String ,
    @ColumnInfo(name = "username")
    @SerializedName("username")
    val username: String ,
    @ColumnInfo(name = "email")
    @SerializedName("email")
    val email: String ,
    @ColumnInfo(name = "address")
    @SerializedName("address")
    val address: Address ,
    @ColumnInfo(name = "phone")
    @SerializedName("phone")
    val phone: String ,
    @ColumnInfo(name = "website")
    @SerializedName("website")
    val website: String ,
    @ColumnInfo(name = "company")
    @SerializedName("company")
    val company: Company ,
    @ColumnInfo(name = "liked")
    val liked: Boolean = false
)

data class Address(
    //  @ColumnInfo(name = "street")
    val street: String ,
    //  @ColumnInfo(name = "suite")
    val suits: String ,
    //  @ColumnInfo(name = "city")
    val city: String ,
    //  @ColumnInfo(name = "zipcode")
    val zipcode: String ,
    //  @ColumnInfo(name = "geo")
    val geo: Geo
)

data class Geo(
    // @ColumnInfo(name = "lat")
    val lat: String ,
    //   @ColumnInfo(name = "lng")
    val lng: String
)

data class Company(
    //  @ColumnInfo(name = "name")
    val name: String ,
    // @ColumnInfo(name = "catchPhrase")
    val catchPhrase: String ,
    //  @ColumnInfo(name = "bs")
    val bs: String
)
