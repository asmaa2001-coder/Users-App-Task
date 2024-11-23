package com.example.usersapp.network

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.usersapp.domain.model.Address
import com.example.usersapp.domain.model.Company
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
@ProvidedTypeConverter
class Converter {
    private val gson = Gson()

    @TypeConverter
    fun fromAddress(address: Address): String {
        return gson.toJson(address)
    }

    @TypeConverter
    fun toAddress(addressString: String): Address {
        val type = object : TypeToken<Address>() {}.type
        return gson.fromJson(addressString, type)
    }

    @TypeConverter
    fun fromCompany(company: Company): String {
        return gson.toJson(company)
    }

    @TypeConverter
    fun toCompany(companyString: String): Company {
        val type = object : TypeToken<Company>() {}.type
        return gson.fromJson(companyString, type)
    }
}