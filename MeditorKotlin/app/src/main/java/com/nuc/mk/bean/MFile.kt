package com.nuc.mk.bean

import java.util.*

/**
 * Markdown文件类型
 * */
class MFile {
    var title: String = ""
    var path: String = ""
    var date: Date = Date()
    var size: Long = 0
    var isFolder: Boolean = false

    override fun toString(): String {
        return "MFile(title='$title', path='$path', date=$date, size=$size, isFolder=$isFolder)"
    }


}