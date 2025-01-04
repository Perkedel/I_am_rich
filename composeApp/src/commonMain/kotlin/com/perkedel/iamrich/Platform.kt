package com.perkedel.iamrich

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform