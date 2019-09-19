package com.tientham.weather.data.mapper

/**
 * Created by tientham (tien.tominh@gmail.com) on 2019-09-16.
 */
interface NullableOutputListMapper<I, O>: Mapper<List<I>, List<O>?>

class NullableOutputListMapperImpl<I, O>(
    private val mapper: Mapper<I, O>
) : NullableOutputListMapper<I, O> {
    override fun map(input: List<I>): List<O>? {
        return if (input.isEmpty()) null else input.map { mapper.map(it) }
    }
}