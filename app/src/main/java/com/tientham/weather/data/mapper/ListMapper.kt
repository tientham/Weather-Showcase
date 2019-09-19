package com.tientham.weather.data.mapper

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-16.
 */
interface ListMapper<I, O>: Mapper<List<I>, List<O>>

class ListMapperImpl<I, O>(
    private val mapper: Mapper<I, O>
) : ListMapper<I, O> {
    override fun map(input: List<I>): List<O> {
        return input.map { mapper.map(it) }
    }
}