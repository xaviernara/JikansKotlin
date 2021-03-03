package com.example.jikanskotlin.remote

import com.example.jikanskotlin.adaptor.JikanService
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitInstance @Inject constructor(private val retrofit: Retrofit) {

    /*
        Identifies injectable constructors, methods, and fields.
        May apply to static as well as instance members.
        An injectable member may have any access modifier (private, package-private, protected, public).
        Constructors are injected first, followed by fields, and then methods.
        Fields and methods in superclasses are injected before those in subclasses.
        Ordering of injection among fields and among methods in the same class is not specified.
        Injectable constructors are annotated with @Inject and accept zero or more dependencies as arguments.
        @Inject can apply to at most one constructor per class.
     */






    val jikanService: JikanService by lazy { retrofit.create(JikanService::class.java) }

}