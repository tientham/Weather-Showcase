package com.tientham.weather.data.mapper

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-16.
 */
interface Mapper<I, O> {
    fun map(input: I): O
}