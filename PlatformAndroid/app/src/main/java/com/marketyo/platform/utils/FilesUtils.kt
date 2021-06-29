package com.marketyo.platform.utils

import java.io.File

/**
 * CreatedBy mbh on 10/11/18.
 */
object FilesUtils {
    /**
     * Deletes a directory tree recursively.
     */
    fun deleteDirectoryTree(fileOrDirectory: File) {
        try {
            if (fileOrDirectory.isDirectory) {
                for (child in fileOrDirectory.listFiles()) {
                    deleteDirectoryTree(child)
                }
            }
            fileOrDirectory.delete()
        } catch (e: Exception) {
        }
    }
}